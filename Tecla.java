package teclado_prop;

public class Tecla {
    private Simbolo s;
    
    public Tecla(){
        
    }
    
    public Tecla(Simbolo sim) throws Exception{
        if (sim.getChar() <= 0 || sim.getChar() > 127) throw new Exception("Error simbolo");
        s = sim; 
    }
    
    public void anadir_simbolo_tecla(Simbolo sim) throws Exception{
        if (sim.getChar() <= 0 || sim.getChar() > 127) throw new Exception("Error simbolo");
        s = sim;
    }
    
    public char getSimbolo() {
        return s.getChar();
    }  
    
    public void setSimbolo(char c) {
        s.setChar(c);
    }
    public boolean es_letra() {
        return ((s.getChar() >= 'a') && (s.getChar() <= 'z'));
    }
}
