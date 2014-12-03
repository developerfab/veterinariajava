/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/** ConsultaExterna
 * Es un tipo especial de cita.
 * @author fabricio
 */
public class ConsultaExterna extends Cita{
    
    //ATRIBUTOS
    private String fecha;
    
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
    
    
    
}
