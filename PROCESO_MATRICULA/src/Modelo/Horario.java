package Modelo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Horario implements Serializable{

    private String horaInicio;
    private String curso;
    private String salonId;
    
    private String horaFinal;
    private String profesor;
    private String grado;

    public Horario(Object[] registro){
       this.horaInicio=registro[0].toString();
       this.curso =registro[1].toString();
       this.profesor =registro[2].toString();
       this.salonId=registro[3].toString();
   }
    
    public Object[] getRegistro(){
      Object[] fila={horaInicio,getHoraFinal(),curso,profesor,salonId};
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
    public String getHoraFinal(){
        try{
            Calendar calendar = Calendar.getInstance();
            //convertir a Date
            SimpleDateFormat formato = new SimpleDateFormat("HH:mm");

            Date Hora = formato.parse(getHoraInicio());
            calendar.setTime(Hora); 
            calendar.add(Calendar.HOUR, 1); 
            calendar.add(Calendar.MINUTE, 30);

            String horaFinal=formato.format(calendar.getTime());
            return horaFinal;
        }catch(Exception e){
            return "ERROR"; 
        }
        
    }

    public void setHoraFinal(String horaFinal) {
        this.horaFinal = horaFinal;
    }
}
