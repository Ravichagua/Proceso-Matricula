package Persistencia;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Estructura.Pila.Pila;

import Procesos.Mensajes;

public class PersistenciaMatricula {
    public static String ARCHIVO3="DatosPilaMatricula.bin";
     
    public static void Guardar(Pila pila){
       try{
           FileOutputStream fos=new FileOutputStream(ARCHIVO3);
           ObjectOutputStream oos =  new ObjectOutputStream(fos);
           oos.writeObject(pila);
           oos.close();
       }catch(Exception ex){
           Mensajes.LeerTexto("ERROR no se puede guardar "+ex);
       }       
    }
    
    public static Pila Recuperar(){
        Pila Lista=new Pila();
       try{
           FileInputStream fis =  new FileInputStream(ARCHIVO3);
           ObjectInputStream ois = new ObjectInputStream(fis);
           Lista = (Pila)ois.readObject();
           ois.close();
       }catch(Exception ex){
           Mensajes.Mostrar("ERROR no se puede recuperar..."+ex);
       }
       return Lista;
    } 
}
