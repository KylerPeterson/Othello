/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

import java.awt.Color;
/**
 *
 * @author Kyler
 */
public class Player {
    private String name;
    private Color Discolor;
    private int score;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the Discolor
     */
    public Color getDiscolor() {
        return Discolor;
    }

    /**
     * @param Discolor the Discolor to set
     */
    public void setDiscolor(Color Discolor) {
        this.Discolor = Discolor;
    }

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score) {
        this.score = score;
    }
}
