package Controlador;

import Modelo.Estudiante;

import Procesos.Mensajes;
import Vista.EstudianteVista;
import Procesos.ProcesosEstudiante;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Persistencia.PersistenciaEstudiante;
import Estructura.ListaEnlazada.ListaEnlazada;
import Estructura.ListaEnlazada.NodoEnlazado;
import Ordenamientos.OrdenarListasEnlazadas;

public class ControladorEstudiante implements ActionListener{
    EstudianteVista vista;
    Estudiante est;
    ListaEnlazada Lista;
    

    NodoEnlazado pos;
    public ControladorEstudiante(EstudianteVista EV){
        vista=EV;
        
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

               Estudiante estu=pos.est;
               
               vista.txtDni.setText(estu.getDni());
               vista.txtNombre.setText(estu.getNombre());
               vista.spnEdad.setValue(estu.getEdad());
               vista.txtApellido.setText(estu.getApellido());
               switch(estu.getGrado()){
                   case "INICIAL": vista.cbxGrado.setSelectedIndex(0); break;
                   case "PRIMARIA": vista.cbxGrado.setSelectedIndex(1); break;
                   case "SECUNDARIA": vista.cbxGrado.setSelectedIndex(2); break;
               }

               vista.btnEliminar.setEnabled(true);
           }
       }
       if(e.getSource()== vista.btnEliminar){
           int respuesta = Mensajes.Confirmar("Confirmar!!!",
                                          "Desea eliminar el registro?");
           if(respuesta==0){
               Lista.EliminarEstudiante(pos);
               PersistenciaEstudiante.GuardarEstudiante(Lista);
               ProcesosEstudiante.LimpiarEntradas(vista);
               ProcesosEstudiante.MostrarEst(vista, Lista); 
           }
       }     
       if(e.getSource()== vista.btnOrdenar){
           
            ListaEnlazada copia =Lista;
            OrdenarListasEnlazadas.PorEdad(copia);
            ProcesosEstudiante.MostrarEst(vista,copia);
          
       }
    }
}
    

