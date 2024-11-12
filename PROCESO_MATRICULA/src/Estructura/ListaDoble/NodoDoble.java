package Estructura.ListaDoble;
import java.io.*;
import Modelo.*;
public class NodoDoble implements Serializable {
    
    public Docente doc;
    public NodoDoble ant;
    public NodoDoble sig;
    
    public NodoDoble(Docente d){
        this.doc=d;
        ant=sig=null;
    }//fin constructor    
}//fin de la clase
