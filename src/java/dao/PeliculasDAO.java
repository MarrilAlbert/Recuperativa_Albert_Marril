/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelos.Categoria;
import modelos.Peliculas;


public class PeliculasDAO extends Conexion {
    
    public int registrar(Peliculas peliculas) throws SQLException{
        try{
            String sentencia ="Insert into peliculas values (?,?,?,?,?)";
            conectar();
            PreparedStatement ps = obtenerPS(sentencia);
            ps.setLong(1, peliculas.getCodigo());
            ps.setString(2, peliculas.getNombre());
            ps.setInt(3, peliculas.getDuracion());
            ps.setString(4, peliculas.getIdioma());
            ps.setInt(5, peliculas.getCategoria().getId());
            
            return ps.executeUpdate();
        }catch(Exception e){
            return -1;
        }finally{
            desconectar();
        }
    }
   /*public int modificar(Peliculas producto) throws SQLException{
        try{
            String sentencia ="update producto set nombre = ?, descripcion=?, cantidad = ?"
                    + ", precio = ?, id_estado=? where codigo = ?";
            conectar();
            PreparedStatement ps = obtenerPS(sentencia);
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getDescripcion());
            ps.setInt(3, producto.getCantidad());
            ps.setInt(4, producto.getPrecio());
            ps.setInt(5, producto.getEstado().getId());
            ps.setLong(6, producto.getCodigo());
            return ps.executeUpdate();
        }catch(Exception e){
            return -1;
        }finally{
            desconectar();
        }
    }*/
    public int eliminar(Peliculas producto) throws SQLException{
        try{
            String sentencia ="delete from producto where codigo = ?";
            conectar();
            PreparedStatement ps = obtenerPS(sentencia);
            ps.setLong(1, producto.getCodigo());
            return ps.executeUpdate();
        }catch(Exception e){
            return -1;
        }finally{
            desconectar();
        }
    }
    public Peliculas obtenerPelicula(long codigo) throws SQLException{
        try{
            String sentencia = "select * from  vista_peliculas where codigo = ?";
            conectar();
            PreparedStatement ps = obtenerPS(sentencia);
            ps.setLong(1, codigo);
            ResultSet rs = ps.executeQuery();
            Peliculas p = null;
            if(rs.next()){
                Categoria c = new Categoria(rs.getInt("id"),rs.getString("c_nombre"));
                p = new Peliculas(rs.getLong("codigo"),rs.getString("nombre"),rs.getInt("duracion"),
                rs.getString("idioma"),c);
            }
            return p;
        }catch(Exception e){
            return null;
        }finally{
            desconectar();
        }
    }
    public ArrayList<Peliculas> obtenerPeliculas() throws SQLException{
        try{
            String sentencia = "select * vista_peliculas";
            conectar();
            PreparedStatement ps = obtenerPS(sentencia);
            ResultSet rs = ps.executeQuery();
            ArrayList<Peliculas> peliculass = new ArrayList();
            while(rs.next()){
                Categoria c = new Categoria(rs.getInt("id"),rs.getString("c_nombre"));
                peliculass.add(new Peliculas(rs.getLong("codigo"),rs.getString("nombre"),rs.getInt("duracion"),
                rs.getString("idioma"),c));
            }
            return peliculass;
        }catch(Exception e){
            return new ArrayList();
        }finally{
            desconectar();
        }
    }
  /* public boolean existeEstado(Categoria estado) throws SQLException{
        try{
            String sentencia = "select * from v_productos where id = ?";
            conectar();
            PreparedStatement ps = obtenerPS(sentencia);
            ps.setInt(1, estado.getId());
            ResultSet rs = ps.executeQuery();
            return rs.next();
        }catch(Exception e){
            return false;
        }finally{
            desconectar();
        }
    } */
   
    
    
}
