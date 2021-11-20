/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author palovpet
 */
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
