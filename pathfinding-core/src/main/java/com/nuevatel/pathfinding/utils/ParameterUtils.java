/**
 * 
 */
package com.nuevatel.pathfinding.utils;

/**
 * <p>The ParameterUtils class.</p>
 * <p>NuevaTel PCS de Bolivia S.A. (c) 2017</p>
 * <p>El contenido de este archivo esta clasificado como: </p>
 * <p>INFORMACION DE CONFIDENCIALIDAD ALTA </p>
 * 
 * Utils for general purpose.
 * 
 * @author asalazar
 * @version 1.0 Apr 8, 2017
 * @since 1.8
 *
 */
public final class ParameterUtils {
    
    private ParameterUtils() {
        // No op.
    }
    
    /**
     * 
     * @param param
     * @param msg
     * @throws IllegalArgumentException if <code>param</code> is null.
     */
    public static <T>void requiredNotNull(T param, String msg) {
        if (param == null) {
            throw new IllegalArgumentException(msg);
        }
    }
    
    /**
     * 
     * @param param
     * @param msg
     * @throws IllegalArgumentException if <code>param</code> is null or empty string.
     */
    public static void requiredNotEmpty(String param, String msg) {
        if (param == null || param.isEmpty() || param.trim().isEmpty()) {
            throw new IllegalArgumentException(msg);
        }
    }
}
