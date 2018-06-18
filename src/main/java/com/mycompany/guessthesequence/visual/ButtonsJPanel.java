/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.guessthesequence.visual;

import com.mycompany.guessthesequence.logical.DifficultyOfGame;
import com.mycompany.guessthesequence.logical.LevelOfPlay;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author grperets
 */
public class ButtonsJPanel extends JPanel implements ActionListener{
    private GridBagLayout gbl;
    private GridBagConstraints gbc;
    private ImageIcon image;
    private JButton[] button;
    private AnswersJPanel answersJPanel;
    
    private DifficultyOfGame difficultyOfGame;
    private ArrayList answersCollection;

   
    public ButtonsJPanel() {
        gbl = new GridBagLayout();
        gbc = new GridBagConstraints();
        setLayout(gbl);
    }
    
    public void setButtonsJPanel(DifficultyOfGame difficultyOfGame) {
        //this.buttonsJPanel = buttonsJPanel;
        button = new JButton[difficultyOfGame.getCollectionSize()];
        for(int i=0;i<difficultyOfGame.getCollectionSize();i++){
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

    public void setAnswersJPanel(AnswersJPanel answersJPanel) {
        this.answersJPanel = answersJPanel;
               
    }

    public DifficultyOfGame getDifficultyOfGame() {
        return difficultyOfGame;
    }

    public void setDifficultyOfGame(DifficultyOfGame difficultyOfGame) {
        this.difficultyOfGame = difficultyOfGame;
    }

    

    public JButton[] getButton() {
        return button;
    }

    public void setButton(JButton[] button) {
        this.button = button;
    }

    
    

     @Override
    public void actionPerformed(ActionEvent e) {
        
        JButton actionButton = (JButton)e.getSource();
        
               
        for(int i=0;i<difficultyOfGame.getDefineSize();i++){
            if(answersJPanel.getButton()[i].getActionCommand().equals("default")){ 
                image = new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource(AllElements.values()[Integer.valueOf(e.getActionCommand())].getUrlAddress())).getImage().getScaledInstance(80, 60, Image.SCALE_SMOOTH));
                if(image!=null){
                    answersJPanel.getButton()[i].setIcon(image);
                } else {answersJPanel.getButton()[i].setText(e.getActionCommand());}
                answersJPanel.getButton()[i].setActionCommand(String.valueOf(Integer.valueOf(e.getActionCommand())));
                actionButton.setEnabled(false);
                break;
            }
        }
        
        answersCollection = new ArrayList();
        for(JButton x:answersJPanel.getButton()){
            answersCollection.add(x.getActionCommand());
        }
        
        if(!answersCollection.contains("default")){
            answersJPanel.getVerifyJButton().setEnabled(true);
        } else answersJPanel.getVerifyJButton().setEnabled(false);
                  
    }  
       
    
}
