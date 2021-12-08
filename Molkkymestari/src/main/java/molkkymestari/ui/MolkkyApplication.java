package molkkymestari.ui;

import molkkymestari.logic.MolkkyService;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

public class MolkkyApplication extends Application{
    private MolkkyService service;
    
    private Scene welcomeScene;
    private Scene gameSettingsScene;
    private Scene gameScene;
    private Scene winnerScene;
    
    private HBox topMenu;
    private Button toWelcomeScene;
    private Button toGameSettingsScene;
    private Button toGameScene;
    private Button closeMolkkymestari;     
    
    @Override
    public void init() throws Exception {
        service = new MolkkyService();
        toWelcomeScene = createLilacButton("Alkuun");
        toGameSettingsScene = createLilacButton("Peliasetukset");
        toGameScene = createLilacButton("Peli");
        closeMolkkymestari = createLilacButton("Sulje");   
    }
    
    @Override
    public void start(Stage window){
        // * Welcome-näkymän toimintoelementit            
        Label addedPlayers = createLabelForAddedPlayers();
        addedPlayers.setText(service.getPlayersToPrint());
        TextField addPlayersField = createTextFieldForAddingPlayers(); 
        Button savePlayer = createSavePlayerButton();
        Button newGame = createNewGameButton();
        
        // * Welcome-näkymän asettelu        
        VBox firstLayout = createFirstLayout(addedPlayers, addPlayersField, savePlayer, newGame);
        welcomeScene = new Scene(firstLayout);
        
        // ** GameSettings-näkymän toimintoelementit              
        Button pointLimitButton = createPointLimitButton();        
        Button pointLimitBrokenButton = createPinkButton("Pisteet puolitetaan pisterajan ylittyessä"); 
        Button startGameButton = createPinkButton ("Aloita peli");
        
        // ** GameSettings-näkymän asettelu     
        VBox gameSettingsLayout = createGameSettingsLayout(pointLimitButton, pointLimitBrokenButton, startGameButton);       
        gameSettingsScene = new Scene(gameSettingsLayout);   
        
        // *** Game-näkymän toimintoelementit     
        Label whosTurn = createLabelWithSettings(" ");
        Label whosTurnPoints = createLabelWithSettings("0");
        Label whosTurnNext = createLabelWithSettings(" ");                 
        TextField pointsToDocument = createTextFieldWithSettings();
        Button documentButton = createPinkButton("Kirjaa");
        
        // *** Game-näkymän asettelu
        VBox gameLayout = createGameLayout(whosTurn, whosTurnPoints, whosTurnNext, pointsToDocument, documentButton);
        gameScene = new Scene(gameLayout);
        
        
        // WelcomeScene-näkymän painikkeiden toiminnot
        newGame.setOnAction((event) -> {
            window.setScene(gameSettingsScene);
        });       
        
        savePlayer.setOnAction((event) -> {
            String name = addPlayersField.getText();
            service.addNewPlayer(name);
            addPlayersField.clear();
            addedPlayers.setText(service.getPlayersToPrint());
            
        });
        
        //GameSettingsScene-näkymän painikkeiden toiminnot        
        pointLimitButton.setOnAction((event ->{
            if(service.getPointLimit() == 50){
                service.setPointLimit(30);
                pointLimitButton.setText("30");
            } else if (service.getPointLimit() == 30){
                service.setPointLimit(50);
                pointLimitButton.setText("50");
            }
            
        }));
        
        pointLimitBrokenButton.setOnAction((event ->{
            if(service.getPointsToZeroWhenPointLimitPassedWithValue() == false){
                service.setPointsToZeroWhenPointLimitPassedWithValue(true);
                pointLimitBrokenButton.setText("Pisteet nollataan pisterajan ylittyessä");
            } else if(service.getPointsToZeroWhenPointLimitPassedWithValue() == true){
                service.setPointsToZeroWhenPointLimitPassedWithValue(false);
                pointLimitBrokenButton.setText("Pisteet puolitetaan pisterajan ylittyessä");
            }
            
        }));
        
        startGameButton.setOnAction((event) -> {
            window.setScene(gameScene);
            whosTurn.setText(service.getWhosTurnName());
            whosTurnNext.setText(service.getWhosNextName());
            
        });
        
        //GameScene-näkymän painikkeiden toiminnot        
        documentButton.setOnAction((event) -> {                   
            String pointsString = pointsToDocument.getText();
            service.documentThrow(Integer.valueOf(pointsString));
            
                
            if(service.getWinnerFound() == true) {    
                    
                  VBox winnerLayout = createWinnerLayout();
                  winnerScene = new Scene(winnerLayout);
                   
                  window.setScene(winnerScene);
                }                
                
                pointsToDocument.clear();
                
                whosTurnPoints.setText(service.getPlayersPointsWithIndex(service.getWhosTurnIndex()));
                whosTurn.setText(service.getWhosTurnName());
                whosTurnNext.setText(service.getWhosNextName()); 
             
                //Käsittely jos ei syötetä arvoa mutta napsautetaan?
                        
        });
        
        window.setTitle("Mölkkymestari");
        window.setScene(welcomeScene);
        window.show();       
        
    }
    
    public HBox createTopMenu() {
        topMenu = new HBox();
        topMenu.getChildren().addAll(toWelcomeScene, toGameSettingsScene, toGameScene, closeMolkkymestari);
        hBoxSettings(topMenu);
                
        return topMenu;
    }
    
    public VBox createFirstLayout(Label addedPlayers, TextField addPlayersField, Button savePlayer, Button newGame) {
        VBox firstLayout = new VBox();  
        
        HBox buttons = new HBox();
        buttons.getChildren().addAll(savePlayer, newGame);
        hBoxSettings(buttons);
        
        firstLayout.getChildren().addAll(createTopMenu(), createInfoTextForWelcomeView(), addedPlayers, addPlayersField, buttons);

        vBoxLayoutSettings(firstLayout); 
        return firstLayout;
    }
    
    public VBox createGameSettingsLayout(Button pointLimitButton, Button pointLimitBrokenButton, Button startGameButton ){      
        VBox gameSettingsLayout = new VBox();
        
        Label newGameText = createLabelWithSettings("UUSI PELI - asetukset");
        
        Label pointLimitLabel = createLabelWithSettings("Pisteraja");
        Label pointLimitBrokenLabel = createLabelWithSettings("Pisterajan ylittyessä");
        
        HBox gameSettingsLabels = new HBox();
        gameSettingsLabels.getChildren().addAll(pointLimitLabel, pointLimitBrokenLabel); 
        hBoxSettings(gameSettingsLabels);
        
        HBox gameSettingsButtons = new HBox();
        gameSettingsButtons.getChildren().addAll(pointLimitButton, pointLimitBrokenButton);
        hBoxSettings(gameSettingsButtons);
 
        gameSettingsLayout.getChildren().addAll(createTopMenu(), newGameText, gameSettingsLabels, gameSettingsButtons, startGameButton);
        
        vBoxLayoutSettings(gameSettingsLayout);
        
        return gameSettingsLayout;

    }
    
    public VBox createGameLayout(Label whosTurn, Label whosTurnPoints, Label whosTurnNext, TextField pointsToDocument, Button documentButton) {
        VBox gameLayout = new VBox();  
        
        Label whosTurnText = createLabelWithSettings("Pelivuorossa: ");
        Label whosTurnPointsText = createLabelWithSettings(", pisteet:  ");

        HBox whosTurnInfo = new HBox();       
        whosTurnInfo.getChildren().addAll(whosTurnText, whosTurn, whosTurnPointsText, whosTurnPoints);
        
        pointsToDocument.setStyle("-fx-background-color: #e6d0dc;"); 
        
        
        Label whosNextText = createLabelWithSettings("Seuraavana vuorossa: ");
        HBox whosNextInfo = new HBox();
        whosNextInfo.getChildren().addAll(whosNextText, whosTurnNext);
                
        gameLayout.getChildren().addAll(createLabelWithSettings("Mölkky meneillään"), whosTurnInfo, pointsToDocument, documentButton, whosNextInfo);
                
        vBoxLayoutSettings(gameLayout);
        return gameLayout;
    }
    
    public VBox createWinnerLayout() {
        VBox winnerLayout = new VBox();
        vBoxLayoutSettings(winnerLayout);
                  
        Label winnerFoundText = createLabelWithSettings("VOITTAJA ON:");
        Label winnersName = createLabelWithSettings("");
        winnersName.setText(service.getWinnerName());
                  
        VBox playerPointTable = createPlayerPointTable();
                  
        winnerLayout.getChildren().addAll(winnerFoundText, winnersName);
                   
        winnerLayout.getChildren().add(playerPointTable);
        return winnerLayout;          
    }
    
    public Label createInfoTextForWelcomeView() {
        Label infotext = createLabelWithSettings("Tervetuloa! Syötä ja tallenna ainakin yhden pelaajan nimi "
                + "kenttään ja aletaan pelaamaan :-)" + "\n" + "Pelaajat:");       
        return infotext;
    }
    
    public Label createLabelForAddedPlayers() {
        Label playersAdded = new Label();      
        return playersAdded;
    }
    
    public TextField createTextFieldForAddingPlayers() {
        TextField nameField = createTextFieldWithSettings();
        nameField.setStyle("-fx-background-color: #e6d0dc;");       
        return nameField;
        
    }
    
    public Button createSavePlayerButton() {
        Button savePlayer = createPinkButton("Tallenna pelaaja");        
        return savePlayer;
    }
    
    public Button createNewGameButton() {
       Button newGame = createPinkButton("Aloita peli");
       return newGame;

    }
    
    public Button createPointLimitButton() {
        Button pointLimitButton = createPinkButton("");
        pointLimitButton.setText("" + service.getPointLimit());
        return pointLimitButton;
    }
    
    public void vBoxLayoutSettings(VBox VBox){
        VBox.setPrefSize(800, 800);
        VBox.setSpacing(30);
    }
    public void labelSettings(Label label){
        label.setMinWidth(50); 
    }
    public TextField createTextFieldWithSettings(){
        TextField textField = new TextField();
        textField.setPrefSize(50, 80);
        return textField;
    }
    
    public Label createLabelWithSettings(String text){
        Label label = new Label(text);
        return label;
    }
    
    public void hBoxSettings(HBox HBox){
        HBox.setSpacing(100);
    }
    
    public Button createGrayButton(String text){
        Button button = new Button(text);
        button.setStyle("-fx-background-color: #BBBBBB; ");
        return button;
    }
    public Button createPinkButton(String text){
        Button button = new Button(text);
        button.setStyle("-fx-background-color: #D76FB0; ");
        return button;
    }
    public Button createLilacButton(String text){
        Button button = new Button(text);
        button.setStyle("-fx-background-color: #DDAADD; ");
        return button;
    }    
     
    public VBox createPlayerPointTable(){
        VBox playerPoints = new VBox();
        playerPoints.getChildren().add(createLabelWithSettings("Pistetaulukko"));
        for(int index = 0; index < service.getHowManyPlayers(); index ++) {
            
            playerPoints.getChildren().add(new Label (service.getPlayersNameWithIndex(index) + ": " + service.getPlayersPointsWithIndex(index)));
                     
        }
        
        return playerPoints;
    }  
}