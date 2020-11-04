/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package central;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sophy
 */

public class Conexion {
    
    private final String URL = "C:\\SQLite\\db\\banco.db";
    private Connection connect;
    
    public Connection connect(){
        try {
            connect = DriverManager.getConnection("jdbc:sqlite:" + URL);
        }catch (SQLException ex) {
            System.err.println("No se ha podido conectar a la base de datos\n" + ex.getMessage());
        }
        
        return connect;
    }
        
    public void close(){
        try {
            connect.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
