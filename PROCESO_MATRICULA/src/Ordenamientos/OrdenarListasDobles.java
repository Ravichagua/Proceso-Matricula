
package Ordenamientos;
import Estructura.ListaDoble.*;
import Modelo.*;
public class OrdenarListasDobles {
    //algoritmo de ordenamiento por Inserción en listas doble
    public static ListaEnlazadaDoble PorNombre(ListaEnlazadaDoble lista){
        for(NodoDoble i=lista.ini.sig; i!=null;i=i.sig){
           Docente value=i.doc;
           NodoDoble j=i;
           while(j!=lista.ini && j.ant.doc.getNombre().compareTo(value.getNombre())>0){
               j.doc = j.ant.doc;
               j=j.ant;
           }//fin while
           j.doc = value;
           
           
        }
        return lista;
    }//fin ordenar
}//fin de la clase
