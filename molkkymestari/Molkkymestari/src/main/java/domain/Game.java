/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;
import domain.Player;
import java.util.ArrayList;
import java.util.HashMap;
/**
 *
 * @author palovpet
 */
public class Game {
    ArrayList<Player> players;
    HashMap<Integer, String> playersWithNames;
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
        this.playersWithNames = new HashMap<>();
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
    public Player getPlayerWithIndex(int index){
        Player player = getPlayers().get(index);
        return player;
    }
    public boolean chechIfListContainsPlayerWithName(String name){
        if(this.players.contains(name)){
            return true;
        } else {
            return false;
        }
    }
    
    public Integer getPlayersIndexWithName(String name){
        int index = 0;
        if (!(this.players.contains(name))){
            index = -1;
            return index;
        }
        while(index < this.players.size()){
            this.players.get(index);
            if(this.players.get(index).equals(name)){
                return index;
                
            }
            index++;
        }       
        return index;
    }
    public Player getPlayerWithName(String name){
        /*if(this.chechIfListContainsPlayerWithName(name)== false){
            Pelaajaa ei löydy, tee jotain
        }*/
        int index = this.getPlayersIndexWithName(name);
        Player player = this.getPlayerWithIndex(index);
        return player;
    }   
    
    public void addNewPlayer(String name){
        /*if(this.chechIfListContainsPlayerWithName(name)){
            Pelaaja on jo lisätty
        }*/
        Player newPlayer = new Player(name);
        this.players.add(newPlayer);
        
        int playersIndex = this.getPlayersIndex(newPlayer);
        newPlayer.setIndexInThisGame(playersIndex);
        
        newPlayer.setPointsInThisGame(0);
        newPlayer.setMissedThrowsInThisGame(0);
    }
    
    public void setPointsFromThrow(Player player, int points){
        
        this.whosTurn += 1;
        
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
    public String getPlayersString(){
        if(this.players.size() == 0){

            return "Ei pelaajia";
        } else {
        
        String printOut = "";
        for(int index = 0; index < this.players.size(); index++){
            printOut = printOut + this.players.get(index) + "\n";
        }
        return printOut;   
        }
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
