package molkkymestari.domain;

public class Game {

    PlayerList playerList;
    int whosTurn;
    int pointLimit;
    boolean pointsToZeroWhenPointLimitPassed;
    Player winner;
    boolean winnerFound;

    public Game() {       
        this(50);
    }
    
    public Game(int pointLimit) {
        this.playerList = new PlayerList();
        this.whosTurn = 0;
        this.pointLimit = pointLimit;
        this.pointsToZeroWhenPointLimitPassed = false;
        this.winnerFound = false;     
    }
    
    //Peliasetukset  
    public void setPointsToZeroWhenPointLimitPassedWithValue(boolean value) {
        this.pointsToZeroWhenPointLimitPassed = value;
    }

    public boolean getPointsToZeroWhenPointLimitPassedWithValue() {
        return this.pointsToZeroWhenPointLimitPassed;
    }

    public int getPointLimit() {
        return this.pointLimit;
    }

    public void setPointLimit(int limit) {
        this.pointLimit = limit;
    }

    //Pelaajien hallinta   
    public void addNewPlayer(String name) {
        this.playerList.addNewPlayer(name);
    }
    
    public int getHowManyPlayers() {
        return this.playerList.getHowManyPlayers();
    }
    
    public String getPlayersToString() {
        return this.playerList.toString();
    }
    
    public Player getPlayerWithIndex(int index) {
        return this.playerList.getPlayerWithIndex(index);
    }
    
    public void removePlayer(Player player) {
        
        int lastBeforeRemovedIndex = this.getWhosTurnIndex() - 1;
        
        if (lastBeforeRemovedIndex < 0) {
            lastBeforeRemovedIndex  = this.getHowManyPlayers() - 1;
        }
        Player lastBeforeRemovingPlayer = this.getPlayerWithIndex(lastBeforeRemovedIndex );
                
        this.playerList.removePlayer(player);
        PlayerList updatedPlayerList = playerList.updatePlayerList();
        this.playerList = updatedPlayerList;
        
        int whoWasLastBeforeRemovingIndex = lastBeforeRemovingPlayer.getIndexInThisGame();
        this.whosTurn = whoWasLastBeforeRemovingIndex;
        
               
    }

    //Pelivuoroon liittyvät
    public void updateWhosTurn() {

        if (this.whosTurn >= (this.playerList.getHowManyPlayers() - 1)) {

            this.whosTurn = 0;

        } else {

            this.whosTurn = this.whosTurn + 1;
        }
    }

    public String getWhosTurnName() {

        if (this.playerList.getHowManyPlayers() == 0) {
            return "Ei pelaajia";
        }
        return this.playerList.getPlayerWithIndex(whosTurn).toString();
    }

    public int getWhosTurnIndex() {

        return this.whosTurn;
    }

    public int getWhosNextIndex() {

        if (this.playerList.getHowManyPlayers() == 1) {

            return 0;
        } else if ((this.whosTurn + 1) >= (this.playerList.getHowManyPlayers())) {
            return 0;
        }
        return (this.whosTurn + 1);
    }

    public String getWhosNextName() {
        if (this.playerList.getHowManyPlayers() == 1) {
            return "Vain yksi pelaaja";
        } else if (this.playerList.getHowManyPlayers() == 0) {
            return "Ei pelaajia";
        }
        int indexOfNext = this.getWhosNextIndex();

        return this.playerList.getPlayerWithIndex(indexOfNext).toString();

    }    

    //Heittovuoro ja voittaja
    public void documentPointsFromThrow(int points) {
        
        Player playerWhosTurn = this.playerList.getPlayerWithIndex(this.whosTurn);
        
        if (points == 0) {
            this.missedThrow(playerWhosTurn);
        }

        else if ((playerWhosTurn.getPointsInThisGame() + points) < this.pointLimit) {
            playerWhosTurn.addPointsInThisGame(points);
            
        } else if ((playerWhosTurn.getPointsInThisGame() + points) == this.pointLimit) {
            this.winningThrow(playerWhosTurn, points);

        } else if ((playerWhosTurn.getPointsInThisGame() + points) > this.pointLimit) {
            this.pointLimitPassed(playerWhosTurn, points);
            
        }
        int playerWhosTurnIndexAfterDocumenting = playerWhosTurn.getIndexInThisGame();
        this.updateWhosTurn();
    }
    
    public void pointLimitPassed(Player player, int points) {
        
        if (getPointsToZeroWhenPointLimitPassedWithValue() == false) {
                int pointsToHalf = ((player.getPointsInThisGame() + points) / 2);
                //tee jotain parittomien lukujen käsittelylle

                player.setPointsInThisGame(pointsToHalf);
            } else {
                player.setPointsInThisGame(0);
            }
        
    }
    
    public void missedThrow(Player player) {
        if (player.getMissedThrowsInThisGame() == 2) {
                removePlayer(player);
                
            } else {
                player.setMissedThrowsInThisGame((player.getMissedThrowsInThisGame() + 1));
            }
    }
    
    public void winningThrow(Player player, int points) {
        player.addPointsInThisGame(points);
            this.winnerFound = true;
            this.winner = player;
    }
    
    public boolean getWinnerFound() {
        return this.winnerFound;
    }
    
    public Player getWinner() {
        return this.winner;
    }

}
