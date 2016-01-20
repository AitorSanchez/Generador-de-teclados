/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package teclado_prop;

//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;



/**
 *
 * 
 */
public class CtrlDatos {

    private FileReader fr;
    private BufferedReader bf;
    private FileWriter fw;
    private BufferedWriter bw;
    private File f;
    
    public CtrlDatos() {
        fr = null;
        bf = null;
        fw = null;
        bw = null;
        f = null;
    }
    
    public String[] leer_archivo(String archivo) throws IOException {
        f = new File(archivo);
        fr = new FileReader(f);
        bf = new BufferedReader(fr);
        if (!f.exists()) throw new IllegalArgumentException("Error: No tienes ningun archivo abierto.");
        ArrayList<String> aux = new ArrayList();
        String linea;
        while ((linea = bf.readLine()) != null) {
            aux.add(linea);
        }
        String[] aux2 = null;
        if (aux.size() > 0) {
            aux2 = new String[aux.size()];
        }
        fr.close();
        bf.close();
        return aux.toArray(aux2);
    }
    
    public void escribir_archivo(String archivo, String[] datos) throws IOException{
        f = new File(archivo);
        if (!f.exists()) throw new IllegalArgumentException("Error: No tienes ningun archivo abierto.");
        fw = new FileWriter(f, false);
        bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw);
        for (int i = 0; i < datos.length; ++i) {
            out.println(datos[i]);
        }
        out.close();
        fw.close();
        bw.close();
    }




}