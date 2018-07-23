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
@Component("answersJPanel")
public class AnswersJPanelImpl extends JPanel implements AnswersJPanel, ActionListener{
    private GridBagLayout gbl;
    private GridBagConstraints gbc;
    private ImageIcon image;
    private JButton[] button;
    @Autowired
    private ButtonsJPanel buttonsJPanel;
    @Autowired
    private ResultsJPanel resultsJPanel;
    private LevelOfPlay levelOfPlay;
    private JButton verifyJButton;
    private Integer[] answersCollection;
    

    public AnswersJPanelImpl() {
        gbl = new GridBagLayout();
        gbc = new GridBagConstraints();
        setLayout(gbl);
    }

    @Override
    public Object[] getAnswersCollection() {
        return answersCollection;
    }

    @Override
    public void setAnswersCollection(String answerElement) {
                
        for(int i=0;i<levelOfPlay.getDefineSize();i++){
            if(getButton()[i].getActionCommand().equals("default")){ 
                image = new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource(AllElements.values()[Integer.valueOf(answerElement)].getUrlAddress())).getImage().getScaledInstance(80, 60, Image.SCALE_SMOOTH));
                if(image!=null){
                    getButton()[i].setIcon(image);
                } else {getButton()[i].setText(answerElement);}
                getButton()[i].setActionCommand(String.valueOf(Integer.valueOf(answerElement)));
                answersCollection[i]=Integer.valueOf(answerElement);
                break;
            }
        }
        for(JButton x:button){
            if(!x.getActionCommand().equals("default")){
                verifyJButton.setEnabled(true);
            } else verifyJButton.setEnabled(false);
        }
        
        
    }

    
    @Override
    public JPanel getAnswersJPanel() {
        return this;
    }

    @Override
    public void setAnswersJPanel(LevelOfPlay levelOfPlay) {
        this.levelOfPlay = levelOfPlay;
        
        answersCollection = new Integer[levelOfPlay.getDefineSize()];
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
        
        //Кнопка проверки ответов
         
        verifyJButton = new JButton("Проверить"); 
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
        if(levelOfPlay.getDefineSize()!=0){
            gbc.gridwidth = levelOfPlay.getDefineSize();
        } else gbc.gridwidth = 1;
        gbc.gridheight = 1;
        //Заполнение ячейки
        gbc.fill = GridBagConstraints.BOTH;

        gbl.setConstraints(verifyJButton, gbc);
        
        verifyJButton.setEnabled(false);
        verifyJButton.addActionListener((ae)->{resultsJPanel.setResultsJPanel(answersCollection);});
        
        add(verifyJButton);
    }
    
    
    
    public ButtonsJPanel getButtonsJPanel() {
        return buttonsJPanel;
    }

    public void setButtonsJPanel(ButtonsJPanel buttonsJPanel) {
        this.buttonsJPanel = buttonsJPanel;
        
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
        verifyJButton.setEnabled(false);
                       
    }
   
    
}
