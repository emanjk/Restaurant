
package Vista;

import javax.swing.JInternalFrame;
import javax.swing.table.DefaultTableModel;


public class Menu extends javax.swing.JFrame {
   //Atributo
   private DefaultTableModel modelo = new DefaultTableModel(); // (2). tabla
    
   
    //Constructor
    public Menu() {
       initComponents();
       this.setLocationRelativeTo(this); //Centrar Menu
       this.setResizable(false); //no alargar
      
    }

    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        escritorio = new javax.swing.JDesktopPane();
        panel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jBAdmin = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jBMesero = new javax.swing.JButton();
        jBCliente = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        jPanel3.setForeground(new java.awt.Color(255, 153, 153));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel1.setBackground(new java.awt.Color(255, 255, 255));
        panel1.setForeground(new java.awt.Color(204, 204, 204));
        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe Print", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 96, 0));
        jLabel1.setText("Bienvenido");
        panel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 166, 28));

        jBAdmin.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jBAdmin.setText("Administrador");
        panel1.add(jBAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 140, 46));

        jSeparator1.setBackground(new java.awt.Color(204, 204, 204));
        panel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 292, 10));

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 96, 0));
        jLabel2.setText("Menú Principal");
        panel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, -1, -1));

        jBMesero.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jBMesero.setText("Mesero");
        jBMesero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBMeseroActionPerformed(evt);
            }
        });
        panel1.add(jBMesero, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 140, 46));

        jBCliente.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jBCliente.setText("Cliente");
        jBCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBClienteActionPerformed(evt);
            }
        });
        panel1.add(jBCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 140, 46));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Menu.png"))); // NOI18N

        escritorio.setLayer(panel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        escritorio.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 376, Short.MAX_VALUE)
                .addContainerGap())
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  
  // 1. Ingreso: Mesero
  private void jBMeseroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBMeseroActionPerformed

    MeseroGestion gestionA = new MeseroGestion();
    gestionA.setVisible(true); 
    escritorio.add(gestionA); 
    escritorio.moveToFront(gestionA); 
    gestionA.requestFocus(); 
   
  }//GEN-LAST:event_jBMeseroActionPerformed

    private void jBClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBClienteActionPerformed
       ClienteMenu clienteFrame = new ClienteMenu (); // Suponiendo que tienes un JInternalFrame para ver menu de productos
       escritorio.add(clienteFrame);
       clienteFrame.setVisible(true);
    }//GEN-LAST:event_jBClienteActionPerformed

  
    
  
    
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JButton jBAdmin;
    private javax.swing.JButton jBCliente;
    private javax.swing.JButton jBMesero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel panel1;
    // End of variables declaration//GEN-END:variables








}
