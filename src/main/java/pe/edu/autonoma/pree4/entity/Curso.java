package pe.edu.autonoma.pree4.entity;

// id int(11) AI PK , nombre varchar(50), semestre int(11), creditos int(11)
public class Curso {
    private Integer id;
    private String nombre;
    private Integer semestre;
    private Integer creditos;

    public Curso(String nombre, Integer semestre, Integer creditos) {
        this.nombre = nombre;
        this.semestre = semestre;
        this.creditos = creditos;
    }

    public Curso(Integer id, String nombre, Integer semestre, Integer creditos) {
        this.id = id;
        this.nombre = nombre;
        this.semestre = semestre;
        this.creditos = creditos;
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

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public Integer getCreditos() {
        return creditos;
    }

    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }
}
