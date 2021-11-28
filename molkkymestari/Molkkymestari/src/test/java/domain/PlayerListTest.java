package domain;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerListTest {
    
    PlayerList list;
    
    @Before
    public void setUp() {
        list = new PlayerList();
        list.addNewPlayer("Testi-Tinze");
        list.addNewPlayer("Testi-Tuure");
        
        
    }
    @Test
    public void getHowManyPlayersReturnsNumberOfPlayers(){
        assertEquals(list.getHowManyPlayers(), 2);
    }
    
    @Test
    public void addNewPlayerAddsPlayersToList(){
       list.addNewPlayer("Testi-Tauno");
       assertEquals(list.getHowManyPlayers(), 3);
    }
    
    
    
    
    
}
