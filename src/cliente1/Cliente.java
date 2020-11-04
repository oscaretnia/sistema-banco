/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente1;

import central.OperacionesBancarias;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sophy
 */
public class Cliente {
    
    private OperacionesBancarias banco;
    
    public Cliente() {
        conectarServidor();
    }
                
    private void conectarServidor() {
        try {
            Registry registro = LocateRegistry.getRegistry("localhost", 4444);
            banco = (OperacionesBancarias) registro.lookup("sistemaBancario");
        } catch (RemoteException | NotBoundException re) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, re);
        }
    }
    
    public OperacionesBancarias getBanco() {
        return banco;
    }
    
}
