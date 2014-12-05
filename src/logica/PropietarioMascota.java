/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

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
    
    /** registrar
     * Metodo para registrar el usuario
     * @param pass
     * @param tipo
     * @return 
     */
    public boolean registrar(String pass){
        boolean registro = false;
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {   File file = new File("/Users/fabricio/Documents/fis/archivo_v/"+getIdentificacion());
            file.mkdir();
            fichero = new FileWriter("/Users/fabricio/Documents/fis/archivo_v/"+getIdentificacion()+"/"+getIdentificacion()+".txt");
            pw = new PrintWriter(fichero);
            
            pw.println(pass);
            pw.println("documento:"+getIdentificacion());
            pw.println("nombre:"+getNombre());
            pw.println("apellido:"+getApellido());
            pw.println("tipo:"+1);
            
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
