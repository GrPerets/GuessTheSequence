/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.guessthesequence.records;

import javax.sql.DataSource;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author grperets
 */
public class JobWithBase implements InitializingBean{
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public JobWithBase() {
    }

    
    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    public void insert(Record record){
        String sqlQuery = "insert into records (nameGamer, defineSize, collectionSize, timeGame) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sqlQuery, new Object[]{record.getNameGamer(), record.getDefineSize(), record.getCollectionSize(), record.getTimeGame()});
    }

    

    
   

    @Override
    public void afterPropertiesSet() throws Exception {
        if(dataSource==null)
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
