package Ordenamiento;

import Estructura.ListaEnlazada.ListaEnlazada;
import Estructura.ListaEnlazada.NodoEnlazado;


public class Burbuja {

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
                        // si actual es el primer nodo movemos ini al siguiente nodo
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
}
    
}
