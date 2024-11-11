package Modelo;


public class Matricula {
    private int id;
    private int estudianteId;
    private int cursoId;
    private int salonId;
    private String fechaMatricula;

    public Matricula(int id, int estudianteId, int cursoId, int salonId, String fechaMatricula) {
        this.id = id;
        this.estudianteId = estudianteId;
        this.cursoId = cursoId;
        this.salonId = salonId;
        this.fechaMatricula = fechaMatricula;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEstudianteId() {
        return estudianteId;
    }

    public void setEstudianteId(int estudianteId) {
        this.estudianteId = estudianteId;
    }

    public int getCursoId() {
        return cursoId;
    }

    public void setCursoId(int cursoId) {
        this.cursoId = cursoId;
    }

    public int getSalonId() {
        return salonId;
    }

    public void setSalonId(int salonId) {
        this.salonId = salonId;
    }

    public String getFechaMatricula() {
        return fechaMatricula;
    }

    public void setFechaMatricula(String fechaMatricula) {
        this.fechaMatricula = fechaMatricula;
    }
    
    
}
