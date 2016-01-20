package teclado_prop;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author David
 */
public class DriverMatrices {
    public static void main(String[] args) throws FileNotFoundException, IOException, Exception {
        
        Teclado t = new Teclado(2, 2 , "qwe");
        String teclas = "h o l a";
        t.anadir_teclas(teclas);
        t.imprimir_teclado();
        /*File f = new File(".\\src\\teclado_prop\\STUB2.txt");
        FileReader fr = new FileReader(".\\src\\teclado_prop\\STUB3.txt");
        t.leer_teclado(fr); */             
        Matrices m = new Matrices();
        
        System.out.println("Texto leido de STUB2");
        System.out.println("Teclado auxiliar leido de STUB3");
        System.out.println("1 = Crear matrices de distancias y probabilidades");
        System.out.println("2 = Listar matriz de probabilidades");
        System.out.println("3 = [letra1 letra2] = probabilidad entre las letras letra 1 y letra2");
        System.out.println("4 = Listar matriz de distancias");
        System.out.println("5 =  [letra1 letra2] = distancia entre las letras letra 1 y letra2");
        System.out.println("0 = Finalizar)");
        
        Scanner in = new Scanner(System.in);
        String x = in.next();  
        
        while (!x.equals("0")){
             if (x.equals("1")){
                 String[] texto = new String[4];
                 for (int i = 0; i < texto.length; ++i) {
                     texto[i] = "hola oh estah";
                 }
                // m.crear_matrices(t, texto);
                 System.out.println("Matrices creadas correctamente");
             }
             else if(x.equals("2")){
                 m.imprimir_probabilidades();
             }
             else if(x.equals("3")){
                 x = in.next();
                 char c1 = x.charAt(0);
                 x = in.next();
                 char c2 = x.charAt(0);
                 m.imprimir_probabilidad_letras(t,c1,c2);
             }
             else if(x.equals("4")){
                 m.imprimir_distancias();
             }
             else if(x.equals("5")){
                 x = in.next();
                 char c1 = x.charAt(0);
                 x = in.next();
                 char c2 = x.charAt(0);
                 m.imprimir_destancia_letras(t, c1, c2);
             }
             x = in.next();
        }
    }
}
