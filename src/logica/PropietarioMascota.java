/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import base.Conexion;
import java.sql.Connection;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/** PropietarioMascota
 * Esta clase se especializa en el caso especifico de la persona que posee una
 * mascota.
 * @author fabricio
 */
public class PropietarioMascota extends Persona{
    
    //ATRIBUTOS
    private Mascota mascota;
    private Connection conexion;
    
    //CONSTRUCTOR
    public PropietarioMascota(){
        
    }
    
    //METODOS

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }
    
    /** registrar
     * Metodo para registrar el usuario
     * @param pass
     * @param tipo
     * @return 
     */
    public boolean registrar(String pass){
        boolean registro = false;
        try{
            Conexion conexion_hab = Conexion.getConexion();
            conexion = conexion_hab.PrepararBaseDatos();
            PreparedStatement a = conexion.prepareStatement("INSERT INTO PROPIETARIO VALUES (?,?,?,?)");
            a.setInt(1, getIdentificacion());
            a.setString(2, getNombre());
            a.setString(3, getApellido());
            a.setString(4, pass);
            a.executeUpdate(); 
            registro=true;
        }
        catch(Exception e){
            registro=false;
        }
        
        return registro;
    }
}
