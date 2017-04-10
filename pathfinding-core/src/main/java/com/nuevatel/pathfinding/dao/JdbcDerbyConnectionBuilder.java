/**
 * 
 */
package com.nuevatel.pathfinding.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import com.nuevatel.pathfinding.exception.FailedOnCreateDbConnectionException;
import com.nuevatel.pathfinding.utils.ParameterUtils;

/**
 * <p>The JdbcDerbyConnectionBuilder class.</p>
 * <p>NuevaTel PCS de Bolivia S.A. (c) 2017</p>
 * <p>El contenido de este archivo esta clasificado como: </p>
 * <p>INFORMACION DE CONFIDENCIALIDAD ALTA </p>
 * 
 * @author asalazar
 * @version 1.0 Apr 9, 2017
 * @since 1.8
 *
 */
public class JdbcDerbyConnectionBuilder {
    
    private String pathToDbFile;
    
    public JdbcDerbyConnectionBuilder(String pathToDbFile) {
        ParameterUtils.requiredNotEmpty(pathToDbFile, "null pathToDbFile.");
        // 
        this.pathToDbFile = pathToDbFile;
    }
    
    public Connection buildConnection() throws FailedOnCreateDbConnectionException {
        String connString = String.format("jdbc:derby:%s", pathToDbFile);
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            return DriverManager.getConnection(connString);
        } catch (Exception ex) {
            throw new FailedOnCreateDbConnectionException(pathToDbFile, ex);
        }
    }
    
}
