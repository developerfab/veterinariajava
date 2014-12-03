/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/** Persona
 * Clase que contiene la informacion escencial de una persona
 * @author fabricio
 */
public class Persona {
    
    //ATRIBUTOS
    private String nombre;
    private String Apellido;
    private int identificacion;
    //CONSTRUCTOR
    public Persona(){
        
    }
    //METODOS

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }
    
    
}
