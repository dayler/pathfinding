/**
 * 
 */
package com.nuevatel.pathfinding.ws;

import java.util.ArrayList;
import java.util.Arrays;

import javax.jws.WebService;

import com.nuevatel.pathfinding.ws.domain.PathResponse;

/**
 * <p>The PathfindingWsService class.</p>
 * <p>NuevaTel PCS de Bolivia S.A. (c) 2017</p>
 * <p>El contenido de este archivo esta clasificado como: </p>
 * <p>INFORMACION DE CONFIDENCIALIDAD ALTA </p>
 * 
 * End point WS.
 * 
 * @author asalazar
 * @version 1.0 Apr 8, 2017
 * @since 1.8
 */
@WebService(endpointInterface="com.nuevatel.pathfinding.ws.PathfindingWs", serviceName="pathfinding")
public class PathfindingWsService implements PathfindingWs {

    /* (non-Javadoc)
     * @see com.nuevatel.pathfinding.ws.PathfindingWS#getPath(java.lang.String)
     */
    @Override
    public PathResponse getPath(String fromPoint) {
        return new PathResponse("fromPoint", new ArrayList<>(Arrays.asList("route1", "route2")));
    }
}
