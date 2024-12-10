package Estructura.ArrayList;

import Estructura.ListaDoble.ListaEnlazadaDoble;
import Estructura.ListaDoble.NodoDoble;
import Modelo.Docente;
import Persistencia.PersistenciaDocente;
import Vista.HorarioVista;
import java.util.ArrayList;


public class ArrayListDatos {

    ArrayList<Docente> lista=new ArrayList<Docente>();
    
    public ArrayListDatos(){}
        
    public void ExtraerListaProfesores(){
        
        ListaEnlazadaDoble listaProfesores = PersistenciaDocente.RecuperarDocente();
        
        NodoDoble nodoActual=listaProfesores.ini;
        
        while(nodoActual!=null){
            System.out.println(nodoActual.doc.getNombreCompleto());
            lista.add(nodoActual.doc);
            
            nodoActual=nodoActual.sig;
        }
 
    }
    
    public void CargarListaProfesores(HorarioVista vista){
        vista.cbxProfesor.removeAllItems();
        
        
        String cursoSeleccionado = vista.cbxCurso.getSelectedItem().toString();
        
        System.out.println(cursoSeleccionado);
        
        for(Docente Elemento:lista){
            if(Elemento.getCurso().equals(cursoSeleccionado))
                vista.cbxProfesor.addItem(Elemento.getNombreCompleto());
        }
        
    }
}
