/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.SQLException;
import logica.Mascota;
import logica.Persona;
import logica.PropietarioMascota;
import logica.Sesion;
import java.util.ArrayList;
import logica.ConsultaExterna;
import logica.Doctor;

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
    public boolean logeo(String id_usuario, String pass) throws SQLException{
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
    
    /** registrarMedico
     * Este metodo se encarga de recibir los datos de la capa de interfaz y 
     * enviarlos a la capa de logica en la clase de Doctor.
     * @param nombre
     * @param documento
     * @param licencia
     * @param especialidad
     * @return 
     */
    public boolean registrarMedico(String nombre, String documento, int licencia, String especialidad){
        boolean registro = false;
        Doctor doctor = new Doctor();
        doctor.setEspecialidad(especialidad);
        doctor.setLicencia(licencia);
        doctor.setNombre(nombre);
        doctor.setIdentificacion(Integer.parseInt(documento));
        doctor.registrar();
        registro = true;
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
    /** verMascotas
     *  Metodo para ver las mascotas de un usuario
     * @return 
     */
    public ArrayList<String> verMascotas() throws SQLException{
        ArrayList<String> listaMascotas = new ArrayList<>();
        sesion = Sesion.getSesion();
        Mascota mascota = new Mascota();
        mascota.setPropietario(sesion.getPersona());
        mascota.setPropietario(sesion.getPersona());
        for(int i=0;i<mascota.listaMascota().size();i++){
            listaMascotas.add(mascota.listaMascota().get(i).getNombre());
        }
        
        return listaMascotas;
    }
    
    /** verDoctores
     * Este metodo pide a la capa logica la lista de doctores inscritos
     * en la base de datos
     * @return
     * @throws SQLException 
     */
    public ArrayList<String> verDoctores() throws SQLException{
        ArrayList<String> lista = new ArrayList<>();
        Doctor doctor = new Doctor();
        for(int i=0; i<doctor.listaDoctor().size();i++){
            lista.add(doctor.listaDoctor().get(i).getNombre());
        }
        return lista;
    }
    
    /** asignarCita
     *  Este metodo se encarga de asignar la cita de una mascota
     * @return 
     */
    public boolean asignarCita(String fecha, String doctor, String tipo, String mascota){
        boolean confirma=false;
        sesion = Sesion.getSesion();
        Mascota mascotaobj = new Mascota();
        mascotaobj.setPropietario(sesion.getPersona());
        mascotaobj.setNombre(mascota);
        mascotaobj.traerMascota(sesion.getPersona().getIdentificacion());
        ConsultaExterna externa = new ConsultaExterna();
        externa.setDoctor(doctor);
        externa.setFecha(fecha);
        externa.setTipo(tipo);
        externa.setMascota(mascotaobj);
        confirma = externa.guardarCita(sesion.getPersona());
        return confirma;
    }
}
