package Ordenamientos;
//librerias
import Estructura.ListaEnlazada.NodoEnlazado;
import Estructura.ListaEnlazada.ListaEnlazada;
import Modelo.*;
public class OrdenarListasEnlazadas {    
    public static ListaEnlazada PorNombres(ListaEnlazada a){
        NodoEnlazado k;
        for(NodoEnlazado i=a.ini;i!=null;i=i.sig){
            k=i;
            for(NodoEnlazado j=i.sig;j!=null;j=j.sig){
                if(j.est.getNombre().compareTo(k.est.getNombre())<0){
                    k=j;
                }
            }
            Estudiante aux = i.est;
            i.est = k.est;
            k.est = aux;
        }
        return a;
    }
    public static ListaEnlazada PorEdad(ListaEnlazada a){
 
         boolean swapped;
    do {
        swapped = false;
        NodoEnlazado actual = a.ini;
        NodoEnlazado anterior = null;

        while (actual != null && actual.sig != null) {
            if (actual.est.getEdad() > actual.sig.est.getEdad()) {
                // Intercambiar los nodos completos
                if (anterior == null) {
                    // Si 'actual' es el primer nodo, movemos 'ini' al siguiente nodo
                    a.ini = actual.sig;
                } else {
                    // Enlazar el nodo anterior con el siguiente nodo
                    anterior.sig = actual.sig;
                }

                // Conectar el nodo actual con el siguiente del siguiente
                NodoEnlazado temp = actual.sig.sig;
                actual.sig.sig = actual;
                actual.sig = temp;

                swapped = true;
            }
            anterior = actual;
            actual = actual.sig;
        }
    } while (swapped);

    return a;
}
    
}
