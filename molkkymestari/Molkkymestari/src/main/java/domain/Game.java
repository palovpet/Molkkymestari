package domain;

public class Game {
    PlayerList playerList;
    int whosTurn;
    int pointLimit;
    boolean pointsToZeroWhenPointLimitPassed;
    boolean winnerFound;
    
    public Game(){
        this(50);
    }
    
    public Game(int pointLimit){
        this.playerList = new PlayerList();
        this.whosTurn = 0;  
        this.pointLimit = pointLimit;
        this.pointsToZeroWhenPointLimitPassed = false;  
        this.winnerFound = false;        
    }
    
    //Pelaajien hallinta   
    public void addNewPlayer(String name){
        this.playerList.addNewPlayer(name);
    }
   
    public int getHowManyPointDoesPlayerHave(String name){
        return this.playerList.getHowManyPointDoesPlayerHave(playerList.getPlayerWithName(name));
    }
     
    public int getHowManyPlayers(){
        return this.playerList.getHowManyPlayers();
    }
    
    //Pelaajan tiedot tässä pelissä
    public int getHowManyPointDoesPlayerHave(Player player){
        return player.getPointsInThisGame();
    }
    
    public int getPlayersIndex(Player player){
        return player.indexInThisGame;
    }
    
    
    public String getPlayersToString(){
        return this.playerList.toString();
    }
        
    //Pelivuoroon liittyvät
    public String getCurrentPlayersPoints(){
        Player playerWhosTurn = this.playerList.getPlayerWithIndex(whosTurn);
        int playersPoints = playerWhosTurn.getPointsInThisGame();
        return "" + playersPoints;
    }
    
    public String getWhosTurnName(){
        if (this.playerList.getHowManyPlayers()== 0){
            return "Ei pelaajia";
        }    
        return this.playerList.getPlayerWithIndex(whosTurn).toString();
    }
    
    public int getWhosTurnIndex(){
        return this.whosTurn;
    }
    
    public int getWhosNextIndex(){
        if(this.playerList.getHowManyPlayers()== 1){
            return 1;
        }
        return (this.whosTurn + 1);
    }
    public String getWhosTurnNextName(){
        if(this.playerList.getHowManyPlayers()== 1){
            return "Vain yksi pelaaja lisätty";
        }
        else if (this.playerList.getHowManyPlayers()== 0){
            return "Ei pelaajia";
        }
        return this.playerList.getPlayerWithIndex(this.getWhosNextIndex()).toString();
            
    }
    //Peliasetukset  
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
    
      
    //Pelitoiminnot
    
        public void winnerFound(){
        this.winnerFound = true;
        //Lisää jotain pelin päättämiseen ja voittajaan liittyen
    }
        
    public void documentPointsFromThrow(int points){
        Player playerWhosTurn = this.playerList.getPlayerWithIndex(this.whosTurn);        
        this.whosTurn += 1;
        
        if(points == 0){
            if(playerWhosTurn.getMissedThrowsInThisGame()== 2){
                //peli päättyy pelaajan osalta, pois listalta jne
            } else {
                playerWhosTurn.setMissedThrowsInThisGame((playerWhosTurn.getMissedThrowsInThisGame() + 1));
            }            
        }
        
        if((playerWhosTurn.getPointsInThisGame() + points)<this.pointLimit){
            playerWhosTurn.addPointsInThisGame(points);
        } 
        else if ((playerWhosTurn.getPointsInThisGame() + points) == this.pointLimit){
            winnerFound();
            
        } else if ((playerWhosTurn.getPointsInThisGame() + points) > this.pointLimit){
            if(getPointsToZeroWhenPointLimitPassedWithValue()== false){
                int pointsToHalf = (playerWhosTurn.getPointsInThisGame() / 2);
                //tee jotain parittomien lukujen käsittelylle
                playerWhosTurn.setPointsInThisGame(pointsToHalf);
            }
            else {
                playerWhosTurn.setPointsInThisGame(0);
            }
        }    
    }

    
    
}
