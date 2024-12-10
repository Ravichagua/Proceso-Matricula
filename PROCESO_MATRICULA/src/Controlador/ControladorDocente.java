package Controlador;

import Ordenamiento.Insercion;
import java.awt.event.ActionListener;
import Vista.DocenteVista;
import java.awt.event.ActionEvent;
import Modelo.Docente;

import Procesos.*;
import Persistencia.PersistenciaDocente;
import Estructura.ListaDoble.*;
import Estructura.Pila.Pila;
public class ControladorDocente  implements ActionListener {
    DocenteVista vista;
    ListaEnlazadaDoble lista;
    
    NodoDoble encontrado;
    
    public ControladorDocente(DocenteVista fd){
        vista=fd;
        lista = new ListaEnlazadaDoble();
        vista.btnGuardar.addActionListener(this);
        vista.btnBuscar.addActionListener(this);
        vista.btnEliminar.addActionListener(this);
        vista.btnOrdenar.addActionListener(this);
        
        lista = PersistenciaDocente.Recuperar();
        ProcesosDocente.Presentacion(vista);
        ProcesosDocente.MostrarDocentes(vista, lista);
        
        vista.btnEliminar.setEnabled(false);//boton eliminar desactivado
        
    }
    private void ActualizarForma(){
        ProcesosDocente.LimpiarEntradas(vista);
        PersistenciaDocente.Guardar(lista);
        ProcesosDocente.MostrarDocentes(vista, lista);
        
        vista.btnEliminar.setEnabled(false);//boton eliminar desactivado
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //aca se usa LISTA DOBLE
       if(e.getSource()==vista.btnGuardar){
           Docente doc = ProcesosDocente.LeerDocente(vista);
           lista.InsertarAlFinal(doc);
           ActualizarForma();
       }
       if(e.getSource()==vista.btnBuscar){
         
         String codbuscado = Mensajes.LeerTexto("Ingrese el codigo a buscar...");
         encontrado = lista.BuscarPorCodigo(codbuscado);
         if(encontrado==null){
             Mensajes.Mostrar("Codigo "+codbuscado+" no existe en la lista");
         }else{
             vista.txtNombre.setText(encontrado.doc.getNombre());
             vista.txtApellido.setText(encontrado.doc.getApellido());
             
             vista.cbxCurso.setSelectedIndex(encontrado.doc.getCursoNumero());
             vista.txtCodigo.setText(encontrado.doc.getCodigo());

             vista.btnEliminar.setEnabled(true);//boton eliminar activado
}
       }
       if(e.getSource()== vista.btnEliminar){
           int resp = Mensajes.Confirmar("CONFIRMAR!!!","Desea eliminar el nodo?");
           if(resp==0){
               lista.EliminarNodo(encontrado);
               ActualizarForma();
               
           }
       }
       if(e.getSource()== vista.btnOrdenar){
          
          System.out.println("this got triggered");
          
          
          
          ListaEnlazadaDoble copia = lista;
          
          copia = Insercion.ListaDoblePorNombre(copia);
          
          ProcesosDocente.MostrarDocentes(vista,copia);
          
          
        }
    }   
    
    
}

