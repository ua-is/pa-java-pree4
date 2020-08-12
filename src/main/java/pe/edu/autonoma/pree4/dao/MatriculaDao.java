package pe.edu.autonoma.pree4.dao;

import pe.edu.autonoma.pree4.conexion.Conexion;
import pe.edu.autonoma.pree4.entity.Curso;
import pe.edu.autonoma.pree4.entity.Estudiante;
import pe.edu.autonoma.pree4.entity.Matricula;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MatriculaDao {
    private Connection conn;
    private PreparedStatement ps;
    // Aqui colocar todos los Dao de los atributos tipo Objeto
    private EstudianteDao estudianteDao;
    private CursoDao cursoDao;

    public MatriculaDao() {
        conn = Conexion.openConnection();
        // Daos
        estudianteDao = new EstudianteDao();
        cursoDao = new CursoDao();
    }
    // Métodos CRUD
    // Create
    // id int(11) AI PK, estudiante_id int(11), curso_id int(11),  seccion varchar(5) , nota int(11)
    public void insert( Matricula matricula ) {
        // Base de datos se utiliza la nomenclatura Snake Case
        try {
            String sql = "INSERT INTO matricula (estudiante_id, curso_id, seccion, nota ) " +
                    "VALUES (?, ?, ?, ?)";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, matricula.getEstudiante().getId());
            ps.setInt(2, matricula.getCurso().getId());
            ps.setString(3, matricula.getSeccion());
            ps.setInt(4, matricula.getNota());
            // Execute SQL
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.err.println( e.getMessage() );
        }
    }
    // READ
    // findAll, listar, list, fetchAll, getAll
    public List<Matricula> list() {
        List<Matricula> matriculas = new ArrayList<>();
        try {
            String sql = "SELECT * FROM matriculas";
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while( rs.next() ) {
                // Obtener el Optional que contiene el trabajador
                int idEstudiante = rs.getInt("estudiante_id");
                Optional<Estudiante> optionalEstudiante = estudianteDao.findId( idEstudiante );

                int idCurso = rs.getInt("curso_id");
                Optional<Curso> optionalCurso = cursoDao.findId( idCurso );

                // id int(11) AI PK, estudiante_id int(11), curso_id int(11),  seccion varchar(5) , nota int(11)
                Matricula matricula = new Matricula( rs.getInt("id"), optionalEstudiante.get(),
                        optionalCurso.get(), rs.getString("seccion"), rs.getInt("nota"));

                matriculas.add( matricula );
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            System.err.println( e.getMessage() );
        }
        return matriculas;
    }
    // findById, GetById, GetEntity, listarId, findId
    public Optional<Matricula> findId(Integer id) {
        // Definiendo Optional vacio (empty)
        Optional<Matricula> optional = Optional.empty();
        try {
            String sql = "SELECT * FROM matriculas WHERE id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            // Si el query devolvio 1 elemento
            if( rs.next() ) {
                // Obtener el Optional que contiene el trabajador
                int idEstudiante = rs.getInt("estudiante_id");
                Optional<Estudiante> optionalEstudiante = estudianteDao.findId( idEstudiante );

                int idCurso = rs.getInt("curso_id");
                Optional<Curso> optionalCurso = cursoDao.findId( idCurso );

                // id int(11) AI PK, estudiante_id int(11), curso_id int(11),  seccion varchar(5) , nota int(11)
                Matricula matricula = new Matricula( rs.getInt("id"), optionalEstudiante.get(),
                        optionalCurso.get(), rs.getString("seccion"), rs.getInt("nota"));

                optional = Optional.of( matricula );
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return optional;
    }
    // findBy____ : Buscar por un atributo, findByDni
    // fetchBy_____: Todos los demás queries, fetchByBornJanuary
    //

    //UPDATE
    // actualizar, update,
    public void update( Matricula matricula ) {
        // Base de datos se utiliza la nomenclatura Snake Case
        try {
            // id int(11) AI PK, estudiante_id int(11), curso_id int(11),  seccion varchar(5) , nota int(11)
            String sql = "UPDATE matriculas SET estudiante_id = ?, curso_id, seccion = ?, nota = ?  WHERE id = ?";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, matricula.getEstudiante().getId());
            ps.setInt(2, matricula.getCurso().getId());
            ps.setString(3, matricula.getSeccion());
            ps.setInt(4, matricula.getNota());
            ps.setInt(5, matricula.getId());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.err.println( e.getMessage() );
        }
    }

    //DELETE
    // borrarID, deleteId, deleteById,
    public void deleteId( Integer id ) {
        // Base de datos se utiliza la nomenclatura Snake Case
        try {
            String sql = "DELETE FROM matriculas WHERE id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            System.err.println( e.getMessage() );
        }
    }
}
