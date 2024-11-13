
package Vista;

/*importamos las clases:*/
import Modelo.Producto;
import Persistencia.ProductoData;
import Persistencia.Conexion;

/*importamos las clases de la API JDBC: */
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement; /*guarda codigo SQL*/
import java.sql.ResultSet; /*obtener datos o registro de un alumno*/
import java.util.Arrays;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

public class ClienteVerMenu extends javax.swing.JInternalFrame {
    
    private static Connection con; // Conexión a la base de datos
    private ProductoData productoData; // Variable para hacer: consultas, inserciones o actualizar en la BDS-restotf - Producto.
    private DefaultTableModel modelo; // Se utilizará para gestionar las columnas y filas de la tabla, usando sus metodos.
    
    
    
    public ClienteVerMenu() {
        initComponents();
        
        this.con = Conexion.getConexion(); //Obtener la conexion y guardarla.
        this.productoData = new ProductoData(con);
        
        armarCabecera(); 
        cargarTabla(); // METODO para cargar tabla con productos del menu
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtMenuProductos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtPrecioMinimo = new javax.swing.JTextField();
        jtPrecioMaximo = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jbBebida = new javax.swing.JButton();
        jbTrago = new javax.swing.JButton();
        jbDesayuno = new javax.swing.JButton();
        jbAlmuerzo = new javax.swing.JButton();
        jbCena = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1236, 749));

        jLabel1.setText("TIPOS DE PRODUCTOS DIPONIBLES EN MENÚ:");

        jtMenuProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtMenuProductos.setEnabled(false);
        jScrollPane1.setViewportView(jtMenuProductos);

        jPanel2.setBackground(new java.awt.Color(255, 204, 153));

        jButton3.setBackground(new java.awt.Color(0, 204, 204));
        jButton3.setText("Volver al inicio");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel4.setText("PRECIO MÍNIMO:");

        jLabel2.setText("PRECIO MÁXIMO:");

        jtPrecioMinimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtPrecioMinimoActionPerformed(evt);
            }
        });

        jtPrecioMaximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtPrecioMaximoActionPerformed(evt);
            }
        });
        jtPrecioMaximo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtPrecioMaximoKeyReleased(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon("D:\\Users\\segov\\Escritorio\\menu.png")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jtPrecioMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jtPrecioMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtPrecioMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtPrecioMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(117, 117, 117)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        jbBebida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/bebida.png"))); // NOI18N
        jbBebida.setText("BEBIDA");
        jbBebida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBebidaActionPerformed(evt);
            }
        });

        jbTrago.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/trago.png"))); // NOI18N
        jbTrago.setText("TRAGO");
        jbTrago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbTragoActionPerformed(evt);
            }
        });

        jbDesayuno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/cafe1.png"))); // NOI18N
        jbDesayuno.setText("DESAYUNO");
        jbDesayuno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDesayunoActionPerformed(evt);
            }
        });

        jbAlmuerzo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/cena.png"))); // NOI18N
        jbAlmuerzo.setText("ALMUERZO");
        jbAlmuerzo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAlmuerzoActionPerformed(evt);
            }
        });

        jbCena.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/cena.png"))); // NOI18N
        jbCena.setText("CENA");
        jbCena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCenaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jbBebida, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                                .addComponent(jbTrago, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)
                                .addComponent(jbDesayuno, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                                .addComponent(jbAlmuerzo)
                                .addGap(55, 55, 55)
                                .addComponent(jbCena, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1)))
                        .addGap(12, 12, 12))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(jbTrago, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbBebida)
                    .addComponent(jbDesayuno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbAlmuerzo, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbCena, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtPrecioMaximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtPrecioMaximoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtPrecioMaximoActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jtPrecioMinimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtPrecioMinimoActionPerformed

        
    }//GEN-LAST:event_jtPrecioMinimoActionPerformed

    private void jbTragoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbTragoActionPerformed
        // Limpiar la tabla antes de agregar productos filtrados    
        modelo.setRowCount(0);
        //Armar listas de productos seleccionados por tipo
        List<Producto> productos = productoData.buscarProductoPorTipo("trago");
        // Recorrer la lista de productos y agregar cada producto a la tabla
        for (Producto producto : productos) {
        // Agregar una fila con los detalles del producto a la tabla
        modelo.addRow(new Object[]{
            producto.getCodigo(),
            producto.getTipo(),
            producto.getNombre(),
            producto.getPrecio(),
            producto.getDescripcion(),
            
        });
       
        }      
    }//GEN-LAST:event_jbTragoActionPerformed

    private void jbDesayunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDesayunoActionPerformed
        // Limpiar la tabla antes de agregar productos filtrados    
        modelo.setRowCount(0);
        //Armar listas de productos seleccionados por tipo
        List<Producto> productos = productoData.buscarProductoPorTipo("desayuno");
        // Recorrer la lista de productos y agregar cada producto a la tabla
        for (Producto producto : productos) {
        // Agregar una fila con los detalles del producto a la tabla
        modelo.addRow(new Object[]{
            producto.getCodigo(),
            producto.getTipo(),
            producto.getNombre(),
            producto.getPrecio(),
            producto.getDescripcion(),
            
        });
       
        }      
    }//GEN-LAST:event_jbDesayunoActionPerformed

    private void jbAlmuerzoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAlmuerzoActionPerformed
        // Limpiar la tabla antes de agregar productos filtrados    
        modelo.setRowCount(0);
        //Armar listas de productos seleccionados por tipo
        List<Producto> productos = productoData.buscarProductoPorTipo("almuerzo");
        // Recorrer la lista de productos y agregar cada producto a la tabla
        for (Producto producto : productos) {
        // Agregar una fila con los detalles del producto a la tabla
        modelo.addRow(new Object[]{
            producto.getCodigo(),
            producto.getTipo(),
            producto.getNombre(),
            producto.getPrecio(),
            producto.getDescripcion(),
        });
       
        }      
    }//GEN-LAST:event_jbAlmuerzoActionPerformed

    private void jbCenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCenaActionPerformed
        // Limpiar la tabla antes de agregar productos filtrados    
        modelo.setRowCount(0);
        //Armar listas de productos seleccionados por tipo
        List<Producto> productos = productoData.buscarProductoPorTipo("cena");
        // Recorrer la lista de productos y agregar cada producto a la tabla
        for (Producto producto : productos) {
        // Agregar una fila con los detalles del producto a la tabla
        modelo.addRow(new Object[]{
            producto.getCodigo(),
            producto.getTipo(),
            producto.getNombre(),
            producto.getPrecio(),
            producto.getDescripcion(),
            
            
        });
       
        }      
    }//GEN-LAST:event_jbCenaActionPerformed

    private void jbBebidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBebidaActionPerformed
        
        // Limpiar la tabla antes de agregar productos filtrados    
        modelo.setRowCount(0);
        //Armar listas de productos seleccionados por tipo
        List<Producto> productos = productoData.buscarProductoPorTipo("bebida");
        // Recorrer la lista de productos y agregar cada producto a la tabla
        for (Producto producto : productos) {
        // Agregar una fila con los detalles del producto a la tabla
        modelo.addRow(new Object[]{
            producto.getCodigo(),
            producto.getTipo(),
            producto.getNombre(),
            producto.getPrecio(),
            producto.getDescripcion(),
            
        });
       
        }                                        

    }//GEN-LAST:event_jbBebidaActionPerformed
    
    
    private void jtPrecioMaximoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtPrecioMaximoKeyReleased
        modelo.setRowCount(0);
        String textoMin = jtPrecioMinimo.getText().trim();
        String textoMax = jtPrecioMaximo.getText().trim();

        if (!textoMin.isEmpty() && !textoMax.isEmpty()) {
            try {
                double precioMin = Double.parseDouble(textoMin);
                double precioMax = Double.parseDouble(textoMax);
                List<Producto> productosFiltrados = productoData.buscarProductoPorPrecio(precioMin, precioMax);

                for (Producto p : productosFiltrados) {
                    modelo.addRow(new Object[]{
                        
                        p.getCodigo(),
                        p.getTipo(),
                        p.getNombre(),
                        p.getPrecio(),
                        p.getDescripcion(),
                        
                    });
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Por favor ingresa valores numéricos válidos para el rango de precio.");
            }
        }
                            
    }//GEN-LAST:event_jtPrecioMaximoKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed


        
//METODOS PARA MI TABLA DE PRODUCTOS

//(a)Armamos las columnas de la tabla
    private void armarCabecera() {
    modelo = new DefaultTableModel() { 
    @Override
    public boolean isCellEditable(int row, int column) {
        return false; // Hace que todas las celdas no sean editables
    }
    };

    if (modelo.getColumnCount() == 0) {
        modelo.addColumn("Codigo");
        modelo.addColumn("Tipo");
        modelo.addColumn("Nombre");
        modelo.addColumn("Precio");
        modelo.addColumn("Descripcion");
        // Configurar el modelo en la tabla
        jtMenuProductos.setModel(modelo);
        jtMenuProductos.getTableHeader().setReorderingAllowed(false); /*que no pueda mover las columnas*/

    }
    }
    
//(b)Cargar datos a mi tabla productos con Menus
 
    public void cargarTabla(){
    jtMenuProductos.getTableHeader().setReorderingAllowed(false); //para q no podamos mover las columnas de la tabla.
    
    // Limpiar cualquier dato anterior en la tabla:
    modelo.setRowCount(0);
    
    // Crear la lista de productos disponibles del menu, ordenado por tipo:
    List<Producto> productos = productoData.mostrarMenu();
    
    // Recorrer la lista de productos y agregar cada producto a la tabla
    for (Producto producto : productos) {
        // Agregar una fila con los detalles del producto a la tabla
        modelo.addRow(new Object[]{
            producto.getCodigo(),
            producto.getTipo(),
            producto.getNombre(),
            producto.getPrecio(),
            producto.getDescripcion(),
            
        });
       
    }
  
    }
    
    
    
         
    
        
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAlmuerzo;
    private javax.swing.JButton jbBebida;
    private javax.swing.JButton jbCena;
    private javax.swing.JButton jbDesayuno;
    private javax.swing.JButton jbTrago;
    private javax.swing.JTable jtMenuProductos;
    private javax.swing.JTextField jtPrecioMaximo;
    private javax.swing.JTextField jtPrecioMinimo;
    // End of variables declaration//GEN-END:variables
}
