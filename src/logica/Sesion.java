/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 *
 * @author fabricio
 */
public class Sesion {
    
    //ATRIBUTOS
    private int id_usuario;
    private Persona persona;
    private static Sesion sesion=null;
    
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
    public int iniciarSesion(String pass){
        int iniciar_sesion = 0;
        //se comprueba si el usuario existe
        File archivo = new File ("/Users/fabricio/Documents/fis/archivo_v/"+getId_usuario()+"/"+getId_usuario()+".txt");
        try{
            FileReader fr = new FileReader (archivo);
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            String[] contenido = new String[6];
            contenido[0]=linea;
            int i =1;
            while((linea=br.readLine())!=null){
                contenido[i]=linea;
                i++;
            }
            if(contenido[0].equals(pass)){
                iniciar_sesion=1;
            }  
            
            Persona persona = new PropietarioMascota();
            persona.setNombre(contenido[2].split("nombre:")[1]);
            persona.setIdentificacion(Integer.parseInt(contenido[1].split("documento:")[1]));
            persona.setApellido(contenido[3].split("apellido:")[1]);
            
            setPersona(persona);
        }
        catch(Exception e){
            iniciar_sesion =-1;
        }
        
        return iniciar_sesion;
    }

    
}
