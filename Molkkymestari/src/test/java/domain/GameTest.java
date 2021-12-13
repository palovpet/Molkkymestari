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
    public void documentPointsFromThrowDocumentAWinnigThrowCorreclty() {
        onePlayerGame.getPlayerWithIndex(0).setPointsInThisGame(49);
        onePlayerGame.documentPointsFromThrow(1);
        assertEquals(onePlayerGame.getPlayerWithIndex(0).getPointsInThisGame(), 50);
    }
    
    @Test
    public void documentPointsFromThrowSetsTheWinnerFoundValue() {
        this.documentPointsFromThrowDocumentAWinnigThrowCorreclty();
        assertEquals(onePlayerGame.getWinnerFound(), true);
    }
    
    @Test
    public void documentPointsFromThrowSetsTheWinnerPlayer() {
        this.documentPointsFromThrowDocumentAWinnigThrowCorreclty();
        assertEquals(onePlayerGame.getWinner(), onePlayerGame.getPlayerWithIndex(0));
    }
    
    @Test
    public void documentPointsFromThrowAddsPoints() {
        onePlayerGame.documentPointsFromThrow(1);
        assertEquals(onePlayerGame.getPlayerWithIndex(0).getPointsInThisGame(), 1);
    }
        
    
    @Test
    public void documentPointsFromThrowDocumentsBreakingAPointLimitCorrectly() {
        onePlayerGame.getPlayerWithIndex(0).setPointsInThisGame(49);
        onePlayerGame.documentPointsFromThrow(3);
        assertEquals(onePlayerGame.getPlayerWithIndex(0).getPointsInThisGame(), 26);
    }
    
    @Test
    public void documentPointsFromThrowAddsPointsDocumentsAMissCorrectly() {
        onePlayerGame.documentPointsFromThrow(0);
        assertEquals(onePlayerGame.getPlayerWithIndex(0).getMissedThrowsInThisGame(), 1);
    }
    
    @Test
    public void getWhosNextReturnsZeroIfThereIsNotNextPlayer() {
        game.updateWhosTurn();
        assertEquals(game.getWhosNextIndex(), 0);
    }
    
    @Test
    public void getWhosNextReturnsZeroWithOnePlayerGame() {
        assertEquals(onePlayerGame.getWhosNextIndex(), 0);
    }
    
    @Test
    public void updateWhosTurnAddsOneIfThereIsANextPlayer() {
        game.updateWhosTurn();
        assertEquals(game.getWhosTurnName(), "Testi-Timotei");
    }
    
    @Test
    public void updateWhosTurnReuturnsToFirstIfThereIsNotANextPlayer() {
        game.updateWhosTurn();
        game.updateWhosTurn();
        assertEquals(game.getWhosTurnName(), "Testi-Timantti");
    }
            
    
    @Test
    public void pointLimitPassedSetsPointsToZeroIfThatSettingIsSelected() {
        game.setPointsToZeroWhenPointLimitPassedWithValue(true);
        game.getPlayerWithIndex(1).setPointsInThisGame(49);
        game.pointLimitPassed(game.getPlayerWithIndex(1), 2);   
 
        assertEquals(game.getPlayerWithIndex(1).getPointsInThisGame(), 0);
    }
    
    @Test
    public void pointLimitPassedDividesByHalfIfThatSettingIsSelected() {
        game.setPointsToZeroWhenPointLimitPassedWithValue(false);
        game.getPlayerWithIndex(0).setPointsInThisGame(48);
        game.pointLimitPassed(game.getPlayerWithIndex(0), 4);
        
        assertEquals(game.getPlayerWithIndex(0).getPointsInThisGame(), 26);
    }
    
    @Test
    public void missedThrowAddsOneIfThereAreLessThanTwpMissedThrows() {
        game.getPlayerWithIndex(1).setMissedThrowsInThisGame(1);
        game.missedThrow(game.getPlayerWithIndex(1));
        assertEquals(game.getPlayerWithIndex(1).getMissedThrowsInThisGame(), 2);
    }
    
    @Test
    public void thirdMissedThrowRemovesPlayer() {
        onePlayerGame.getPlayerWithIndex(0).setMissedThrowsInThisGame(2);
        onePlayerGame.missedThrow(onePlayerGame.getPlayerWithIndex(0));
        assertEquals(onePlayerGame.getPlayerWithIndex(0), null);
    }
    
    @Test
    public void getPlayerWithIndexReturnsCorrectPlayer() {
        assertEquals(game.getPlayerWithIndex(0).toString(), "Testi-Timantti");
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
    public void getWhosNextReturnsIndexOneInTheBeginning() {
        assertEquals(game.getWhosNextIndex(), 1);
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
