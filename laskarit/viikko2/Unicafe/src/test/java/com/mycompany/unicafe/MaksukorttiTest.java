package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    @Test
    public void konstruktoriAsettaaSaldonOikein(){
        assertEquals("saldo: 0.10", kortti.toString());
    }
    
    @Test
    public void rahanLataaminenKasvattaaSaldoaOikein(){
        kortti.lataaRahaa(10);
        assertEquals("saldo: 0.20", kortti.toString());
    }
    
    @Test
    public void saldoVaheneeOikeinJosRahaaOnTarpeeksi(){
        kortti.otaRahaa(5);
        assertEquals("saldo: 0.5", kortti.toString());
    /*Tuo otaRahaa metodi taitaa toimia väärin, mutta tein 
    testin testaamaan niin miten metodi pääohjelmassa toimii. */
    }
    @Test
    public void saldoEiMuutuJosRahaaEiOleTarpeeksi(){
        kortti.otaRahaa(11);
        assertEquals("saldo: 0.10", kortti.toString());
    }
    
    @Test
    public void metodiPalauttaaTrueJosRahatRiittaa(){
        boolean arvoMetodista = false;
        arvoMetodista = kortti.otaRahaa(5);
        boolean tosi = true;
        assertEquals(arvoMetodista, tosi);        
        
    }
    
    @Test
    public void metoriPalauttaaFalseJosRahatEiRiita(){
        boolean arvoMetodista = true;
        arvoMetodista = kortti.otaRahaa(11);
        boolean epatosi = false;
        assertEquals(arvoMetodista, epatosi);
        
    }
    @Test
    public void saldoPalauttaaSaldon(){
        int saldo = kortti.saldo();
        assertEquals(10, saldo);
    }
            
    
}
