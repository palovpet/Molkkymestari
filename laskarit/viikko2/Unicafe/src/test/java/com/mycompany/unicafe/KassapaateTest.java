package com.mycompany.unicafe;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author palovpet
 */
public class KassapaateTest {
         
    Kassapaate kassa;
    Maksukortti rikasKortti;
    Maksukortti koyhaKortti;
          
    @Before
    public void setUp() {
        kassa = new Kassapaate();
        rikasKortti = new Maksukortti(1000);
        koyhaKortti = new Maksukortti(100);
    }
    
    @Test
    public void konstruktoriAsettaaOikeanAlkusumman(){
        int rahaaKassassa = kassa.kassassaRahaa();
        assertEquals(100000, rahaaKassassa);
    }
    @Test
    public void luodussaKassassaOnNollaMyytyaEdullistaLounasta(){
        int myytyaEdullistaLounasta = kassa.edullisiaLounaitaMyyty();
        assertEquals(0, myytyaEdullistaLounasta);
    }
    
    @Test
    public void luodussaKassassaOnNollaMyytyaMaukastaLounasta(){
        int myytyaMaukastaLounasta = kassa.maukkaitaLounaitaMyyty();
        assertEquals(0, myytyaMaukastaLounasta);
    }
    
    @Test
    public void myytyjenEdullistenLounaidenMaaraKasvaa(){
        kassa.syoEdullisesti(240);
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void myytyjenMaukkaidenLounaidenMaaraKasvaa(){
        kassa.syoMaukkaasti(400);
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void vaihtorahaAnnetaanOikeinEdullisestaLounaasta(){        
        assertEquals(60, kassa.syoEdullisesti(300));

    }
    
    @Test
    public void vaihtorahaAnnetaanOikeinMaukkaastaLounaasta(){        
        assertEquals(100, kassa.syoMaukkaasti(500));
    }
    
    @Test
    public void rahamaaraKasvaaEdullisestaLounaasta(){
        kassa.syoEdullisesti(240);
        assertEquals(100240, kassa.kassassaRahaa());
    }
    
    @Test
    public void rahamaaraKasvaaMaukkaastaLounaasta(){
        kassa.syoMaukkaasti(400);
        assertEquals(100400, kassa.kassassaRahaa());
    }
    
    @Test
    public void josMaksuEiRiitaSaldoEiMuutuEdullinen(){
        kassa.syoEdullisesti(200);
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void josMaksuEiRiitaSaldoEiMuutuMaukas(){
        kassa.syoMaukkaasti(300);
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void josMaksuEiRiitaPalautetaanRahatEdullinen(){
        assertEquals(200, kassa.syoEdullisesti(200));
    }
    
    @Test
    public void josMaksuEiRiitaPalautetaanRahatMaukas(){
        assertEquals(300, kassa.syoMaukkaasti(300));
    }
    
    @Test 
    public void josMaksuEiRiitaMyytyjenEdullistenLounaidenMaaraEiMuutu(){
        kassa.syoEdullisesti(200);
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void josMaksuEiRiitaMyytyjenMaukkaidenLounaidenMaaraEiMuutu (){
        kassa.syoMaukkaasti(300);
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void josKortillaOnRiittavastiRahaaVeloitetaanEdullisenSumma(){
        kassa.syoEdullisesti(rikasKortti);
        assertEquals(760, rikasKortti.saldo());
        
    }
    
    @Test
    public void josKortillaOnRiittavastiRahaaVeloitetaanMaukkaanSumma(){
        kassa.syoMaukkaasti(rikasKortti);
        assertEquals(600, rikasKortti.saldo());
        
    }
    
    @Test
    public void onnistunutEdullisenOstoPalauttaaTrue(){
        assertEquals(true, kassa.syoEdullisesti(rikasKortti));
    }
    
    @Test
    public void onnistunutMaukkaanOstoPalauttaaTrue(){
        assertEquals(true, kassa.syoMaukkaasti(rikasKortti));
    }
    
    @Test
    public void onnistunutMaksuKasvattaaMyytyjaEdullisiaLounaita(){
        kassa.syoEdullisesti(rikasKortti);
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void onnistunutMaksuKasvattaaMyytyjaMaukkaitaLounaita(){
        kassa.syoMaukkaasti(rikasKortti);
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test 
    public void epaonnistunutEdullisenOstoEiMuutaKortinRahamaaraa(){
        kassa.syoEdullisesti(koyhaKortti);
        assertEquals(100, koyhaKortti.saldo());
    }
    
    @Test 
    public void epaonnistunutMaukkaanOstoEiMuutaKortinRahamaaraa(){
        kassa.syoMaukkaasti(koyhaKortti);
        assertEquals(100, koyhaKortti.saldo());
    }
    
    @Test
    public void epaonnistunutEdullisenOstoEiMuutaMyytyjenLounaidenMaaraa(){
        kassa.syoEdullisesti(koyhaKortti);
        assertEquals(0, kassa.edullisiaLounaitaMyyty());        
    }
    
    @Test
    public void epaonnistunutMaukkaanOstoEiMuutaMyytyjenLounaidenMaaraa(){
        kassa.syoMaukkaasti(koyhaKortti);
        assertEquals(0, kassa.edullisiaLounaitaMyyty());        
    }
    
    @Test
    public void epaonnistunutEdullisenOstoPalauttaaTrue(){
        assertEquals(false, kassa.syoEdullisesti(koyhaKortti));
    }
    
    @Test
    public void epaonnistunutMaukkaanOstoPalauttaaTrue(){
        assertEquals(false, kassa.syoMaukkaasti(koyhaKortti));
    }
    
    @Test
    public void kortinLatausKasvattaaKortinSaldoa(){
        koyhaKortti.lataaRahaa(100);
        assertEquals(200, koyhaKortti.saldo());
    }
    
    @Test
    public void kortinLatausKasvattaaKassaa(){
        kassa.lataaRahaaKortille(rikasKortti, 100);
        assertEquals(100100, kassa.kassassaRahaa());
    }
    
    @Test
    public void kortinLatausNegatiivisellaSummallaEiMuutaKortinSaldoa(){
        kassa.lataaRahaaKortille(koyhaKortti, -1);
        assertEquals(100, koyhaKortti.saldo());
    }
}
