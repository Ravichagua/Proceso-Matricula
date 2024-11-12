package Estructura.ListaDoble;
import Modelo.*;
import java.io.*;
public class ListaDoble implements Serializable {
    public Nodo ini;
    public Nodo fin;
    
    public ListaDoble(){
        
        ini=fin=null;
    }//fin de constructor
    //metodo que inserta un nodo al final de la lista
    public void InsertarAlFinal(Docente doc){
       Nodo nuevo =  new Nodo(doc);
       if(ini==null){
           ini=fin=nuevo;
       }else{
           nuevo.ant=fin;
           fin.sig= nuevo;
       }
       fin=nuevo;
       fin.sig=null;               
    }//fin insertar
    //metodo que busca un nodo por el codigo de docente
    public Nodo BuscarPorCodigo(String codigo){
        Nodo encontrado=ini;
        while(encontrado!=null){
            if(encontrado.doc.getCodigo().equals(codigo))
                return encontrado;
            encontrado=encontrado.sig;
        }
        return null;
    }//fin buscar
    //metodo que elimina un nodo
    public void EliminarNodo(Nodo actual){
      if(actual!=null){
          if(actual==ini){
              ini = actual.sig;
              if(actual.sig!=null) actual.sig.ant=null;
          }else if(actual.sig!=null){
              actual.ant.sig=actual.sig;
              actual.sig.ant = actual.ant;
          }else{
              actual.ant.sig=null;
              fin=actual.ant;
          }
      }//fin if
    }//fin eliminar
}//fin de la clase
