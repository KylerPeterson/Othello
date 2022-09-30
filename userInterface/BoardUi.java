/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import Core.Constants;
import Core.Disc;
import Core.Game;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Kyler
 */
public class BoardUi extends JPanel {
    
    JButton[][] board;
    BoardListener listener;
    private Game game;
    private Gameui gameUi;
    
    public BoardUi(){
    
        initComponents();
    }

    public BoardUi(Game game, Gameui gameUi) {
       this.game = game;
       this.gameUi = gameUi;
       initComponents();
       listener.updateUi();
    }
    
    private void initComponents(){
    
    this.setPreferredSize(new Dimension(500, 500));
    this.setMaximumSize(new Dimension(500, 500));
    this.setLayout(new GridLayout(Constants.ROWS, Constants.COLUMNS));
    
    board = new JButton[Constants.ROWS][Constants.COLUMNS];
    listener = new BoardListener();
    
    for(int row = 0; row < Constants.ROWS; row++) {
    
        for(int col = 0; col < Constants.COLUMNS; col++){
        
          board[row][col] = new JButton();  
          board[row][col].putClientProperty("row", row);
          board[row][col].putClientProperty("col", col);
          board[row][col].putClientProperty("color", Constants.EMPTY);
          board[row][col].setBackground(Color.RED);
          board[row][col].addActionListener(listener);
          
          this.add(board[row][col]);
        
        }
     }
    }
    private class BoardListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            if(ae.getSource() instanceof JButton){
                
                JButton button = (JButton) ae.getSource();
                int row = (int)button.getClientProperty("row");
                int col = (int)button.getClientProperty("col");
                Color color = (Color)button.getClientProperty("color");
                
                if(isValidMove(row, col, game.getCurrentPlayer().getDiscolor())){
                    updateUi();
                    changePlayer();
                }
                else{
                    JOptionPane.showMessageDialog(button, "Move is not valid, select another");
                }
            }
        }

        private boolean isValidMove(int row, int col, Color color){
            boolean valid = false;
            Disc[][] blah = game.getBoard().getBoard();
            
            if(color == Constants.EMPTY){
                valid = false;
            }
            else if (blah[row][col].getDiscolor() != Constants.EMPTY) {
                valid = false;
            }
            
            else if(game.getBoard().isValidMove(row, col, color, true)){
                valid = true;
            }
            return valid;
        }
        
        private void changePlayer(){
            if(game.getCurrentPlayer() == game.getPlayers().get(Constants.PLAYER_ONE))
                game.setCurrentPlayer(game.getPlayers().get(Constants.PLAYER_TWO));
            else
                game.setCurrentPlayer(game.getPlayers().get(Constants.PLAYER_ONE));
        }
        
        private void updateUi() {
            Disc[][] discs = game.getBoard().getBoard();
            ImageIcon disc = null;
            
            for(int row = 0; row < Constants.ROWS; row++){
                for(int col = 0; col < Constants.COLUMNS; col++){
                    if(discs[row][col].getDiscolor() == Constants.DARK){
                        disc = new ImageIcon( getClass().getResource("../images/black_disc.png"));
                        disc = imageResize(disc);
                        board[row][col].setIcon(disc);
                    }
                    else if (discs[row][col].getDiscolor() == Constants.LIGHT){
                        disc = new ImageIcon( getClass().getResource("../images/white_disc.png"));
                        disc = imageResize(disc);
                        board[row][col].setIcon(disc);
                        
                    }
                
                }
            }
            gameUi.getScoreOne().setText(String.valueOf(game.getPlayers().get(Constants.PLAYER_ONE).getScore()));
            gameUi.getScoreTwo().setText(String.valueOf(game.getPlayers().get(Constants.PLAYER_TWO).getScore()));
        }
    
        private ImageIcon imageResize(ImageIcon icon){
            Image image = icon.getImage();
            Image newImage =
                    image.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
            icon = new ImageIcon(newImage);
            return icon;
        }
    
    
    }
    
}
