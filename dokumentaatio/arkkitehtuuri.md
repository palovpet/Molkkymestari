# Arkkitehtuurikuvaus
## Rakenne

Ohjelma on jaettu itsenäisiin kerroksiin, jotka ovat vuorovaikutuksessa toistensa kanssa. 

<img src="https://github.com/palovpet/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/pakkauskaavio.png" width="200">

Pakkaus molkkymestari.ui on sovelluksen käyttöliittymäkerros, se sisältää JavaFX:llä toteutetun käyttöliittymän. Sovelluslogiikka ja JavaFX:n käynnistämiseen tarvittava Main-luokka ovat pakkauksessa molkkymestari.logic. Sovelluslogiikan käyttämät toimintoja, kuten peliä ja pelaajia kuvaavat luokat ovat molkkymestari.domain -pakkauksessa.

## Käyttöliittymä
Käyttöliittymässä on viisi erillistä Scene-oliona toteutettua näkymää:
- Alkunäyttö
- Pelaajien lisääminen
- Peliasetusten valinta
- Pelinäkymä
- Voittaja ja pistetaulukko

Jokainen näkymä on yksi kerrallaan sovelluksen Stageen sijoitettuna, eli näkyvissä. Käyttöliittymän toteutus on luokassa molkkymestari.ui.Molkkyapplication. Toteutettu käyttöliittymä on eristetty sovelluslogiikasta, käyttöliittymä kutsuu sovelluslogiikan luokkia MölkkyService-luokasta luodun MölkkyService-olion metodien kautta.

## Sovelluslogiikka
Sovelluslogiikan data-elementtejä ovat MolkkyService-luokka joka vastaa viestin välittämisestä graafisen käyttöliittymän ja sovelluslogiikan välillä, sekä domain-pakkauksen luokat Game, PlayerList ja Player.

Player-luokan oliot edustavat yksittäistä pelaajaa. Luokassa on olennaiset toiminnot pelaajan tietojen hallintaa ja tarkastelua varten. PlayerList-luokan olio vastaa yhteen peliin osallistuvasta joukosta pelaajia, ja se tarjoaa medodit pelaajajoukon hallintaa ja tietojen käsittelyä varten. Game-luokan olio vastaa yksittäisen pelin asetuksista, sekä pelin kulkuun liittyvistä toiminnoista. Yksittäisene Game-olioon linkittyy aina yksittäinen PlayerList-olio, johon taas voi linkittyä 0-10 Player-oliota. 

Peliin ja pelaajiin liittyvät toiminnot tehdään kaikki MolkkyService-luokan olion kautta. Tämän luokan tärkeimmät metodit ovat:
- Pisterajan asettaminen (30 tai 50) ja lukeminen
- Asetuksen mikä toiminto pelaajan pisteille tehdään, mikäli hän heitollaan ylittää pisterajan valinta (pelaajan pisteet nollataan tai puolitetaan), sekä asetuksen lukeminen
- Uuden pelaajan lisääminen
- Pelivuorossa ja seuraavana pelivuorossa olevan pelaajan lukeminen
- Heiton kirjaaminen

### Luokkakaavio
<img src="https://github.com/palovpet/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/luokkakaavio.png" width="1000">

## Päätoiminnallisuuksia sekvenssikaavioina
### Uuden pelaajan lisääminen
Käyttäjä kirjoittaa pelaajan nimen tai nimimerkin kenttään ja painaa Tallenna pelaaja -painiketta. Painikkeen painamiseen reagoiva tapahtumankäsittelijä tarkistaa, että annettu nimi on haluttua muotoa, ja ettei samaa nimeä ole jo lisätty kyseiseen peliin. Mikäli virheellinen syöte havaitaan, käyttäjälle näytetään virheviesti. Oikean muotoinen nimi luo uuden Player-olion, joka tallennetaan PlayerList -olioon, joka on kyseistä peliä kuvaavan Game-olion muuttuja. Game-olio taasen on sovelluslogiikasta vastaavan MolkkyService-luokan muuttuja. 

<img src="https://github.com/palovpet/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/addPlayer.png" width="1000">

### Peliasetusten muuttaminen ja tarkastelu
Valitut peliasetukset näytetään käyttäjälle graafisen käyttöliittymän painikkeiden teksteissä, se asetus joka on aktiivisena, on se joka painikkeessa lukee. Asetuksia vaihdetaan napsauttamalla painikkeita, jolloin asetusten toinen vaihtoehto tulee aktiiviseksi. Painikkeen napsauttaminen vie metodeilla viestin peliasetusten muutoksesta MolkkyService-olion kautta Game-oliolle, päivittäen sen muuttujia. 

<img src="https://github.com/palovpet/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/gameSettings.png" width="1000">

### Heiton kirjaaminen
Heiton kirjaamiseen liittyy useita erilaisia vaiheita ja tarkastuksia sovelluksen eri tasoilla. Käyttäjä kirjaa tekstikenttään heitosta saatavat pisteet ja napsauttaa Kirjaa-painiketta. Tässä vaiheessa tarkistetaan, että onhan peliin lisätty pelaajia, ja onhan syöte oikean muotoinen (eli numero väliltä 0 - 12). Pelaajien puuttumisesta tai virheellisestä syötteestä käyttäjälle näytetään virheviesti. Mikäli syöte on oikean muotoinen ja ainakin yksi pelaaja on lisätty, graafinen käyttöliittymä kutsuu MolkkyService-oliota kirjaamaan heiton pisteet documentThrow-metodilla. Metodi tarkistaa pelin asetuksia Game-oliolta (esim. pisteraja), sekä pelaajaan liittyviä tietoja (esim. hutien määrä) ja toteuttaa heiton kirjauksen näitä tietoja käyttäen. Kun heitto on kirjattu Game-olio päivittää heittovuorossa ja seuraavana heittovuorossa olevan pelaajan tiedot updateWhosTurn-metodilla, nämä tiedot päivitetään graafiseen käyttöliittymään ja näytetään käyttäjälle. 

<img src="https://github.com/palovpet/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/documentThrow.png" width="1000">

## Ohjelman rakenteeseen jääneet heikkoudet
Ohjelman graafinen käyttäliittymä eli luokka MolkkyApplication käyttää hyväkseen ulkoista kirjastoa emojeista (https://github.com/vdurmont/emoji-java). Vaikka riippuvuus on lisätty oikeaoppisesti, ja paketin tarjoama luokka toimii ohjelmassa oikein, Netbeans näyttää luokan import komennon kohdalla virheviestiä. Koska kyseinen virhe ei näy ohjelmaa suorittaessa mitenkään, jätetty virhe huomiotta.
