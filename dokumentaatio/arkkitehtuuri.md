# Arkkitehtuurikuvaus

## Rakenne

Ohjelma sisältää kaksi pakkausta, jatkanshakki.ui joka sisältää käyttöliittymän, sekä jatkanshakki.domain joka sisältää 
sovelluslogiikan. Käyttöliittymä on suhteellisen yksinkertainen ja se on toteutettu vain yhdessä luokassa. Käyttöliittymä 
kutsuu sovelluslogiikan puolelta Game olion metodeja sen mukaan mitä käyttäjät tekevät, ja muokkaa käyttöliittymää reaaliajassa 
aina sen mukaisesti.

### Käyttöliittymä

Käyttöliittymässä on vain yksi näkymä, joten se on toteutettu vain yhdellä Scene-oliolla. Näkymässä on 15x15 peliruudukko, ja
ruudukon yläpuolella lukee aina kumman pelaajan vuoro on. Käyttöliittymä kutsuu ainoastaan sopivilla parametreilla sovelluslogiikan
olion Game metodeja.

## Sovelluslogiikka

Sovelluslogiikka koostuu luokista Game, Board ja Space, jotka kuvaavat pelin toimintoja, pelilautaa sekä yksittäistä ruutua.

<img src="https://raw.githubusercontent.com/miskapohjanrinne/ot-harjoitustyo/master/dokumentaatio/kuvat/luokkakaavio.png" height=200>

[Game](https://github.com/miskapohjanrinne/ot-harjoitustyo/blob/master/Jatkanshakki/src/main/java/jatkanshakki/domain/Game.java) luokalla siis hoidetaan vuorojen vaihto, ruutujen merkkaaminen, sekä voiton tarkastaminen. Voiton tarkastimen kutsutaan käyttöliittymältä joka vuoron lopuksi sekä joka kerta ennen merkin asettamista ruutuun, jotta ruutuja ei voi merkata enää toisen pelaajan voitettua.

[Board](https://github.com/miskapohjanrinne/ot-harjoitustyo/blob/master/Jatkanshakki/src/main/java/jatkanshakki/domain/Board.java) luokka luo aluksi pelilaudan, eli 15x15 ruudukon Space olioita. Lisäksi luokalla on metodi, joka tarkistaa voiko haluttuihin koordinaatteihin asettaa merkin, sekä metodi joka tarkistaa onko valittu ruutu jo käytetty.

[Space](https://github.com/miskapohjanrinne/ot-harjoitustyo/blob/master/Jatkanshakki/src/main/java/jatkanshakki/domain/Space.java) luokka kuvaa yksittäistä peliruutua, joka saa luomishetkellä tietyt X- ja Y-koordinaatit, sekä sille voi myöhemmin kerran asettaa arvon O tai X. Arvon asettamisen jälkeen Space olion *boolean used* saa arvoksi *true*, jolloin sen arvoa ei voi enää muuttaa.
