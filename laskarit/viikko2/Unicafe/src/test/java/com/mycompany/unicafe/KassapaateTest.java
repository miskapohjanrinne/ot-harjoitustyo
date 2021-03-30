/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.unicafe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Miska
 */
public class KassapaateTest {

    Kassapaate kassa;

    @Before
    public void setUp() {
        kassa = new Kassapaate();
    }

    @Test
    public void alussaRahaOikeinJaLounaatNollassa() {
        assertEquals(100000, kassa.kassassaRahaa());
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }

    @Test
    public void kateisostoToimiiKunEiRahaa() {
        assertEquals(239, kassa.syoEdullisesti(239));
        assertEquals(239, kassa.syoMaukkaasti(239));
        assertEquals(100000, kassa.kassassaRahaa());
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }

    @Test
    public void kateisostoToimiiKunOnRahaa() {
        assertEquals(10, kassa.syoEdullisesti(250));
        assertEquals(100240, kassa.kassassaRahaa());
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
        assertEquals(50, kassa.syoMaukkaasti(450));
        assertEquals(100640, kassa.kassassaRahaa());
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void korttiOstoToimii() {
        Maksukortti kortti2 = new Maksukortti(1000);
        assertEquals(true, kassa.syoMaukkaasti(kortti2));
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
        assertEquals(true, kassa.syoEdullisesti(kortti2));
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
        assertEquals(false, kassa.syoMaukkaasti(kortti2));
        assertEquals(360, kortti2.saldo());
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void kortilleRahanLatausToimii() {
        Maksukortti kortti2 = new Maksukortti(0);
        assertEquals (0, kortti2.saldo());
        kassa.lataaRahaaKortille(kortti2, 1000);
        assertEquals(1000, kortti2.saldo());
        assertEquals(101000, kassa.kassassaRahaa());
        kassa.lataaRahaaKortille(kortti2, -100);
        assertEquals(1000, kortti2.saldo());
        assertEquals(101000, kassa.kassassaRahaa());
    }

}
