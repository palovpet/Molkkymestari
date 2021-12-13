/**
 * Class provides methods for adding players and 
 * updating and pulling players information in a Mölkky-game.
 */

package molkkymestari.domain;

public class Player {
    private String name;
    private int pointsInThisGame;
    private int indexInThisGame;
    private int missedThrowsInThisGame;
    
    /**
     * Constructor for creating a new Player object.
     * @param name players name or nickname 
     */
    public Player(String name) {
        
        this.name = name;          
    }
    
    public int getIndexInThisGame() {
        
        return indexInThisGame;
    }
    
    /**
     * Sets index in a game, won't set a negative index
     * @param indexInThisGame index to be set for this player in this game
     */
    public void setIndexInThisGame(int indexInThisGame) {
        
        if (indexInThisGame < 0) {
            
            return;
        }
        
        this.indexInThisGame = indexInThisGame;
    }
  
    public int getPointsInThisGame() {
        
        return pointsInThisGame;
    }
    
    /**
     * Sets points in a game, wont set negative points
     * @param pointsInThisGame points to be set for the player for this game
     */

    public void setPointsInThisGame(int pointsInThisGame) {
        
        if (pointsInThisGame < 0) {
            return;
        }
        
        this.pointsInThisGame = pointsInThisGame;
    }
    /**
     * Adds points from a throw to players current points. 
     * Only accepts possible points (number between 0 - 12).
     * @param points amount of points received from a throw
     */
    public void addPointsFromThrow(int points) {
        
        if (points < 0) {
            
            return;
        } else if (points > 12) {
            
            return;
        } 
        
        this.pointsInThisGame += points;
    }

    public int getMissedThrowsInThisGame() {
        
        return missedThrowsInThisGame;
    }
    
    /**
     * Sets missed throws in a game, won't set a negative number
     * @param missedThrowsInThisGame value for missed throws in a game
     */   
    public void setMissedThrowsInThisGame(int missedThrowsInThisGame) {
        
        if (missedThrowsInThisGame < 0) {
            
            return;
        }
        this.missedThrowsInThisGame = missedThrowsInThisGame;
    }
    
    /**
     * toStringe presentation for Player objects.
     * @return the name given for the player with creation
     */  
    @Override
    public String toString() {
        
        return this.name;
    }              
}
