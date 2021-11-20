/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author palovpet
 */
public class MolkkyApplication extends Application{
    
    @Override
    public void start(Stage window){
        window.setTitle("Mölkkymestari");
        

        //Ensimmäinen näkymä
        VBox firstLayout = new VBox();     
        firstLayout.setPrefSize(500, 500);
        firstLayout.setSpacing(30);
        
        //Infoteksti ja pelaajan nimikenttä
        Label infotext = new Label("Tervetuloa! Syötä pelaajan nimi "
                + "kenttään ja aletaan pelaamaan :-)");
        infotext.setMinWidth(50);       
        
        TextField nameField = new TextField();
        nameField.setPrefSize(50, 80);
        
        VBox infoAndField = new VBox();
        infoAndField.setSpacing(50);
        
        infoAndField.getChildren().add(infotext);
        infoAndField.getChildren().add(nameField);  
        
        //Painikkeet            
        Button newPlayer = new Button("Syötä lisää pelaajia");
        newPlayer.setStyle("-fx-background-color: #D76FB0; ");
        
        Button startGame = new Button("Aloita peli");
        startGame.setStyle("-fx-background-color: #D76FB0; ");
        
        HBox buttons = new HBox();
        buttons.getChildren().add(newPlayer);
        buttons.getChildren().add(startGame);
        buttons.setSpacing(100);
        
        firstLayout.getChildren().add(infoAndField);
        firstLayout.getChildren().add(buttons);

        
        //Tehdään näkymä uuden pelin aloitukseen
        VBox startGameLayout = new VBox();     
        startGameLayout.setPrefSize(500, 500);
        startGameLayout.setSpacing(30);
        
        //Otsikko
        Label newGameText = new Label("Uusi peli");
        newGameText.setMinWidth(50); 
        
        //Painikkeet
        Button pointLimitButton = new Button("30");
        pointLimitButton.setStyle("-fx-background-color: #D76FB0; ");
        Button pointLimitBrokenButton = new Button("Pisteet puolitetaan");
        pointLimitBrokenButton.setStyle("-fx-background-color: #D76FB0; ");
        
        HBox gameSettingsButtons = new HBox();
        gameSettingsButtons.getChildren().add(pointLimitButton);
        gameSettingsButtons.getChildren().add(pointLimitBrokenButton);  
        gameSettingsButtons.setSpacing(10);
        
        //Labelit
        Label pointLimitLabel = new Label("Pisteraja");
        pointLimitLabel.setMinWidth(50);
        Label pointLimitBrokenLabel = new Label("Pisterajan ylittyessä");
        pointLimitBrokenLabel.setMinWidth(50);

        HBox gameSettingsLabels = new HBox();
        gameSettingsLabels.getChildren().add(pointLimitLabel);
        gameSettingsLabels.getChildren().add(pointLimitBrokenLabel);
        gameSettingsLabels.setSpacing(10);
      
        startGameLayout.getChildren().add(newGameText);
        startGameLayout.getChildren().add(gameSettingsLabels);
        startGameLayout.getChildren().add(gameSettingsButtons);
        
        
        Scene startGameView = new Scene(startGameLayout);
        
                      
        //Näytetään ensimmäinen näkymä
        Scene welcomeView = new Scene(firstLayout);
        
        //Lisätään uuden pelin aloitus nappiin
        startGame.setOnAction((event) -> {
            window.setScene(startGameView);
        });
        

        window.setScene(welcomeView);
        window.show();
        
        
    }
    
    
}
