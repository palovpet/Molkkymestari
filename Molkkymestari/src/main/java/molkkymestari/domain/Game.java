package molkkymestari.domain;

/**
 * Class provides methods for a Mölkky-game. Methods contain ways to manage and get game settings, 
 * document the throws of players and manage and get information of the players of the game.  
 */
public class Game {

    private PlayerList playerList;
    private int whosTurn;
    private int pointLimit;
    private boolean pointsToZeroWhenPointLimitPassed;
    private Player winner;
    private boolean winnerFound;

    /**
     * Constructor for Game-objects with default settings: point limit of 50 
     * and points are divided by half if point limit is passed. 
     */
    public Game() {       
        this(50);
    }
    
    /**
     * Constructor for Game-objects with the option of selecting the point limit. 
     * If point limit is passed the default setting is set to divide players points by half.
     * @param pointLimit 
     */
    public Game(int pointLimit) {
        this.playerList = new PlayerList();
        this.whosTurn = 0;
        this.pointLimit = pointLimit;
        this.pointsToZeroWhenPointLimitPassed = false;
        this.winnerFound = false;     
    }
      
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

    /**
     * Method for adding a new player to the game. Creates a new Player-object and 
     * adds that object to the PlayerList-object associated with this game.
     * @param name name or nickname of the player 
     */  
    public void addNewPlayer(String name) {
        this.playerList.addNewPlayer(name);
    }
    
    /**
     * Method for getting the information of how many players are in this game.
     * @return integer value of Player-objects in the PlayerList-object associated with this Game-object.
     */
    public int getHowManyPlayers() {
        return this.playerList.getHowManyPlayers();
    }
    
    /**
     * Method for getting the String-representation of the players in this game.
     * @return names or nicknames given to Player-objects upon creation divided by a row change.
     */
    public String getPlayersToString() {
        return this.playerList.toString();
    }
    
    /**
     * Method for getting a Player-object with the index the player has been given in this game.
     * @param index the index associated with the Player in this game
     * @return Player-object
     */
    public Player getPlayerWithIndex(int index) {
        return this.playerList.getPlayerWithIndex(index);
    }
    
    /**
     * Removes a player from the game. Updates the remaining players indexes in this game, 
     * and the information of whos turn it is.
     * @param player the Player-object to be removed.
     */
    public void removePlayer(Player player) {
        
        int lastBeforeRemovedIndex = this.getWhosTurnIndex() - 1;
        
        if (lastBeforeRemovedIndex < 0) {
            lastBeforeRemovedIndex  = this.getHowManyPlayers() - 1;
        }
        Player lastBeforeRemovingPlayer = this.getPlayerWithIndex(lastBeforeRemovedIndex);
                
        this.playerList.removePlayer(player);
        PlayerList updatedPlayerList = playerList.updatePlayerList();
        this.playerList = updatedPlayerList;
        
        int whoWasLastBeforeRemovingIndex = lastBeforeRemovingPlayer.getIndexInThisGame();
        this.whosTurn = whoWasLastBeforeRemovingIndex;
        
               
    }

    /**
     * Updates whos turn to throw it is at a given time. The information about the player 
     * who's turn it is at the given time is stored in a Game-objects attribute whosTurn. 
     * The attribute is an integer that represents a players index in that game.
     * The method checks if there is a player next after the current one by comparing 
     * the whosTurn-attribute to the amount of players in the game subtracted by one (as indexes start from zero).
     * If there is a next player the attribute is summed with one, if not the attribute returns 
     * to zero to represent the first player.
     * 
     */
    public void updateWhosTurn() {

        if (this.whosTurn >= (this.playerList.getHowManyPlayers() - 1)) {

            this.whosTurn = 0;

        } else {

            this.whosTurn = this.whosTurn + 1;
        }
    }
    
    /**
     * Method gets the name or nickname of the player whos turn is 
     * at that current time. If there are no players, that information is presented
     * @return toString representation of the Player-object whos turn it is
     */
    public String getWhosTurnName() {

        if (this.playerList.getHowManyPlayers() == 0) {
            return "Ei pelaajia";
        }
        return this.playerList.getPlayerWithIndex(whosTurn).toString();
    }

    public int getWhosTurnIndex() {

        return this.whosTurn;
    }
    
    /**
     * Method gets the index of the player whos turn it is after the current players turn.
     * If there is only one player, the index is zero tho represent that player. If there
     * is no next player the index is zero to represent the index of the first player.
     * @return integer value of the index of the Player-object who's turn is after the current player.
     */
    public int getWhosNextIndex() {

        if (this.playerList.getHowManyPlayers() == 1) {

            return 0;
        } else if ((this.whosTurn + 1) >= (this.playerList.getHowManyPlayers())) {
            return 0;
        }
        return (this.whosTurn + 1);
    }
    
    /**
     * Method gets the name or nickname of the player who's turn it is after the current players turn.
     * If there are no players or only one player, that information is shown.
     * @return toString representation of the Player-object who's turn is next. 
     */
    public String getWhosNextName() {
        if (this.playerList.getHowManyPlayers() == 1) {
            return "Vain yksi pelaaja";
        } else if (this.playerList.getHowManyPlayers() == 0) {
            return "Ei pelaajia";
        }
        int indexOfNext = this.getWhosNextIndex();

        return this.playerList.getPlayerWithIndex(indexOfNext).toString();

    }    

    /**
     * Method documents points from throw to the player  whos turn it is at that given time.
     * Missed throws, winning throws and normal (not winning or missed) throws are
     * documented according the settings made.
     * @param points integer value of points received of the throw
     */ 
    public void documentPointsFromThrow(int points) {
        
        Player playerWhosTurn = this.playerList.getPlayerWithIndex(this.whosTurn);
        
        if (points == 0) {
            this.missedThrow(playerWhosTurn);
            
        } else if ((playerWhosTurn.getPointsInThisGame() + points) < this.pointLimit) {
            playerWhosTurn.addPointsFromThrow(points);
            
        } else if ((playerWhosTurn.getPointsInThisGame() + points) == this.pointLimit) {
            playerWhosTurn.addPointsFromThrow(points);
            this.winnerFound = true;
            this.winner = playerWhosTurn;

        } else if ((playerWhosTurn.getPointsInThisGame() + points) > this.pointLimit) {
            this.pointLimitPassed(playerWhosTurn, points);
            
        }
        int playerWhosTurnIndexAfterDocumenting = playerWhosTurn.getIndexInThisGame();
        this.updateWhosTurn();
    }
    
    /**
     * Method for processing a players throw that passes the games point limit.
     * Depending on settings made, the passing of the point limit either sets 
     * players points to zero or divides them by half. Points divided by half
     * are rounded up mathematically, if decimals are 50 or more the number is rounded up.
     * @param player Player-object to whom the points are documented
     * @param points the points received from the throw
     */
    public void pointLimitPassed(Player player, int points) {
        
        if (getPointsToZeroWhenPointLimitPassedWithValue() == false) {
            
            double pointsDouble = 1.0 * points;
            pointsDouble += (1.0 * player.getPointsInThisGame());
            pointsDouble = pointsDouble / 2.0;
            
            int pointsToHalf = (int) Math.round(pointsDouble);
            
            player.setPointsInThisGame(pointsToHalf);
            
        } else {
            player.setPointsInThisGame(0);
        }
        
    }
    
    /**
     * Method for processing a missed throw. If player already has two missed throws 
     * in this game they are removed from the game. Otherwise a missed throw is added 
     * to players count of missed throw.
     * @param player Player-object representing the player who threw the missed throw.
     */
    public void missedThrow(Player player) {
        if (player.getMissedThrowsInThisGame() == 2) {
            removePlayer(player);
                
        } else {
            player.setMissedThrowsInThisGame((player.getMissedThrowsInThisGame() + 1));
        }
    }
    
    public boolean getWinnerFound() {
        return this.winnerFound;
    }
    
    public Player getWinner() {
        return this.winner;
    }

}
