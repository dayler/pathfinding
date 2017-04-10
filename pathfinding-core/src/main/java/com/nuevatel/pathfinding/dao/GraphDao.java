/**
 * 
 */
package com.nuevatel.pathfinding.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.nuevatel.pathfinding.dijkstra.domain.Edge;
import com.nuevatel.pathfinding.dijkstra.domain.Graph;
import com.nuevatel.pathfinding.dijkstra.domain.Node;
import com.nuevatel.pathfinding.exception.GraphDaoException;

/**
 * <p>The GraphDao class.</p>
 * <p>NuevaTel PCS de Bolivia S.A. (c) 2017</p>
 * <p>El contenido de este archivo esta clasificado como: </p>
 * <p>INFORMACION DE CONFIDENCIALIDAD ALTA </p>
 * 
 * @author asalazar
 * @version 1.0 Apr 9, 2017
 * @since 1.8
 *
 */
public class GraphDao {
    
    public Graph getGraph(Connection conn) throws GraphDaoException {
        try {
            Map<Integer, Node>nodeMap = getNodeMap(conn);
            List<Edge>edgeList = getEdgeList(conn, nodeMap);
            return new Graph(new ArrayList<>(nodeMap.values()), edgeList);
        } catch (SQLException ex) {
            throw new GraphDaoException(ex);
        }
    }
    
    private List<Edge>getEdgeList(Connection conn,  Map<Integer, Node>nodeMap) throws SQLException {
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select e.NODE_ID_A, e.NODE_ID_B, e.DISTANCE from EDGE as e")) {
            List<Edge>edgeList = new ArrayList<>();
            while (rs.next()) {
                Integer nodeIdA = rs.getInt("NODE_ID_A");
                Integer nodeIdB = rs.getInt("NODE_ID_B");
                Integer distance = rs.getInt("DISTANCE");
                // 
                Node nodeA = nodeMap.get(nodeIdA);
                Node nodeB = nodeMap.get(nodeIdB);
                if (nodeA == null || nodeB == null) {
                    continue;
                }
                // add to edge list.
                edgeList.add(new Edge(nodeA.toString() + "/" + nodeIdB.toString(), nodeA, nodeB, distance));
            }
            return edgeList;
        }
    }
    
    private Map<Integer, Node> getNodeMap(Connection conn) throws SQLException {
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("select n.ID, n.NAME from NODE as n")) {
            Map<Integer, Node>nodeList = new HashMap<>();
            while (rs.next()) {
                Integer id = rs.getInt("ID");
                String name = rs.getString("NAME");
                nodeList.put(id, new Node(id.toString(), name));
            }
            // return list
            return nodeList;
        }
    }
}
