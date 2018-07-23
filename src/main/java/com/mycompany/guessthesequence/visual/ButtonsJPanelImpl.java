/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.guessthesequence.visual;

import com.mycompany.guessthesequence.logical.LevelOfPlay;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author grperets
 */
@Component("buttobsJPanel")
public class ButtonsJPanelImpl extends JPanel implements ButtonsJPanel, ActionListener {
    private GridBagLayout gbl;
    private GridBagConstraints gbc;
    private ImageIcon image;
    private JButton[] button;
    private AnswersJPanel answersJPanel;
    private LevelOfPlay levelOfPlay;
    
    

   
    public ButtonsJPanelImpl() {
        gbl = new GridBagLayout();
        gbc = new GridBagConstraints();
        setLayout(gbl);
    }
    
    @Override
    public JPanel getButtonsJPanel() {
        return this;
    }
    
    
    @Override
    public void setButtonsJPanel(LevelOfPlay levelOfPlay) {
        this.levelOfPlay = levelOfPlay;
        
        
        button = new JButton[levelOfPlay.getCollectionSize()];
        for(int i=0;i<levelOfPlay.getCollectionSize();i++){
            image = new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource(AllElements.values()[i].getUrlAddress())).getImage().getScaledInstance(80, 60, Image.SCALE_SMOOTH));
            
            if(image!=null){
                button[i] = new JButton(image);
            } else {button[i] = new JButton(String.valueOf(i));}    
            //} else {button[i] = new JButton(arrayAllElements[i].getName());}
            button[i].setActionCommand(String.valueOf(i));     
              
            //Расположение на панели                
            //Значимость
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        //Увеличение компонента на заданое число пикселей
        gbc.ipadx = 0; //default 0
        gbc.ipady = 0; //default 0
        //Отступы от краев
        gbc.insets = new Insets(10,10,10,10);
        //Выравнивание в ячейке
        gbc.anchor = GridBagConstraints.CENTER;
        //Координата в сетке
        gbc.gridx = GridBagConstraints.RELATIVE;
        gbc.gridy = 0;
        //Количество занимаемых ячеек
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        //Заполнение ячейки
        gbc.fill = GridBagConstraints.BOTH;

        gbl.setConstraints(button[i], gbc);
            
            add(button[i]);
            button[i].addActionListener(this);
           
        }
    }
    
    public AnswersJPanel getAnswersJPanel() {
        return answersJPanel;
    }
    @Autowired
    public void setAnswersJPanel(AnswersJPanel answersJPanel) {
        this.answersJPanel = answersJPanel;
               
    }

    
    @Override
    public JButton[] getButton() {
        return button;
    }

    public void setButton(JButton[] button) {
        this.button = button;
    }

    
    

     @Override
    public void actionPerformed(ActionEvent e) {
        
        JButton actionButton = (JButton)e.getSource();
        int answerButtons = 0;
        for(JButton x:button){
            if(!x.isEnabled()) ++answerButtons;
        }
        if(answerButtons!=levelOfPlay.getDefineSize()){
            answersJPanel.setAnswersCollection(e.getActionCommand());
            actionButton.setEnabled(false);
            
        }
        
        
                 
    }  
    
}
