/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import base.Conexion;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import javax.swing.JOptionPane;

/** ConsultaExterna
 * Es un tipo especial de cita.
 * @author fabricio
 */
public class ConsultaExterna extends Cita{
    
    //ATRIBUTOS
    private Date fecha;
    private Doctor doctor;
    private Conexion conexion_hab;
    private Connection conexion;
    private String tipo;
    
    //CONSTRUCTOR
    public ConsultaExterna(){
        
    }
    //METODOS

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    /** guardarcita
     * Este metodo se encarga de almacenar las citas en un archivo
     * @param persona
     * @return 
     */
    public boolean guardarCita(Persona persona){
        boolean confirma = false;
        int num_cita=0;
        try{
            conexion_hab = Conexion.getConexion();
            Connection con = conexion_hab.PrepararBaseDatos();
            java.sql.Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery("SELECT COUNT(*) as total FROM CITA");
            Random rand = new Random();
            while(result.next()){
                num_cita = result.getInt(1)+ rand.nextInt();
                if(num_cita<0){
                    num_cita= num_cita*(-1);
                }
            }
            
            PreparedStatement a = con.prepareStatement("INSERT INTO CITA VALUES (?,?,?,?,?,?,?)");
            a.setInt(1, num_cita+1);
            a.setInt(2, getDoctor().getLicencia());
            a.setString(3, persona.getIdentificacion()+"_"+getMascota().getNombre());
            a.setDate(4, getFecha());
            a.setInt(5, getConsultorio());
            a.setString(6, getTipo());
            a.setString(7, "asignada");
            a.executeUpdate(); 
            confirma=true;
            JOptionPane.showConfirmDialog(null, "Id de su cita: "+(num_cita+1));
        }catch(Exception e){
            confirma=false;
        }
        return confirma;
    }
    
    /** cancelarCita
     * Este metodo se encarga de cancelar una cita asignada.
     * @param id_cita
     * @return
     * @throws SQLException 
     */
    public boolean cancelarCita(String id_cita) throws SQLException{
        boolean registro = false;
        try{
            Conexion conexion_hab = Conexion.getConexion();
            conexion = conexion_hab.PrepararBaseDatos();
            System.out.println("1");
            PreparedStatement a = conexion.prepareStatement("DELETE FROM CITA WHERE id_cita = ?");
            System.out.println("2");
            a.setInt(1, Integer.parseInt(id_cita));
            a.executeUpdate(); 
            System.out.println("3");
            registro=true;
        }
        catch(Exception e){
            registro=false;
        }
        
        return registro;
        
        
    }
    
}
