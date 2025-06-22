/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ed.davidnavarroc.tarea1;

import java.util.Date;

/**
 *
 * @author angel
 */
public class Celebracion {
    //Propiedades de cada celebración
    private int id;
    private Date fecha;
    private String descripcion;
    private String pais;

    //Constructor de la clase Celebración
    //Crea una nueva celebración con los datos especificados
    public Celebracion(int id, Date fecha, String descripcion, String pais) {
        this.id = id;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.pais = pais;
    }

    //Getters y Setters
    public int getId() {
        return id;
    }

   //ID no es editable

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    
    //Método para probar el almacenamiento de los datos
    public void mostrarCelebracion(){
        System.out.println(Integer.toString(id) + " " + fecha.toString() + " " + descripcion + " "+pais);
    }
    
    //Función recursiva para invertir palabras (países)
    private String invertirPalabra(String palabra){
        if(palabra == null || palabra.length()<=1){ //Si el valor es null o tiene 1 caracter se devuelve la misma
            return palabra;
        }else{
            return this.invertirPalabra(palabra.substring(1))  + palabra.charAt(0); //Invierte el resto de la palabra y concatena el primer carácter al final
        }
    }  
    
    //Devuelve la palabra invertidad por medio de la función recursiva
    public String invertirPaises(){
        return this.invertirPalabra(this.pais);
    }
    
}
