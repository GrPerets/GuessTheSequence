/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.guessthesequence.logical;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 *
 * @author grperets
 */
@Component("levelOfPlay")
public class LevelOfPlayImpl implements  LevelOfPlay, InitializingBean{
    private int defineSize;
    private int collectionSize;

    public LevelOfPlayImpl() {
    }
     
    
    @Override
    public int getCollectionSize() {
        return collectionSize;
    }

    @Override
    public void setCollectionSize(int collectionSize) {
        this.collectionSize = collectionSize;
    }

    @Override
    public int getDefineSize() {
        return defineSize;
    }

    @Override
    public void setDefineSize(int defineSize) {
        this.defineSize = defineSize;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if(defineSize==0)defineSize=4;
        if(collectionSize==0)collectionSize=10;
    }
   
    
    
}
