/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.guessthesequence.records;

import java.util.List;

/**
 *
 * @author grperets
 */
public interface RecordDao {
    List<Record> findAll();
    void insert(Record record);
    
}
