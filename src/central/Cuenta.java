/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package central;

import java.io.Serializable;

/**
 *
 * @author Sophy
 */
public class Cuenta implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String numero;
    private String propietario;
    private int cantidadDinero;
    private String fechaRegistro;

    public Cuenta(String numero, String propietario, int cantidadDinero, String fechaRegistro) {
        this.numero = numero;
        this.propietario = propietario;
        this.cantidadDinero = cantidadDinero;
        this.fechaRegistro = fechaRegistro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public int getCantidadDinero() {
        return cantidadDinero;
    }

    public void setCantidadDinero(int cantidadDinero) {
        this.cantidadDinero = cantidadDinero;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    } 
    
}
