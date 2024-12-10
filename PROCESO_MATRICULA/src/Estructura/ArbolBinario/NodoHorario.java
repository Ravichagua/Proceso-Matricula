package Estructura.ArbolBinario;
import Modelo.Horario;
import java.io.Serializable;
public class NodoHorario implements Serializable{
    private Horario elemento;
    private NodoHorario Izq;
    private NodoHorario Der;
    
    public NodoHorario(Horario elem){
        this.elemento=elem;
        Izq=Der=null;
    }

    
    public Horario getElemento() {
        return elemento;
    }
    public void setElemento(Horario elemento) {
        this.elemento = elemento;
    }
    public NodoHorario getIzq() {     return Izq;    }

    public void setIzq(NodoHorario Izq) {
        this.Izq = Izq;
    }

    public NodoHorario getDer() {
        return Der;
    }

    public void setDer(NodoHorario Der) {
        this.Der = Der;
    }
    
    
}
