
package Vista;

import javax.swing.JInternalFrame;


public class Menu extends javax.swing.JFrame {

    
    public Menu() {
        initComponents();
       this.setLocationRelativeTo(this);
    }

    
    @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jPanel3 = new javax.swing.JPanel();
    escritorio = new javax.swing.JDesktopPane();
    jPanel1 = new javax.swing.JPanel();
    jBAdmin = new javax.swing.JButton();
    jBCliente = new javax.swing.JButton();
    jBMesero = new javax.swing.JButton();
    jPanel2 = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jPanel3.setForeground(new java.awt.Color(255, 153, 153));
    jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    escritorio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jPanel1.setBackground(new java.awt.Color(0, 153, 204));
    jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jBAdmin.setBackground(new java.awt.Color(255, 51, 51));
    jBAdmin.setForeground(new java.awt.Color(255, 255, 255));
    jBAdmin.setText("ADMINISTRADOR");
    jBAdmin.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jBAdminActionPerformed(evt);
      }
    });
    jPanel1.add(jBAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 28, 161, 58));

    jBCliente.setBackground(new java.awt.Color(255, 51, 51));
    jBCliente.setForeground(new java.awt.Color(255, 255, 255));
    jBCliente.setText("CLIENTE");
    jPanel1.add(jBCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 191, 161, 58));

    jBMesero.setBackground(new java.awt.Color(255, 51, 51));
    jBMesero.setForeground(new java.awt.Color(255, 255, 255));
    jBMesero.setText("MESERO");
    jBMesero.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jBMeseroActionPerformed(evt);
      }
    });
    jPanel1.add(jBMesero, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 115, 161, 58));

    escritorio.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 280));

    jPanel2.setBackground(new java.awt.Color(255, 204, 204));
    jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jLabel1.setFont(new java.awt.Font("MV Boli", 1, 36)); // NOI18N
    jLabel1.setText("BIENVENIDO");
    jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 130, -1, 26));

    escritorio.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 0, 490, 280));

    jPanel3.add(escritorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 280));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

    //1. Ingresar como 'Mesero'
  private void jBMeseroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBMeseroActionPerformed
    escritorio.removeAll();  // Limpia cualquier ventana interna existente
    escritorio.repaint();
    
    LoginMesero loginMesero = new LoginMesero();  // Asegúrate de que LoginMesero extienda JInternalFrame
    loginMesero.setVisible(true);
    
     escritorio.add(loginMesero);
     escritorio.moveToFront(loginMesero);
   
  }//GEN-LAST:event_jBMeseroActionPerformed

  private void jBAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAdminActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_jBAdminActionPerformed

    
    
    
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
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JPanel jPanel3;
  // End of variables declaration//GEN-END:variables
}
