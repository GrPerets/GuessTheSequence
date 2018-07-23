/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.guessthesequence.records;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.sql.DataSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

/**
 *
 * @author grperets
 */
@Repository("recordDao")
public class RecordDaoImpl implements RecordDao{
    private DataSource dataSource;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private InsertRecord insertRecord;

    public RecordDaoImpl() {
    }
    
    

    @Override
    public List<Record> findAll() {
        String sql = "select id, nameGamer, defineSize, collectionSize, timeGame from record";
        return namedParameterJdbcTemplate.query(sql, (rs, rowNum)-> {
            Record record = new Record();
            record.setId(rs.getLong("id"));
            record.setNameGamer(rs.getString("nameGamer"));
            record.setDefineSize(rs.getInt("defineSize"));
            record.setCollectionSize(rs.getInt("collectionSize"));
            record.setTimeGame(rs.getInt("timeGame"));
            
            return record;
        });
    }

    @Override
    public void insert(Record record) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("nameGamer", record.getNameGamer());
        paramMap.put("defineSize", record.getDefineSize());
        paramMap.put("collectionSize", record.getCollectionSize());
        paramMap.put("timeGame", record.getTimeGame());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        insertRecord.updateByNamedParam(paramMap, keyHolder);
        record.setId(keyHolder.getKey().longValue());
        
        
}

    @Resource(name="dataSource")
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        this.insertRecord = new InsertRecord(dataSource);
    }
    
    
    
}
