package Controlador;

import Modelo.Estudiante;
import Estructura.ListaEstudiantes;
import Procesos.Mensajes;
import Vista.EstudianteVista;
import Procesos.ProcesosEstudiante;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Persistencia.PersistenciaEstudiante;

public class ControladorEstudiante implements ActionListener{
    EstudianteVista vista;
    Estudiante est;
    ListaEstudiantes Lista;
    
    int pos;
    public ControladorEstudiante(EstudianteVista EV){
        vista=EV;
        // !!!!!!!!!!!!!!!!!!!!!!!!!!!falta boton actualizar!!!!!!!!!!!!!!!!!!!!!!
        
        vista.btnGuardar.addActionListener(this);
        vista.btnBuscar.addActionListener(this);
        vista.btnOrdenar.addActionListener(this);
        vista.btnEliminar.addActionListener(this);
        
        ProcesosEstudiante.Presentacion(vista);        
        Lista =  new ListaEstudiantes();
        Lista = PersistenciaEstudiante.RecuperarEstudiantes();
        ProcesosEstudiante.MostrarEst(vista, Lista);

        vista.btnEliminar.setEnabled(false);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == vista.btnGuardar){
           est = ProcesosEstudiante.LeerEstudiante(vista);
           Lista.Agregar(est);
           PersistenciaEstudiante.GuardarEstudiante(Lista);
           ProcesosEstudiante.LimpiarEntradas(vista);
           ProcesosEstudiante.MostrarEst(vista, Lista); 
       }
       if(e.getSource() == vista.btnBuscar){
           String dnibus = Mensajes.LeerTexto("Ingrese dni a buscar");
           pos = Lista.Buscar(dnibus);
           if(pos==-1){
               Mensajes.Mostrar("DNI "+dnibus+" no existe en la lista..");
           }else{
               est = Lista.Recuperar(pos);
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
               Lista.Eliminar(pos);
               PersistenciaEstudiante.GuardarEstudiante(Lista);
               ProcesosEstudiante.LimpiarEntradas(vista);
               ProcesosEstudiante.MostrarEst(vista, Lista); 
           }
       }//fin eliminar       
    }//fin action   
    
}
