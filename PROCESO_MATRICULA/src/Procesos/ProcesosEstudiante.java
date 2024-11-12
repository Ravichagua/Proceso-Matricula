package Procesos;

import Estructura.ListaEnlazada.ListaEnlazada;
import Estructura.ListaEnlazada.Nodo;
import Modelo.Estudiante;
import javax.swing.table.DefaultTableModel;
import Vista.EstudianteVista;
import Estructura.ListaEstudiantes;

public class ProcesosEstudiante {
    public static void Presentacion(EstudianteVista fe){
       fe.setTitle("Registro de estudiantes...");
       fe.setVisible(true);
       fe.cbxGrado.removeAllItems();
       fe.cbxGrado.addItem("INICIAL");
       fe.cbxGrado.addItem("PRIMARIA");
       fe.cbxGrado.addItem("SECUNDARIA");
       
       /*fe.cbxDiscapacidad.removeAllItems();
       fe.cbxDiscapacidad.addItem("SI");
       fe.cbxDiscapacidad.addItem("NO");*/
   }
   
   public static void LimpiarEntradas(EstudianteVista EV){
       
       EV.txtNombre.setText("");
       EV.spnEdad.setValue(10);
       EV.txtApellido.setText("");
       EV.cbxGrado.setSelectedIndex(0);
       EV.txtDni.setText("");;
   }//fin leer
   
   public static void MostrarEst(EstudianteVista EV,ListaEnlazada lista){
       String titulos[]={"dni","nombre","apellido","edad","grado"}; 
       DefaultTableModel mt = new DefaultTableModel(null,titulos);
       EV.tblDatos.setModel(mt);
//       for(int i=0;i<lista.Cantidad();i++){
//           mt.addRow(lista.Recuperar(i).Registro());
//       }
       Nodo aux=lista.ini;
       int num=0;
       while(aux!=null){
           num++;
           mt.addRow(aux.est.Registro());
           aux=aux.sig;
       }
       
       
       
       EV.btnEliminar.setEnabled(false);
   }//fin mostrarest    mt.addRow(lista.Recuperar(i).Registro(i+1));
   
   public static Estudiante LeerEstudiante(EstudianteVista EV){
       Estudiante e =  new Estudiante();
       e.setNombre(EV.txtNombre.getText());
       e.setApellido(EV.txtApellido.getText());
       e.setGrado((String)EV.cbxGrado.getSelectedItem());
       e.setEdad(Integer.parseInt(EV.spnEdad.getValue().toString()));
       e.setDni(EV.txtDni.getText());
       /*
       e.setDni(EV.txtDni.getText());
       e.setNom(EV.txtNombres.getText());
       e.setNivel(EV.cbxNivel.getSelectedItem().toString());
       e.setEdad(Integer.parseInt(EV.txtEdad.getText()));
       e.setDisc(EV.cbxDiscapacidad.getSelectedItem().toString());
       e.ActualizarPension();*/
       return e;
   }
}
