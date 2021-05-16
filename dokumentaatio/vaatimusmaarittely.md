# Vaatimusmäärittely

## Sovelluksen tarkoitus

Sovellus on vanha kunnon jätkänshakki-peli. Kaksi pelaajaa, peliruudulla X ja O, asettavat vuorotellen laudalle
oman merkkinsä ja pyrkivät saamaan viisi omaa merkkiään peräkkäin pysty- tai vaakariviin tai vinoon. Pelin voittaa
se pelaaja kumpi tässä onnistuu ensin. Pelilaudan koko on 15x15 ruutua.

## Käyttäjät

Pelaajia on kaksi ja he pelaavat vastakkain. Peliä pelataan lokaalisesti, ja pelin aloittava pelaaja saa merkin O.

## Perusversion tarjoama toiminnallisuus

### Aloitusnäytöllä

Odotetaan että ensimmäinen pelaaja eli O aloittaa pelin valitsemalla ruudun.

### Pelin aikana

Käyttäjät valitsevat vuorotellen mihin ruutuun asettavat merkkinsä. Jos pelaaja koittaa asettaa oman merkkinsä ruutuun joka on jo varattu, vuoro ei vaihdu, vaan pysyy samalla pelaajalla kunnes hän valitsee vapaan ruudun.

### Pelin päätyttyä

Näytetään kumpi pelaaja voitti.
