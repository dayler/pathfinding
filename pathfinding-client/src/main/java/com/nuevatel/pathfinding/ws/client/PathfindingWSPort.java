
package com.nuevatel.pathfinding.ws.client;

import java.util.concurrent.Future;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.Response;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebService(name = "PathfindingWSPort", targetNamespace = "http://ws.pathfinding.nuevatel.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface PathfindingWSPort {


    /**
     * 
     * @param fromPoint
     * @return
     *     returns javax.xml.ws.Response<com.nuevatel.pathfinding.ws.client.GetPathResponse>
     */
    @WebMethod(operationName = "getPath")
    @RequestWrapper(localName = "getPath", targetNamespace = "http://ws.pathfinding.nuevatel.com/", className = "com.nuevatel.pathfinding.ws.client.GetPath")
    @ResponseWrapper(localName = "getPathResponse", targetNamespace = "http://ws.pathfinding.nuevatel.com/", className = "com.nuevatel.pathfinding.ws.client.GetPathResponse")
    public Response<GetPathResponse> getPathAsync(
        @WebParam(name = "fromPoint", targetNamespace = "")
        String fromPoint);

    /**
     * 
     * @param asyncHandler
     * @param fromPoint
     * @return
     *     returns java.util.concurrent.Future<? extends java.lang.Object>
     */
    @WebMethod(operationName = "getPath")
    @RequestWrapper(localName = "getPath", targetNamespace = "http://ws.pathfinding.nuevatel.com/", className = "com.nuevatel.pathfinding.ws.client.GetPath")
    @ResponseWrapper(localName = "getPathResponse", targetNamespace = "http://ws.pathfinding.nuevatel.com/", className = "com.nuevatel.pathfinding.ws.client.GetPathResponse")
    public Future<?> getPathAsync(
        @WebParam(name = "fromPoint", targetNamespace = "")
        String fromPoint,
        @WebParam(name = "asyncHandler", targetNamespace = "")
        AsyncHandler<GetPathResponse> asyncHandler);

    /**
     * 
     * @param fromPoint
     * @return
     *     returns com.nuevatel.pathfinding.ws.client.PathResponse
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getPath", targetNamespace = "http://ws.pathfinding.nuevatel.com/", className = "com.nuevatel.pathfinding.ws.client.GetPath")
    @ResponseWrapper(localName = "getPathResponse", targetNamespace = "http://ws.pathfinding.nuevatel.com/", className = "com.nuevatel.pathfinding.ws.client.GetPathResponse")
    @Action(input = "http://ws.pathfinding.nuevatel.com/PathfindingWSPort/getPathRequest", output = "http://ws.pathfinding.nuevatel.com/PathfindingWSPort/getPathResponse")
    public PathResponse getPath(
        @WebParam(name = "fromPoint", targetNamespace = "")
        String fromPoint);

}
