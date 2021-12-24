# Käyttöohje
Ohjelman voi käynnistää komentoriviltä komennolla
```
java -jar Molkkymestari-1.0-SNAPSHOT.jar
```

Avautuvassa näkymässä napsautetaan Uusi peli -painiketta. 
### Pelaajien lisääminen
<img src="https://github.com/palovpet/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/lisaa_pelaaja_final.png" width="500">

Ohjelma pyytää ensin syöttämään pelaajat. Anna vähintään yhden pelaajan nimi, syöttämällä kenttään pelaajien nimi tai nimimerkki yksitellen, tallenna pelaaja napsauttamalla Tallenna pelaaja -painiketta. Nimimerkin on oltava 3-20 merkkiä pitkä, se voi sisältää kirjaimia tai numertoita. Lisätyt pelaajat tulevat näkyviin ruudun keskiosaan. Pelaajia pitää lisätä vähintään yksi, maksimi pelaajamäärä on kymmenen. Pelivuorot ovat siinä järjestyksessä, missä pelaajat lisätään. Lisättyäsi vähintään yhden pelaajan napsauta Peliasetuksiin-painiketta. 

### Peliasetukset
<img src="https://github.com/palovpet/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/peliasetukset_final.png" width="500">

Avautuvassa näkymässä voit valita, pelataanko mölkkyä viiteenkymmeneen vai kolmeenkymmeneen pisteesen, sekä puolitetaanko vai nollataanko pelaajan pisteet jos hän ylittää pisterajan. Valinnat tehdään napsauttamalla painikkeita, jolloin asetukset vaihtuvat. Tee haluamasi asetukset pian alkavaan mölkkypeliin ja napsauta sitten Aloita peli -painiketta. Tarvittaessa voit palata edelliseen näkymään lisäämään pelaajia Palaa lisäämään pelajia -painikkeesta. 

### Pelinäkymä
<img src="https://github.com/palovpet/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/pelinakyma_final.png" width="500">

Pelinäkymässä ylhäällä logon alla näkyy pelivuorossa olevan pelaajan nimi ja pistemäärä ennen heittoa. Tämän pelaajan heitettyä mölkkyä heitosta saadut pisteet kirjataan keskellä näkymää olevaan kenttään numerona. Kenttä sallii kirjauksen numeroilla 0 - 12 välillä. Ohi mennyt heitto merkataan kirjaamalla kenttään 0. Mikäli pelaaja heittää kolme peräkkäistä hutia, hänet poistetaan kuluvasta pelistä. Mikäli pelaaja ylittää asetetun pisterajan, hänen pisteet joko nollataan tai puolitetaan tehtyjen peliasetusten mukaisesti. Heittoja kirjataan, kunnes joku pelaajista saavuttaa tarkalleen valitun pisterajan, jonka jälkeen käyttäjä viedään pelin viimeiseen näkymään. Kirjaa painikkeen alapuolella näytetään kommentteja kirjatusta heitosta, sekä seuraavaksi heittovuorossa oleva pelaaja.

### Pelin päättymisnäkymä
<img src="https://github.com/palovpet/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/pistetaulukko_final.png" width="500">

Pelin viimeisessä näkymässä isolla näkyy voittajan nimi. Voittajan alapuolella on kooste muiden pelaajien pisteistä. Lopeta peli ja palaa alkuun -painikkeesta käyttäjä viedään takaisin alkunäyttöön, ja hän voi aloittaa suoraan uuden pelin. Sulje-painikkeen napsauttaminen sulkee koko sovelluksen ja ikkunan.
