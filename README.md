## Mölkkymestari

Mölkky on perinteinen Suomalainen seurapeli, joka on monille tuttu etenkin kesämökeiltä. Mölkyssä heitetään puisella kapulalla, mölkyllä, luvuilla 1-12 numeroiuja puisia "keiloja", jotka on pelin alussa aseteltu tiiviiksi ryhmäksi noin 3 metrin päähän heittäjistä. Heittäjät pyrkivät kaatamaan mölkyllä keiloja vuoron perään, mikäli kaatuu yksi keila, saatu pistemäärä on keilassa oleva numero. Mikäli kaatuu useampi, on saatu pistemäärä kaatuneiden keilojen lukumäärä. Kaatuneet keilat nostetaan siihen, mihin ne ovat heitosta kaatuneet. Kolmesta peräkkäisestä hudista pelaaja tippuu pelistä. Peli päättyy, kun ensimmäinen pelaaja saavuttaa täsmälleen sovitun pisterajan. Mikäli pisteraja ylittyy, pisteet joko puolitetaan tai nollataan peliporukasta riippuen. Mölkky on peli joka monissa porukoissa kuumentaa tunteita, omasta kokemuksestani erityisesti kirjanpidosta löytyy monesti monenlaisia mielipiteitä. Mölkkymestari on kehitetty tähän tarpeeseen. Heittopisteet on helppo kirjata, eikä kirjanpitäjää tarvitse syyttää vilpistä. 


### Dokumentaatio

[Käyttöohje](https://github.com/palovpet/ot-harjoitustyo/blob/master/dokumentaatio/kayttoohje.md)

[Vaatimusmäärittely](https://github.com/palovpet/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)

[Arkkitehtuurikuvaus](https://github.com/palovpet/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)

[Testausdokumentti](https://github.com/palovpet/ot-harjoitustyo/blob/master/dokumentaatio/testaus.md)

[Tuntikirjanpito](https://github.com/palovpet/ot-harjoitustyo/blob/master/dokumentaatio/tuntikirjanpito.md)

## Releaset

[Loppupalautus](https://github.com/palovpet/ot-harjoitustyo/releases/tag/loppupalautus)

[Viikon 6 release](https://github.com/palovpet/ot-harjoitustyo/releases/tag/viikko6)

[Viikon 5 release](https://github.com/palovpet/ot-harjoitustyo/releases/tag/viikko5)


## Sovelluksen käynnistäminen
Ladattuasi releasen githubista (lähdekoodi ja .jar -tiedosto) siirry komentorivillä kansioon, johon .jar-loppuinen kansio tallentui (todennäköisesti Downloads-kansio). 


Suorita komentorivillä komento:  
```
java -jar Molkkymestari.jar
```


## Testien ajaminen ja testauskattavuus

Testit voi ajaa komennolla: 

```
mvn test
```

 ja testikattavuusraportin luoda komennolla: 
```
mvn test jacoco:report
```
## Checkstyle ja JavaDoc

Checkstyle raportin voi luoda komentoriviltä komennolla:
```
mvn jxr:jxr checkstyle:checkstyle
```

JavaDocin voi generoida komentoriviltä komennolla:

```
mvn javadoc:javadoc
```
