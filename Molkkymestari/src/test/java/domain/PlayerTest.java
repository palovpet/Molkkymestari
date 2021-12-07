package domain;

import molkkymestari.domain.Player;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTest {
    
    Player player;

    @Before
    public void setUp() {
        player = new Player("Testi-Tahvo");
        player.setIndexInThisGame(0);
        player.setMissedThrowsInThisGame(1);
        player.setPointsInThisGame(10);
    }
    
    @Test
    public void getIndexInThisGameReturnsIndexInThisName(){
        assertEquals(player.getIndexInThisGame(), 0);
    }
    
    @Test
    public void setIndexInThisGameSetsTheIndexInThisGame(){
        int newIndex = 1;
        player.setIndexInThisGame(newIndex);
        assertEquals(player.getIndexInThisGame(), newIndex);
    }
    @Test
    public void setIndexInThisGameWontSetNegativeIndex(){
        player.setIndexInThisGame(-1);
        assertEquals(player.getIndexInThisGame(), 0);
    }
    
    @Test
    public void getMissedThrowsInThisGameReturnsMissedThrowsInThisGame(){
        assertEquals(player.getMissedThrowsInThisGame(), 1);
    }
    
    @Test
    public void setMissedThrowsInThisGameSetsMissedThrowsInThisGame(){
        int newValueForMissedThrows = 2;
        player.setMissedThrowsInThisGame(newValueForMissedThrows);
        assertEquals(player.getMissedThrowsInThisGame(), newValueForMissedThrows);
    }
    @Test
    public void setMissedThrowsInThisGameWontSetNegativeMissedThrowsInThisGame(){
        player.setMissedThrowsInThisGame(-1);
        assertEquals(player.getMissedThrowsInThisGame(), 1);
    }
    
    @Test
    public void getPointsInThisGameReturnsPointsInThisGame(){
        assertEquals(player.getPointsInThisGame(), 10);
    }
    
    @Test
    public void setPointsInThisGameSetsPointsInThisGame(){
        int points = 5;
        player.setPointsInThisGame(points);
        assertEquals(player.getPointsInThisGame(), 5);
    }
    
    @Test
    public void setPointsInThisGameWontSetNegativePoints(){
        int points = -1;
        player.setPointsInThisGame(points);
        assertEquals(player.getPointsInThisGame(), 10);
    }
    
    @Test
    public void addPointsInThisGameAddsPoints(){
        int points = 5;
        player.addPointsInThisGame(points);
        assertEquals(player.getPointsInThisGame(), 15);
    }
    
    @Test
    public void addPointsInThisGameWontAddNegativePoints(){
        int points = -5;
        player.addPointsInThisGame(points);
        assertEquals(player.getPointsInThisGame(), 10);
    }
    
    @Test
    public void addPointsInThisGameWontAddPointsBiggerThanTwelve(){
        int points = 13;
        player.addPointsInThisGame(points);
        assertEquals(player.getPointsInThisGame(), 10);
    }
    
    @Test
    public void toStringReturnsPlayersName(){
        assertEquals(player.toString(), "Testi-Tahvo");
    }
}
