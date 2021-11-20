/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;
import domain.Player;
import java.util.ArrayList;
/**
 *
 * @author palovpet
 */
public class Game {
    ArrayList<Player> players;
    ArrayList<Integer> playerPoints;
    ArrayList<Integer> playerMissedThrows;
    int whosTurn;
    int pointLimit;
    boolean pointsToZeroWhenPointLimitPassed;
    /*Täydennä tietoihin: oletus siitä että pisteet palaa puoleenväliin, 
    mutta voi asettaa että menee nollaan.*/
    boolean winnerFound;
    
    public Game(){
        this(50);
    }
    
    public Game(int pointLimit){
        this.players = new ArrayList<>();
        this.playerPoints = new ArrayList<>();
        this.playerMissedThrows = new ArrayList<>();
        this.whosTurn = 0;  
        this.pointLimit = pointLimit;
        this.pointsToZeroWhenPointLimitPassed = false;  
        this.winnerFound = false;        
    }
    
    //Peliasetukset   
    public void setPointsToZeroWhenPointLimitPassedWithValue(boolean value){
        this.pointsToZeroWhenPointLimitPassed = value;
    }
    public void setPointsToZeroWhenPointLimitPassedWithTrue(){
        setPointsToZeroWhenPointLimitPassedWithValue(true);
    }
    
    public void setPointsToZeroWhenPointLimitPassedWithFalse(){
        setPointsToZeroWhenPointLimitPassedWithValue(false);
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
    
    public void winnerFound(){
        this.winnerFound = true;
        //Lisää jotain pelin päättämiseen ja voittajaan liittyen
    }
    
    //Pelaajat    
    public void addPlayer(Player player){
        players.add(player);
        player.setIndexInThisGame(this.players.size()+1);
        player.setPointsInThisGame(0);
        player.setMissedThrowsInThisGame(0);
    }
    
    public void setPointsFromThrow(Player player, int points){
        
        if(points == 0){
            if(player.getMissedThrowsInThisGame()== 2){
                //peli päättyy pelaajan osalta, pois listalta jne
            } else {
                player.setMissedThrowsInThisGame((player.getMissedThrowsInThisGame() + 1));
            }
            
        }
        
        if((player.getPointsInThisGame() + points)<this.pointLimit){
            player.addPointsInThisGame(points);
        } 
        else if ((player.getPointsInThisGame() + points) == this.pointLimit){
            winnerFound();
            
        } else if ((player.getPointsInThisGame() + points) > this.pointLimit){
            if(getPointsToZeroWhenPointLimitPassedWithValue()== false){
                int pointsToHalf = (player.getPointsInThisGame() / 2);
                //tee jotain parittomien lukujen käsittelylle
                player.setPointsInThisGame(pointsToHalf);
            }
            else {
                player.setPointsInThisGame(0);
            }
        }    
    }
    
    public int getHowManyPointDoesPlayerHave(Player player){
        return player.getPointsInThisGame();
    }
    
    public int getPlayersIndex(Player player){
        return player.indexInThisGame;
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
