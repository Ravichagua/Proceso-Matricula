package Ordenamientos;
//librerias
import Estructura.ListaEnlazada.Nodo;
import Estructura.ListaEnlazada.ListaEnlazada;
import Modelo.*;
public class OrdenarListasEnlazadas {    
    public static ListaEnlazada PorNombres(ListaEnlazada a){
        Nodo k;
        for(Nodo i=a.ini;i!=null;i=i.sig){
            k=i;
            for(Nodo j=i.sig;j!=null;j=j.sig){
                if(j.est.getNombre().compareTo(k.est.getNombre())<0){
                    k=j;
                }
            }
            Estudiante aux = i.est;
            i.est = k.est;
            k.est = aux;
        }
        return a;
    }//fin metodo
    public static ListaEnlazada Edad(ListaEnlazada a){
        
        return a;
    }
}//fin de clase
