# Käyttöohje
Ohjelman voi käynnistää komentoriviltä komennolla
```
java -jar Molkkymestari-1.0-SNAPSHOT.jar
```
### Pelaajien lisääminen
Syötä kenttään pelaajien nimi tai nimimerkki yksitellen, tallenna pelaaja napsauttamalla Tallenna pelaaja -painiketta. Lisätyt pelaajat tulevat näkyviin ruudun keskiosaan. Pelaajia pitää lisätä vähintään yksi, maksimi pelaajamäärä on kymmenen. Lisättyäsi haluamasi pelaajat napsauta Peliasetuksiin-painiketta.

### Peliasetukset
Tee haluamasi asetukset pian alkavaan mölkkypeliin. Pisterajaa voi vaihtaa kolmenkymmenen ja viidenkymmenen välillä napsauttamalla painiketta. Pisterajaksi jää se, joka näytöllä painikkeessa näkyy. Pisterajan ylittämisestä aiheutuva toiminto toimii vastaavalla tavalla.
Voit palata lisäämään uusia pelaajia Palaa lisäämään pelaajia -painikkeella, tai aloittaa pelin Aloita-peli painikkeella.

### Pelinäkymä
Pelinäkymässä ylhäällä logon alla näkyy pelivuorossa olevan pelaajan nimi ja pistemäärä ennen heittoa. Tämän pelaajan heitettyä mölkkyä heitosta saadut pisteet kirjataan keskellä näkymää olevaan kenttään numerona. Kenttä sallii kirjauksen numeroilla 0 - 12 välillä. 
Ohi mennyt heitto merkataan kirjaamalla kenttään 0. Mikäli pelaaja heittää kolme peräkkäistä hutia, hänet poistetaan kuluvasta pelistä. Mikäli pelaaja ylittää asetetun pisterajan, hänen pisteet
joko nollataan tai puolitetaan tehtyjen peliasetusten mukaisesti.
Heittoja kirjataan, kunnes joku pelaajista saavuttaa tarkalleen valitun pisterajan, jonka jälkeen käyttäjä viedään pelin viimeiseen näkymään.

### Pelin päättymisnäkymä
Pelin viimeisessä näkymässä isolla näkyy voittajan nimi. Voittajan alapuolella on kooste muiden pelaajien pisteistä. 
Sulje-painikkeen napsauttaminen sulkee koko sovelluksen ja ikkunan.
