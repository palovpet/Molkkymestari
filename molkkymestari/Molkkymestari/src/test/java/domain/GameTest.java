
package domain;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class GameTest {
    
    Game game;

    @Before
    public void setUp() {
        game = new Game();
    }
    
    @Test
    public void newGameHasDefaultSettingOfPointsGoingToHalf(){
        assertEquals(game.pointsToZeroWhenPointLimitPassed, false);
        
    }

}
