package Procesos;
import Estructura.ArbolBinario.NodoHorario;
import Vista.HorarioVista;
import javax.swing.table.DefaultTableModel;
public class ProcesosHorario {
    
    public static void MostrarDatosNodo(NodoHorario actual,HorarioVista f){
        f.txtHoraInicio.setText(actual.getElemento().getHoraInicio());
        f.cbxCurso.removeAllItems();
        f.cbxCurso.addItem(actual.getElemento().getCursoId());
        
        f.txtSalon.setText(actual.getElemento().getSalonId());
    }

    
   public static void LimpiarEntradas(HorarioVista f){
        f.txtHoraInicio.setText("");
        f.txtSalon.setText("");
        f.cbxCurso.setSelectedIndex(0);
   }
   
    public static void LimpiarTabla(DefaultTableModel modtabla){
       modtabla.setRowCount(0);
   }     

    public static int obtenerDiaNum(HorarioVista f){
        

        return f.cbxDia.getSelectedIndex();
    }
}
