package molkkymestari;


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
    
    public MolkkyService(){
        this.molkky = new Game();
    }
    
    public void changePointLimitToFifty(){
        molkky.setPointLimit(50);
    }
    
    public void changePointLimitToThirty(){
        molkky.setPointLimit(30);
    }
    
    public void pointsGoToZeroIfPointLimitIsPassed(){
        molkky.setPointsToZeroWhenPointLimitPassedWithValue(true);
    }
    
    public void pointsAreSplitHalfIfPoinLimitIsPassed(){
        molkky.setPointsToZeroWhenPointLimitPassedWithValue(false);
    }
    
    public void addNewPlayer(String name){
        molkky.addNewPlayer(name);
    }
    public String getPlayersToPrint(){
        return molkky.getPlayersToString();
    }
    
    public String getWhosTurnName(){
        return molkky.getWhosTurnName();
    }
    
    public String getWhosNextName(){
        return molkky.getWhosTurnNextName();
    }
    public String getTheCurrentPlayersPoints(){
        return molkky.getCurrentPlayersPoints();
    }
    
    public void documentThrow(int points){
        molkky.documentPointsFromThrow(points);
    }
    
    public void winnerFoundGameOver(){
        //jotain voittajan juhlintaa
    }
    
}
