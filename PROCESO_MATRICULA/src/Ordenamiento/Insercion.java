
package Ordenamiento;
import Estructura.ListaDoble.*;
import Estructura.Pila.Pila;
import Modelo.*;

public class Insercion {
    //algoritmo de ordenamiento por Inserción en listas doble
    public static ListaEnlazadaDoble ListaDoblePorNombre(ListaEnlazadaDoble lista){
        for(NodoDoble i=lista.ini.sig; i!=null;i=i.sig){
           Docente value=i.doc;
           NodoDoble j=i;
           while(j!=lista.ini && j.ant.doc.getNombre().compareTo(value.getNombre())>0){
               j.doc = j.ant.doc;
               j=j.ant;
           }
           j.doc = value;
           
           
        }
        return lista;
    }

//    public static Pila PilaPorInsercionFecha(Pila pila) {
//    // Crear una pila auxiliar para almacenar las fechas ordenadas
//    Stack<Matricula> pilaOriginal = pila.pila;
//    Stack<Matricula> pilaOrdenada = new Pila().pila;
//
//    // Procesar cada elemento de la pila original
//    while (!pilaOriginal.isEmpty()) {
//        Matricula current = pilaOriginal.pop(); // Sacar el elemento de la pila original
//        
//        Date fechaElegida = current.getFecha(); // Obtener la fecha asociada
//        
//        
//        
//        // Colocar el elemento en la posición correcta en la pila ordenada
//        while (!pilaOrdenada.isEmpty() && pilaOrdenada.peek().getFecha().after(fechaElegida)) {
//            pilaOriginal.push(pilaOrdenada.pop());
//        }
//        
//        // Insertar el elemento actual en la pila ordenada
//        pilaOrdenada.push(current);
//
//        // Reapilar los elementos que fueron movidos a la pila original
//        while (!pilaOriginal.isEmpty() && pilaOrdenada.peek().getFecha().after(pilaOriginal.peek().getFecha())) {
//            pilaOrdenada.push(pilaOriginal.pop());
//        }
//    }
//    
//    Pila pilaNueva=new Pila();
//    pilaNueva.pila=pilaOrdenada;
//    return pilaNueva;
//    }
    //***********************************************************************
//    public static Pila PilaPorInsercionFecha(Pila pila) {
//    // Crear una pila auxiliar para almacenar las fechas ordenadas
//    Stack<Matricula> pilaOriginal = pila.pila;  // La pila original
//    Stack<Matricula> pilaOrdenada = new Stack<>();  // Pila ordenada
//
//    // Procesar cada elemento de la pila original
//    while (!pilaOriginal.isEmpty()) {
//        Matricula current = pilaOriginal.pop(); // Sacar el elemento de la pila original
//        Date fechaElegida = current.getFecha(); // Obtener la fecha asociada
//        
//        // Colocar el elemento en la posición correcta en la pila ordenada
//        while (!pilaOrdenada.isEmpty() && pilaOrdenada.peek().getFecha().after(fechaElegida)) {
//            pilaOriginal.push(pilaOrdenada.pop()); // Mover los elementos de la pila ordenada de vuelta a la pila original
//        }
//        
//        // Insertar el elemento actual en la pila ordenada
//        pilaOrdenada.push(current);
//
//        // Reapilar los elementos que fueron movidos a la pila original y que deben ir en la pila ordenada
//        while (!pilaOriginal.isEmpty() && !pilaOrdenada.isEmpty() && pilaOrdenada.peek().getFecha().after(pilaOriginal.peek().getFecha())) {
//            pilaOrdenada.push(pilaOriginal.pop());
//        }
//    }
//    
//    // Crear la nueva pila que contendrá los elementos ordenados
//    Pila pilaNueva = new Pila();
//    pilaNueva.pila = pilaOrdenada;  // Asignar la pila ordenada
//    return pilaNueva;
//}
    public static void PilaPorInsercionFecha(Pila pila) {
  
}
    
}
