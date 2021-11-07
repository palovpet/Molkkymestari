///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package molkkymestari;
//import java.util.Scanner;
//
///**
// *
// * @author palovpet
// */
//public class MolkkyService {
//    Scanner reader;
//    
//    public MolkkyService(){
//        this.reader = new Scanner(System.in);
//    }
//    
//    public static String getInputString(){
//    String input = reader.nextLine();
//    return input;
//    }
//    
//    public static int getInputInt(){
//    String inputString = getInputString();
//    int inputInt = Integer.valueOf(inputString);
//    return inputInt;
//    }
//   
//    public static void Launch(){
//        mainMenu();       
//    }
//    
//    public static void mainMenu(){
//        System.out.println("Mölkkymestari");
//        System.out.println("Valikko");
//        System.out.println("1: Aloita uusi peli");
//        System.out.println("2: sulje");
//        
//        if(getInputInt()==1){
//            newGame();
//        }
//        
//        if(getInputInt()==2){
//            close();
//        }
//        
//        
//    }
//    
//    public static void close(){
//        //sulkee koko pelin
//    }
//    
//    public static void newGame(){
//        System.out.println("Uusi peli");
//        Game game = new Game();
//        
//        System.out.println("Vaihtoehdot:");        
//        System.out.println("1: Vaihda pisterajaa");
//        System.out.println("2: Nollaa pisteet jos pisteraja ylittyy");
//        System.out.println("3: Lisää pelaajat");
//        
//        if(getInputInt()==1){
//            changePointLimit();
//        }
//        
//        if(getInputInt()==2){
//            changeWhatHappensIfPoinLimitIsPassed();
//        }
//        
//        if(getInputInt()==3){
//           addPlayers(); 
//        }
//    }
//    
//    public static void changePointLimit(){
//        //vaihtaa pisterajaa
//    }
//    
//    public static void changeWhatHappensIfPoinLimitIsPassed(){
//        //vaihtaa pisterajasta tapahtuvaa tapahtumaa
//    }
//    
//    public static void addPlayers(){
//        
//    }
//    
//}
