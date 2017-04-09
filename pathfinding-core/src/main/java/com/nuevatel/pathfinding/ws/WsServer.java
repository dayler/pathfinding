/**
 * 
 */
package com.nuevatel.pathfinding.ws;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.ws.Endpoint;

import com.sun.net.httpserver.Authenticator;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpServer;

/**
 * <p>The WsServer class.</p>
 * <p>NuevaTel PCS de Bolivia S.A. (c) 2017</p>
 * <p>El contenido de este archivo esta clasificado como: </p>
 * <p>INFORMACION DE CONFIDENCIALIDAD ALTA </p>
 * 
 * @author asalazar
 * @version 1.0 Apr 8, 2017
 * @since 1.8
 *
 */
@SuppressWarnings("restriction")
public class WsServer {
    
    private static Logger logger = Logger.getLogger(WsServer.class.getName());
    
    /**
     * The HttpServer.
     */
    private HttpServer httpServer;
    
    /**
     * End points.
     */
    private Set<Endpoint>enpointSet;
    
    /**
     * Basic authenticator.
     */
    private Authenticator authenticator;
    
    /**
     * Bind address.
     */
    private InetAddress bindAddr = null;
    
    private int port;
    
    private int poolSize;
    
    private int backlog;

    public WsServer(String bindAddr,
                    int port,
                    int poolSize,
                    int backlog,
                    Set<Endpoint> endpointSet,
                    Authenticator authenticator) throws UnknownHostException {
        this.bindAddr = bindAddr == null || bindAddr.equalsIgnoreCase("all") ? null : InetAddress.getByName(bindAddr);
        this.port = port;
        this.poolSize = poolSize;
        this.backlog = backlog;
        this.enpointSet = endpointSet == null ? Collections.emptySet() : endpointSet;
        this.authenticator = authenticator;
    }
    
    /**
     * Start WS server.
     * @throws IOException
     */
    public void start() throws IOException {
        httpServer = HttpServer.create(new InetSocketAddress(bindAddr, port), backlog);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(poolSize, poolSize, 16, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        executor.allowCoreThreadTimeOut(true);
        httpServer.setExecutor(executor);
        enpointSet.stream().forEach(endpoint -> createEndPointContext(endpoint));
        httpServer.start();
    }
    
    private void createEndPointContext(Endpoint endpoint) {
        String contextPath = "/ws/" + endpoint.getImplementor().getClass().getSimpleName();
        HttpContext context = httpServer.createContext(contextPath);
        logger.log(Level.INFO, "Context: " + contextPath);
        if (authenticator != null) {
            context.setAuthenticator(authenticator);
        }
        endpoint.publish(context);
    }

    /**
     * Stop WS server.
     */
    public void stop() {
        enpointSet.forEach(Endpoint::stop);
        if (httpServer != null) {
            httpServer.stop(0);
            ((ExecutorService)httpServer.getExecutor()).shutdownNow();
        }
    }
}
