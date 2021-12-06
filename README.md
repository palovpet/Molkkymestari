## Mölkkymestari

Mölkkymestarin avulla voidaan pitää kirjaa mölkkyturnauksen etenemisestä. Mölkkymestariin kirjataan heittojen pisteet yksilöittäin. Kun voittava pisteraja on saavutettu, Mölkkymestari ilmoittaa voittajan.

### Dokumentaatio

Alustava määrittelydokumentti: [vaatimusmäärittely](https://github.com/palovpet/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)

Alustava arkkitehtuurikuvaus: [arkkitehtuuri](https://github.com/palovpet/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)

[Tuntikirjanpito](https://github.com/palovpet/ot-harjoitustyo/blob/master/dokumentaatio/tuntikirjanpito.md)

## Sovelluksen käynnistäminen ja toiminta
Ladattuasi [releasen](https://github.com/palovpet/ot-harjoitustyo/releases/tag/viikko5) githubista (lähdekoodi ja .jar -tiedosto) siirry komentorivillä kansioon, johon .jar-loppuinen kansio tallentui (todennäköisesti Downloads-kansio). 

Suorita komentorivillä komento:  
```
java -jar Molkkymestari-1.0-SNAPSHOT.jar
```

Ohjelma pyytää ensin syöttämään pelaajat. Anna vähintään yhden pelaajan nimi, tämän jälkeen napsauta Aloiota peli -painiketta.

Avautuvassa näkymässä voit valita, pelataanko mölkkyä viiteenkymmeneen vai kolmeenkymmeneen pisteesen, sekä puolitetaanko vai nollataanko pelaajan pisteet jos hän ylittää pisterajan. Valinnat tehdään napsauttamalla painikkeita, jolloin asetukset vaihtuvat. Kun olet valinnut mieleisesti asetukset, napsauta Aloita peli -painiketta.

Pelinäkymässä näkyy ylhäällä heittovurossa olevan pelaajan nimi ja hänen silloinen pistesldonsa. Keskivaiheilla olevaan kenttään syötetään heittopisteet numeroina 0-12 väliltä. Pisteet jotka eivät ole 0-12 välillä eivät kirjaudu. Näkymässä näkyy myös seuraavana heittovuorossa olevan pelaajan nimi. Kirjaa-painikkeen painaminen tallentaa pisteet heittovuorossa olevalle pelaajalle ja päivittää pelivuoron seuraavalle. Hutiheitto kirjataan nollana. Mikäli pelaaja heittää kolme hutia peräkkäin, hän tippuu pelistä. Riippuen tehdyistä asetuksista, pistetavoitteen ylittäminen aiheuttaa pistesaldon puolittamisen tai nollaamisen. Kun joku pelaaja heittää pistemäärän, jolla hän saavuttaa tarkalleen pisterajan peli päättyy. Aukavassa näkymässä näkyy voittavan pelaajan nimi ja muiden pelaajien pisteet. Pelistä tippuneiden pisteitä ei näytetä.

Peli suljetaan ikkunan raksista.

## Testien ajaminen

Siirry komentorivillä kansioon ot-harjoitustyö-viikko5/Molkkymestari ja suorita komento: 
```
mvn test
```

testikattavuusraportin voi luoda samassa kansiossa komennolla: 
```
mvn test jacoco:report
```

Checkstyle raportin voi luoda komentoriviltä komennolla:
```

mvn jxr:jxr checkstyle:checkstyle
```

