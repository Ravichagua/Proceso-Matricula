package Controlador;

import Estructura.ArregloObjeto;
import Persistencia.PersistenciaLogin;
import Procesos.Mensajes;
import Vista.LoginVista;
import Vista.MenuPrincipalVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControladorLogin implements ActionListener {
    LoginVista vista;
    
    //ArrayListCredenciales instanciaArrayLCredenciales;
    
    public ControladorLogin(LoginVista LV){
        this.vista=LV;
        this.vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        vista.btnIngresar.addActionListener(this);
        vista.btnSalir.addActionListener(this);
        
        vista.instanciaListaObjetos=PersistenciaLogin.RecuperarLogin();
        
        //instanciaArrayLCredenciales=PersistenciaLogin.RecuperarLogin();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==vista.btnIngresar){
            
            //obtener texto ingresado
            String usuarioIngresado =vista.txtUsuario.getText();
            String ContrasenaIngresado =vista.txtContrasena.getText();
            //autentifica
            //vista.instanciaListaObjetos se cambio de instanciaArrayLCredenciales
            if(vista.instanciaListaObjetos.AutentificarObjeto(usuarioIngresado,ContrasenaIngresado)==true){
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
