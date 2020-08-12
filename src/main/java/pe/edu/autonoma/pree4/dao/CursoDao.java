package pe.edu.autonoma.pree4.dao;

import pe.edu.autonoma.pree4.conexion.Conexion;
import pe.edu.autonoma.pree4.entity.Curso;
import pe.edu.autonoma.pree4.entity.Estudiante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CursoDao {
    private Connection conn;
    private PreparedStatement ps;

    public CursoDao() {
        conn = Conexion.openConnection();
    }
    // id int(11) AI P,  nombre varchar(50),  semestre int(11), creditos int(11)
    public void insert (Curso curso) {
        try {
            String sql = "INSERT INTO cursos (nombre, semestre, creditos) VALUES (?, ?, ?)";

            ps = conn.prepareStatement(sql);
            ps.setString(1, curso.getNombre());
            ps.setInt(2, curso.getSemestre());
            ps.setInt(3, curso.getCreditos());

            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.err.println( e.getMessage() );
        }

    }   // id int(11) AI P,  nombre varchar(50),  semestre int(11), creditos int(11)
    public List<Curso> list() {
        List<Curso> cursos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM cursos";
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while( rs.next() ) {
                Curso curso = new Curso( rs.getInt("id"),
                        rs.getString("nombre"), rs.getInt("semestre"),
                        rs.getInt("creditos"));
                cursos.add(curso);
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            System.err.println( e.getMessage() );
        }
        return cursos;
    }   // id int(11) AI P,  nombre varchar(50),  semestre int(11), creditos int(11)

    public Optional<Curso> findId(Integer id) {
        Optional<Curso> optional = Optional.empty();
        try {
            String sql = "SELECT * FROM cursos WHERE id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if( rs.next() ) {
                Curso curso = new Curso( rs.getInt("id"),
                        rs.getString("nombre"), rs.getInt("semestre"),
                        rs.getInt("creditos"));

                optional = Optional.of(curso);
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return optional;
    }
    // id int(11) AI P,  nombre varchar(50),  semestre int(11), creditos int(11)
    public void update( Curso curso ) {
        // Base de datos se utiliza la nomenclatura Snake Case
        try {
            String sql = "UPDATE cursos SET nombre = ?, semestre = ?, creditos = ? WHERE id = ?";

            ps = conn.prepareStatement(sql);
            ps.setString(1,curso.getNombre());
            ps.setInt(2,curso.getSemestre());
            ps.setInt(3,curso.getCreditos());
            ps.setInt(4, curso.getId());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.err.println( e.getMessage() );
        }
    }

    public void deleteId( Integer id ) {
        // Base de datos se utiliza la nomenclatura Snake Case
        try {
            String sql = "DELETE FROM cursos WHERE id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.err.println( e.getMessage() );
        }
    }
}
