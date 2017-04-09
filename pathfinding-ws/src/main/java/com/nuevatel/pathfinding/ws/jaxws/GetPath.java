
package com.nuevatel.pathfinding.ws.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getPath", namespace = "http://ws.pathfinding.nuevatel.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getPath", namespace = "http://ws.pathfinding.nuevatel.com/")
public class GetPath {

    @XmlElement(name = "fromPoint", namespace = "")
    private String fromPoint;

    /**
     * 
     * @return
     *     returns String
     */
    public String getFromPoint() {
        return this.fromPoint;
    }

    /**
     * 
     * @param fromPoint
     *     the value for the fromPoint property
     */
    public void setFromPoint(String fromPoint) {
        this.fromPoint = fromPoint;
    }

}
