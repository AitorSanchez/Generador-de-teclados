/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package teclado_prop;

/**
 *
 * @author
 */
public class Distancia {
    
    // Calcular distancia euclidea
    public static float euclidean(int[]x, int[] y){ 
        return (float) Math.sqrt(Math.pow(x[0] - y[0], 2) + Math.pow(x[1] - y[1], 2));
        } 
    
    // Calcular distancia 
     public static double manhatta (int[] x, int[] y){ 
        return  Math.abs(x[1]-x[0]) + Math.abs(y[1]-y[0]);
    }
     
}
