/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import molkkymestari.domain.Game;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author palovpet
 */
public class GameTest {   
    
    Game game;
    Game onePlayerGame;
    Game noPlayersGame;
  
    
    @Before
    public void setUp() {
        game = new Game();
        game.addNewPlayer("Testi-Timantti");
        game.addNewPlayer("Testi-Timotei");
        
        onePlayerGame = new Game();
        onePlayerGame.addNewPlayer("Testi-Tylsimys");
        
        noPlayersGame = new Game();
                
    }
    
    @Test
    public void getPointLimitReturnsPointLimit() {
        assertEquals(game.getPointLimit(), 50);
    }
    
    @Test
    public void getPointsToZeroWhenPointLimitPassedWithValueReturnsThat() {
        assertEquals(game.getPointsToZeroWhenPointLimitPassedWithValue(), false);
    }
    
    @Test
    public void getWhosTurnIndexReturnsThat() {
        assertEquals(game.getWhosTurnIndex(), 0);
    }
    
    @Test
    public void constructorWithIntValueGeneratesGameWithThatAsPointLimit(){
        Game newGame = new Game(25);
        assertEquals(newGame.getPointLimit(), 25);
    }
    
    @Test
    public void setPointLimitSetsThePointLimit() {
        game.setPointLimit(100);
        assertEquals(game.getPointLimit(), 100);
    }
    
    @Test
    public void setPointsToZeroWhenPointLimitPassedWithValueDoesThat() {
        game.setPointsToZeroWhenPointLimitPassedWithValue(true);
        assertEquals(game.getPointsToZeroWhenPointLimitPassedWithValue(), true);
    }
    
    @Test
    public void addNewPlayerAddsPlayer() {
        game.addNewPlayer("Testi-Taneli");
        assertEquals(game.getHowManyPlayers(), 3);
    }
    
    @Test
    public void getPlayersToStringReturnsPlayers() {
        game.addNewPlayer("Testi-Taneli");
        assertEquals(game.getPlayersToString(), "Testi-Timantti\nTesti-Timotei\nTesti-Taneli\n");
    }
    
    @Test
    public void getWinnerFoundReturnsFalseWhenGameBegins() {
        assertEquals(game.getWinnerFound(), false);
    }
    
    @Test
    public void getWhosTurnReturnsFirstPlayersNameInTheBeginning() {
        assertEquals(game.getWhosTurnName(), "Testi-Timantti");
    }
    
    @Test
    public void getWhosNextNameReturnsSecondPlayersNameInTheBeginning() {
        assertEquals(game.getWhosNextName(), "Testi-Timotei");
    }
    
    @Test
    public void getWhosNextNameReturnsCorrectInfoWithOnlyOnePlayer() {
        assertEquals(onePlayerGame.getWhosNextName(), "Vain yksi pelaaja");
    }
    
    @Test
    public void getWhosTurnNameReturnsCorrectInfoIfNoPlayersAreAdded() {
        assertEquals(noPlayersGame.getWhosTurnName(), "Ei pelaajia");
    }
    
    @Test
    public void getWhosNextNameReturnsCorrectInfoIfNoPlayersAreAdded() {
        assertEquals(noPlayersGame.getWhosNextName(), "Ei pelaajia");
    }
}
