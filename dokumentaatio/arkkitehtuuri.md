# Arkkitehtuurikuvaus

## Rakenne

Ohjelma sisältää kaksi pakkausta, jatkanshakki.ui joka sisältää käyttöliittymän, sekä jatkanshakki.domain joka sisältää 
sovelluslogiikan. Käyttöliittymä on suhteellisen yksinkertainen ja se on toteutettu vain yhdessä luokassa. Käyttöliittymä 
kutsuu sovelluslogiikan puolelta Game olion metodeja sen mukaan mitä käyttäjät tekevät, ja muokkaa käyttöliittymää reaaliajassa 
aina sen mukaisesti.

### Käyttöliittymä

<img src="https://raw.githubusercontent.com/miskapohjanrinne/ot-harjoitustyo/master/dokumentaatio/kuvat/kayttoliittyma.png">

[Käyttöliittymä](https://github.com/miskapohjanrinne/ot-harjoitustyo/blob/master/Jatkanshakki/src/main/java/jatkanshakki/ui/UI.java) on suhteellisen yksinkertainen graafinen käyttöliittymä, joka koostuu pelilaudasta sekä yläpuolella olevasta juontajasta, joka ilmoittaa kumman pelaajan vuoro on sekä kumpi pelaaja lopulta voitti. Peliä ei voi enää jatkaa sen jälkeen kun toinen pelaaja on voittanut.

Käyttöliittymän toiminnallisuus perustuu siihen, että jokaiselle ruudulle eli napille on annettu tietynlainen toimivuus tietyissä olosuhteissa. Siis jos ruutu on vapaa, pelaaja voi asettaa siihen merkkinsä, ja jos ei ole niin mitään ei tapahdu ja pelaajan on valittava toinen ruutu. Jos toinen pelaajista on jo voittanut, napeista ei tapahdu enää mitään.

## Sovelluslogiikka

Sovelluslogiikka koostuu luokista Game, Board ja Space, jotka kuvaavat pelin toimintoja, pelilautaa sekä yksittäistä ruutua.

<img src="https://raw.githubusercontent.com/miskapohjanrinne/ot-harjoitustyo/master/dokumentaatio/kuvat/luokkakaavio.png" height=200>

[Game](https://github.com/miskapohjanrinne/ot-harjoitustyo/blob/master/Jatkanshakki/src/main/java/jatkanshakki/domain/Game.java) luokalla siis hoidetaan vuorojen vaihto, ruutujen merkkaaminen, sekä voiton tarkastaminen. Voiton tarkastimen kutsutaan käyttöliittymältä joka vuoron lopuksi (sekä joka kerta ennen merkin asettamista ruutuun, jotta ruuduilla ei ole enää toiminnallisuutta toisen pelaajan voitettua).

[Board](https://github.com/miskapohjanrinne/ot-harjoitustyo/blob/master/Jatkanshakki/src/main/java/jatkanshakki/domain/Board.java) luokka luo aluksi pelilaudan, eli 15x15 ruudukon Space olioita. Lisäksi luokalla on metodi, joka tarkistaa voiko haluttuihin koordinaatteihin asettaa merkin, sekä metodi joka tarkistaa onko valittu ruutu jo käytetty.

[Space](https://github.com/miskapohjanrinne/ot-harjoitustyo/blob/master/Jatkanshakki/src/main/java/jatkanshakki/domain/Space.java) luokka kuvaa yksittäistä peliruutua, joka saa luomishetkellä tietyt X- ja Y-koordinaatit, sekä sille voi myöhemmin kerran asettaa arvon O tai X. Arvon asettamisen jälkeen Space olion *boolean used* saa arvoksi *true*, jolloin sen arvoa ei voi enää muuttaa.

### Tiedossa olevat ongelmatilanteet tai bugit

Siinä tapauksessa, että pelaajat täyttävät kaikki ruudut eikä kumpikaan voita, mitään ei oikeastaan enää tapahdu. Sovellus on vain sammutettava ja käynnistettävä uudelleen manuaalisesti. Jos tätä asiaa olisi tullut miettineeksi aikaisemmin, tämä olisi ollut helposti korjattavissa lisäämällä metodi asian tarkastamiseksi.
