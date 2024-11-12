package Estructura;

import Modelo.LoginCredenciales;
import java.util.ArrayList;


public class ArrayListCredenciales {

    ArrayList<LoginCredenciales> listaCredenciales=new ArrayList<LoginCredenciales>();
    

    public boolean Autentificar(String usuario,String contrasena){
        for(LoginCredenciales elemento:listaCredenciales){
            if(elemento.getUsuario().equals(usuario) &&elemento.getContrasena().equals(contrasena))
                return true;
        }
        return false;
    }
    
    public void annadirCredenciales(String usuario,String contrasena){
        listaCredenciales.add(new LoginCredenciales(usuario,contrasena) );
    }        
    
    
}
