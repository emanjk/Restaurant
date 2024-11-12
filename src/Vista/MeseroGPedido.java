package Vista;
import Modelo.Mesa;
import Modelo.Pedido;
import Modelo.Mesero;
import Modelo.PedidoProducto;
import Modelo.Producto;

import Persistencia.MesaData;
import Persistencia.MeseroData;
import Persistencia.PedidoData;
import Persistencia.ProductoData;

import java.sql.Connection;
import Persistencia.Conexion;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel; // (1).modelo-tabla

public class MeseroGPedido extends javax.swing.JPanel {
  private  Connection con; /* variable q tendra la conexion */ 
  private  MesaData mesaData; 
  private PedidoData pedidoData;
  private MeseroData meseroData;
  private DefaultTableModel modelo = new DefaultTableModel(); // (2).tabla
  
  
  
  public MeseroGPedido() {
    initComponents();
    this.con = Conexion.getConexion(); //Obtener la conexion y guardarla.
    this.mesaData = new MesaData(con);
    this.pedidoData = new PedidoData(con);
    this.meseroData = new MeseroData(con);
    
    armarCabecera();
    cargarDatos();
    cargaComboSector ();
    confiSpinner();
    
  }

  
  
  
  
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jLabel6 = new javax.swing.JLabel();
    jScrollPane1 = new javax.swing.JScrollPane();
    jtPedidos = new javax.swing.JTable();
    jPanel3 = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    jSeparator1 = new javax.swing.JSeparator();
    jLabel3 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    jLabel5 = new javax.swing.JLabel();
    jLabel8 = new javax.swing.JLabel();
    jsMesa = new javax.swing.JSpinner();
    jsMesero = new javax.swing.JSpinner();
    jdFecha = new com.toedter.calendar.JDateChooser();
    jrbActivo = new javax.swing.JRadioButton();
    jrbInactivo = new javax.swing.JRadioButton();
    jbAgregar = new javax.swing.JButton();
    jbCancelar = new javax.swing.JButton();
    jLabel2 = new javax.swing.JLabel();
    jcbSector = new javax.swing.JComboBox<>();
    jPanel4 = new javax.swing.JPanel();
    jLabel7 = new javax.swing.JLabel();
    jSeparator2 = new javax.swing.JSeparator();
    jLabel9 = new javax.swing.JLabel();
    jsNumeroPedido = new javax.swing.JSpinner();
    jbBuscar = new javax.swing.JButton();
    jLabel10 = new javax.swing.JLabel();
    jLabel11 = new javax.swing.JLabel();
    jLabel12 = new javax.swing.JLabel();
    jdcFecha = new com.toedter.calendar.JDateChooser();
    jrActivoPedido = new javax.swing.JRadioButton();
    jrbInactivoPedido = new javax.swing.JRadioButton();
    jbModificar = new javax.swing.JButton();
    jButton3 = new javax.swing.JButton();
    jsNumeroMesa = new javax.swing.JSpinner();

    jLabel6.setFont(new java.awt.Font("Franklin Gothic Medium", 3, 18)); // NOI18N
    jLabel6.setForeground(new java.awt.Color(0, 204, 0));
    jLabel6.setText("Gestion  Pedidos");

    jtPedidos.setModel(new javax.swing.table.DefaultTableModel(
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
    jScrollPane1.setViewportView(jtPedidos);

    jPanel3.setBackground(new java.awt.Color(255, 204, 153));

    jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
    jLabel1.setForeground(new java.awt.Color(204, 51, 0));
    jLabel1.setText("Agregar Pedido");

    jSeparator1.setForeground(new java.awt.Color(204, 204, 204));

    jLabel3.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
    jLabel3.setForeground(new java.awt.Color(0, 0, 0));
    jLabel3.setText("N° Mesa: ");

    jLabel4.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
    jLabel4.setForeground(new java.awt.Color(0, 0, 0));
    jLabel4.setText("N° Mesero: ");

    jLabel5.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
    jLabel5.setForeground(new java.awt.Color(0, 0, 0));
    jLabel5.setText("Fecha: ");

    jLabel8.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
    jLabel8.setForeground(new java.awt.Color(0, 0, 0));
    jLabel8.setText("Estado: ");

    jrbActivo.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
    jrbActivo.setForeground(new java.awt.Color(0, 0, 0));
    jrbActivo.setText("Activo");
    jrbActivo.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jrbActivoActionPerformed(evt);
      }
    });

    jrbInactivo.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
    jrbInactivo.setForeground(new java.awt.Color(0, 0, 0));
    jrbInactivo.setText("Inactivo");
    jrbInactivo.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jrbInactivoActionPerformed(evt);
      }
    });

    jbAgregar.setText("Agregar");
    jbAgregar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jbAgregarActionPerformed(evt);
      }
    });

    jbCancelar.setText("Cancelar");
    jbCancelar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jbCancelarActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel3Layout.createSequentialGroup()
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel3Layout.createSequentialGroup()
            .addGap(6, 6, 6)
            .addComponent(jLabel3)
            .addGap(12, 12, 12)
            .addComponent(jsMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(jPanel3Layout.createSequentialGroup()
            .addGap(5, 5, 5)
            .addComponent(jLabel4)
            .addGap(12, 12, 12)
            .addComponent(jsMesero, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(jPanel3Layout.createSequentialGroup()
            .addGap(6, 6, 6)
            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(6, 6, 6)
            .addComponent(jdFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(jPanel3Layout.createSequentialGroup()
            .addGap(50, 50, 50)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(jPanel3Layout.createSequentialGroup()
            .addGap(6, 6, 6)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createSequentialGroup()
                  .addComponent(jLabel8)
                  .addGap(6, 6, 6)
                  .addComponent(jrbActivo)
                  .addGap(20, 20, 20)
                  .addComponent(jrbInactivo)))
              .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jbAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jbCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        .addContainerGap(20, Short.MAX_VALUE))
    );
    jPanel3Layout.setVerticalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel3Layout.createSequentialGroup()
        .addGap(12, 12, 12)
        .addComponent(jLabel1)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(7, 7, 7)
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel3Layout.createSequentialGroup()
            .addGap(3, 3, 3)
            .addComponent(jLabel3))
          .addComponent(jsMesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(31, 31, 31)
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel3Layout.createSequentialGroup()
            .addGap(3, 3, 3)
            .addComponent(jLabel4))
          .addComponent(jsMesero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(28, 28, 28)
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel5)
          .addComponent(jdFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(26, 26, 26)
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel3Layout.createSequentialGroup()
            .addGap(1, 1, 1)
            .addComponent(jLabel8))
          .addComponent(jrbActivo)
          .addGroup(jPanel3Layout.createSequentialGroup()
            .addGap(2, 2, 2)
            .addComponent(jrbInactivo)))
        .addGap(24, 24, 24)
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jbAgregar)
          .addComponent(jbCancelar))
        .addContainerGap(23, Short.MAX_VALUE))
    );

    jLabel2.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
    jLabel2.setForeground(new java.awt.Color(204, 0, 0));
    jLabel2.setText(" Sector:");

    jcbSector.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
    jcbSector.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jcbSectorActionPerformed(evt);
      }
    });

    jPanel4.setBackground(new java.awt.Color(255, 204, 153));

    jLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
    jLabel7.setForeground(new java.awt.Color(204, 51, 0));
    jLabel7.setText("Modificar Pedido");

    jSeparator2.setForeground(new java.awt.Color(204, 204, 204));

    jLabel9.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
    jLabel9.setForeground(new java.awt.Color(0, 0, 0));
    jLabel9.setText("N° Pedido: ");

    jbBuscar.setBackground(new java.awt.Color(51, 204, 0));
    jbBuscar.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
    jbBuscar.setForeground(new java.awt.Color(255, 255, 255));
    jbBuscar.setText("Buscar");
    jbBuscar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jbBuscarActionPerformed(evt);
      }
    });

    jLabel10.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
    jLabel10.setForeground(new java.awt.Color(0, 0, 0));
    jLabel10.setText("N° Mesa: ");

    jLabel11.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
    jLabel11.setForeground(new java.awt.Color(0, 0, 0));
    jLabel11.setText("Fecha: ");

    jLabel12.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
    jLabel12.setForeground(new java.awt.Color(0, 0, 0));
    jLabel12.setText("Estado: ");

    jrActivoPedido.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
    jrActivoPedido.setForeground(new java.awt.Color(0, 0, 0));
    jrActivoPedido.setText("Activo");
    jrActivoPedido.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jrActivoPedidoActionPerformed(evt);
      }
    });

    jrbInactivoPedido.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
    jrbInactivoPedido.setForeground(new java.awt.Color(0, 0, 0));
    jrbInactivoPedido.setText("Inactivo");
    jrbInactivoPedido.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jrbInactivoPedidoActionPerformed(evt);
      }
    });

    jbModificar.setText("Modificar");
    jbModificar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jbModificarActionPerformed(evt);
      }
    });

    jButton3.setText("Cancelar");

    javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
    jPanel4.setLayout(jPanel4Layout);
    jPanel4Layout.setHorizontalGroup(
      jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel4Layout.createSequentialGroup()
        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
              .addGap(40, 40, 40)
              .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel4Layout.createSequentialGroup()
              .addGap(20, 20, 20)
              .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel4Layout.createSequentialGroup()
              .addContainerGap()
              .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel4Layout.createSequentialGroup()
              .addContainerGap()
              .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                  .addComponent(jLabel10)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                  .addComponent(jsNumeroMesa))
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                  .addComponent(jLabel9)
                  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                  .addComponent(jsNumeroPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
              .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel4Layout.createSequentialGroup()
              .addContainerGap()
              .addComponent(jLabel12)
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
              .addComponent(jrActivoPedido)
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
              .addComponent(jrbInactivoPedido)))
          .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
            .addGap(18, 18, 18)
            .addComponent(jbModificar)
            .addGap(18, 18, 18)
            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addContainerGap(12, Short.MAX_VALUE))
    );
    jPanel4Layout.setVerticalGroup(
      jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel4Layout.createSequentialGroup()
        .addGap(10, 10, 10)
        .addComponent(jLabel7)
        .addGap(8, 8, 8)
        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel9)
          .addComponent(jsNumeroPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jbBuscar))
        .addGap(18, 18, 18)
        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel10)
          .addComponent(jsNumeroMesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(26, 26, 26)
        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel11)
          .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(27, 27, 27)
        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jrActivoPedido)
          .addComponent(jLabel12)
          .addComponent(jrbInactivoPedido))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jbModificar)
          .addComponent(jButton3))
        .addGap(26, 26, 26))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(6, 6, 6)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(6, 6, 6)
            .addComponent(jcbSector, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(689, 689, 689)
            .addComponent(jLabel6))
          .addGroup(layout.createSequentialGroup()
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGap(12, 12, 12)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(5, 5, 5)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGap(3, 3, 3)
            .addComponent(jLabel2))
          .addGroup(layout.createSequentialGroup()
            .addGap(5, 5, 5)
            .addComponent(jcbSector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap())
    );
  }// </editor-fold>//GEN-END:initComponents

  // 1. Mostrar: 'Pedidos' por sector seleccionado.
  private void jcbSectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbSectorActionPerformed

    String sectorSeleccionado = (String) jcbSector.getSelectedItem();

    // Obtener el rango de mesas para el sector seleccionado
    int[] rangoMesas = pedidoData.obtenerRangoMesasPorSector(sectorSeleccionado);

    // Si se obtiene un rango válido
    if (rangoMesas[0] != 0 && rangoMesas[1] != 0) {
        SpinnerNumberModel modelo = new SpinnerNumberModel(rangoMesas[0], rangoMesas[0], rangoMesas[1], 1);
        jsMesa.setModel(modelo);
        jsNumeroMesa.setModel(modelo);
    }

    // Obtener los pedidos del sector seleccionado
    List<Pedido> pedidos = pedidoData.obtenerPedidosPorSector(sectorSeleccionado);

    // Limpiar la tabla antes de cargar los nuevos pedidos
    DefaultTableModel modelo = (DefaultTableModel) jtPedidos.getModel();
    modelo.setRowCount(0);

    // Agregar los pedidos a la tabla
    for (Pedido p : pedidos) {
        modelo.addRow(new Object[]{
            p.getIdPedido(),                // ID del Pedido
            p.getMesa().getIdMesa(),        // Número de Mesa
            p.getMesero().getIdMesero(),    // Número de Mesero
            p.getFechaHora(),               // Fecha y Hora
            p.isEstado() ? "Activo" : "Cancelado" // Estado
        });
    }  
  }//GEN-LAST:event_jcbSectorActionPerformed

  // 2. Agregar: Pedido
  private void jbAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarActionPerformed

    if (jcbSector.getSelectedItem() == null) {
        JOptionPane.showMessageDialog(null, "Seleccione el sector asignado", "Error", JOptionPane.ERROR_MESSAGE);
        
        jsMesero.setValue(1);
        jdFecha.setDate(null);
        jrbActivo.setSelected(false);
        jrbInactivo.setSelected(false);
        return;
    }
    
    if (jdFecha.getDate() == null || (!jrbActivo.isSelected() && !jrbInactivo.isSelected())) {
      JOptionPane.showMessageDialog(null, "Debe completar todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
      jdFecha.setDate(null);
      jrbActivo.setSelected(false);
      jrbInactivo.setSelected(false);
      return;
    }
 
    int numeroMesa = (Integer) jsMesa.getValue();  
    int numeroMesero = (Integer) jsMesero.getValue();  
    Date fechaSeleccionada = jdFecha.getDate();  
    LocalDateTime fechaHora = fechaSeleccionada.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();  // Convertir a LocalDateTime
   
    boolean estado = jrbActivo.isSelected(); 

    // Crear el objeto Pedido
    Mesa mesa = mesaData.buscarMesa(numeroMesa);  // Método para obtener la mesa por su ID
    Mesero mesero = meseroData.buscarMeseroPorId(numeroMesero);  // Método para obtener el mesero por su ID
    Pedido pedido = new Pedido(mesa, mesero, fechaHora, estado, new ArrayList<PedidoProducto>()); 

    
    pedidoData.crearPedido(pedido); 
    JOptionPane.showMessageDialog(null, "Pedido agregado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);

     // Agregar el nuevo pedido a la tabla jtPedidos en tiempo real
    DefaultTableModel modelo = (DefaultTableModel) jtPedidos.getModel();
    modelo.addRow(new Object[]{
        pedido.getIdPedido(), // Asumiendo que tienes un método getIdPedido
        pedido.getMesa().getIdMesa(), // ID de la mesa
        pedido.getMesero().getIdMesero(), // ID del mesero
        pedido.getFechaHora(), // Fecha y hora del pedido
        pedido.isEstado() ? "Activo" : "Inactivo" // Estado del pedido
    });

    // Limpiar los campos después de agregar el pedido
    
    jsMesero.setValue(1);
    jdFecha.setDate(null);
    jrbActivo.setSelected(false);
    jrbInactivo.setSelected(false);

  }//GEN-LAST:event_jbAgregarActionPerformed

  
  // 3. Estado 'Activo'
  private void jrbActivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbActivoActionPerformed
    if(jcbSector.getSelectedItem()==null){
    
    }
    
    if(jrbActivo.isSelected()){
      jrbInactivo.setSelected(false);
    
    }
  }//GEN-LAST:event_jrbActivoActionPerformed

  
  // 4. Estado 'Inactivo'
  private void jrbInactivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbInactivoActionPerformed
   if(jrbInactivo.isSelected()){
     jrbActivo.setSelected(false);
   }
  }//GEN-LAST:event_jrbInactivoActionPerformed

  // 5. Buscar: 'Pedido'
  private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
    // Validar que se haya seleccionado un sector
    if (jcbSector.getSelectedItem() == null) {
        JOptionPane.showMessageDialog(null, "Seleccione el sector asignado", "Error", JOptionPane.ERROR_MESSAGE);
        return;  
    }

    // Validar que se haya ingresado un número de pedido
    if (jsNumeroPedido.getValue() == null) {
        JOptionPane.showMessageDialog(null, "Seleccione el número del pedido a buscar");
        return;  
    }
    
    int idPedido = (Integer) jsNumeroPedido.getValue();
    Pedido pedido = pedidoData.buscarPedidoPorId(idPedido);

    if (pedido == null) {
        JOptionPane.showMessageDialog(null, "No se encontró el pedido con ID: " + idPedido, "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
 
    jsNumeroMesa.setValue(pedido.getMesa().getIdMesa());  
    jdcFecha.setDate(java.sql.Date.valueOf(pedido.getFechaHora().toLocalDate())); // Usamos .toLocalDate() para obtener solo la fecha
    if (pedido.isEstado()) {
        jrActivoPedido.setSelected(true);
        jrbInactivoPedido.setSelected(false);
    } else {
        jrActivoPedido.setSelected(false);
        jrbInactivoPedido.setSelected(true);
    }

  }//GEN-LAST:event_jbBuscarActionPerformed

  
  
  // 6. Modificar: 'Pedido'
  private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
      // Validaciones
    if (jcbSector.getSelectedItem() == null) {
        JOptionPane.showMessageDialog(null, "Seleccione el sector asignado", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    if (jsNumeroPedido.getValue() == null) {
        JOptionPane.showMessageDialog(null, "Seleccione el número del pedido a modificar");
        return;
    }
    
    //consulta
    int idPedido = (Integer) jsNumeroPedido.getValue();
    Pedido pedido = pedidoData.buscarPedidoPorId(idPedido); // Buscar el pedido en la base de datos
    if (pedido == null) {
        JOptionPane.showMessageDialog(null, "No se encontró el pedido con ID: " + idPedido, "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Obtener los nuevos valores desde los campos del formulario
    int numeroMesa = (Integer) jsNumeroMesa.getValue();
    Mesa mesa = mesaData.buscarMesa(numeroMesa);  // Buscar la mesa actualizada
    LocalDate fechaSeleccionada = jdcFecha.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();  // Fecha seleccionada
    boolean estado = jrActivoPedido.isSelected();  // Estado activo/inactivo

    // Obtener la hora original del pedido si quieres mantenerla
    LocalDateTime fechaHoraOriginal = pedido.getFechaHora(); // Fecha y hora original
    LocalTime horaOriginal = fechaHoraOriginal.toLocalTime();  // Extraemos solo la hora

    // Combinar la nueva fecha con la hora original 
    LocalDateTime nuevaFechaHora = fechaSeleccionada.atTime(horaOriginal);  // Nueva fecha y hora combinada

    // Actualizar los valores del pedido
    pedido.setMesa(mesa);  // Modificar la mesa asociada
    pedido.setFechaHora(nuevaFechaHora);  // Modificar la fecha y hora combinada
    pedido.setEstado(estado);  
    
    if (pedidoData.modificarPedido2(pedido)) { 
        JOptionPane.showMessageDialog(null, "Pedido actualizado con éxito");
        
        DefaultTableModel modelo = (DefaultTableModel) jtPedidos.getModel();
        for (int i = 0; i < modelo.getRowCount(); i++) {     
            if ((int) modelo.getValueAt(i, 0) == pedido.getIdPedido()) {
                modelo.setValueAt(pedido.getMesa().getIdMesa(), i, 1);
                modelo.setValueAt(pedido.getMesero().getIdMesero(), i, 2);
                modelo.setValueAt(pedido.getFechaHora(), i, 3);
                modelo.setValueAt(pedido.isEstado() ? "Activo" : "Inactivo", i, 4); 
                break; 
            }
    }
    
    } else {
        JOptionPane.showMessageDialog(null, "No se pudo actualizar el pedido", "Error", JOptionPane.ERROR_MESSAGE);
    }

  }//GEN-LAST:event_jbModificarActionPerformed

  // 7. Estado de: 'jrActivoPedido'
  private void jrActivoPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrActivoPedidoActionPerformed
   if(jrActivoPedido.isSelected()){
     jrbInactivoPedido.setSelected(false);
   }
     
  }//GEN-LAST:event_jrActivoPedidoActionPerformed
  
  // 8. Estado de: 'jrbInactivoPedido'
  private void jrbInactivoPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbInactivoPedidoActionPerformed
    if(jrbInactivoPedido.isSelected()){
      jrActivoPedido.setSelected(false);
    }
  }//GEN-LAST:event_jrbInactivoPedidoActionPerformed

  // 9. Boton 'Cancelar'
  private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
    jsMesero.setValue(1);
    jrbActivo.setSelected(false);
    jrbInactivo.setSelected(false);
    jdFecha.setDate(null);
    
    String sectorSeleccionado = (String) jcbSector.getSelectedItem();
    
    int[] rangoMesas = pedidoData.obtenerRangoMesasPorSector(sectorSeleccionado);  
    if (rangoMesas[0] != 0 && rangoMesas[1] != 0) {
        SpinnerNumberModel modelo = new SpinnerNumberModel(rangoMesas[0], rangoMesas[0], rangoMesas[1], 1);
        jsMesa.setModel(modelo);
        jsNumeroMesa.setModel(modelo);
        
    }

    // Obtener los pedidos del sector seleccionado
    List<Pedido> pedidos = pedidoData.obtenerPedidosPorSector(sectorSeleccionado);

    // Limpiar la tabla antes de cargar los nuevos pedidos
   
    modelo.setRowCount(0);

    // Agregar los pedidos a la tabla
    for (Pedido p : pedidos) {
        modelo.addRow(new Object[]{
            p.getIdPedido(),                // ID del Pedido
            p.getMesa().getIdMesa(),        // Número de Mesa
            p.getMesero().getIdMesero(),    // Número de Mesero
            p.getFechaHora(),               // Fecha y Hora
            p.isEstado() ? "Activo" : "Cancelado" // Estado
        });
    }  
    
   
    
    
    

  }//GEN-LAST:event_jbCancelarActionPerformed


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton jButton3;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel10;
  private javax.swing.JLabel jLabel11;
  private javax.swing.JLabel jLabel12;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JLabel jLabel8;
  private javax.swing.JLabel jLabel9;
  private javax.swing.JPanel jPanel3;
  private javax.swing.JPanel jPanel4;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JSeparator jSeparator1;
  private javax.swing.JSeparator jSeparator2;
  private javax.swing.JButton jbAgregar;
  private javax.swing.JButton jbBuscar;
  private javax.swing.JButton jbCancelar;
  private javax.swing.JButton jbModificar;
  private javax.swing.JComboBox<String> jcbSector;
  private com.toedter.calendar.JDateChooser jdFecha;
  private com.toedter.calendar.JDateChooser jdcFecha;
  private javax.swing.JRadioButton jrActivoPedido;
  private javax.swing.JRadioButton jrbActivo;
  private javax.swing.JRadioButton jrbInactivo;
  private javax.swing.JRadioButton jrbInactivoPedido;
  private javax.swing.JSpinner jsMesa;
  private javax.swing.JSpinner jsMesero;
  private javax.swing.JSpinner jsNumeroMesa;
  private javax.swing.JSpinner jsNumeroPedido;
  private javax.swing.JTable jtPedidos;
  // End of variables declaration//GEN-END:variables



//1. Cabecera 'tabla'
private void armarCabecera(){
  modelo = new DefaultTableModel() { 
    @Override
    public boolean isCellEditable(int row, int column) {
        return false; // Hace que todas las celdas no sean editables
    }
  };
  
  modelo.addColumn("ID PEDIDO");
  modelo.addColumn("N° MESA");
  modelo.addColumn("ID MESERO");
  modelo.addColumn("FECHA Y HORA");
  modelo.addColumn("ESTADO");

  jtPedidos.setModel(modelo);
  jtPedidos.getTableHeader().setReorderingAllowed(false); /*que no pueda mover las columnas*/

 }


//2. Cargar datos a la 'tabla'
private void cargarDatos(){
  modelo.setRowCount(0); // Limpiar las filas existentes del modelo
  List<Pedido> pedidos = pedidoData.listarPedidos(); // Obtener la lista de pedidos
  jtPedidos.setBackground(new java.awt.Color(153, 204, 255)); 
  for (Pedido p : pedidos) {
      modelo.addRow(new Object[]{
          p.getIdPedido(),                     // ID del Pedido
          p.getMesa().getIdMesa(),             // ID de la Mesa (asumiendo que Mesa tiene un método getIdMesa())
          p.getMesero().getIdMesero(),         // ID del Mesero (asumiendo que Mesero tiene un método getIdMesero())
          p.getFechaHora(),                    // Fecha y Hora del Pedido
          p.isEstado() ? "Activo" : "Inactivo" // Estado del Pedido como texto
      });
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

// 4. Configuracion del JSpinner
private void confiSpinner(){
  SpinnerNumberModel modelo = new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1);
  SpinnerNumberModel modelo2 = new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1);
  SpinnerNumberModel modelo3 = new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1);
  jsMesa.setModel(modelo);
  jsMesero.setModel(modelo2);
  jsNumeroPedido.setModel(modelo3);
}

}
