/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

/** ConsultaExterna
 * Es un tipo especial de cita.
 * @author fabricio
 */
public class ConsultaExterna extends Cita{
    
    //ATRIBUTOS
    private String fecha;
    private String doctor;
    private String tipo;
    
    //CONSTRUCTOR
    public ConsultaExterna(){
        
    }
    //METODOS

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
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
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {   File file = new File("/Users/fabricio/Documents/fis/fecha/");
            file.mkdir();
            fichero = new FileWriter("/Users/fabricio/Documents/fis/fecha/fecha.txt");
            pw = new PrintWriter(fichero);
            
            pw.println(persona.getIdentificacion()+":"+getFecha()+":"+getDoctor()+":"+getTipo()+":"+getMascota().getNombre());
            
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
            if (null != fichero)
                fichero.close();
                confirma = true;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        
        return confirma;
    }
    
}
