/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author palovpet
 */
public class Player {
    String name;
    int pointsInThisGame;
    int indexInThisGame;
    int missedThrowsInThisGame;
   /* int points; 
Siirrä pisteiden muistaminen eri paikkaan, 
pelaaja luokka voisi muistaa statistiikkaan liittyviä tietoja */

/* Laajennusidea: pelaajalla joukkue */
    
    public Player(String name){
        this.name = name;   
    }

    public String getName() {
        return name;
    }
    public void addPointsInThisGame(int points){
        this.pointsInThisGame += points;
    }

    public int getPointsInThisGame() {
        return pointsInThisGame;
    }

    public int getIndexInThisGame() {
        return indexInThisGame;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPointsInThisGame(int pointsInThisGame) {
        this.pointsInThisGame = pointsInThisGame;
    }

    public void setIndexInThisGame(int indexInThisGame) {
        this.indexInThisGame = indexInThisGame;
    }

    public int getMissedThrowsInThisGame() {
        return missedThrowsInThisGame;
    }

    public void setMissedThrowsInThisGame(int missedThrowsInThisGame) {
        this.missedThrowsInThisGame = missedThrowsInThisGame;
    }
    
    
    
            
    
}
