/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molkkymestari;
import java.util.ArrayList;
/**
 *
 * @author palovpet
 */
public class Game {
    ArrayList<Player> players;
    int whosTurn;
    int pointLimit;
    boolean pointsToZeroWhenPointLimitPassed;
    /*Täydennä tietoihin: oletus siitä että pisteet palaa puoleenväliin, 
    mutta voi asettaa että menee nollaan.*/
    
    public Game(){
        this(50);
    }
    
    public Game(int pointLimit){
        this.players = new ArrayList<>();
        this.whosTurn = 0;  
        this.pointLimit = pointLimit;
        this.pointsToZeroWhenPointLimitPassed = false;      
    }
    
    public void setPointsToZeroWhenPointLimitPassedWithValue(boolean value){
        this.pointsToZeroWhenPointLimitPassed = value;
    }
    
    public boolean getPointsToZeroWhenPointLimitPassedWithValue(){
        return this.pointsToZeroWhenPointLimitPassed;
    }
    
    public int getPointLimit(){
        return this.pointLimit;
    }
    
    public void setPointLimit(int limit){
        this.pointLimit = limit;
    }
    
    public void addPlayer(Player player){
        players.add(player);
    }
    
    public ArrayList<Player> getPlayers(){
        return this.players;
    } 
    
    public int getHowManyPlayers(){
        return this.players.size();
    }
    
    public Player getWhosTurn(){
        return this.players.get(whosTurn);
    }
    
    public Player getWhosNext(){
        return this.players.get((whosTurn + 1));
    }
    
    
}
