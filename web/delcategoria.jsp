<%-- 
    Document   : crudProductos
    Created on : 03-07-2020, 21:18:40
    Author     : Edgard
--%>

<%@page import="dao.EstadoDAO"%>
<%@page import="modelos.Estado"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminar Estado</title>
    </head>
    <body>
    <center>
        <h1>Eliminar Estado</h1>
        <menu >
            <a href="intranet.jsp">
            <menuitem >Usuarios</menuitem>
            </a> |
            <a href="crudProductos.jsp">
            <menuitem >Productos</menuitem>
            </a> | 
            <a href="crudEstados.jsp">
            <menuitem >Estados</menuitem>
            </a>
        </menu>
        <% if(request.getParameter("id")!=null){
            Estado e = new EstadoDAO().obtenerEstado(Integer.parseInt(request.getParameter("id")));
            %>
        <form action="ControladorEstado" method="post">
            <table>
                <tr>
                    <td>ID</td>
                    <td><input type="text" name="id" readonly="true" value="<%= e.getId() %>" /></td>
                </tr>
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="nombre" readonly="true" value="<%= e.getNombre() %>"/></td>
                </tr>
                    <td><input type="reset" value="Limpiar"/></td>
                    <td><input type="submit" value="Eliminar"/></td>
                <input type="hidden" name="accion" value="3"/>
                </tr>
            </table>
        </form>
        <% }%>
                        <% if(request.getParameter("msj")!= null){%>
        <h4><%= request.getParameter("msj") %></h4>
        <%}%>
        
    </center>
    </body>
</html>
