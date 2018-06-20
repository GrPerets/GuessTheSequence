/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.guessthesequence.logical;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

/**
 *
 * @author grperets
 */
public class RandomCollection implements CollectionElements{
    
    private Object[] randomCollectionElements;
    
    public RandomCollection() {
                
    }
    
    @Override
    public Object[] getCollectionElements() {
        return randomCollectionElements;
    }

    @Override
    public void setCollectionElements(LevelOfPlay levelOfPlay) {
        //this.collectionElements = collectionElements;
        randomCollectionElements = new Object[levelOfPlay.getDefineSize()];
        Object[] collectionElements = new Object[levelOfPlay.getCollectionSize()];
        
        for(int i=0;i<collectionElements.length;i++){
            collectionElements[i]=i;
        }
                
        if(collectionElements!=null){
            int collectionSize=collectionElements.length;
        
            //Object[] arrayCollectionElements=collectionElements.toArray();
        
            for(int i=0; i < randomCollectionElements.length;i++){
                int randomPosition = new Random().nextInt(collectionSize);
                randomCollectionElements[i]=collectionElements[randomPosition];
                collectionElements[randomPosition]=collectionElements[--collectionSize];
            }
        }
        
    }
           
}
