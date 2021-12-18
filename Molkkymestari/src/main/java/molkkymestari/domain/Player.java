package molkkymestari.domain;

/**
 * Class provides methods for adding players and 
 * updating and pulling players information in a Mölkky-game. 
 */
public class Player {
    private String name;
    private int points;
    private int index;
    private int missedThrows;
    
    /**
     * Constructor for creating a new Player object.
     * @param name players name or nickname 
     */
    public Player(String name) {       
        this.name = name;          
    }
    
    public int getIndex() {        
        return index;
    }
    
    /**
     * Sets index in a game, won't set a negative index
     * @param index index to be set for this player in this game
     */
    public void setIndex(int index) {       
        if (index < 0) {     
            return;
        }
        this.index = index;
    }
  
    public int getPoints() {     
        return points;
    }
    
    /**
     * Sets points in a game, wont set negative points
     * @param points points to be set for the player for this game
     */

    public void setPoints(int points) {      
        if (points < 0) {
            return;
        }      
        this.points = points;
    }
    /**
     * Adds points from a throw to players current points. 
     * @param points amount of points received from a throw
     */
    public void addPoints(int points) {                    
        this.points += points;
    }

    public int getMissedThrows() {      
        return missedThrows;
    }
    
    /**
     * Sets missed throws in a game, won't set a negative number
     * @param missedThrows value for missed throws in a game
     */   
    public void setMissedThrows(int missedThrows) {       
        if (missedThrows < 0) {         
            return;
        }
        this.missedThrows = missedThrows;
    }
    
    /**
     * toStringe presentation for Player objects.
     * @return the name given for the player with creation
     */  
    @Override
    public String toString() {       
        return name;
    }              
}
