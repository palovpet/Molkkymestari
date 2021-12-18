package molkkymestari.ui;

import java.io.IOException;
import molkkymestari.logic.MolkkyService;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * Class provides methods for the GUI of Mölkkymestari, which allows the end user
 * to edit and view game settings, players, and document the throws. Class has
 * five Scenes that each provide different functionalities. 
 */
public class MolkkyApplication extends Application{
    private MolkkyService service;
    private Scene staticsOrNewGame;
    private Scene addPlayersScene;
    private Scene gameSettingsScene;
    private Scene gameScene;
    private Scene winnerScene;  
    
    public static void main(String[] args) {  
        launch(MolkkyApplication.class);
    }
    
    /**
     * Method makes the needed preparations for the launching of the GUI
     * @throws Exception 
     */
    @Override
    public void init() throws Exception {
        service = new MolkkyService();   
    }
    
    /**
     * Method creates the visual GUI of the application
     * @param window
     * @throws IOException 
     */
    @Override
    public void start(Stage window) throws IOException {   
        // ELEMENTIT JA ASETTELU
        // 1: AddPlayers-näkymän toimintoelementit      
        Label addedPlayers = new Label();
        addedPlayers.setText(service.getPlayersToPrint());
        addedPlayers.setMinSize(200, 200);
        
        TextField addPlayersField = new TextField();
        addPlayersField.setStyle("-fx-background-color: #e6d0dc;");
        addPlayersField.setMinSize(150, 50);
        addPlayersField.setMaxSize(300, 100);
        
        Button savePlayer = createLilacButton("Tallenna pelaaja"); 
        Button toSettingsButton = createPinkButton("Peliasetuksiin");
  
        // 1: AddPlayers-näkymän asettelu        
        VBox addPlayersLayout = createAddPlayersLayout(window, addedPlayers, 
                addPlayersField, savePlayer, toSettingsButton);
        addPlayersScene= new Scene(addPlayersLayout);
        
        // 2: GameSettings-näkymän toimintoelementit         
        Button pointLimitButton = 
                createLilacButton("Pisteraja: " + service.getPointLimit());      
        Button pointLimitBrokenButton = 
                createLilacButton("Pisteet puolitetaan pisterajan ylittyessä"); 
        Button startGameButton = 
                createPinkButton ("Aloita peli");
        Button addMorePlayersButton = 
                createPinkButton("Palaa lisäämään pelaajia");
        
        // 2: GameSettings-näkymän asettelu     
        VBox gameSettingsLayout = createGameSettingsLayout(window, pointLimitButton, 
                pointLimitBrokenButton, startGameButton, addMorePlayersButton);       
        gameSettingsScene = new Scene(gameSettingsLayout);   
        
        // 3: Game-näkymän toimintoelementit     
        Label whosTurn = new Label(" ");
        Label whosTurnPoints = new Label("0");
        Label whosTurnNext = new Label(" ");                 
        TextField pointsToDocument = new TextField();
        Button documentButton = createLilacButton("Kirjaa");
        
        // 3: Game-näkymän asettelu
        VBox gameLayout = createGameLayout(window, whosTurn, whosTurnPoints, 
                whosTurnNext, pointsToDocument, documentButton);
        gameScene = new Scene(gameLayout);    
        
        //ELEMENTTIEN TOIMINNOT        
        // 1: AddPlayers-näkymän painikkeiden toiminnot
        toSettingsButton.setOnAction((event) -> {
            window.setScene(gameSettingsScene);
        });       
        
        savePlayer.setOnAction((event) -> {
            String name = addPlayersField.getText();
           
            if(name.matches("[a-zA-Z0-9]{3,20}")) {
                service.addNewPlayer(name);
                addPlayersField.clear();
                addedPlayers.setText(service.getPlayersToPrint());
            } else {
                addPlayersField.setText("Anna kunnollinen nimi!");
            }
            
            
        });
        
        //2: GameSettings-näkymän painikkeiden toiminnot        
        pointLimitButton.setOnAction((event ->{
            if(service.getPointLimit() == 50){
                service.setPointLimit(30);
                pointLimitButton.setText("Pisteraja: 30");
            } else if (service.getPointLimit() == 30){
                service.setPointLimit(50);
                pointLimitButton.setText("Pisteraja: 50");
            }
            
        }));
        
        pointLimitBrokenButton.setOnAction((event ->{
            if(service.getPointsToZeroWhenPointLimitPassed() == false){
                service.setPointsToZeroWhenPointLimitPassed(true);
                pointLimitBrokenButton.setText("Pisteet nollataan "
                        + "pisterajan ylittyessä");
            } else if(service.getPointsToZeroWhenPointLimitPassed() == true){
                service.setPointsToZeroWhenPointLimitPassed(false);
                pointLimitBrokenButton.setText("Pisteet puolitetaan "
                        + "pisterajan ylittyessä");
            }
            
        }));
        
        startGameButton.setOnAction((event) -> {
            window.setScene(gameScene);
            whosTurn.setText(service.getWhosTurnName());
            whosTurnNext.setText(service.getWhosNextName());
            
        });
        
        addMorePlayersButton.setOnAction((event) -> {
            window.setScene(addPlayersScene);
        });
        
        //3: Game-näkymän painikkeiden toiminnot
        
        documentButton.setOnAction((event) -> { 
            if (service.getHowManyPlayers() == 0) {
                pointsToDocument.setText("Pelaajat puuttuu! Palaa alkuun.");
                return;
            }
            
            String pointsString = pointsToDocument.getText();
            service.documentThrow(pointsString);
                
            if(service.getWinnerFound() == true) { 
                    
                  VBox winnerLayout = createWinnerLayout(window);
                  winnerScene = new Scene(winnerLayout);
                  window.setScene(winnerScene);              
                }                
                
                pointsToDocument.clear();                
                whosTurnPoints.setText
        (service.getPlayersPointsWithIndex(service.getWhosTurnIndex()));
                whosTurn.setText(service.getWhosTurnName());
                whosTurnNext.setText(service.getWhosNextName()); 
                        
        }); 
        
        VBox selectionsLayout
                = createStaticsOrNewGameScreen(window, addedPlayers, 
                pointLimitButton, pointLimitBrokenButton, whosTurn, whosTurnPoints, 
                whosTurnNext, pointsToDocument);
        
        staticsOrNewGame = new Scene(selectionsLayout);
        window.setTitle("Mölkkymestari");
        window.setScene(staticsOrNewGame);
        window.show();
        
    }    
    
    /**
     * Method for closing the whole application.
     */
    public void close() {
        Platform.exit();
    }
    
    /**
     * Method creates the first Scene that is shown to end user.Shows a logo
     * and with the click of a button the player can start a new game.
     * @param window
     * @param addedPlayers
     * @param pointLimitButton
     * @param pointLimitBrokenButton
     * @param whosTurn
     * @param whosTurnPoints
     * @param whosTurnNext
     * @param pointsToDocument
     * @return VBox layout for the staticsOrNewGame-Scene
     * @throws IOException 
     */
    public VBox createStaticsOrNewGameScreen(Stage window, Label addedPlayers, 
            Button pointLimitButton, Button pointLimitBrokenButton, Label whosTurn, 
            Label whosTurnPoints, Label whosTurnNext, TextField pointsToDocument) 
            throws IOException  {
        
        VBox staticsOrNewGameLayout = new VBox();
        vBoxLayoutSettings(staticsOrNewGameLayout);       
        Button newGame = createPinkButton("Uusi peli");
        Button statics = createGrayButton("Tulokset");     
        Image bigLogoImage = new Image("file:logo.png");
        ImageView bigLogoImageView = new ImageView(bigLogoImage); 
 
        staticsOrNewGameLayout.getChildren().add(bigLogoImageView);
        staticsOrNewGameLayout.getChildren().addAll(newGame, statics);
        
        newGame.setOnAction((event)-> {
            service = new MolkkyService();
            resetButtonsForNewGame(addedPlayers, pointLimitButton, 
                    pointLimitBrokenButton, whosTurn, whosTurnPoints, whosTurnNext, 
                    pointsToDocument);          
            
            window.setScene(addPlayersScene);
        });
        
        return staticsOrNewGameLayout;
    }
    
    /**
     * Creates the Scene used for adding the players to this game of Mölkky. 
     * With the click of a button end user can access the settings screen.
     * @param window
     * @param addedPlayers
     * @param addPlayersField
     * @param savePlayer
     * @param newGame
     * @return VBox layout for the addPlayers-Scene
     */
    public VBox createAddPlayersLayout(Stage window, Label addedPlayers, 
            TextField addPlayersField, Button savePlayer, Button newGame) {
        VBox AddPlayersLayout = new VBox();        
        Label logo = createLogo();       
        HBox buttons = new HBox();
        
        buttons.getChildren().addAll(savePlayer, newGame);
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(30);
                
        addedPlayers.setPadding(new Insets (20, 20, 20, 20));
        
        AddPlayersLayout.getChildren().addAll(logo, new Label 
        ("Lisää Mölkkyyn osallistuvat 1-10 pelaajaa yksitellen kenttään, "
                + "tallenna napsauttamalla Tallenna pelaaja -painiketta.\n"
                + "Nimimerkissä voi sisältää kirjaimia ja numeroita, sen on "
                + "oltava 3 - 20 merkkiä pitkä."
                + "\n\nPelaajat:\n"), addedPlayers, addPlayersField, buttons);

        vBoxLayoutSettings(AddPlayersLayout); 
        return AddPlayersLayout;
    }
    
    /**
     * Method for creating the Scene for game settings. Has buttons for changing
     * the point limit of the game and the action that is performed if the
     * point limit is passed with a throw.
     * @param window
     * @param pointLimitButton
     * @param pointLimitBrokenButton
     * @param startGameButton
     * @param addMorePlayersButton
     * @return VBox layout for the gameSetting -Scene
     */
    public VBox createGameSettingsLayout(Stage window, Button pointLimitButton, 
            Button pointLimitBrokenButton, Button startGameButton, 
            Button addMorePlayersButton){      
        
        VBox gameSettingsLayout = new VBox();       
        Label logo = createLogo();      
        Label newGameText = new Label("Peliasetukset");
 
        gameSettingsLayout.getChildren().addAll(logo, newGameText, pointLimitButton, 
                pointLimitBrokenButton, addMorePlayersButton, startGameButton);
        
        vBoxLayoutSettings(gameSettingsLayout);
        
        return gameSettingsLayout;

    }
    
    /**
     * Method for creating the Scene for the game-screen. Shows which players turn 
     * it is at that current time and their points that far. In the field the
     *  end user documents the points from that players throw as a number between 
     * 0-12. Below the point documentation field the next players name is shown.
     * @param window
     * @param whosTurn
     * @param whosTurnPoints
     * @param whosTurnNext
     * @param pointsToDocument
     * @param documentButton
     * @return VBox layout for the gameLayout -Scene
     */
    public VBox createGameLayout(Stage window, Label whosTurn, Label whosTurnPoints, 
            Label whosTurnNext, TextField pointsToDocument, 
        Button documentButton) {
        VBox gameLayout = new VBox();         
        Label logo = createLogo();       
        Label whosTurnText = new Label("Pelivuorossa: ");
        Label whosTurnPointsText = new Label(" - pisteet:  ");
        whosTurn.setTextFill(Color.web("ef2684", 0.8)); 
        whosTurnPoints.setTextFill(Color.web("ef2684", 0.8)); 
        
        HBox whosTurnInfo = new HBox();      
        whosTurnInfo.setAlignment(Pos.CENTER);
        whosTurnInfo.getChildren().addAll(whosTurnText, whosTurn, 
                whosTurnPointsText, whosTurnPoints);
        
        
        pointsToDocument.setStyle("-fx-background-color: #ecd4f8"); 
        pointsToDocument.setMinSize(150, 50);
        pointsToDocument.setMaxSize(300, 100);
        
        Label whosNextText = new Label("Seuraavana vuorossa: ");
        HBox whosNextInfo = new HBox();
        whosNextInfo.setAlignment(Pos.CENTER);
        whosTurnNext.setTextFill(Color.web("ef2684", 0.8)); 
        whosNextInfo.getChildren().addAll(whosNextText, whosTurnNext);
        
        Button closeAndStartNewGame = createPinkButton("Lopeta peli ja palaa alkuun");  
        closeAndStartNewGame.setOnAction((event)-> {
            window.setScene(staticsOrNewGame);           
        });  
           
        gameLayout.getChildren().addAll(logo, whosTurnInfo, pointsToDocument, 
                documentButton, whosNextInfo, closeAndStartNewGame);
                
        vBoxLayoutSettings(gameLayout);
        return gameLayout;
    }
    
    /**
     * Method for creating the Scene used to show the winner of the game.
     * Has the name of the winner and the points of all the players in that game.
     * @param window
     * @return VBox layout for the winner-Scene
     */
    public VBox createWinnerLayout(Stage window) {
        VBox winnerLayout = new VBox();
        vBoxLayoutSettings(winnerLayout);     
        Label logo = createLogo();               
        Label winnerFoundText = new Label("PELIN VOITTAJA:");       
        Label winnersName = new Label("");
        
        winnersName.setText(service.getWinnerName());       
        winnersName.setFont(new Font("impact", 35));
        winnersName.setTextFill(Color.web("e91bd4", 0.8)); 
        
        Label playerPointTable = createPlayerPointTable();        
            
        Button closeMolkkymestari = new Button("Sulje");
        closeMolkkymestari.setStyle("-fx-background-color: #B475A9; ");
        
        closeMolkkymestari.setOnAction((event)-> {
            close();
        });
        
        Button closeAndStartNew = createPinkButton("Lopeta peli ja palaa alkuun");  
        closeAndStartNew.setOnAction((event)-> {
            window.setScene(staticsOrNewGame);           
        });   
            
        winnerLayout.getChildren().addAll(logo, winnerFoundText, winnersName, 
                playerPointTable, closeAndStartNew, closeMolkkymestari);
                   
        return winnerLayout;          
    }
    
    /**
     * Method that creates the Mölkkymestari logo.
     * @return logo as a Label object
     */
    public Label createLogo() {
        Label logoLabel = new Label("Mölkkymestari");        
        logoLabel.setFont((new Font("Impact", 32)));
        logoLabel.setTextFill(Color.web("712a95", 0.8)); 
        
        return logoLabel;      
    }
    
    /**
     * Method creates the visualization of each player who was in the game
     * when it ended. Shows the name and the points they got in the game.
     * @return 
     */
    public Label createPlayerPointTable(){
        String playersAndPoints = "";
                
        for(int index = 0; index < service.getHowManyPlayers(); index ++) {           
            playersAndPoints = playersAndPoints + "\n" + 
                    service.getPlayersNameWithIndex(index) + ": " + 
                    service.getPlayersPointsWithIndex(index);
        }
        playersAndPoints = "Pistetaulukko" + playersAndPoints;     
        Label playerPoints = new Label(playersAndPoints);
        
        return playerPoints;
    }  
    
    /**
     * Method used to give correct visual settings for all of the Layout VBoxes 
     * that are used in Scenes.
     * @param VBox 
     */
    public void vBoxLayoutSettings(VBox VBox){
        VBox.setPrefSize(800, 500);
        VBox.setAlignment(Pos.TOP_CENTER);
        VBox.setSpacing(30);
    }
    
    /**
     * MEthod for creating a gray button. Gray button represents a button that
     * doesn't have a functionality in it yet.
     * @param text text in the button
     * @return gray Button-object
     */
    public Button createGrayButton(String text){
        Button button = new Button(text);
        button.setStyle("-fx-background-color: #BBBBBB; ");
        
        return button;
    }
    
    /**
     * Method for creating a pink button. Pink button represents a button that
     *  changes a Scene once clicked.
     * @param text in the button
     * @return pink Button-object
     */
    public Button createPinkButton(String text){
        Button button = new Button(text);
        button.setStyle("-fx-background-color: #D76FB0; ");
        
        return button;
    }
    
    /**
     * Method for creating a lilac button. Lilac button represents a button that
     * has a functionality in the scene where it is.
     * @param text in the button
     * @return lilac Button-object
     */
    public Button createLilacButton(String text){
        Button button = new Button(text);
        button.setStyle("-fx-background-color: #DDAADD; ");
        
        return button;
    }

    /**
     * Method is used to clear all Button-, Label- and TextField -objects that 
     * contain information about the game that ended, in the event of player 
     * choosing to start a new game after the first one, 
     * without closing the application.
     * @param addedPlayers 
     * @param pointLimitButton
     * @param pointLimitBrokenButton
     * @param whosTurn
     * @param whosTurnPoints
     * @param whosTurnNext
     * @param pointsToDocument 
     */
    public void resetButtonsForNewGame(Label addedPlayers, Button pointLimitButton, 
            Button pointLimitBrokenButton, Label whosTurn, Label whosTurnPoints, 
            Label whosTurnNext, TextField pointsToDocument) {
        addedPlayers.setText("");
        pointLimitButton.setText("Pisteraja: " + service.getPointLimit()); 
        pointLimitBrokenButton.setText("Pisteet puolitetaan pisterajan ylittyessä"); 
        whosTurn.setText("");
        whosTurnPoints.setText("0");
        whosTurnNext.setText("");   
        pointsToDocument.setText("");
    }
}