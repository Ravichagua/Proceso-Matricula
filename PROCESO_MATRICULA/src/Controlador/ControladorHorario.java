package Controlador;
//librerias
//import Estructura.*;
import Estructura.ArbolBinario.ArbolHora;
import Estructura.ArbolBinario.NodoHora;
import java.awt.event.*;
import Vista.HorarioVista;
import Modelo.*;
import Procesos.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import Persistencia.*;
public class ControladorHorario implements ActionListener {
     HorarioVista vista;
     ArbolHora arbol;
     DefaultTableModel modTabla;
     
     public ControladorHorario(HorarioVista HV){
         vista=HV;
         vista.btnGuardar.addActionListener(this);

         vista.btnBuscar.addActionListener(this);
         //vista.btnEliminar.addActionListener(this);
        
         vista.setLocationRelativeTo(null);
         vista.setVisible(true);
         

         arbol = new ArbolHora();
         arbol = PersistenciaHorario.RecuperarDeArchivo();
         modTabla = (DefaultTableModel)vista.tblDatos.getModel();
         arbol.MostrarEnOrden(arbol.getRaiz(), modTabla);
        
     }
     
     @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== vista.btnGuardar){
            Object[] Registro={vista.txtHoraInicio.getText(),
                               vista.txtCurso.getText(),
                               vista.txtSalon.getText()};
            Horario elem =  new Horario(Registro);
            
            arbol.setRaiz(arbol.AgregarHorario(arbol.getRaiz(),elem));
            PersistenciaHorario.GuardarEnArchivo(arbol);
            ProcesosHorario.LimpiarTabla(modTabla);
            arbol.MostrarEnOrden(arbol.getRaiz(), modTabla);
            ProcesosHorario.LimpiarEntradas(vista);

        }


            
        if(e.getSource() == vista.btnBuscar){
            String dato = JOptionPane.showInputDialog(
                                     "Ingrese la hora de la clase a buscar :  ");
            NodoHora encontrado = arbol.BuscarPorHora(dato);
            if(encontrado==null)
                JOptionPane.showMessageDialog(null,
                        dato+" no existe en el arbol..");
            else ProcesosHorario.MostrarDatosNodo(encontrado, vista);
        }
    }//fin del action
}//fin de la clase
