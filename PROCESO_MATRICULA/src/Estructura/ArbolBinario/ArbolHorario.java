package Estructura.ArbolBinario;
import Modelo.Estudiante;
import java.io.Serializable;
import javax.swing.table.DefaultTableModel;
import Modelo.Horario;
import java.time.LocalTime;

public class ArbolHorario implements Serializable {
    
    private NodoHorario Raiz;
    
    public ArbolHorario(){
        Raiz=null;
    }
    
    
    
    
    //metodo que agrega nodos al arbol
    public NodoHorario AgregarHorario(NodoHorario nodo,Horario elem){
        
        
        
        
        if(nodo==null){
            NodoHorario nuevo =  new NodoHorario(elem);
            return nuevo;
        }
        else{
            LocalTime tiempoNodo = LocalTime.parse(nodo.getElemento().getHoraInicio());
        
            LocalTime tiempoElem = LocalTime.parse(elem.getHoraInicio());
            
            
            if(tiempoElem.isAfter(tiempoNodo)){
               nodo.setDer(AgregarHorario(nodo.getDer(),elem));
            }else{
                nodo.setIzq(AgregarHorario(nodo.getIzq(),elem)); 
            }                    
        }
        return nodo;
    }
    //metodo que muestra los datos enOrden (Izq - raiz - der)
    public void MostrarEnOrden(NodoHorario nodo,DefaultTableModel modelo){
        //String titulos[]={"HoraIni","curso","salonId"};
       
        if(nodo!=null){
            MostrarEnOrden(nodo.getIzq(),modelo);
            modelo.addRow(nodo.getElemento().getRegistro());
            MostrarEnOrden(nodo.getDer(),modelo);
        }
    }
    //metodo que busca un nodo en el arbol nombre completo
    public NodoHorario BuscarPorHora(String dato){

        
        NodoHorario aux=Raiz;
        
        while(aux!=null){
            
            if(aux.getElemento().getHoraInicio().startsWith(dato)){
                
                
                return aux;
            }else{
                
                if(dato.compareToIgnoreCase(
                        aux.getElemento().getHoraInicio())>0){
                    aux=aux.getDer();
                    
                }else{
                    aux=aux.getIzq();
                    
                }
            }
        }
        return null;
    }

    
    
    public NodoHorario getRaiz() {
        return Raiz;
    }

    public void setRaiz(NodoHorario Raiz) {
        this.Raiz = Raiz;
    }
}//fin de la clase
