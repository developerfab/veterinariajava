/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import sun.applet.Main;

/**
 *
 * @author fabricio
 */
public class Conexion {
    
    private Connection conexion;

    private Statement sentencia;
    
    private static Conexion objConexion=null;
    

    private Conexion(){
        
    }
    
    public static Conexion getConexion() throws SQLException{
        if(objConexion==null){
            objConexion = new Conexion();
            
        }
        return objConexion;
    }
    
    //conexion con la base de datos
    public Connection PrepararBaseDatos() throws SQLException {

     

        try{

            String controlador="com.mysql.jdbc.Driver";

            Class.forName (controlador).newInstance();

        }

        catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error al cargar el Controlador");

        }

        try {

            String DSN="jdbc:mysql://127.0.0.1:3306/veterinaria";

            String user="veterinaria";

            String password="medellin";

            conexion=DriverManager.getConnection(DSN,user,password);
            
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al realizar la conexion");
        }
        return conexion;
   }
}