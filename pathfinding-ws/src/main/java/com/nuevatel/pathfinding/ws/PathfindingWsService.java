/**
 * 
 */
package com.nuevatel.pathfinding.ws;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.jws.WebService;

import com.nuevatel.pathfinding.dijkstra.DijkstraPathfinding;
import com.nuevatel.pathfinding.dijkstra.domain.Node;
import com.nuevatel.pathfinding.exception.NullSourceException;
import com.nuevatel.pathfinding.utils.ParameterUtils;
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
    
    private DijkstraPathfinding processor = null;
    
    public PathfindingWsService() {
        // No op.
    }
    
    public PathfindingWsService(DijkstraPathfinding processor, String destinationNodeName) {
        ParameterUtils.requiredNotNull(processor, "null Djikstra processor.");
        ParameterUtils.requiredNotEmpty(destinationNodeName, "null or empty destinationNodeName.");
        // 
        this.processor = processor;
        Node source = Optional.ofNullable(processor.getNodeFromName(destinationNodeName))
                              .orElseThrow(() -> new NullSourceException(destinationNodeName));
        // process all nodes.
        processor.execute(source);
    }
    
    /* (non-Javadoc)
     * @see com.nuevatel.pathfinding.ws.PathfindingWS#getPath(java.lang.String)
     */
    @Override
    public PathResponse getPath(String fromPoint) {
        Node target = processor.getNodeFromName(fromPoint);
        if (target != null) {
            List<Node>nodeList = processor.getPath(target);
            return new PathResponse(fromPoint,
                                    processor.getShortestDistance(target),
                                    nodeList.stream().map(n -> n.getName()).collect(Collectors.toList()));
        }
        
        return new PathResponse(fromPoint, 0, Collections.emptyList());
    }
}
