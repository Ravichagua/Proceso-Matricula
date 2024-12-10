package Modelo;

import java.io.Serializable;


public class Docente implements Serializable {
    private int id;
    private String nombre;
    private String apellido;
    private String Curso;
    private String codigo;
    
    public Object[] Registro(int num){
        
        Object[] fila={codigo,nombre,apellido,Curso};
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
    public String getNombreCompleto() {
        return nombre+" "+apellido;
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

    public String getCurso() {
        return Curso;
    }

    public void setCurso(String asignatura) {
        this.Curso = asignatura;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public int getCursoNumero() {
        
        if(Curso.equals("Matematicas")){
            return 0;
        }
        if(Curso.equals("Comunicacion")){
            return 1;
        }
        if(Curso.equals("Ingles")){
            return 2;
        }
        if(Curso.equals("EdFisica")){
            return 3;
        }
        if(Curso.equals("Quimica")){
            return 4;
        }
        if(Curso.equals("Informatica")){
            return 5;
        }
        else{
            return -1;
        }
    }
    
}
