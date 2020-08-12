package pe.edu.autonoma.pree4.entity;

public class Estudiante {
    // id int(11) AI PK, nombre varchar(50), escuela varchar(50)
    private Integer id;
    private String nombre;
    private String escuela;

    public Estudiante(String nombre, String escuela) {
        this.nombre = nombre;
        this.escuela = escuela;
    }
    public Estudiante(Integer id, String nombre, String escuela) {
        this.id = id;
        this.nombre = nombre;
        this.escuela = escuela;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEscuela() {
        return escuela;
    }

    public void setEscuela(String escuela) {
        this.escuela = escuela;
    }
}
