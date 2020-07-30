

<%@page import="modelos.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%if(session.getAttribute("usuarios")!= null){
             ArrayList<Usuario> lista = (ArrayList) session.getAttribute("usuarios");
            %>
        <h1>Hello World!</h1>
        <table>
            <tr>
                <td>Nombre</td>
                 <td>Nombre2</td>
            </tr>
            <% for(Usuario u:lista){ %>
            <tr>
                <td><%= u.getNombre() %></td>
                <td><%= Usuario.nombre2 %></td>
            </tr>
            <% } }%>
        </table>
    </body>
</html>
