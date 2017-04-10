/**
 * 
 */
package com.nuevatel.pathfinding.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.nuevatel.pathfinding.ws.domain.PathResponse;

/**
 * <p>The PathfindingWS class.</p>
 * <p>NuevaTel PCS de Bolivia S.A. (c) 2017</p>
 * <p>El contenido de este archivo esta clasificado como: </p>
 * <p>INFORMACION DE CONFIDENCIALIDAD ALTA </p>
 * 
 * @author asalazar
 * @version 1.0 Apr 8, 2017
 * @since 1.8
 *
 */
@WebService(name="PathfindingWSPort", wsdlLocation="/pathfinding.wsdl")
public interface PathfindingWs {
    
    @WebMethod(operationName="getPath")
    PathResponse getPath(@WebParam(name="fromPoint") String fromPoint);
}
