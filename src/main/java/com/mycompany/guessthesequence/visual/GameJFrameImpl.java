/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.guessthesequence.visual;

import com.mycompany.guessthesequence.logical.CollectionElements;
import com.mycompany.guessthesequence.logical.LevelOfPlay;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author grperets
 */
@Component("gameJFrame")
public class GameJFrameImpl extends JFrame implements GameJFrame, InitializingBean{
    
    private Dimension dimension;
    private StartJPanel startJPanel;
    private PlayJPanel playJPanel;
    private JPanel actionJPanel;
    private LevelOfPlay levelOfPlay;
    private CollectionElements collectionElements;
    private long timeStart;
    
    @Autowired
    public GameJFrameImpl(GameJMenu gameJMenu) {
                
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
    
    public void test(){
        
    }

    public CollectionElements getCollectionElements() {
        return collectionElements;
    }
    @Autowired
    public void setCollectionElements(CollectionElements collectionElements) {
        this.collectionElements = collectionElements;
    }

     
    
    public LevelOfPlay getLevelOfPlay() {
        return levelOfPlay;
    }
    @Autowired
    public void setLevelOfPlay(LevelOfPlay levelOfPlay) {
        this.levelOfPlay = levelOfPlay;
    }
    
    
    @Override
    public JPanel getActionJPanel() {
        return actionJPanel;
    }

    @Override
    public void setActionJPanel(JPanel actionJPanel) {
        this.actionJPanel = actionJPanel;
        add(actionJPanel);
        setVisible(true);
    }

    @Override
    public StartJPanel getStartJPanel() {
        return startJPanel;
    }
    @Autowired
    public void setStartJPanel(StartJPanel startJPanel) {
        this.startJPanel = startJPanel;
    }

    public PlayJPanel getPlayJPanel() {
        return playJPanel;
    }
    @Autowired
    public void setPlayJPanel(PlayJPanel playJPanel) {
        this.playJPanel = playJPanel;
    }
    
    @Override
    public long getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(long timeStart) {
        this.timeStart = timeStart;
    }
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        remove(this.actionJPanel);
               
        playJPanel.getButtonsJPanel().setButtonsJPanel(levelOfPlay);
        playJPanel.getAnswersJPanel().setAnswersJPanel(levelOfPlay);
        collectionElements.setCollectionElements(levelOfPlay);
                
        setActionJPanel(playJPanel.getPlayJPanel());
        //getActionJPanel();
        //Начало отсчета времени
        setTimeStart(System.currentTimeMillis());
        
        
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        setActionJPanel(startJPanel.getStartJPanel());
        
        //if(getActionJPanel()!=null)getActionJPanel();
        
    }

    @Override
    public JFrame getGameJFrame() {
        return this;
    }
 
    
}
