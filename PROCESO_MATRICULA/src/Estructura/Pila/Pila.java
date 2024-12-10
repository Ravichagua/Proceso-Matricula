package Estructura.Pila;
import java.io.Serializable;
import Modelo.*;
import Persistencia.PersistenciaMatricula;
import Procesos.Mensajes;

import java.util.Stack;


public class Pila implements Serializable {
    
    public Stack<Matricula> pila;
    
    public Pila(){
        pila = new Stack();
    }
    
    //agregando datos a la pila
    public void Apilar(Matricula objetoMatricula){
        pila.push(objetoMatricula);
        PersistenciaMatricula.GuardarMatricula(this);
    }
    //método que elimina un operario de la pila
    public void Desapilar(){
        if(pila.isEmpty()){
            Mensajes.Mostrar("Pila vacía");
        }else{
           pila.pop();
           PersistenciaMatricula.GuardarMatricula(this);
        }
    }
    //metodo que visualiza el ultimo elemento de la pila
    public Matricula VerUltimo(){
        return pila.peek();
    }
    public void ObtenerUltimo(){
        Mensajes.Mostrar(pila.peek().toString());
    }
    //método que visualiza el primer wwelemento de la pila
    public void VerPrimero(){
        Mensajes.Mostrar(pila.firstElement().toString());
    }
    public Matricula ObtenerPrimero(){
        return pila.firstElement();
    }
    
    //metodo que busca un elemento en pila NO OLVIDARETE REDSO****************
    public int BuscarOperario(String cod){
       for(int i=0;i<pila.size();i++){
           if(cod.equals(pila.get(i).getDni())){
               Mensajes.Mostrar(pila.get(i).toString());
               return i;
           }
           
       } 
       Mensajes.Mostrar("Codigo + "+cod+" no existe en la pila");
       return 0;
    }    //*************************************************************************
    public int Cantidad(){
        return pila.size();
    }    
    public Matricula ObtenerOpe(int pos){
        return pila.get(pos);
    }
    public Matricula ObtenerActual(int pos){
        return pila.get(pos);
    }
    
     public static Pila copiarPila(Stack<Matricula> stackOrginal) {
        Stack<Matricula> StackAuxiliar = new Stack<>();
        Stack<Matricula> StackCopia = new Stack<>();

        // Vaciar la pila original en la pila auxiliar
        while (!stackOrginal.isEmpty()) {
            StackAuxiliar.push(stackOrginal.pop());
        }

        // Vaciar la pila auxiliar en la nueva pila (esto preserva el orden)
        while (!StackAuxiliar.isEmpty()) {
            Matricula elemento = StackAuxiliar.pop();
            StackCopia.push(elemento);
            stackOrginal.push(elemento); // Restaurar la pila original
        }
        
        Pila pilanueva=new Pila();
        pilanueva.pila=StackCopia;
        return pilanueva;
    }
    public void EliminarPosicion(int numero){
        pila.remove(numero);
    }
    
    
    
}
