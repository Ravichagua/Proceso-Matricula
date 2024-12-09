package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.MatriculaVista;
import Procesos.ProcesosMatricula;
import Estructura.Pila.Pila;
import Modelo.Matricula;
import Persistencia.PersistenciaMatricula;
import Procesos.Mensajes;
import java.util.Date;


public class ControladorMatricula implements ActionListener {
    MatriculaVista vista;
    Pila pila;

    
    public ControladorMatricula(MatriculaVista MV){
        vista=MV;
        vista.btnGuardar.addActionListener(this);
        vista.btnEliminar.addActionListener(this);
        vista.btnOrdenar.addActionListener(this);
        vista.btnBuscar.addActionListener(this);
        pila=PersistenciaMatricula.Recuperar();
        
        vista.txtFecha.setText(ProcesosMatricula.FechaActual());
        
        ProcesosMatricula.MostrarMatricula(vista,pila); 
        
       vista.setTitle("Registro de operarios usando pilas");
       

        
        
        vista.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vista.btnGuardar){
            System.out.println("awdaw");
            pila.Apilar(ProcesosMatricula.LeerDocente(vista));
            PersistenciaMatricula.Guardar(pila);
              
            ProcesosMatricula.LimpiarEntradas(vista);
            
            ProcesosMatricula.MostrarMatricula(vista,pila);  
            
        }
        if(e.getSource()==vista.btnBuscar){
            //int numeroPilra =pila.BuscarOperario(vista.txtDni.getText());
            System.out.println("awdaw");
            int numeroPila =pila.BuscarOperario(Mensajes.LeerTexto("Ingrese el numero de Dni"));
            
            Matricula arEncontrado=pila.ObtenerOpe(numeroPila);
            
            vista.txtDni.setText(arEncontrado.getDni());
            vista.txtNombre.setText(arEncontrado.getEstudianteNombres());
            vista.cbxGrado.setSelectedItem(arEncontrado.getGrado());
            vista.cbxEstado.setSelectedItem(arEncontrado.getEstado());
            
            
        }
        if(e.getSource()==vista.btnOrdenar){
            
            
            //Pila copiapila=pila;
            
//            Pila PilaOrdenada=Ordenamiento.Insercion.PilaPorInsercionFecha(Pila.copiarPila(pila.pila));
//            
//            ProcesosMatricula.MostrarMatricula(vista,PilaOrdenada);
//            
//            System.out.println("SE HA ORDENADO");
        }

    }
}