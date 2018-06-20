/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.guessthesequence.logical;

import java.util.Collection;

/**
 *
 * @author grperets
 */
public class ResultOfGuessingImpl implements ResultOfGuessing {
    private int guessedElements; //Угадано елементов
    private int positionElements; //Елементы на своих местах
        
    public ResultOfGuessingImpl() {
    
    }

    @Override
    public int getGuessedElements() {
        return guessedElements;
    }

    @Override
    public int getPositionElements() {
        return positionElements;
    }

    @Override
    public void setGuessedElements(Object[] collection1, Object[] collection2) {
        guessedElements=0;
        
        int indexX=0;
        
        if((collection1!=null)&&(collection2!=null))
        for(Object x: collection1){
            indexX++;
            int indexY=0;
            for(Object y: collection2){
                indexY++;
                if(x.equals(y)) {
                    ++guessedElements;
                }
            }
        } 
    }

    @Override
    public void setPositionElements(Object[] collection1, Object[] collection2) {
        positionElements=0;
        int indexX=0;
        
        if((collection1!=null)&&(collection2!=null))
        for(Object x: collection1){
            indexX++;
            int indexY=0;
            for(Object y: collection2){
                indexY++;
                if(x.equals(y)) {
                    if(indexX==indexY){
                        ++positionElements;
                    }
                }
            }
        } 
    }

   
}
