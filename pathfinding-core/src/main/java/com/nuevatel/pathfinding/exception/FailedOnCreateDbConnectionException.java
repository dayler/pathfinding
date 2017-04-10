/**
 * 
 */
package com.nuevatel.pathfinding.exception;

/**
 * <p>The FailedOnCreateDbConnectionException class.</p>
 * <p>NuevaTel PCS de Bolivia S.A. (c) 2017</p>
 * <p>El contenido de este archivo esta clasificado como: </p>
 * <p>INFORMACION DE CONFIDENCIALIDAD ALTA </p>
 * 
 * @author asalazar
 * @version 1.0 Apr 9, 2017
 * @since 1.8
 *
 */
public class FailedOnCreateDbConnectionException extends Exception {

    private static final long serialVersionUID = 20170409L;
    
    public FailedOnCreateDbConnectionException(String path, Throwable trwbl) {
        super("Failed to create connection: " + path, trwbl);
    }
}
