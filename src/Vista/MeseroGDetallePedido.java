
package Vista;

import Modelo.Mesa;
import Modelo.Pedido; // Clase pedido
import Modelo.PedidoProducto;
import Modelo.Mesero;
import Modelo.Producto;
import Persistencia.MeseroData;
import Persistencia.PedidoData; // Pedido Data
import Persistencia.PedidoProductoData;

import java.sql.Connection;
import Persistencia.Conexion;
import Persistencia.ProductoData;


import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel; // (1).modelo-tabla

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;




public class MeseroGDetallePedido extends javax.swing.JPanel {
  //Atributos
  private  Connection con; /* variable q tendra la conexion */ 

  private PedidoData pedidoData;
  private ProductoData productoData;
  private  PedidoProductoData pedidoProductoData;
  private MeseroData meseroData;
  private DefaultTableModel modelo = new DefaultTableModel(); // (2).tabla
  
  
  
  
 
  public MeseroGDetallePedido() {
    initComponents();
    this.con = Conexion.getConexion(); //Obtener la conexion y guardarla.
    
    this.pedidoData = new PedidoData(con);
    this.pedidoProductoData= new PedidoProductoData(con);
    this.productoData = new ProductoData(con);
    this.meseroData = new MeseroData(con);
    
    cargaComboSector ();
    armarCabeceraPedido();  
    cargarDatosPedidos();
    
    armarCabeceraPedidoProducto();
    cargarDatosPedidosProductos();
    confiSpinner();
  }

  
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jLabel2 = new javax.swing.JLabel();
    jcbSector = new javax.swing.JComboBox<>();
    jScrollPane1 = new javax.swing.JScrollPane();
    jtPedidos = new javax.swing.JTable();
    jScrollPane2 = new javax.swing.JScrollPane();
    jtPedidoProducto = new javax.swing.JTable();
    jLabel1 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    jPanel1 = new javax.swing.JPanel();
    jLabel4 = new javax.swing.JLabel();
    jSeparator3 = new javax.swing.JSeparator();
    jLabel5 = new javax.swing.JLabel();
    jsIdPedido = new javax.swing.JSpinner();
    jbBuscar = new javax.swing.JButton();
    jLabel6 = new javax.swing.JLabel();
    jLabel7 = new javax.swing.JLabel();
    jLabel8 = new javax.swing.JLabel();
    jLabel9 = new javax.swing.JLabel();
    jSeparator1 = new javax.swing.JSeparator();
    jsIDProducto = new javax.swing.JSpinner();
    jsCantidad = new javax.swing.JSpinner();
    jtPrecio = new javax.swing.JTextField();
    jrbActivo = new javax.swing.JRadioButton();
    jrbInactivo = new javax.swing.JRadioButton();

    setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jLabel2.setFont(new java.awt.Font("Roboto", 3, 18)); // NOI18N
    jLabel2.setForeground(new java.awt.Color(204, 0, 0));
    jLabel2.setText(" Sector:");
    add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 64, -1));

    jcbSector.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
    jcbSector.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jcbSectorActionPerformed(evt);
      }
    });
    add(jcbSector, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 8, 90, -1));

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

    add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 72, 585, 183));

    jtPedidoProducto.setModel(new javax.swing.table.DefaultTableModel(
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
    jScrollPane2.setViewportView(jtPedidoProducto);

    add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 307, 585, 184));

    jLabel1.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
    jLabel1.setForeground(new java.awt.Color(255, 102, 0));
    jLabel1.setText("Lista de Pedidos");
    add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 40, -1, -1));

    jLabel3.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
    jLabel3.setForeground(new java.awt.Color(255, 102, 0));
    jLabel3.setText("Detalles del Pedido");
    add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 280, -1, -1));

    jPanel1.setBackground(new java.awt.Color(255, 204, 153));

    jLabel4.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
    jLabel4.setForeground(new java.awt.Color(255, 102, 0));
    jLabel4.setText("Detalles del Pedido");

    jSeparator3.setForeground(new java.awt.Color(102, 102, 102));

    jLabel5.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
    jLabel5.setForeground(new java.awt.Color(0, 0, 0));
    jLabel5.setText("ID PEDIDO: ");

    jbBuscar.setBackground(new java.awt.Color(0, 204, 0));
    jbBuscar.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
    jbBuscar.setForeground(new java.awt.Color(255, 255, 255));
    jbBuscar.setText("Buscar");
    jbBuscar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jbBuscarActionPerformed(evt);
      }
    });

    jLabel6.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
    jLabel6.setForeground(new java.awt.Color(0, 0, 0));
    jLabel6.setText("ID PRODUCTO: ");

    jLabel7.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
    jLabel7.setForeground(new java.awt.Color(0, 0, 0));
    jLabel7.setText("CANTIDAD:");

    jLabel8.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
    jLabel8.setForeground(new java.awt.Color(0, 0, 0));
    jLabel8.setText("PRECIO:");

    jLabel9.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
    jLabel9.setForeground(new java.awt.Color(0, 0, 0));
    jLabel9.setText("ESTADO: ");

    jSeparator1.setForeground(new java.awt.Color(204, 204, 204));

    jrbActivo.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
    jrbActivo.setForeground(new java.awt.Color(0, 0, 0));
    jrbActivo.setText("Activo");

    jrbInactivo.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
    jrbInactivo.setForeground(new java.awt.Color(0, 0, 0));
    jrbInactivo.setText("Inactivo");

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
              .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jsIdPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbBuscar))
              .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))))
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(71, 71, 71)
            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jsIDProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                  .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jrbActivo)
                    .addGap(38, 38, 38))
                  .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(jLabel7)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jsCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jrbInactivo)))))
        .addContainerGap(45, Short.MAX_VALUE))
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel4)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel5)
          .addComponent(jsIdPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jbBuscar))
        .addGap(23, 23, 23)
        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel6)
          .addComponent(jsIDProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel7)
          .addComponent(jsCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel8)
          .addComponent(jtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel9)
          .addComponent(jrbActivo)
          .addComponent(jrbInactivo))
        .addContainerGap(174, Short.MAX_VALUE))
    );

    add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 66, 316, -1));
  }// </editor-fold>//GEN-END:initComponents

  
  // 1. ComboBox 'Seleccionar Sector'
  private void jcbSectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbSectorActionPerformed
    String sectorSeleccionado = (String) jcbSector.getSelectedItem();

    // Obtener los pedidos por sector
    List<Pedido> pedidos = pedidoData.obtenerPedidosPorSector(sectorSeleccionado);

    // Limpiar la tabla jtPedidos antes de cargar los nuevos pedidos
    DefaultTableModel modeloPedidos = (DefaultTableModel) jtPedidos.getModel();
    modeloPedidos.setRowCount(0);

    // Limpiar la tabla jtPedidoProducto también
    DefaultTableModel modeloProductos = (DefaultTableModel) jtPedidoProducto.getModel();
    modeloProductos.setRowCount(0);

    // Agregar los pedidos al jtPedidos
    for (Pedido p : pedidos) {
        modeloPedidos.addRow(new Object[]{
            p.getIdPedido(),
            p.getMesa().getIdMesa(),
            p.getMesero().getIdMesero(),
            p.getFechaHora(),
            p.isEstado() ? "Activo" : "Inactivo"
        });

        // Obtener los productos asociados al pedido y cargarlos en jtPedidoProducto
        List<PedidoProducto> productos = pedidoProductoData.obtenerProductosPorPedido(p);
        for (PedidoProducto pp : productos) {
            modeloProductos.addRow(new Object[]{
                pp.getIdPedidoProducto(),
                pp.getPedido().getIdPedido(),
                pp.getProducto().getIdProducto(),
                pp.getCantidad(),
                pp.getSubtotal(),
                pp.isEstado() ? "Activo" : "Inactivo"
            });
        }
    }
  }//GEN-LAST:event_jcbSectorActionPerformed

  
  // 2. Buscar 'ID PEDIDO'
  private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
     // Verificar si se ha seleccionado un sector
    if (jcbSector.getSelectedItem() == null) {
        JOptionPane.showMessageDialog(this, "Seleccione su sector asignado.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    String sectorSeleccionado = (String) jcbSector.getSelectedItem();
    int idPedido = (int) jsIdPedido.getValue();

    // Verificar si el ID es válido (positivo)
    if (idPedido <= 0) {
        JOptionPane.showMessageDialog(this, "Por favor, seleccione un ID de pedido válido.");
        return;
    }

    // Obtener la lista de pedidos del sector seleccionado
    List<Pedido> pedidosDelSector = pedidoData.obtenerPedidosPorSector(sectorSeleccionado);

    // Buscar el pedido específico en la lista del sector
    Pedido pedidoEncontrado = null;
    for (Pedido pedido : pedidosDelSector) {
        if (pedido.getIdPedido() == idPedido) {
            pedidoEncontrado = pedido;
            break;
        }
    }

    if (pedidoEncontrado == null) {
        // Mensaje si el pedido no pertenece al sector seleccionado
        JOptionPane.showMessageDialog(this,
            "El pedido con ID " + idPedido + " no pertenece al sector '" + sectorSeleccionado + "'.",
            "Pedido no encontrado",
            JOptionPane.INFORMATION_MESSAGE);
        return;
    }

    // Limpiar la tabla de pedidos
    DefaultTableModel modeloPedidos = (DefaultTableModel) jtPedidos.getModel();
    modeloPedidos.setRowCount(0);

    // Cargar el pedido encontrado en la tabla de pedidos
    modeloPedidos.addRow(new Object[]{
        pedidoEncontrado.getIdPedido(),
        pedidoEncontrado.getMesa().getIdMesa(),
        pedidoEncontrado.getMesero().getIdMesero(),
        pedidoEncontrado.getFechaHora(),
        pedidoEncontrado.isEstado() ? "Activo" : "Inactivo"
    });

    // 3. Obtener los productos del pedido encontrado
    List<PedidoProducto> productosDelPedido = pedidoProductoData.obtenerProductosPorPedido(pedidoEncontrado);

    // Limpiar la tabla de productos
    DefaultTableModel modeloProductos = (DefaultTableModel) jtPedidoProducto.getModel();
    modeloProductos.setRowCount(0);

    // Cargar los productos del pedido en la tabla
    for (PedidoProducto pedidoProducto : productosDelPedido) {
        modeloProductos.addRow(new Object[]{
            pedidoProducto.getIdPedidoProducto(), // idPedidoProducto
            pedidoProducto.getPedido().getIdPedido(), // idPedido
            pedidoProducto.getProducto().getIdProducto(), // idProducto
            pedidoProducto.getCantidad(), // cantidad
            pedidoProducto.getSubtotal(), // subtotal
            pedidoProducto.isEstado() ? "Activo" : "Inactivo" // estado
        });
    }
    

 
   
   
  }//GEN-LAST:event_jbBuscarActionPerformed


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JLabel jLabel8;
  private javax.swing.JLabel jLabel9;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JSeparator jSeparator1;
  private javax.swing.JSeparator jSeparator3;
  private javax.swing.JButton jbBuscar;
  private javax.swing.JComboBox<String> jcbSector;
  private javax.swing.JRadioButton jrbActivo;
  private javax.swing.JRadioButton jrbInactivo;
  private javax.swing.JSpinner jsCantidad;
  private javax.swing.JSpinner jsIDProducto;
  private javax.swing.JSpinner jsIdPedido;
  private javax.swing.JTable jtPedidoProducto;
  private javax.swing.JTable jtPedidos;
  private javax.swing.JTextField jtPrecio;
  // End of variables declaration//GEN-END:variables


//1. Cabecera 'tabla pedido'
private void armarCabeceraPedido(){
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

//2. Cabecera 'pedido-producto'
private void armarCabeceraPedidoProducto(){
  modelo = new DefaultTableModel() { 
    @Override
    public boolean isCellEditable(int row, int column) {
        return false; // Hace que todas las celdas no sean editables
    }
  };
  
  modelo.addColumn("ID PEDIDO-PRODUCTO");
  modelo.addColumn("ID PEDIDO");
  modelo.addColumn("ID PRODUCTO");
  modelo.addColumn("CANTIDAD");
  modelo.addColumn("SUBTOTAL");
  modelo.addColumn("ESTADO");

  jtPedidoProducto.setModel(modelo);
  jtPedidoProducto.getTableHeader().setReorderingAllowed(false); /*que no pueda mover las columnas*/

 }


// 1.2 Cargar datos de 'Pedidos'
private void cargarDatosPedidos(){
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

  
// 2.2 Cargar datos de 'Pedido-producto'
private void cargarDatosPedidosProductos(){
  modelo.setRowCount(0); // Limpiar las filas existentes del modelo

  List<PedidoProducto> pedidosProductos = pedidoProductoData.obtenerPedidosProductos();
  jtPedidoProducto.setBackground(new java.awt.Color(153, 204, 255)); 

  for (PedidoProducto pp : pedidosProductos) {
      // Obtener datos relacionados con Pedido y Producto
      Pedido pedido = new PedidoData(con).buscarPedidoPorId(pp.getPedido().getIdPedido());
      Producto producto = new ProductoData(con).buscarProductoPorId(pp.getProducto().getIdProducto());

      modelo.addRow(new Object[]{
          pp.getIdPedidoProducto(),               // ID del PedidoProducto
          pedido.getIdPedido(),                  // ID del Pedido relacionado
          producto.getNombre(),                  // Nombre del Producto relacionado
          pp.getCantidad(),                      // Cantidad del producto en el pedido
          pp.getSubtotal(),                      // Subtotal para este producto
          pp.isEstado() ? "Activo" : "Inactivo"  // Estado como texto
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
  SpinnerNumberModel model = new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1);
  jsIdPedido.setModel(model);

}


}
