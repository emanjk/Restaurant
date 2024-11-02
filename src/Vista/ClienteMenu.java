
package Vista;

import java.awt.BorderLayout;


public class ClienteMenu extends javax.swing.JInternalFrame {


    public ClienteMenu() {
        initComponents();
        
        // Código para ajustar dinámicamente el tamaño y eliminar el espacio en blanco
        ajustarComponentes();
    }
    
    // Método para ajustar componentes después de la inicialización
    private void ajustarComponentes() {
        // Ajusta el tamaño de EscritorioAdmin para que ocupe todo el espacio disponible
        this.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                ajustarEscritorio();
            }
        });
    }
    private void ajustarEscritorio() {
        // Ajustar tamaño de EscritorioAdmin según el tamaño del JInternalFrame
        BarraPanel.setSize(getWidth() - BarraPanel.getWidth(), barraUp.getWidth());
        EscritorioCliente.setSize(getWidth() - BarraPanel.getWidth(), getHeight() - barraUp.getHeight());
        EscritorioCliente.setLocation(BarraPanel.getWidth(), barraUp.getHeight());
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        EscritorioCliente = new javax.swing.JPanel();
        BarraPanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        barraUp = new javax.swing.JPanel();

        EscritorioCliente.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout EscritorioClienteLayout = new javax.swing.GroupLayout(EscritorioCliente);
        EscritorioCliente.setLayout(EscritorioClienteLayout);
        EscritorioClienteLayout.setHorizontalGroup(
            EscritorioClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        EscritorioClienteLayout.setVerticalGroup(
            EscritorioClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 467, Short.MAX_VALUE)
        );

        jButton1.setText("Ver Menu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Salir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BarraPanelLayout = new javax.swing.GroupLayout(BarraPanel);
        BarraPanel.setLayout(BarraPanelLayout);
        BarraPanelLayout.setHorizontalGroup(
            BarraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BarraPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
        );
        BarraPanelLayout.setVerticalGroup(
            BarraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BarraPanelLayout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout barraUpLayout = new javax.swing.GroupLayout(barraUp);
        barraUp.setLayout(barraUpLayout);
        barraUpLayout.setHorizontalGroup(
            barraUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 880, Short.MAX_VALUE)
        );
        barraUpLayout.setVerticalGroup(
            barraUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BarraPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(barraUp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(EscritorioCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(BarraPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(barraUp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(EscritorioCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Crear una instancia del panel ClienteVerMenu
        ClienteVerMenu verMenuFrame = new ClienteVerMenu ();

        // Remover todos los componentes anteriores en el escritorio y limpiar
        EscritorioCliente.removeAll();
        EscritorioCliente.repaint();

        // Agregar el panel GProductos al EscritorioAdmin
        EscritorioCliente.add(verMenuFrame, BorderLayout.CENTER);

        // Configurar tamaño y visibilidad del panel
        verMenuFrame.setVisible(true);
        verMenuFrame.setSize(EscritorioCliente.getWidth(), EscritorioCliente.getHeight());
        verMenuFrame.setLocation(0, 0);

        // Revalidar y repintar para asegurar que el nuevo panel se vea correctamente
        EscritorioCliente.revalidate();
        EscritorioCliente.repaint();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BarraPanel;
    private javax.swing.JPanel EscritorioCliente;
    private javax.swing.JPanel barraUp;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    // End of variables declaration//GEN-END:variables
}
