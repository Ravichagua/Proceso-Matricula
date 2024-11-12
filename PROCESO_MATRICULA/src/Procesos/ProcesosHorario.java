package Procesos;
import Estructura.ArbolBinario.NodoHora;
import Vista.HorarioVista;
import javax.swing.table.DefaultTableModel;
public class ProcesosHorario {
    
    public static void MostrarDatosNodo(NodoHora actual,HorarioVista f){
      f.txtHoraInicio.setText(actual.getElemento().getHoraInicio());
      f.txtCurso.setText(actual.getElemento().getCursoId());
      f.txtSalon.setText(actual.getElemento().getSalonId());
    }

    
   public static void LimpiarEntradas(HorarioVista f){
       f.txtHoraInicio.setText("");
       f.txtCurso.setText("");
       f.txtSalon.setText("");

   }
   
    public static void LimpiarTabla(DefaultTableModel modtabla){
       modtabla.setRowCount(0);
   }     
   
   
   
}
