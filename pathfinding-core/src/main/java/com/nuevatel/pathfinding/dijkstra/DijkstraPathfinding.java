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

    private List<Node> nodes;
    
    private List<Edge> edges;
    
    private Set<Node> settledNodes;
    
    private Set<Node> unSettledNodes;
    
    private Map<Node, Node> predecessors;
    
    private Map<Node, Integer> distance;

    public DijkstraPathfinding(Graph graph) {
        ParameterUtils.requiredNotNull(graph, "null graph.");
        // create a copy of the array so that we can operate on this array
        this.nodes = new ArrayList<Node>(graph.getNodes());
        this.edges = new ArrayList<Edge>(graph.getEdges());
    }
    
    public Node getNodeFromName(String nodeName) {
        return nodes.stream().filter(n -> n.getName().equalsIgnoreCase(nodeName)).findAny().orElse(null);
    }
    
    public void execute(Node source) {
        settledNodes = new HashSet<Node>(); // Utilizados.
        unSettledNodes = new HashSet<Node>(); // No utilizados.
        
        distance = new HashMap<Node, Integer>();
        predecessors = new HashMap<Node, Node>();
        distance.put(source, 0);
        unSettledNodes.add(source);
        
        while (!unSettledNodes.isEmpty()) {
            // while unSettledNodes is not empty.
            Node node = getMinimum(unSettledNodes);
            settledNodes.add(node);
            unSettledNodes.remove(node);
            findMinimalDistances(node);
        }
    }

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
        throw new RuntimeException("Should not happen");
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

    /*
     * This method returns the path from the source to the selected target and
     * NULL if no path exists
     */
    public List<Node> getPath(Node target) {
        List<Node> path = new LinkedList<Node>();
        Node step = target;
        // check if a path exists
        if (predecessors.get(step) == null) {
            return null;
        }
        path.add(step);
        while (predecessors.get(step) != null) {
            step = predecessors.get(step);
            path.add(step);
        }
        // Put it into the correct order
        return path;
    }
}
