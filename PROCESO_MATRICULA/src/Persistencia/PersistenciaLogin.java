package Persistencia;

import Estructura.ArregloObjeto;
import Procesos.Mensajes;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class PersistenciaLogin {
    public static String ARCHIVO1="DatosLogin.bin";
    
    public static void GuardarLogin(ArregloObjeto Lista){
       try{
           FileOutputStream fos=new FileOutputStream(ARCHIVO1);
           ObjectOutputStream oos =  new ObjectOutputStream(fos);
           oos.writeObject(Lista);
           oos.close();
       }catch(Exception ex){
           Mensajes.LeerTexto("ERROR no se puede guardar "+ex);
       }       
    }
    
    public static ArregloObjeto RecuperarLogin(){
        ArregloObjeto Lista=new ArregloObjeto();
       try{
           FileInputStream fis =  new FileInputStream(ARCHIVO1);
           ObjectInputStream ois = new ObjectInputStream(fis);
           Lista = (ArregloObjeto)ois.readObject();
           ois.close();
       }catch(Exception ex){
           Mensajes.Mostrar("ERROR no se puede recuperar..."+ex);
       }
       return Lista;
    }  
}
