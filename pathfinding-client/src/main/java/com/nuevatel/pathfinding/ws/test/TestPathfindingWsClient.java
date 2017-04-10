/**
 * 
 */
package com.nuevatel.pathfinding.ws.test;

import java.net.MalformedURLException;
import java.net.URL;

import com.nuevatel.pathfinding.utils.IntegerUtils;
import com.nuevatel.pathfinding.ws.client.PathResponse;
import com.nuevatel.pathfinding.ws.client.Pathfinding;
import com.nuevatel.pathfinding.ws.client.PathfindingWSPort;

/**
 * <p>The TestClient class.</p>
 * <p>NuevaTel PCS de Bolivia S.A. (c) 2017</p>
 * <p>El contenido de este archivo esta clasificado como: </p>
 * <p>INFORMACION DE CONFIDENCIALIDAD ALTA </p>
 * 
 * 
 * @author asalazar
 * @version 1.0 Apr 9, 2017
 * @since 1.8
 *
 */
public class TestPathfindingWsClient {
    
    /**
     * 
     * @param args address port addressName
     */
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Use: java TestPathfindingWsClient <ip address> <port> <intersection name>");
            return;
        }
        try {
            TestApp app = new TestApp(args[0], IntegerUtils.tryParse(args[1], 8080), args[2]);
            app.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(-1);
        }
    }
    
    /**
     * Test application.
     */
    private static class TestApp {
        
        private String address;
        
        private int port;
        
        private String intersection;
        
        public TestApp(String address, int port, String intersection) {
            this.address = address;
            this.port = port;
            this.intersection = intersection;
        }
        
        void execute() throws MalformedURLException {
            Pathfinding provider = new Pathfinding(new URL(String.format("http://%s:%s/ws/PathfindingWsService?wsdl", address, port)));
            PathfindingWSPort port = provider.getPathfindingWsServicePort();
            PathResponse response = port.getPath(intersection);
            System.out.println("Initial intesection:" + intersection + " fastest way:" + response.getRouteList().getRoute() + " total distance:" + response.getTotalDistance());
        }
        
    }
}
