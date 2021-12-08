## Luokkakaavio

<img src="https://github.com/palovpet/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/luokkakaavio.png" width="800">

## Rakenne

Ohjelma on jaettu itsenäisiin kerroksiin, jotka ovat vuorovaikutuksessa toistensa kanssa. 

<img src="https://github.com/palovpet/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/pakkauskaavio.png" width="200">

Pakkaus molkkymestari.ui on sovelluksen käyttöliittymäkerros, se sisältää JavaFX:llä toteutetun käyttöliittymän. Sovelluslogiikka ja JavFaX:n käynnistämiseen tarvittavat Main ja Paaohjelma -luokat ovat pakkauksessa molkkymestari.logic. Sovelluslogiikan käyttämät toimintoja, kuten peliä ja pelaajia kuvaavat luokat ovat molkkymestari.domain -pakkauksessa.

## Sekvenssikaavio
Tässä sekvenssikaaviossa kuvataan hutiheitossa tapahtuvat toiminnot
<img src="https://github.com/palovpet/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/sekvenssikaavio.png" width="1000">
