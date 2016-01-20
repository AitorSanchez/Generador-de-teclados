package teclado_prop;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static java.lang.Math.sqrt;

public class Teclado {
    
    private int n;
    private int m;
    private Tecla matriz[][];
    private String nombre;
    
    //ATENCION: procedimiento no acabado. Falta concretar cómo va a funcionar!!!
    
    
    public Teclado() {}
    
    public Teclado(int n, int m, String nombre) throws Exception {
        if (n <= 0 || n > 16 || m <= 0 || m > 16) throw new Exception("Error medida");
        if ("".equals(nombre)) throw new Exception("Error nombre");
        this.matriz = new Tecla[n][m]; //He cambiado la declaración aquí dentro ya que de otra manera no funcionaba!!
        this.n = n;
        this.m = m;
        String aux = nombre.toUpperCase();
        this.nombre = aux;
    }
    
    public void leer_teclado(FileReader fr) throws IOException, Exception {
        BufferedReader br = new BufferedReader(fr);
        String nom = br.readLine();
        this.nombre = nom;        
            
        //Lee las filas
        String str = br.readLine();
        this.n = Integer.parseInt(str);

        //Lee las columnas
        str = br.readLine();
        this.m = Integer.parseInt(str);

        this.matriz = new Tecla[n][m];
        
        int caract = br.read();
        br.read();
        Simbolo s;
        Tecla tecl;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                s = new Simbolo((char)caract);
                tecl = new Tecla(s);
                anadir_tecla(i,j,tecl);
                if(j == m-1 && i < n-1) {
                    br.readLine();
                    caract = br.read();
                    br.read();
                }
                else if (j < m-1) {
                    caract = br.read();
                    br.read();
                }
                else if(i == n-1) {
                    br.readLine();
                }
            }
        }
    }
    
    public Teclado copiaTeclado() throws Exception {
        Teclado aux = new Teclado(n, m, nombre);
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                aux.anadir_tecla(i, j, matriz[i][j]);
            }
        }
        return aux;
    }
    
    public int getN() {
        return n;
    }
    
    public int getM() {
        return m;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public char getSimbolo(int i, int j) {
        return matriz[i][j].getSimbolo();
    }
    
    public int[] getCoordenadas(Tecla Simbolo) {
        int x[] = {-1,-1};
        char a1 = Simbolo.getSimbolo();
        char a2;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                a2 = matriz[i][j].getSimbolo();
                if (a1 == a2) {
                    x[0] = i;
                    x[1] = j;
                    return x;
                }
            }
        }
        return x; 
    }
    
    public boolean tec_correctas(String s) {
        boolean existe[] = new boolean[127];
        Arrays.fill(existe, Boolean.FALSE);
        for (int i = 0; i < s.length(); i += 2) {
            if (!existe[s.charAt(i)]) {
                existe[s.charAt(i)] = true;
            }
            else return false;
        }
        return true;
    }
   
    public void anadir_teclas(String s) throws Exception {
        if (tec_correctas(s)) {
            int cont = 0;
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < m; ++j) {
                    Simbolo a = new Simbolo(s.charAt(cont));
                    Tecla b = new Tecla(a);
                    anadir_tecla(i, j, b);
                    cont += 2;
                }
            }
        }
        else throw new Exception("Error tecla repetida");
    }
    // mejorar con excepciones
    public boolean anadir_teclas() throws Exception {
        boolean existe[] = new boolean[126];
        Arrays.fill(existe, Boolean.FALSE);
        char e;
        boolean error = false;
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < n && !error; i++) {
            for (int j = 0; j < m && !error; j++) {
                e = in.next().charAt(0);
                if (!existe[(int)e-32]) {
                    Simbolo b = new Simbolo(e);
                    Tecla a = new Tecla(b);
                    anadir_tecla(i, j, a);                   
                    existe[(int)e-32] = true;
                }
                else {
                    return false;
                }
           }
        }
        return true;
    }
    
    public void leer_teclado_manualmente() throws Exception {
        boolean e = false;
        while (!e) {
            e = anadir_teclas();
        }
        //System.out.println("Teclado insertado correctamente");
    }
    
     public void anadir_n(int n) throws Exception {
        if (n <= 0 || n > 16) throw new Exception("Error medida");
        this.n = n;
    }
    
    public void anadir_m(int m) throws Exception {
        if (m <= 0 || m > 16) throw new Exception("Error medida");
        this.m = m;
    }
    
    public void anadir_nombre(String nom) throws Exception {
        if ("".equals(nombre)) throw new Exception("Error nombre");
        String aux = nom.toUpperCase();
        nombre = aux;
    }
    
    public void anadir_tecla(int i, int j, Tecla simbolo) throws Exception{
        matriz[i][j] = simbolo;
    }
    
    public boolean existe_tecla(Tecla simbolo) {
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (simbolo.getSimbolo() == matriz[i][j].getSimbolo()) return true;
            }
        }
        return false;
    }
    
     public boolean tec_correcto() {
        boolean rep = true;
        boolean existe[] = new boolean[127];
        Arrays.fill(existe, Boolean.FALSE);
        for (int i = 0; i < n && !rep; ++i) {
            for (int j = 0; j < m && !rep; ++j) {
                if (!existe[(int)matriz[i][j].getSimbolo()]) {
                    existe[(int)matriz[i][j].getSimbolo()] = true;
                }
                else rep = false;
            }
        }
        return rep;
    }
    
    public void swap_teclas(Tecla simbolo1, Tecla simbolo2) throws Exception {
        System.out.println(simbolo1.getSimbolo() + " " + simbolo2.getSimbolo()); 
            
        if ((!existe_tecla(simbolo1)) || (!existe_tecla(simbolo2))) {
            System.out.println(simbolo1.getSimbolo() + " " + simbolo2.getSimbolo()); 
            throw new Exception("No se puede hacer swap. Una de las teclas (o ambas) no existen.");
        }
        else if (simbolo1.getSimbolo() == simbolo2.getSimbolo()) {
            System.out.println(simbolo1.getSimbolo() + " " + simbolo2.getSimbolo()); 
            throw new Exception("No se puede hacer swap de la misma tecla");
        }
        else {
            System.out.println(simbolo1.getSimbolo() + " " + simbolo2.getSimbolo()); 
            
            Tecla a = simbolo2;
            int x[] = getCoordenadas(simbolo1);
            int y[] = getCoordenadas(simbolo2);
            anadir_tecla(y[0], y[1], simbolo1);
            anadir_tecla(x[0], x[1], a);
        }
    }
    
    public void eliminar_tecla(Tecla simbolo) {
        boolean elim = false;
        for(int i = 0; i < n && !elim; i++) {
            for(int j = 0; j < m && !elim; j++) {
                if(matriz[i][j].getSimbolo() == simbolo.getSimbolo()) matriz[i][j].setSimbolo('*');
            }
        }
    }
     
    public void imprimir_teclado() {
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (j == m-1) System.out.println(matriz[i][j].getSimbolo());
                else System.out.print(matriz[i][j].getSimbolo()+ " ");
            }
        }
    }
    public String consultar_teclado() {
        String teclado = new String();
        char c;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (j == m-1) {
                    teclado = teclado.concat(matriz[i][j].getSimbolo()+ "\n");
                }
                else teclado = teclado.concat(matriz[i][j].getSimbolo()+ " ");
            }
        }
        return teclado;
    }
    
    public String fila_string(int pos){
        String x = matriz[pos][0].getSimbolo() + " ";
        for (int  i = 1; i < m; ++i) {
            x = x.concat(matriz[pos][i].getSimbolo() + " ");       
        }
        return x;
    }
}
