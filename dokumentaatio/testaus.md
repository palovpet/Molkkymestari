# Testausdokumentti
Ohjelman testaus on toteutettu käyttäen automatisoituja yksikkö- ja integraatiotestejä JUnitilla, sekä manuaalisesti toteutettuna järjestelmätason testauksena. 

## Yksikkö- ja integraatiotestaus
Automatisoiduissa testeissä testataan sovelluslogiikan sisältävän MolkkyService-luokan toiminnallisuudet, eli toiminnot joita käyttäjä tekee graafisen käyttöliittymän kautta.
MolkkyService-luokan testit testaavat välillisesti myös muiden luokkien toimintaa, mutta lisäksi luokille Player, PlayerList ja Game on toteutettu omat automaatiotestit, joilla varmistetaan niiden toimivuus yksittäin.

## Testauskattavuus

Poislukien käyttöliittymäkerroksen, ohjelman testauksen rivikattavuus on 93% ja haaraumakattavuus 92%. Automaatiotestauksella on pyritty kattamaan kaikki ohjelman käyttämisen kannalta olennaiset toiminnallisuudet.

<img src="https://github.com/palovpet/ot-harjoitustyo/blob/master/dokumentaatio/kuvat/testauskattavuus.png" width="900">

## Järjestelmätestaus
Ohjelman järjestelmätestaus on toteutettu manuaalisesti kehittäjän toimesta, sekä sovellusta tuntemattoman testaajan toimesta. 
Järjestelmätestauksessa sovellusta on pyritty testaamaan positiivisen testauksen lisäksi negatiivisella testauksella, eli yrittäen saada ohjelma kaatumaan tai toimimaan virheellisesti. 
Ohjelmaa on testattu kehittäjän työaseman lisäksi Helsingin Yliopiston laitoksen koneella käyttäen etätyöpöytää. Järjestelmätestauksessa on käyty läpi kaikki määrittelydokumentin toiminnallisuudet.
