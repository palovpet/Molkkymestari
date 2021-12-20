# Vaatimusmäärittely
## Sovelluksen tarkoitus
Mölkkymestarin avulla voidaan pitää kirjaa mölkkypelin etenemisestä. Mölkkymestariin kirjataan heittojen pisteet yksilöittäin. Kun voittava pisteraja on saavutettu, Mölkkymestari ilmoittaa voittajan ja näyttää kaikkien voiton hetkellä mukana olleiden pelaajien pisteet.

## Käyttäjät
Sovellusta voi käyttää kuka vain Mölkky-peliin osallistuva pelaaja, tai peliä seuraava kirjuri. Sovelluksessa ei ole tässä versiossa käyttäjärooleja, eikä tietojen tallennusta.

## Käyttöliittymäluonnos
Sovellus koostuu viidestä näkymästä. Avattaessa sovelluksen on alkunäkymä, josta Uusi peli -painiketta napsauttamalla siirrytään lisäämään pelaajat. Pelaajat lisätään nimiä tai nimimerkkejä käyttäen peliin. Seuraavaksi siirrytään peliasetukset-näkymään, jossa käyttäjä voi katselmoida pelin asetukset ja tehdä niihin halutessaan muutoksia. Kun asetuksiin ollaan tyytyväisiä, siirtyy käyttäjä pelinäkymään. Pelinäkymässä sovellus ohjaa käyttäjää kirjaamaan pelaajien pisteet, heittovuorot ovat siinä järjestyksessä missä pelaajat lisättiin peliin. Heittovuoroja kirjataan, kunnes joku pelaajista voittaa pelin saavuttamalla asetetun pisterajan tarkalleen. Pelinäkymästä voi myös palata alkuun luomaan uuden pelin. Kun pelin voittaja löytyy, avautuu näkymä, jossa voittajan nimi tai nimimerkki on isolla, lisäksi näytetään muiden pelissä olleiden (ei pelistä 3:n hudin vuoksi tippuneet) pisteet pelin päättyessä.

## Ensimmäiseen versioon toteutetut toiminnallisuudet
* Pelin alkuvalmistelut, pelaajien lisäys ja peliasetukset:
  * 1-10 pelaajaa voidaan kirjata  peliin nimimerkeillä.
  * Pisteraja on oletuksena 50, mutta sen voi vaihtaa olemaan 30.
  * Pisterajan ylittyessä oletuksena on, että pelaajan pisteet puolittuvat. Ne voi myös valita nollaantumaan.
  
* Pelin kulku:
  * Jokaisen pelaajan pisteet kysytään peräkkäin samassa järjestyksessä jossa pelaajat syötettiin, pistemäärä syötetään lukuna, huti nollana.
  * Kun jokin pelaaja saavuttaa sovitun pisterajan, peli päättyy.
  * Jos pelaaja ylittää sovitun pisterajan, heidän pistesaldo menee puoleen tai nollaan alun määrittelyistä riippuen.
  * Jos pelaaja saa peräkkäin kolme tyhjää, hän tippuu pelistä.
  
* Pelin päätyttyä:
  * Voittaja julistetaan.
  * Kaikilta pelissä sen päättymishetkellä mukana olleet pelaajien pisteet näytetään.
  
### Ensimmäistä versiota laajentavat jatkokehitysideat
 Ensimmäisen version jälkeen sovellusta voidaan täydentää esimerkiksi seuraavilla toiminnallisuuksilla:
 * Käyttäjä voi luoda käyttäjätunnuksen.
 * Sisäänkirjautunut käyttäjä voi palata katsomaan omaa aikaisempien pelien statistiikkaa.
 * Peliin voi lisätä käyttäjän käyttäjätunnuksen perusteella, jolloin pelin pisteet tallentuvat hänen käyttäjäprofiiliinsa.
 * Pelaajat voivat muodostaa joukkueita, ja pelata muiden pelaajien muodostamia joukkueita vastaan.
  
