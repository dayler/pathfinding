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
    
    private List<Vertex> vertexes;
    
    private List<Edge> edges;

    public Graph(List<Vertex> vertexes, List<Edge> edges) {
            this.vertexes = new ArrayList<>(vertexes);
            this.edges = new ArrayList<>(edges);
    }

    public List<Vertex> getVertexes() {
            return Collections.unmodifiableList(vertexes);
    }

    public List<Edge> getEdges() {
            return Collections.unmodifiableList(edges);
    }
}
