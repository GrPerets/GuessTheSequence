/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.guessthesequence.visual;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;

/**
 *
 * @author grperets
 */
public interface StartJPanel{
    JPanel getStartJPanel();
    DefineSizeJSlider getDefineSizeJSlider();
    CollectionSizeJSlider getCollectionSizeJSlider();
    JButton getStartJButton();
    
}
