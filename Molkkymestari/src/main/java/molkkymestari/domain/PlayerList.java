package molkkymestari.domain;

import java.util.ArrayList;

/**
 * Class provides methods for managing and getting information of Player-objects 
 * in a Mölkky-game. Acts as a bridge between Game and Player class. 
 */
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
        return players.size();
    } 
    
    /**
     * Adds a new player to the game. If there are already 10 or more players, 
     * won't add a new player
     * @param name players name or nickname
     */
    public void addNewPlayer(String name) {       
        if (players.size() >= 10) {
            return;
        }
       
        Player newPlayer = new Player(name);
        players.add(newPlayer);
    
        int indexForThisGame = players.indexOf(newPlayer);
        newPlayer.setIndex(indexForThisGame);        
        newPlayer.setPoints(0);
        newPlayer.setMissedThrows(0);   
    }
    
    /**
     * Removes a player from the game
     * @param player the player to be removed
     */
    public void removePlayer(Player player) {
        players.remove(player.getIndex());
            
    }
    
    /**
     * Updates the PlayerList, so players indexes in this game remain accurate 
     * after removing a player.
     * @return Returns the updated PlayerList object
     */
    public PlayerList updatePlayerList() {   
        ArrayList<Player> updatedList = new ArrayList<>();
        for (int index = 0; index < players.size(); index++) {
            
            Player playerToNewList = players.get(index);
            
            updatedList.add(playerToNewList);
            playerToNewList.setIndex(index);
            
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
        if (players.isEmpty()) {
            return null;
        }       
        Player player = players.get(index);
        return player;
    }

    /**
     * Method for getting the Player-object with players name or nickname.
     * If there are no players, returns null.
     * @param name the name or nickname that was given upon creating the 
     * Player-object.
     * @return Player-object or null
     */
    public Player getPlayerWithName(String name) {        
        if (players.isEmpty()) {
            return null;
        }
        
        int playersIndex = -1;
        for (int index = 0; index < players.size(); index++) {               
            if (players.get(index).toString().equals(name)) {                  
                playersIndex = index;
            }
        }
        if (playersIndex == -1) {               
            return null;
        }
        return players.get(playersIndex);                       
    }
    
    /**
     * toString presentation for PlayerList objects.
     * @return Returns each player in the game separated with a row change. 
     * If there are no players, returns that information. 
     */
    @Override
    public String toString() {       
        if (players.isEmpty()) {            
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
