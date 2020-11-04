/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente3;

import central.OperacionesBancarias;
import central.Usuario;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sophy
 */
public class Middleware {
    
    private Usuario usuario;
    private final OperacionesBancarias control;
    
    public Middleware(String id) {
        control = new Cliente().getBanco();
        obtenerUsuario(id);
    }
    
    public boolean crearCuenta() {
        return usuario.es("gerente");
    }
    
    public boolean borrarCuenta() {
        return usuario.es("gerente");
    }
    
    public boolean modificarCuenta() {
        return usuario.es("gerente");
    }
    
    public boolean adicionarDinero() {
        return usuario.es("gerente") ? true : usuario.es("cajero");
    }
    
    public boolean retirarDinero() {
        return usuario.es("gerente") ? true : usuario.es("cajero") ? true : usuario.es("cliente");
    }
    
    public boolean puedeObtenerSaldo() {
        return usuario.es("gerente") ? true : usuario.es("cajero") ? true : usuario.es("cliente");
    }  
    
    private void obtenerUsuario(String id) {
        try {
            usuario = control.obtenerUsuario(id);
        } catch (RemoteException ex) {
            Logger.getLogger(Middleware.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
