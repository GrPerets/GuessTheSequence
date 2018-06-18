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
public class ResultOfGuessing implements ComparisonOfCollections{
    private int guessedElements; //Угадано елементов
    private int positionElements; //Елементы на своих местах
    private int sameElements;
    private int inTheirPlaces;
    
    public ResultOfGuessing() {
    
    }

    public int getGuessedElements() {
        return guessedElements;
    }

    public int getPositionElements() {
        return positionElements;
    }

        
    public void setResultOfGuessing(Collection yourCollection, Collection randomCollection) {
        
        guessedElements=0;
        positionElements=0;
        int indexX=0;
        
        if((yourCollection!=null)&&(randomCollection!=null))
        for(Object x: yourCollection){
            indexX++;
            int indexY=0;
            for(Object y: randomCollection){
                indexY++;
                if(x.equals(y)) {
                    ++guessedElements;
                    if(indexX==indexY) ++positionElements;
                }
            }
        } 
    }

    @Override
    public int getSameElements() {
        return sameElements;        
    }

    @Override
    public int getInTheirPlaces() {
        return inTheirPlaces;
    }
   
}
