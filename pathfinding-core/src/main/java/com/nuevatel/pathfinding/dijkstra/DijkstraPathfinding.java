/**
 * 
 */
package com.nuevatel.pathfinding.dijkstra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.nuevatel.pathfinding.dijkstra.domain.Edge;
import com.nuevatel.pathfinding.dijkstra.domain.Graph;
import com.nuevatel.pathfinding.dijkstra.domain.Node;
import com.nuevatel.pathfinding.utils.ParameterUtils;

/**
 * <p>The DijkstraAlgorithm class.</p>
 * <p>NuevaTel PCS de Bolivia S.A. (c) 2017</p>
 * <p>El contenido de este archivo esta clasificado como: </p>
 * <p>INFORMACION DE CONFIDENCIALIDAD ALTA </p>
 * 
 * @author asalazar
 * @version 1.0 Apr 9, 2017
 * @since 1.8
 *
 */
public class DijkstraPathfinding {

	/**
	 * Graph nodes.
	 */
    private List<Node> nodes;
    
    /**
     * Edges (nodeA, nodeB)
     */
    private List<Edge> edges;
    
    /**
     * Used nodes.
     */
    private Set<Node> settledNodes;
    
    /**
     * Unused nodes.
     */
    private Set<Node> unSettledNodes;
    
    /**
     * predecessors.
     */
    private Map<Node, Node> predecessors;
    
    /**
     * Accumulated distance.
     */
    private Map<Node, Integer> distance;

    private Object lck = new Object();

    public DijkstraPathfinding(Graph graph) {
        ParameterUtils.requiredNotNull(graph, "null graph.");
        // create a copy of the array so that we can operate on this array
        this.nodes = new ArrayList<Node>(graph.getNodes());
        this.edges = new ArrayList<Edge>(graph.getEdges());
    }
    
    /**
     * From node name get the node.
     * @param nodeName
     * @return
     */
    public Node getNodeFromName(String nodeName) {
        return nodes.stream().filter(n -> n.getName().equalsIgnoreCase(nodeName)).findAny().orElse(null);
    }
    
    /**
     * Builds Dijkstra matrix.
     * @param source
     */
    public void execute(Node source) {
        settledNodes = new HashSet<Node>(); // Utilizados.
        unSettledNodes = new HashSet<Node>(); // No utilizados.
        distance = new HashMap<Node, Integer>();
        predecessors = new HashMap<Node, Node>();
        distance.put(source, 0); // Initial node.
        unSettledNodes.add(source);
        while (!unSettledNodes.isEmpty()) {
            // while unSettledNodes is not empty.
            Node node = getMinimum(unSettledNodes);
            settledNodes.add(node);
            unSettledNodes.remove(node);
            findMinimalDistances(node);
        }
    }

    /**
     * 
     * @param node
     */
    private void findMinimalDistances(Node node) {
        List<Node> adjacentNodes = getNeighbors(node);
        for (Node target : adjacentNodes) {
            if (getShortestDistance(target) > getShortestDistance(node) + getDistance(node, target)) {
                distance.put(target, getShortestDistance(node) + getDistance(node, target));
                predecessors.put(target, node);
                unSettledNodes.add(target);
            }
        }
    }

    private int getDistance(Node node, Node target) {
        for (Edge edge : edges) {
            if (edge.getSource().equals(node) && edge.getDestination().equals(target)) {
                return edge.getWeight();
            }
        }
        throw new RuntimeException("Failed not found distance between: " + node.toString() + "-" + target.toString());
    }

    private List<Node> getNeighbors(Node node) {
        List<Node> neighbors = new ArrayList<Node>();
        for (Edge edge : edges) {
            if (edge.getSource().equals(node) && !isSettled(edge.getDestination())) {
                neighbors.add(edge.getDestination());
            }
        }
        return neighbors;
    }

    private Node getMinimum(Set<Node> vertexes) {
        Node minimum = null;
        for (Node vertex : vertexes) {
            if (minimum == null) {
                minimum = vertex;
                continue;
            }
            if (getShortestDistance(vertex) < getShortestDistance(minimum)) {
                minimum = vertex;
            }
        }
        return minimum;
    }

    private boolean isSettled(Node vertex) {
        return settledNodes.contains(vertex);
    }

    public int getShortestDistance(Node destination) {
        Integer d = distance.get(destination);
        return d == null ? Integer.MAX_VALUE : d;
    }
    
    /**
     * 
     * @param target
     * @return the path from the source to the selected target and NULL if no path exists.
     */
    public List<Node> getPath(Node target) {
        Node step = target;
        if (predecessors.get(step) == null) {
            // node does not exisit.
            return null;
        }
        synchronized (lck) {
            List<Node> path = new LinkedList<Node>();
            path.add(step);
            while (predecessors.get(step) != null) {
                step = predecessors.get(step);
                path.add(step);
            }
            // Put it into the correct order
            return path;
        }
    }
}
