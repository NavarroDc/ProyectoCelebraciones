/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ed.davidnavarroc.tarea1;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author angel
 */
public class Gestor {
    
    private ArrayList<Celebracion> celebraciones = new ArrayList<>();
    private int agregarID = 1;
    
    public void registrarCelebracion(Date fecha, String descripcion, String pais){
        this.agregarID = this.agregarID + 1;
        Celebracion nuevaCelebracion = new Celebracion(agregarID, fecha, descripcion, pais);
        celebraciones.add(nuevaCelebracion); 
    }
}
