# Arkkitehtuurikuvaus
## Rakenne

Ohjelma on jaettu itsenäisiin kerroksiin, jotka ovat vuorovaikutuksessa toistensa kanssa. 

<img src="https://github.com/palovpet/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/pakkauskaavio.png" width="200">

Pakkaus molkkymestari.ui on sovelluksen käyttöliittymäkerros, se sisältää JavaFX:llä toteutetun käyttöliittymän. Sovelluslogiikka ja JavFaX:n käynnistämiseen tarvittavat Main ja Paaohjelma -luokat ovat pakkauksessa molkkymestari.logic. Sovelluslogiikan käyttämät toimintoja, kuten peliä ja pelaajia kuvaavat luokat ovat molkkymestari.domain -pakkauksessa.

## Käyttöliittymä
Käyttöliittymässä on neljä erillistä Scene-oliona toteutettua näkymää:
- Pelaajien lisääminen
- Peliasetusten valinta
- Pelinäkymä
- Voittaja ja pistetaulukko

Jokainen näkymä on yksi kerrallaan sovelluksen Stageen sijoitettuna, eli näkyvissä. Käyttöliittymän toteutus on luokassa molkkymestari.ui.Molkkyapplication. Toteutettu käyttöliittymä on eristetty sovelluslogiikasta, käyttöliittymä kutsuu sovelluslogiikan luokkia MölkkyService-luokasta luodun MölkkyService-olion metodien kautta.

## Sovelluslogiikka
Sovelluslogiikan data-elementtejä ovat MolkkyService-luokka joka vastaa viestin välittämisestä graafisen käyttöliitytmän ja sovelluslogiikan välilä, sekä domain-pakkauksen luokat Game, PlayerList ja Player.

Player-luokan oliot edustavat yksittäistä pelaajaa. Luokassa on olennaiset toiminnot pelaajan tietojen hallintaa ja tarkastelua varten. PlayerList-luokan olio vastaa yhteen peliin osallistuvasta joukosta pelaajia, ja se tarjoaa medodit pelaajajoukon hallintaa ja tietojen käsittelyä varten. Game-luokan olio vastaa yksittäisen pelin asetuksista, sekä pelin kulkuun liittyvistä toiminnoista. Yksittäisene Game-olioon linkittyy aina yksittäinen PlayerList-olio, johon taas voi linkittyä 0-10 Player-oliota. 

Peliin ja pelaajiin liittyvät toiminnot tehdään kaikki MolkkyService-luokan olion kautta. Tämän luokan tärkeimmät metodit ovat:
- Pisterajan asettaminen (30 tai 50) ja lukeminen
- Asetuksen mikä toiminto pelaajan pisteille tehdään, mikäli hän heitollaan ylittää pisterajan (pelaajan pisteet nollataan tai puolitetaan) valinta, sekä asetuksen lukeminen
- Uuden pelaajan lisääminen
- Pelivuorossa ja seuraavana pelivuorossa olevan pelaajan lukeminen
- Heiton kirjaaminen

## Luokkakaavio

<img src="https://github.com/palovpet/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/luokkakaavio.png" width="800">

## Päätoiminnallisuuksia sekvenssikaavioina
Tässä sekvenssikaaviossa kuvataan hutiheitossa tapahtuvat toiminnot
<img src="https://github.com/palovpet/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/sekvenssikaavio.png" width="1000">
