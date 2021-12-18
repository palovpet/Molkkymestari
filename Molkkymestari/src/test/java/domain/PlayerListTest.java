package domain;

import molkkymestari.domain.PlayerList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerListTest {
    
    PlayerList list;
    PlayerList emptyList;
    
    @Before
    public void setUp() {
        list = new PlayerList();
        list.addNewPlayer("Testi-Tinze");
        list.addNewPlayer("Testi-Tuure");
        
        emptyList = new PlayerList();
    }
        
    @Test
    public void getPlayerWithIndexReturnsPlayer(){
        assertEquals(list.getPlayerWithIndex(0).toString(), "Testi-Tinze");
    }
    
    @Test
    public void getPlayersPointsInThisGameReuturnsPoints() {
        list.getPlayerWithIndex(0).setPoints(10);
        assertEquals(list.getPlayerWithIndex(0).getPoints(), 10);
    }
    
    @Test
    public void getPlayerWithNameReturnsPlayer() {
        list.addNewPlayer("Testi-Timppa");
        assertEquals(list.getPlayerWithName("Testi-Timppa").toString(), "Testi-Timppa");
    }
    
    @Test
    public void getPlayerWithNameReturnsNullIfNoPlayerIsFound() {
        assertEquals(emptyList.getPlayerWithName("Testi-Tämäeilöydy"), null);
    }   
    
    @Test
    public void getHowManyPlayersReturnsNumberOfPlayers(){
        assertEquals(list.getHowManyPlayers(), 2);
    }
    
    @Test
    public void getHowManyPointsPlayerHasReturnsPoints() {
        list.getPlayerWithIndex(0).setPoints(10);
        assertEquals(list.getPlayerWithIndex(0).getPoints(), 10);
    }
    
    @Test
    public void addNewPlayerAddsPlayersToList(){
       list.addNewPlayer("Testi-Tauno");
       assertEquals(list.getHowManyPlayers(), 3);
    }
    
    @Test
    public void toStringReturnsPlayersNamesOnTheirOwnRows() {
        assertEquals(list.toString(), "Testi-Tinze\nTesti-Tuure\n");        
    }
    
    @Test
    public void toStringReturnsInfoIfThereIsNoPlayers() {
        assertEquals(emptyList.toString(), "Ei pelaajia");        
    }
    
    @Test
    public void removePlayerRemovesAPlayer() {      
        list.removePlayer(list.getPlayerWithIndex(0));
        assertEquals(list.getHowManyPlayers(), 1);
    }
    
    
}
