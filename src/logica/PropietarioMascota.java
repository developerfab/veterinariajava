/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/** PropietarioMascota
 * Esta clase se especializa en el caso especifico de la persona que posee una
 * mascota.
 * @author fabricio
 */
public class PropietarioMascota extends Persona{
    
    //ATRIBUTOS
    private Mascota mascota;
    
    //CONSTRUCTOR
    public PropietarioMascota(){
        
    }
    
    //METODOS

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }
    
}
