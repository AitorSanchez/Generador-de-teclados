/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package teclado_prop;

import java.io.File;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.Arrays;

/**
 *
 * @author 
 */
public class Matrices{

    
    private int con[];
    private double mat_dist[][];
    private double mat_prob[][];
    private char pos_teclas[];
    
    public Matrices() {}
    
    public void crear_matrices(Teclado t, String texto) throws Exception {
        pos_teclas = new char[t.getN()*t.getM()];
        for(int i = 0; i < t.getN(); i++) {
            for(int j = 0; j < t.getM(); j++) {
                pos_teclas[i*t.getM()+j] = t.getSimbolo(i,j);
            }
        }
        Calcular_distancia_op(t);
        op_calcular_probabilidad(t, texto);          
    }
    
    public void imprimir_distancias() {
        DecimalFormat df = new DecimalFormat("0.00000"); 
        for (int i = 0; i < mat_dist.length; ++i) {
            for (int j = 0; j < mat_dist[0].length; ++j) {
                System.out.print(df.format(mat_dist[i][j])+ "  ");
            }
            System.out.println("");
        }
    }
    
    public void imprimir_destancia_letras(Teclado t,char a, char b) {
        DecimalFormat df = new DecimalFormat("0.00000");
        int x = cerca(pos_teclas, a);
        int y = cerca(pos_teclas, b);
        if (x == -1 || y == -1) System.out.println("Algun simbolo no existe"); 
        else {
            System.out.println(a+"|"+b+ ": " + df.format(mat_dist[x][y])); 
        }
    }
    public int cerca(char []a, char x) {
        for(int i = 0; i < a.length; ++i) {
            if (a[i] == x) return i;
        }
        return -1;
    }
    
    public void imprimir_probabilidades() {
        DecimalFormat df = new DecimalFormat("0.00000"); 
        for (int i = 0; i < mat_prob.length; ++i) {
            for (int j = 0; j < mat_prob[0].length; ++j) {
                System.out.print(df.format(mat_prob[i][j])+ "  ");
            }
            System.out.println("");
        }
    }
    
    public void imprimir_probabilidad_letras(Teclado t, char c1, char c2) {
        DecimalFormat df = new DecimalFormat("0.00000"); 
        int n = t.getN();
        int m = t.getM();
        int tam = n*m;
        char aux;
        boolean finaliza = false;
        for(int i = 0; i < tam; i++) {
            if(pos_teclas[i] == c1 || pos_teclas[i] == c2) {
                if(pos_teclas[i] == c1) aux = c2;
                else aux = c1;
                for(int j = 0; j < n*m && !finaliza; j++) {
                    if(pos_teclas[j] == aux) {
                        System.out.println(c1+"|"+c2+": "+df.format(mat_prob[i][j]));
                        finaliza = true;
                    }
                }
            }
        }
        if(!finaliza) System.out.println("Algun simbolo no existe"); 
    }
    
    public double[][] getDistancias(){
        return this.mat_dist;
    }
    
    public double[][] getProbabilidad() {
        return this.mat_prob;
    }
    
    public char[] getPos() {
        return this.pos_teclas;
    }
    
    public int [] getCon() {
        return con;
    }
    
    private void Calcular_distancia(Teclado t) throws Exception {
        int n = t.getN();
        int m = t.getM();
        int tam = n*m;
        double dist_max = (double)Math.sqrt(Math.pow(n-1, 2)+Math.pow(m-1, 2));
        mat_dist = new double[tam][tam];
        char aux1, aux2;
        Simbolo x, y;
        Tecla w, z;
        int iaux = 0, jaux;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                aux1 = t.getSimbolo(i,j);
                x = new Simbolo(aux1);
                w = new Tecla(x);
                jaux = 0;
                for (int k = 0; k < n; ++k) {
                    for (int l = 0; l < m; ++l) {
                        aux2 = t.getSimbolo(k,l);
                        y = new Simbolo(aux2);
                        z = new Tecla(y); // ver que va mal
                        mat_dist[iaux][jaux] = (Distancia.euclidean(t.getCoordenadas(w), t.getCoordenadas(z)))/dist_max;
                        mat_dist[jaux][iaux] = (Distancia.euclidean(t.getCoordenadas(w), t.getCoordenadas(z)))/dist_max;
                        ++jaux;
                    }
                }
                ++iaux;
            }
        }
    }
    
     private void Calcular_distancia_op(Teclado t) throws Exception {
         int n = t.getN();
        int m = t.getM();
        int tam = n*m;
        double dist_max = (double)Math.sqrt(Math.pow(n-1, 2)+Math.pow(m-1, 2));
        mat_dist = new double[tam][tam];
        
        char aux1, aux2;
        Tecla w= new Tecla();
        Tecla z=new Tecla();
        Simbolo a = new Simbolo();
        Simbolo b = new Simbolo();
        int iaux = 0, jaux;
        for (int i = 0; i < tam; ++i) {
            a.setChar(pos_teclas[i]);
            w.anadir_simbolo_tecla(a);
            t.getCoordenadas(w);
            for (int j = i; j < tam; ++j) {
                b.setChar(pos_teclas[j]);
                z.anadir_simbolo_tecla(b);
                t.getCoordenadas(z);
                mat_dist[i][j] = (Distancia.euclidean(t.getCoordenadas(w), t.getCoordenadas(z)));
                mat_dist[j][i] = (Distancia.euclidean(t.getCoordenadas(w), t.getCoordenadas(z)));
            }
        }
    }

    private int pos(char a) {
        for (int i = 0; i < pos_teclas.length; ++i) {
            if (pos_teclas[i] == a) return i;
        }
        return -1;
    } 
    private void op_calcular_probabilidad(Teclado t, String text) {
        int n = t.getN();
        int m = t.getM();
        int tam = n*m;
        mat_prob = new double[tam][tam];
        con = new int[tam];
        Arrays.fill(con, 0);
        int pos1;
        int pos2;
        int cont = 0;
        while (cont < text.length()) {
           pos1 = pos(text.charAt(cont));
            if (pos1 != -1) {
                ++con[pos1];
                if(cont+1 != text.length() && (pos2 = pos(text.charAt(cont+1))) != -1) {
                    ++mat_prob[pos1][pos2];
                    ++mat_prob[pos2][pos1];
                }
            }
            ++cont;
        }
        /*
        double max = 0;
        for (int i = 0; i < tam; i++) {
            for (int j = i; j < tam; j++) {
                if (mat_prob[i][j] > max) max = mat_prob[i][j];
            }
        }
        
        ++max;
        for (int i = 0; i < tam; i++) {
            for (int j = i+1; j < tam; j++) {
                mat_prob[i][j] = max - mat_prob[i][j];
                mat_prob[j][i] = max - mat_prob[j][i];
            }
        }
                */
    } 
    
    boolean todo_ceros() {
        for (int i = 0; i < con.length; i++) {
            if (con[i] != 0) return false;
        }
        return true;
    }
}

