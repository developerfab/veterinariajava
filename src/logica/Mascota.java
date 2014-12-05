/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

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
        {   File file = new File("/Users/fabricio/Documents/fis/archivo_v/"+getPropietario().getIdentificacion()+"/mascotas/");
            file.mkdir();
            fichero = new FileWriter("/Users/fabricio/Documents/fis/archivo_v/"+getPropietario().getIdentificacion()+"/mascotas/"+getNombre()+".txt");
            
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
    
    /** listaMascota
     *  retorna la lista de mascotas de un usuario
     * @return 
     */
    public ArrayList<String> listaMascota(){
        ArrayList<String> lista = new ArrayList<>();
        File folder = new File("/Users/fabricio/Documents/fis/archivo_v/"+getPropietario().getIdentificacion()+"/mascotas/");
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                lista.add(file.getName().split(".txt")[0]);
            }
        }
        return lista;
    }
    /** traerMascota
     * Se asigna los datos faltantes
     * @param idUsuario 
     */
    public void traerMascota(int idUsuario){
        
        //se comprueba si el usuario existe
        File archivo = new File ("/Users/fabricio/Documents/fis/archivo_v/"+idUsuario+"/"+getNombre()+".txt");
        try{
            FileReader fr = new FileReader (archivo);
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            String[] contenido = new String[6];
            contenido[0]=linea;
            int i =0;
            while((linea=br.readLine())!=null){
                contenido[i]=linea;
                i++;
            }
            setTipo(contenido[2].split("tipo:")[1]);
        }
        catch(Exception e){
            
        }
    }
}
