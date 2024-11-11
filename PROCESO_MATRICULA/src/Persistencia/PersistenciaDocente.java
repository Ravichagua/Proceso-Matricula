package Persistencia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Estructura.ListaDoble.*;

import Procesos.Mensajes;

public class PersistenciaDocente {
     public static String ARCHIVO3="DatosListaDobleDocente.bin";
     
    public static void Guardar(ListaDoble Lista){
       try{
           FileOutputStream fos=new FileOutputStream(ARCHIVO3);
           ObjectOutputStream oos =  new ObjectOutputStream(fos);
           oos.writeObject(Lista);
           oos.close();
       }catch(Exception ex){
           Mensajes.LeerTexto("ERROR no se puede guardar "+ex);
       }       
    }// fin guardar
    
    public static ListaDoble Recuperar(){
        ListaDoble Lista=new ListaDoble();
       try{
           FileInputStream fis =  new FileInputStream(ARCHIVO3);
           ObjectInputStream ois = new ObjectInputStream(fis);
           Lista = (ListaDoble)ois.readObject();
           ois.close();
       }catch(Exception ex){
           Mensajes.Mostrar("ERROR no se puede recuperar..."+ex);
       }
       return Lista;
    }//fin recuperar   
}
