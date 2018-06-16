/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.guessthesequence.visual;

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
import javax.swing.JScrollPane;

/**
 *
 * @author grperets
 */
public class AnswersJPanel extends JPanel implements ActionListener{
    private GridBagLayout gbl;
    private GridBagConstraints gbc;
    private ImageIcon image;
    private JButton[] button;
    private ButtonsJPanel buttonsJPanel;
    private ResultsJPanel resultsJPanel;
    private LevelOfPlay levelOfPlay;
    private JButton verifyJButton;
    private AnswersJPanel answersJPanel;

    public AnswersJPanel() {
        gbl = new GridBagLayout();
        gbc = new GridBagConstraints();
        setLayout(gbl);
    }

    public AnswersJPanel getAnswersJPanel() {
        
        return answersJPanel;
    }

    public void setAnswersJPanel(LevelOfPlay levelOfPlay) {
        this.answersJPanel = answersJPanel;
        button = new JButton[levelOfPlay.getDefineSize()];
        image = new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource("images/question.jpeg")).getImage().getScaledInstance(80, 60, Image.SCALE_SMOOTH));
        
        for(int i=0;i<levelOfPlay.getDefineSize();i++){
            if(image!=null){
                button[i] = new JButton(image);
            } else {button[i] = new JButton("?");}
            
            button[i].setActionCommand("default");
            
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
    
    
    
    public ButtonsJPanel getButtonsJPanel() {
        return buttonsJPanel;
    }

    public void setButtonsJPanel(ButtonsJPanel buttonsJPanel) {
        this.buttonsJPanel = buttonsJPanel;
        
    }

    public LevelOfPlay getLevelOfPlay() {
        return levelOfPlay;
    }

    public void setLevelOfPlay(LevelOfPlay levelOfPlay) {
        this.levelOfPlay = levelOfPlay;
    }
    
    public JButton getVerifyJButton() {
        
        return verifyJButton;
    }

    public void setVerifyJButton(JButton verifyJButton) {
        this.verifyJButton = verifyJButton;
        //Кнопка проверки ответов
                
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
        gbc.gridx = 0;
        gbc.gridy = 1;
        //Количество занимаемых ячеек
        if(levelOfPlay!=null){
            gbc.gridwidth = levelOfPlay.getDefineSize();
        } else gbc.gridwidth = 1;
        gbc.gridheight = 1;
        //Заполнение ячейки
        gbc.fill = GridBagConstraints.BOTH;

        gbl.setConstraints(verifyJButton, gbc);
        
        verifyJButton.setEnabled(false);
        verifyJButton.addActionListener(resultsJPanel);
        
        add(verifyJButton);
        
    }

    public ResultsJPanel getResultsJPanel() {
        return resultsJPanel;
    }

    public void setResultsJPanel(ResultsJPanel resultsJPanel) {
        this.resultsJPanel = resultsJPanel;
        
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
        image = new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource("images/question.jpeg")).getImage().getScaledInstance(80, 60, Image.SCALE_SMOOTH));
        
        if(image!=null){
            actionButton.setIcon(image);
        } else {
            actionButton.setText("?");
            }
        if(!(e.getActionCommand().equals("default"))){
            buttonsJPanel.getButton()[Integer.valueOf(e.getActionCommand())].setEnabled(true);
        }
        actionButton.setActionCommand("default");
        getVerifyJButton().setEnabled(false);
                       
    }
   
    
    
}
