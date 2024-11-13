
package Vista;

import Modelo.Mesa;
import java.sql.Connection;
import Persistencia.Conexion;
import Persistencia.MesaData;
import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel; // (1).modelo-tabla


public class MeseroGestion extends javax.swing.JInternalFrame {
  //Atributos
  private  Connection con; /* variable q tendra la conexion */ 
  private  MesaData mesaData; 

  private DefaultTableModel modelo = new DefaultTableModel(); // (2).tabla
  
  
 
  //Consctrucotr
  public MeseroGestion() {
    initComponents();
    this.con = Conexion.getConexion(); //Obtener la conexion y guardarla.
    this.mesaData = new MesaData(con);
    
    armarCabecera();
    cargarDatos();
   
   
    this.setBorder(null);//quita el borde del JInternalFrame
    ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null); 
    
   
  }


  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jPanel1 = new javax.swing.JPanel();
    jPContenedor = new javax.swing.JPanel();
    jLabel3 = new javax.swing.JLabel();
    jPanel4 = new javax.swing.JPanel();
    jbGestionMesas = new javax.swing.JButton();
    jbGestionPedidos = new javax.swing.JButton();
    jbDetallePedido = new javax.swing.JButton();
    jBSalir = new javax.swing.JButton();
    jLabel1 = new javax.swing.JLabel();
    jbGestionReservas = new javax.swing.JButton();
    jLabel2 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();

    setBorder(null);
    getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jPanel1.setBackground(new java.awt.Color(51, 51, 51));
    jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jPContenedor.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

    javax.swing.GroupLayout jPContenedorLayout = new javax.swing.GroupLayout(jPContenedor);
    jPContenedor.setLayout(jPContenedorLayout);
    jPContenedorLayout.setHorizontalGroup(
      jPContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 1074, Short.MAX_VALUE)
    );
    jPContenedorLayout.setVerticalGroup(
      jPContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 574, Short.MAX_VALUE)
    );

    jPanel1.add(jPContenedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 1080, 580));

    jLabel3.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
    jLabel3.setForeground(new java.awt.Color(255, 102, 0));
    jLabel3.setText("Restotf");
    jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 0, 75, -1));

    jPanel4.setBackground(new java.awt.Color(204, 102, 0));

    jbGestionMesas.setText("Gestion Mesas");
    jbGestionMesas.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jbGestionMesasActionPerformed(evt);
      }
    });

    jbGestionPedidos.setText("Gestion Pedidos");
    jbGestionPedidos.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jbGestionPedidosActionPerformed(evt);
      }
    });

    jbDetallePedido.setText("Detalle Pedido");
    jbDetallePedido.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jbDetallePedidoActionPerformed(evt);
      }
    });

    jBSalir.setBackground(new java.awt.Color(0, 102, 204));
    jBSalir.setForeground(new java.awt.Color(255, 255, 255));
    jBSalir.setText("Volver al inicio");
    jBSalir.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jBSalirActionPerformed(evt);
      }
    });

    jLabel1.setFont(new java.awt.Font("Franklin Gothic Medium", 3, 26)); // NOI18N
    jLabel1.setForeground(new java.awt.Color(255, 255, 255));
    jLabel1.setText("Gestion Resto");

    jbGestionReservas.setText("Gestion Reservas");
    jbGestionReservas.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jbGestionReservasActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
    jPanel4.setLayout(jPanel4Layout);
    jPanel4Layout.setHorizontalGroup(
      jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel4Layout.createSequentialGroup()
        .addGap(32, 32, 32)
        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(jbGestionReservas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jbDetallePedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jbGestionPedidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jbGestionMesas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jBSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addContainerGap(29, Short.MAX_VALUE))
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanel4Layout.setVerticalGroup(
      jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel4Layout.createSequentialGroup()
        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(jbGestionMesas, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(32, 32, 32)
        .addComponent(jbGestionPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(33, 33, 33)
        .addComponent(jbDetallePedido, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(28, 28, 28)
        .addComponent(jbGestionReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(46, 46, 46)
        .addComponent(jBSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(93, Short.MAX_VALUE))
    );

    jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 180, 570));

    jLabel2.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
    jLabel2.setForeground(new java.awt.Color(255, 102, 0));
    jLabel2.setText("Ingreso como:");
    jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 1, 79, -1));

    jLabel4.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
    jLabel4.setForeground(new java.awt.Color(0, 153, 0));
    jLabel4.setText("Mesero");
    jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 0, 56, -1));

    getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1310, 610));

    pack();
  }// </editor-fold>//GEN-END:initComponents

  
  //Boton 'Salir'
  private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
    this.dispose(); // Cierra el JInternalFrame
    
  }//GEN-LAST:event_jBSalirActionPerformed

  // 1. Boton 'gestion mesas'
  private void jbGestionMesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGestionMesasActionPerformed
   jbGestionMesas.setBackground(new Color(140, 235, 140)); 
   //reset color de fondo de los demas Botones.
   jbGestionPedidos.setBackground(UIManager.getColor("Button.background"));
   jbDetallePedido.setBackground(UIManager.getColor("Button.background"));
   jbGestionReservas.setBackground(UIManager.getColor("Button.background"));
   
   MeseroGMesas mgm = new MeseroGMesas ();
   mgm.setSize(1020,600);
   mgm.setLocation(0,0);
   
   jPContenedor.removeAll();
   jPContenedor.add(mgm, BorderLayout.CENTER);
   jPContenedor.revalidate();
   jPContenedor.repaint();
   
    
    
    
  }//GEN-LAST:event_jbGestionMesasActionPerformed

  // 2. Boton 'gestion pedidos'
  private void jbGestionPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGestionPedidosActionPerformed
   jbGestionPedidos.setBackground(new Color(140, 235, 140));  
   //reset color de fondo de los demas Botones.
   jbGestionMesas.setBackground(UIManager.getColor("Button.background"));
   jbDetallePedido.setBackground(UIManager.getColor("Button.background"));
   jbGestionReservas.setBackground(UIManager.getColor("Button.background"));
    
    
   MeseroGPedido mgp = new MeseroGPedido ();
   mgp.setSize(1020,600);
   mgp.setLocation(0,0);
   
   jPContenedor.removeAll();
   jPContenedor.add(mgp, BorderLayout.CENTER);
   jPContenedor.revalidate();
   jPContenedor.repaint();
    
    
  }//GEN-LAST:event_jbGestionPedidosActionPerformed

  // 3 Boton 'gestion reservas'
  private void jbGestionReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGestionReservasActionPerformed
   jbGestionReservas.setBackground(new Color(140, 235, 140)); 
   //reset color de fondo de los demas Botones.
   jbGestionMesas.setBackground(UIManager.getColor("Button.background"));
   jbGestionPedidos.setBackground(UIManager.getColor("Button.background"));
   jbDetallePedido.setBackground(UIManager.getColor("Button.background"));
    
    
   MeseroGReservas mgr = new MeseroGReservas ();
   mgr.setSize(1020,600);
   mgr.setLocation(0,0);
   
   jPContenedor.removeAll();
   jPContenedor.add(mgr, BorderLayout.CENTER);
   jPContenedor.revalidate();
   jPContenedor.repaint();
  }//GEN-LAST:event_jbGestionReservasActionPerformed

  
  // 4. Boton 'Detalle del pedido'
  private void jbDetallePedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDetallePedidoActionPerformed
     jbDetallePedido.setBackground(new Color(140, 235, 140)); 
   // Resetear color de fondo de los demás botones.
   jbGestionPedidos.setBackground(UIManager.getColor("Button.background"));
   jbGestionMesas.setBackground(UIManager.getColor("Button.background"));
   jbGestionReservas.setBackground(UIManager.getColor("Button.background"));
    
   MeseroGDetallePedido mgdp = new MeseroGDetallePedido();
   mgdp.setSize(1020,600);
   mgdp.setLocation(0,0);
   
   jPContenedor.removeAll();
   jPContenedor.add(mgdp, BorderLayout.CENTER);
   jPContenedor.revalidate();
   jPContenedor.repaint();
  }//GEN-LAST:event_jbDetallePedidoActionPerformed

  
  
  
  
  
  
  
  

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton jBSalir;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JPanel jPContenedor;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel4;
  private javax.swing.JButton jbDetallePedido;
  private javax.swing.JButton jbGestionMesas;
  private javax.swing.JButton jbGestionPedidos;
  private javax.swing.JButton jbGestionReservas;
  // End of variables declaration//GEN-END:variables


//1. Cabecera 'tabla'
private void armarCabecera(){
  

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







}
