package Estructura;

import Modelo.LoginCredenciales;
import java.io.Serializable;

public class ArregloObjeto implements Serializable {
 
    int numeroDeObjetos=30;
    Object[] arregloObjetos = new Object[numeroDeObjetos];
    

    public void annadirObejetos(String usuario,String contrasena){
        
        for(int i=0;i<numeroDeObjetos;i++){
            if(arregloObjetos[i]==null){
                arregloObjetos[i] =new LoginCredenciales(usuario,contrasena);

                LoginCredenciales miObjeto =(LoginCredenciales)arregloObjetos[i];

                System.out.println(miObjeto.getUsuario());
                System.out.println(miObjeto.getContrasena());
                
                break;
            }
        }

    }  
    public boolean AutentificarObjeto(String usuarioIngresado,String contrasenaIngresada){
        int a=0;
        System.out.println("START");
        while(arregloObjetos[a]!=null && a<numeroDeObjetos){
            System.out.println(a);
            LoginCredenciales miObjeto =(LoginCredenciales)arregloObjetos[a];
            
            String usuarioActual=miObjeto.getUsuario();
            String contrasenaActual=miObjeto.getContrasena();
            
            System.out.println("TESTING");
            if(usuarioActual.equals(usuarioIngresado) && contrasenaActual.equals(contrasenaIngresada)){
                System.out.println("FOUND!");
                return true;
            }
            
            a++;
        }
        
        return false;
    }

}
