package Modelo;

import java.io.Serializable;


public class Estudiante implements Serializable {

    //private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private String grado;
    private String dni;
    
    public Estudiante(){}
    /*
    public Estudiante(int id, String nombre, String apellido, int edad, String grado) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.grado = grado;
    }*/

    public Object[] Registro(){
       Object[] fila={nombre,apellido,edad,dni,grado};
       return fila;
   }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }
    
    public String getNombreCompleto(){
        return nombre+apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}


