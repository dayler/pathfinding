/**
 * 
 */
package com.nuevatel.pathfinding.utils;

/**
 * <p>The IntegerUtils class.</p>
 * <p>NuevaTel PCS de Bolivia S.A. (c) 2017</p>
 * <p>El contenido de este archivo esta clasificado como: </p>
 * <p>INFORMACION DE CONFIDENCIALIDAD ALTA </p>
 * 
 * @author asalazar
 * @version 1.0 Apr 8, 2017
 * @since 1.8
 *
 */
public final class IntegerUtils {
    
    private IntegerUtils() {
        // No op.
    }
    
    /**
     * @param str
     * @param dflt
     * @return <code>Integer</code> representation of <code>str</code>.
     */
    public static Integer tryParse(String str, Integer dflt) {
        if (str == null || str.isEmpty()) {
            return dflt;
        }
        // try to parse.
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException ex) {
            return dflt;
        }
    }
}
