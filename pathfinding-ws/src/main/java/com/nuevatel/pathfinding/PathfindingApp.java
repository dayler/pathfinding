/**
 * 
 */
package com.nuevatel.pathfinding;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.ws.Endpoint;

import com.nuevatel.pathfinding.dao.GraphDao;
import com.nuevatel.pathfinding.dao.JdbcDerbyConnectionBuilder;
import com.nuevatel.pathfinding.dijkstra.DijkstraPathfinding;
import com.nuevatel.pathfinding.dijkstra.domain.Graph;
import com.nuevatel.pathfinding.exception.FailedOnCreateDbConnectionException;
import com.nuevatel.pathfinding.exception.GraphDaoException;
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
    
    private Graph graph = null;
    
    public PathfindingApp(Config config) {
        ParameterUtils.requiredNotNull(config, "config");
        //
        this.config = config;
    }

    public void start() {
        try {
            initGraph();
            startWsi();
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Failed to initialize PathfindingApp.", ex);
            stop();
        }
    }

    public void stop() {
        if (wsServer != null) {
            wsServer.stop();
        }
        logger.log(Level.INFO, "All process was stopped.");
    }
    
    private void initGraph() throws FailedOnCreateDbConnectionException, SQLException, GraphDaoException {
        // create connection.
        JdbcDerbyConnectionBuilder builder = new JdbcDerbyConnectionBuilder(config.getDbPath());
        try (Connection conn = builder.buildConnection()) {
            // get graph from dao.
            GraphDao graphDao = new GraphDao();
            Graph graph = graphDao.getGraph(conn);
            this.graph = graph;
        }
    }
    
    private void startWsi() {
        PathfindingWsService wsImpl = new PathfindingWsService(new DijkstraPathfinding(graph), config.getDestinationNodeName());
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
