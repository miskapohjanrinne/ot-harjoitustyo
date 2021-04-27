# Jätkänshakki

Sovellus on perinteinen kahden hengen jätkänshakki eli viiden suora -peli. Peliä voi pelata paikallisesti yhdellä koneella.

## Dokumentaatio

[Tuntikirjanpito](https://github.com/miskapohjanrinne/ot-harjoitustyo/blob/master/dokumentaatio/tuntikirjanpito.md)

[Vaatimusmäärittely](https://github.com/miskapohjanrinne/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)

[Sovellusarkkitehtuuri](https://github.com/miskapohjanrinne/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)

## Releaset

[Viikko 5](https://github.com/miskapohjanrinne/ot-harjoitustyo/releases/tag/viikko5)

##  Komentorivitoiminnot

### Testaus

Testit suoritetaan komennolla

> mvn test

Testikattavuusraportti luodaan komennolla

> mvn jacoco:report

### Checkstyle

Checkstyle tarkastuksen voi suorittaa komennolla

> mvn jxr:jxr checkstyle:checkstyle

Mahdolliset virheilmoitukset voi tarkistaa avaamalla tiedosto _target/site/checkstyle.html_

