
package Estructura.ListaEnlazada;

import Modelo.Estudiante;
import java.io.Serializable;

public class NodoEnlazado implements Serializable{
    
    public Estudiante est;
    public NodoEnlazado sig;
    
    public NodoEnlazado(Estudiante e){
        est=e;
        sig=null;
    
    
    }//fin constructor    
}//fin de la clase

