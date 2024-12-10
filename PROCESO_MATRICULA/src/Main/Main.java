package Main;

import Vista.*;
import Controlador.ControladorLogin;
import Estructura.ArregloObjeto;

public class Main {

    public static void main(String[] args) {
        //ArrayListCredenciales listaNueva=new ArrayListCredenciales();//nueva lista para credenciales
        
//        listaNueva.annadirCredenciales("admin","admin");
//        listaNueva.annadirCredenciales("123","123");
//        listaNueva.annadirCredenciales("1","1");
        
        LoginVista instanciaVista=new LoginVista();
        

        ControladorLogin ctrlStart=new ControladorLogin(instanciaVista);
        
    }
    
}
