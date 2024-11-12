package Persistencia;
import java.io.*;
import javax.swing.JOptionPane;

import Estructura.ArbolBinario.ArbolHora;
public class PersistenciaHorario {
    public static void GuardarEnArchivo(ArbolHora arbol){
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
    public static ArbolHora RecuperarDeArchivo(){
      ArbolHora arbol = new ArbolHora();  
        try{
           FileInputStream fis = new FileInputStream("ArchivoArbol.bin");
           ObjectInputStream ois = new ObjectInputStream(fis);
           arbol = (ArbolHora)ois.readObject();
           ois.close();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,
               "ERROR no se puede recuperar de archivo"+ex);
        }
        return arbol;
    }
}
