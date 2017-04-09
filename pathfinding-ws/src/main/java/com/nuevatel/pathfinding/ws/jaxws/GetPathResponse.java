
package com.nuevatel.pathfinding.ws.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.nuevatel.pathfinding.ws.domain.PathResponse;

@XmlRootElement(name = "getPathResponse", namespace = "http://ws.pathfinding.nuevatel.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getPathResponse", namespace = "http://ws.pathfinding.nuevatel.com/")
public class GetPathResponse {

    @XmlElement(name = "return", namespace = "")
    private PathResponse _return;

    /**
     * 
     * @return
     *     returns PathResponse
     */
    public PathResponse getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(PathResponse _return) {
        this._return = _return;
    }

}
