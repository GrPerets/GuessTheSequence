/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.guessthesequence.visual;

import com.mycompany.guessthesequence.logical.LevelOfPlay;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author grperets
 */
@Component
public class DefineSizeJSlider extends JSlider{
    @Autowired
    private LevelOfPlay levelOfPlay;

    
    
    public DefineSizeJSlider() {
    }
        
    public DefineSizeJSlider(int min, int max, int value) {
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
            this.levelOfPlay.setDefineSize(getValue());
        });
    }

    public LevelOfPlay getLevelOfPlay() {
        return levelOfPlay;
    }

    public void setLevelOfPlay(LevelOfPlay levelOfPlay) {
        this.levelOfPlay = levelOfPlay;
    }

        
}
