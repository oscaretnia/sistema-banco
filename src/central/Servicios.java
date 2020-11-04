/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package central;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Sophy
 */
public class Servicios {
    
    private final Conexion conexion;
    
    public Servicios() {
        conexion = new Conexion();
        //crearUsuariosDummy();
    }
        
    public boolean crearCuenta(String numero, String propietario, int cantidadDinero, String fechaRegistro) {
        
        try {
            PreparedStatement st = conexion.connect().prepareStatement("INSERT INTO cuentas (numero, propietario, cantidadDinero, fechaRegistro) VALUES (?,?,?,?)");
            st.setString(1, numero);
            st.setString(2, propietario);
            st.setInt(3, cantidadDinero);
            st.setString(4, fechaRegistro);
            return st.execute();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            conexion.close();
        }
        return false;
    }
    
    public boolean borrarCuenta(String cuenta) {
        
        try {
            PreparedStatement st = conexion.connect().prepareStatement("DELETE FROM cuentas WHERE numero = ?;");
            st.setString(1, cuenta);
            return st.execute();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            conexion.close();
        }
        return false;
    }
    
    public boolean modificarCuenta(String cuenta, String propietario) {
        
        try {
            PreparedStatement st = conexion.connect().prepareStatement("UPDATE cuentas SET propietario = ? WHERE numero = ?;");
            st.setString(1, propietario);
            st.setString(2, cuenta);
            return st.execute();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            conexion.close();
        }
        return false;
    }
    
    public int obtenerSaldo(String cuenta) {
        ResultSet rs;
        try {
            PreparedStatement st = conexion.connect().prepareStatement("SELECT cantidadDinero FROM cuentas WHERE numero = ?;");
            st.setString(1, cuenta);
            rs = st.executeQuery();
            if (rs.next()) return rs.getInt("cantidadDinero");        
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            conexion.close();
        }
        return -1;
    }
    
    public boolean adicionarDinero(String cuenta, int cantidadDinero) {
        int cantidad = 0;
        
        if (obtenerSaldo(cuenta) >= 0) {
            cantidad = obtenerSaldo(cuenta) + cantidadDinero;
        } else {
            return false;
        }
        
        try {
            PreparedStatement st = conexion.connect().prepareStatement("UPDATE cuentas SET cantidadDinero = ? WHERE numero = ?;");
            st.setInt(1, cantidad);
            st.setString(2, cuenta);
            return st.execute();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }finally {
            conexion.close();
        }
        return false;
    }
    
    public boolean retirarDinero(String cuenta, int cantidadDinero) {
        int cantidad = 0;
        
        if (cantidad % 10000 == 0) return false;
        
        if (obtenerSaldo(cuenta) >= 0) cantidad = obtenerSaldo(cuenta) - cantidadDinero;
        else return false;
        
        if (cantidad < 0) return false;
        
        try {
            PreparedStatement st = conexion.connect().prepareStatement("UPDATE cuentas SET cantidadDinero = ? WHERE numero = ?;");
            st.setInt(1, cantidad);
            st.setString(2, cuenta);
            return st.execute();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            conexion.close();
        }
        return false;
    }
    
    public Usuario obtenerUsuario(String id) {
        ResultSet rs;
        Usuario usuario = null;
        try {
            PreparedStatement st = conexion.connect().prepareStatement("SELECT * FROM usuarios WHERE identificacion = ? LIMIT 1;");
            st.setString(1, id);
            rs = st.executeQuery();
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setIdentificacion(rs.getString("identificacion"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setRol(rs.getString("rol"));
                usuario.setClave(rs.getString("clave"));
            }        
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            conexion.close();
        }
        return usuario;
    }
    
    public boolean verificarUsuario(String id, String clave) {
        return obtenerUsuario(id) != null ? this.obtenerUsuario(id).getClave().equals(clave) : false;
    }
    
    private void crearUsuario(String nombre, String identificacion, String clave, String rol) {
        
        try {
            PreparedStatement st = conexion.connect().prepareStatement("INSERT INTO usuarios (nombre, identificacion, clave, rol) VALUES (?,?,?,?)");
            st.setString(1, nombre);
            st.setString(2, identificacion);
            st.setString(3, clave);
            st.setString(4, rol);
            st.executeUpdate();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            conexion.close();
        }
    }
    
    private void crearUsuariosDummy() {
        crearUsuario("Oscar Sepulveda", "1234567890", "12345", "gerente");
        crearUsuario("Sophy Rico", "5432167890", "12345", "cajero");
        crearUsuario("Juliana Diaz", "1234509876", "12345", "cliente");
    }
    
}
