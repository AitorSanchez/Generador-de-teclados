/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package teclado_prop;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

/**
 *
 * @author 
 */
public class Solucio {
    
    private int [] sol_ini;
    private int [] sol_final;
    private Teclado st;
    private long tiempo;
    private CtrlDominio cd;
    private LanzarThread l;
    private Matrices m;
    
    
    public int [] getSol_ini() {
        return sol_ini;
    }
    
    public int [] getSol_fin() {
        return sol_final;
    }
    
    public void Sol(Teclado t, Matrices m, CtrlDominio cd, int nivel) throws Exception {
        st = t;
        this.m = m;
        //m.crear_matrices(t, null); // falta el fichero
        sol_ini = m.getCon();
        this.cd = cd;
        int [] aux = copia(sol_ini);
        sort(aux);
        sol_ini = solucion_inicial(aux, sol_ini);
        for (int i = 0; i < sol_ini.length; ++i) {
            System.out.print(sol_ini[i]+" ");
        }
        if (m.todo_ceros()) sol_ini = new int[0];
        System.out.print(nivel + " ---");
         l = new LanzarThread(m.getDistancias(), m.getProbabilidad(), sol_ini, this, 10);
    }
    
    public void sort(int[] in){
        if(in.length <2) return;
            int mid = in.length/2;
            int left[] = new int[mid];
            int right[] = new int[in.length-mid];
            for(int i=0; i<mid; i++){
                left[i] = in[i];
            }
            for(int i=0; i<in.length-mid; i++){
                right[i] = in[mid+i];
            }
            sort(left);
            sort(right);
            merge(left, right, in);
    }

    private void merge(int[] a, int[] b, int[] all){
        int i=0, j=0, k=0;
        while(i<a.length && j<b.length){
            if(a[i] > b[j]){
                all[k] = a[i];
                i++;
            }
            else{
                all[k] = b[j];
                j++;
            }
            k++;
        }
        while(i<a.length){
            all[k++] = a[i++];
        }
        while(j<b.length){
            all[k++] = b[j++];
        }
    }
    // optimizar
    // no funciona cuando ay el mismo numero de repeticiones. Mñna termino de acer esta funcion
    public int [] solucion_inicial(int [] a, int []b)  {
        //System.out.println(" ");
        int [] aux = new int[a.length];
        Arrays.fill(aux, -1);
        for (int i = 0; i < a.length; ++i) {
           // System.out.print(i + " ?? ");
            for (int j = 0; j < b.length; ++j) {
                if (a[i] == b[j] && !esta(aux, j)) {
                    aux[i] = j;
                    //System.out.println(" como? " +a[i]+ " " +b[j] + " " + j + " " + " "+ i + " " + aux[i]);
                }
            }
        }
        return aux;
    }
    
    public boolean esta(int [] a, int x) {
        for (int i = 0; i < a.length; ++i) {
            if (a[i] == x) return true;
        }
        /*int ini = 0;
        int fin = a.length-1;
        int pos;
        while (ini <= fin) {
            pos = (ini+fin)/2;
            if (a[pos] == x) return true;
            else if (a[pos] < x) ini = pos+1;
            else fin = pos-1;
        }*/
        return false;
    }
    
    public int [] copia(int [] a) {
        int[] aux = new int [a.length];
        for (int i = 0; i < aux.length; ++i) {
            aux[i] = a[i];
        }
        return aux;
    }
    
    public Teclado SolTec() {
        return st;
    }
    
    public int bus_dicotomica(int []a, int x) {
        int ini = 0;
        int fin = a.length-1;
        int pos;
        while (ini <= fin) {
            pos = (ini+fin)/2;
            if (a[pos] == x) return pos;
            else if (a[pos] < x) ini = pos+1;
            else fin = pos-1;
        }
        return -1;
    }
    // ver si funciona
    public int [] inicial(int [] a, int []b)  {
        //System.out.println(" ");
        int [] aux = new int[a.length];
        Arrays.fill(aux, -1);
        int pos;
        for (int i = 0; i < a.length; ++i) {
            pos = bus_dicotomica(b, a[i]);
            if (pos != -1 && !esta(aux, pos)) {
                aux[i] = pos;
            }
        }
        return aux;
    }
    
    public long getTiempo() {
        return tiempo;
    }
    
    public void calcul_realitzat(long temps) {
        if (l.hi_ha_solucio()) {
            sol_final = l.get_solucio();
        }
        cd.calcul_realitzat(temps);
    }
    
    public void sol_corre() throws Exception {
         Simbolo sim;
            Tecla te;
            int cont = 0;
            char [] pos = m.getPos();
            for(int i = 0; i < st.getN(); i++) {
                 for(int j = 0; j < st.getM(); j++) {
                     sim = new Simbolo(pos[sol_final[cont]]);
                         te = new Tecla(sim);
                         st.anadir_tecla(i, j, te);
                         ++cont;
                     }
                 }
     
    }
    
    public void finalitzar_calcul() {
        l.parar();
    }
}