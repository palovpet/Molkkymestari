package molkkymestari.domain;

import java.util.ArrayList;

public class PlayerList {
    ArrayList<Player> players;
        
    public PlayerList() {
        
        this.players = new ArrayList<>();    
    }
    
    //Pelaajalistan toiminnot  
    public int getHowManyPlayers() {
        
        return this.players.size();
    } 
    
    public void addNewPlayer(String name) {
       
    //Lisää jokin tarkastus, jos sama nimi on jo käytössä
        Player newPlayer = new Player(name);
        this.players.add(newPlayer);
    
        int indexForThisGame = this.players.indexOf(newPlayer);
        newPlayer.setIndexInThisGame(indexForThisGame);        
        newPlayer.setPointsInThisGame(0);
        newPlayer.setMissedThrowsInThisGame(0);        
    }
    
    public void removePlayer(Player player) {
        this.players.remove(player.getIndexInThisGame());
            
    }
    
    public PlayerList updatePlayerList() {
    
        ArrayList<Player> updatedList = new ArrayList<>();
        for (int index = 0; index < this.players.size(); index ++) {
            
            Player playerToNewList = players.get(index);
            
            updatedList.add(playerToNewList);
            playerToNewList.setIndexInThisGame(index);
            
        }
        this.players = updatedList;
        PlayerList updatedPlayerList = new PlayerList();
        updatedPlayerList.players = updatedList;
        return updatedPlayerList;
            
    }
    
    //Pelaajien tiedot  
    public Player getPlayerWithIndex(int index) {   
        
        Player player = this.players.get(index);
        return player;
    }

    //Mahdollisesti turha, ellei käytä pelaajan nimen tarkistukseen
    public Player getPlayerWithName(String name) {
        
        int playersIndex = -1;
        for (int index = 0; index < this.players.size(); index++) {
                
            if (this.players.get(index).toString().equals(name)) {
                    
                playersIndex = index;
            }
        }
        if (playersIndex == -1) {
                
            return null;
        }
        return this.players.get(playersIndex);                       
    }

    @Override
    public String toString() {
        
        if (this.players.isEmpty()) {
            
            return "Ei pelaajia";
        } else {
            
            String printOut = "";
            for (int index = 0; index < this.players.size(); index++) {
                
                printOut = printOut + this.players.get(index) + "\n";
            }
            return printOut;
        }
    } 
    
}
