/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package teclado_prop;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

/**
 *
 * @author Aitor
 */
public class CtrlDominio {
    private Teclados t;
    private CtrlDatos cd;
    private  ArrayList<String> b;
    private Matrices m = new Matrices();
    //private Algoritmo a = new Algoritmo();
    private Solucio s = new Solucio();
    private Teclado t2;
    private String s2 = ".\\src\\teclado_prop\\STUB.txt";  
    private String config = ".\\src\\teclado_prop\\CONFIG.txt";
    private CtrlPresentacion cp;
    
    public void inicializar(CtrlPresentacion cp) throws Exception {
        this.cp = cp;
        cd = new CtrlDatos();
        t = new Teclados();
        t.Crear(cd.leer_archivo(s2));
        b = new ArrayList(Arrays.asList(cd.leer_archivo(s2)));
    }
    
    public String consultar_teclado(String nombre) {
        Teclado aux = t.getTeclado(nombre);
        return aux.consultar_teclado();
    }
    // añades el teclado a la ultima posicion de la lista y a la lista de teclados
    public void anadir_teclado(String nom, int n, int m, String letras) throws Exception {
        Teclado tec = new Teclado(n,m,nom);
        tec.anadir_teclas(letras);
        /*int cont = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; ++j) {
                tec.anadir_tecla(i,j,new Tecla(new Simbolo(letras.charAt(cont))));
                cont += 2;
            }
        }*/    
        t.Anadir_teclado(tec);
        ArrayList<String> aux = t.String_Teclado(tec);
        b.addAll(aux);
        String [] aux3 = new String[b.size()];
        cd.escribir_archivo(s2, b.toArray(aux3));
    }
    // eliminas el teclado de teclados t del lista de string
    public void eliminar_teclado(String nom) throws IOException, Exception {
        Teclado tec = t.getTeclado(nom);
        t.Eliminar_teclado(tec);
        int tam = tec.getN();
        int cont = b.indexOf(tec.getNombre());
        b.remove(tec.getNombre());
        b.remove(cont);
        b.remove(cont);
        for (int i = 0; i < tam; ++i) {
            b.remove(cont);
        }
        String [] aux = new String[b.size()];
        cd.escribir_archivo(s2, b.toArray(aux));
    }
    
    public String[] nombres_Teclados() {
        return t.Imprimir_Nombres();
    }
    
    public String[] leer_archivo(String archivo) throws IOException {
        return cd.leer_archivo(archivo);
    }
    
    public void crear_teclado(String nombre, String texto) throws Exception {
         Teclado tec = t.getTeclado(nombre);
         t2 = tec.copiaTeclado();
         t2.anadir_nombre(tec.getNombre()+"_1");
         m.crear_matrices(t2, texto);
         m.imprimir_distancias();
         System.out.println();
         System.out.println();
         m.imprimir_probabilidades();
         String aux[] = cd.leer_archivo(config);
         int aux2 = Integer.parseInt(aux[0]);
         s.Sol(t2, m, this, aux2);
         t2 = s.SolTec();
        
         
    }
    
    public String consultar_tec_en_creacion() {
        return t2.getNombre()+"\n"+t2.consultar_teclado();
    }
    
    public void cambiar_nombre(String nombre) throws Exception {
        t2.anadir_nombre(nombre);
    }
    
    public void swap_teclas(String a,String b) throws Exception {
        char a1 = a.charAt(0);
        char b1 = b.charAt(0);
        t2.swap_teclas(new Tecla(new Simbolo(a1)), new Tecla(new Simbolo(b1)));
    } 
    
    public void anadir_tec_en_creacion() throws IOException, Exception {
        t.Anadir_teclado(t2);
        ArrayList<String> aux = t.String_Teclado(t2);
        b.addAll(aux);
        t2 = null;
        String [] aux2 = new String[b.size()];
        cd.escribir_archivo(s2, b.toArray(aux2));
    }
    public void desechar_tec_en_creacion() {
        t2=null;
    }
    
    public long getTiempo() {
        return s.getTiempo();
    }
    
    public void escribir_archivo(String archivo, String[] datos) throws IOException {
        cd.escribir_archivo(archivo, datos);
    }
    
    public void finalitzar_calcul() {
        s.finalitzar_calcul();
    }
    public void calcul_realitzat(long temps) {
        cp.calcul_realitzat(temps);
    }
    public void sol_cor() throws Exception {
        s.sol_corre();
    }
}
