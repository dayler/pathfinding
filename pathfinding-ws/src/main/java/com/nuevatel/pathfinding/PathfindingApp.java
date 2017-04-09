/**
 * 
 */
package com.nuevatel.pathfinding;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.ws.Endpoint;

import com.nuevatel.pathfinding.utils.ParameterUtils;
import com.nuevatel.pathfinding.ws.PathfindingWsService;
import com.nuevatel.pathfinding.ws.WsServer;

/**
 * <p>
 * The PathfindingApp class.
 * </p>
 * <p>
 * NuevaTel PCS de Bolivia S.A. (c) 2017
 * </p>
 * <p>
 * El contenido de este archivo esta clasificado como:
 * </p>
 * <p>
 * INFORMACION DE CONFIDENCIALIDAD ALTA
 * </p>
 * 
 * @author asalazar
 * @version 1.0 Apr 8, 2017
 * @since 1.8
 *
 */
public class PathfindingApp {
    
    private static Logger logger = Logger.getLogger(PathfindingApp.class.getName());
    
    private Config config;

    private WsServer wsServer = null;

    public PathfindingApp(Config config) {
        ParameterUtils.requiredNotNull(config, "config");
        //
        this.config = config;
    }

    public void start() {
        startWsi();
    }

    public void stop() {
        if (wsServer != null) {
            wsServer.stop();
        }
    }

    private void startWsi() {
        PathfindingWsService wsImpl = new PathfindingWsService();
        Set<Endpoint> endpointSet = new HashSet<>();
        endpointSet.add(Endpoint.create(wsImpl));
        try {
            // TODO authenticator
            wsServer = new WsServer(config.getAddress(), config.getPort(), config.getWsPoolSize(), 32, endpointSet, null);
            wsServer.start();
            logger.log(Level.INFO, "Http Server was started at " + config.getAddress() + ":" + config.getPort());
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Failed to start Http Server at " + config.getAddress() + ":" + config.getPort(), ex);
            stop();
        }
    }
}
