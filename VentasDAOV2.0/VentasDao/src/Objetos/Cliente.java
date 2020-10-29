/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

/**
 *
 * @author Usuario
 */
public class Cliente {
    
    private Integer id;
    private String nombre;
    private Integer cuil;
    private String razonSocial;
    
   private TipoCliente tipo;

    public Cliente() {
    }

    public Cliente(Integer id, String nombre, Integer cuil, String razonSocial, TipoCliente tipo) {
        this.id = id;
        this.nombre = nombre;
        this.cuil = cuil;
        this.razonSocial = razonSocial;
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCuil() {
        return cuil;
    }

    public void setCuil(Integer cuil) {
        this.cuil = cuil;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public TipoCliente getTipo() {
        return tipo;
    }

    public void setTipo(TipoCliente tipo) {
        this.tipo = tipo;
    }

   
    

   

    
    
    
}
