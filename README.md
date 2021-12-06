## Mölkkymestari
Mölkyssä heitetään mölkyllä (=puinen palikka) luvuilla 1–12 numeroituja puisia "keiloja", jotka on pystytetty tiiviiksi ryhmäksi 3–4 metrin etäisyydelle heittäjästä. Heitto on suoritettava aina alakautta, muuten heittotapa on vapaa. Jos heittäjä kaataa yhden keilan, pistemäärä on sama kuin kaatuneen keilan numero. Jos keiloja kaatuu kaksi tai enemmän, pistemäärä on sama kuin kaatuneiden keilojen lukumäärä. Mikäli keila nojaa toiseen keilaan tai mölkkyyn, sen laskenta riippuu missä seurassa mölkkyä pelataan. Heiton jälkeen keilat nostetaan pystyyn sille kohdalle, johon ne ovat kaatuneet tai lentäneet. Kolmesta perättäisestä ohiheitosta kilpailija putoaa pelistä ja siirtyy yleensä kirjuriksi. Peli päättyy, kun ensimmäinen pelaaja saavuttaa täsmälleen 50 pistettä. Mikäli pistemäärä ylittää 50, pelaajan pisteet putoavat 25:een. 




Mölkky on perinteinen Suomalainen seurapeli, joka on monille tuttu etenkin kesämökeiltä. Mölkyssä heitetään puisella kapulalla, mölkyllä, luvuilla 1-12 numeroiuja puolisia "keiloja", jotka on pelin alussa aseteltu tiiviiksi ryhmäksi noin 3 metrin päähän heittäjistä. Heittäjät pyrkivät kaatamaan mölkyllä keiloja vuoron perään, mikäli kaatuu yksi keila, saatu pistemäärä on keilassa oleva numero. Mikäli kaatuu useampi, on saatu pistemäärä kaatuneiden keilojen lukumäärä. Kolmesta peräkkäisestä hudista tippuu pelistä ja peli päättyy, kun ensimmäinen pelaaja saavuttaa täsmälleen sovitun pisterajan. Mikäli pisteraja ylittyy, pisteet joko puolitetaan tai nollataan peliporukasta riippuen. Mölkky on peli joka monissa porukoissa kuumentaa tunteita, omasta kokemuksestari erityisesti kirjanpidosta löytyy monesti monenlaisia mielipiteitä. Mölkkymestari on kehitetty tähän tarpeeseen. Heittopisteet on helppo kirjata, eikä kirjanpitäjää tarvitse syyttää vilpistä. 


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

Pelinäkymässä näkyy ylhäällä heittovurossa olevan pelaajan nimi ja hänen silloinen pistesaldonsa. Keskivaiheilla olevaan kenttään syötetään heittopisteet numeroina 0-12 väliltä. Pisteet jotka eivät ole 0-12 välillä eivät kirjaudu. Näkymässä näkyy myös seuraavana heittovuorossa olevan pelaajan nimi. Kirjaa-painikkeen napsauttaminen tallentaa pisteet heittovuorossa olevalle pelaajalle ja päivittää pelivuoron seuraavalle. Hutiheitto kirjataan nollana. Mikäli pelaaja heittää kolme hutia peräkkäin, hän tippuu pelistä. Riippuen tehdyistä asetuksista, pistetavoitteen ylittäminen aiheuttaa pistesaldon puolittamisen tai nollaamisen. Kun joku pelaaja heittää pistemäärän, jolla hän saavuttaa tarkalleen pisterajan peli päättyy. Aukeavassa näkymässä näkyy voittavan pelaajan nimi ja pelaajien pisteet. Pelistä tippuneiden pisteitä ei näytetä.

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

