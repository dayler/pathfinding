/**
 * 
 */
package com.nuevatel.pathfinding.exception;

/**
 * <p>The NullSourceException class.</p>
 * <p>NuevaTel PCS de Bolivia S.A. (c) 2017</p>
 * <p>El contenido de este archivo esta clasificado como: </p>
 * <p>INFORMACION DE CONFIDENCIALIDAD ALTA </p>
 * 
 * @author asalazar
 * @version 1.0 Apr 9, 2017
 * @since 1.8
 *
 */
public class NullSourceException extends RuntimeException {

    private static final long serialVersionUID = 20170409L;
    
    public NullSourceException(String source) {
        super("Null Dijkstra node source. Node Name:" + source);
    }
    
}
