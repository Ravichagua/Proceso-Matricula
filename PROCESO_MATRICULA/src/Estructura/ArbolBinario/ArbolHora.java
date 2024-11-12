package Estructura.ArbolBinario;
import Modelo.Estudiante;
import java.io.Serializable;
import javax.swing.table.DefaultTableModel;
public class ArbolHora implements Serializable {
    
    private NodoHora Raiz;
    
    public ArbolHora(){
        Raiz=null;
    }
    
    
    
    
    //metodo que agrega nodos al arbol
    public NodoHora AgregarEstudiante(NodoHora nodo,Estudiante elem){
        if(nodo==null){
            NodoHora nuevo =  new NodoHora(elem);
            return nuevo;
        }
        else{
            if(elem.getNombreCompleto().compareTo(
                  nodo.getElemento().getNombreCompleto())>0){
               nodo.setDer(AgregarEstudiante(nodo.getDer(),elem));
            }else{
                nodo.setIzq(AgregarEstudiante(nodo.getIzq(),elem)); 
            }                    
        }
        return nodo;
    }
    //metodo que muestra los datos enOrden (Izq - raiz - der)
    public void MostrarEnOrden(NodoHora nodo,DefaultTableModel modelo){
        if(nodo!=null){
            MostrarEnOrden(nodo.getIzq(),modelo);
            modelo.addRow(nodo.getElemento().Registro());
            MostrarEnOrden(nodo.getDer(),modelo);
        }
    }
    //metodo que busca un nodo en el arbol nombre completo
    public NodoHora BuscarPorNombreCompleto(String dato){
        NodoHora aux=Raiz;
        while(aux!=null){
            if(aux.getElemento().getNombreCompleto().startsWith(dato)){
                return aux;
            }else{
                if(dato.compareToIgnoreCase(
                        aux.getElemento().getNombreCompleto())>0){
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
