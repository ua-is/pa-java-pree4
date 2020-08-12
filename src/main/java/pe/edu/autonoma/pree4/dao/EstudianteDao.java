package pe.edu.autonoma.pree4.dao;

import pe.edu.autonoma.pree4.conexion.Conexion;
import pe.edu.autonoma.pree4.entity.Estudiante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EstudianteDao {
    private Connection conn;
    private PreparedStatement ps;

    public EstudianteDao() {
        conn = Conexion.openConnection();
    }

    public void insert (Estudiante estudiante) {
        try {
            String sql = "INSERT INTO estudiantes (nombre, escuela) VALUES (?, ?)";

            ps = conn.prepareStatement(sql);
            ps.setString(1, estudiante.getNombre());
            ps.setString(1, estudiante.getEscuela());

            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.err.println( e.getMessage() );
        }

    }   //Estudiante(Integer id, String nombre, String escuela)
    public List<Estudiante> list() {
        List<Estudiante> estudiantes = new ArrayList<>();
        try {
            String sql = "SELECT * FROM estudiantes";
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while( rs.next() ) {
                Estudiante estudiante = new Estudiante( rs.getInt("id"),
                        rs.getString("nombre"), rs.getString("escuela"));
                estudiantes.add(estudiante);
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            System.err.println( e.getMessage() );
        }
        return estudiantes;
    } //Estudiante(Integer id, String nombre, String escuela)
    public Optional<Estudiante> findId(Integer id) {
        Optional<Estudiante> optional = Optional.empty();
        try {
            String sql = "SELECT * FROM  estudiantes WHERE id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if( rs.next() ) {
                Estudiante estudiante = new Estudiante( rs.getInt("id"),
                        rs.getString("nombre"), rs.getString("escuela"));

                optional = Optional.of(estudiante);
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return optional;
    }
    //Estudiante(Integer id, String nombre, String escuela)
    public void update( Estudiante estudiante ) {
        // Base de datos se utiliza la nomenclatura Snake Case
        try {
            String sql = "UPDATE estudiantes SET nombre = ?, escuela = ?  WHERE id = ?";

             ps = conn.prepareStatement(sql);
            ps.setString(1,estudiante.getNombre());
            ps.setString(2,estudiante.getEscuela());
            ps.setInt(3, estudiante.getId());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.err.println( e.getMessage() );
        }
    }

    public void deleteId( Integer id ) {
        // Base de datos se utiliza la nomenclatura Snake Case
        try {
            String sql = "DELETE FROM estudiantes WHERE id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.err.println( e.getMessage() );
        }
    }

}
