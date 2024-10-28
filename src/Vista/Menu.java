
package Vista;
import javax.swing.*;
/** @author Roma
 */
public class Menu extends javax.swing.JFrame {

    
    public Menu() {
        initComponents();
        setLocationRelativeTo(null); // Centrar la ventana principal
    }
    
@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Escritorio = new javax.swing.JDesktopPane();
        jPUsers = new javax.swing.JPanel();
        jBAdmin = new javax.swing.JButton();
        jBMesero = new javax.swing.JButton();
        jBCliente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jBAdmin.setText("ADMINISTRACION");
        jBAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAdminActionPerformed(evt);
            }
        });

        jBMesero.setText("MESERO");
        jBMesero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBMeseroActionPerformed(evt);
            }
        });

        jBCliente.setText("CLIENTE");
        jBCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPUsersLayout = new javax.swing.GroupLayout(jPUsers);
        jPUsers.setLayout(jPUsersLayout);
        jPUsersLayout.setHorizontalGroup(
            jPUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPUsersLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBAdmin)
                    .addComponent(jBMesero)
                    .addComponent(jBCliente))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPUsersLayout.setVerticalGroup(
            jPUsersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPUsersLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jBAdmin)
                .addGap(59, 59, 59)
                .addComponent(jBMesero)
                .addGap(56, 56, 56)
                .addComponent(jBCliente)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        Escritorio.setLayer(jPUsers, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout EscritorioLayout = new javax.swing.GroupLayout(Escritorio);
        Escritorio.setLayout(EscritorioLayout);
        EscritorioLayout.setHorizontalGroup(
            EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EscritorioLayout.createSequentialGroup()
                .addComponent(jPUsers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(275, Short.MAX_VALUE))
        );
        EscritorioLayout.setVerticalGroup(
            EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPUsers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    private void jBAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAdminActionPerformed
       // Abrir la ventana de administración
        Admin adminFrame = new Admin();
        Escritorio.add(adminFrame); // Agregar el JInternalFrame al JDesktopPane
        adminFrame.setVisible(true); // Hacer visible el JInternalFrame
       
    }//GEN-LAST:event_jBAdminActionPerformed

    private void jBMeseroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBMeseroActionPerformed
        MeseroMenu meseroFrame = new MeseroMenu ();
        Escritorio.add(meseroFrame); // Agregar el JInternalFrame al JDesktopPane
        meseroFrame.setVisible(true); // Hacer visible el JInternalFrame
       
    }//GEN-LAST:event_jBMeseroActionPerformed

    private void jBClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBClienteActionPerformed
        ClienteMenu clienteFrame = new  ClienteMenu();
        Escritorio.add(clienteFrame); // Agregar el JInternalFrame al JDesktopPane
        clienteFrame.setVisible(true); // Hacer visible el JInternalFrame
       
    }//GEN-LAST:event_jBClienteActionPerformed

    
    
    
    
    
    
    
    
    
    /**
     * @param args the command line arguments
     */
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
    private javax.swing.JDesktopPane Escritorio;
    private javax.swing.JButton jBAdmin;
    private javax.swing.JButton jBCliente;
    private javax.swing.JButton jBMesero;
    private javax.swing.JPanel jPUsers;
    // End of variables declaration//GEN-END:variables
}
