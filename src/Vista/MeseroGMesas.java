
package Vista;

import Modelo.Mesa;
import java.sql.Connection;
import Persistencia.Conexion;
import Persistencia.MesaData;
import java.awt.Dimension;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel; // (1).modelo-tabla

public class MeseroGMesas extends javax.swing.JPanel {
  //Atributos
  private  Connection con; /* variable q tendra la conexion */ 
  private  MesaData mesaData; 
  private DefaultTableModel modelo = new DefaultTableModel(); // (2).tabla
  
  
  
  //constructor
  public MeseroGMesas() {
    initComponents();
    this.con = Conexion.getConexion(); //Obtener la conexion y guardarla.
    this.mesaData = new MesaData(con);
    
    armarCabecera();
    cargarDatos();
    cargaComboSector ();
    cargaComboSituacion ();
 
  }

  
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jLabel6 = new javax.swing.JLabel();
    jPanel2 = new javax.swing.JPanel();
    jLabel2 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    jsNumeroMesa = new javax.swing.JSpinner();
    jcbSituacion = new javax.swing.JComboBox<>();
    jLabel5 = new javax.swing.JLabel();
    jbModificar = new javax.swing.JButton();
    jButton8 = new javax.swing.JButton();
    jSeparator1 = new javax.swing.JSeparator();
    jPanel3 = new javax.swing.JPanel();
    jLabel7 = new javax.swing.JLabel();
    jLabel8 = new javax.swing.JLabel();
    jrbAlta = new javax.swing.JRadioButton();
    jrbBaja = new javax.swing.JRadioButton();
    jcbMostrarSituacion = new javax.swing.JComboBox<>();
    jLabel9 = new javax.swing.JLabel();
    jbMesasPorSector = new javax.swing.JButton();
    jLabel10 = new javax.swing.JLabel();
    jSeparator2 = new javax.swing.JSeparator();
    jScrollPane1 = new javax.swing.JScrollPane();
    jtMesas = new javax.swing.JTable();
    jLabel1 = new javax.swing.JLabel();
    jcbSector = new javax.swing.JComboBox<>();

    jLabel6.setFont(new java.awt.Font("Franklin Gothic Medium", 3, 18)); // NOI18N
    jLabel6.setForeground(new java.awt.Color(0, 204, 0));
    jLabel6.setText("Gestion  Mesas");

    jPanel2.setBackground(new java.awt.Color(255, 204, 153));
    jPanel2.setForeground(new java.awt.Color(204, 204, 204));

    jLabel2.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
    jLabel2.setForeground(new java.awt.Color(255, 102, 0));
    jLabel2.setText("Modificar Situacion");

    jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    jLabel4.setForeground(new java.awt.Color(0, 0, 0));
    jLabel4.setText("N° Mesa:");

    jsNumeroMesa.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
    jsNumeroMesa.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

    jcbSituacion.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N

    jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    jLabel5.setForeground(new java.awt.Color(0, 0, 0));
    jLabel5.setText("Situación");

    jbModificar.setText("Modificar");
    jbModificar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jbModificarActionPerformed(evt);
      }
    });

    jButton8.setText("Cancelar");
    jButton8.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton8ActionPerformed(evt);
      }
    });

    jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
    jSeparator1.setForeground(new java.awt.Color(204, 204, 204));

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel2Layout.createSequentialGroup()
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbSituacion, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jsNumeroMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jbModificar)
                .addGap(45, 45, 45)
                .addComponent(jButton8)))
            .addGap(0, 50, Short.MAX_VALUE))
          .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING))
        .addContainerGap())
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addGap(64, 64, 64)
        .addComponent(jLabel2)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanel2Layout.setVerticalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addGap(11, 11, 11)
        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel4)
          .addComponent(jsNumeroMesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(24, 24, 24)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel5)
          .addComponent(jcbSituacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jbModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(24, 24, 24))
    );

    jPanel3.setBackground(new java.awt.Color(255, 204, 153));
    jPanel3.setForeground(new java.awt.Color(204, 204, 204));

    jLabel7.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
    jLabel7.setForeground(new java.awt.Color(255, 102, 0));
    jLabel7.setText("Filtrar Mesas");

    jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    jLabel8.setForeground(new java.awt.Color(0, 0, 0));
    jLabel8.setText("Por estado:");

    jrbAlta.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
    jrbAlta.setForeground(new java.awt.Color(0, 0, 0));
    jrbAlta.setText(" Alta");
    jrbAlta.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jrbAltaActionPerformed(evt);
      }
    });

    jrbBaja.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
    jrbBaja.setForeground(new java.awt.Color(0, 0, 0));
    jrbBaja.setText("Baja");
    jrbBaja.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jrbBajaActionPerformed(evt);
      }
    });

    jcbMostrarSituacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Reservada", "Ocupada", "Libre", "" }));
    jcbMostrarSituacion.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jcbMostrarSituacionActionPerformed(evt);
      }
    });

    jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    jLabel9.setForeground(new java.awt.Color(0, 0, 0));
    jLabel9.setText("Por situacion: ");

    jbMesasPorSector.setText("Mostrar todas");
    jbMesasPorSector.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jbMesasPorSectorActionPerformed(evt);
      }
    });

    jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    jLabel10.setForeground(new java.awt.Color(0, 0, 0));
    jLabel10.setText("Segun su sector: ");

    jSeparator2.setForeground(new java.awt.Color(204, 204, 204));

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel3Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel3Layout.createSequentialGroup()
            .addComponent(jSeparator2)
            .addContainerGap())
          .addGroup(jPanel3Layout.createSequentialGroup()
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jrbAlta)
                .addGap(18, 18, 18)
                .addComponent(jrbBaja))
              .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbMesasPorSector))
              .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jcbMostrarSituacion, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(0, 36, Short.MAX_VALUE))))
      .addGroup(jPanel3Layout.createSequentialGroup()
        .addGap(81, 81, 81)
        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 0, Short.MAX_VALUE))
    );
    jPanel3Layout.setVerticalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel3Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel7)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(5, 5, 5)
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jrbAlta)
          .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(jrbBaja))
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel3Layout.createSequentialGroup()
            .addGap(24, 24, 24)
            .addComponent(jLabel9))
          .addGroup(jPanel3Layout.createSequentialGroup()
            .addGap(21, 21, 21)
            .addComponent(jcbMostrarSituacion, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addGap(18, 18, 18)
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jbMesasPorSector)
          .addComponent(jLabel10))
        .addContainerGap(55, Short.MAX_VALUE))
    );

    jtMesas.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
    jtMesas.setModel(new javax.swing.table.DefaultTableModel(
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
    jScrollPane1.setViewportView(jtMesas);

    jLabel1.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
    jLabel1.setForeground(new java.awt.Color(204, 0, 0));
    jLabel1.setText(" Sector:");

    jcbSector.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
    jcbSector.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jcbSectorActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(12, 12, 12)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
              .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGap(26, 26, 26)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jcbSector, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(461, 461, 461)
            .addComponent(jLabel6)))
        .addGap(40, 79, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel1)
          .addComponent(jcbSector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel6))
        .addGap(27, 27, 27)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(14, Short.MAX_VALUE))
    );
  }// </editor-fold>//GEN-END:initComponents

  
  private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed

    if(jcbSector.getSelectedItem()==null){
      JOptionPane.showMessageDialog(this, "Seleccione su sector asignado","Error", JOptionPane.ERROR_MESSAGE);
      return;
    
    }else{
    
    String situacion = (String) jcbSituacion.getSelectedItem();

    // Verifica si el sector es válido (no debe ser "Mostrar por sector")
    if (situacion==null) {
      JOptionPane.showMessageDialog(this, "Seleccione la situacion actual de la mesa","Error", JOptionPane.ERROR_MESSAGE);
      return;
    }

    int idMesa = (int) jsNumeroMesa.getValue();
    String nuevaSituacion = (String) jcbSituacion.getSelectedItem();

    Mesa buscarMesa = mesaData.buscarMesa(idMesa); // Verificamos si se encuentra la mesa en la BD.

    if (buscarMesa == null) {
      JOptionPane.showMessageDialog(null, "No se encontró la mesa N° " + idMesa, "Error", JOptionPane.ERROR_MESSAGE);
      return;
    }else{

      Mesa mesaSituacion = new Mesa(buscarMesa.getIdMesa(), buscarMesa.getCapacidad(), buscarMesa.isEstado(), buscarMesa.getSector(), nuevaSituacion);
      mesaData.modificarMesa(mesaSituacion);
      JOptionPane.showMessageDialog(null, "La mesa N° "+ buscarMesa.getIdMesa()+" Fue modificada con exito! " );
      jsNumeroMesa.setValue(1); //reseteamos
      jcbSituacion.setSelectedIndex(0); //reseteamos

      modelo.setRowCount(0); // Limpiar la tabla antes de cargar nuevos datos
      String sector = (String) jcbSector.getSelectedItem();
      List<Mesa> mesas = mesaData.listarMesasPorSector(sector); // Obtener las mesas del sector
      for (Mesa m : mesas) {
        modelo.addRow(new Object[]{
          m.getIdMesa(),
          m.getCapacidad(),
          m.isEstado(),
          m.getSector(),
          m.getSituacion(),
        });
      }

    }
    }
  }//GEN-LAST:event_jbModificarActionPerformed

  private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
    jsNumeroMesa.setValue(1);
    jcbSituacion.setSelectedIndex(0);
  }//GEN-LAST:event_jButton8ActionPerformed

  private void jrbAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbAltaActionPerformed

    if (jrbAlta.isSelected()) {
      jrbBaja.setSelected(false);

      // Obtener el sector seleccionado del JComboBox
      String sectorSeleccionado = (String) jcbSector.getSelectedItem();

      modelo.setRowCount(0);
      // Obtener todas las mesas con estado false

      List<Mesa> mesasConEstadoFalse = mesaData.listarMesasPorEstado(true);

      // Filtrar las mesas por el sector seleccionado
      for (Mesa m : mesasConEstadoFalse) {
        if (m.getSector().equals(sectorSeleccionado)) {
          modelo.addRow(new Object[]{
            m.getIdMesa(),
            m.getCapacidad(),
            m.isEstado(),
            m.getSector(),
            m.getSituacion(),
          });
        }
      }
    }

  }//GEN-LAST:event_jrbAltaActionPerformed

  private void jrbBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbBajaActionPerformed

    if (jrbBaja.isSelected()) {
      jrbAlta.setSelected(false);
      String sectorSeleccionado = (String) jcbSector.getSelectedItem();
      modelo.setRowCount(0); // Limpiar la tabla antes de cargar nuevos datos

      // Obtener todas las mesas con estado false
      List<Mesa> mesasConEstadoFalse = mesaData.listarMesasPorEstado(false);

      // Filtrar las mesas por el sector seleccionado
      for (Mesa m : mesasConEstadoFalse) {
        if (m.getSector().equals(sectorSeleccionado)) {
          modelo.addRow(new Object[]{
            m.getIdMesa(),
            m.getCapacidad(),
            m.isEstado(),
            m.getSector(),
            m.getSituacion(),
          });
        }
      }
    }
  }//GEN-LAST:event_jrbBajaActionPerformed

  private void jcbMostrarSituacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbMostrarSituacionActionPerformed
    String situacionSeleccionada = (String) jcbMostrarSituacion.getSelectedItem();

    if (situacionSeleccionada == null) { // Cambié aquí para verificar el valor seleccionado
      JOptionPane.showMessageDialog(null, "Seleccione una situación válida");
      return;
    }

    String sectorSeleccionado = (String) jcbSector.getSelectedItem();

    modelo.setRowCount(0); // Limpiar la tabla antes de cargar nuevos datos
    List<Mesa> mesas = mesaData.buscarMesasPorSituacion(situacionSeleccionada); // Obtener las mesas por situación

    // Filtrar por sector antes de agregar a la tabla
    for (Mesa m : mesas) {
      if (m.getSector().equals(sectorSeleccionado)) { // Verificar si coincide el sector
        modelo.addRow(new Object[]{
          m.getIdMesa(),
          m.getCapacidad(),
          m.isEstado(),
          m.getSector(),
          m.getSituacion(),
        });
      }
    }
  }//GEN-LAST:event_jcbMostrarSituacionActionPerformed

  private void jbMesasPorSectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMesasPorSectorActionPerformed
    jrbAlta.setSelected(false);
    jrbBaja.setSelected(false);

    String sectorSeleccionado = (String) jcbSector.getSelectedItem();
    if(sectorSeleccionado == null){
      JOptionPane.showMessageDialog(null, "Seleccione su sector asignado");
      return;
    }else {
      modelo.setRowCount(0); // Limpiar la tabla antes de cargar nuevos datos
      List<Mesa> mesas = mesaData.listarMesasPorSector(sectorSeleccionado); // Obtener las mesas del sector
      for (Mesa m : mesas) {
        modelo.addRow(new Object[]{
          m.getIdMesa(),
          m.getCapacidad(),
          m.isEstado(),
          m.getSector(),
          m.getSituacion(),
        });
      }
    }
  }//GEN-LAST:event_jbMesasPorSectorActionPerformed

  private void jcbSectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbSectorActionPerformed
    jrbAlta.setSelected(false);
    jrbBaja.setSelected(false);

    String sectorSeleccionado = (String) jcbSector.getSelectedItem();
    if(sectorSeleccionado == null){
      JOptionPane.showMessageDialog(null, "Seleccione su sector asignado");
      return;
    }else {
      modelo.setRowCount(0); // Limpiar la tabla antes de cargar nuevos datos
      List<Mesa> mesas = mesaData.listarMesasPorSector(sectorSeleccionado); // Obtener las mesas del sector
      for (Mesa m : mesas) {
        modelo.addRow(new Object[]{
          m.getIdMesa(),
          m.getCapacidad(),
          m.isEstado(),
          m.getSector(),
          m.getSituacion(),
        });
      }
    }
  }//GEN-LAST:event_jcbSectorActionPerformed


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton jButton8;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel10;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JLabel jLabel8;
  private javax.swing.JLabel jLabel9;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JPanel jPanel3;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JSeparator jSeparator1;
  private javax.swing.JSeparator jSeparator2;
  private javax.swing.JButton jbMesasPorSector;
  private javax.swing.JButton jbModificar;
  private javax.swing.JComboBox<String> jcbMostrarSituacion;
  private javax.swing.JComboBox<String> jcbSector;
  private javax.swing.JComboBox<String> jcbSituacion;
  private javax.swing.JRadioButton jrbAlta;
  private javax.swing.JRadioButton jrbBaja;
  private javax.swing.JSpinner jsNumeroMesa;
  private javax.swing.JTable jtMesas;
  // End of variables declaration//GEN-END:variables



//1. Cabecera 'tabla'
private void armarCabecera(){
  modelo = new DefaultTableModel() { 
    @Override
    public boolean isCellEditable(int row, int column) {
        return false; // Hace que todas las celdas no sean editables
    }
  };
  
  modelo.addColumn("N° MESA");
  modelo.addColumn("CAPACIDAD");
  modelo.addColumn("ESTADO");
  modelo.addColumn("SECTOR");
  modelo.addColumn("SITUACION");

  jtMesas.setModel(modelo);
  jtMesas.getTableHeader().setReorderingAllowed(false); /*que no pueda mover las columnas*/

 }

//2. Cargar datos a la 'tabla'
private void cargarDatos(){
 modelo.setRowCount(0);
    List<Mesa> mesas = mesaData.listarMesas();
    for (Mesa m : mesas) {
        modelo.addRow(new Object[]{
            m.getIdMesa(),
            m.getCapacidad(),
            m.isEstado(),
            m.getSector(),
            m.getSituacion(),
        });
    }
}


// 3. Cargar combo-sector
private void cargaComboSector (){
    // Agregar un elemento nulo como primer elemento
    jcbSector.addItem(null);  

    // Agregar otros elementos al JComboBox
    jcbSector.addItem("Patio");
    jcbSector.addItem("Interior");
    jcbSector.addItem("Privado");
    jcbSector.addItem("Terraza");
}

// 4. Cargar combo-situacion
private void cargaComboSituacion (){
    // Agregar un elemento nulo como primer elemento
    jcbSituacion.addItem(null);  
    jcbSituacion.addItem("Reservado");
    jcbSituacion.addItem("Ocupado");
    jcbSituacion.addItem("Libre");
   
}


















}
