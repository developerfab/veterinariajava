/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import base.Conexion;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author fabricio
 */
public class Mascota {
    
    //ATRIBUTOS
    private String nombre;
    private Persona propietario;
    private String tipo;
    private Connection conexion;
    
    //CONSTRUCTOR
    public Mascota(){
        
    }
    
    //METODOS

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Persona getPropietario() {
        return propietario;
    }

    public void setPropietario(Persona propietario) {
        this.propietario = propietario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    /** registrar
     * Este es un metodo que se encarga de registrar una mascota
     * @return 
     */
    public boolean registrar(){
        boolean registro = false;
        Sesion sesion = Sesion.getSesion();
        setPropietario(sesion.getPersona());
        System.out.println("asdf: "+getPropietario().getIdentificacion());
        try{
            System.out.println("1");
            Conexion conexion_hab = Conexion.getConexion();
            System.out.println("2");
            conexion = conexion_hab.PrepararBaseDatos();
            System.out.println("3");
            PreparedStatement a = conexion.prepareStatement("INSERT INTO MASCOTA VALUES (?,?,?)");
            System.out.println("4: "+getPropietario().getIdentificacion());
            a.setInt(1,getPropietario().getIdentificacion());
            System.out.println("5");
            a.setString(2, getNombre());
            System.out.println("6");
            a.setString(3, getTipo());
            System.out.println("7");
            a.executeUpdate(); 
            System.out.println("8");
            registro=true;
        }
        catch(Exception e){
            registro=false;
        }
        return registro;
    }
    
    /** listaMascota
     *  retorna la lista de mascotas de un usuario
     * @return 
     */
    public ArrayList<String> listaMascota(){
        ArrayList<String> lista = new ArrayList<>();
        File folder = new File("/Users/fabricio/Documents/fis/archivo_v/"+getPropietario().getIdentificacion()+"/mascotas/");
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                lista.add(file.getName().split(".txt")[0]);
            }
        }
        return lista;
    }
    /** traerMascota
     * Se asigna los datos faltantes
     * @param idUsuario 
     */
    public void traerMascota(int idUsuario){
        
        //se comprueba si el usuario existe
        File archivo = new File ("/Users/fabricio/Documents/fis/archivo_v/"+idUsuario+"/"+getNombre()+".txt");
        try{
            FileReader fr = new FileReader (archivo);
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            String[] contenido = new String[6];
            contenido[0]=linea;
            int i =0;
            while((linea=br.readLine())!=null){
                contenido[i]=linea;
                i++;
            }
            setTipo(contenido[2].split("tipo:")[1]);
        }
        catch(Exception e){
            
        }
    }
}
