/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import central.Usuario;

/**
 *
 * @author Sophy
 */
public class Middleware {
    
    public static boolean puedeCrearCuenta(Usuario usuario) {
        return usuario.es("gerente");
    }
    
    public static boolean puedeBorrarCuenta(Usuario usuario) {
        return usuario.es("gerente");
    }
    
    public static boolean puedeModificarCuenta(Usuario usuario) {
        return usuario.es("gerente");
    }
    
    public static boolean puedeAdicionarDinero(Usuario usuario) {
        return usuario.es("gerente") ? true : usuario.es("cajero");
    }
    
    public static boolean puedeRetirarDinero(Usuario usuario) {
        return usuario.es("gerente") ? true : usuario.es("cajero") ? true : usuario.es("cliente");
    }
    
    public static boolean puedeObtenerSaldo(Usuario usuario) {
        return usuario.es("gerente") ? true : usuario.es("cajero") ? true : usuario.es("cliente");
    }  
    
}
