/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import logica.Mascota;
import logica.Persona;
import logica.PropietarioMascota;
import logica.Sesion;

/** Controlador
 * Esta clase es la encargada de comunicar la interfaz con la logica de la 
 * aplicacion.
 * @author fabricio
 */
public class Controlador {
    
    //ATRIBUTOS
    
    private Sesion sesion ;
    
    //CONSTRUCTOR
    
    public Controlador(){
        
    }
    //METODOS
    /** logeo
     * Este metodo se encarga de confirmar el logeo del usuario
     * @param id_usuario
     * @param pass
     * @return 
     */
    public boolean logeo(String id_usuario, String pass){
        boolean login = false;
        sesion = Sesion.getSesion();
        sesion.setId_usuario(Integer.parseInt(id_usuario));
        int rta = sesion.iniciarSesion(pass);
        if(rta ==1){
            login = true;
        }
        return login;
    }
    
    /** registrarUsuario
     *  Este metodo llama al registro de usuario en Persona
     * @param nombre
     * @param documento
     * @param pass
     * @return 
     */
    public boolean registrarUsuario(String nombre, String apellido ,String documento, String pass, int tipo){
        boolean registro=false;
        sesion = Sesion.getSesion();
        if(tipo==1){
            PropietarioMascota persona = new PropietarioMascota();
            persona.setIdentificacion(Integer.parseInt(pass));
            persona.setNombre(nombre);
            persona.setApellido(apellido);
            sesion.setPersona((Persona)persona);
            persona.registrar(pass);
            registro = true;
        }
        
        return registro;
    }
    
    /** registrarMascota
     * Se envian los datos desde la interfaz a la logica del registro
     * @param nombre
     * @param tipo
     * @return 
     */
    public boolean registrarMascota(String nombre, String tipo){
        boolean respuesta = false;
        Mascota mascota = new Mascota();
        mascota.setNombre(nombre);
        mascota.setTipo(tipo);
        sesion = Sesion.getSesion();
        mascota.setPropietario(sesion.getPersona());
        if(mascota.registrar()){
            respuesta = true;
        }
        return respuesta;
    }
}
