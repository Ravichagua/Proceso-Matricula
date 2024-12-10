package Modelo;

import java.io.Serializable;


public class LoginCredenciales implements Serializable  {
    private String usuario;
    private String contrasena;
    
    public LoginCredenciales(String usuario,String contrasena){
        this.usuario=usuario;
        this.contrasena=contrasena;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasena() {
        return contrasena;
    }
    
    
    
}
