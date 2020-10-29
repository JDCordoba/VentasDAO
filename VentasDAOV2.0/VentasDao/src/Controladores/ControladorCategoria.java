/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Objetos.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class ControladorCategoria {
    Connection con; 
    PreparedStatement ps,ps2;
    ResultSet rs;
    
     public Categoria mostrar(int id){
        Conexion conexion = new Conexion();
        con=conexion.getConexion();
        
        Categoria obj = null;
        

        
        try {
                    ps = con.prepareStatement("select * from categorias where id = ?");
                    
            ps.setInt(1 , id);
            rs = ps.executeQuery();
            while (rs.next()){
            obj = new Categoria(rs.getInt(1),
                    rs.getString(2), rs.getString(3));

                
            }
        } catch (Exception e) {
            System.out.println(e+"categoria");
        }
        
        
        
        return obj;
    
    }
     
         public ArrayList<Categoria> MostrarTodo (){
        Conexion conexion = new Conexion();
        con=conexion.getConexion();
        Categoria obj =null;
        
        ArrayList<Categoria>  alCategoria = new ArrayList<> ();
        
        
          try {
        ps = con.prepareStatement("select * from categorias");
                    
            rs = ps.executeQuery();
            while (rs.next()){
            
             obj = new Categoria(rs.getInt(1),
                     rs.getString(2),
                     rs.getString(3));
            
             alCategoria.add(obj);
                
                
            }
        } catch (Exception e) {
            System.out.println(e+"Categorias");
        }
    return alCategoria;
    }
    
    public void Guardar(Categoria c) {
        Conexion conexion = new Conexion();
        con=conexion.getConexion();
        Categoria obj = new Categoria();
        try {
            con.setAutoCommit(false);
            ps=con.prepareStatement("INSERT INTO public.categorias(\n" +
"	denominacion, descripcion)\n" +
"	VALUES (?, ?);");
            
            
            ps.setString(1,c.getDenominacion());
            ps.setString(2,c.getDescripcion());
          
            if (ps.executeUpdate()>0) {
                con.commit();
        
             }else{con.rollback();}
        } catch (Exception e) { 
            System.out.println("Guardar categoprias"+e);
        }
        
    }      
         
}
