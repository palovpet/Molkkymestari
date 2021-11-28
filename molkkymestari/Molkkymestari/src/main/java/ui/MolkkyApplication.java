package ui;

import molkkymestari.MolkkyService;
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
    
    @Override
    public void init(){
        service = new MolkkyService();
        
    }
    
    @Override
    public void start(Stage window){
        window.setTitle("Mölkkymestari");
        
        // * Painikkeet eri näkymille ja sulkemiselle
        
        /*Button GameSettingsLayoutButton = createLilacButton("Peliasetukset");
        Button GameViewButton = createLilacButton("Pelinäkymä");
        Button CloseGameButton = createLilacButton("Sulje");*/
       

        // *1 Ensimmäinen näkymä ja scene
        VBox firstLayout = new VBox();  
        vBoxLayoutSettings(firstLayout); 
        Scene welcomeView = new Scene(firstLayout);
        
        // ** Luo ja lisää infotekstin ja nimimerkkikentän 
        
        Label infotext = createLabelWithSettings("Tervetuloa! Syötä ja tallenna ainakin yhden pelaajan nimi "
                + "kenttään ja aletaan pelaamaan :-)" + "\n" + "Pelaajat:");
        Label playersAdded = new Label();
        
        playersAdded.setText(service.getPlayersToPrint());
        
        TextField nameField = createTextFieldWithSettings();
        nameField.setStyle("-fx-background-color: #e6d0dc;");
               
        VBox infoAndField = new VBox();
        infoAndField.setSpacing(50);
        
        addLabelToVBox(infoAndField, infotext, playersAdded);
        addTextFieldToVBox(infoAndField, nameField);
        firstLayout.getChildren().add(infoAndField);
       
        // ** Luo ja lisää painikkeet
        Button newPlayer = createPinkButton("Tallenna pelaaja");        
        Button newGame = createPinkButton("Aloita peli");
     
        firstLayout.getChildren().add(createHBoxWithButtons(newPlayer, newGame));        

        // *2 Uusi peli + asetukset -näkymä 
        VBox gameSettingsLayout = new VBox();    
                     
        
        
        // ** Näkymän otsikko   
        Label newGameText = createLabelWithSettings("UUSI PELI - asetukset");
         
        // ** Asetusten otsikot
        Label pointLimitLabel = createLabelWithSettings("Pisteraja");
        Label pointLimitBrokenLabel = createLabelWithSettings("Pisterajan ylittyessä");

        HBox gameSettingsLabels = createHBoxWithLabels(pointLimitLabel, pointLimitBrokenLabel);  
        
        // ** Asetusten painikkeet
        Button pointLimitButton = createPinkButton("");
        pointLimitButton.setText("" + service.getPointLimit());
        
        //1 Nappi jonka tekstiä muutetaan, taphtumankäsittelijään if-lause
        
        Button pointLimitBrokenButton = createPinkButton("Pisteet puolitetaan pisterajan ylittyessä");         
        
        HBox gameSettingsButtons = createHBoxWithButtons(pointLimitButton, pointLimitBrokenButton);
        
        // **Aloita peli-painike
        Button startGameButton = createPinkButton ("Aloita peli");
        
        // ** Lisää rompe näkymään ja luo scene
        
        createGameSettingsLayout(gameSettingsLayout, newGameText, gameSettingsLabels, gameSettingsButtons, startGameButton);       
        
        Scene GameSettingsView = new Scene(gameSettingsLayout);       
        
        // *3 Pelinäkymä 
        VBox GameLayout = new VBox();  
        vBoxLayoutSettings(GameLayout);
        
        // ** Pelivuoron tiedot 
        Label whosTurnText = createLabelWithSettings("Pelivuorossa:");
        Label whosTurn = createLabelWithSettings(" ");
        
        Label whosTurnPoints = createLabelWithSettings(" ");
        
               
        // ** Pisteiden kirjaaminen
        addLabelToVBox(GameLayout, createLabelWithSettings("Kirjaa heitto:"));   
        TextField pointsToDocument = createTextFieldWithSettings();

        Button documentButton = createPinkButton("Kirjaa");
        
        Label whosTurnNextText = createLabelWithSettings("Seuraavana vuorossa:");
        Label whosTurnNext = createLabelWithSettings(" ");
        
        //** Pelinäkymän rompe lisätty ja uusi scene
        addLabelToVBox(GameLayout, whosTurnText, whosTurn, whosTurnPoints);
        addTextFieldToVBox(GameLayout, pointsToDocument);
        addLabelToVBox(GameLayout, whosTurnNextText, whosTurnNext);
        addButtonsToVBox(GameLayout, documentButton);

        Scene GameView = new Scene(GameLayout);
        
        
        
        
        
        // * Painikkeiden toiminnot
        newGame.setOnAction((event) -> {
            window.setScene(GameSettingsView);
        });
        
        
        
        newPlayer.setOnAction((event) -> {
            String name = nameField.getText();
            service.addNewPlayer(name);
            nameField.clear();
            playersAdded.setText(service.getPlayersToPrint());
            
        });
        
        pointLimitButton.setOnAction((event ->{
            if(service.getPointLimit() == 50){
                service.changePointLimitToThirty();
                pointLimitButton.setText("30");
            } else if (service.getPointLimit() == 30){
                service.changePointLimitToFifty();
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
            window.setScene(GameView);
            whosTurn.setText(service.getWhosTurnName());
            whosTurnNext.setText(service.getWhosNextName());
            
        });
        
        documentButton.setOnAction((event ->{ 
            String pointsString = pointsToDocument.getText();
            
            service.documentThrow(Integer.valueOf(pointsString));
            pointsToDocument.clear();
            
            whosTurnPoints.setText(service.getTheCurrentPlayersPoints());
            whosTurn.setText(service.getWhosTurnName());
            whosTurnNext.setText(service.getWhosNextName());
            //Käsittely jos ei syötetä arvoa mutta napsautetaan?
            
        }));
        
        window.setScene(welcomeView);
        window.show();       
        
    }
    
    public void addButtonsToVBox(VBox VBox, Button button1){
        VBox.getChildren().add(button1);     
    }
    
    public void addButtonsToVBox(VBox VBox, Button button1, Button button2){
        this.addButtonsToVBox(VBox, button1);
        this.addButtonsToVBox(VBox, button2);     
    }
    
    public void addButtonsToVBox(VBox VBox, Button button1, Button button2, Button button3){
        this.addButtonsToVBox(VBox, button1);
        this.addButtonsToVBox(VBox, button2);
        this.addButtonsToVBox(VBox, button3);    
    }
    
    public void addButtonsToHBox(HBox HBox, Button button1){
        HBox.getChildren().add(button1);     
    }
    
    public void addButtonsToHBox(HBox HBox, Button button1, Button button2){
        this.addButtonsToHBox(HBox, button1);
        this.addButtonsToHBox(HBox, button2);     
    }
    
    public void addButtonsToHBox(HBox HBox, Button button1, Button button2, Button button3){
        this.addButtonsToHBox(HBox, button1);
        this.addButtonsToHBox(HBox, button2);
        this.addButtonsToHBox(HBox, button3);    
    }
    
    public void addLabelToVBox(VBox VBox, Label label1){
        VBox.getChildren().add(label1);        
    }
    
    public void addLabelToVBox(VBox VBox, Label label1, Label label2){
        this.addLabelToVBox(VBox, label1);
        this.addLabelToVBox(VBox, label2); 
    }
    
    public void addLabelToVBox(VBox VBox, Label label1, Label label2, Label label3){
        this.addLabelToVBox(VBox, label1);
        this.addLabelToVBox(VBox, label2);
        this.addLabelToVBox(VBox, label3);     
    }
    public void addLabelToHBox(HBox HBox, Label label1){
        HBox.getChildren().add(label1);        
    }
    
    public void addLabelToHBox(HBox HBox, Label label1, Label label2){
        this.addLabelToHBox(HBox, label1);
        this.addLabelToHBox(HBox, label2); 
    }
    
    public void addLabelToHBox(HBox HBox, Label label1, Label label2, Label label3){
        this.addLabelToHBox(HBox, label1);
        this.addLabelToHBox(HBox, label2);
        this.addLabelToHBox(HBox, label3);     
    }    
    
    public void addTextFieldToVBox(VBox VBox, TextField field){
        VBox.getChildren().add(field);
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
    
    public void hBoxSettins(HBox HBox){
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
    
    public HBox createHBoxWithButtons(Button button1, Button button2){
        HBox HBox = new HBox();
        addButtonsToHBox(HBox, button1, button2);
        hBoxSettins(HBox);
        return HBox;
    }
    
    public HBox createHBoxWithButtons(Button button1, Button button2, Button button3, Button button4){
        HBox HBox = new HBox();
        addButtonsToHBox(HBox, button1, button2);
        addButtonsToHBox(HBox, button3, button4);
        hBoxSettins(HBox);
        return HBox;
    }
    
    public HBox createHBoxWithLabels(Label label1, Label label2){
        HBox HBox = new HBox();
        addLabelToHBox(HBox, label1, label2);
        hBoxSettins(HBox);
        return HBox;
    }
    
    public void createGameSettingsLayout(VBox vBox, Label label1, HBox HBox1, HBox HBox2, Button button){           
        vBoxLayoutSettings(vBox);
        addLabelToVBox(vBox, label1);
        
        vBox.getChildren().add(HBox1);
        vBox.getChildren().add(HBox2);
        addButtonsToHBox(HBox2, button);

    }
    public void upDatePointLimitToFifty(MolkkyService service, Button button){
        service.changePointLimitToFifty();
        Button buttonToReturn = createGrayButton("30");
        
    }
    
    
}