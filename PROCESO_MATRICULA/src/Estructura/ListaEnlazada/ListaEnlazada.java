
package Estructura.ListaEnlazada;

import Modelo.Estudiante;
import java.io.Serializable;
//import javax.swing.JTextArea;

public class ListaEnlazada implements Serializable{
    public Nodo ini;
    public Nodo fin;
    private int ctotal;
    
    public ListaEnlazada(){
        ini = fin = null;
    }
    //metodo que agrega un objeto al inicio de la lista
    public void AgregarAlInicio(Nodo nuevo){
        if(ini==null && fin==null){
            ini=fin=nuevo; 
        }else{
            nuevo.sig=ini;
            ini = nuevo;
        }
    }
    //metodo que agrega un nodo al inicio de la lista
    public void AgregarAlFinal(Nodo nuevo){
        if(ini==null && fin==null){
            ini=fin=nuevo; 
        }else{
            fin.sig=nuevo;
        }
        fin=nuevo;
        fin.sig=null;
    }
    
    //Metodo que busca un estudiante por medio de su DNI
    /*public Nodo BuscarPorDni(String dnibuscado){
        Nodo aux=ini;
        while(aux!=null){
            if(dnibuscado.equals(aux.est.getDni())){
                return aux;
            }
            aux= aux.sig;
        }
        return null;
    }*/

    //metodo que muestra en un TextArea la cantidad de estudiantes por
    //cada nivel
   /* public void MostrarResumen(JTextArea txa){       
        int contini=0,contprim=0,contsec=0;
        ctotal=0;
        for(Nodo aux=ini;aux!=null;aux=aux.sig){
            ctotal++;
            switch(aux.est.getNivel()){
                case "INICIAL": contini++; break;
                case "PRIMARIA": contprim++; break;
                case "SECUNDARIA": contsec++; break;
            }
        }//fin for
        txa.setText("Cantidad estudiantes           : "+ctotal+
                  "\nEstudiantes nivel inicial      : "+contini+
                  "\nEstudiantes nivel primaria     : "+contprim+
                  "\nEstudiantes nivel secundaria   : "+contsec);
    }
    */
   //metodo que elimina un nodo
    public void EliminarEstudiante(Nodo actual){
        Nodo anterior=ini;
        while(anterior.sig!=actual && anterior.sig!=null){
            anterior=anterior.sig;
        }
        if(actual!=null){
            if(ini==actual){
                ini=actual.sig;
            }else{
                anterior.sig=actual.sig;
            }
        }//fin if
    }//fin metodo
           
    //metodo que actualiza el estudiantes de un nodo
    public void ActualizarEst(Nodo actual,Estudiante nuevoest){
        actual.est = nuevoest;
    }
    
    
    
    

    public Nodo getIni() {
        return ini;
    }

    public void setIni(Nodo ini) {
        this.ini = ini;
    }

    public Nodo getFin() {
        return fin;
    }

    public void setFin(Nodo fin) {
        this.fin = fin;
    }

    public int getCtotal() {
        return ctotal;
    }

    public void setCtotal(int ctotal) {
        this.ctotal = ctotal;
    }
}//fin de la clase
