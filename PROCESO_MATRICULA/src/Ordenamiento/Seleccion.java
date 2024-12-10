package Ordenamiento;
//librerias
import Estructura.ListaEnlazada.NodoEnlazado;
import Estructura.ListaEnlazada.ListaEnlazada;
import Modelo.*;
public class Seleccion {    
    public static ListaEnlazada PorNombres(ListaEnlazada a){
        //Ordenamiento seleccion
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
    //************************ELIMINAR ESTO**********************************
    public static ListaEnlazada PorEdad(ListaEnlazada a){
        //Ordenamiento burbuja
        boolean swapped;
        do {
            swapped = false;
            NodoEnlazado actual = a.ini;
            NodoEnlazado anterior = null;

            while (actual != null && actual.sig != null) {
                if (actual.est.getEdad() > actual.sig.est.getEdad()) {
                    // intercambiar los nodos completos
                    if (anterior == null) {
                        // Si actual es el primer nodo, movemos ini al siguiente nodo
                        a.ini = actual.sig;
                    } else {
                        // enlazar el nodo anterior con el siguiente nodo
                        anterior.sig = actual.sig;
                    }

                    // conectar el nodo actual con el siguiente del siguiente
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
}//************************ELIMINAR ESTO**********************************
    
}
