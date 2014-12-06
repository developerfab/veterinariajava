
import base.Conexion;
import interfaz.Login;
import interfaz.VentanaPrincipal;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author fabricio
 */
public class Launcher {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        Conexion conexion;
        conexion = Conexion.getConexion();
        conexion.PrepararBaseDatos();
        Login login = new Login();
        login.setVisible(true);
    }
    
}
