package Controlador;

import Estructura.ArbolBinario.ArbolHorario;
import Estructura.ArbolBinario.NodoHorario;
import Estructura.ArrayList.ArrayListDatos;
import java.awt.event.*;
import Vista.HorarioVista;
import Modelo.*;
import Procesos.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import Persistencia.*;
public class ControladorHorario implements ActionListener {
    DefaultTableModel modTabla;
    HorarioVista vista;
    ArbolHorario arbol;
     

     
    int diaNumero;

    ArrayListDatos profesoresActuales= new ArrayListDatos();
    
    
    public ControladorHorario(HorarioVista HV){
       vista=HV;
       vista.btnGuardar.addActionListener(this);
       vista.btnBuscar.addActionListener(this);
       vista.cbxCurso.addActionListener(this);
       vista.cbxDia.addActionListener(this);
       
       vista.setVisible(true);

       //***************************************************
       diaNumero=ProcesosHorario.obtenerDiaNum(vista);
       System.out.println(diaNumero);
       

       //***************************************************

       arbol = new ArbolHorario();
       arbol = PersistenciaHorario.RecuperarDeArchivo(diaNumero);
       modTabla = (DefaultTableModel)vista.tblDatos.getModel();
       arbol.MostrarEnOrden(arbol.getRaiz(), modTabla);

       //**************************************************************
        
        profesoresActuales.ExtraerListaProfesores();
        profesoresActuales.CargarListaProfesores(vista);

    }
     
     @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== vista.btnGuardar){
            
            Object[] Registro={vista.txtHoraInicio.getText(),
                               vista.cbxCurso.getSelectedItem().toString(),
                               vista.cbxProfesor.getSelectedItem().toString(),
                               vista.txtSalon.getText()};
            
            Horario elem =  new Horario(Registro);
            
            arbol.setRaiz(arbol.AgregarHorario(arbol.getRaiz(),elem));
            PersistenciaHorario.GuardarEnArchivo(arbol,diaNumero);
            ProcesosHorario.LimpiarTabla(modTabla);
            arbol.MostrarEnOrden(arbol.getRaiz(), modTabla);
            ProcesosHorario.LimpiarEntradas(vista);

        }


            
        if(e.getSource() == vista.btnBuscar){
            String dato = JOptionPane.showInputDialog(
                                     "Ingrese la hora de la clase a buscar :  ");
            NodoHorario encontrado = arbol.BuscarPorHora(dato);
            if(encontrado==null)
                JOptionPane.showMessageDialog(null,
                        dato+" no existe en el arbol..");
            else ProcesosHorario.MostrarDatosNodo(encontrado, vista);
        }
        if(e.getSource() == vista.cbxDia){
            diaNumero=ProcesosHorario.obtenerDiaNum(vista);
            System.out.println(diaNumero);
            
            arbol = PersistenciaHorario.RecuperarDeArchivo(diaNumero);
            
            ProcesosHorario.LimpiarTabla(modTabla);
            arbol.MostrarEnOrden(arbol.getRaiz(), modTabla);
            ProcesosHorario.LimpiarEntradas(vista);
        }
        if(e.getSource() == vista.cbxCurso){
            profesoresActuales.CargarListaProfesores(vista);
        }
    }
}
