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
        if(Estado.equals("EN PROCESO")){
            return "-";
        }else{
        String Fecha=ProcesosMatricula.DateToString(fechaMatricula);
        return Fecha;
        }
        
    }
    public Date getFecha() {
        
        return fechaMatricula;
    }

    public void setFechaMatricula(Date fechaMatricula) {
        this.fechaMatricula = fechaMatricula;
    }
    public int getEstadoNum() {
        System.out.println("Estado NUM DEBE SALIR:"+Estado);
        if(Estado.equals("MATRICULADO")){
            return 0;
        }
        if(Estado.equals("EN PROCESO")){
            return 1;
        }
        else{
            return -1;
        }
    }
    public int getGradoNum() {
        System.out.println("GRADO NUM DEBE SALIR:"+Grado);
       if(Grado.equals("Primero")){
            return 0;
        }
        if(Grado.equals("Segundo")){
            return 1;
        }
        if(Grado.equals("Tercero")){
            return 2;
        }
        if(Grado.equals("Cuarto")){
            return 3;
        }
        if(Grado.equals("Quinto")){
            return 4;
        }
        if(Grado.equals("Sexto")){
            return 5;
        }
        else{
            return -1;
        }
    }
}
