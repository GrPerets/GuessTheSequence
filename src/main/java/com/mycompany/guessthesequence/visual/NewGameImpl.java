/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.guessthesequence.visual;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 *
 * @author grperets
 */
//@Component("newGame")
@Aspect
public class NewGameImpl{
    /*
    @Autowired
    private PlayJPanel playJPanel;
    @Autowired
    private LevelOfPlay levelOfPlay;
    @Autowired
    private CollectionElements collectionElements;
*/
    
    
    @Pointcut("execution(* com.mycompany.guessthesequence.visual.GameJFrame.actionPerformed(..))")
    public void startNewGame(){
    }
    
    @Before("startNewGame()")
    public void parameterNewGame(){
        System.out.println("bn--------------------------nm");
        /*
        playJPanel.getButtonsJPanel().setButtonsJPanel(levelOfPlay);
        playJPanel.getAnswersJPanel().setAnswersJPanel(levelOfPlay);
        collectionElements.setCollectionElements(levelOfPlay);
        */
    }
    
    
    
    
}
