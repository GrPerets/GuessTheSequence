/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.guessthesequence.visual;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author grperets
 */
public class GameJMenu extends JMenuBar{

    public GameJMenu() {
        JMenu fileMenu = new JMenu("<html><h3>File</h3></html>");
        add(fileMenu);
        JMenuItem newFileMenu = new JMenuItem("<html><h3>New game</h3></html>");
        fileMenu.add(newFileMenu);
        JMenu helpMenu = new JMenu("<html><h3>Help</h3></html>");
        add(helpMenu);
        JMenuItem rulesHelpMenu = new JMenuItem("<html><h3>Rules game</h3></html>");
        helpMenu.add(rulesHelpMenu);
        
        JMenuItem recordsHelpMenu = new JMenuItem("<html><h3>Records</h3></html>");
        helpMenu.add(recordsHelpMenu);
        
    }
    
    
}
