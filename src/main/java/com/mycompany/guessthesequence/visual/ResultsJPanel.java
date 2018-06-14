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
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author grperets
 */
public class ResultsJPanel extends JPanel implements ActionListener {
    private final GridBagLayout gbl;
    private final GridBagConstraints gbc;
    private final JPanel scrollResultsJPanel;
    private long timeGame;
    private GameJFrame gameJFrame;
    
    private ArrayList<Integer> yourCollection;
    private AnswersJPanel answersJPanel;
    private LevelOfPlay levelOfPlay;
        
    
    private ResultsJPanel resultsJPanel;
    
    
    
    public ResultsJPanel() {
        BorderLayout borderLayout = new BorderLayout();
        this.setLayout(borderLayout);
        JPanel titleJPanel = new JPanel();
        add(titleJPanel,BorderLayout.NORTH);
        GridLayout gridLayout = new GridLayout(1,0);
        titleJPanel.setLayout(gridLayout);
        
        
        JLabel titleJLabel = new JLabel("<html><h1>Ваш вариант</h1></html>");
        titleJPanel.add(titleJLabel);
        titleJLabel = new JLabel("<html><h1>Угадано элементов</h1></html>");
        titleJPanel.add(titleJLabel);
        titleJLabel = new JLabel("<html><h1>На своих местах</h1></html>");
        titleJPanel.add(titleJLabel);
        
        
        
        scrollResultsJPanel = new JPanel();
        
        gbl = new GridBagLayout();
        gbc = new GridBagConstraints();
        scrollResultsJPanel.setLayout(gbl);          
        
        JScrollPane scrollResultsPane = new JScrollPane(scrollResultsJPanel);
        //автоскролинг
        
        add(scrollResultsPane); 
        
          
        
    }

    public ResultsJPanel getResultsJPanel() {
        return resultsJPanel;
    }

    public void setResultsJPanel(ResultsJPanel resultsJPanel) {
        this.resultsJPanel = resultsJPanel;
    }
  
        
    public AnswersJPanel getAnswersJPanel() {
        return answersJPanel;
    }

    public void setAnswersJPanel(AnswersJPanel answersJPanel) {
        this.answersJPanel = answersJPanel;
    }

    public ArrayList<Integer> getYourCollection() {
        return yourCollection;
    }

    public void setYourCollection(ArrayList<Integer> yourCollection) {
        this.yourCollection = yourCollection;
    }

    
    public LevelOfPlay getLevelOfPlay() {
        return levelOfPlay;
    }

    public void setLevelOfPlay(LevelOfPlay levelOfPlay) {
        this.levelOfPlay = levelOfPlay;
    }

    public GameJFrame getGameJFrame() {
        return gameJFrame;
    }

    public void setGameJFrame(GameJFrame gameJFrame) {
        this.gameJFrame = gameJFrame;
    }
        
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        yourCollection = new ArrayList();
        for(JButton x:answersJPanel.getButton()){
            yourCollection.add(Integer.valueOf( x.getActionCommand()));
            //System.out.println(answersCollection);
        }
        
        //Расположение scrollResultsJPanel
        //Значимость
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        //Увеличение компонента на заданое число пикселей
        gbc.ipadx = 0; //default 0
        gbc.ipady = 0; //default 0
        //Отступы от крайов
        gbc.insets = new Insets(10,10,10,10);
        //Выравнивание в ячейке
        gbc.anchor = GridBagConstraints.CENTER;
        //Координата в сетке
        gbc.gridx = GridBagConstraints.RELATIVE;
        //gbc.gridy = GridBagConstraints.REMAINDER;
        gbc.gridy ++;
        //Количество занимаемых ячеек
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        //Заполнение ячейки
        gbc.fill = GridBagConstraints.BOTH;

        
        JLabel resultsJLabel= new JLabel();
        gbl.setConstraints(resultsJLabel, gbc);
        
        //scrollResultsJPanel.setLayout(new GridLayout(0,1));
        
        //scrollResultsJPanel.add(jLabel);
        for(Integer x:yourCollection){
            //scrollResultsJPanel.setLayout(new FlowLayout());
            resultsJLabel= new JLabel(); 
            resultsJLabel.setIcon(new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource(AllElements.values()[x].getUrlAddress())).getImage().getScaledInstance(80, 60, Image.SCALE_SMOOTH)));
            gbl.setConstraints(resultsJLabel, gbc);
            scrollResultsJPanel.add(resultsJLabel);
        }
        //Передача варианта ответа для сравнения
        
        //gameJFrame.getPlayJPanel().getRandomCollection()
        
        
        gameJFrame.getPlayJPanel().getResultOfGuessing().setResultOfGuessing(yourCollection, gameJFrame.getPlayJPanel().getRandomCollection());
        
        resultsJLabel= new JLabel();
        resultsJLabel.setText("<html><h1>"+String.valueOf(gameJFrame.getPlayJPanel().getResultOfGuessing().getGuessedElements())+"</h1></html>");
        gbl.setConstraints(resultsJLabel, gbc);
        scrollResultsJPanel.add(resultsJLabel);
        
        resultsJLabel= new JLabel();
        resultsJLabel.setText(String.valueOf("<html><h1>"+gameJFrame.getPlayJPanel().getResultOfGuessing().getPositionElements())+"</h1></html>");
        gbl.setConstraints(resultsJLabel, gbc);
        scrollResultsJPanel.add(resultsJLabel);
        this.validate();
        
        //Окно поздравления
        if (gameJFrame.getPlayJPanel().getResultOfGuessing().getPositionElements() == levelOfPlay.getDefineSize()){
            timeGame = (System.currentTimeMillis() - gameJFrame.getTimeStart())/1000;
            int response = JOptionPane.showConfirmDialog(null,"Поздравляем!\nВаш результат: "+timeGame+" c. Хотите сохранить?", "Победа!", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
            switch (response){
                case (JOptionPane.YES_OPTION):{
                    //SaveResultsGame saveResultsGame = new SaveResultsGame(gamePanel, timeGame);
                    break;
                }
                default: {
                    //Новое окно игры
                    //gameJFrame.dispose();
                    gameJFrame.remove(gameJFrame.getActionJPanel());
                    //gameJFrame.remove(gameJFrame.getActionJPanel());
                    gameJFrame.setVisible(false);
                    
                    gameJFrame.setActionJPanel(gameJFrame.getStartJPanel());
                    gameJFrame.setVisible(true);
                    //EventQueue.invokeLater(new Runnable(){public void run(){GameFrame gameFrame = new GameFrame();}});
                }
                
            }

        }
        
        
    }
    
    
    
}
