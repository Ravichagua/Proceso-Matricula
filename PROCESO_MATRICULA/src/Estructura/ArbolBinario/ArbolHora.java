package Estructura.ArbolBinario;
import Modelo.Estudiante;
import java.io.Serializable;
import javax.swing.table.DefaultTableModel;
import Modelo.Horario;
import java.time.LocalTime;

public class ArbolHora implements Serializable {
    
    private NodoHora Raiz;
    
    public ArbolHora(){
        Raiz=null;
    }
    
    
    
    
    //metodo que agrega nodos al arbol
    public NodoHora AgregarHorario(NodoHora nodo,Horario elem){
        
        
        
        
        if(nodo==null){
            NodoHora nuevo =  new NodoHora(elem);
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
    public void MostrarEnOrden(NodoHora nodo,DefaultTableModel modelo){
        //String titulos[]={"HoraIni","curso","salonId"};
       
        if(nodo!=null){
            MostrarEnOrden(nodo.getIzq(),modelo);
            modelo.addRow(nodo.getElemento().getRegistro());
            MostrarEnOrden(nodo.getDer(),modelo);
        }
    }
    //metodo que busca un nodo en el arbol nombre completo
    public NodoHora BuscarPorHora(String dato){
        System.out.println("this got triggered");
        
        NodoHora aux=Raiz;
        
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

    
    
    public NodoHora getRaiz() {
        return Raiz;
    }

    public void setRaiz(NodoHora Raiz) {
        this.Raiz = Raiz;
    }
}//fin de la clase
