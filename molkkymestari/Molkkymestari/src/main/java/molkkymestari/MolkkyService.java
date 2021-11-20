
import domain.Game;

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package molkkymestari;

//
///**
// *
// * @author palovpet
// */
public class MolkkyService {
    Game molkky;

    
    public void changePointLimitToFifty(){
        molkky.setPointLimit(50);
    }
    
    public void changePointLimitToThirty(){
        molkky.setPointLimit(30);
    }
    
    public void pointsGoToZeroIfPoinLimitIsPassed(){
        molkky.setPointsToZeroWhenPointLimitPassedWithTrue();
    }
    
    public void pointsAreSplitHalfIfPoinLimitIsPassed(){
        molkky.setPointsToZeroWhenPointLimitPassedWithFalse();
    }
    
    public void addPlayers(){
        //lisä uuden pelaajan
    }
    
    public void documentThrow(){
        //kirjaa heittovuoron tapahtumat
    }
    public void winnerFoundGameOver(){
        //jotain voittajan juhlintaa
    }
    
}
