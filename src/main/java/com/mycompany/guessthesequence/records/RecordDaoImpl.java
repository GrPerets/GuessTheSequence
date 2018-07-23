/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.guessthesequence.records;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author grperets
 */
public class RecordDaoImpl implements RecordDao{
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public RecordDaoImpl() {
    }
    
    

    @Override
    public Record findBest() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(Record record) {
        String sqlQuery = "insert into records (nameGamer, defineSize, collectionSize, timeGame) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sqlQuery, new Object[]{record.getNameGamer(), record.getDefineSize(), record.getCollectionSize(), record.getTimeGame()});
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    
    
}
