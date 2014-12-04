/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import sun.applet.Main;

/**
 *
 * @author fabricio
 */
public class Conexion {
    
    Connection conexion;

    Statement sentencia;

    public Conexion(){
        
    }
    
    public void PrepararBaseDatos() {

     

        try{

            String controlador="com.mysql.jdbc.Driver";

            Class.forName (controlador).newInstance();

        }

        catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error al cargar el Controlador");

        }

        try {

            String DSN="jdbc:mysql://localhost/veterinaria";

            String user="veterinaria";

            String password="medellin";

            conexion=DriverManager.getConnection(DSN,user,password);

        }

        catch (Exception e) {

            JOptionPane.showMessageDialog(null,"Error al realizar la conexion");

        }

        try {

            sentencia=(Statement) conexion.createStatement(

                    ResultSet.TYPE_SCROLL_INSENSITIVE,

                    ResultSet.CONCUR_READ_ONLY);

        }

        catch (Exception e) {

            JOptionPane.showMessageDialog(null,"Error al crear el objeto sentencia");

        }

     }
    
    
}
