
package Vista;
import Modelo.Mesa;
import Modelo.Reserva;
import Persistencia.MesaData;
import Persistencia.ReservaData;

import java.sql.Connection;
import Persistencia.Conexion;


import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel; // (1).modelo-tabla

public class MeseroGReservas extends javax.swing.JPanel {
  private  Connection con; /* variable q tendra la conexion */ 
  private  MesaData mesaData; 
  private ReservaData reservaData;
  private DefaultTableModel modelo = new DefaultTableModel(); // (2).tabla
  
  //constructor 
  public MeseroGReservas() {
    initComponents();
    this.con = Conexion.getConexion(); //Obtener la conexion y guardarla.
    this.mesaData = new MesaData(con);
    this.reservaData = new ReservaData(con);
    
    armarCabecera();
    cargarDatos();
  }

  
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jLabel6 = new javax.swing.JLabel();
    jScrollPane1 = new javax.swing.JScrollPane();
    jtReservas = new javax.swing.JTable();
    jLabel2 = new javax.swing.JLabel();
    jSeparator1 = new javax.swing.JSeparator();
    jLabel7 = new javax.swing.JLabel();
    jcbSector = new javax.swing.JComboBox<>();
    jPanel1 = new javax.swing.JPanel();
    jPanel2 = new javax.swing.JPanel();
    jLabel8 = new javax.swing.JLabel();
    jLabel1 = new javax.swing.JLabel();
    jRadioButton1 = new javax.swing.JRadioButton();
    jRadioButton2 = new javax.swing.JRadioButton();
    jSpinner1 = new javax.swing.JSpinner();
    jLabel4 = new javax.swing.JLabel();
    jDateChooser1 = new com.toedter.calendar.JDateChooser();
    jLabel10 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    jButton1 = new javax.swing.JButton();
    jSeparator2 = new javax.swing.JSeparator();
    jPanel3 = new javax.swing.JPanel();
    jLabel5 = new javax.swing.JLabel();
    jSeparator3 = new javax.swing.JSeparator();
    jLabel9 = new javax.swing.JLabel();
    jTextField1 = new javax.swing.JTextField();

    setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jLabel6.setFont(new java.awt.Font("Franklin Gothic Medium", 3, 18)); // NOI18N
    jLabel6.setForeground(new java.awt.Color(0, 204, 0));
    jLabel6.setText("Gestion  Reservas");
    add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, -1, -1));

    jtReservas.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null}
      },
      new String [] {
        "Title 1", "Title 2", "Title 3", "Title 4"
      }
    ));
    jScrollPane1.setViewportView(jtReservas);

    add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 730, 180));

    jLabel2.setFont(new java.awt.Font("Franklin Gothic Medium", 3, 18)); // NOI18N
    jLabel2.setText("LISTA DE RESERVAS");
    add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 280, 170, -1));
    add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 300, 200, 10));

    jLabel7.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
    jLabel7.setForeground(new java.awt.Color(204, 0, 0));
    jLabel7.setText(" Sector:");
    add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

    jcbSector.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
    add(jcbSector, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 100, -1));

    jPanel1.setBackground(new java.awt.Color(255, 204, 153));
    jPanel1.setForeground(new java.awt.Color(255, 204, 153));

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 230, Short.MAX_VALUE)
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 220, Short.MAX_VALUE)
    );

    add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 50, 230, 220));

    jPanel2.setBackground(new java.awt.Color(255, 204, 153));
    jPanel2.setForeground(new java.awt.Color(255, 204, 153));
    jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jLabel8.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
    jLabel8.setForeground(new java.awt.Color(255, 102, 0));
    jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel8.setText("Filtrar Reservas");
    jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 139, 37));

    jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    jLabel1.setForeground(new java.awt.Color(0, 0, 0));
    jLabel1.setText("Por estado: ");
    jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 90, 20));

    jRadioButton1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
    jRadioButton1.setForeground(new java.awt.Color(0, 0, 0));
    jRadioButton1.setText("Alta");
    jPanel2.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, -1, -1));

    jRadioButton2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
    jRadioButton2.setForeground(new java.awt.Color(0, 0, 0));
    jRadioButton2.setText("Baja");
    jPanel2.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, -1, -1));
    jPanel2.add(jSpinner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, -1, -1));

    jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    jLabel4.setForeground(new java.awt.Color(0, 0, 0));
    jLabel4.setText("Por fecha: ");
    jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));
    jPanel2.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, -1, -1));

    jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    jLabel10.setForeground(new java.awt.Color(0, 0, 0));
    jLabel10.setText("Segun su sector: ");
    jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

    jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    jLabel3.setForeground(new java.awt.Color(0, 0, 0));
    jLabel3.setText("Por N° Mesa: ");
    jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 90, -1));

    jButton1.setText("Mostrar");
    jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, -1, -1));

    jSeparator2.setForeground(new java.awt.Color(204, 204, 204));
    jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 200, 10));

    add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 240, 220));

    jPanel3.setBackground(new java.awt.Color(255, 204, 153));
    jPanel3.setForeground(new java.awt.Color(255, 204, 153));

    jLabel5.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
    jLabel5.setForeground(new java.awt.Color(255, 102, 0));
    jLabel5.setText("Buscar por nombre");

    jSeparator3.setForeground(new java.awt.Color(204, 204, 204));

    jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    jLabel9.setForeground(new java.awt.Color(0, 0, 0));
    jLabel9.setText("Nombre: ");

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel3Layout.createSequentialGroup()
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel3Layout.createSequentialGroup()
            .addGap(38, 38, 38)
            .addComponent(jLabel5))
          .addGroup(jPanel3Layout.createSequentialGroup()
            .addGap(24, 24, 24)
            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(jPanel3Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel9)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addContainerGap(16, Short.MAX_VALUE))
    );
    jPanel3Layout.setVerticalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel3Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel5)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel9)
          .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(151, Short.MAX_VALUE))
    );

    add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, 230, 220));
  }// </editor-fold>//GEN-END:initComponents


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton jButton1;
  private com.toedter.calendar.JDateChooser jDateChooser1;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel10;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JLabel jLabel8;
  private javax.swing.JLabel jLabel9;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JPanel jPanel3;
  private javax.swing.JRadioButton jRadioButton1;
  private javax.swing.JRadioButton jRadioButton2;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JSeparator jSeparator1;
  private javax.swing.JSeparator jSeparator2;
  private javax.swing.JSeparator jSeparator3;
  private javax.swing.JSpinner jSpinner1;
  private javax.swing.JTextField jTextField1;
  private javax.swing.JComboBox<String> jcbSector;
  private javax.swing.JTable jtReservas;
  // End of variables declaration//GEN-END:variables


//1. Cabecera 'tabla'
private void armarCabecera(){
  modelo = new DefaultTableModel() { 
    @Override
    public boolean isCellEditable(int row, int column) {
        return false; // Hace que todas las celdas no sean editables
    }
  };
  
  modelo.addColumn("ID RESERVA");
  modelo.addColumn("ID MESA");
  modelo.addColumn("NOMBRE DEL CLIENTE");
  modelo.addColumn("TELÉFONO");
  modelo.addColumn("COMENSALES");
  modelo.addColumn("SECTOR");
  modelo.addColumn("FECHA Y HORA");
  modelo.addColumn("ESTADO");

  jtReservas.setModel(modelo);
  jtReservas.getTableHeader().setReorderingAllowed(false); /*que no pueda mover las columnas*/

 }


//2. Cargar datos a la 'tabla'
private void cargarDatos(){
  modelo.setRowCount(0); // Limpiar las filas existentes del modelo

    // Obtener la lista de reservas
    List<Reserva> reservas = reservaData.listarReservas(); 

    // Recorrer la lista de reservas y agregar cada una al modelo
    for (Reserva r : reservas) {
        modelo.addRow(new Object[]{
            r.getIdReserva(),                        // ID de la Reserva
            r.getMesa().getIdMesa(),                 // ID de la Mesa (asumiendo que Mesa tiene un método getIdMesa())
            r.getNombreCliente(),                     // Nombre del Cliente
            r.getTelefono(),                          // Teléfono del Cliente
            r.getComensales(),                       // Cantidad de Comensales
            r.getSector(),                            // Sector de la Reserva
            r.getFechaHora(),                        // Fecha y Hora de la Reserva
            r.isEstado() ? "Activo" : "Inactivo"    // Estado de la Reserva como texto
        });
    }
}




}
