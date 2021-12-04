package molkkymestari.logic;

import molkkymestari.domain.Game;

public class MolkkyService {
    
    Game molkky;
  
    public MolkkyService() {
        
        this.molkky = new Game();
    }
    
    public int getPointLimit() {
        
        return molkky.getPointLimit();
    }
    
    public void setPointLimit(int limit) {
        
        molkky.setPointLimit(limit);
    }
    
    public void setPointsToZeroWhenPointLimitPassedWithValue(boolean value) {
        
        molkky.setPointsToZeroWhenPointLimitPassedWithValue(value);
    }
    
    public boolean getPointsToZeroWhenPointLimitPassedWithValue() {
        
        return molkky.getPointsToZeroWhenPointLimitPassedWithValue();
    }
    
    public void addNewPlayer(String name) {
        
        molkky.addNewPlayer(name);
    }
    
    public String getPlayersToPrint() {
        
        return molkky.getPlayersToString();
    }
    
    public String getWhosTurnName() {
        
        return molkky.getWhosTurnName();
    }
    
    public String getWhosNextName() {
        
        return molkky.getWhosNextName();
    }
    
    public int getWhosTurnIndex() {
        return molkky.getWhosTurnIndex();
    }
    
    public void documentThrow(int points) {
        molkky.documentPointsFromThrow(points);
    }
    
    public boolean getWinnerFound() {
        return molkky.getWinnerFound();
    }
    
    public String getWinnerName() {
        return molkky.getWinner().toString();
    }
    
    public int getHowManyPlayers() {
        return molkky.getHowManyPlayers();
    }
    
    
    public String getPlayersNameWithIndex(int index) {
        return molkky.getPlayerWithIndex(index).toString();
    }
    
    public String getPlayersPointsWithIndex(int index) {
        return "" + molkky.getPlayerWithIndex(index).getPointsInThisGame();
    }
    
}
