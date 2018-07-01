/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.guessthesequence.visual;

import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author grperets
 */
public interface GameJFrame extends ActionListener{
    JFrame getGameJFrame();
    long getTimeStart();
    JPanel getActionJPanel();
    void setActionJPanel(JPanel actionJPanel);
    StartJPanel getStartJPanel();
    
}
