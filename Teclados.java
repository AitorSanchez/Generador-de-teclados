package teclado_prop;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;



public class Teclados {
    private ArrayList<Teclado> lista_teclados;
    
    public Teclados() {
        lista_teclados = new ArrayList();
    }
    
    public void Crear(String[] datos) throws Exception {
        //FileReader fr = new FileReader(".\\src\\teclado_prop\\STUB.txt");
        int cont = 0;
        String nom;
        int x, y;
        while (cont < datos.length) {
            nom = datos[cont];
            ++cont;
            x = Integer.parseInt(datos[cont]);
            ++cont;
            y = Integer.parseInt(datos[cont]);
            Teclado tt = new Teclado(x,y,nom);
            ++cont;
            int cont2;
            char caract = datos[cont].charAt(0);
            Simbolo s;
            Tecla t;
            for(int i = 0; i < x; i++) {
                cont2 = 0;
                for(int j = 0; j < y; j++) {
                    s = new Simbolo(caract);
                    t = new Tecla(s);
                    tt.anadir_tecla(i, j, t);
                    cont2 += 2;
                    if (cont2 >= y*2) {
                        cont2 = 0;
                         ++cont;
                    }
                    if (cont != datos.length) caract = datos[cont].charAt(cont2);
                }
            }
            if (!Existe(tt)) lista_teclados.add(tt);
        }
    }
    
    public void Consultar_num_teclados() {
        System.out.println("Hay " + lista_teclados.size() + " teclados.");
    }
    /*//tiene que retornar un String con la matriz de teclas listo para hacer System.out
    public String Consultar_teclado(Teclado t) {
        String res = "";
        for (int i = 0; i < )
        return res;
        
    }
    */
    
    public boolean Existe(Teclado T) {
        if (T == null) return false;
        for (int i = 0; i < lista_teclados.size(); i++) {
            String nomt = lista_teclados.get(i).getNombre();
            if (nomt.equals(T.getNombre())) return  true;
        }
        return false;
    }
    
    public int pos_teclado(Teclado t) {
         int pos = 0;
         boolean existe = false;
        for (int i = 0; i < lista_teclados.size() && existe == false; i++) {
            String nomt = lista_teclados.get(i).getNombre();
            if (nomt.equals(t.getNombre())) {
                existe = true;
                pos = i;
            }
        }
        return pos;
    }
    
    // Falta hacer las excepciones
    public void Anadir_teclado (Teclado t) throws Exception{
        if (Existe(t)) throw new Exception("Existe este teclado, no se puede crear un nuevo teclado");
        else {
            lista_teclados.add(t);
            System.out.println("Teclodo añadido correctamente");
        } 
    }
    
    public void Eliminar_teclado(Teclado t) throws Exception {
        if (Existe(t)) {
            lista_teclados.remove(t);
        }
        else throw new Exception("El teclado no se encuentra en la lista");
    }
    
    public void Escribir_teclado(Teclado t) throws Exception {
        if (Existe(t)) {
            t.imprimir_teclado();
        }
        else throw new Exception("El teclado no se encuentra en la lista");
    }
    
    public Teclado getTeclado(String nombre) {
        boolean existe = false;
        for (int i = 0; i < lista_teclados.size() && existe == false; i++) {
            String nomt = lista_teclados.get(i).getNombre();
            if (nomt.equals(nombre)) {
                existe = true;
                return lista_teclados.get(i);
            }
        } 
        return null;
    }
    
    public void Imprimir_Teclados() {
        int esta = 0;
        for (int i = 0; i < lista_teclados.size(); i++) {
            System.out.println(lista_teclados.get(i).getNombre());
            System.out.println(lista_teclados.get(i).getN());
            System.out.println(lista_teclados.get(i).getM());
            lista_teclados.get(i).imprimir_teclado();
            System.out.println("");
            ++esta;
        }
        if(esta == 0) System.out.println("No hay teclados para imprimir");
    }
    
    public String[] Imprimir_Nombres() {
        String[] aux = new String[lista_teclados.size()];
        for (int i = 0; i < lista_teclados.size(); i++) {
            aux[i] = (lista_teclados.get(i).getNombre());
        }
        return aux;
    }
    
    public  ArrayList<String> String_Teclado(Teclado t) {
        ArrayList<String> aux = new ArrayList();
        aux.add(t.getNombre());
        aux.add(Integer.toString(t.getN()));
        aux.add(Integer.toString(t.getM()));
        for (int i = 0; i < t.getN(); ++i) {
            aux.add(t.fila_string(i));
        }
        return aux;
    }
        
}
    
    
    

