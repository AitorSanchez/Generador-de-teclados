package teclado_prop;

public class Simbolo {
    private char c;
    
    public Simbolo(){
        
    }
    
    public Simbolo(char inp) throws Exception{
        if (inp < 0 || inp > 127) throw new Exception("Error caracter");
        c = inp;
    }
    
    public char getChar() {
        return c;
    }
    
    public void setChar(char c) {
        this.c = c;
    }
    
}
