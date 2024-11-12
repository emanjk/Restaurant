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
    jSpinner1 = new javax.swing.JSpinner();
    jButton1 = new javax.swing.JButton();
    jLabel10 = new javax.swing.JLabel();
    jLabel11 = new javax.swing.JLabel();
    jLabel12 = new javax.swing.JLabel();
    jDateChooser1 = new com.toedter.calendar.JDateChooser();
    jRadioButton1 = new javax.swing.JRadioButton();
    jRadioButton2 = new javax.swing.JRadioButton();
    jButton2 = new javax.swing.JButton();
    jButton3 = new javax.swing.JButton();
    jSpinner2 = new javax.swing.JSpinner();

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
    jLabel1.setForeground(new java.awt.Color(255, 102, 0));
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

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addGroup(jPanel3Layout.createSequentialGroup()
            .addComponent(jLabel8)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jrbActivo)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
            .addComponent(jrbInactivo))
          .addGroup(jPanel3Layout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addComponent(jbAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(jbCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addGap(31, 31, 31))
      .addGroup(jPanel3Layout.createSequentialGroup()
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel3Layout.createSequentialGroup()
            .addGap(40, 40, 40)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(jPanel3Layout.createSequentialGroup()
            .addGap(20, 20, 20)
            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(jPanel3Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(11, 11, 11)
            .addComponent(jdFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(jPanel3Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel3)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jsMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(jPanel3Layout.createSequentialGroup()
            .addGap(5, 5, 5)
            .addComponent(jLabel4)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jsMesero, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanel3Layout.setVerticalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel3Layout.createSequentialGroup()
        .addGap(10, 10, 10)
        .addComponent(jLabel1)
        .addGap(8, 8, 8)
        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(7, 7, 7)
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel3)
          .addComponent(jsMesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(31, 31, 31)
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jsMesero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel4))
        .addGap(28, 28, 28)
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel5)
          .addComponent(jdFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(26, 26, 26)
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jrbActivo)
          .addComponent(jLabel8)
          .addComponent(jrbInactivo))
        .addGap(30, 30, 30)
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jbCancelar)
          .addComponent(jbAgregar))
        .addContainerGap(25, Short.MAX_VALUE))
    );

    jLabel2.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
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
    jLabel7.setForeground(new java.awt.Color(255, 102, 0));
    jLabel7.setText("Modificar Pedido");

    jSeparator2.setForeground(new java.awt.Color(204, 204, 204));

    jLabel9.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
    jLabel9.setForeground(new java.awt.Color(0, 0, 0));
    jLabel9.setText("N° Pedido: ");

    jButton1.setBackground(new java.awt.Color(51, 204, 0));
    jButton1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
    jButton1.setForeground(new java.awt.Color(255, 255, 255));
    jButton1.setText("Buscar");

    jLabel10.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
    jLabel10.setForeground(new java.awt.Color(0, 0, 0));
    jLabel10.setText("N° Mesa: ");

    jLabel11.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
    jLabel11.setForeground(new java.awt.Color(0, 0, 0));
    jLabel11.setText("Fecha: ");

    jLabel12.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
    jLabel12.setForeground(new java.awt.Color(0, 0, 0));
    jLabel12.setText("Estado: ");

    jRadioButton1.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
    jRadioButton1.setForeground(new java.awt.Color(0, 0, 0));
    jRadioButton1.setText("Activo");

    jRadioButton2.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
    jRadioButton2.setForeground(new java.awt.Color(0, 0, 0));
    jRadioButton2.setText("Inactivo");

    jButton2.setText("Modificar");

    jButton3.setText("Cancelar");

    javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
    jPanel4.setLayout(jPanel4Layout);
    jPanel4Layout.setHorizontalGroup(
      jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel4Layout.createSequentialGroup()
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
            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(jPanel4Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
              .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSpinner2))
              .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
              .addGap(18, 18, 18)
              .addComponent(jButton2)
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
              .addContainerGap()
              .addComponent(jLabel12)
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
              .addComponent(jRadioButton1)
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
              .addComponent(jRadioButton2))))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
          .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jButton1))
        .addGap(18, 18, 18)
        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel10)
          .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(26, 26, 26)
        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel11)
          .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(27, 27, 27)
        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jRadioButton1)
          .addComponent(jLabel12)
          .addComponent(jRadioButton2))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jButton2)
          .addComponent(jButton3))
        .addGap(27, 27, 27))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jcbSector, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel6))
          .addGroup(layout.createSequentialGroup()
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addGap(27, 44, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(5, 5, 5)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jcbSector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel2)
          .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        .addContainerGap(214, Short.MAX_VALUE))
    );
  }// </editor-fold>//GEN-END:initComponents

  // 1. Filtrar 'Pedidos' por sector seleccionado.
  private void jcbSectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbSectorActionPerformed
    // Obtener el sector seleccionado
    String sectorSeleccionado = (String) jcbSector.getSelectedItem();

    // Obtener el rango de mesas para el sector seleccionado
    int[] rangoMesas = pedidoData.obtenerRangoMesasPorSector(sectorSeleccionado);

    // Si se obtiene un rango válido
    if (rangoMesas[0] != 0 && rangoMesas[1] != 0) {
        // Actualizar el modelo del JSpinner con el rango de mesas
        SpinnerNumberModel modelo = new SpinnerNumberModel(rangoMesas[0], rangoMesas[0], rangoMesas[1], 1);
        jsMesa.setModel(modelo);
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

  // 2. Botton 'add Pedido'
  private void jbAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarActionPerformed

    if (jcbSector.getSelectedItem() == null) {
        JOptionPane.showMessageDialog(null, "Seleccione el sector asignado", "Error", JOptionPane.ERROR_MESSAGE);
        jsMesa.setValue(1);
        jsMesero.setValue(1);
        jdFecha.setDate(null);
        jrbActivo.setSelected(false);
        jrbInactivo.setSelected(false);
        return;
    }
    
    if(jdFecha.getDate()==null || jrbActivo.isSelected()==false || jrbInactivo.isSelected()==false){
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
    

  }//GEN-LAST:event_jbAgregarActionPerformed

  
  // 3. Estado 'Activo'
  private void jrbActivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbActivoActionPerformed
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


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton jButton1;
  private javax.swing.JButton jButton2;
  private javax.swing.JButton jButton3;
  private com.toedter.calendar.JDateChooser jDateChooser1;
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
  private javax.swing.JRadioButton jRadioButton1;
  private javax.swing.JRadioButton jRadioButton2;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JSeparator jSeparator1;
  private javax.swing.JSeparator jSeparator2;
  private javax.swing.JSpinner jSpinner1;
  private javax.swing.JSpinner jSpinner2;
  private javax.swing.JButton jbAgregar;
  private javax.swing.JButton jbCancelar;
  private javax.swing.JComboBox<String> jcbSector;
  private com.toedter.calendar.JDateChooser jdFecha;
  private javax.swing.JRadioButton jrbActivo;
  private javax.swing.JRadioButton jrbInactivo;
  private javax.swing.JSpinner jsMesa;
  private javax.swing.JSpinner jsMesero;
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

private void confiSpinner(){
  SpinnerNumberModel modelo = new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1);
  SpinnerNumberModel modelo2 = new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1);
  jsMesa.setModel(modelo);
  jsMesero.setModel(modelo2);

}

}
