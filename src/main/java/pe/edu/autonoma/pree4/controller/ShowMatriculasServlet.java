package pe.edu.autonoma.pree4.controller;

import pe.edu.autonoma.pree4.dao.CursoDao;
import pe.edu.autonoma.pree4.dao.MatriculaDao;
import pe.edu.autonoma.pree4.entity.Curso;
import pe.edu.autonoma.pree4.entity.Matricula;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ShowMatriculasServlet", urlPatterns = "/showmatriculas")
public class ShowMatriculasServlet extends HttpServlet {
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Matricula> matriculas = new ArrayList<>();

        try {
            MatriculaDao dao = new MatriculaDao();
            matriculas = dao.list();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        request.setAttribute("matriculas", matriculas);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("show-matriculas.jsp");
        requestDispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doProcess(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doProcess(request, response);
    }
}
