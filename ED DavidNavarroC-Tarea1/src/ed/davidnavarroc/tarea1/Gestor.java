/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ed.davidnavarroc.tarea1;

//Librerias
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;

/**
 *
 * @author angel
 */
public class Gestor {
    
    //Inicialización del Array celebraciones y el contador de ID
    private ArrayList<Celebracion> celebraciones = new ArrayList<>();
    private int agregarID = 1;
    
    //Método para registrar una nueva celebreación
    public void registrarCelebracion(Date fecha, String descripcion, String pais){
        Celebracion nuevaCelebracion = new Celebracion(agregarID, fecha, descripcion, pais);
        celebraciones.add(nuevaCelebracion); 
        this.agregarID = this.agregarID + 1; //ID único
    }
    
    //Getters y Setters
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
    
    //Este método se relaciona con mostrarCelebracion() para hacer pruebas en consola con los datos
    public void imprimirCelebraciones() {
      for(int i = 0; i < this.celebraciones.size(); i++) {   
        this.celebraciones.get(i).mostrarCelebracion();
        }  
    }
    
    //Busca celebraciones de acuerdo al texto ingresado por el usuario
    public ArrayList<Celebracion> buscarPais (String paisIngresado){
        ArrayList<Celebracion> celebracionesEncontradas = new ArrayList<>();//Array inicializado de celebraciones encontradas
       
        Iterator<Celebracion> itCelebraciones = this.celebraciones.iterator();//Se crea el iterator para recorrer el array de celebraciones
        while(itCelebraciones.hasNext()){//Mientras haya elementos en el array, se obtiene el siguiente
            Celebracion celebracionEncontrada = itCelebraciones.next();
            String pais = celebracionEncontrada.getPais().toUpperCase().trim();//Se obtiene el país de la celebración, se pasan las letras a mayúsculas y se eliminan espacios
            if(pais.contains(paisIngresado.toUpperCase().trim())){//Si la string el país contiene caracteres que coindicen con el input del usuario, se agrega a celebracionesEncontradas
                celebracionesEncontradas.add(celebracionEncontrada);
            }
        }
        return celebracionesEncontradas; //Retorna las celebraciones encontradas
    }
    
    //Función para editar una celebración existente de acuerdo a su ID
    public void editarCelebracion(int id, Date fecha, String descripción, String pais){
        Iterator<Celebracion> itCelebraciones = this.celebraciones.iterator();//Iterator para recorrer la lista de celebraciones
        while(itCelebraciones.hasNext()){//Mientras haya elementos en el array, se obtiene el siguiente
            Celebracion celebracionEncontrada = itCelebraciones.next();
            
            if (celebracionEncontrada.getId() == id){ //Verifica si la celebración actual tiene el mismo ID que la celebración a editar
                celebracionEncontrada.setFecha(fecha);
                celebracionEncontrada.setDescripcion(descripción);
                celebracionEncontrada.setPais(pais);//Si el ID es el mismo, los valors se cambian a los nuevos (editados)
            }
        }
    }
    
    public boolean esMayorQue(Celebracion a, Celebracion b) {
        // numero mayor que cero: a > b
        // numero menor que cero: b > a
        int resultadoString = a.getPais().compareTo(b.getPais());

        if (resultadoString > 0) {
          return true;
        }

        if (resultadoString < 0) {
          return false;
        }

        else {
          return a.getFecha().compareTo(b.getFecha()) > 0;
        }

    }

    public boolean esMenorQue(Celebracion a, Celebracion b) {
        // numero mayor que cero: a > b
        // numero menor que cero: b > a
        int resultadoString = a.getPais().compareTo(b.getPais());

        if (resultadoString < 0) {
          return true;
        }

        if (resultadoString > 0) {
          return false;
        }

        else {
            return a.getFecha().compareTo(b.getFecha()) < 0;
        }
    }
    
    public void mergeArrayList(ArrayList<Celebracion> arr, int l, int m, int r) {
    // Find sizes of two subarrays to be merged
    int n1 = m - l + 1;
    int n2 = r - m;

    // Create temp ArrayLists
    ArrayList<Celebracion> L = new ArrayList<Celebracion>(n1);
    for (int i = 0; i < n1; ++i) {
      L.add(null);
    }

    ArrayList<Celebracion> R = new ArrayList<Celebracion>(n2);
    for (int j = 0; j < n2; ++j) {
      R.add(null);
    }

    // Copy data to temp arrays
    for (int i = 0; i < n1; ++i) {
      // L[i] = arr[l + i];
      L.set(i, arr.get(l + i));
    }
    for (int j = 0; j < n2; ++j) {
      // R[j] = arr[m + 1 + j];
      R.set(j, arr.get(m + 1 + j));
    }

    // Merge the temp arrays

    // Initial indices of first and second subarrays
    int i = 0, j = 0;

    // Initial index of merged subarray array
    int k = l;
    while (i < n1 && j < n2) {
      // L[i] > R[j]
      if (esMayorQue(L.get(i), R.get(j))) {
        // arr[k] = L[i];
        arr.set(k, L.get(i));
        i++;
      } else {
        // arr[k] = R[j];
        arr.set(k, R.get(j));
        j++;
      }
      k++;
    }

    // Copy remaining elements of L[] if any
    while (i < n1) {
      // arr[k] = L[i];
      arr.set(k, L.get(i));
      i++;
      k++;
    }

    // Copy remaining elements of R[] if any
    while (j < n2) {
      // arr[k] = R[j];
      arr.set(k, R.get(j));
      j++;
      k++;
    }
  }
    
    public void mergeSortArrayList(ArrayList<Celebracion> arr, int l, int r) {
    if (l < r) {

      // Find the middle point
      int m = l + (r - l) / 2;

      // Sort first and second halves
      mergeSortArrayList(arr, l, m);
      mergeSortArrayList(arr, m + 1, r);

      // Merge the sorted halves
      mergeArrayList(arr, l, m, r);
    }
  }
    
    public void insertionSort() {
    ArrayList<Celebracion> arr = this.celebraciones;
    int n = arr.size();
    for (int i = 1; i < n; ++i) {
      Celebracion key = arr.get(i);
      int j = i - 1;
      /*
       * Move elements of arr[0..i-1], that are
       * greater than key, to one position ahead
       * of their current position
       */
      while (j >= 0 && esMayorQue(key, arr.get(j))) {
        arr.set(j + 1, arr.get(j));
        j = j - 1;
      }
      arr.set(j + 1, key);
    }
  }
}
