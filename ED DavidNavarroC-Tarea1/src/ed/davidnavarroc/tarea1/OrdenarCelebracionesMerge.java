/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ed.davidnavarroc.tarea1;

//Librerias
import java.text.SimpleDateFormat;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author angel
 */
public class OrdenarCelebracionesMerge extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(OrdenarCelebracionesMerge.class.getName());
    private Gestor gestor;//Referencia del gestor centralizado

    /**
     * Creates new form OrdenarCelebraciones
     */
    
    //Esta función implementa el Merge Sort y carga las listas ordenadas
    public void cargarOrdenadasMerge (){
        // Llama al método del gestor que realiza el ordenamiento por Merge Sort sobre la lista de celebraciones
        gestor.mergeSortArrayList(gestor.getCelebraciones(), 0, gestor.getCelebraciones().size() - 1);
        
        DefaultTableModel modeloTabla = (DefaultTableModel) tablaOrdenarMerge.getModel();//Modelo tabla
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy/MM/dd");//Formato de la fecha
        
        Iterator<Celebracion> iterarCelebrarciones = gestor.getCelebraciones().iterator();//Iterador que recorre la celebraciones ordenadas
        while (iterarCelebrarciones.hasNext()){ // Recorre la lista y agrega cada celebración como una fila en la tabla

            Celebracion datoCelebracion = iterarCelebrarciones.next();
             // Agrega una fila con los datos de la celebración
            modeloTabla.addRow(new Object[]{
                datoCelebracion.getId(),
                formatoFecha.format(datoCelebracion.getFecha()),//Fecha formateada
                datoCelebracion.getDescripcion(),
                datoCelebracion.getPais()
            });
        }
    }
    
    public OrdenarCelebracionesMerge(Gestor gestor) {//Método público para compartir la misma instancia con otras ventanas
        this.gestor = gestor;//Asigna la instancia del gestor recibida al atributo local de la clase
        initComponents();
        cargarOrdenadasMerge (); //Invoca al método que ordena las celebraciones con Merge Sort y las muestra en la tabla

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaOrdenarMerge = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaOrdenarMerge.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Fecha", "Descripción", "País"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaOrdenarMerge);

        jLabel1.setText("MergeSort");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(346, 346, 346))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaOrdenarMerge;
    // End of variables declaration//GEN-END:variables
}
