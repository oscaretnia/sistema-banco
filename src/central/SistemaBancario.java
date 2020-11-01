/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package central;

import java.rmi.RemoteException;

/**
 *
 * @author Sophy
 */
public class SistemaBancario implements OperacionesBancarias {

    private final Servicios servicio;
    
    public SistemaBancario()  throws RemoteException {
        super();servicio = new Servicios();        
    }

    @Override
    public int crearCuenta(String numero, String propietario, int cantidadDinero, String fechaRegistro) throws RemoteException {
        return servicio.crearCuenta(numero, propietario, cantidadDinero, fechaRegistro) ? 5 : 1;
    }

    @Override
    public int borrarCuenta(String cuenta) throws RemoteException {
        return servicio.borrarCuenta(cuenta) ? 5 : 1;
    }

    @Override
    public int modificarCuenta(String cuenta, String propietario) throws RemoteException {
        return servicio.modificarCuenta(cuenta, propietario) ? 5 : 1;
    }

    @Override
    public int adicionarDinero(String cuenta, int cantidadDinero) throws RemoteException {
        return servicio.adicionarDinero(cuenta, cantidadDinero) ? 5 : 1;
    }

    @Override
    public int retirarDinero(String cuenta, int cantidadDinero) throws RemoteException {
        return servicio.retirarDinero(cuenta, cantidadDinero) ? 5 : 1;
    }

    @Override
    public String obtenerSaldo(String cuenta) throws RemoteException {
        int saldo = servicio.obtenerSaldo(cuenta);        
        return saldo >= 0 ? "5:" + saldo : "1";
    }   

    @Override
    public Usuario obtenerUsuario(String id) throws RemoteException {
        return servicio.obtenerUsuario(id);
    }

    @Override
    public boolean verificarUsuario(String id, String clave) throws RemoteException {
        return servicio.verificarUsuario(id, clave);
    }
}
