package pe.edu.autonoma.pree4.controller;

import pe.edu.autonoma.pree4.dao.EstudianteDao;
import pe.edu.autonoma.pree4.entity.Estudiante;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ShowEstudiantesServlet", urlPatterns = "/showestudiantes")
public class ShowEstudiantesServlet extends HttpServlet {
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Estudiante> estudiantes = new ArrayList<>();

        try {
            EstudianteDao dao = new EstudianteDao();
            estudiantes = dao.list();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        request.setAttribute("estudiantes", estudiantes);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("show-estudiantes.jsp");
        requestDispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doProcess(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doProcess(request, response);
    }
}
