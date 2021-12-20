package molkkymestari.logic;

import molkkymestari.domain.Game;
import java.util.Random;

/**
 * Class acts as a bridge between the GUI of Mölkkymestari-application and the 
 * Game-class. It provides methods for accessing and modifying game-settings, 
 * documenting throws and accessing and editing information of players in a game. 
 */
public class MolkkyService {   
    private Game game;
    
    /**
     * Constructor that creates a new MolkkyService-object with a new Game-object.
     */
    public MolkkyService() {
        this.game = new Game();
    }    
    
    /**
     * Method for checking the point limit set for this game of Mölkky.
     * 
     * 
     * 
     * @return integer value of point limit
     */ 
    public int getPointLimit() {        
        return game.getPointLimit();
    }
    
    /**
     * Method for setting the point limit for this game of Mölkky.
     * @param limit integer value of point limit
     */
    public void setPointLimit(int limit) {      
        game.setPointLimit(limit);
    }
    
    /**
     * Method for setting the action of what happens if the set point limit is 
     * passed. If true is selected, players points will go to zero and if false
     * is selected, points will be divided by half.
     * @param value boolean value
     */
    public void setPointsToZeroWhenPointLimitPassed(boolean value) {        
        game.setPointsToZeroWhenPointLimitPassed(value);
    }
    
    /**
     * Method for checking the action of what happens if the set point limit is 
     * passed. True indicates that players points will be set to zero and false 
     * indicates that the points will be divided by half.
     * @return boolean value
     */
    public boolean getPointsToZeroWhenPointLimitPassed() {        
        return game.getPointsToZeroWhenPointLimitPassed();
    }
    
    /**
     * Method for adding a new player for this game of Mölkky
     * @param name name or nickname of the player
     */ 
    public void addNewPlayer(String name) {        
        game.addNewPlayer(name);
    }
    
    /**
     * Method for getting how many players are in this game of Mölkky.
     * @return integer value of how many players
     */
    public int getHowManyPlayers() {
        return game.getHowManyPlayers();
    }
    
    /**
     * Method gets the players of this game of Mölkky in a list with names in 
     * each row.
     * @return String-representation of Player-objects in the PlayerList-object 
     * of this Game.
     */
    public String getPlayersToPrint() {        
        return game.getPlayersToString();
    }
    
    /**
     * Method for getting the players name with the index of that player in this
     * game of Mölkky.
     * @param index the index of the Player-object in this game
     * @return the String-representation of the Player-object
     */
    public String getPlayersNameWithIndex(int index) {
        return game.getPlayerWithIndex(index).toString();
    }
    
    /**
     * MEthod for getting the players points in this game of Mölkky with the index
     * of that player in this game.
     * @param index the index of the Player-object in this game
     * @return points of that Player-object in this game as String
     */
    public String getPlayersPointsWithIndex(int index) {
        return "" + game.getPlayerWithIndex(index).getPoints();
    }
    
    /**
     * Method for getting the name of the player whos turn is at that current time. 
     * @return the String-representation of the Player-object
     */
    public String getWhosTurnName() {        
        return game.getWhosTurnName();
    }
    
    /**
     * Method for getting the name of the player who's turn it is after the player
     * who's turn it is after this current time.
     * @return the String-representation of the Player-object
     */
    public String getWhosNextName() {        
        return game.getWhosNextName();
    }
    
    /**
     * Method for getting the index in this game of Mölkky of the player whos turn
     * it is at this current time.
     * @return the index of that Player-object in this game as integer
     */
    public int getWhosTurnIndex() {
        return game.getWhosTurnIndex();
    }
    
    /**
     * Method for documenting the points of the throw
     * @param points the points received from throw as integer, 
     * zero represents a missed throw 
     */
    public void documentThrow(String points) {
        if (this.checkIfValidNumber(points) == true) {
            game.documentPointsFromThrow(Integer.valueOf(points));
        }            
            
        
    }
    /**
     * Method checks if String is integer, returns true if it is and false if not.
     * @param value String to be checked
     * @return boolean
     */
    public Boolean checkIfInteger(String value) {
        try {
            Integer.parseInt(value);       
            return true;
        
        } catch (NumberFormatException ex) {
            return false;
        }
    }
    
    /**
     * Checks that points as String have integer value and are allowed numbers 
     * (between 0 - 12).
     * @param points points as String
     * @return boolean
     */
    public Boolean checkIfValidNumber(String points) {
        if (this.checkIfInteger(points).equals(false)) {
            return false;
        }
        int pointsInteger = Integer.valueOf(points);            
        if ((pointsInteger > 12) || (pointsInteger < 0)) {
            return false;
        }
            
        return true;
    }
    
    /**
     * Method gets the information whether the winner of this game has been found.
     * Winner is the player who get exactly the amount of points that the point 
     * limit is.
     * @return boolean value of true if winner is found, and false if it hasn't
     */
    public boolean getWinnerFound() {
        return game.getWinnerFound();
    }
    
    /**
     * Method gets the name of the winner.
     * @return the String-representation of the Player-object
     */
    public String getWinnerName() {
        return game.getWinner().toString();
    } 
    
    /**
     * Method checks if there is already a player with the name in this game.
     * @param name name as String
     * @return boolean
     */
    public Boolean checkIfNameIsAlreadyAdded(String name) {
        if (game.checkIfPlayerIsInTheGame(name).equals(true)) {
            return true;
        }        
        return false;
    }
    
    public String generateComment(String points) {
        String name = game.getWhosTurnName();
        String comment = "";
        
        if (points.equals("0")) {
            
            if(game.getPlayerWithIndex(game.getWhosTurnIndex()).getMissedThrows() == 2) {
                comment = "Hitsin pimpulat " + name + ", kolmas huti eli putoat pelistä :(";
                return comment;
            }
            
            comment = "Hupsista " + name + ", nyt meni huti :(";
            return comment;
        }    
        
        Random randomizer = new Random();
        int randomNumber = randomizer.nextInt(4);
        
        if (randomNumber == 0) {
            comment = "Huisi heitto " + name + "!";
        }
        if (randomNumber == 1) {
            comment = name + " osuu jälleen! <3";
        }
        if (randomNumber == 2) {
            comment = "Ja yleisö huutaa: " + name + ", " + name + ", " + name + "!";
        }
        if (randomNumber == 3) {
            comment = name + " on liekeissä!!! :o";
        }
        if (randomNumber == 4) {
            comment = name + " nappaa pisteet jälleen!";
        }
        
        return comment;
    }
}
