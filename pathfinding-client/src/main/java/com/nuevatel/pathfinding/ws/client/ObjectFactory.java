
package com.nuevatel.pathfinding.ws.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.nuevatel.pathfinding.ws.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetPathResponse_QNAME = new QName("http://ws.pathfinding.nuevatel.com/", "getPathResponse");
    private final static QName _PathResponse_QNAME = new QName("http://ws.pathfinding.nuevatel.com/", "pathResponse");
    private final static QName _GetPath_QNAME = new QName("http://ws.pathfinding.nuevatel.com/", "getPath");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.nuevatel.pathfinding.ws.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PathResponse }
     * 
     */
    public PathResponse createPathResponse() {
        return new PathResponse();
    }

    /**
     * Create an instance of {@link GetPathResponse }
     * 
     */
    public GetPathResponse createGetPathResponse() {
        return new GetPathResponse();
    }

    /**
     * Create an instance of {@link GetPath }
     * 
     */
    public GetPath createGetPath() {
        return new GetPath();
    }

    /**
     * Create an instance of {@link PathResponse.RouteList }
     * 
     */
    public PathResponse.RouteList createPathResponseRouteList() {
        return new PathResponse.RouteList();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPathResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.pathfinding.nuevatel.com/", name = "getPathResponse")
    public JAXBElement<GetPathResponse> createGetPathResponse(GetPathResponse value) {
        return new JAXBElement<GetPathResponse>(_GetPathResponse_QNAME, GetPathResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PathResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.pathfinding.nuevatel.com/", name = "pathResponse")
    public JAXBElement<PathResponse> createPathResponse(PathResponse value) {
        return new JAXBElement<PathResponse>(_PathResponse_QNAME, PathResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPath }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.pathfinding.nuevatel.com/", name = "getPath")
    public JAXBElement<GetPath> createGetPath(GetPath value) {
        return new JAXBElement<GetPath>(_GetPath_QNAME, GetPath.class, null, value);
    }

}
