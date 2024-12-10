package Modelo;

import java.io.Serializable;


public class Estudiante implements Serializable {

    private String nombre;
    private String apellido;
    private int edad;
    private String grado;
    private String dni;
    
    public Estudiante(){}


    public Object[] Registro(){
       Object[] fila={dni,nombre,apellido,edad,grado};
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
    public int getGradoNumero() {
        
        if(grado.equals("Primero")){
            return 0;
        }
        if(grado.equals("Segundo")){
            return 1;
        }
        if(grado.equals("Tercero")){
            return 2;
        }
        if(grado.equals("Cuarto")){
            return 3;
        }
        if(grado.equals("Quinto")){
            return 4;
        }
        if(grado.equals("Sexto")){
            return 5;
        }
        else{
            return -1;
        }
    }
}


