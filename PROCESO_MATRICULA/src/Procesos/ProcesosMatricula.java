package Procesos;
import Vista.MatriculaVista;
import Estructura.Pila.Pila;
import javax.swing.table.DefaultTableModel;
import Modelo.Matricula;
import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ProcesosMatricula {
    
    
    //this is going to be deleted
    public static void MostrarMatricula(MatriculaVista fd,Pila pila){
       String titulos[]={"Dni","Nombres","Grado","Estado","Fecha"};
       DefaultTableModel mt  = new DefaultTableModel(null,titulos);
       fd.tblDatos.setModel(mt);
       
       for(int i=0;i<pila.Cantidad();i++){
           mt.addRow(pila.ObtenerOpe(i).getRegistro());
           System.out.println(i);
       }
    }
    
    public static Matricula LeerDocente(MatriculaVista fd){
        
        
        Matricula ar =  new Matricula();
        ar.setDni(fd.txtDni.getText());
        ar.setEstudianteNombres(fd.txtNombre.getText());
        ar.setGrado(fd.cbxGrado.getSelectedItem().toString());
        ar.setEstado(fd.cbxEstado.getSelectedItem().toString());
        ar.setFechaMatricula(StringToDate(fd.txtFecha.getText()));

        return ar;
    }//fin leer
    
    public static void LimpiarEntradas(MatriculaVista fd){
        fd.txtDni.setText("");
        fd.txtNombre.setText("");
        fd.cbxGrado.setSelectedIndex(0);
        fd.cbxEstado.setSelectedIndex(0);
        fd.txtFecha.setText(FechaActual());
        
    }
    public static Date StringToDate(String CadenaFecha){
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date Default=new Date();
        try {
             //Convertir el String a Date
            Date date = formatter.parse(CadenaFecha) ;
            
            System.out.println("Fecha convertida: " + date);
            return date;
        } catch (ParseException e) {
            // Manejar el error si el formato no coincide
            Procesos.Mensajes.Mostrar("Ingrese una fecha correcta");
            throw new RuntimeException("Error al parsear la fecha: " + CadenaFecha, e);
        }
        //return Default;
    }
    public static String DateToString(Date DateFecha){
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

        // Formatear la fecha como String
        String FechaString = formatter.format(DateFecha);
        return FechaString;
    }
    public static String FechaActual(){
        
        Date FechaActual=new Date();
        String FechaActualString=ProcesosMatricula.DateToString(FechaActual);
        
        return FechaActualString;
    }
}






//fin limpiar    

//       Nodo aux=lista.ini;
//       
//       
//       int num=0;
//       while(aux!=null){
//           num++;
//           mt.addRow(aux.doc.Registro(num));
//           aux=aux.sig;
//       }//fin while
