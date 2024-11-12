package Modelo;

import java.io.Serializable;


public class Horario implements Serializable{
    //private int id;
   // private String dia;
    private String horaInicio;
    //private String horaFin;
    private String curso;
    private String salonId;

    public Horario(Object[] registro){
       this.horaInicio=registro[0].toString();
       this.curso =registro[1].toString();
       this.salonId=registro[2].toString();
   }
    
    public Object[] getRegistro(){
      Object[] fila={horaInicio,curso,salonId};
       //Object[] fila={"horaInicio","curso","salonId"};
       return fila;
   }
    

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    

    public String getCursoId() {
        return curso;
    }

    public void setCursoId(String cursoId) {
        this.curso = cursoId;
    }

    public String getSalonId() {
        return salonId;
    }

    public void setSalonId(String salonId) {
        this.salonId = salonId;
    }
}
