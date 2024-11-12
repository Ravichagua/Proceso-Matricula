
package Estructura.ListaEnlazada;

import Modelo.Estudiante;
import java.io.Serializable;
//import javax.swing.JTextArea;

public class ListaEnlazada implements Serializable{
    public NodoEnlazado ini;
    public NodoEnlazado fin;
    private int ctotal;
    
    public ListaEnlazada(){
        ini = fin = null;
    }
    //metodo que agrega un objeto al inicio de la lista
    public void AgregarAlInicio(Estudiante est){
        
        NodoEnlazado nuevo=new NodoEnlazado(est);
        
        if(ini==null && fin==null){
            ini=fin=nuevo; 
        }else{
            nuevo.sig=ini;
            ini = nuevo;
        }
    }
    //metodo que agrega un nodo al inicio de la lista
    public void AgregarAlFinal(Estudiante est){
        
        NodoEnlazado nuevo=new NodoEnlazado(est);
        
        if(ini==null && fin==null){
            ini=fin=nuevo; 
        }else{
            fin.sig=nuevo;
        }
        fin=nuevo;
        fin.sig=null;
    }
    
    //Metodo que busca un estudiante por medio de su DNI
    public NodoEnlazado BuscarPorDni(String dnibuscado){
        NodoEnlazado aux=ini;
        while(aux!=null){
            if(dnibuscado.equals(aux.est.getDni())){
                return aux;
            }
            aux= aux.sig;
        }
        return null;
    }

   //metodo que elimina un nodo
    public void EliminarEstudiante(NodoEnlazado actual){
        NodoEnlazado anterior=ini;
        while(anterior.sig!=actual && anterior.sig!=null){
            anterior=anterior.sig;
        }
        if(actual!=null){
            if(ini==actual){
                ini=actual.sig;
            }else{
                anterior.sig=actual.sig;
            }
        }
    }
           
    //metodo que actualiza el estudiantes de un nodo
    public void ActualizarEst(NodoEnlazado actual,Estudiante nuevoest){
        actual.est = nuevoest;
    }

    
    
    

    public NodoEnlazado getIni() {
        return ini;
    }

    public void setIni(NodoEnlazado ini) {
        this.ini = ini;
    }

    public NodoEnlazado getFin() {
        return fin;
    }

    public void setFin(NodoEnlazado fin) {
        this.fin = fin;
    }

    public int getCtotal() {
        return ctotal;
    }

    public void setCtotal(int ctotal) {
        this.ctotal = ctotal;
    }
}
