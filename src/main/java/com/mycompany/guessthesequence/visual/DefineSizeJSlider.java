/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.guessthesequence.visual;

import com.mycompany.guessthesequence.logical.DifficultyOfGame;
import com.mycompany.guessthesequence.logical.LevelOfPlay;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;

/**
 *
 * @author grperets
 */
public class DefineSizeJSlider extends JSlider{
    private DifficultyOfGame difficultyOfGame;
    

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
            this.difficultyOfGame.setDefineSize(getValue());
        });
    }

    public DifficultyOfGame getDifficultyOfGame() {
        return difficultyOfGame;
    }

    public void setDifficultyOfGame(DifficultyOfGame difficultyOfGame) {
        this.difficultyOfGame = difficultyOfGame;
    }

    
       
    
}
