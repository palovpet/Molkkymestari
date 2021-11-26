package molkkymestari;


import domain.Game;

public class MolkkyService {
    Game molkky;
  
    public MolkkyService(){
        this.molkky = new Game();
    }
    
    public int getPointLimit(){
        return molkky.getPointLimit();
    }
    
    public void changePointLimitToFifty(){
        molkky.setPointLimit(50);
    }
    
    public void changePointLimitToThirty(){
        molkky.setPointLimit(30);
    }
    
    public void setPointsToZeroWhenPointLimitPassedWithValue(boolean value){
        molkky.setPointsToZeroWhenPointLimitPassedWithValue(value);
    }
    
    public boolean getPointsToZeroWhenPointLimitPassedWithValue(){
        return molkky.getPointsToZeroWhenPointLimitPassedWithValue();
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
