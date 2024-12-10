package Modelo;

import java.io.Serializable;
import java.util.Date;
import Procesos.ProcesosMatricula;

public class Matricula implements Serializable{

    private String dni;
    private String estudianteNombres;
    private String Grado;
    private String Estado;
    private Date fechaMatricula;

    public Object[] getRegistro(){
       
       Object[] fila={getDni(), getEstudianteNombres(), getGrado(), getEstado(),getFechaMatricula()};
       return fila;
   }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEstudianteNombres() {
        return estudianteNombres;
    }

    public void setEstudianteNombres(String estudianteNombres) {
        this.estudianteNombres = estudianteNombres;
    }

    public String getGrado() {
        return Grado;
    }

    public void setGrado(String Grado) {
        this.Grado = Grado;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    
    public String getFechaMatricula() {
        String Fecha=ProcesosMatricula.DateToString(fechaMatricula);
        return Fecha;
    }
    public Date getFecha() {
        
        return fechaMatricula;
    }

    public void setFechaMatricula(Date fechaMatricula) {
        this.fechaMatricula = fechaMatricula;
    }
    
    
}
