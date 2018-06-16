/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.guessthesequence.visual;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.springframework.beans.factory.InitializingBean;

/**
 *
 * @author grperets
 */
public class GameJFrame extends JFrame implements ActionListener, InitializingBean{
    
    private Dimension dimension;
    private StartJPanel startJPanel;
    private PlayJPanel playJPanel;
    private JPanel actionJPanel;
    
    
    
    private long timeStart;
    

    public GameJFrame(GameJMenu gameJMenu) {
                
// Размер окна = размер экрана - панель задач
        dimension = Toolkit.getDefaultToolkit().getScreenSize();
        Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(getGraphicsConfiguration());
        setSize((int)dimension.getWidth()-insets.left-insets.right, (int)dimension.getHeight()-insets.top-insets.bottom);
        setLocation(insets.right, insets.top);
        setTitle("Guess The Sequence");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        
        
        //Главное меню
        setJMenuBar(gameJMenu);
        
    }
    
     

    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    public JPanel getActionJPanel() {
        return actionJPanel;
    }

    public void setActionJPanel(JPanel actionJPanel) {
        this.actionJPanel = actionJPanel;
        add(actionJPanel);
        setVisible(true);
    }
    
    public JPanel getStartJPanel() {
        return startJPanel;
    }

    public void setStartJPanel(StartJPanel startJPanel) {
        this.startJPanel = startJPanel;
        
    }

    public PlayJPanel getPlayJPanel() {
        return playJPanel;
    }

    public void setPlayJPanel(PlayJPanel playJPanel) {
        this.playJPanel = playJPanel;
    }
   

    public long getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(long timeStart) {
        this.timeStart = timeStart;
    }
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        remove(this.actionJPanel);
        
        playJPanel.getButtonsJPanel().setButtonsJPanel(startJPanel.getCollectionSizeJSlider().getLevelOfPlay());
        playJPanel.getAnswersJPanel().setAnswersJPanel(startJPanel.getCollectionSizeJSlider().getLevelOfPlay());
        playJPanel.getAnswersJPanel().getVerifyJButton();
        playJPanel.getRandomCollection().setRandomCollection(startJPanel.getCollectionSizeJSlider().getLevelOfPlay());
        
        
        
        setActionJPanel(playJPanel);
        getActionJPanel();
        //Начало отсчета времени
        setTimeStart(System.currentTimeMillis());
        
        
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        
        if(getActionJPanel()!=null)getActionJPanel();
        
    }
 
    
}
