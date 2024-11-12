package Estructura;
import java.io.Serializable;
import java.util.ArrayList;
import Modelo.*;
public class ListaEstudiantes implements Serializable{
    private ArrayList<Estudiante> lista;
    
    
    
    public ListaEstudiantes(){
        lista= new ArrayList();
    }
    public void Agregar(Estudiante e){
        lista.add(e);        
    }
    public Estudiante Recuperar(int pos){
        return lista.get(pos);
    }
    public void Eliminar(int pos){
        lista.remove(pos);
    }
    public int Cantidad(){return lista.size(); }
    public void Reemplazar(int pos,Estudiante actual){
        lista.set(pos, actual);
    }
     
    public int Buscar(String dnibuscado){
        for(int i=0;i<lista.size();i++){
            if(dnibuscado.equals(lista.get(i).getDni()))
                return i;
        }
        return -1;
    }

    public ArrayList<Estudiante> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Estudiante> lista) {
        this.lista = lista;
    }
}//fin de la clase
