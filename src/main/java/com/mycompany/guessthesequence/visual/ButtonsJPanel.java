/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.guessthesequence.visual;

import com.mycompany.guessthesequence.logical.LevelOfPlay;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author grperets
 */
public interface ButtonsJPanel{
    JPanel getButtonsJPanel();
    JButton[] getButton();
    void setButtonsJPanel(LevelOfPlay levelOfPlay);
    
}
