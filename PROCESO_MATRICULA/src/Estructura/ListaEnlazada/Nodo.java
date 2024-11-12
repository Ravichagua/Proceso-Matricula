
package Estructura.ListaEnlazada;

import Modelo.Estudiante;
import java.io.Serializable;

public class Nodo implements Serializable{
    
    public Estudiante est;
    public Nodo sig;
    
    public Nodo(Estudiante e){
        est=e;
        sig=null;
    
    
    }//fin constructor    
}//fin de la clase

