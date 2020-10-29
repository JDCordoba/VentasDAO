/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Objetos.TipoCliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class ControladorTipo {
     Connection con;
    PreparedStatement ps, ps2;
    ResultSet rs;
    
    
    public TipoCliente mostrar(int id){
        Conexion conexion = new Conexion();
        con=conexion.getConexion();
        
        TipoCliente obj = null;
        

        
        try {
                    ps = con.prepareStatement("select * from tipo_cliente where id = ?");
                    
            ps.setInt(1 , id);
            rs = ps.executeQuery();
            while (rs.next()){
            obj = new TipoCliente(rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),rs.getString(4),
                    rs.getString(5));

                
            }
        } catch (Exception e) {
            System.out.println(e+"tipo");
        }
        
        
        
        return obj;
    
    }
    
    
      public ArrayList<TipoCliente> MostrarTodo (){
        Conexion conexion = new Conexion();
        con=conexion.getConexion();
        TipoCliente obj =null;
        
        ArrayList<TipoCliente>  alTipo = new ArrayList<> ();
        
        
          try {
        ps = con.prepareStatement("select * from tipo_cliente");
                    
            rs = ps.executeQuery();
            while (rs.next()){
            
             obj = new TipoCliente(rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),rs.getString(4),
                    rs.getString(5));
            
             alTipo.add(obj);
                
                
            }
        } catch (Exception e) {
            System.out.println(e+"Tipo");
        }
    return alTipo;
    }
      
       public void Guardar(TipoCliente t) {
        Conexion conexion = new Conexion();
        con=conexion.getConexion();
        TipoCliente obj = new TipoCliente();
        try {
            con.setAutoCommit(false);
            ps=con.prepareStatement("INSERT INTO public.tipo_cliente(\n" +
"	 nombre, descripcion, consumidor_final, responsable_inscripto)\n" +
"	VALUES ( ?, ?, ?, ?);");
            
            
            ps.setString(1,t.getNombre());
            ps.setString(2,t.getDescripcion());
            ps.setString(3,t.getConsumidorFinal());
            ps.setString(4,t.getResponsableInscripto());
            
            if (ps.executeUpdate()>0) {
                con.commit();
        
             }else{con.rollback();}
        } catch (Exception e) { 
            System.out.println("Guardar Tipo"+e);
        }
        
    }      
      
}
