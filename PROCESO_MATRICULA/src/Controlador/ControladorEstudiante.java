package Controlador;

import Modelo.Estudiante;
import Estructura.ListaEstudiantes;
import Procesos.Mensajes;
import Vista.EstudianteVista;
import Procesos.ProcesosEstudiante;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Persistencia.PersistenciaEstudiante;
import Estructura.ListaEnlazada.ListaEnlazada;
import Estructura.ListaEnlazada.Nodo;
import Ordenamientos.OrdenarListasEnlazadas;

public class ControladorEstudiante implements ActionListener{
    EstudianteVista vista;
    Estudiante est;
    ListaEnlazada Lista;
    
    //int pos;
    Nodo pos;
    public ControladorEstudiante(EstudianteVista EV){
        vista=EV;
        // !!!!!!!!!!!!!!!!!!!!!!!!!!!falta boton actualizar!!!!!!!!!!!!!!!!!!!!!!
        
        vista.btnGuardar.addActionListener(this);
        vista.btnBuscar.addActionListener(this);
        vista.btnOrdenar.addActionListener(this);
        vista.btnEliminar.addActionListener(this);
        
        ProcesosEstudiante.Presentacion(vista);        
        Lista =  new ListaEnlazada();
        Lista = PersistenciaEstudiante.RecuperarEstudiantes();
        ProcesosEstudiante.MostrarEst(vista, Lista);

        vista.btnEliminar.setEnabled(false);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == vista.btnGuardar){
           est = ProcesosEstudiante.LeerEstudiante(vista);
           //Lista.Agregar(est);
           Lista.AgregarAlInicio(est);
           PersistenciaEstudiante.GuardarEstudiante(Lista);
           ProcesosEstudiante.LimpiarEntradas(vista);
           ProcesosEstudiante.MostrarEst(vista, Lista); 
       }
       if(e.getSource() == vista.btnBuscar){
           String dnibus = Mensajes.LeerTexto("Ingrese dni a buscar");
           pos = Lista.BuscarPorDni(dnibus);
           if(pos==null){
               Mensajes.Mostrar("DNI "+dnibus+" no existe en la lista..");
           }else{
               //est = Lista.Recuperar(pos);
               est=pos.est;
               
               vista.txtDni.setText(est.getDni());
               vista.txtNombre.setText(est.getNombre());
               vista.spnEdad.setValue(est.getEdad());
               vista.txtApellido.setText(est.getApellido());
               switch(est.getGrado()){
                   case "INICIAL": vista.cbxGrado.setSelectedIndex(0); break;
                   case "PRIMARIA": vista.cbxGrado.setSelectedIndex(1); break;
                   case "SECUNDARIA": vista.cbxGrado.setSelectedIndex(2); break;
               }
               /*switch(est.getDisc()){
                   case "SI": vista.cbxDiscapacidad.setSelectedIndex(0); break;
                   case "NO": vista.cbxDiscapacidad.setSelectedIndex(1); break;
               }*/
               vista.btnEliminar.setEnabled(true);
           }
       }//fin consultar
//       if(e.getSource() == vista.btnActualizar){
//           est =  ProcesosEstudiante.LeerEstudiante(vista);
//           Lista.Reemplazar(pos, est);
//           AlmacenarEstudiante.GuardarEstudiante(Lista);
//           ProcesosEstudiante.LimpiarEntradas(vista);
//           ProcesosEstudiante.MostrarEst(vista, Lista); 
//       }//fin actualizar
       if(e.getSource()== vista.btnEliminar){
           int respuesta = Mensajes.Confirmar("Confirmar!!!",
                                          "Desea eliminar el registro?");
           if(respuesta==0){
               Lista.EliminarEstudiante(pos);
               PersistenciaEstudiante.GuardarEstudiante(Lista);
               ProcesosEstudiante.LimpiarEntradas(vista);
               ProcesosEstudiante.MostrarEst(vista, Lista); 
           }
       }//fin eliminar       
//       if(e.getSource()== vista.btnOrdenar){
//          
//          System.out.println("this got triggered");
//          
//          ListaEstudiantes copia = Lista;
//          copia = OrdenarListasEnlazadas.PorNombre(copia);
//          ProcesosEstudiante.MostrarEst(vista,copia);
          
          
       }//fin ordenar
    }//fin action   
    

