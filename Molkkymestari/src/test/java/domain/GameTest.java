package domain;

import molkkymestari.domain.Game;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

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
    public void documentPointsFromThrowDocumentsWinnigThrowCorreclty() {
        onePlayerGame.getPlayerWithIndex(0).setPoints(49);
        onePlayerGame.documentPointsFromThrow(1);
        assertEquals(onePlayerGame.getPlayerWithIndex(0).getPoints(), 50);
    }
    
    @Test
    public void documentPointsFromThrowSetsTheWinnerFoundValue() {
        this.documentPointsFromThrowDocumentsWinnigThrowCorreclty();
        assertEquals(onePlayerGame.getWinnerFound(), true);
    }
    
    @Test
    public void documentPointsFromThrowSetsTheWinnerPlayer() {
        this.documentPointsFromThrowDocumentsWinnigThrowCorreclty();
        assertEquals(onePlayerGame.getWinner(), onePlayerGame.getPlayerWithIndex(0));
    }
    
    @Test
    public void documentPointsFromThrowAddsPoints() {
        onePlayerGame.documentPointsFromThrow(1);
        assertEquals(onePlayerGame.getPlayerWithIndex(0).getPoints(), 1);
    }
        
    
    @Test
    public void documentPointsFromThrowDocumentsBreakingPointLimitCorrectly() {
        onePlayerGame.getPlayerWithIndex(0).setPoints(49);
        onePlayerGame.documentPointsFromThrow(3);
        assertEquals(onePlayerGame.getPlayerWithIndex(0).getPoints(), 26);
    }
    
    @Test
    public void documentPointsFromThrowAddsPointsDocumentsAMissCorrectly() {
        onePlayerGame.documentPointsFromThrow(0);
        assertEquals(onePlayerGame.getPlayerWithIndex(0).getMissedThrowsInRow(), 1);
    }
    
    @Test
    public void getWhosNextReturnsZeroIfThereIsNoNextPlayer() {
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
    public void updateWhosTurnReuturnsToFirstIfThereIsNoNextPlayer() {
        game.updateWhosTurn();
        game.updateWhosTurn();
        assertEquals(game.getWhosTurnName(), "Testi-Timantti");
    }
            
    
    @Test
    public void pointLimitPassedSetsPointsToZeroIfThatSettingIsSelected() {
        game.setPointsToZeroWhenPointLimitPassed(true);
        game.getPlayerWithIndex(1).setPoints(49);
        game.pointLimitPassed(game.getPlayerWithIndex(1), 2);   
 
        assertEquals(game.getPlayerWithIndex(1).getPoints(), 0);
    }
    
    @Test
    public void pointLimitPassedDividesByHalfIfThatSettingIsSelected() {
        game.setPointsToZeroWhenPointLimitPassed(false);
        game.getPlayerWithIndex(0).setPoints(48);
        game.pointLimitPassed(game.getPlayerWithIndex(0), 4);
        
        assertEquals(game.getPlayerWithIndex(0).getPoints(), 26);
    }
    
    @Test
    public void missedThrowAddsOneIfThereAreLessThanTwoMissedThrows() {
        game.getPlayerWithIndex(1).setMissedThrowsInRow(1);
        game.missedThrow(game.getPlayerWithIndex(1));
        assertEquals(game.getPlayerWithIndex(1).getMissedThrowsInRow(), 2);
    }
    
    @Test
    public void thirdMissedThrowRemovesPlayer() {
        onePlayerGame.getPlayerWithIndex(0).setMissedThrowsInRow(2);
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
        assertEquals(game.getPointsToZeroWhenPointLimitPassed(), false);
    }
    
    @Test
    public void getWhosTurnIndexReturnsZeroInTheBeginning() {
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
        game.setPointsToZeroWhenPointLimitPassed(true);
        assertEquals(game.getPointsToZeroWhenPointLimitPassed(), true);
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
    
    @Test
    public void checkIfPlayerIsInTheGameReturnsTrueIfThereIsAlreadyPlayerWithThatName() {
        assertEquals(onePlayerGame.checkIfPlayerIsInTheGame("Testi-Tylsimys"), true);
    }
    
    @Test
    public void checkIfPlayerIsInTheGameReturnsFalseForoPlayers() {
        assertEquals(noPlayersGame.checkIfPlayerIsInTheGame("Testi-Tylsimys"), false);
    }
}
