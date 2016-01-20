/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package teclado_prop;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 *
 * @author Víctor
 */
public class DriverTeclado {
    public static void main(String[] args) throws FileNotFoundException, IOException, Exception{
         System.out.println("OPCIONES DE TESTEO:");
         System.out.println("1 = Creadora teclado [n m nombre]"); 
         System.out.println("2 = Leer teclado de fichero");
         System.out.println("3 = Añadir tecla [i j simbolo]"); 
         System.out.println("4 = Swap de teclas [tecla1 tecla2]");
         System.out.println("5 = Eliminar tecla [tecla]");
         System.out.println("6 = Obtener N");
         System.out.println("7 = Obtener M");
         System.out.println("8 = Obtener nombre del teclado");
         System.out.println("9 = Obtener símbolo [x y]]");
         System.out.println("10 = Obtener posición del símbolo [simbolo]");
         System.out.println("11 = Imprimir teclado");
         System.out.println("12 = consultar_teclado");
         System.out.println("0 = Finalizar");
         Scanner in = new Scanner(System.in);
         String x = in.next();        
         Tecla t = new Tecla();
         Teclado tec = new Teclado();
         while (!x.equals("0")){
             if (x.equals("1")){
                  int n, m;
                    String nombre;
                    System.out.println("Tamaño");
                    nombre = in.next();
                    n = Integer.parseInt(nombre);
                    nombre = in.next();
                    m = Integer.parseInt(nombre);
                    System.out.println("Nombre");
                    nombre = in.next();
                    tec = new Teclado(n,m,nombre);
                    System.out.println("letras");
                    String AUX = "q w e r";
                    tec.anadir_teclas(AUX);
             }
             else if (x.equals("2")){     
                 FileReader fr = new FileReader(".\\src\\teclado_prop\\STUB3.txt");
                 tec.leer_teclado(fr);      
             }
             else if (x.equals("3")){
                 Tecla t1 = new Tecla();
                 String st = in.next();
                 char ch;
                 ch = st.charAt(0);
                 Simbolo s1;
                 s1 = new Simbolo(ch);
                 t1.anadir_simbolo_tecla(s1);
                 int i = in.nextInt();
                 int j = in.nextInt();
                 tec.anadir_tecla(i, j, t1);
                 
             }
             else if (x.equals("4")){
                 String st = in.next();
                 char ch = st.charAt(0);
                 System.out.println("Tecla 1: "+ ch);
                 Tecla t1 = new Tecla(new Simbolo(ch));
                 System.out.println("Tecla 1 asignada");
                 st = in.next();
                 ch = st.charAt(0);
                 Tecla t2 = new Tecla(new Simbolo(ch));
                 System.out.println("Tecla 2: "+ ch);
                 tec.swap_teclas(t1, t2);
                 System.out.println("Swap hecho");
                 
                 
             }             
             else if (x.equals("5")){
                 String st = in.next();
                 char ch = st.charAt(0);
                 Tecla t1 = new Tecla(new Simbolo (ch));
                 tec.eliminar_tecla(t1);
             }             
             else if (x.equals("6")){
                 int M = tec.getM();
                 System.out.println(M);
             }         
             else if (x.equals("7")){
                 int N = tec.getN();
                 System.out.println(N);
             }
             else if (x.equals("8")){
                 String name = tec.getNombre();
                 System.out.println(name);
                 
             }
             else if (x.equals("9")){
                 int i = in.nextInt();
                 int j = in.nextInt();
                 char c = tec.getSimbolo(i, j);
                 System.out.println(c);
             }
             else if (x.equals("10")){
                 String st = in.next();
                 char ch;
                 ch = st.charAt(0);
                 Simbolo s1;
                 s1 = new Simbolo(ch);
                 Tecla te = new Tecla(s1);
                 int[] coor = tec.getCoordenadas(te);
                 System.out.println("x " + coor[0] + " y " + coor[1]);
             }
             else if (x.equals("11")){
                 tec.imprimir_teclado();
             }
             else if (x.equals("12")){
                 int cont = 0;
                 int max = tec.getM();
                 String e = tec.consultar_teclado();
                 System.out.println(e);
             }
              else if (x.equals("13")){
                  System.out.println(tec.fila_string(1));
              }        
             x = in.next();
         }
    }
}
