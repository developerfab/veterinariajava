/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/** Cita
 * Esta clase es la que se encarga de contener la informacion más general de una
 * cita.
 * @author fabricio
 */
public class Cita {
    
    //ATRIBUTOS
    private Mascota mascota;
    private String descripcion;
    private int consultorio;
    
    //CONSTRUCTOR
    public Cita(){
        
    }
    //METODOS

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setConsultorio(int consultorio) {
        this.consultorio = consultorio;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getConsultorio() {
        return consultorio;
    }
    
    /** tipoCita
     * Este metodo se encarga de consultar y retornar los diferentes tipos de 
     * cita existentes
     * @return 
     */
    public String[] tipoCita(){
        String[] tipo = {"Consulta Externa","Urgencia", "Cirugia"};
        return tipo;
    }
}
