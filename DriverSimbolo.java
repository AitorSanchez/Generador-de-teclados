/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package teclado_prop;

import java.util.*;
/**
 *
 * @author Aitor
 */
public class DriverSimbolo {
    public static void main(String[] args) throws Exception {
         System.out.println("OPCIONES DE TESTEO:");
         System.out.println("1 = Simbolo(char c)");
         System.out.println("2 = getChar()");
         System.out.println("3 = setChar(char c)");
         System.out.println("4 = Finalizar");
         Scanner in = new Scanner(System.in);
         String x = in.next();
         Simbolo s = new Simbolo();
         while (!x.equals("4")) {
             if (x.equals("1")) {
                 System.out.println("Introducir caracter"); 
                 x = in.next();
                 char c = x.charAt(0);
                 s = new Simbolo(c);
                 char aux = s.getChar();
             }
             if (x.equals("2")) {
                 char aux = s.getChar();
                 System.out.println("El simbolo con tiene el caracter: "+ aux);
             }
             if (x.equals("3")) {
                 System.out.println("Introducir caracter"); 
                 x = in.next();
                 char c = x.charAt(0);
                 s.setChar(c);   
             }
             System.out.println();
             System.out.println("OPCIONES DE TESTEO:");
             System.out.println("1 = Simbolo(char c)");
             System.out.println("2 = getChar()");
             System.out.println("3 = setChar(char c)");
             System.out.println("4 = Finalizar");
             x = in.next();
          }    
    }
}
