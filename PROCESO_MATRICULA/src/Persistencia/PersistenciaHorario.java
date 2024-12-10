package Persistencia;
import java.io.*;
import javax.swing.JOptionPane;

import Estructura.ArbolBinario.ArbolHorario;
public class PersistenciaHorario {
    public static void GuardarHorario(ArbolHorario arbol,int numero){
        
        String numeroString=String.valueOf(numero);
        
        try{
           FileOutputStream fos = new FileOutputStream("arbolDias\\ArchivoArbol"+numeroString+".bin");
           ObjectOutputStream oos = new ObjectOutputStream(fos);
           oos.writeObject(arbol);
           oos.close();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,
               "ERROR no se puede guardar en archivo "+ex);
        }
    }
    public static ArbolHorario RecuperarHorario(int numero){
      ArbolHorario arbol = new ArbolHorario();  
      
      String numeroString=String.valueOf(numero);
      
        try{
           FileInputStream fis = new FileInputStream("arbolDias\\ArchivoArbol"+numeroString+".bin");
           ObjectInputStream ois = new ObjectInputStream(fis);
           arbol = (ArbolHorario)ois.readObject();
           ois.close();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"ERROR no se puede recuperar de archivo"+ex);
        }
        return arbol;
    }
    
    
    
}
