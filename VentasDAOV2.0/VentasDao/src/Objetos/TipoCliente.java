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
public class TipoCliente {
    private Integer id;
    private String nombre;
    private String descripcion;
    private String consumidorFinal;
    private String responsableInscripto;

    public TipoCliente() {
    }

    public TipoCliente(Integer id, String nombre, String descripcion, String consumidorFinal, String responsableInscripto) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.consumidorFinal = consumidorFinal;
        this.responsableInscripto = responsableInscripto;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getConsumidorFinal() {
        return consumidorFinal;
    }

    public void setConsumidorFinal(String consumidorFinal) {
        this.consumidorFinal = consumidorFinal;
    }

    public String getResponsableInscripto() {
        return responsableInscripto;
    }

    public void setResponsableInscripto(String responsableInscripto) {
        this.responsableInscripto = responsableInscripto;
    }

    @Override
    public String toString() {
        return  "Tipo=" + descripcion ;
    }
    
    
    
}
