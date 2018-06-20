/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.guessthesequence.visual;

import com.mycompany.guessthesequence.logical.LevelOfPlay;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;

/**
 *
 * @author grperets
 */
public class CollectionSizeJSlider extends JSlider{
    private LevelOfPlay levelOfPlay;
    private JSlider defineSizeJSlider;

    public CollectionSizeJSlider(int min, int max, int value) {
        super(min, max, value);
        //Маркеры
        setMajorTickSpacing(1);
        setPaintTicks(true);
        //Подписи к маркерам
        setLabelTable(createStandardLabels(1));
        setPaintLabels(true);
                
        //Слушатель
               
        addChangeListener((ChangeEvent ce) -> {
            if(getValueIsAdjusting()) return;
            
            defineSizeJSlider.setMaximum(getValue());
            defineSizeJSlider.setValue(Math.round(getValue()/2));
            
            levelOfPlay.setCollectionSize(getValue());
            
        });
    }

    public LevelOfPlay getLevelOfPlay() {
        return levelOfPlay;
    }

    public void setLevelOfPlay(LevelOfPlay levelOfPlay) {
        this.levelOfPlay = levelOfPlay;
    }

        

    public JSlider getDefineSizeJSlider() {
        return defineSizeJSlider;
    }

    public void setDefineSizeJSlider(JSlider defineSizeJSlider) {
        this.defineSizeJSlider = defineSizeJSlider;
    }

    
    
    
}
