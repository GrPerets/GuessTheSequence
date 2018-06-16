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
public class RandomCollection extends ArrayList{
    private RandomCollection randomCollection;

    public RandomCollection() {
                
    }

    public RandomCollection getRandomCollection(LevelOfPlay levelOfPlay) {
        Collection collectionElements= new ArrayList();
        
        for(int i=0;i<levelOfPlay.getCollectionSize();i++){
            collectionElements.add(i);
        }
                
        if(!collectionElements.isEmpty()){
            int collectionSize=collectionElements.size();
        
            Object[] arrayCollectionElements=collectionElements.toArray();
        
            for(int i=0; i < levelOfPlay.getDefineSize();i++){
                int randomPosition = new Random().nextInt(collectionSize);
                add(arrayCollectionElements[randomPosition]);
                arrayCollectionElements[randomPosition]=arrayCollectionElements[--collectionSize];
            }
        }
        return randomCollection;
    }

    public void setRandomCollection(RandomCollection randomCollection) {
        this.randomCollection = randomCollection;
        
        
    }
       
}
