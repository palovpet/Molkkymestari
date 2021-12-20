# Käyttöohje
Ohjelman voi käynnistää komentoriviltä komennolla
```
java -jar Molkkymestari-1.0-SNAPSHOT.jar
```

Avautuvassa ikunassa napsautetaan Uusi peli -painiketta. 
### Pelaajien lisääminen
<img src="https://github.com/palovpet/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/lisaa_pelaaja2.png" width="500">

Syötä kenttään pelaajien nimi tai nimimerkki yksitellen, tallenna pelaaja napsauttamalla Tallenna pelaaja -painiketta. Nimimerkin on oltava 3-20 merkkiä pitkä, se voi sisältää kirjaimia tai numertoita. Lisätyt pelaajat tulevat näkyviin ruudun keskiosaan. Pelaajia pitää lisätä vähintään yksi, maksimi pelaajamäärä on kymmenen. Lisättyäsi haluamasi pelaajat napsauta Peliasetuksiin-painiketta. Pelivuorot ovat siinä järjestyksessä, missä pelaajat lisätään.

### Peliasetukset
<img src="https://github.com/palovpet/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/peliasetukset2.png" width="500">

Tee haluamasi asetukset pian alkavaan mölkkypeliin. Pisterajaa voi vaihtaa kolmenkymmenen ja viidenkymmenen välillä napsauttamalla painiketta. Pisterajaksi jää se, joka näytöllä painikkeessa näkyy. Pisterajan ylittämisestä aiheutuva toiminto toimii vastaavalla tavalla. Voit palata lisäämään uusia pelaajia Palaa lisäämään pelaajia -painikkeella, tai aloittaa pelin Aloita-peli painikkeella.

### Pelinäkymä
<img src="https://github.com/palovpet/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/pelinakyma2.png" width="500">

Pelinäkymässä ylhäällä logon alla näkyy pelivuorossa olevan pelaajan nimi ja pistemäärä ennen heittoa. Tämän pelaajan heitettyä mölkkyä heitosta saadut pisteet kirjataan keskellä näkymää olevaan kenttään numerona. Kenttä sallii kirjauksen numeroilla 0 - 12 välillä. Ohi mennyt heitto merkataan kirjaamalla kenttään 0. Mikäli pelaaja heittää kolme peräkkäistä hutia, hänet poistetaan kuluvasta pelistä. Mikäli pelaaja ylittää asetetun pisterajan, hänen pisteet joko nollataan tai puolitetaan tehtyjen peliasetusten mukaisesti. Heittoja kirjataan, kunnes joku pelaajista saavuttaa tarkalleen valitun pisterajan, jonka jälkeen käyttäjä viedään pelin viimeiseen näkymään. Kirjaa painikkeen alapuolella näytetään kommentteja kirjatusta heitosta, sekä seuraavaksi heittovuorossa oleva pelaaja.

### Pelin päättymisnäkymä
<img src="https://github.com/palovpet/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/pistetaulukko2.png" width="500">

Pelin viimeisessä näkymässä isolla näkyy voittajan nimi. Voittajan alapuolella on kooste muiden pelaajien pisteistä. Lopeta peli ja palaa alkuun -painikkeesta käyttäjä viedään takaisin alkunäyttöön, ja hän voi aloittaa suoraan uuden pelin. Sulje-painikkeen napsauttaminen sulkee koko sovelluksen ja ikkunan.
