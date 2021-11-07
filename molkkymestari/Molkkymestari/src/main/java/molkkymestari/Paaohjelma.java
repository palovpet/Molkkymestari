/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molkkymestari;
import java.util.Scanner;


/**
 *
 * @author palovpet
 */
public class Paaohjelma {
    
       
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        mainMenu(reader);
               
        System.out.println("Anna valinta");
        String input = reader.nextLine();
            
            if(input.equals("X")){
                close();
            }
            else {
                mainMenu(reader);
                
            }           
        }  
    
    public static void mainMenu(Scanner reader){
        System.out.println("Mölkkymestari");
        System.out.println("Valikko");
        System.out.println("1: Aloita uusi peli");
        System.out.println("X: sulje");
        
        mainMenuSelection(reader);
        
    }
    
    public static void mainMenuSelection(Scanner reader){        
        if(reader.nextLine().equals("1")){
            newGame(reader);
        }
        
        if(reader.nextLine().equals("2")){
            close();
        }              
    }
    
    public static void close(){
        //sulkee koko pelin
        System.out.println("Heippa!");
    }
    
    public static void newGame(Scanner reader){
        System.out.println("Uusi peli");
        Game game = new Game();
        
        System.out.println("Vaihtoehdot:");        
        System.out.println("1: Vaihda pisterajaa");
        System.out.println("2: Nollaa pisteet jos pisteraja ylittyy");
        System.out.println("3: Lisää pelaajat");
        System.out.println("4: Takaisin päävalikkoon");
        
        int selection = Integer.valueOf(reader.nextLine());
        newGameSelection(selection);
        
    }
    
    public static void newGameSelection(int selection){
        
        if(selection==1){
            changePointLimit();
        }
        
        if(selection==2){
            changeWhatHappensIfPoinLimitIsPassed();
        }
        
        if(selection==3){
           addPlayers(); 
        }

    }
    
    public static void changePointLimit(){
        System.out.println("vaihtaa pisterajaa");
    }
    
    public static void changeWhatHappensIfPoinLimitIsPassed(){
        System.out.println("vaihtaa pisterajasta tapahtuvaa tapahtumaa");
    }
    
    public static void addPlayers(){
        System.out.println("lisää pelajat");
    
    }
    
}
    

