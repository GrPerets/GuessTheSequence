/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.guessthesequence.logical;

import org.springframework.beans.factory.InitializingBean;

/**
 *
 * @author grperets
 */
public class LevelOfPlay implements InitializingBean{
    private int defineSize;
    private int collectionSize;

    public LevelOfPlay() {
    }
     
    
    public int getCollectionSize() {
        return collectionSize;
    }

    public void setCollectionSize(int collectionSize) {
        this.collectionSize = collectionSize;
    }

    public int getDefineSize() {
        return defineSize;
    }

    public void setDefineSize(int defineSize) {
        this.defineSize = defineSize;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if(defineSize==0)defineSize=4;
        if(collectionSize==0)collectionSize=10;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    
    
}
