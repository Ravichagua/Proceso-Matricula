package Controlador;

import Estructura.ArrayListCredenciales;
import Procesos.Mensajes;
import Vista.LoginVista;
import Vista.MenuPrincipalVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControladorLogin implements ActionListener {
    LoginVista vista;
    ArrayListCredenciales instanciaArrayLCredenciales;
    
    public ControladorLogin(LoginVista LV,ArrayListCredenciales instanciaArrayLCredenciales){
        this.vista=LV;
        this.instanciaArrayLCredenciales=instanciaArrayLCredenciales;
        this.vista.setVisible(true);
        
        vista.setLocationRelativeTo(null);
        vista.btnIngresar.addActionListener(this);
        vista.btnSalir.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==vista.btnIngresar){
            
            //obtener texto ingresado
            String usuarioIngresado =vista.txtUsuario.getText();
            String ContrasenaIngresado =vista.txtContrasena.getText();
            //autentifica
            if(instanciaArrayLCredenciales.Autentificar(usuarioIngresado,ContrasenaIngresado)==true){
                MenuPrincipalVista MenuInstancia=new MenuPrincipalVista();
                MenuInstancia.setVisible(true);
                vista.dispose();
            }else{
                
                vista.txtUsuario.setText("");
                vista.txtContrasena.setText("");
                Mensajes.Mostrar("Usuario y contrasena incorrectos");
            }
                
       }
        if(e.getSource()==vista.btnSalir){
            vista.dispose();
       }
    }
    
}
