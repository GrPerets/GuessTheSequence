/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.guessthesequence.visual;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 *
 * @author grperets
 */
@Component("startJPanel")
public class StartJPanelImpl extends JPanel implements StartJPanel{
    
    private final GridBagLayout gbl;
    private final GridBagConstraints gbc;  
    private DefineSizeJSlider defineSizeJSlider;
    private CollectionSizeJSlider collectionSizeJSlider;    
    private JButton startJButton;
    private GameJFrame gameJFrame;
           
    
    public StartJPanelImpl() {
        gbl = new GridBagLayout();
        gbc = new GridBagConstraints();
        setLayout(gbl);
        
        //Color newColor = new Color(125,125,125);
        //setBackground(newColor);
              
                
        //Панель правил игры
        //RulesOfGamePanel rulesOfGamePanel = new RulesOfGamePanel();
        
        JPanel rulesOfGamePanel = new JPanel();
        
        //Расположение панели правил игры
        //Значимость
        gbc.weightx = 1.0;
        gbc.weighty = 5.0;
        //Увеличение компонента на заданое число пикселей
        gbc.ipadx = 0; //default 0
        gbc.ipady = 0; //default 0
        //Отступы от краев
        gbc.insets = new Insets(10,10,10,10);
        //Выравнивание в ячейке
        gbc.anchor = GridBagConstraints.CENTER;
        //Координата в сетке
        gbc.gridx = 0;
        gbc.gridy = 2;
        //Количество занимаемых ячеек
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        //Заполнение ячейки
        gbc.fill = GridBagConstraints.BOTH;

        gbl.setConstraints(rulesOfGamePanel, gbc);
        
        //Добавление панели правил
        add(rulesOfGamePanel);
        
        
                
    }
    
    
    public GameJFrame getGameJFrame() {
        return gameJFrame;
    }
    @Autowired
    public void setGameJFrame(GameJFrame gameJFrame) {
        this.gameJFrame = gameJFrame;
    }

    @Override
    public CollectionSizeJSlider getCollectionSizeJSlider() {
        return collectionSizeJSlider;
    }
    @Autowired
    public void setCollectionSizeJSlider(CollectionSizeJSlider collectionSizeJSlider) {
         this.collectionSizeJSlider = collectionSizeJSlider;
               
        //Управление сложностью
        //Размер коллекции
        JLabel collectionSizeLabel = new JLabel("<html><h1>Из скольких элементов?</h1></html>");
        //Расположение на панели 
        //Значимость
        gbc.weightx = 1.0;
        gbc.weighty = 0.0;
        //Увеличение компонента на заданое число пикселей
        gbc.ipadx = 0; //default 0
        gbc.ipady = 0; //default 0
        //Отступы от краев
        gbc.insets = new Insets(10,10,10,10);
        //Выравнивание в ячейке
        gbc.anchor = GridBagConstraints.CENTER;
        //Координата в сетке
        gbc.gridx = 2;
        gbc.gridy = 0;
        //Количество занимаемых ячеек
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        //Заполнение ячейки
        gbc.fill = GridBagConstraints.BOTH;

        gbl.setConstraints(collectionSizeLabel, gbc);
        
        //Подпись ползунка Размер коллекции
        add(collectionSizeLabel);
        
        //Линейный регулятор
        //Координата в сетке
        gbc.gridx = 2;
        gbc.gridy = 1;
               
        gbl.setConstraints(collectionSizeJSlider, gbc);
        add(collectionSizeJSlider);
        
        
        
    }

    @Override
    public DefineSizeJSlider getDefineSizeJSlider() {
        return defineSizeJSlider;
    }
    @Autowired
    public void setDefineSizeJSlider(DefineSizeJSlider defineSizeJSlider) {
        this.defineSizeJSlider = defineSizeJSlider;
        //Управление сложностью
        //Количество выбираемых элементов
        JLabel defineSizeLabel = new JLabel("<html><h1>Сколько элементов?</h1></html>");
        //Расположение на панели 
        //Значимость
        gbc.weightx = 1.0;
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
        gbc.gridy = 0;
        //Количество занимаемых ячеек
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        //Заполнение ячейки
        gbc.fill = GridBagConstraints.BOTH;

        gbl.setConstraints(defineSizeLabel, gbc);
        
        //Подпись к плзунку Количество выбираемых элементов
        add(defineSizeLabel);
        
        //Линейный регулятор
        //Координата в сетке
        gbc.gridx = 0;
        gbc.gridy = 1;
        
        
        gbl.setConstraints(defineSizeJSlider, gbc);
        add(defineSizeJSlider);
        
    }
    
    @Override
    public JButton getStartJButton() {
        return startJButton;
    }
    @Autowired
    public void setStartJButton(JButton startJButton) {
        this.startJButton = startJButton;
        //Кнопка старта игры
        
        startJButton.setText("<html><h1>Старт</h1></html>");
        
        //Расположение startButton
        //Значимость
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        //Увеличение компонента на заданое число пикселей
        gbc.ipadx = 0; //default 0
        gbc.ipady = 0; //default 0
        //Отступы от краев
        gbc.insets = new Insets(10,10,10,10);
        //Выравнивание в ячейке
        gbc.anchor = GridBagConstraints.CENTER;
        //Координата в сетке
        gbc.gridx = 1;
        gbc.gridy = 0;
        //Количество занимаемых ячеек
        gbc.gridwidth = 1;
        gbc.gridheight = 2;
        //Заполнение ячейки
        gbc.fill = GridBagConstraints.BOTH;

        gbl.setConstraints(startJButton, gbc);
        
        
        //Слушатель для кнопки старт
        startJButton.addActionListener(gameJFrame);
        
        //Добавление кнопки старт
        add(startJButton);
    }

    @Override
    public JPanel getStartJPanel() {
        return this;
    }
    
    
}
