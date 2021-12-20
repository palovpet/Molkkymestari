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
        player.setIndex(0);
        player.setMissedThrowsInRow(1);
        player.setPoints(10);
    }
    
    @Test
    public void getIndexReturnsIndex(){
        assertEquals(player.getIndex(), 0);
    }
    
    @Test
    public void setIndexSetsTheIndexIn(){
        player.setIndex(1);
        assertEquals(player.getIndex(), 1);
    }
    
    @Test
    public void setIndexWontSetNegativeIndex(){
        player.setIndex(-1);
        assertEquals(player.getIndex(), 0);
    }
    
    @Test
    public void getMissedThrowsReturnsMissedThrowse(){
        assertEquals(player.getMissedThrowsInRow(), 1);
    }
    
    @Test
    public void setMissedThrowsSetsMissedThrows(){
        int newValueForMissedThrows = 2;
        player.setMissedThrowsInRow(newValueForMissedThrows);
        assertEquals(player.getMissedThrowsInRow(), newValueForMissedThrows);
    }
    @Test
    public void setMissedThrowsWontSetNegativeMissedThrows(){
        player.setMissedThrowsInRow(-1);
        assertEquals(player.getMissedThrowsInRow(), 1);
    }
    
    @Test
    public void getPointsInGameReturnsPoints(){
        assertEquals(player.getPoints(), 10);
    }
    
    @Test
    public void setPointsSetsPoints(){
        player.setPoints(5);
        assertEquals(player.getPoints(), 5);
    }
    
    @Test
    public void setPointsWontSetNegativePoints(){
        player.setPoints(-1);
        assertEquals(player.getPoints(), 10);
    }
    
    @Test
    public void addPointsFromThrowAddsPoints(){
        player.addPoints(5);
        assertEquals(player.getPoints(), 15);
    }
    
    @Test
    public void toStringReturnsPlayersName(){
        assertEquals(player.toString(), "Testi-Tahvo");
    }
}
