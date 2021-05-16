# Testausdokumentti

Ohjelman sovelluslogiikan toimivuutta on testattu JUnit yksikkötesteillä. Kullekin luokalle riitti sitä vastaava testiluokka.

## Testikattavuus

Space ja Board luokkien rivi- ja haarautumakattavuudet olivat 100%. Game luokalla rivikattavuus oli 99% ja haarautumakattavuus 83%. 
Yhteensä siis sovelluslogiikan rivikattavuus oli 99% ja haarautumakattavuus 84%. Haarautumakattavuus jäi vajavaiseksi lähinnä vain 
voiton tarkistamiseen käytettävissä metodeissa, joista pienin kattavuus oli metodilla, joka tarkistaa onko voittoa tullut vinoriveillä.
Tällä metodilla rivikattavuus oli 98% ja haarautumakattavuus 79%. Käyttöliittymää tai Main luokkaa ei testattu.

<img src="https://raw.githubusercontent.com/miskapohjanrinne/ot-harjoitustyo/master/dokumentaatio/kuvat/testikattavuus.png">
