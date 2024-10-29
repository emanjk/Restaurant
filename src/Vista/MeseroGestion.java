
package Vista;

import Modelo.Mesa;
import java.sql.Connection;
import Persistencia.Conexion;
import Persistencia.MesaData;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
    jLabel1 = new javax.swing.JLabel();
    jButton1 = new javax.swing.JButton();
    jButton2 = new javax.swing.JButton();
    jButton3 = new javax.swing.JButton();
    jPContenedor = new javax.swing.JPanel();
    jButton6 = new javax.swing.JButton();
    jScrollPane1 = new javax.swing.JScrollPane();
    jtMesas = new javax.swing.JTable();
    jPanel2 = new javax.swing.JPanel();
    jLabel2 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    jSpinner1 = new javax.swing.JSpinner();
    jComboBox1 = new javax.swing.JComboBox<>();
    jLabel5 = new javax.swing.JLabel();
    jButton7 = new javax.swing.JButton();
    jButton8 = new javax.swing.JButton();
    jSeparator1 = new javax.swing.JSeparator();
    jBSalir = new javax.swing.JButton();
    jLabel3 = new javax.swing.JLabel();
    jcbSector = new javax.swing.JComboBox<>();

    setBorder(null);
    getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jPanel1.setBackground(new java.awt.Color(51, 51, 51));

    jLabel1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
    jLabel1.setForeground(new java.awt.Color(255, 102, 0));
    jLabel1.setText("Seleccione su sector:");

    jButton1.setText("Gestion Mesas");

    jButton2.setText("Gestion Pedidos");

    jButton3.setText("Detalle Pedido");

    jPContenedor.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

    jButton6.setText("Actualizar");

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

    jPanel2.setBackground(new java.awt.Color(255, 204, 0));

    jLabel2.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
    jLabel2.setForeground(new java.awt.Color(0, 0, 0));
    jLabel2.setText("Actualizar situacion");

    jLabel4.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
    jLabel4.setText("N° Mesa:");

    jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Reservado", "Libre", "Ocupado" }));

    jLabel5.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
    jLabel5.setText("Situación");

    jButton7.setText("Actualizar");

    jButton8.setText("Cancelar");

    jSeparator1.setBackground(new java.awt.Color(204, 204, 204));
    jSeparator1.setForeground(new java.awt.Color(204, 204, 204));

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
        .addGap(15, 15, 15)
        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(29, 29, 29))
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel2Layout.createSequentialGroup()
            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(jPanel2Layout.createSequentialGroup()
            .addComponent(jButton7)
            .addGap(18, 18, 18)
            .addComponent(jButton8)))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jSeparator1)
        .addContainerGap())
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(16, 16, 16))
    );
    jPanel2Layout.setVerticalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addGap(11, 11, 11)
        .addComponent(jLabel2)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel4)
          .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(47, 47, 47)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel5))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jButton7)
          .addComponent(jButton8))
        .addGap(31, 31, 31))
    );

    javax.swing.GroupLayout jPContenedorLayout = new javax.swing.GroupLayout(jPContenedor);
    jPContenedor.setLayout(jPContenedorLayout);
    jPContenedorLayout.setHorizontalGroup(
      jPContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPContenedorLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPContenedorLayout.createSequentialGroup()
            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, Short.MAX_VALUE))
          .addGroup(jPContenedorLayout.createSequentialGroup()
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addGap(25, 25, 25))
    );
    jPContenedorLayout.setVerticalGroup(
      jPContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPContenedorLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(38, 38, 38)
        .addGroup(jPContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
          .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addContainerGap(21, Short.MAX_VALUE))
    );

    jBSalir.setBackground(new java.awt.Color(255, 0, 0));
    jBSalir.setForeground(new java.awt.Color(255, 255, 255));
    jBSalir.setText("Salir");
    jBSalir.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jBSalirActionPerformed(evt);
      }
    });

    jLabel3.setFont(new java.awt.Font("Roboto", 1, 28)); // NOI18N
    jLabel3.setForeground(new java.awt.Color(255, 102, 0));
    jLabel3.setText("Restotf");

    jcbSector.setFont(new java.awt.Font("Roboto", 0, 13)); // NOI18N
    jcbSector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Terraza", "Interior", "Patio", "Privado", "Balcón", " ", " " }));
    jcbSector.setSelectedIndex(-1);
    jcbSector.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jcbSectorActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jBSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(14, 14, 14)
            .addComponent(jPContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(jLabel1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jcbSector, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(425, 425, 425)
            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addGap(122, 122, 122))
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jcbSector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGap(78, 78, 78)
            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(38, 38, 38)
            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(48, 48, 48)
            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(55, 55, 55)
            .addComponent(jBSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(jLabel3)
            .addGap(25, 25, 25)
            .addComponent(jPContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 100, Short.MAX_VALUE))))
    );

    getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, -1));

    pack();
  }// </editor-fold>//GEN-END:initComponents

  
  // 1. Boton 'Salir'
  private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
    this.dispose(); // Cierra el JInternalFrame
    
  }//GEN-LAST:event_jBSalirActionPerformed

  // 2. Seleccionar por Sector
  private void jcbSectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbSectorActionPerformed
     String sectorSeleccionado = (String) jcbSector.getSelectedItem();
     
     // Verifica si el sector es válido (no debe ser "Mostrar por sector")
    if (sectorSeleccionado == null) {
        JOptionPane.showMessageDialog(null, "Seleccione un sector válido");
        return;
    }
    
    
    
    //Cargar a la tabla
    modelo.setRowCount(0); /*Limpiar la tabla antes de cargar nuevos datos*/
    List<Mesa> mesasSector = mesaData.listarMesasPorSector(sectorSeleccionado); 

     // Agregar las mesas al modelo de la tabla
    for (Mesa m : mesasSector) {
        modelo.addRow(new Object[]{
            m.getIdMesa(),
            m.getCapacidad(),
            m.isEstado(),
            m.getSector(),
            m.getSituacion(),
        });
    }
    
    // Establecer el modelo actualizado a la tabla
    jtMesas.setModel(modelo); 
    
  }//GEN-LAST:event_jcbSectorActionPerformed


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton jBSalir;
  private javax.swing.JButton jButton1;
  private javax.swing.JButton jButton2;
  private javax.swing.JButton jButton3;
  private javax.swing.JButton jButton6;
  private javax.swing.JButton jButton7;
  private javax.swing.JButton jButton8;
  private javax.swing.JComboBox<String> jComboBox1;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JPanel jPContenedor;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JSeparator jSeparator1;
  private javax.swing.JSpinner jSpinner1;
  private javax.swing.JComboBox<String> jcbSector;
  private javax.swing.JTable jtMesas;
  // End of variables declaration//GEN-END:variables


//3. Cabecera 'tabla'
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

//4. Cargar datos a la 'tabla'
private void cargarDatos(){
  modelo.setRowCount(0);
  List<Mesa> mesas = mesaData.listarMesas();
  for(Mesa m: mesas){
    modelo.addRow(new Object[]{
                  m.getIdMesa(), // Suponiendo que tienes el método getIdAlumno en tu clase Alumno
                  m.getCapacidad(),
                  m.isEstado(),
                  m.getSector(),
                  m.getSituacion(),
                  
              });
  
  }
}


// 5. Cargar por sector
private void cargarDatosPorSector(String sector) {
    modelo.setRowCount(0); // Limpiar la tabla antes de cargar nuevos datos

    // Suponiendo que tu método en MesaData ya acepta un String para filtrar
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
