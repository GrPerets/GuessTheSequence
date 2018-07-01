/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.guessthesequence.visual;

import com.mycompany.guessthesequence.logical.CollectionElements;
import com.mycompany.guessthesequence.logical.LevelOfPlay;
import com.mycompany.guessthesequence.logical.ResultOfGuessing;
import com.mycompany.guessthesequence.records.JobWithBase;
import com.mycompany.guessthesequence.records.Record;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author grperets
 */
public class ResultsJPanelImpl extends JPanel implements ResultsJPanel {
    private GridBagLayout gbl;
    private GridBagConstraints gbc;
    private JPanel scrollResultsJPanel;
    private long timeGame;
    private GameJFrame gameJFrame;
    
    private ArrayList<Integer> yourCollection;
    private AnswersJPanel answersJPanel;
    private LevelOfPlay levelOfPlay;
    private ResultOfGuessing resultOfGuessing;
    private CollectionElements collectionElements;
    private JLabel resultsJLabel;
        
    
    
    private Record record;
    private JobWithBase jobWithBase;
    
    
    public ResultsJPanelImpl() {
        BorderLayout borderLayout = new BorderLayout();
        setLayout(borderLayout);
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
       
        scrollResultsJPanel.setLayout(gbl); 
        
        
        JScrollPane scrollResultsPane = new JScrollPane(scrollResultsJPanel);
        add(scrollResultsPane); 
                
    }

    public CollectionElements getCollectionElements() {
        return collectionElements;
    }

    public void setCollectionElements(CollectionElements collectionElements) {
        this.collectionElements = collectionElements;
    }

    
    @Override
    public JPanel getResultsJPanel() {
        return this;
    }

    @Override
    public void setResultsJPanel(Object[]answersCollection) {
        //this.re = (ResultsJPanelImpl) resultsJPanel;
        
               
        //Расположение в scrollResultsJPanel
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

        
        resultsJLabel= new JLabel();
        gbl.setConstraints(resultsJLabel, gbc);
        
        //scrollResultsJPanel.setLayout(new GridLayout(0,1));
        
        //scrollResultsJPanel.add(jLabel);
        for(Object x:answersCollection){
            //scrollResultsJPanel.setLayout(new FlowLayout());
            resultsJLabel= new JLabel(); 
            resultsJLabel.setIcon(new ImageIcon(new ImageIcon(getClass().getClassLoader().getResource(AllElements.values()[(Integer)x].getUrlAddress())).getImage().getScaledInstance(80, 60, Image.SCALE_SMOOTH)));
            gbl.setConstraints(resultsJLabel, gbc);
            scrollResultsJPanel.add(resultsJLabel);
        }
        //Передача варианта ответа для сравнения
        resultOfGuessing.setGuessedElements(answersCollection, collectionElements.getCollectionElements());
        resultOfGuessing.setPositionElements(answersCollection, collectionElements.getCollectionElements());
        
        resultsJLabel= new JLabel();
        resultsJLabel.setText("<html><h1>"+String.valueOf(resultOfGuessing.getGuessedElements())+"</h1></html>");
        gbl.setConstraints(resultsJLabel, gbc);
        scrollResultsJPanel.add(resultsJLabel);
        
        resultsJLabel= new JLabel();
        resultsJLabel.setText(String.valueOf("<html><h1>"+resultOfGuessing.getPositionElements())+"</h1></html>");
        gbl.setConstraints(resultsJLabel, gbc);
        scrollResultsJPanel.add(resultsJLabel);
        
        validate();
        
        //Окно поздравления
        if (resultOfGuessing.getPositionElements() == levelOfPlay.getDefineSize()){
            timeGame = (System.currentTimeMillis() - gameJFrame.getTimeStart())/1000;
            int response = JOptionPane.showConfirmDialog(null,"Поздравляем!\nВаш результат: "+timeGame+" c. Хотите сохранить?", "Победа!", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
            switch (response){
                case (JOptionPane.YES_OPTION):{
                    String nameGamer = (String)JOptionPane.showInputDialog(null,"Ваше имя:", "Сохранение результатов", JOptionPane.PLAIN_MESSAGE, null, null, "Ваше имя");
                    record.setNameGamer(nameGamer);
                    record.setDefineSize(levelOfPlay.getDefineSize());
                    record.setCollectionSize(levelOfPlay.getCollectionSize());
                    record.setTimeGame(timeGame);
                    jobWithBase.insert(record);
                    
                    //SaveResultsGame saveResultsGame = new SaveResultsGame(gamePanel, timeGame);
                    break;
                }
                default: {
                    //Новое окно игры
                    //gameJFrame.dispose();
                    gameJFrame.getGameJFrame().remove(gameJFrame.getActionJPanel());
                    //gameJFrame.remove(gameJFrame.getActionJPanel());
                    gameJFrame.getGameJFrame().setVisible(false);
                    
                    gameJFrame.setActionJPanel(gameJFrame.getStartJPanel().getStartJPanel());
                    gameJFrame.getGameJFrame().setVisible(true);
                    //EventQueue.invokeLater(new Runnable(){public void run(){GameFrame gameFrame = new GameFrame();}});
                }
                
            }

        }
        
        
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

    public ResultOfGuessing getResultOfGuessing() {
        return resultOfGuessing;
    }

    public void setResultOfGuessing(ResultOfGuessing resultOfGuessing) {
        this.resultOfGuessing = resultOfGuessing;
    }
    
    

    public GameJFrame getGameJFrame() {
        return gameJFrame;
    }

    public void setGameJFrame(GameJFrame gameJFrame) {
        this.gameJFrame = gameJFrame;
    }

    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }

    public JobWithBase getJobWithBase() {
        return jobWithBase;
    }

    public void setJobWithBase(JobWithBase jobWithBase) {
        this.jobWithBase = jobWithBase;
    }
      
    
}
