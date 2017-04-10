/**
 * 
 */
package com.nuevatel.pathfinding;

import java.util.Properties;

import com.nuevatel.pathfinding.utils.IntegerUtils;
import com.nuevatel.pathfinding.utils.ParameterUtils;

/**
 * <p>The Config class.</p>
 * <p>NuevaTel PCS de Bolivia S.A. (c) 2017</p>
 * <p>El contenido de este archivo esta clasificado como: </p>
 * <p>INFORMACION DE CONFIDENCIALIDAD ALTA </p>
 * 
 * @author asalazar
 * @version 1.0 Apr 8, 2017
 * @since 1.8
 *
 */
public class Config {
    
    private String address;
    
    private int port;
    
    private int wsPoolSize;
    
    private String user;
    
    private String password;
    
    private String dbPath;
    
    private String destinationNodeName;
    
    public Config(Properties properties) {
        ParameterUtils.requiredNotNull(properties, "properties");
        // 
        this.address = properties.getProperty("ws.bindAddrr");
        this.port = IntegerUtils.tryParse(properties.getProperty("ws.port"), 8080);
        wsPoolSize = IntegerUtils.tryParse(properties.getProperty("ws.poolSize"), 8);
        this.user = properties.getProperty("ws.user");
        this.password = properties.getProperty("ws.password");
        this.dbPath = properties.getProperty("db.source");
        this.destinationNodeName = properties.getProperty("destinationNodeName");
    }
    
    public String getDestinationNodeName() {
        return destinationNodeName;
    }
    
    public String getDbPath() {
        return dbPath;
    }
    
    public String getAddress() {
        return address;
    }

    public int getPort() {
        return port;
    }

    public int getWsPoolSize() {
        return wsPoolSize;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}
