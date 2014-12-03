/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/** Urgencia
 * Este metodo se encarga del caso especial de cita urgencia.
 * @author fabricio
 */
public class Urgencia extends Cita{
    
    //ATRIBUTOS
    private int nivel_urgencia;
    
    //CONSTRUCTOR
    
    public Urgencia(){
        
    }
    
    //METODOS

    public int getNivel_urgencia() {
        return nivel_urgencia;
    }

    public void setNivel_urgencia(int nivel_urgencia) {
        this.nivel_urgencia = nivel_urgencia;
    }
    
    
}
