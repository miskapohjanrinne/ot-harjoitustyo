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

