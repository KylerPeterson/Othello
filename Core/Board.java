/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Kyler
 */
public class Board {
    
    private Disc[][] board;
    private int darkCount;
    private int lightCount;
    private ArrayList<Player> players;
            
    public Board(){
        initObjects();
    }
    
    private void initObjects() {
        board = new Disc[Constants.ROWS][Constants.COLUMNS];
        
        for(int row = 0; row < Constants.ROWS; row++)
        {
            for(int col = 0; col<Constants.COLUMNS; col++)
            {
                board[row][col] = new Disc();
            }
        }
    board[3][3].setDiscolor(Constants.LIGHT);
    board[3][4].setDiscolor(Constants.DARK);
    board[4][3].setDiscolor(Constants.DARK);
    board[4][4].setDiscolor(Constants.LIGHT);
    
    lightCount = 0;
    darkCount = 0;
    }
    //The for loop above and the code that follows sets up the new Othello board
    //It sets up the rows, columns, and then the disc placement and color
    
    /**
     * @return the board
     */
    public Disc[][] getBoard() {
        return board;
    }

    /**
     * @param board the board to set
     */
    public void setBoard(Disc[][] board) {
        this.board = board;
    }
    
    public void calculateScore(){
        darkCount = 0;
        lightCount = 0;
        for(int row = 0; row < Constants.ROWS; row++){
            for(int col = 0; col < Constants.COLUMNS; col++){
                if(board[row][col].getDiscolor() == Constants.DARK)
                    darkCount++;
                else if(board[row][col].getDiscolor() == Constants.LIGHT)
                    lightCount++;
            } 
        }
        players.get(Constants.PLAYER_ONE).setScore(darkCount);
        players.get(Constants.PLAYER_TWO).setScore(lightCount);
    }
   
    public boolean isValidMove(int row, int col, Color color, Boolean flip){
        boolean valid = false;
        //board[row][col].getDiscolor() == Constants.EMPTY
        if(checkUp(row, col, color, flip)){
            valid = true;
        }
        if(checkDown(row, col, color, flip)){
            valid = true;
        }
        if(checkLeft(row, col, color, flip)){
            valid = true;
        }
        if(checkRight(row, col, color, flip)){
            valid = true;
        }
         if(checkUpLeft(row, col, color, flip)){
            valid = true;
        }
         if(checkUpRight(row, col, color, flip)){
            valid = true;
        }
         if(checkDownRight(row, col, color, flip)){
            valid = true;
        }
          if(checkDownLeft(row, col, color, flip)){
            valid = true;
        }
        if (valid && flip) {
            board[row][col].setDiscolor(color);
        }
        calculateScore();
        if (flip == true){
        gameOver();
        }
        return valid;
     }
    /**
     * @return the darkCount
     */
    public int getDarkCount() {
        return darkCount;
    }

    /**
     * @param darkCount the darkCount to set
     */
    public void setDarkCount(int darkCount) {
        this.darkCount = darkCount;
    }

    /**
     * @return the lightCount
     */
    public int getLightCount() {
        return lightCount;
    }

    /**
     * @param lightCount the lightCount to set
     */
    public void setLightCount(int lightCount) {
        this.lightCount = lightCount;
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

    
    private boolean checkUp (int row, int col, Color color, Boolean flip){
    
        int flipSquares = 0;
        int checkRow = row - 1;
        boolean matchFound = false;
        boolean validMove = false;
        
        while (checkRow >= 0 && !matchFound){
            if(board[checkRow][col].getDiscolor() == Constants.EMPTY){
                validMove = false;
                break;
            }
          
            else if (board[checkRow][col].getDiscolor() != color){
                flipSquares++;
            }
            else{
                matchFound = true;
            }
            checkRow--;
        }
        
        if (matchFound == true && flipSquares > 0) {
              do { row--;
                   flipSquares--; 
                   if(flip == true){
                   board[row][col].setDiscolor(color);
                   }
            } while (flipSquares > 0);
            validMove = true;
        }
        else {
            validMove = false;
        }
        return validMove;
     }
    
    private boolean checkDown (int row, int col, Color color, Boolean flip){
    
        int flipSquares = 0;
        int checkRow = row + 1;
        boolean matchFound = false;
        boolean validMove = false;
        
        while (checkRow <= 7 && !matchFound){
            if(board[checkRow][col].getDiscolor() == Constants.EMPTY){
                validMove = false;
                break;
            }
           
            else if (board[checkRow][col].getDiscolor() != color){
                flipSquares++;
            }
            else{
                matchFound = true;
            }
            checkRow++;
        }
        
        if (matchFound == true && flipSquares > 0) {
              do { row++;
                   flipSquares--; 
                   if(flip == true){
                   board[row][col].setDiscolor(color);
                   }
        
            } while (flipSquares > 0);
            validMove = true;
        }
        else {
            validMove = false;
        }
        return validMove;
     }
    
     private boolean checkLeft (int row, int col, Color color, Boolean flip){
    
        int flipSquares = 0;
        int checkCol = col - 1;
        boolean matchFound = false;
        boolean validMove = false;
        
        while (checkCol >= 0 && !matchFound){
            if(board[row][checkCol].getDiscolor() == Constants.EMPTY){
                validMove = false;
                break;
            }
            
            else if (board[row][checkCol].getDiscolor() != color){
                flipSquares++;
            }
            else{
                matchFound = true;
            }
            checkCol--;
        }
        
        if (matchFound == true && flipSquares > 0) {
              do { col--;
                   flipSquares--; 
                   if(flip == true){
                   board[row][col].setDiscolor(color);
                   }
        
            } while (flipSquares > 0);
            validMove = true;
        }
        else {
            validMove = false;
        }
        return validMove;
     }
     
      private boolean checkRight (int row, int col, Color color, Boolean flip){
    
        int flipSquares = 0;
        int checkCol = col + 1;
        boolean matchFound = false;
        boolean validMove = false;
        
        while (checkCol <= 7 && !matchFound){
            if(board[row][checkCol].getDiscolor() == Constants.EMPTY){
                validMove = false;
                break;
            }
            
            else if (board[row][checkCol].getDiscolor() != color){
                flipSquares++;
            }
            else{
                matchFound = true;
            }
            checkCol++;
        }
        
        if (matchFound == true && flipSquares > 0) {
              do { col++;
                   flipSquares--; 
                   if(flip == true){
                   board[row][col].setDiscolor(color);
                   }
        
            } while (flipSquares > 0);
            validMove = true;
        }
        else {
            validMove = false;
        }
        return validMove;
     }
      
          /*
        
        . . . . . . . . 0
        . . . . . . . . 1
        . . . = . . . . 2   * --> checkRow
        . . . . * . . . 3   = --> the row we are trying to click
        . . . . . = . . 4   row = 4 (5th row)
        . . . . . . . . 5   col = 5 (6th col)
    ...
        0 1 2 3 4 5 6 7
    
    checkRow = 3
    
    
    
    */
      
       private boolean checkUpLeft (int row, int col, Color color, Boolean flip){
    
        int flipSquares = 0;
        int checkRow = row - 1;
        int checkCol = col -1;
        boolean matchFound = false;
        boolean validMove = false;
        
        while (checkRow >= 0 && checkCol >=0 && !matchFound){
            if(board[checkRow][checkCol].getDiscolor() == Constants.EMPTY){
                validMove = false;
                break;
            }
          
            else if (board[checkRow][checkCol].getDiscolor() != color){
                flipSquares++;
            }
            else{
                matchFound = true;
            }
            checkRow--;
            checkCol--;
        }
        
        if (matchFound == true && flipSquares > 0) {
              do { row--;
                   col--;
                   flipSquares--;
                   if(flip == true){
                   board[row][col].setDiscolor(color);
                   }
        
            } while (flipSquares > 0);
            validMove = true;
        }
        else {
            validMove = false;
        }
        return validMove;
     }
       
       private boolean checkUpRight (int row, int col, Color color, Boolean flip){
    
        int flipSquares = 0;
        int checkRow = row - 1;
        int checkCol = col + 1;
        boolean matchFound = false;
        boolean validMove = false;
        
        while (checkRow >= 0 && checkCol <=7 && !matchFound){
            if(board[checkRow][checkCol].getDiscolor() == Constants.EMPTY){
                validMove = false;
                break;
            }
          
            else if (board[checkRow][checkCol].getDiscolor() != color){
                flipSquares++;
            }
            else{
                matchFound = true;
            }
            checkRow--;
            checkCol++;
        }
        
        if (matchFound == true && flipSquares > 0) {
              do { row--;
                   col++;
                   flipSquares--;
                   if(flip == true){
                   board[row][col].setDiscolor(color);
                   }
        
            } while (flipSquares > 0);
            validMove = true;
        }
        else {
            validMove = false;
        }
        return validMove;
     }
       
       private boolean checkDownRight (int row, int col, Color color, Boolean flip){
    
        int flipSquares = 0;
        int checkRow = row + 1;
        int checkCol = col + 1;
        boolean matchFound = false;
        boolean validMove = false;
        
        while (checkRow <= 7 && checkCol <=7 && !matchFound){
            if(board[checkRow][checkCol].getDiscolor() == Constants.EMPTY){
                validMove = false;
                break;
            }
          
            else if (board[checkRow][checkCol].getDiscolor() != color){
                flipSquares++;
            }
            else{
                matchFound = true;
            }
            checkRow++;
            checkCol++;
        }
        
        if (matchFound == true && flipSquares > 0) {
              do { row++;
                   col++;
                   flipSquares--;
                   if(flip == true){
                   board[row][col].setDiscolor(color);
                   }
        
            } while (flipSquares > 0);
            validMove = true;
        }
        else {
            validMove = false;
        }
        return validMove;
     }
    
    private boolean checkDownLeft (int row, int col, Color color, Boolean flip){
    
        int flipSquares = 0;
        int checkRow = row + 1;
        int checkCol = col - 1;
        boolean matchFound = false;
        boolean validMove = false;
        
        while (checkRow <= 7 && checkCol >= 0 && !matchFound){
            if(board[checkRow][checkCol].getDiscolor() == Constants.EMPTY){
                validMove = false;
                break;
            }
          
            else if (board[checkRow][checkCol].getDiscolor() != color){
                flipSquares++;
            }
            else{
                matchFound = true;
            }
            checkRow++;
            checkCol--;
        }
        
        if (matchFound == true && flipSquares > 0) {
              do { row++;
                   col--;
                   flipSquares--;
                   if(flip == true){
                   board[row][col].setDiscolor(color);
                   }
        
            } while (flipSquares > 0);
            validMove = true;
        }
        else {
            validMove = false;
        }
        return validMove;
     }
    
    public void gameOver() {
        if (isGameOver() == true) {
            Component button = null;
            JOptionPane.showMessageDialog(button, "The game is over, Congratulations");
        // Display a dialogue box saying congrats! You could even compare their scores (lightCount < darkCount) and say who won
        }
    }
    
    public boolean isGameOver(){
        if(lightCount + darkCount == 64){
            return true;
        }
        
        if(!hasMove(Constants.DARK)&& !hasMove(Constants.LIGHT)){
            return true;
        }
        else {
            return false;
        }
    }
    
    public boolean hasMove(Color color){
        boolean hasMove = false;
          
        for(int row = 0; row < Constants.ROWS; row++) {
            for(int col = 0; col < Constants.COLUMNS; col++){
                if (board[row][col].getDiscolor() == Constants.EMPTY && hasMove == false) {
                    hasMove = isValidMove(row, col, color, false);
                }
            }
        }
        return hasMove;
    }
      
      
}
