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
public class DriverTecla {
     public static void main(String[] args) throws Exception {
         System.out.println("OPCIONES DE TESTEO:");
         System.out.println("1 = Tecla(Simbolo sim)");
         System.out.println("2 = anadir_simbolo_tecla(Simbolo sim)");
         System.out.println("3 = es_letra()");
         System.out.println("4 = getSimbolo()");
         System.out.println("5 = Finalizar");
         Scanner in = new Scanner(System.in);
         String x = in.next();
         Tecla t = new Tecla();
         while (!x.equals("5")) {
             if (x.equals("1")) {
                System.out.println("Introducir simbolo");
                x = in.next();
                char c = x.charAt(0);
                Simbolo s = new Simbolo(c);
                t = new Tecla(s); 
             }
             else if (x.equals("2")) {
                System.out.println("Introducir simbolo");
                x = in.next();
                char c = x.charAt(0);
                Simbolo s = new Simbolo(c);
                t.anadir_simbolo_tecla(s);
             }
             else if (x.equals("3")) {
                 if (t.es_letra())System.out.println("La tecla es una letra");
                 else System.out.println("La tecla no es una letra");
             }
             else if (x.equals("4")) {
                 char aux = t.getSimbolo();
                 System.out.println("La tecla contiene el simbolo: " + aux);
             }
             System.out.println();
             System.out.println("OPCIONES DE TESTEO:");
             System.out.println("1 = Tecla(Simbolo sim)");
             System.out.println("2 = anadir_simbolo_tecla(Simbolo sim)");//para poder usar esta opcion hay que crear una tecla primero
             System.out.println("3 = es_letra()");//para poder usar esta opcion hay que crear una tecla primero
             System.out.println("4 = getSimbolo()");//para poder usar esta opcion hay que crear una tecla primero
             System.out.println("5 = Finalizar");
             x = in.next();
         }
     }
}
