/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import Core.Constants;
import Core.Game;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Kyler
 */
public class Gameui extends JPanel {
    private Game game;
    private JLabel nameOne;
    private JLabel nameTwo;
    private JLabel scoreOne;
    private JLabel scoreTwo;
    
    public Gameui(Game game){
        this.game = game;
        initComponents();
    }

    
    private void initComponents(){
    
        this.setPreferredSize(new Dimension(600, 50));
        this.setMinimumSize(new Dimension(600, 50));
        this.setBackground(Color.LIGHT_GRAY);
    
        ImageIcon discOne = new ImageIcon( getClass().getResource("../images/black_disc.png"));
        discOne = imageResize(discOne);
        
        nameOne = new JLabel();
        nameOne.setIcon(discOne);
        nameOne.setText(game.getPlayers().get(Constants.PLAYER_ONE).getName());
        nameOne.setMinimumSize(new Dimension(100, 50));
        nameOne.setPreferredSize(new Dimension(100, 50));
        nameOne.setForeground(Color.BLACK);
        nameOne.setFont(new Font("Serif",Font.BOLD, 22));
       
        ImageIcon discTwo = new ImageIcon( getClass().getResource("../images/white_disc.png"));
        discTwo = imageResize(discTwo);
        
        nameTwo = new JLabel();
        nameTwo.setIcon(discTwo);
        nameTwo.setText(game.getPlayers().get(Constants.PLAYER_TWO).getName());
        nameTwo.setMinimumSize(new Dimension(100, 50));
        nameTwo.setPreferredSize(new Dimension(100, 50));
        nameTwo.setForeground(Color.BLACK);
        nameTwo.setFont(new Font("Serif",Font.BOLD, 22));
                
                
        setScoreOne(new JLabel());
        getScoreOne().setText(String.valueOf(game.getPlayers().get(Constants.PLAYER_ONE).getScore()));
        getScoreOne().setMinimumSize (new Dimension(100, 50));
        getScoreOne().setPreferredSize(new Dimension(100, 50));
        getScoreOne().setForeground(Color.BLACK);
        getScoreOne().setFont(new Font("Serif",Font.BOLD, 22));
        
        setScoreTwo(new JLabel());
        //scoreTwo.setText(String.valueOf(game.getPlayers().get(Constants.PLAYER_TWO).getScore()));
        
        // Get the actual # score of player 2 :  game.getPlayers().get(Constants.PLAYER_TWO).getScore()
        // Insert that score into this to turn a # into a string : String.valueOf(   <turn something into string>   )
        // Put a string into the UI :  scoreTwo.setText( <string here> );
        
        getScoreTwo().setText(String.valueOf(game.getPlayers().get(Constants.PLAYER_TWO).getScore()));
        getScoreTwo().setMinimumSize (new Dimension(100, 50));
        getScoreTwo().setPreferredSize(new Dimension(100, 50));
        getScoreTwo().setForeground(Color.BLACK);
        getScoreTwo().setFont(new Font("Serif",Font.BOLD, 22));
    
        this.add(nameOne);
        this.add(getScoreOne());
        this.add(nameTwo);
        this.add(getScoreTwo());
    }
    private ImageIcon imageResize(ImageIcon icon){
            Image image = icon.getImage();
            Image newImage =
                    image.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
            icon = new ImageIcon(newImage);
            return icon;
        }

    /**
     * @return the scoreTwo
     */
    public JLabel getScoreTwo() {
        return scoreTwo;
    }

    /**
     * @param scoreTwo the scoreTwo to set
     */
    public void setScoreTwo(JLabel scoreTwo) {
        this.scoreTwo = scoreTwo;
    }

    /**
     * @return the scoreOne
     */
    public JLabel getScoreOne() {
        return scoreOne;
    }

    /**
     * @param scoreOne the scoreOne to set
     */
    public void setScoreOne(JLabel scoreOne) {
        this.scoreOne = scoreOne;
    }

    }
    

