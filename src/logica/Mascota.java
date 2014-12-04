/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author fabricio
 */
public class Mascota {
    
    //ATRIBUTOS
    private String nombre;
    private Persona propietario;
    private String tipo;
    
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
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("/Users/fabricio/Documents/fis/archivo_v/mascotas/"+getPropietario().getIdentificacion()+"_"+getNombre()+".txt");
            pw = new PrintWriter(fichero);
            
            pw.println("id:"+getPropietario().getIdentificacion()+"_"+getNombre());
            pw.println("nombre:"+getNombre());
            pw.println("tipo:"+getTipo());
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
            if (null != fichero)
                fichero.close();
                registro = true;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return registro;
    }
}
