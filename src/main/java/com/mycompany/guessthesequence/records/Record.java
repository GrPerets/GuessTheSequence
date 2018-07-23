/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.guessthesequence.records;

/**
 *
 * @author grperets
 */
public class Record {
    private long id;
    private String nameGamer;
    private int defineSize;
    private int collectionSize;
    private long timeGame;

    public Record() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameGamer() {
        return nameGamer;
    }

    public void setNameGamer(String nameGamer) {
        this.nameGamer = nameGamer;
    }

    public int getDefineSize() {
        return defineSize;
    }

    public void setDefineSize(int defineSize) {
        this.defineSize = defineSize;
    }

    public int getCollectionSize() {
        return collectionSize;
    }

    public void setCollectionSize(int collectionSize) {
        this.collectionSize = collectionSize;
    }

    public long getTimeGame() {
        return timeGame;
    }

    public void setTimeGame(long timeGame) {
        this.timeGame = timeGame;
    }
    
    @Override
    public String toString(){
        return null;        
    }
    
}
