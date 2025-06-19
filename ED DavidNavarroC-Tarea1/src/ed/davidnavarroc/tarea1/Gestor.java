/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ed.davidnavarroc.tarea1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 *
 * @author angel
 */
public class Gestor {
    
    private ArrayList<Celebracion> celebraciones = new ArrayList<>();
    private int agregarID = 1;
    
    public void registrarCelebracion(Date fecha, String descripcion, String pais){
        Celebracion nuevaCelebracion = new Celebracion(agregarID, fecha, descripcion, pais);
        celebraciones.add(nuevaCelebracion); 
        this.agregarID = this.agregarID + 1;
    }

    public ArrayList<Celebracion> getCelebraciones() {
        return celebraciones;
    }

    public void setCelebraciones(ArrayList<Celebracion> celebraciones) {
        this.celebraciones = celebraciones;
    }

    public int getAgregarID() {
        return agregarID;
    }

    public void setAgregarID(int agregarID) {
        this.agregarID = agregarID;
    }
    
    public void imprimirCelebraciones() {
      for(int i = 0; i < this.celebraciones.size(); i++) {   
        this.celebraciones.get(i).mostrarCelebracion();
        }  
    }
}
