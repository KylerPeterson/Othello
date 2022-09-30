/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Kyler
 */
public class Game {
    private ArrayList<Player> players;
    private Board board;
    private Player currentPlayer;
    
    public Game(){
        initObjects();
           
    }

    private void initObjects(){
        board = new Board(); 
        createPlayers();
        board.setPlayers(players);
        setCurrentPlayer(players.get(Constants.PLAYER_ONE));
        printPlayers();
    }
    
    private void createPlayers(){
        players = new ArrayList<>(); 
        int i;
        Player x;
        String a;
        for(i = 0; i < Constants.MAX_PLAYERS; i++){
          a = JOptionPane.showInputDialog(null, "Enter player's name"); 
           x = new Player();
           x.setName(a);
           if( i == 0){
                x.setDiscolor(Constants.DARK);
                   }
           if( i == 1){
               x.setDiscolor(Constants.LIGHT);
           }
           players.add(x);
        }
        }
    private void printPlayers(){
        System.out.println("The game has the following players:");
        
        for (Player x : players) {
            System.out.println( x.getName()+" is playing disc color " + x.getDiscolor());
        }
    }
    /* The above code goes through setting up the players and their colors based on
    which player position they are. The for loop goes through each player, and then 
    uses the if statement within to set up the players properly, i.e. If player 1 then color is 
    black. If player 2 then color is white. In printplayers we are having the user
    add in the information and taking what they gave us and combining it with the previous code to tell
    the user what the players names are and their colors.
    */
    /**
     * @return the board
     */
    public Board getBoard() {
        return board;
    }

    /**
     * @param board the board to set
     */
    public void setBoard(Board board) {
        this.board = board;
    }

    /**
     * @return the players
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * @param players the players to set
     */
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
    
    public void calculateScore(){
    
        board.calculateScore();
        players.get(Constants.PLAYER_ONE).setScore(board.getDarkCount());
        players.get(Constants.PLAYER_TWO).setScore(board.getLightCount());
    }

    /**
     * @return the currentPlayer
     */
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * @param currentPlayer the currentPlayer to set
     */
    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
}
