package pe.edu.autonoma.pree4.entity;

// id int(11) AI PK, estudiante_id int(11), curso_id int(11),  seccion varchar(5) , nota int(11)
public class Matricula {
    private Integer id;
    private Estudiante estudiante;
    private Curso curso;
    private String seccion;
    private Integer nota;

    public Matricula(Estudiante estudiante, Curso curso, String seccion, Integer nota) {
        this.estudiante = estudiante;
        this.curso = curso;
        this.seccion = seccion;
        this.nota = nota;
    }

    public Matricula(Integer id, Estudiante estudiante, Curso curso, String seccion, Integer nota) {
        this.id = id;
        this.estudiante = estudiante;
        this.curso = curso;
        this.seccion = seccion;
        this.nota = nota;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }
}
