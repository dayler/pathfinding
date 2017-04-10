/**
 * 
 */
package com.nuevatel.pathfinding.ws.domain;

import static javax.xml.bind.annotation.XmlAccessType.FIELD;

import java.util.Collections;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.nuevatel.pathfinding.utils.ParameterUtils;

/**
 * <p>The PathResponse class.</p>
 * <p>NuevaTel PCS de Bolivia S.A. (c) 2017</p>
 * <p>El contenido de este archivo esta clasificado como: </p>
 * <p>INFORMACION DE CONFIDENCIALIDAD ALTA </p>
 * 
 * Define the response for the best way.
 * 
 * @author asalazar
 * @version 1.0 Apr 8, 2017
 * @since 1.8
 *
 */
@XmlRootElement(name = "pathResponse")
@XmlAccessorType(value = FIELD)
public class PathResponse {
    
    /**
     * Initial point.
     */
    @XmlElement(name="fromPoint")
    private String fromPoint;
    
    /**
     * Fasted way.
     */
    @XmlElementWrapper(name="routeList")
    @XmlElement(name = "route")
    private List<String>route;
    
    @XmlElement(name = "totalDistance")
    private int distance;
    
    public PathResponse() {
        // No op.
    }
    
    public PathResponse(String fromPoint, int distance, List<String>route) {
        ParameterUtils.requiredNotEmpty(fromPoint, "null or empty fromPoint.");
        ParameterUtils.requiredNotNull(route, "null route.");
        // 
        this.fromPoint = fromPoint;
        this.distance = distance;
        this.route = route;
    }
    
    public List<String> getRoute() {
        return Collections.unmodifiableList(route);
    }
    
    public String getFromPoint() {
        return fromPoint;
    }
    
    public int getDistance() {
        return distance;
    }
}
