## Mölkkymestari

Mölkkymestarin avulla voidaan pitää kirjaa mölkkyturnauksen etenemisestä. Mölkkymestariin kirjataan heittojen pisteet yksilöittäin. Kun voittava pisteraja on saavutettu, Mölkkymestari ilmoittaa voittajan.

### Dokumentaatio

Alustava määrittelydokumentti: [vaatimusmäärittely](https://github.com/palovpet/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md)

Alustava arkkitehtuurikuvaus: [arkkitehtuuri](https://github.com/palovpet/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)

[Tuntikirjanpito](https://github.com/palovpet/ot-harjoitustyo/blob/master/dokumentaatio/tuntikirjanpito.md)

## Sovelluksen käynnistäminen

Komentoriviltä oltaessa Molkkymestari hakemistossa komennolla: mvn compile exec:java -Dexec.mainClass=molkkymestari.logic.Main

Ohjelma pyytää ensin syöttämään pelaajat, kun pelaajia on tallennettu 1 tai enemmän, voi pelin aloittaa Aloita peli painikkeesta.

## Testien ajaminen

Komentoriviltä oltaessa Molkkymestari hakemistossa komennolla: mvn test

ja testikattavuusraportin luoda komennolla: mvn test jacoco:report

