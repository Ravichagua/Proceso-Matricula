package Estructura;
import java.io.Serializable;
import java.util.ArrayList;
import Modelo.*;
public class ListaDocentes implements Serializable{
    private ArrayList<Docente> lista;
    
    
    
    public ListaDocentes(){
        lista= new ArrayList();
    }
    public void Agregar(Docente e){
        lista.add(e);        
    }
    public Docente Recuperar(int pos){
        return lista.get(pos);
    }
    public void Eliminar(int pos){
        lista.remove(pos);
    }
    public int Cantidad(){return lista.size(); }
    public void Reemplazar(int pos,Docente actual){
        lista.set(pos, actual);
    }
      

    public ArrayList<Docente> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Docente> lista) {
        this.lista = lista;
    }
}//fin de la clase
