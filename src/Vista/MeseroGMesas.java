
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
import javax.swing.SpinnerNumberModel;
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
    jbCancelar = new javax.swing.JButton();
    jSeparator1 = new javax.swing.JSeparator();
    jPanel3 = new javax.swing.JPanel();
    jLabel7 = new javax.swing.JLabel();
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

    jLabel2.setFont(new java.awt.Font("Roboto", 3, 18)); // NOI18N
    jLabel2.setForeground(new java.awt.Color(255, 102, 0));
    jLabel2.setText("Modificar Situacion");

    jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    jLabel4.setText("N° Mesa:");

    jsNumeroMesa.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
    jsNumeroMesa.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

    jcbSituacion.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
    jcbSituacion.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jcbSituacionActionPerformed(evt);
      }
    });

    jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    jLabel5.setText("Situación");

    jbModificar.setText("Modificar");
    jbModificar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jbModificarActionPerformed(evt);
      }
    });

    jbCancelar.setText("Cancelar");
    jbCancelar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jbCancelarActionPerformed(evt);
      }
    });

    jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
    jSeparator1.setForeground(new java.awt.Color(204, 204, 204));

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addGap(19, 19, 19)
        .addComponent(jbModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jbCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(27, 27, 27))
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel2Layout.createSequentialGroup()
            .addGap(12, 12, 12)
            .addComponent(jLabel4)
            .addGap(12, 12, 12)
            .addComponent(jsNumeroMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(jPanel2Layout.createSequentialGroup()
            .addGap(12, 12, 12)
            .addComponent(jLabel5)
            .addGap(6, 6, 6)
            .addComponent(jcbSituacion, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(jPanel2Layout.createSequentialGroup()
            .addGap(22, 22, 22)
            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(jPanel2Layout.createSequentialGroup()
            .addGap(62, 62, 62)
            .addComponent(jLabel2)))
        .addContainerGap(14, Short.MAX_VALUE))
    );
    jPanel2Layout.setVerticalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addGap(11, 11, 11)
        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(6, 6, 6)
        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(6, 6, 6)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel2Layout.createSequentialGroup()
            .addGap(3, 3, 3)
            .addComponent(jLabel4))
          .addComponent(jsNumeroMesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(24, 24, 24)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel2Layout.createSequentialGroup()
            .addGap(3, 3, 3)
            .addComponent(jLabel5))
          .addComponent(jcbSituacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(32, 32, 32)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jbModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jbCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(15, Short.MAX_VALUE))
    );

    jPanel3.setBackground(new java.awt.Color(255, 204, 153));
    jPanel3.setForeground(new java.awt.Color(204, 204, 204));

    jLabel7.setFont(new java.awt.Font("Roboto", 3, 18)); // NOI18N
    jLabel7.setForeground(new java.awt.Color(255, 102, 0));
    jLabel7.setText("Visualización de Mesas");

    jcbMostrarSituacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Reservado", "Ocupado", "Libre", "" }));
    jcbMostrarSituacion.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jcbMostrarSituacionActionPerformed(evt);
      }
    });

    jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    jLabel9.setText("Filtrar por Situación:");

    jbMesasPorSector.setText("Mostrar");
    jbMesasPorSector.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jbMesasPorSectorActionPerformed(evt);
      }
    });

    jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    jLabel10.setText("Mostrar todas las mesas:");

    jSeparator2.setForeground(new java.awt.Color(204, 204, 204));

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel3Layout.createSequentialGroup()
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel3Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel10)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jbMesasPorSector, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(jPanel3Layout.createSequentialGroup()
            .addGap(51, 51, 51)
            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(jPanel3Layout.createSequentialGroup()
            .addGap(28, 28, 28)
            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(jPanel3Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel9)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jcbMostrarSituacion, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanel3Layout.setVerticalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel3Layout.createSequentialGroup()
        .addGap(6, 6, 6)
        .addComponent(jLabel7)
        .addGap(5, 5, 5)
        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(17, 17, 17)
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jcbMostrarSituacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel9))
        .addGap(28, 28, 28)
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jbMesasPorSector, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel10))
        .addContainerGap(49, Short.MAX_VALUE))
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

    jLabel1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
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
        .addGap(10, 10, 10)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGap(840, 840, 840)
            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jcbSector, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addGap(17, 17, 17))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGap(8, 8, 8)
            .addComponent(jLabel6))
          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(jcbSector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel1)))
        .addGap(18, 18, 18)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
          .addGroup(layout.createSequentialGroup()
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())))
    );
  }// </editor-fold>//GEN-END:initComponents

  
  
  
  
  // 1. Modificar situacion de una Mesa
  private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
     if (jcbSector.getSelectedItem() == null) {
        JOptionPane.showMessageDialog(this, "Seleccione su sector asignado", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    } else {
        String situacion = (String) jcbSituacion.getSelectedItem();

        // Verifica si la situación es válida
        if (situacion == null) {
            JOptionPane.showMessageDialog(this, "Seleccione la situación actual de la mesa");
            return;
        }

        int idMesa = (int) jsNumeroMesa.getValue();
        String nuevaSituacion = (String) jcbSituacion.getSelectedItem();

        // Buscar la mesa en la BD
        Mesa buscarMesa = mesaData.buscarMesa(idMesa);

        if (buscarMesa == null) {
            JOptionPane.showMessageDialog(null, "No se encontró la mesa N° " + idMesa, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else {     
            if (!buscarMesa.isEstado()) { 
                JOptionPane.showMessageDialog(this, "La mesa N° " + idMesa + " no está habilitada. No se puede modificar.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            //Confirmar Modificacion
            int confirmacion = JOptionPane.showOptionDialog(this, 
            "¿Está seguro que desea modificar la situación de la mesa N° " + idMesa + "?", 
            "Confirmación", 
            JOptionPane.YES_NO_OPTION, 
            JOptionPane.QUESTION_MESSAGE, 
            null, // Icono
            new Object[] {"Sí", "No"}, // Personalización de los botones
            "Sí"); 

            //Verificar lo seleccionado
            if (confirmacion == JOptionPane.NO_OPTION || confirmacion == JOptionPane.CLOSED_OPTION) {
                return; 
            }

           
            Mesa mesaSituacion = new Mesa(buscarMesa.getIdMesa(), buscarMesa.getCapacidad(), buscarMesa.isEstado(), buscarMesa.getSector(), nuevaSituacion);
            mesaData.modificarMesa(mesaSituacion);
            JOptionPane.showMessageDialog(null, "La mesa N° " + buscarMesa.getIdMesa() + " fue modificada con éxito!");

            jsNumeroMesa.setValue(1); // Reseteamos el Spinner
            jcbSituacion.setSelectedIndex(0); // Reseteamos el ComboBox

            modelo.setRowCount(0); 
            String sector = (String) jcbSector.getSelectedItem();
            List<Mesa> mesas = mesaData.listarMesasPorSector(sector); // Obtener las mesas del sector
            
            for (Mesa m : mesas) {
                if (m.isEstado()) { 
                    modelo.addRow(new Object[] {
                        m.getIdMesa(),
                        m.getCapacidad(),
                        "Habilitada",
                        m.getSector(),
                        m.getSituacion(),
                    });
                }
            }
        }
    }
        
            
         
  }//GEN-LAST:event_jbModificarActionPerformed

  // 2. Boton 'Cancelar'
  private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
    if(jcbSector.getSelectedItem()==null){
      JOptionPane.showMessageDialog(this, "Seleccione su sector asignado", "Error", JOptionPane.ERROR_MESSAGE);
      jcbSituacion.setSelectedIndex(0);
      return;
    
    }
    jcbSituacion.setSelectedIndex(0);
    
    
  }//GEN-LAST:event_jbCancelarActionPerformed

  
  // 3. Mostrar 'Mesas' por situacion(Libre, Ocupado, Reservado)
  private void jcbMostrarSituacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbMostrarSituacionActionPerformed
    if(jcbSector.getSelectedItem()==null){
      JOptionPane.showMessageDialog(this, "Seleccione su sector asignado", "Error", JOptionPane.ERROR_MESSAGE);
      return;
    }
    
    
    String situacionSeleccionada = (String) jcbMostrarSituacion.getSelectedItem();
    if (situacionSeleccionada == null) { 
      JOptionPane.showMessageDialog(null, "Seleccione una situación válida");
      return;
    }

    String sectorSeleccionado = (String) jcbSector.getSelectedItem();

    modelo.setRowCount(0); // Limpiar la tabla antes de cargar nuevos datos
    List<Mesa> mesas = mesaData.buscarMesasPorSituacion(situacionSeleccionada); // Obtener las mesas por situación

    // Filtrar por sector antes de agregar a la tabla
    System.out.println("Situación seleccionada: " + situacionSeleccionada);

    for (Mesa m : mesas) {
      if (m.getSector().equalsIgnoreCase(sectorSeleccionado) && m.isEstado()) { // Verificar sector y que la mesa esté habilitada
          modelo.addRow(new Object[]{
              m.getIdMesa(),
              m.getCapacidad(),
              "Habilitada", // Siempre mostrar como habilitada porque son las únicas mesas visibles
              m.getSector(),
              m.getSituacion(),
          });
      }
    }
  }//GEN-LAST:event_jcbMostrarSituacionActionPerformed

  
  
  // Mostrar 'Mesas' por sector asignado
  private void jbMesasPorSectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMesasPorSectorActionPerformed
    String sectorSeleccionado = (String) jcbSector.getSelectedItem();
    
    if(sectorSeleccionado == null) {
        JOptionPane.showMessageDialog(null, "Seleccione su sector asignado", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    } else {
        modelo.setRowCount(0); // Limpiar la tabla antes de cargar nuevos datos

        // Obtener las mesas del sector seleccionado
        List<Mesa> mesas = mesaData.listarMesasPorSector(sectorSeleccionado);

        // Filtrar solo las mesas habilitadas
        for (Mesa m : mesas) {
            if (m.isEstado()) {  // Solo mesas habilitadas
                modelo.addRow(new Object[] {
                    m.getIdMesa(),
                    m.getCapacidad(),
                    "Habilitada",  
                    m.getSector(),
                    m.getSituacion(),
                });
            }
        }
    }
    
    
  }//GEN-LAST:event_jbMesasPorSectorActionPerformed

  
  // Sector seleccionado
  private void jcbSectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbSectorActionPerformed

    String sectorSeleccionado = (String) jcbSector.getSelectedItem();
    if (sectorSeleccionado == null) {
        JOptionPane.showMessageDialog(null, "Seleccione su sector asignado");
        return;
    }

    // Limpiar la tabla antes de cargar nuevos datos
    DefaultTableModel modelo = (DefaultTableModel) jtMesas.getModel();
    modelo.setRowCount(0);

    // Obtener las mesas del sector
    List<Mesa> mesas = mesaData.listarMesasPorSector(sectorSeleccionado);
    
    if (mesas.isEmpty()) {
        JOptionPane.showMessageDialog(null, "No hay mesas disponibles en este sector.", "Información", JOptionPane.INFORMATION_MESSAGE);
        jsNumeroMesa.setModel(new SpinnerNumberModel(0, 0, 0, 1)); 
        return;
    }

    // Cargar solo mesas habilitadas en la tabla
    for (Mesa m : mesas) {
        if (m.isEstado()) { // Solo agregar mesas con estado 'true' o habilitadas
            modelo.addRow(new Object[]{
                m.getIdMesa(),
                m.getCapacidad(),
                "Habilitada", // Mostrar como texto
                m.getSector(),
                m.getSituacion(),
            });
        }
    }

    // Obtener el rango de números de mesa del sector
    int minMesa = mesas.stream().filter(Mesa::isEstado).mapToInt(Mesa::getIdMesa).min().orElse(0); // Filtrar mesas habilitadas
    int maxMesa = mesas.stream().filter(Mesa::isEstado).mapToInt(Mesa::getIdMesa).max().orElse(0); // Filtrar mesas habilitadas

    // Configurar el modelo del Spinner
    SpinnerNumberModel modeloSpinner = new SpinnerNumberModel(minMesa, minMesa, maxMesa, 1);
    jsNumeroMesa.setModel(modeloSpinner);

  }//GEN-LAST:event_jcbSectorActionPerformed

  
  
  // Filtar lista por situacion
    private void jcbSituacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbSituacionActionPerformed
     
    }//GEN-LAST:event_jcbSituacionActionPerformed


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel10;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JLabel jLabel9;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JPanel jPanel3;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JSeparator jSeparator1;
  private javax.swing.JSeparator jSeparator2;
  private javax.swing.JButton jbCancelar;
  private javax.swing.JButton jbMesasPorSector;
  private javax.swing.JButton jbModificar;
  private javax.swing.JComboBox<String> jcbMostrarSituacion;
  private javax.swing.JComboBox<String> jcbSector;
  private javax.swing.JComboBox<String> jcbSituacion;
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
  jtMesas.setBackground(new java.awt.Color(153, 204, 255));  
  
  for (Mesa m : mesas) {
      if (m.isEstado()) { // Solo agregar mesas con estado 'habilitada'
          modelo.addRow(new Object[]{
              m.getIdMesa(),
              m.getCapacidad(),
              "Habilitada", // Mostrar como texto "Habilitada"
              m.getSector(),
              m.getSituacion(),
          });
      }
  }
}


// 3. Cargar combo-sector
private void cargaComboSector (){
    // Agregar un elemento nulo como primer elemento
    jcbSector.addItem(null);  

    // Agregar otros elementos al JComboBox
    jcbSector.addItem("Comedor");
    jcbSector.addItem("Terraza");
    jcbSector.addItem("Patio");
    
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
