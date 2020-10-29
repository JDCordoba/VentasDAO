/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Objetos.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class ControladorCliente {
      Connection con;
    PreparedStatement ps, ps2;
    ResultSet rs;
    
     public Cliente mostrar(int id) {
        Conexion conexion = new Conexion();
        con=conexion.getConexion();
         Cliente obj = null; 
        ControladorTipo ct = new ControladorTipo();
       
        try {

            ps = con.prepareStatement("select * from clientes where c.id = ?");
                    
            ps.setInt(1 , id);
            rs = ps.executeQuery();
            while (rs.next()){
            
            
           
            
            obj = new Cliente(rs.getInt(1),
                    rs.getString(2),
                    rs.getInt(3), rs.getString(4),
                    ct.mostrar(rs.getInt(5)));

            }
        } catch (Exception e) {
            System.out.println(e+"Cliente");
        }
        
        
        
        return obj;
   
    }
     
     public ArrayList<Cliente> MostrarTodo (){
        Conexion conexion = new Conexion();
        con=conexion.getConexion();
        Cliente obj = null;
       ArrayList<Cliente>  alCliente = new ArrayList<> ();
        ControladorTipo ct = new ControladorTipo();
          try {
        ps = con.prepareStatement("select * from clientes ");
            
            rs = ps.executeQuery();
            while (rs.next()){
            
            obj = new Cliente(rs.getInt(1),
                    rs.getString(2),
                    rs.getInt(3), rs.getString(4),
                    ct.mostrar(rs.getInt(5)));

            
             alCliente.add(obj);
                
                
            }
        } catch (Exception e) {
            System.out.println(e+"Caso");
        }
    return alCliente;
    }
     
     public void Guardar(Cliente c) {
        Conexion conexion = new Conexion();
        con=conexion.getConexion();
        Cliente obj = new Cliente();
        try {
            con.setAutoCommit(false);
            ps=con.prepareStatement("INSERT INTO public.clientes(\n" +
"	 nombre, cuil, razon_social, tipo_cliente_id)\n" +
"	VALUES (?, ?, ?, ?);");
            
            
            ps.setString(1,c.getNombre());
            ps.setInt(2,c.getCuil());
            ps.setString(3,c.getRazonSocial());
            ps.setInt(4,c.getTipo().getId());
          
            if (ps.executeUpdate()>0) {
                con.commit();
        
             }else{con.rollback();}
        } catch (Exception e) { 
            System.out.println("Guardar clientes"+e);
        }
        
    }
}
