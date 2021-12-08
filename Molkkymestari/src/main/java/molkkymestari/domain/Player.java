/**
 * 
 */

package molkkymestari.domain;

public class Player {
    private String name;
    private int pointsInThisGame;
    private int indexInThisGame;
    private int missedThrowsInThisGame;
    
    public Player(String name) {
        
        this.name = name;          
    }
    
    //Pelaajan tiedot

    public int getIndexInThisGame() {
        
        return indexInThisGame;
    }
    
    public void setIndexInThisGame(int indexInThisGame) {
        
        
        if (indexInThisGame < 0) {
            
            return;
        }
        
        this.indexInThisGame = indexInThisGame;
    }

    //Pisteet ja hudit    
    public int getPointsInThisGame() {
        
        return pointsInThisGame;
    }

    public void setPointsInThisGame(int pointsInThisGame) {
        
        if (pointsInThisGame < 0) {
            return;
        }
        
        this.pointsInThisGame = pointsInThisGame;
    }
    
    public void addPointsInThisGame(int points) {
        
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

    public void setMissedThrowsInThisGame(int missedThrowsInThisGame) {
        
        if (missedThrowsInThisGame < 0) {
            
            return;
        }
        this.missedThrowsInThisGame = missedThrowsInThisGame;
    }
    
    @Override
    public String toString() {
        
        return this.name;
    }          
    
}
