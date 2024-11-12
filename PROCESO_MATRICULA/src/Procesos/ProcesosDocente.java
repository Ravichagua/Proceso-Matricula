package Procesos;

import Modelo.Docente;
import javax.swing.table.DefaultTableModel;

import Vista.DocenteVista;
import Estructura.ListaDoble.*;
import Modelo.Docente;

public class ProcesosDocente {
    
    public static void MostrarDocentes(DocenteVista dv,ListaEnlazadaDoble lista){
       String titulos[]={"Num","Nombre","Apellido","Asignatura","Codigo"};
       DefaultTableModel mt  = new DefaultTableModel(null,titulos);
       dv.tblDatos.setModel(mt);
       NodoDoble aux=lista.ini;
       int num=0;
       while(aux!=null){
           num++;
           mt.addRow(aux.doc.Registro(num));
           aux=aux.sig;
       }
       
    }
    
    public static Docente LeerDocente(DocenteVista dv){
        Docente doc =  new Docente();
        
        doc.setNombre(dv.txtNombre.getText());
        doc.setApellido(dv.txtApellido.getText());
        doc.setAsignatura(dv.txtAsignatura.getText());
        doc.setCodigo(dv.txtCodigo.getText());

        
        return doc;
    } 
    public static void LimpiarEntradas(DocenteVista dv){
        dv.txtCodigo.setText("");
        dv.txtNombre.setText("");
        dv.txtApellido.setText("");
        dv.txtAsignatura.setText("");
        
    }
    
    public static void Presentacion(DocenteVista dv){
       dv.setTitle("Registro de Docentes");
       dv.setVisible(true);

    }
}
