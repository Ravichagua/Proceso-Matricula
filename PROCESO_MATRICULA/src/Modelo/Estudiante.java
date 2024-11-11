package Modelo;


public class Estudiante {

    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private String grado;

    public Estudiante(int id, String nombre, String apellido, int edad, String grado) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.grado = grado;
    }

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
}


