/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package central;


import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sophy
 */

public class Servidor {
    
    public Servidor() {
        try {
            OperacionesBancarias banco = new SistemaBancario();
            Registry registro = LocateRegistry.createRegistry(4444);
            registro.bind("sistemaBancario", banco);
            System.out.println("Servidor Sistema Bancario corriendo en puerto 4444");
        } catch (Exception ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main (String args[]) {        
        new Servidor();
    }
    
}
