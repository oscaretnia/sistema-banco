/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package central;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Sophy
 */

public interface OperacionesBancarias extends Remote {
    
    public int crearCuenta(String numero, String propietario, int cantidadDinero, String fechaRegistro) throws RemoteException;
    
    public int borrarCuenta(String cuenta) throws RemoteException;

    public int modificarCuenta(String cuenta, String propietario) throws RemoteException;
    
    public int adicionarDinero(String cuenta, int cantidadDinero) throws RemoteException;
    
    public int retirarDinero(String cuenta, int cantidadDinero) throws RemoteException;
    
    public String obtenerSaldo(String cuenta) throws RemoteException;
    
    public Usuario obtenerUsuario(String id) throws RemoteException;
    
    public boolean verificarUsuario(String id, String clave) throws RemoteException;

}
