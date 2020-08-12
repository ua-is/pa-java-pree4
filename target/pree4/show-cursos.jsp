<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="pe.edu.autonoma.pree4.entity.Estudiante" %>
<%@ page import="pe.edu.autonoma.pree4.entity.Curso" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    List<Curso> cursos = new ArrayList<>();
%>
<%
    cursos = (List<Curso>) request.getAttribute("cursos");
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Mi primera Web App</title>
    <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/estilo.css">
</head>
<body>

<header>
    <nav id="header-nav">
        <div id="header-logo">
            Logo
        </div>
        <ul id="nav-menu">
            <li><a href="showestudiantes">Estudiantes</a></li>
            <li><a href="showcursos">Cursos</a></li>
            <li><a href="showmatriculas">Maticulas</a></li>
            <li><a href="#">Cerrar Sesión</a></li>
        </ul>
    </nav>
</header>
<main>
    <section id="secction-main">
        <div>.</div>
        <div>
            <h2>Lista de Cursos</h2>
            <table id="table-trabajadores" class="table-collapse">
                <thead>
                <tr>
                    <th>#</th>
                    <th>Nombres</th>
                    <th>Semestre</th>
                    <th>creditos</th>
                    <th></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <%
                    for (Curso curso: cursos) {
                %>
                    <tr>
                        <td><%=curso.getId()%></td>
                        <td><%=curso.getNombre()%></td>
                        <td><%=curso.getSemestre()%></td>
                        <td><%=curso.getCreditos()%></td>
                        <td>
                            <!--<a href="edittrabajador?id=<%=curso.getId()%>" class="a-button a-button-edit">Editar</a>-->
                        </td>
                        <td>
                            <!--<a href="deltrabajador?id=<%=curso.getId()%>" class="a-button a-button-del">Borrar</a>-->
                        </td>
                    </tr>
                <%
                    }
                %>
                </tbody>
                <tfoot></tfoot>
            </table>

            <a href="newcurso" class="a-button a-button-new">Nuevo Curso</a>
        </div>
        <div>
            .
        </div>
    </section>
</main>
<footer>

</footer>

</body>
</html>
