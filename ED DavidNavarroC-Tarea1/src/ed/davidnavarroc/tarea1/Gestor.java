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
        this.celebraciones.get(i).mostrarCelebracion();//Por cada celebración en el array celebraciones, se muestran los datos con mostrarCelebración()
        }  
    }
    
    //Busca celebraciones de acuerdo al texto ingresado por el usuario
    public ArrayList<Celebracion> buscarPais (String paisIngresado){
        ArrayList<Celebracion> celebracionesEncontradas = new ArrayList<>();//Array inicializado de celebraciones encontradas
       
        Iterator<Celebracion> itCelebraciones = this.celebraciones.iterator();//Se crea el iterator para recorrer el array de celebraciones
        while(itCelebraciones.hasNext()){//Mientras haya elementos en el array, se obtiene el siguiente (sigue iterando)
            Celebracion celebracionEncontrada = itCelebraciones.next();//Se guarda la siguiente celebración
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
            Celebracion celebracionEncontrada = itCelebraciones.next();//Se obtiene la siguiente celebración
            
            if (celebracionEncontrada.getId() == id){ //Verifica si la celebración actual tiene el mismo ID que la celebración a editar
                celebracionEncontrada.setFecha(fecha);
                celebracionEncontrada.setDescripcion(descripción);
                celebracionEncontrada.setPais(pais);//Si el ID es el mismo, los valores se cambian a los nuevos (editados)
            }
        }
    }
    
    //Función para comparar 2 celebraciones para determinar si la primera es "mayor" que la segunda. Criterios: 1-País/2-Fecha
    public boolean esMayorQue(Celebracion a, Celebracion b) {
        // numero mayor que cero: a > b
        // numero menor que cero: b > a
        int resultadoString = a.getPais().compareTo(b.getPais());//Compara los países alfabéticamente. compareTo() retorna 0 si (a) es depsués que (b)

        if (resultadoString > 0) { //Si el país de (a) es mayor alfabéticamente que (b) retorna true
          return true;
        }

        if (resultadoString < 0) {// Si el país de (a) es menor alfabéticamente que (b) retorna false
          return false;
        }

        else {// De otro modo, si los países son alfabéticamente iguales, se usa la fecha como criterio de comparación
          return a.getFecha().compareTo(b.getFecha()) > 0; //Retorna true si la fecha de (a) es después que la de (b)
        }

    }

    //Función para comparar 2 celebraciones para determinar si la primera es "menor" que la segunda. Criterios: 1-País/2-Fecha
    public boolean esMenorQue(Celebracion a, Celebracion b) {
        // numero mayor que cero: a > b
        // numero menor que cero: b > a
        int resultadoString = a.getPais().compareTo(b.getPais());//Compara los países alfabéticamente.

        if (resultadoString < 0) {//Si el país de (a) va antes que el país de (b) alfabéticamente, entonces (a) es menor
          return true;
        }

        if (resultadoString > 0) {//Si el país de (a) va después que el país de (b) alfabéticamente, entonces (a) es mayor
          return false;
        }

        else {//De otro modo, si los países son alfabéticamente iguales, se usa la fecha como criterio de comnparación
            return a.getFecha().compareTo(b.getFecha()) < 0;//La fecha más antigua es menor
        }
    }
    
    //Función para llevar a cabo el Merge Sort, fusiona 2 mitades de un array de celebraciones. Criterios: 1- Fecha/2- País
    public void mergeArrayList(ArrayList<Celebracion> arr, int l, int m, int r) {
   
    //Tamaños de la sublistas (izquierda y derecha)
    int n1 = m - l + 1;
    int n2 = r - m;

    //Arrays temporales vacíos con el tamaño necesario
    ArrayList<Celebracion> L = new ArrayList<Celebracion>(n1);
    for (int i = 0; i < n1; ++i) {
      L.add(null);//Inicializado en null para evitar errores con set()
    }
    ArrayList<Celebracion> R = new ArrayList<Celebracion>(n2);
    for (int j = 0; j < n2; ++j) {
      R.add(null);//Inicializado en null para evitar errores con set()
    }

    //Se copian los datos de la lista original a los arrays temporales
    for (int i = 0; i < n1; ++i) {
      // L[i] = arr[l + i];
      L.set(i, arr.get(l + i));
    }
    for (int j = 0; j < n2; ++j) {
      // R[j] = arr[m + 1 + j];
      R.set(j, arr.get(m + 1 + j));
    }
    
    //Índices para recorrer arrays temporales
    int i = 0, j = 0;
    int k = l;//Índice inicial ---> fusión del array original
    
    //Fusión de las 2 listas utilizando el método esMyorQue (descendente)
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

   //Si sobran elementos en la lista izquierda, los copia
    while (i < n1) {
      // arr[k] = L[i];
      arr.set(k, L.get(i));
      i++;
      k++;
    }

    //Si sobran elementos en la lista derecha, los copia
    while (j < n2) {
      // arr[k] = R[j];
      arr.set(k, R.get(j));
      j++;
      k++;
    }
  }
    
    //Función para implementar Merge Sort. Ordena una array de celebraciones (descendente. Criterios 1- País/2-Fecha)
    public void mergeSortArrayList(ArrayList<Celebracion> arr, int l, int r) {
    if (l < r) {
      int m = l + (r - l) / 2;//Punto medio

      //Se ordena la primera y la segunda mitad
      mergeSortArrayList(arr, l, m);
      mergeSortArrayList(arr, m + 1, r);
      //Fusiona las mitades ordenadas
      mergeArrayList(arr, l, m, r);
    }
  }
    
    //Función para implementar Insertion Sort. Ordena una array de celebraciones (ascendente. Criterios 1- País/2-Fecha)
    public void insertionSort(ArrayList<Celebracion> arr) {
        int n = arr.size();//Se guarda el tamaño de la lista en (n)
        
        for (int i = 1; i < n; ++i) {//Se recorre la lista desde el índice 1 hasta el final
        Celebracion key = arr.get(i);//Se guarda la celebración actual para insertarla en la posición correspondiente
        
        int j = i - 1;//Para comparar hacia atrás desde el elemento anterior
        
        //Se ejecuta mientras no llegue al inicio de la lista Y el elemento actual sea mayor que la clave
        while (j >= 0 && esMayorQue(arr.get(j), key)) {
            //arr[j + 1] = arr[j];
            arr.set(j+1, arr.get(j));//arr[j] se mueve 1 posición adelante
            j = j - 1;
        }
        //arr[j + 1] = key;
        arr.set(j+1,key);//Se inserta la clave en una posición correcta
    }
  }
}