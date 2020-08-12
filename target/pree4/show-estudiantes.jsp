<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="pe.edu.autonoma.pree4.entity.Estudiante" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    List<Estudiante> estudiantes = new ArrayList<>();
%>
<%
    estudiantes = (List<Estudiante>) request.getAttribute("estudiantes");
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
            <h2>Lista de Estudiantes</h2>
            <table id="table-trabajadores" class="table-collapse">
                <thead>
                <tr>
                    <th>#</th>
                    <th>Apellidos y NOmbres</th>
                    <th>Escuela</th>
                    <th></th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <%
                    for (Estudiante estudiante: estudiantes) {
                %>
                    <tr>
                        <td><%=estudiante.getId()%></td>
                        <td><%=estudiante.getNombre()%></td>
                        <td><%=estudiante.getEscuela()%></td>
                        <td>
                            <!--<a href="edittrabajador?id=<%=estudiante.getId()%>" class="a-button a-button-edit">Editar</a>-->
                        </td>
                        <td>
                            <!--<a href="deltrabajador?id=<%=estudiante.getId()%>" class="a-button a-button-del">Borrar</a>-->
                        </td>
                    </tr>
                <%
                    }
                %>
                </tbody>
                <tfoot></tfoot>
            </table>

            <a href="newtrabajador" class="a-button a-button-new">Nuevo Estudiante</a>
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
