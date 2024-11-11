
package Procesos;

import javax.swing.JOptionPane;

public class Mensajes {
    public static void Mostrar(String msj){
        JOptionPane.showMessageDialog(null,msj);
    }
    public static String LeerTexto(String msj){
        return JOptionPane.showInputDialog(msj);
    }
    public static int Confirmar(String titulo,String msj){
        return JOptionPane.showConfirmDialog(null,
                msj, 
                titulo,
                JOptionPane.YES_NO_OPTION);
    }
}
