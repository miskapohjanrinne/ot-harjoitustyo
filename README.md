# Jätkänshakki

Sovellus on perinteinen kahden hengen jätkänshakki eli viiden suora -peli. Peliä voi pelata paikallisesti yhdellä koneella.

## Dokumentaatio

[Tuntikirjanpito](https://github.com/miskapohjanrinne/ot-harjoitustyo/blob/master/dokumentaatio/tuntikirjanpito.md)

[Vaatimusmäärittely](https://github.com/miskapohjanrinne/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)

[Sovellusarkkitehtuuri](https://github.com/miskapohjanrinne/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)

[Testausdokumentti](https://github.com/miskapohjanrinne/ot-harjoitustyo/blob/master/dokumentaatio/testaus.md)

## Releaset

[Viikko 5](https://github.com/miskapohjanrinne/ot-harjoitustyo/releases/tag/viikko5)

[Viikko 6](https://github.com/miskapohjanrinne/ot-harjoitustyo/releases/tag/viikko6)

##  Komentorivitoiminnot

### Ohjelman suorittaminen

Komennolla

> mvn compile exec:java -Dexec.mainClass=jatkanshakki.Main

Huom! Ohjelman käynnistäminen tällä komennolla suoraan ei toimi jostain syystä, toimii kuitenkin NetBeansin kautta.

### Jarin generointi

Komennolla

> mvn package

Luotu jar-tiedosto löytyy hakemistosta _target_ nimellä _Jatkanshakki-1.0-SNAPSHOT_

Huom! Ohjelma ei jostain syystä käynnisty jarin kautta. Ohjelma käynnistyy kuitenkin NetBeansin kautta mainiosti.

### Testaus

Testit suoritetaan komennolla

> mvn test

Testikattavuusraportti luodaan komennolla

> mvn jacoco:report

Testikattavuusraportin löytää avaamalla tiedoston _target/site/jacoco/index.html_

### Checkstyle

Checkstyle tarkastuksen voi suorittaa komennolla

> mvn jxr:jxr checkstyle:checkstyle

Mahdolliset virheilmoitukset voi tarkistaa avaamalla tiedosto _target/site/checkstyle.html_

