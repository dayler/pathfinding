/**
 * 
 */
package com.nuevatel.pathfinding.dijkstra.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>The Graph class.</p>
 * <p>NuevaTel PCS de Bolivia S.A. (c) 2017</p>
 * <p>El contenido de este archivo esta clasificado como: </p>
 * <p>INFORMACION DE CONFIDENCIALIDAD ALTA </p>
 * 
 * @author asalazar
 * @version 1.0 Apr 9, 2017
 * @since 1.8
 *
 */
public class Graph {
    
    private List<Node> nodes;
    
    private List<Edge> edges;

    public Graph(List<Node> nodes, List<Edge> edges) {
            this.nodes = new ArrayList<>(nodes);
            this.edges = new ArrayList<>(edges);
    }

    public List<Node> getNodes() {
        return Collections.unmodifiableList(nodes);
    }

    public List<Edge> getEdges() {
        return Collections.unmodifiableList(edges);
    }
}
