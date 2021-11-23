package domain;

public class Player {
    String name;
    int pointsInThisGame;
    int indexInThisGame;
    int missedThrowsInThisGame;
    
    public Player(String name){
        this.name = name;          
    }

    public String getName() {
        return name;
    }

    public int getIndexInThisGame() {
        return indexInThisGame;
    }
    
    public void setIndexInThisGame(int indexInThisGame) {
        this.indexInThisGame = indexInThisGame;
    }

    public int getPointsInThisGame() {
        return pointsInThisGame;
    }

    public void setPointsInThisGame(int pointsInThisGame) {
        this.pointsInThisGame = pointsInThisGame;
    }
    
    public void addPointsInThisGame(int points){
        this.pointsInThisGame += points;
    }

    public int getMissedThrowsInThisGame() {
        return missedThrowsInThisGame;
    }

    public void setMissedThrowsInThisGame(int missedThrowsInThisGame) {
        this.missedThrowsInThisGame = missedThrowsInThisGame;
    }
    
    @Override
    public String toString(){
        return this.name;
    }          
    
}
