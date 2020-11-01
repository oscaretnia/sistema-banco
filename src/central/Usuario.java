/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package central;

/**
 *
 * @author Sophy
 */
public class Usuario {
    
    private String nombre;    
    private String identificacion;    
    private String clave;
    private String rol;
    
    public Usuario() {
    }

    public Usuario(String identificacion, String nombre, String clave, String rol) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.clave = clave;
        this.rol = rol;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }  
    
    public boolean es(String rol) {
        return this.getRol().equalsIgnoreCase(rol);
    }
    
}
