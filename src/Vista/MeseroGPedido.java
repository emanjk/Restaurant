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
import java.awt.Color;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
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
    jLabel13 = new javax.swing.JLabel();
    jtNumeroMesero = new javax.swing.JTextField();
    jPanel1 = new javax.swing.JPanel();
    jLabel14 = new javax.swing.JLabel();
    jLabel15 = new javax.swing.JLabel();
    jLabel16 = new javax.swing.JLabel();
    jLabel17 = new javax.swing.JLabel();
    jsMesas = new javax.swing.JSpinner();
    jrbEstadoActivo = new javax.swing.JRadioButton();
    jrbEstadoInactivo = new javax.swing.JRadioButton();
    jdtFechaUno = new com.toedter.calendar.JDateChooser();
    jdcFechaDos = new com.toedter.calendar.JDateChooser();
    jbBuscarMesa = new javax.swing.JButton();
    jLabel18 = new javax.swing.JLabel();
    jdcBuscarFecha = new com.toedter.calendar.JDateChooser();
    jbBuscarDosFechas = new javax.swing.JButton();
    jSeparator3 = new javax.swing.JSeparator();

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

    jLabel1.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
    jLabel1.setForeground(new java.awt.Color(255, 102, 0));
    jLabel1.setText("Registrar Nuevo Pedido");

    jSeparator1.setForeground(new java.awt.Color(204, 204, 204));

    jLabel3.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
    jLabel3.setForeground(new java.awt.Color(0, 0, 0));
    jLabel3.setText("Mesa N°: ");

    jLabel4.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
    jLabel4.setForeground(new java.awt.Color(0, 0, 0));
    jLabel4.setText("N° Mesero: ");

    jLabel5.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
    jLabel5.setForeground(new java.awt.Color(0, 0, 0));
    jLabel5.setText("Fecha: ");

    jLabel8.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
    jLabel8.setForeground(new java.awt.Color(0, 0, 0));
    jLabel8.setText("Estado: ");

    jrbActivo.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
    jrbActivo.setForeground(new java.awt.Color(0, 0, 0));
    jrbActivo.setText("Activo");
    jrbActivo.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jrbActivoActionPerformed(evt);
      }
    });

    jrbInactivo.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
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
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jSeparator1))
          .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
            .addGap(6, 6, 6)
            .addComponent(jLabel3)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jsMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE)))
        .addGap(8, 8, 8))
      .addGroup(jPanel3Layout.createSequentialGroup()
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel3Layout.createSequentialGroup()
            .addGap(16, 16, 16)
            .addComponent(jLabel1))
          .addGroup(jPanel3Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel4)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jsMesero, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(jPanel3Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jdFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(jPanel3Layout.createSequentialGroup()
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jrbActivo))
              .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jbAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jrbInactivo)
              .addComponent(jbCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))))
        .addContainerGap(26, Short.MAX_VALUE))
    );
    jPanel3Layout.setVerticalGroup(
      jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel3Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel1)
        .addGap(4, 4, 4)
        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel3)
          .addComponent(jsMesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel4)
          .addComponent(jsMesero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel5)
          .addComponent(jdFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(26, 26, 26)
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel8)
          .addComponent(jrbActivo)
          .addComponent(jrbInactivo))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jbCancelar)
          .addComponent(jbAgregar))
        .addGap(15, 15, 15))
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

    jLabel7.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
    jLabel7.setForeground(new java.awt.Color(255, 102, 0));
    jLabel7.setText(" Actualizar Estado  ");

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
    jLabel10.setText("N° Mesa:");

    jLabel11.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
    jLabel11.setForeground(new java.awt.Color(0, 0, 0));
    jLabel11.setText("Fecha: ");

    jLabel12.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
    jLabel12.setForeground(new java.awt.Color(0, 0, 0));
    jLabel12.setText("Estado: ");

    jrActivoPedido.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
    jrActivoPedido.setForeground(new java.awt.Color(0, 0, 0));
    jrActivoPedido.setText("Activo");
    jrActivoPedido.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jrActivoPedidoActionPerformed(evt);
      }
    });

    jrbInactivoPedido.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
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

    jLabel13.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
    jLabel13.setForeground(new java.awt.Color(0, 0, 0));
    jLabel13.setText("N° Mesero: ");

    javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
    jPanel4.setLayout(jPanel4Layout);
    jPanel4Layout.setHorizontalGroup(
      jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel4Layout.createSequentialGroup()
        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jsNumeroPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jsNumeroMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))))
          .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
            .addGap(48, 48, 48)
            .addComponent(jLabel7))
          .addGroup(jPanel4Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      .addGroup(jPanel4Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
              .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtNumeroMesero, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 61, Short.MAX_VALUE)))
            .addGap(23, 23, 23))
          .addGroup(jPanel4Layout.createSequentialGroup()
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jrActivoPedido))
              .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jbModificar)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
              .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jrbInactivoPedido)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
    );
    jPanel4Layout.setVerticalGroup(
      jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel4Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel7)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
        .addGap(18, 18, 18)
        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel13)
          .addComponent(jtNumeroMesero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jLabel11)
          .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel12)
          .addComponent(jrActivoPedido)
          .addComponent(jrbInactivoPedido))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jbModificar)
          .addComponent(jButton3))
        .addContainerGap(12, Short.MAX_VALUE))
    );

    jPanel1.setBackground(new java.awt.Color(255, 204, 153));

    jLabel14.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
    jLabel14.setForeground(new java.awt.Color(255, 102, 0));
    jLabel14.setText("Consultar Pedidos");

    jLabel15.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
    jLabel15.setForeground(new java.awt.Color(0, 0, 0));
    jLabel15.setText("Buscar por Mesa:");

    jLabel16.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
    jLabel16.setForeground(new java.awt.Color(0, 0, 0));
    jLabel16.setText("Buscar por Estado:");

    jLabel17.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
    jLabel17.setForeground(new java.awt.Color(0, 0, 0));
    jLabel17.setText("Buscar por Fechas: ");

    jrbEstadoActivo.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
    jrbEstadoActivo.setForeground(new java.awt.Color(0, 0, 0));
    jrbEstadoActivo.setText("Activo");
    jrbEstadoActivo.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jrbEstadoActivoActionPerformed(evt);
      }
    });

    jrbEstadoInactivo.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
    jrbEstadoInactivo.setForeground(new java.awt.Color(0, 0, 0));
    jrbEstadoInactivo.setText("Inactivo");
    jrbEstadoInactivo.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jrbEstadoInactivoActionPerformed(evt);
      }
    });

    jdcFechaDos.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
      public void propertyChange(java.beans.PropertyChangeEvent evt) {
        jdcFechaDosPropertyChange(evt);
      }
    });

    jbBuscarMesa.setBackground(new java.awt.Color(0, 204, 0));
    jbBuscarMesa.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
    jbBuscarMesa.setForeground(new java.awt.Color(255, 255, 255));
    jbBuscarMesa.setText("Buscar");
    jbBuscarMesa.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jbBuscarMesaActionPerformed(evt);
      }
    });

    jLabel18.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
    jLabel18.setForeground(new java.awt.Color(0, 0, 0));
    jLabel18.setText("Buscar por Fecha: ");

    jdcBuscarFecha.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
      public void propertyChange(java.beans.PropertyChangeEvent evt) {
        jdcBuscarFechaPropertyChange(evt);
      }
    });

    jbBuscarDosFechas.setBackground(new java.awt.Color(0, 204, 0));
    jbBuscarDosFechas.setForeground(new java.awt.Color(255, 255, 255));
    jbBuscarDosFechas.setText("Buscar");
    jbBuscarDosFechas.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jbBuscarDosFechasActionPerformed(evt);
      }
    });

    jSeparator3.setForeground(new java.awt.Color(204, 204, 204));

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jLabel14)
        .addGap(175, 175, 175))
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(jLabel16)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jrbEstadoActivo)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jrbEstadoInactivo)
            .addGap(0, 0, Short.MAX_VALUE))
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jdtFechaUno, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jdcFechaDos, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbBuscarDosFechas))
              .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jdcBuscarFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jsMesas, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jbBuscarMesa)))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(143, 143, 143)
        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel15)
          .addComponent(jsMesas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jbBuscarMesa))
        .addGap(18, 18, 18)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel16)
          .addComponent(jrbEstadoActivo)
          .addComponent(jrbEstadoInactivo))
        .addGap(19, 19, 19)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(jdcFechaDos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jbBuscarDosFechas)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
              .addComponent(jLabel18)
              .addComponent(jdcBuscarFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
              .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jdtFechaUno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        .addGap(28, 28, 28))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jcbSector, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(689, 689, 689)
            .addComponent(jLabel6))
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addContainerGap(115, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGap(5, 5, 5)
            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(jcbSector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabel2)))
        .addGap(18, 18, 18)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(27, Short.MAX_VALUE))
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
        jsMesas.setModel(modelo);
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
            p.isEstado() ? "Activo" : "Inactivo" // Estado
        });
    }  
  }//GEN-LAST:event_jcbSectorActionPerformed

  // 2. Agregar: Pedido
  private void jbAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarActionPerformed
    // Validación de campos
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

    // Personalizar botones de confirmación
    Object[] options = {"Confirmar", "Cancelar"};
    
    // Preguntar al usuario si está seguro de agregar el pedido
    int respuesta = JOptionPane.showOptionDialog(
            null, 
            "¿Está seguro de que desea agregar este pedido?", 
            "Confirmación", 
            JOptionPane.DEFAULT_OPTION, 
            JOptionPane.QUESTION_MESSAGE, 
            null, 
            options, 
            options[0]  // El botón "Confirmar" será el seleccionado por defecto
    );

    // Si el usuario selecciona "Confirmar" (índice 0), se agrega el pedido
    if (respuesta == 0) { 
        int numeroMesa = (Integer) jsMesa.getValue();  
        int numeroMesero = (Integer) jsMesero.getValue();  
        Date fechaSeleccionada = jdFecha.getDate();  
        LocalDateTime fechaHora = fechaSeleccionada.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();  // Convertir a LocalDateTime

        boolean estado = jrbActivo.isSelected(); 

        // Crear el objeto Pedido
        Mesa mesa = mesaData.buscarMesa(numeroMesa);  // Método para obtener la mesa por su ID
        Mesero mesero = meseroData.buscarMeseroPorId(numeroMesero);  // Método para obtener el mesero por su ID
        Pedido pedido = new Pedido(mesa, mesero, fechaHora, estado, new ArrayList<PedidoProducto>()); 

        // Guardar el pedido en la base de datos
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
    } else {
        // Si el usuario selecciona "Cancelar" (índice 1), no se agrega el pedido
        JOptionPane.showMessageDialog(null, "El pedido no fue agregado.", "Cancelado", JOptionPane.INFORMATION_MESSAGE);
    }
     
    
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
    String sectorSeleccionado = (String) jcbSector.getSelectedItem();

    // Obtener los pedidos del sector seleccionado
    List<Pedido> pedidosPorSector = pedidoData.obtenerPedidosPorSector(sectorSeleccionado);

    // Verificar si el pedido está en el sector seleccionado
    Pedido pedido = null;
    for (Pedido p : pedidosPorSector) {
        if (p.getIdPedido() == idPedido) {
            pedido = p;
            break;
        }
    }

    // Si no se encontró el pedido en el sector seleccionado
    if (pedido == null) {
        JOptionPane.showMessageDialog(null, "El ID del Pedido no corresponde al sector seleccionado o no existe. ", "Advertencia", JOptionPane.WARNING_MESSAGE);
        return;
    }

    // Si se encuentra el pedido, cargar los datos en los campos
    jsNumeroMesa.setValue(pedido.getMesa().getIdMesa());  
    jdcFecha.setDate(java.sql.Date.valueOf(pedido.getFechaHora().toLocalDate())); // Usamos .toLocalDate() para obtener solo la fecha
    if (pedido.isEstado()) {
        jrActivoPedido.setSelected(true);
        jrbInactivoPedido.setSelected(false);
    } else {
        jrActivoPedido.setSelected(false);
        jrbInactivoPedido.setSelected(true);
    }

    // Llenar el campo jtNumeroMesero con el número del mesero que tomó el pedido
    jtNumeroMesero.setText(String.valueOf(pedido.getMesero().getIdMesero()));  // Obtener el número del mesero y asignarlo como texto
   
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

    // Consulta
    String sectorSeleccionado = (String) jcbSector.getSelectedItem();
    int idPedido = (Integer) jsNumeroPedido.getValue();
    Pedido pedido = pedidoData.buscarPedidoPorId(idPedido); // Buscar el pedido en la base de datos
    if (pedido == null) {
        JOptionPane.showMessageDialog(null, "No se encontró el pedido con ID: " + idPedido, "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Validar si el pedido pertenece al sector seleccionado
    String sectorPedido = pedido.getMesa().getSector(); // Obtener el sector de la mesa del pedido
    if (!sectorSeleccionado.equalsIgnoreCase(sectorPedido)) {
        JOptionPane.showMessageDialog(null, "El pedido con ID: " + idPedido + " pertenece al sector '" 
                + sectorPedido + "', no puede modificarlo.", "Acción no permitida", JOptionPane.WARNING_MESSAGE);
        return;
    }

    // Confirmar modificación con botones personalizados
    Object[] options = {"Confirmar", "Cancelar"};
    int confirmacion = JOptionPane.showOptionDialog(
        null, 
        "¿Está seguro de que desea modificar este pedido?", 
        "Confirmar modificación", 
        JOptionPane.DEFAULT_OPTION, 
        JOptionPane.QUESTION_MESSAGE, 
        null, 
        options, 
        options[0]  // Establecemos "Confirmar" como el botón predeterminado
    );

    if (confirmacion != 0) {  // Si el usuario elige "Cancelar" (índice 1), no hacer nada
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

  
  // 10. Boton 'Buscar por numero de mesa'
  private void jbBuscarMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarMesaActionPerformed
    // Validar si se ha seleccionado un sector
    String sectorSeleccionado = (String) jcbSector.getSelectedItem();
    if (sectorSeleccionado == null || sectorSeleccionado.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Seleccione su sector asignado.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Obtener el número de mesa seleccionado
    int idMesaSeleccionada = (Integer) jsMesas.getValue();

    // Obtener pedidos por sector
    List<Pedido> pedidosPorSector = pedidoData.obtenerPedidosPorSector(sectorSeleccionado);

    // Filtrar los pedidos por la mesa seleccionada
    List<Pedido> pedidosFiltradosPorMesa = pedidosPorSector.stream()
        .filter(pedido -> pedido.getMesa().getIdMesa() == idMesaSeleccionada)
        .collect(Collectors.toList());

    // Verificar si hay pedidos para la combinación sector-mesa seleccionada
    if (pedidosFiltradosPorMesa.isEmpty()) {
        JOptionPane.showMessageDialog(null, "No hay pedidos registrados para la mesa seleccionada en este sector.", "Información", JOptionPane.INFORMATION_MESSAGE);
        return;
    }

    // Actualizar la tabla con los pedidos encontrados
    DefaultTableModel modelo = (DefaultTableModel) jtPedidos.getModel();
    modelo.setRowCount(0); // Limpiar la tabla antes de agregar nuevos datos

    for (Pedido pedido : pedidosFiltradosPorMesa) {
        modelo.addRow(new Object[]{
            pedido.getIdPedido(),
            pedido.getMesa().getIdMesa(),
            pedido.getMesero().getIdMesero(),
            pedido.getFechaHora(),
            pedido.isEstado() ? "Activo" : "Inactivo"
        });
    }

   
       
  }//GEN-LAST:event_jbBuscarMesaActionPerformed

  // 11. jrb 'Activo'
  private void jrbEstadoActivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbEstadoActivoActionPerformed
   if (jrbEstadoActivo.isSelected()) {
        jrbEstadoInactivo.setSelected(false); // Desmarcar el otro botón

        // Validar si se ha seleccionado un sector
        String sectorSeleccionado = (String) jcbSector.getSelectedItem();
        if (sectorSeleccionado == null || sectorSeleccionado.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Seleccione su sector asignado", "Error", JOptionPane.ERROR_MESSAGE);
            jrbEstadoActivo.setSelected(false);
            return;
        }

        // Obtener los pedidos del sector seleccionado
        List<Pedido> pedidosSector = pedidoData.obtenerPedidosPorSector(sectorSeleccionado);

        // Filtrar pedidos activos
        List<Pedido> pedidosActivos = new ArrayList<>();
        for (Pedido pedido : pedidosSector) {
            if (pedido.isEstado()) { // Comprobamos si está activo
                pedidosActivos.add(pedido);
            }
        }

        // Verificar si hay pedidos para mostrar
        if (pedidosActivos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay pedidos activos para el sector seleccionado.", "Información", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Actualizar la tabla con los pedidos activos
        DefaultTableModel modelo = (DefaultTableModel) jtPedidos.getModel();
        modelo.setRowCount(0); // Limpiar la tabla

        for (Pedido pedido : pedidosActivos) {
            modelo.addRow(new Object[]{
                pedido.getIdPedido(),
                pedido.getMesa().getIdMesa(),
                pedido.getMesero().getIdMesero(),
                pedido.getFechaHora(),
                pedido.isEstado() ? "Activo" : "Inactivo"
            });
        }
    }
    
    
    
  }//GEN-LAST:event_jrbEstadoActivoActionPerformed

  
  
  // 12. jrb 'Inactivo'
  private void jrbEstadoInactivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbEstadoInactivoActionPerformed
   if(jrbEstadoInactivo.isSelected()){
     jrbEstadoActivo.setSelected(false);
   
   }
    if (jrbEstadoInactivo.isSelected()) {
        jrbEstadoActivo.setSelected(false); // Desmarcar el otro botón

        // Validar si se ha seleccionado un sector
        String sectorSeleccionado = (String) jcbSector.getSelectedItem();
        if (sectorSeleccionado == null || sectorSeleccionado.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Seleccione su sector asignado", "Error", JOptionPane.ERROR_MESSAGE);
            jrbEstadoInactivo.setSelected(false); // Desmarcar el botón si no hay sector
            return;
        }

        // Obtener los pedidos del sector seleccionado
        List<Pedido> pedidosSector = pedidoData.obtenerPedidosPorSector(sectorSeleccionado);

        // Filtrar pedidos inactivos
        List<Pedido> pedidosInactivos = new ArrayList<>();
        for (Pedido pedido : pedidosSector) {
            if (!pedido.isEstado()) { // Verificar si el pedido está inactivo
                pedidosInactivos.add(pedido);
            }
        }

        // Verificar si hay pedidos inactivos para mostrar
        if (pedidosInactivos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay pedidos inactivos para el sector seleccionado.", "Información", JOptionPane.INFORMATION_MESSAGE);
            DefaultTableModel modelo = (DefaultTableModel) jtPedidos.getModel();
            modelo.setRowCount(0); // Limpiar la tabla en caso de no haber datos
            return;
        }

        // Actualizar la tabla con los pedidos inactivos
        DefaultTableModel modelo = (DefaultTableModel) jtPedidos.getModel();
        modelo.setRowCount(0); // Limpiar la tabla antes de llenarla

        for (Pedido pedido : pedidosInactivos) {
            modelo.addRow(new Object[]{
                pedido.getIdPedido(),
                pedido.getMesa().getIdMesa(),
                pedido.getMesero().getIdMesero(),
                pedido.getFechaHora(),
                "Inactivo" // Solo cargamos inactivos
            });
        }
    }
    
  }//GEN-LAST:event_jrbEstadoInactivoActionPerformed

  // 13. Buscar mesa por una Fecha
  private void jdcBuscarFechaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jdcBuscarFechaPropertyChange
    if ("date".equals(evt.getPropertyName())) { // Detecta cambios en la fecha seleccionada
        if (jdcBuscarFecha.getDate() != null) {
            // Convertir la fecha seleccionada en LocalDate
            LocalDate fechaSeleccionada = jdcBuscarFecha.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            // Obtener pedidos por fecha
            List<Pedido> pedidos = pedidoData.buscarPedidosPorFecha(fechaSeleccionada);

            // Limpiar la tabla
            DefaultTableModel modelo = (DefaultTableModel) jtPedidos.getModel();
            modelo.setRowCount(0);

            // Mostrar los pedidos en la tabla
            for (Pedido pedido : pedidos) {
                modelo.addRow(new Object[]{
                    pedido.getIdPedido(),
                    pedido.getMesa().getIdMesa(),
                    pedido.getMesero().getIdMesero(),
                    pedido.getFechaHora(),
                    pedido.isEstado() ? "Activo" : "Inactivo"
                });
            }

            // Mostrar mensaje si no hay resultados
            if (pedidos.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se encontraron pedidos para la fecha seleccionada.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fecha.");
        }
    }
  }//GEN-LAST:event_jdcBuscarFechaPropertyChange

  // Buscar entre dos fechas
  private void jbBuscarDosFechasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarDosFechasActionPerformed
   
    String sector = (String) jcbSector.getSelectedItem();
    if (sector == null || sector.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Seleccione su segtor asignado");
        return;
    }
    
    Date fechaInicioDate = jdtFechaUno.getDate();
    Date fechaFinDate = jdcFechaDos.getDate();

    if (fechaInicioDate == null || fechaFinDate == null) {
        JOptionPane.showMessageDialog(this, "Por favor, selecciona ambas fechas.");
        return; 
    }

    // Convertir las fechas a LocalDate (esto ya elimina la parte de la hora)
    LocalDate fechaInicio = fechaInicioDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    LocalDate fechaFin = fechaFinDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

    // Validar que la fecha de inicio no sea posterior a la fecha de fin
    if (fechaInicio.isAfter(fechaFin)) {
        JOptionPane.showMessageDialog(this, "La fecha de inicio no puede ser posterior a la fecha de fin.");
        return;
    }

    List<Pedido> pedidosPorSector = pedidoData.obtenerPedidosPorSector(sector);
    List<Pedido> pedidosPorFechas = pedidoData.buscarPedidosPorRangoDeFechas(fechaInicio, fechaFin);

    List<Pedido> pedidosFiltrados = pedidosPorSector.stream()
            .filter(pedido -> {
                // Extraer solo la fecha de cada pedido (sin la hora)
                LocalDate fechaPedido = pedido.getFechaHora().toLocalDate();
                return pedidosPorFechas.stream().anyMatch(p -> p.getFechaHora().toLocalDate().equals(fechaPedido));
            })
            .collect(Collectors.toList());

    DefaultTableModel modelo = (DefaultTableModel) jtPedidos.getModel();
    modelo.setRowCount(0); 

    for (Pedido pedido : pedidosFiltrados) {
        modelo.addRow(new Object[]{
            pedido.getIdPedido(),
            pedido.getMesa().getIdMesa(),
            pedido.getMesero().getIdMesero(),
            pedido.getFechaHora().toLocalDate(),  // Solo mostrar la fecha
            pedido.isEstado() ? "Activo" : "Inactivo"
        });
    }

    if (pedidosFiltrados.isEmpty()) {
        JOptionPane.showMessageDialog(this, "No se encontraron pedidos para los criterios seleccionados.");
    }
   

    
  }//GEN-LAST:event_jbBuscarDosFechasActionPerformed

  // 14.2 Filtrar fechas entre dos fechas
  private void jdcFechaDosPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jdcFechaDosPropertyChange

  }//GEN-LAST:event_jdcFechaDosPropertyChange

  
  
  
  
  
  

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton jButton3;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel10;
  private javax.swing.JLabel jLabel11;
  private javax.swing.JLabel jLabel12;
  private javax.swing.JLabel jLabel13;
  private javax.swing.JLabel jLabel14;
  private javax.swing.JLabel jLabel15;
  private javax.swing.JLabel jLabel16;
  private javax.swing.JLabel jLabel17;
  private javax.swing.JLabel jLabel18;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JLabel jLabel8;
  private javax.swing.JLabel jLabel9;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel3;
  private javax.swing.JPanel jPanel4;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JSeparator jSeparator1;
  private javax.swing.JSeparator jSeparator2;
  private javax.swing.JSeparator jSeparator3;
  private javax.swing.JButton jbAgregar;
  private javax.swing.JButton jbBuscar;
  private javax.swing.JButton jbBuscarDosFechas;
  private javax.swing.JButton jbBuscarMesa;
  private javax.swing.JButton jbCancelar;
  private javax.swing.JButton jbModificar;
  private javax.swing.JComboBox<String> jcbSector;
  private com.toedter.calendar.JDateChooser jdFecha;
  private com.toedter.calendar.JDateChooser jdcBuscarFecha;
  private com.toedter.calendar.JDateChooser jdcFecha;
  private com.toedter.calendar.JDateChooser jdcFechaDos;
  private com.toedter.calendar.JDateChooser jdtFechaUno;
  private javax.swing.JRadioButton jrActivoPedido;
  private javax.swing.JRadioButton jrbActivo;
  private javax.swing.JRadioButton jrbEstadoActivo;
  private javax.swing.JRadioButton jrbEstadoInactivo;
  private javax.swing.JRadioButton jrbInactivo;
  private javax.swing.JRadioButton jrbInactivoPedido;
  private javax.swing.JSpinner jsMesa;
  private javax.swing.JSpinner jsMesas;
  private javax.swing.JSpinner jsMesero;
  private javax.swing.JSpinner jsNumeroMesa;
  private javax.swing.JSpinner jsNumeroPedido;
  private javax.swing.JTextField jtNumeroMesero;
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
   SpinnerNumberModel modeloMesa = new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1);
   SpinnerNumberModel modeloMesero = new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1);
   SpinnerNumberModel modeloNumeroPedido = new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1);
   SpinnerNumberModel modeloMesas = new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1);

   
    jsMesa.setModel(modeloMesa);
    jsMesero.setModel(modeloMesero);
    jsNumeroPedido.setModel(modeloNumeroPedido);

    jsNumeroMesa.setEnabled(false);
    jdcFecha.setEnabled(false);

    jtNumeroMesero.setFocusable(false);

    jsMesas.setModel(modeloMesas);
}

}
