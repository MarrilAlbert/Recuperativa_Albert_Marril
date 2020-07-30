<%-- 
    Document   : crudProductos
    Created on : 03-07-2020, 21:18:40
    Author     : Edgard
--%>

<%@page import="dao.ProductoDAO"%>
<%@page import="modelos.Producto"%>
<%@page import="dao.EstadoDAO"%>
<%@page import="modelos.Estado"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% if(session.getAttribute("usuario")==null){
            response.sendRedirect("index.jsp?msj=No te pases");
        }else{
        Producto p = new Producto();
        if(request.getParameter("codigo")!=null){
         p = new ProductoDAO().obtenerProducto(Long.parseLong(request.getParameter("codigo")));
                }
            %>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar Producto</title>
    </head>
    <body>
    <center>
        <h1>Modificar Producto</h1>
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
        <form action="ControladorProducto" method="post">
            <table>
                <tr>
                    <td>Codigo</td>
                    <td><input type="number" name="codigo" value="<%= p.getCodigo() %>" readonly="true"/></td>
                </tr>
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="nombre" value="<%= p.getNombre() %>"/></td>
                </tr>
                <tr>
                    <td>Descripcion</td>
                    <td><textarea cols="20" rows="5" name="descripcion" >
                        <%= p.getDescripcion() %>
                        </textarea></td>
                </tr>
                <tr>
                    <td>Cantidad</td>
                    <td><input type="number" name="cantidad" value="<%= p.getCantidad() %>"/></td>
                </tr><tr>
                    <td>Precio</td>
                    <td><input type="number" name="precio" value="<%= p.getPrecio() %>"/></td>
                </tr>
                <tr>
                    <td>Estado</td>
                    <td>
                        <select name="estado">
                            <option value="0">Seleccione</option>
                            <% ArrayList<Estado> estados = new EstadoDAO().obtenerEstados(); 
                            for(Estado e:estados){%>
                            <option value="<%= e.getId() %>" 
                                  <% if(e.getId()== p.getEstado().getId()){ out.print("selected='selected'"); }%>  
                                    ><%= e %></option>
                            <% } %>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><input type="reset" value="Limpiar"/></td>
                    <td><input type="submit" value="Modificar"/></td>
                <input type="hidden" name="accion" value="2"/>
                </tr>
            </table>
        </form>
                        <% if(request.getParameter("msj")!= null){%>
        <h4><%= request.getParameter("msj") %></h4>
        <%}%>
        
    </center>
    </body>
</html>
<% } %>