/**
 * 
 */
package com.nuevatel.pathfinding.dijkstra.domain;

import com.nuevatel.pathfinding.utils.ParameterUtils;

/**
 * <p>The Vertex class.</p>
 * <p>NuevaTel PCS de Bolivia S.A. (c) 2017</p>
 * <p>El contenido de este archivo esta clasificado como: </p>
 * <p>INFORMACION DE CONFIDENCIALIDAD ALTA </p>
 * 
 * @author asalazar
 * @version 1.0 Apr 9, 2017
 * @since 1.8
 *
 */
public class Vertex {
    
    private String id;
    
    private String name; // TODO remove if not necesary.

    /**
     * 
     * @param id To identify the node. It cannot be null.
     * @param name
     */
    public Vertex(String id, String name) {
        ParameterUtils.requiredNotNull(id, "null node id.");
        // 
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        // Compare vertex.
        return id.equals(((Vertex)obj).id);
    }

    @Override
    public String toString() {
        return name;
    }
}
