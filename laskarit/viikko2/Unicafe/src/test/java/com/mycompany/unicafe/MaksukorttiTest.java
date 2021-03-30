package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti != null);
    }

    @Test
    public void kortinSaldoAlussaOikein() {
        assertEquals("saldo: 0.10", kortti.toString());
    }

    @Test
    public void rahanLataaminenKasvattaaSaldoaOikein() {
        kortti.lataaRahaa(10);
        assertEquals("saldo: 0.20", kortti.toString());
    }

    @Test
    public void saldoVaheneeOikeinJosTarpeeksiRahaa() {
        Maksukortti kortti2 = new Maksukortti(241);
        Kassapaate kassa = new Kassapaate();
        kassa.syoEdullisesti(kortti2);
        assertEquals("saldo: 0.01", kortti2.toString());
    }

    @Test
    public void saldoEiMuutuJosEiOleRahaa() {
        Maksukortti kortti2 = new Maksukortti(239);
        Kassapaate kassa = new Kassapaate();
        kassa.syoEdullisesti(kortti2);
        assertEquals("saldo: 2.39", kortti2.toString());
    }
    
    
    @Test
    public void otaRahaaEiVahennaJosEiTarpeeksi() {
        Maksukortti kortti2 = new Maksukortti(1000);
        kortti2.otaRahaa(500);
        assertEquals(500, kortti2.saldo());
        kortti2.otaRahaa(1000);
        assertEquals(500, kortti2.saldo());
    }
    

}
