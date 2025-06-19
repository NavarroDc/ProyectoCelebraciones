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
    
    private int id;
    private Date fecha;
    private String descripcion;
    private String pais;

    public Celebracion(int id, Date fecha, String descripcion, String pais) {
        this.id = id;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.pais = pais;
    }

    public int getId() {
        return id;
    }

   //Acá se borró set ID porque no es editable

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
    
    public void mostrarCelebracion(){
        System.out.println(Integer.toString(id) + " " + fecha.toString() + " " + descripcion + " "+pais);
    }
}
