

<%@page import="dao.PeliculasDAO"%>
<%@page import="modelos.Peliculas"%>
<%@page import="dao.CategoriaDAO"%>
<%@page import="modelos.Categoria"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <title>Crud Peliculas</title>
    </head>
    <body>
    <center>
        <h1>Crud Peliculas</h1>
        <menu >
            <a href="intranet.jsp">
            <menuitem >Usuarios</menuitem>
            </a> |
            <a href="crudPelicula.jsp">
            <menuitem >Peliculas</menuitem>
            </a> | 
            <a href="crudcategoria.jsp">
            <menuitem>Categoria</menuitem>
            </a>
        </menu>
        <form action="ControladorPeliculas" method="post">
            <table>
                <tr>
                    <td>Codigo</td>
                    <td><input type="number" name="codigo"/></td>
                </tr>
                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="nombre"/></td>
                </tr>
                <tr>
                    <td>Duracion</td>
                    <td><input type="number" name="duracion"/></td>
                </tr>
                <tr>
                 <td>Idioma</td>
                    <td><input type="text" name="idioma"/></td>
                </tr>
               
                <tr>
                    <td>Categoria</td>
                    <td>
                        <select name="categoria">
                            <option value="0">Seleccione</option>
                            <% ArrayList<Categoria> categorias = new CategoriaDAO().obtenerCategorias(); 
                            for(Categoria e:categorias){%>
                            <option value="<%= e.getId() %>"><%= e %></option>
                            <% } %>
                        </select>
                    </td>
                </tr>
                <tr>
                      <td><input type="submit" value="Registrar"/></td>
                
                    <td><input type="reset" value="Limpiar"/></td>
                     <input type="hidden" name="accion" value="1"/>
                  
                </tr>
            </table>
        </form>
                        <% if(request.getParameter("msj")!= null){%>
        <h4><%= request.getParameter("msj") %></h4>
        <%}%>
        <table>
            <tr>
                <td>Codigo</td>
                <td>Nombre</td>
                <td>Duracion</td>
                <td>Idioma</td>
                <td>Categoria</td>
                <td>Modificar</td>
                <td>Eliminar</td>
            </tr>
            <% ArrayList<Peliculas> peliculass = new PeliculasDAO().obtenerPeliculas();
               for(Peliculas p: peliculass){               
                %>
            <tr>
                <td><%= p.getCodigo() %></td>
                <td><%= p.getNombre() %></td>
                <td><%= p.getDuracion()%></td>
                <td><%= p.getIdioma()%></td>
                <td><%= p.getCategoria()%></td>
                <td><a href="modPelicula.jsp?codigo=<%= p.getCodigo()%>">
                        <button type="button">Modificar</button>
                    </a></td>
                <td><a href="delcategoria.jsp?codigo=<%= p.getCodigo() %>">
                        <button type="button">Eliminar</button>
                    </a></td>
                    
                   
            </tr>
            <% } %>
        </table>
    </center>
    </body>
</html>
