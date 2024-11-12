package Persistencia;

import Estructura.ListaEnlazada.ListaEnlazada;

import Procesos.Mensajes;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class PersistenciaEstudiante {
    public static String ARCHIVO1="DatosEstudiantes.bin";
    
    public static void GuardarEstudiante(ListaEnlazada Lista){
       try{
           FileOutputStream fos=new FileOutputStream(ARCHIVO1);
           ObjectOutputStream oos =  new ObjectOutputStream(fos);
           oos.writeObject(Lista);
           oos.close();
       }catch(Exception ex){
           Mensajes.LeerTexto("ERROR no se puede guardar "+ex);
       }       
    }// fin guardar
    
    public static ListaEnlazada RecuperarEstudiantes(){
        ListaEnlazada Lista=new ListaEnlazada();
       try{
           FileInputStream fis =  new FileInputStream(ARCHIVO1);
           ObjectInputStream ois = new ObjectInputStream(fis);
           Lista = (ListaEnlazada)ois.readObject();
           ois.close();
       }catch(Exception ex){
           Mensajes.Mostrar("ERROR no se puede recuperar..."+ex);
       }
       return Lista;
    }  
}
