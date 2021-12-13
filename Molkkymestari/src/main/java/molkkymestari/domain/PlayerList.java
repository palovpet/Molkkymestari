/**
 * Class provides methods for managing and getting information of Player-objects in a Mölkky-game. Acts as a bridge between Game and Player class.
 */
package molkkymestari.domain;

import java.util.ArrayList;

public class PlayerList {
    
    private ArrayList<Player> players;
    
    /**
     * Constructor for a new PlayerList object.
     */
    public PlayerList() {
        this.players = new ArrayList<>();    
    }
    
    /**
     * Method for getting the number of players in the game
     * @return integer value of how many players has been added to the PlayerList 
     */
    public int getHowManyPlayers() {
        
        return this.players.size();
    } 
    
    /**
     * Adds a new player to the game. If there are already 10 or more players, 
     * won't add a new player
     * @param name players name or nickname
     */
    public void addNewPlayer(String name) {
        
        if (this.players.size() >= 10) {
            return;
        }
       
        Player newPlayer = new Player(name);
        this.players.add(newPlayer);
    
        int indexForThisGame = this.players.indexOf(newPlayer);
        newPlayer.setIndexInThisGame(indexForThisGame);        
        newPlayer.setPointsInThisGame(0);
        newPlayer.setMissedThrowsInThisGame(0);   
    }
    
    /**
     * Removes a player from the game
     * @param player the player to be removed
     */
    public void removePlayer(Player player) {
        this.players.remove(player.getIndexInThisGame());
            
    }
    
    /**
     * Updates the PlayerList, so players indexes in this game remain accurate after removing a player.
     * @return Returns the updated PlayerList object
     */
    public PlayerList updatePlayerList() {
    
        ArrayList<Player> updatedList = new ArrayList<>();
        for (int index = 0; index < this.players.size(); index++) {
            
            Player playerToNewList = players.get(index);
            
            updatedList.add(playerToNewList);
            playerToNewList.setIndexInThisGame(index);
            
        }
        this.players = updatedList;
        PlayerList updatedPlayerList = new PlayerList();
        updatedPlayerList.players = updatedList;
        return updatedPlayerList;
            
    }
    
    /**
     * Method for getting the Player-object with that players index in this game.
     * If there are no players, returns null.
     * @param index the index player is given in this game
     * @return Player-object or null
     */ 
    public Player getPlayerWithIndex(int index) {  
        
        if (this.players.isEmpty()) {
            return null;
        }
        
        Player player = this.players.get(index);
        return player;
    }

    /**
     * Method for getting the Player-object with players name or nickname.
     * If there are no players, returns null.
     * @param name the name or nickname that was given upon creating the Player-object.
     * @return Player-object or null
     */
    public Player getPlayerWithName(String name) {
        
        if (this.players.isEmpty()) {
            return null;
        }
        
        int playersIndex = -1;
        for (int index = 0; index < this.players.size(); index++) {
                
            if (this.players.get(index).toString().equals(name)) {
                    
                playersIndex = index;
            }
        }
        if (playersIndex == -1) {
                
            return null;
        }
        return this.players.get(playersIndex);                       
    }
    
    /**
     * toString presentation for PlayerList objects.
     * @return Returns each player in the game separated with a row change. 
     * If there are no players, returns that information. 
     */
    @Override
    public String toString() {
        
        if (this.players.isEmpty()) {
            
            return "Ei pelaajia";
        } else {
            
            String printOut = "";
            for (int index = 0; index < this.players.size(); index++) {
                
                printOut = printOut + this.players.get(index) + "\n";
            }
            return printOut;
        }
    } 
    
}
