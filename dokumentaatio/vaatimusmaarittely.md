# Vaatimusmäärittely

# *Mölkkymestari*

## Sovelluksen tarkoitus
Mölkkymestarin avulla voidaan pitää kirjaa mölkkyturnauksen etenemisestä. Mölkkymestariin kirjataan heittojen pisteet yksilöittäin tai joukkueittain. Kun voittava pisteraja on saavutettu, Mölkkymestari ilmoittaa voittajan ja näyttää statistiikkaa pelistä. 

## Suunnitellut toiminnallisuudet
### Perusversio
* Pelin alkuvalmistelut:
  * 1-10 pelaajaa kirjataan  peliin nimimerkeillä. (OSITTAIN TEHTY, PELAAJAMÄÄRÄ RAJOITTAMATTA)
  * Pisteraja on oletuksena 50, mutta sen voi vaihtaa olemaan 30. (TEHTY!)
  * Pisterjan ylittyessä oletuksena on, että pelaajan pisteet puolittuvat. Ne voi myös valita nollaantumaan. (TEHTY!)

* Pelin kulku:
  * Jokaisen pelaajan pisteet kysytään peräkkäin samassa järjestyksessä jossa pelaajat syötettiin, pistemäärä syötetään lukuna, huti nollana. (TEHTY!)
  * Kun jokin pelaaja saavuttaa sovitun pisterajan, peli päättyy ja voittaja ilmoitetaan (TEKEMÄTTÄ)
  * Jos pelaaja ylittää sovitun pisterajan, heidän pistesaldo menee puoleen tai nollaan alun määrittelyistä riippuen (TEHTY!)
  * Jos pelaaja saa peräkkäin kolme tyhjää, hän tippuu pelistä (TEKEMÄTTÄ)

* Pelin päätyttyä:
  * Voittaja julistetaan (TEKEMÄTTÄ)
  * Kaikilta osallistuneilta pelaajilta näytetään statistiikkaa pelistä (TEKEMÄTTÄ)

### Perusversiota laajentavat jatkokehitysideat:
  * Pelaajien tiedot tallennetaan ja statistiikkaan voi palata pelin jälkeen
  * Pelaajat löydetään tietokannasta
  * Anonyymi/ei tallennettava käyttäjä pikapeliä varten, anonyymi käyttäjä ei tallenna pisteitä
  * Yksittäiset pelaajat voivat muodostaa joukkueita
  
