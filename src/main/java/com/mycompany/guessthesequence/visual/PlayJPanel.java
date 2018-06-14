/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.guessthesequence.visual;

import com.mycompany.guessthesequence.logical.LevelOfPlay;
import com.mycompany.guessthesequence.logical.RandomCollection;
import com.mycompany.guessthesequence.logical.ResultOfGuessing;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JPanel;

/**
 *
 * @author grperets
 */
public class PlayJPanel extends JPanel{
    
    private final GridBagLayout gbl;
    private final GridBagConstraints gbc;
    private RandomCollection randomCollection;
    private ButtonsJPanel buttonsJPanel;
    private AnswersJPanel answersJPanel;
    private ResultsJPanel resultsJPanel;
    private LevelOfPlay levelOfPlay;
    private ResultOfGuessing resultOfGuessing;
    
    
    
    
    public PlayJPanel() {
        gbl = new GridBagLayout();
        gbc = new GridBagConstraints();
        setLayout(gbl);
    }

    public LevelOfPlay getLevelOfPlay() {
        return levelOfPlay;
    }

    public void setLevelOfPlay(LevelOfPlay levelOfPlay) {
        this.levelOfPlay = levelOfPlay;
    }
    
    public RandomCollection getRandomCollection() {
        return randomCollection;
    }

    public void setRandomCollection(RandomCollection randomCollection) {
        this.randomCollection = randomCollection;
    }

    public ResultOfGuessing getResultOfGuessing() {
        return resultOfGuessing;
    }

    public void setResultOfGuessing(ResultOfGuessing resultOfGuessing) {
        this.resultOfGuessing = resultOfGuessing;
    }

        
    public ButtonsJPanel getButtonsJPanel() {
        return buttonsJPanel;
    }

    public void setButtonsJPanel(ButtonsJPanel buttonsJPanel) {
        this.buttonsJPanel = buttonsJPanel;
        
        //Расположение buttonsJPanel
        //Значимость
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        //Увеличение компонента на заданое число пикселей
        gbc.ipadx = 0; //default 0
        gbc.ipady = 0; //default 0
        //Отступы от крайов
        gbc.insets = new Insets(10,10,10,10);
        //Выравнивание в ячейке
        gbc.anchor = GridBagConstraints.CENTER;
        //Координата в сетке
        gbc.gridx = 0;
        gbc.gridy = 0;
        //Количество занимаемых ячеек
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        //Заполнение ячейки
        gbc.fill = GridBagConstraints.BOTH;

        gbl.setConstraints(buttonsJPanel, gbc);
              
        add(buttonsJPanel);
    }

    public AnswersJPanel getAnswersJPanel() {
        return answersJPanel;
    }

    public void setAnswersJPanel(AnswersJPanel answersJPanel) {
        this.answersJPanel = answersJPanel;
        
        //Расположение answersJPanel
        //Значимость
        gbc.weightx = 1.5;
        gbc.weighty = 1.0;
        //Увеличение компонента на заданое число пикселей
        gbc.ipadx = 0; //default 0
        gbc.ipady = 0; //default 0
        //Отступы от крайов
        gbc.insets = new Insets(10,10,10,10);
        //Выравнивание в ячейке
        gbc.anchor = GridBagConstraints.CENTER;
        //Координата в сетке
        gbc.gridx = 0;
        gbc.gridy = 1;
        //Количество занимаемых ячеек
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        //Заполнение ячейки
        gbc.fill = GridBagConstraints.BOTH;
        
        gbl.setConstraints(answersJPanel, gbc);
        
        add(answersJPanel);
    }

    public ResultsJPanel getResultsJPanel() {
        return resultsJPanel;
    }

    public void setResultsJPanel(ResultsJPanel resultsJPanel) {
        this.resultsJPanel = resultsJPanel;
        //Расположение ResultsJPanel
        //Значимость
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        //Увеличение компонента на заданое число пикселей
        gbc.ipadx = 0; //default 0
        gbc.ipady = 0; //default 0
        //Отступы от крайов
        gbc.insets = new Insets(10,10,10,10);
        //Выравнивание в ячейке
        gbc.anchor = GridBagConstraints.CENTER;
        //Координата в сетке
        gbc.gridx = 1;
        gbc.gridy = 1;
        //Количество занимаемых ячеек
        gbc.gridwidth = 1;
        gbc.gridheight = 2;
        //Заполнение ячейки
        gbc.fill = GridBagConstraints.BOTH;
        

        gbl.setConstraints(resultsJPanel, gbc);
        add(resultsJPanel);
    }

    

    
    
    
    
    
}
