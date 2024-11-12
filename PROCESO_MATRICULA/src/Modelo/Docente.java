package Modelo;

import java.io.Serializable;


public class Docente implements Serializable {
    private int id;
    private String nombre;
    private String apellido;
    private String asignatura;
    private String codigo;
    
    public Object[] Registro(int num){
        
        Object[] fila={num,nombre,apellido,asignatura,codigo};
        return fila;
    }
    
    public Docente(){}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
