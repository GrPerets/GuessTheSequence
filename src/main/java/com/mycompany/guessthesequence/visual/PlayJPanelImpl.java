/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.guessthesequence.visual;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author grperets
 */
@Component("playJPanel")
public class PlayJPanelImpl extends JPanel implements PlayJPanel{
    
    private final GridBagLayout gbl;
    private final GridBagConstraints gbc;
    @Autowired
    private ButtonsJPanel buttonsJPanel;
    @Autowired
    private AnswersJPanel answersJPanel;
    @Autowired
    private ResultsJPanel resultsJPanel;
    private JScrollPane jScrollPane;
    
    
    
    
    
    public PlayJPanelImpl() {
        gbl = new GridBagLayout();
        gbc = new GridBagConstraints();
        setLayout(gbl);
    }

    @Override
    public ButtonsJPanel getButtonsJPanel() {
        return buttonsJPanel;
    }

    public void setButtonsJPanel(ButtonsJPanel buttonsJPanel) {
        this.buttonsJPanel = buttonsJPanel;
        jScrollPane = new JScrollPane(buttonsJPanel.getButtonsJPanel());
        //Расположение JScrolPane buttonsJPanel
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

        gbl.setConstraints(jScrollPane, gbc);
              
        add(jScrollPane);
    }

    @Override
    public AnswersJPanel getAnswersJPanel() {
        return answersJPanel;
    }

    public void setAnswersJPanel(AnswersJPanel answersJPanel) {
        this.answersJPanel = answersJPanel;
        jScrollPane = new JScrollPane(answersJPanel.getAnswersJPanel());
        //Расположение JScrollPane answersJPanel
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
        
        gbl.setConstraints(jScrollPane, gbc);
        
        add(jScrollPane);
    }

    @Override
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
        

        gbl.setConstraints(resultsJPanel.getResultsJPanel(), gbc);
        add(resultsJPanel.getResultsJPanel());
    }

    @Override
    public JPanel getPlayJPanel() {
        return this;
    }
    
}
