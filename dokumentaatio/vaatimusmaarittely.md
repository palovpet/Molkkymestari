# Vaatimusmäärittely

# *Mölkkymestari*

## Sovelluksen tarkoitus
Mölkkymestarin avulla voidaan pitää kirjaa mölkkyturnauksen etenemisestä. Mölkkymestariin kirjataan heittojen pisteet yksilöittäin tai joukkueittain. Kun voittava pisteraja on saavutettu, Mölkkymestari ilmoittaa voittajan ja näyttää statistiikkaa pelistä. 

## Suunnitellut toiminnallisuudet
### Perusversio
* Pelin alkuvalmistelut:
  * 1-10 pelaajaa kirjataan  peliin nimimerkeillä
  * Valitaan moneenko pisteeseen pelataan (50 / 30)
  * Valitaan meneekö pistesaldo pisterajan ylitettäessä puoleen väliin vai nollaan

* Pelin kulku:
  * Jokaisen pelaajan pisteet kysytään peräkkäin samassa järjestyksessä jossa pelaajat syötettiin, pistemäärä syötetään lukuna tai tyhjänä
  * Kun jokin pelaaja saavuttaa sovitun pisterajan, peli päättyy
  * Jos pelaaja ylittää sovitun pisterajan, heidän pistesaldo menee puoleen tai nollaan alun määrittelyistä riippuen
  * Jos pelaaja saa peräkkäin kolme tyhjää, hän tippuu pelistä

* Pelin päätyttyä:
  * Voittaja julistetaan
  * Kaikilta osallistuneilta pelaajilta näytetään statistiikkaa pelistä
  * Paluu alkuun

### Perusversiota laajentavat jatkokehitysideat:
  * Graafisen käyttöliittymän toteutus
  * Pelaajien tiedot tallennetaan ja statistiikkaan voi palata pelin jälkeen
  * Yksittäiset pelaajat voivat muodostaa joukkueita
  * Anonyymi/ei tallennettava käyttäjä pikapeliä varten
