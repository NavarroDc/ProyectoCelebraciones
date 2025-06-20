/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ed.davidnavarroc.tarea1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;

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
    
    public ArrayList<Celebracion> buscarPais (String paisIngresado){
        ArrayList<Celebracion> celebracionesEncontradas = new ArrayList<>();
       
        Iterator<Celebracion> itCelebraciones = this.celebraciones.iterator();
        while(itCelebraciones.hasNext()){
            Celebracion celebracionEncontrada = itCelebraciones.next();
            String pais = celebracionEncontrada.getPais().toUpperCase().trim();
            if(pais.contains(paisIngresado.toUpperCase().trim())){
                celebracionesEncontradas.add(celebracionEncontrada);
            }
        }
        return celebracionesEncontradas;
    }
    
    public void editarCelebracion(int id, Date fecha, String descripción, String pais){
        Iterator<Celebracion> itCelebraciones = this.celebraciones.iterator();
        while(itCelebraciones.hasNext()){
            Celebracion celebracionEncontrada = itCelebraciones.next();
            
            if (celebracionEncontrada.getId() == id){
                celebracionEncontrada.setFecha(fecha);
                celebracionEncontrada.setDescripcion(descripción);
                celebracionEncontrada.setPais(pais);
            }
        }
    }
}
