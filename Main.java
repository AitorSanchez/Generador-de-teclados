/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package teclado_prop;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author 
 */
public class Main {
    public static void main(String[] args) throws IOException, Exception {
        /*Solucion s = new Solucion();
        Algoritmo a = new Algoritmo();
        Teclados tec = new Teclados();
        Teclados S = new Teclados();
        Matrices m = new Matrices();
        Teclado t = new Teclado();
        Teclado p = new Teclado();
        //FileReader fr = new FileReader(".\\src\\teclado_prop\\STUB.txt");
        CtrlDatos cd = new CtrlDatos();
        String ss = ".\\src\\teclado_prop\\STUB.txt";
        String[] aux = cd.leer_archivo(ss);
        tec.Crear(aux);
        System.out.println("Lista de teclados predeterminados creados de STUB");
        System.out.println();
        System.out.println("OPCIONES:");
        System.out.println("1 = Consultar teclados predeterminados");
        System.out.println("2 = Consultar teclados creados");
        System.out.println("3 = Consultar teclado predeterminado [nombre teclado]");
        System.out.println("4 = Consultar teclado creado [nombre teclado], en caso de existir imprime los 2 teclados");
        System.out.println("5 = Crear nuevo teclado");
        System.out.println("6 = Añadir teclado nuevo a lista de teclados predeterminados");
        System.out.println("0 = Finalizar");
        
        Scanner in = new Scanner(System.in);
        String x = in.next();
        
        while(!x.equals("0")) {
            if(x.equals("1")) {
                tec.Imprimir_Teclados();
                tec.Consultar_num_teclados();
            }
            else if(x.equals("2")) {
                S.Imprimir_Teclados();
                S.Consultar_num_teclados();
            }
            else if (x.equals("3")) {
                System.out.println("Nombre del teclado");
                x = in.next();
                t = tec.getTeclado(x);
                if (tec.Existe(t)) {
                    tec.Escribir_teclado(t);
                }
                else System.out.println("No se puede encontrar la solucion");
            }
            else if (x.equals("4")) {
                System.out.println("Nombre del teclado");
                x = in.next();
                p = S.getTeclado(x);
                if (S.Existe(p)) {
                    t = tec.getTeclado(x);
                    System.out.println("Teclado Original");
                    tec.Escribir_teclado(t);
                    System.out.println("Teclado Solucion");
                    S.Escribir_teclado(p);
                }
                else System.out.println("No hay solucion para este teclado");
            }
            else if (x.equals("5")) {
                System.out.println("Nombre del teclado a partir del que se creará");
                x = in.next();
                String nom = x;
                t = tec.getTeclado(x);
                if (tec.Existe(t)) {
                    System.out.println("Nombre del archivo del que leer el texto");
                    x = in.next();
                    String s1 = ".\\src\\teclado_prop\\";
                    s1 = s1.concat(x);
                    File f = new File(s1);
                    int intentos = 5;
                    while(!f.exists() && intentos != 0) { // while?
                        intentos = intentos -1;
                        if (intentos==0) System.out.println("Solucion no encontrada (el texto no se ha encontrado)");
                        else{
                            System.out.println("Intentos restantes: " + intentos);
                            System.out.println("El archivo no existe, introducir archivo valido");
                            x = in.next();
                            s1 = ".\\";
                            s1 = s1.concat(x);
                            f = new File(s1);
                        }    
                    }
                    if (intentos > 0){

                        if(S.Existe(t)) {
                            p = t.copiaTeclado();
                            m.crear_matrices(t, f);
                            s.Sol(a, p, m);
                            p = s.SolTec();
                            System.out.println("Elegir solución nueva(1) o solución antigua(2)");
                            System.out.println("Solución nueva");
                            p.imprimir_teclado();
                            System.out.println("Solución antigua");
                            t = S.getTeclado(nom);
                            t.imprimir_teclado();
                            x = in.next();
                            if(x.equals("1")) {
                                S.Eliminar_teclado(t);
                                S.Anadir_teclado(p);
                                System.out.println("Solucion nueva añadida");
                            }
                            else System.out.println("Solucion antigua mantenida");
                            System.out.println("Modificar teclas del teclado solucion? (S=1; N=0)");
                            x = in.next();
                            while (!x.equals("0")) {
                                System.out.println("Primera tecla");
                                Simbolo a1 = new Simbolo(in.next().charAt(0));
                                Tecla aa = new Tecla(a1);
                                System.out.println("Segunda tecla");
                                Simbolo a2 = new Simbolo(in.next().charAt(0));
                                Tecla bb = new Tecla(a2);
                                p.swap_teclas(aa, bb);
                                p.imprimir_teclado();
                                System.out.println("Seguir modificando?(S=1; N=0)");
                                x = in.next();
                            }
                        }
                        else {
                            t.imprimir_teclado();
                            p = t.copiaTeclado();
                            m.crear_matrices(t, f);
                            s.Sol(a, p, m);
                            p = s.SolTec();
                            S.Anadir_teclado(p);
                            p.imprimir_teclado();
                            System.out.println("Solucion nueva añadida");
                            System.out.println("Modificar teclas del teclado solucion? (S=1; N=0)");
                            x = in.next();
                            while (!x.equals("0")) {
                                System.out.println("Primera tecla");
                                Simbolo a1 = new Simbolo(in.next().charAt(0));
                                Tecla aa = new Tecla(a1);
                                System.out.println("Segunda tecla");
                                Simbolo a2 = new Simbolo(in.next().charAt(0));
                                Tecla bb = new Tecla(a2);
                                p.swap_teclas(aa, bb);
                                p.imprimir_teclado();
                                System.out.println("Seguir modificando?(S=1; N=0)");
                                x = in.next();
                            }
                        }
                    }
                }
                else System.out.println("No existe teclado, no se puede encontrar solucion");
                
                
            }
            else if (x.equals("7")) {
//                for (int i = 0; i < aux.length; ++i) {
//                    System.out.println(aux[i]);
//               }
                cd.escribir_archivo(".\\src\\teclado_prop\\STUB3.txt", aux);
            }
            else if (x.equals("6")) {
                /*System.out.println("Tamaño");
                int i = in.nextInt();
                 int j = in.nextInt();
                 System.out.println("Nombre");
                 String name = in.next();
                 t = new Teclado(i,j,name);
                 System.out.println("Insertar teclas manualmente");
                t.leer_teclado_manualmente();
                tec.Anadir_teclado(t);
                
                 int n, q;
                    String nombre;
                    System.out.println("Tamaño");
                    nombre = in.next();
                    n = Integer.parseInt(nombre);
                    //System.out.println("fvrfvrfv");
                    nombre = in.next();
                    q = Integer.parseInt(nombre);
                    //System.out.println("<<<<");
                    System.out.println("Nombre");
                    nombre = in.next();
                    t = new Teclado(n,q,nombre);
                    char z;
                     System.out.println("Insertar teclas manualmente");
                    for (int ii = 0; ii < n; ++ii) {
                        for (int jj = 0; jj < q; ++jj) {
                            nombre = in.next();
                            z = nombre.charAt(0);
                            //System.out.println("<<<<"+ z);
                            Simbolo b = new Simbolo(z);
                            Tecla aa = new Tecla(b);
                            t.anadir_tecla(ii, jj, aa);
                        }
                    }
                    tec.Anadir_teclado(t);
                    //t.leer_teclado_manualmente();
            }
            x = in.next();
        }
        System.out.println("¡Hola pap\u00e1!\nYa puedo escribir bi\u00e9n.\n\u00d1a\u00f1a\u00f1a\u00f1a");*/
    }
}
