package Estructura.ArbolBinario;
import Modelo.Horario;
import java.io.Serializable;
public class NodoHora implements Serializable{
    private Horario elemento;
    private NodoHora Izq;
    private NodoHora Der;
    
    public NodoHora(Horario elem){
        this.elemento=elem;
        Izq=Der=null;
    }
    //getter y settter
    
    public Horario getElemento() {
        return elemento;
    }
    public void setElemento(Horario elemento) {
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
