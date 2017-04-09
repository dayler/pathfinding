/**
 * 
 */
package com.nuevatel.pathfinding.dijkstra;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.nuevatel.pathfinding.dijkstra.domain.Edge;
import com.nuevatel.pathfinding.dijkstra.domain.Graph;
import com.nuevatel.pathfinding.dijkstra.domain.Vertex;

/**
 * <p>The TestDijkstraAlgorithm class.</p>
 * <p>NuevaTel PCS de Bolivia S.A. (c) 2017</p>
 * <p>El contenido de este archivo esta clasificado como: </p>
 * <p>INFORMACION DE CONFIDENCIALIDAD ALTA </p>
 * 
 * @author asalazar
 * @version 1.0 Apr 9, 2017
 * @since 1.8
 *
 */
public class TestDijkstraAlgorithm {
    
    private List<Vertex> nodes;
    
    private List<Edge> edges;
    
    /**
     * @throws java.lang.Exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        // No op.
    }

    /**
     * @throws java.lang.Exception
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        // No op.
    }

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        // No op.
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
        // No op.
    }

    @Test
    public void testExcute() {
        nodes = new ArrayList<Vertex>();
        edges = new ArrayList<Edge>();
        for (int i = 0; i < 11; i++) {
            Vertex location = new Vertex("Node_" + i, "Node_" + i);
            nodes.add(location);
        }
        addEdge("Edge_0", 0, 1, 85);
        addEdge("Edge_1", 0, 2, 217);
        addEdge("Edge_2", 0, 4, 173);
        addEdge("Edge_3", 2, 6, 186);
        addEdge("Edge_4", 2, 7, 103);
        addEdge("Edge_5", 3, 7, 183);
        addEdge("Edge_6", 5, 8, 250);
        addEdge("Edge_7", 8, 9, 84);
        addEdge("Edge_8", 7, 9, 167);
        addEdge("Edge_9", 4, 9, 502);
        addEdge("Edge_10", 9, 10, 40);
        addEdge("Edge_11", 1, 10, 600);
        // Lets check from location Loc_1 to Loc_10
        Graph graph = new Graph(nodes, edges);
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
        // TODO 
        dijkstra.execute(nodes.get(0));
        List<Vertex> path = dijkstra.getPath(nodes.get(10));
        
        assertNotNull(path);
        assertTrue(path.size() > 0);
        for (Vertex vertex : path) {
            System.out.println(vertex);
        }
    }
    
    private void addEdge(String laneId, int sourceLocNo, int destLocNo, int duration) {
        Edge lane = new Edge(laneId, nodes.get(sourceLocNo), nodes.get(destLocNo), duration);
        edges.add(lane);
    }
}
