package teclado_prop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aitor
 */
public class CtrlPresentacion {
    
    private CtrlDominio cd;
    private Presentacion p;
    
     public void inicializar(Presentacion p) throws Exception {
         this.p = p;
        cd = new CtrlDominio();
        cd.inicializar(this);
    }
    
    public String consultar_teclado(String nombre) {
        return cd.consultar_teclado(nombre);
    }
    // añades el teclado a la ultima posicion de la lista y a la lista de teclados
    public void anadir_teclado(String nom, int n, int m, String letras) throws Exception {
        
        cd.anadir_teclado(nom,n,m,letras);
    }
    // eliminas el teclado de teclados t del lista de string
    public void eliminar_teclado(String nom) throws IOException, Exception {
        cd.eliminar_teclado(nom);
    }
    
    public String[] nombres_Teclados() {
        return cd.nombres_Teclados();
    }
    
    public String[] leer_archivo(String archivo) throws IOException {
        return cd.leer_archivo(archivo);
    }
    
    public void crear_teclado(String nombre, String texto) throws Exception {
         cd.crear_teclado(nombre, texto);
    }
    
    public String consultar_tec_en_creacion() {
        return cd.consultar_tec_en_creacion();
    }
    
    public void cambiar_nombre(String nombre) throws Exception {
        cd.cambiar_nombre(nombre);
    }
    
    public void swap_teclas(String a,String b) throws Exception {
        cd.swap_teclas(a, b);
    } 
    
    public void anadir_tec_en_creacion() throws IOException, Exception {
        cd.anadir_tec_en_creacion();
    }
    public void desechar_tec_en_creacion() {
        cd.desechar_tec_en_creacion();
    }
    
    public long getTiempo() {
        return cd.getTiempo();
    }
    
    public void escribir_archivo(String archivo, String[] datos) throws IOException {
        cd.escribir_archivo(archivo, datos);
    }
    
    public void finalitzar_calcul() {
        this.cd.finalitzar_calcul();
    }
    public void calcul_realitzat(long temps) {
        p.calcul_realitzat(temps);
    }
    
    public void sol_cor() throws Exception {
        cd.sol_cor();
    }
}


