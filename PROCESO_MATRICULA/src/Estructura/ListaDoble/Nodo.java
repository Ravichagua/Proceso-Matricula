package Estructura.ListaDoble;
import java.io.*;
import Modelo.*;
public class Nodo implements Serializable {
    
    public Docente doc;
    public Nodo ant;
    public Nodo sig;
    
    public Nodo(Docente d){
        this.doc=d;
        ant=sig=null;
    }//fin constructor    
}//fin de la clase
