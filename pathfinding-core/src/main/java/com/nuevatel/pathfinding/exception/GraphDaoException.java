/**
 * 
 */
package com.nuevatel.pathfinding.exception;

/**
 * <p>The GraphDaoException class.</p>
 * <p>NuevaTel PCS de Bolivia S.A. (c) 2017</p>
 * <p>El contenido de este archivo esta clasificado como: </p>
 * <p>INFORMACION DE CONFIDENCIALIDAD ALTA </p>
 * 
 * @author asalazar
 * @version 1.0 Apr 9, 2017
 * @since 1.8
 *
 */
public class GraphDaoException extends Exception {

    private static final long serialVersionUID = 20170409L;
    
    public GraphDaoException(Throwable trwbl) {
        super("Failed to create Graph from DAO.", trwbl);
    }

}
