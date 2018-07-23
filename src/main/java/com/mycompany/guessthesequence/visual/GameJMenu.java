/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.guessthesequence.visual;

import com.mycompany.guessthesequence.records.Record;
import com.mycompany.guessthesequence.records.RecordDao;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author grperets
 */
@Component
public class GameJMenu extends JMenuBar{
    private RecordDao recordDao;
            
    public GameJMenu() {
        JMenu fileMenu = new JMenu("<html><h3>File</h3></html>");
        add(fileMenu);
        JMenuItem newFileMenu = new JMenuItem("<html><h3>New game</h3></html>");
        fileMenu.add(newFileMenu);
        JMenu helpMenu = new JMenu("<html><h3>Help</h3></html>");
        add(helpMenu);
        JMenuItem rulesHelpMenu = new JMenuItem("<html><h3>Rules game</h3></html>");
        helpMenu.add(rulesHelpMenu);
        
        JMenuItem recordsHelpMenu = new JMenuItem("<html><h3>Records</h3></html>");
        helpMenu.add(recordsHelpMenu);
              
        //Окно рекордов
        recordsHelpMenu.addActionListener((ae)->{JDialog recordsDialog = new JDialog();
        recordsDialog.setTitle("Рекорды");
        recordsDialog.setSize(400, 400);
        recordsDialog.setLocationRelativeTo(null);
        
        
        BorderLayout borderLayout = new BorderLayout();
        recordsDialog.setLayout(borderLayout);
        JPanel titleJPanel = new JPanel();
        recordsDialog.add(titleJPanel,BorderLayout.NORTH);
        GridLayout gridLayout = new GridLayout(1,0);
        titleJPanel.setLayout(gridLayout);
        
        
        JLabel titleJLabel = new JLabel("<html><h1>Логин</h1></html>");
        titleJPanel.add(titleJLabel);
        titleJLabel = new JLabel("<html><h1>Уровень</h1></html>");
        titleJPanel.add(titleJLabel);
        titleJLabel = new JLabel("<html><h1>Время</h1></html>");
        titleJPanel.add(titleJLabel);
        
        
        
        JPanel scrollRecordsJPanel = new JPanel();
        
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        scrollRecordsJPanel.setLayout(gbl); 
               
        
        JScrollPane scrollRecordsPane = new JScrollPane(scrollRecordsJPanel);
        recordsDialog.add(scrollRecordsPane); 
               
        JLabel recordJLabel;
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
        
        //Количество занимаемых ячеек
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        //Заполнение ячейки
        gbc.fill = GridBagConstraints.BOTH;

        
        recordJLabel= new JLabel();
        gbl.setConstraints(recordJLabel, gbc);
                        
        List<Record> records = recordDao.findAll();
        for(Record record: records){  
            gbc.gridy ++;
            recordJLabel= new JLabel();
            recordJLabel.setText("<html><h1>"+record.toString()+"</h1></html>");
            gbl.setConstraints(recordJLabel, gbc);    
            scrollRecordsJPanel.add(recordJLabel);
            
        }
        
        recordsDialog.setVisible(true);});
        
    }
    @Autowired
    public void setRecordDao(RecordDao recordDao) {
        this.recordDao = recordDao;
    }
   
    
}
