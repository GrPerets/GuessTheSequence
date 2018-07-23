/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.guessthesequence.records;

import java.sql.Types;
import javax.sql.DataSource;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

/**
 *
 * @author grperets
 */
public class InsertRecord extends SqlUpdate{
    private static final String SQL_INSERT_RECORD = "insert into record (nameGamer, defineSize, collectionSize, timeGame) values (:nameGamer, :defineSize, :collectionSize, :timeGame)";
    
    public InsertRecord(DataSource dataSource){
        super (dataSource, SQL_INSERT_RECORD);
        super.declareParameter(new SqlParameter("nameGamer", Types.VARCHAR));
        super.declareParameter(new SqlParameter("defineSize", Types.INTEGER));
        super.declareParameter(new SqlParameter("collectionSize", Types.INTEGER));
        super.declareParameter(new SqlParameter("timeGame", Types.INTEGER));
        super.setGeneratedKeysColumnNames(new String[] {"id"});
        super.setReturnGeneratedKeys(true);
    }
    
}
