package teclado_prop;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DriverTeclados {

	public static void main(String[] args) throws IOException, Exception {
            Teclados T = new Teclados();
            Teclado t = new Teclado();
            System.out.println("OPCIONES:");
            System.out.println("1 = Crear (Crea la lista de teclados de nuestra base de datos"); 
            System.out.println("2 = Anadir teclado [String nombre] [int n] [int m] metodo leer_teclado(Teclado)");
            System.out.println("3 = Consultar_num (Muestra el número de teclados existentes:");
            System.out.println("4 = Consultar [String s] (Muestra el nombre, el tamaño y contenido del teclado");
            System.out.println("5 = Eliminar [String s] (Elimina el teclado con nombre s");
            System.out.println("6 = Imprimir conjunto de teclados (Imprime por pantalla el contenido del teclado s)");
            System.out.println("0 = Finalizar (Finaliza el programa)");
            
            Scanner in = new Scanner(System.in);
            String x = in.next();
            while(!x.equals("0")) {
                if(x.equals("1")) {
                    FileReader fr = new FileReader(".\\src\\teclado_prop\\STUB.txt");
                    //Insertar STUB en Crear_teclado para leer todos los teclados
                    CtrlDatos cd = new CtrlDatos();
                    String s = ".\\src\\teclado_prop\\STUB.txt";
                    String[] aux = cd.leer_archivo(s);
                    T.Crear(aux);
                }
                 else if (x.equals("2")) { // No identifica la Tecla Espacio, supongo que couando se lea lo pondra.
                    int n, m;
                    String nombre;
                    nombre = in.next();
                    Scanner a = new Scanner(System.in);
                    n = a.nextInt();
                    m = a.nextInt();
                    t = new Teclado(n,m,nombre);
                    t.leer_teclado_manualmente();
                    T.Anadir_teclado(t);
                }
                  else if(x.equals("3")) {
                    T.Consultar_num_teclados();
                    //System.out.println("El número de teclados es "+num);
                }
                  /*
                else if(x.equals("4")) {
                    String s = in.next();
                    t = T.getTeclado(s);
                    //System.out.println("0000000");
                    T.Consultar_teclado(t);
                }
                */
                else if(x.equals("5")) {
                    String s = in.next();
                    t = T.getTeclado(s);
                    T.Eliminar_teclado(t);
                }
                else if (x.equals("6")) {
                    T.Imprimir_Teclados();
                }
                x = in.next();
            }

	}

}