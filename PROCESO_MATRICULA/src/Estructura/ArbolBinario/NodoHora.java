package Estructura.ArbolBinario;
import Modelo.Estudiante;
import java.io.Serializable;
public class NodoHora implements Serializable{
    private Estudiante elemento;
    private NodoHora Izq;
    private NodoHora Der;
    
    public NodoHora(Estudiante elem){
        this.elemento=elem;
        Izq=Der=null;
    }
    //getter y settter
    
    public Estudiante getElemento() {
        return elemento;
    }
    public void setElemento(Estudiante elemento) {
        this.elemento = elemento;
    }
    public NodoHora getIzq() {     return Izq;    }

    public void setIzq(NodoHora Izq) {
        this.Izq = Izq;
    }

    public NodoHora getDer() {
        return Der;
    }

    public void setDer(NodoHora Der) {
        this.Der = Der;
    }
    
    
}//fin de la clase
