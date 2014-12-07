/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import base.Conexion;
import java.beans.Statement;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author fabricio
 */
public class Sesion {
    
    //ATRIBUTOS
    private int id_usuario;
    private Persona persona;
    private static Sesion sesion=null;
    private Conexion conexion;
    //CONSTRUCTOR
    private Sesion(){
        
    }
    
    //METODOS
    
    //singleton
    
    /** getSesion
     * Retorna un objeto singleton de tipo sesion
     * @return Sesion 
     */
    public static Sesion getSesion(){
        if(sesion==null){
            sesion = new Sesion();
        }
        return sesion;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    /** iniciarSesion
     * Este metodo inicia sesion para un usuario
     * @param pass
     * @return 
     */
    public int iniciarSesion(String pass) throws SQLException{
        int iniciar_sesion = 0;
        conexion = Conexion.getConexion();
        Connection con = conexion.PrepararBaseDatos();
        java.sql.Statement statement = con.createStatement();
        ResultSet result = statement.executeQuery("select * from REGISTRO");
        while (result.next()) 
        {
            if((result.getInt(1)==getId_usuario())&&(result.getString(4).equals(pass))){
                setId_usuario(result.getInt(1));
                Persona persona = new Persona();
                persona.setNombre(result.getString(2));
                persona.setApellido(result.getString(3));
                persona.setIdentificacion(result.getInt(1));
                setPersona(persona);
                iniciar_sesion=1;
            }
        }
        return iniciar_sesion;
    }

    
}
