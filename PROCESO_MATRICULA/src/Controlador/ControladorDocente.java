package Controlador;

import java.awt.event.ActionListener;
import Vista.DocenteVista;
import java.awt.event.ActionEvent;
import Modelo.Docente;

import Procesos.*;
import Persistencia.PersistenciaDocente;
import Estructura.ListaDoble.*;
import Ordenamientos.*;
public class ControladorDocente  implements ActionListener {
    DocenteVista vista;
    ListaDoble lista;
    
    Nodo encontrado;
    
    public ControladorDocente(DocenteVista fd){
        vista=fd;
        lista = new ListaDoble();
        vista.btnGuardar.addActionListener(this);
        vista.btnBuscar.addActionListener(this);
        vista.btnEliminar.addActionListener(this);
        vista.btnOrdenar.addActionListener(this);
        
        lista = PersistenciaDocente.Recuperar();
        ProcesosDocente.Presentacion(vista);
        ProcesosDocente.MostrarDocentes(vista, lista);
        
        vista.btnEliminar.setEnabled(false);//boton eliminar desactivado
        
    }//fin constructor
    private void ActualizarForma(){
        ProcesosDocente.LimpiarEntradas(vista);
        PersistenciaDocente.Guardar(lista);
        ProcesosDocente.MostrarDocentes(vista, lista);
        
        vista.btnEliminar.setEnabled(false);//boton eliminar desactivado
    }//fin actualizar
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
       if(e.getSource()==vista.btnGuardar){
           Docente doc = ProcesosDocente.LeerDocente(vista);
           lista.InsertarAlFinal(doc);
           ActualizarForma();
       }//fin registrar
       if(e.getSource()==vista.btnBuscar){
         
         String codbuscado = Mensajes.LeerTexto("Ingrese el codigo a buscar...");
         encontrado = lista.BuscarPorCodigo(codbuscado);
         if(encontrado==null){
             Mensajes.Mostrar("Codigo "+codbuscado+" no existe en la lista");
         }else{
             vista.txtNombre.setText(encontrado.doc.getNombre());
             vista.txtApellido.setText(encontrado.doc.getApellido());
             
             vista.txtAsignatura.setText(encontrado.doc.getAsignatura());
             vista.txtCodigo.setText(encontrado.doc.getCodigo());

             vista.btnEliminar.setEnabled(true);//boton eliminar activado
}
       }//fin consultar
       if(e.getSource()== vista.btnEliminar){
           int resp = Mensajes.Confirmar("CONFIRMAR!!!","Desea eliminar el nodo?");
           if(resp==0){
               lista.EliminarNodo(encontrado);
               ActualizarForma();
               
           }
       }//fin eliminar
       if(e.getSource()== vista.btnOrdenar){
          
          System.out.println("this got triggered");
          
          ListaDoble copia = lista;
          copia = OrdenarListasDobles.PorNombre(copia);
          ProcesosDocente.MostrarDocentes(vista,copia);
          
          
       }//fin ordenar
    }//fin del action    
    
    
}//fin de la clase

