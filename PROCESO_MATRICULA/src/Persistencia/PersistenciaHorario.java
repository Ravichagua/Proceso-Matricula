package Persistencia;
import java.io.*;
import javax.swing.JOptionPane;

import Estructura.ArbolBinario.ArbolHorario;
public class PersistenciaHorario {
    public static void GuardarEnArchivo(ArbolHorario arbol){
        try{
           FileOutputStream fos = new FileOutputStream("ArchivoArbol.bin");
           ObjectOutputStream oos = new ObjectOutputStream(fos);
           oos.writeObject(arbol);
           oos.close();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,
               "ERROR no se puede guardar en archivo "+ex);
        }
    }
    public static ArbolHorario RecuperarDeArchivo(){
      ArbolHorario arbol = new ArbolHorario();  
        try{
           FileInputStream fis = new FileInputStream("ArchivoArbol.bin");
           ObjectInputStream ois = new ObjectInputStream(fis);
           arbol = (ArbolHorario)ois.readObject();
           ois.close();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,
               "ERROR no se puede recuperar de archivo"+ex);
        }
        return arbol;
    }
}
