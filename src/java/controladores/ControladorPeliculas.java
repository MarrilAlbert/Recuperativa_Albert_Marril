/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import dao.CategoriaDAO;
import dao.PeliculasDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.Peliculas;


@WebServlet(name = "ControladorPeliculas", urlPatterns = {"/ControladorPeliculas"})
public class ControladorPeliculas extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         if(request.getParameter("accion")!=null){
        String accion = request.getParameter("accion");
        switch(accion){
            case "1": registrar(request,response);
                /*break;*/
            /*case "2": modificar(request,response); */
        }
         }else{
             response.sendRedirect("crudPelicula.jsp?msj=No te pases");
         }
    }
    
   /* private void modificar(HttpServletRequest request, HttpServletResponse response) throws IOException{
         try{
            long codigo =Long.parseLong(request.getParameter("codigo").trim());
            String nombre = request.getParameter("nombre").trim();
            String descripcion = request.getParameter("descripcion").trim();
            int cantidad = Integer.parseInt(request.getParameter("cantidad").trim());
            int precio = Integer.parseInt(request.getParameter("precio").trim());
            int estado =Integer.parseInt( request.getParameter("estado").trim());
            if(codigo<1||nombre.equals("")||descripcion.equals("")||cantidad<1||precio<1||estado<1){
                response.sendRedirect("modProducto.jsp?msj=valores erroneos");
            }else{
                CategoriaDAO ed = new CategoriaDAO();
                Peliculas nuevoProducto = new Peliculas (codigo,nombre,descripcion,
                        cantidad,precio,ed.obtenerEstado(estado));
                PeliculasDAO pd = new PeliculasDAO();
                if(pd.obtenerProducto(nuevoProducto.getCodigo())==null){
                    response.sendRedirect("modProducto.jsp?msj=Codigo de producto inexistente");
                }else{
                   int respuesta = pd.modificar(nuevoProducto);
                   if(respuesta>0){
                       response.sendRedirect("crudProductos.jsp?msj=Producto modificado");
                   }else{
                       response.sendRedirect("crudProductos.jsp?msj=Producto no se pudo modificar");
                   }
                }
            }
         }catch(Exception e){
             
         }
    }*/
         private void registrar(HttpServletRequest request, HttpServletResponse response) throws IOException{
           try{
            long codigo =Long.parseLong(request.getParameter("codigo").trim());
            String nombre = request.getParameter("nombre").trim();
            int duracion = Integer.parseInt(request.getParameter("duracion").trim());
            String idioma = request.getParameter("idioma").trim();
            int categoria =Integer.parseInt(request.getParameter("categoria").trim());
            if(codigo<1||nombre.equals("")||duracion<1||idioma.equals("")||categoria<1){
                response.sendRedirect("crudPelicula.jsp?msj=valores erroneos");
            }else{
                CategoriaDAO ed = new CategoriaDAO();
                Peliculas nuevaPeliculas = new Peliculas(codigo,nombre,duracion,
                        idioma,ed.obtenerCategoria(categoria));
                PeliculasDAO pd = new PeliculasDAO();
                if(pd.obtenerPelicula(nuevaPeliculas.getCodigo())==null){
                    int respuesta = pd.registrar(nuevaPeliculas);
                    if(respuesta==1){
                    response.sendRedirect("crudPelicula.jsp?msj=Pelicula registrado");
                    }else{
                    response.sendRedirect("crudPelicula.jsp?msj=pelicula no se pudo registrar");
                    }
                }else{
                    response.sendRedirect("crudPelicula.jsp?msj=pelicula ya existe");
                }
            }
           }catch(Exception e){
               response.sendRedirect("crudPelicula.jsp?msj="+e.getMessage());
           }
        }
    

  

}
