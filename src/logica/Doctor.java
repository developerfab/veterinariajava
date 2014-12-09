/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import base.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/** Doctor
 * Objeto doctor es un tipo especial de persona, el cual se encarga de atender
 * la mascota de PropietarioMascota.
 * @author fabricio
 */
public class Doctor extends Persona{
    
    //ATRIBUTOS
    
    private String password;
    private int licencia;
    private String especialidad;
    private Connection conexion;
    private Conexion conexion_hab;
    //COSTRUCTOR
    
    public Doctor(){
        
    }
    
    //ATRIBUTOS

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLicencia() {
        return licencia;
    }

    public void setLicencia(int licencia) {
        this.licencia = licencia;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    /** registrar
     * Metodo para registrar el usuario
     * @return boolean true si el registro es exitoso.
     */
    public boolean registrar(){
        boolean registro = false;
        try{
            Conexion conexion_hab = Conexion.getConexion();
            conexion = conexion_hab.PrepararBaseDatos();
            PreparedStatement a = conexion.prepareStatement("INSERT INTO MEDICO VALUES (?,?,?,?)");
            a.setInt(1, getIdentificacion());
            a.setString(2, getNombre());
            a.setInt(3, getLicencia());
            a.setString(4, getEspecialidad());
            a.executeUpdate(); 
            registro=true;
        }
        catch(Exception e){
            registro=false;
        }
        
        return registro;
    }
    
    /** listaDoctor
     *  Se retorna la lista de doctores inscritos en la base de datos. 
     * @return
     * @throws SQLException 
     */
    public ArrayList<Doctor> listaDoctor() throws SQLException{
        ArrayList<Doctor> lista = new ArrayList<>();
        
        conexion_hab = Conexion.getConexion();
        Connection con = conexion_hab.PrepararBaseDatos();
        java.sql.Statement statement = con.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM `MEDICO`");
        while (result.next()) 
        {
            Doctor doctor = new Doctor();
            doctor.setIdentificacion(result.getInt(1));
            doctor.setNombre(result.getString(2));
            doctor.setLicencia(result.getInt(3));
            doctor.setEspecialidad(result.getString(4));
            lista.add(doctor);
            doctor=null;
            
        }
        return lista;
    }
}
