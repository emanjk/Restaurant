
package Vista;
import Modelo.Mesa;
import Modelo.Reserva;
import Persistencia.MesaData;
import Persistencia.ReservaData;

import java.sql.Connection;
import Persistencia.Conexion;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.table.DefaultTableModel; // (1).modelo-tabla

public class MeseroGReservas extends javax.swing.JPanel {
  private  Connection con; /* variable q tendra la conexion */ 
  private  MesaData mesaData; 
  private ReservaData reservaData;
  private DefaultTableModel modelo = new DefaultTableModel(); // (2).tabla
  
  //constructor 
  public MeseroGReservas() {
    initComponents();
    this.con = Conexion.getConexion(); //Obtener la conexion y guardarla.
    this.mesaData = new MesaData(con);
    this.reservaData = new ReservaData(con);
    
    armarCabecera();
    cargarDatos();
    cargaComboSector ();
    modeloSpinner();
  }

  
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jLabel6 = new javax.swing.JLabel();
    jScrollPane1 = new javax.swing.JScrollPane();
    jtReservas = new javax.swing.JTable();
    jLabel7 = new javax.swing.JLabel();
    jcbSector = new javax.swing.JComboBox<>();
    jPanel2 = new javax.swing.JPanel();
    jLabel8 = new javax.swing.JLabel();
    jLabel1 = new javax.swing.JLabel();
    jrbAlta = new javax.swing.JRadioButton();
    jrbBaja = new javax.swing.JRadioButton();
    jLabel4 = new javax.swing.JLabel();
    jdcFecha = new com.toedter.calendar.JDateChooser();
    jSeparator2 = new javax.swing.JSeparator();
    jLabel9 = new javax.swing.JLabel();
    jtNombre = new javax.swing.JTextField();
    jbBuscar = new javax.swing.JButton();
    jsHora = new javax.swing.JSpinner();
    jLabel3 = new javax.swing.JLabel();
    jbMostrarTodo = new javax.swing.JButton();

    setMinimumSize(new java.awt.Dimension(973, 490));

    jLabel6.setFont(new java.awt.Font("Franklin Gothic Medium", 3, 18)); // NOI18N
    jLabel6.setForeground(new java.awt.Color(0, 204, 0));
    jLabel6.setText("Gestion  Reservas");

    jtReservas.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
    jtReservas.setModel(new javax.swing.table.DefaultTableModel(
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
    jScrollPane1.setViewportView(jtReservas);

    jLabel7.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
    jLabel7.setForeground(new java.awt.Color(204, 0, 0));
    jLabel7.setText(" Sector:");

    jcbSector.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
    jcbSector.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jcbSectorActionPerformed(evt);
      }
    });

    jPanel2.setBackground(new java.awt.Color(255, 204, 153));
    jPanel2.setForeground(new java.awt.Color(255, 204, 153));
    jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jLabel8.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
    jLabel8.setForeground(new java.awt.Color(204, 51, 0));
    jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel8.setText("Filtrar Reservas");
    jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, -1, 37));

    jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    jLabel1.setForeground(new java.awt.Color(0, 0, 0));
    jLabel1.setText("Por estado: ");
    jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 90, 20));

    jrbAlta.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
    jrbAlta.setForeground(new java.awt.Color(0, 0, 0));
    jrbAlta.setText("Alta");
    jrbAlta.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jrbAltaActionPerformed(evt);
      }
    });
    jPanel2.add(jrbAlta, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, -1, -1));

    jrbBaja.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
    jrbBaja.setForeground(new java.awt.Color(0, 0, 0));
    jrbBaja.setText("Baja");
    jrbBaja.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jrbBajaActionPerformed(evt);
      }
    });
    jPanel2.add(jrbBaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, -1, -1));

    jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    jLabel4.setForeground(new java.awt.Color(0, 0, 0));
    jLabel4.setText("Fecha:");
    jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

    jdcFecha.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
      public void propertyChange(java.beans.PropertyChangeEvent evt) {
        jdcFechaPropertyChange(evt);
      }
    });
    jPanel2.add(jdcFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 70, -1));

    jSeparator2.setForeground(new java.awt.Color(204, 204, 204));
    jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 200, 10));

    jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    jLabel9.setForeground(new java.awt.Color(0, 0, 0));
    jLabel9.setText("Nombre: ");
    jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

    jtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyReleased(java.awt.event.KeyEvent evt) {
        jtNombreKeyReleased(evt);
      }
    });
    jPanel2.add(jtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 170, -1));

    jbBuscar.setBackground(new java.awt.Color(51, 204, 0));
    jbBuscar.setForeground(new java.awt.Color(255, 255, 255));
    jbBuscar.setText("Buscar");
    jbBuscar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jbBuscarActionPerformed(evt);
      }
    });
    jPanel2.add(jbBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, 70, -1));
    jPanel2.add(jsHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 70, -1));

    jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    jLabel3.setForeground(new java.awt.Color(0, 0, 0));
    jLabel3.setText("Hora");
    jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 40, 20));

    jbMostrarTodo.setText("Mostrar todo");
    jbMostrarTodo.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jbMostrarTodoActionPerformed(evt);
      }
    });
    jPanel2.add(jbMostrarTodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel7)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jcbSector, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(665, 665, 665)
            .addComponent(jLabel6))
          .addGroup(layout.createSequentialGroup()
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addGap(24, 24, 24))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGap(8, 8, 8)
            .addComponent(jLabel6))
          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(jLabel7)
            .addComponent(jcbSector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addGap(18, 18, 18)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(132, Short.MAX_VALUE))
    );
  }// </editor-fold>//GEN-END:initComponents

  
  
  // 1. Filtrar reservas por 'Alta'
  private void jrbAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbAltaActionPerformed
             
        if(jcbSector.getSelectedItem()==null){
          JOptionPane.showMessageDialog(null, "Seleccione su sector asignado.", "Error", JOptionPane.ERROR_MESSAGE);
          jrbAlta.setSelected(false);
          return ;   
        }

        String sectorSeleccionado = (String) jcbSector.getSelectedItem();
        
        if (jrbAlta.isSelected()) {
        jrbBaja.setSelected(false); // Desmarcar el radio button 'Baja'
        

        modelo.setRowCount(0); // Limpiar la tabla antes de cargar nuevas reservas
        List<Reserva> reservasAlta = reservaData.obtenerReservasPorSector(sectorSeleccionado);
        reservasAlta = reservasAlta.stream()
                                   .filter(reserva -> reserva.isEstado()) // Filtra solo las reservas en estado "Alta"
                                   .collect(Collectors.toList());

        if (reservasAlta.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay reservas para el sector seleccionado.");
        } else {
            // Cargar las reservas 'Alta' en la tabla
            for (Reserva reserva : reservasAlta) {
                modelo.addRow(new Object[]{
                    reserva.getIdReserva(),
                    reserva.getMesa().getIdMesa(),
                    reserva.getNombreCliente(),
                    reserva.getTelefono(),
                    reserva.getComensales(),
                    reserva.getSector(),
                    reserva.getFechaHora(),
                    reserva.isEstado(),
                });
            }
        }
    }
    
    
    
  }//GEN-LAST:event_jrbAltaActionPerformed

  
  
  // 2. Mostrar tabla por sector
  private void jcbSectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbSectorActionPerformed
    jrbAlta.setSelected(false);
    jrbBaja.setSelected(false);

    String sectorSeleccionado = (String) jcbSector.getSelectedItem();
    if (sectorSeleccionado == null || sectorSeleccionado.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Seleccione su sector asignado .","Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    modelo.setRowCount(0); 

    // Obtener reservas del sector seleccionado
    List<Reserva> reservas = reservaData.obtenerReservasPorSector(sectorSeleccionado);
    if (reservas.isEmpty()) {
        JOptionPane.showMessageDialog(null, "No hay reservas para el sector seleccionado.");
        return;
    }

    // Cargar las reservas en la tabla
    for (Reserva reserva : reservas) {
        modelo.addRow(new Object[]{
            reserva.getIdReserva(),             
            reserva.getMesa().getIdMesa(),         
            reserva.getNombreCliente(),              
            reserva.getTelefono(),             
            reserva.getComensales(),              
            reserva.getSector(),       
            reserva.getFechaHora(),
            reserva.isEstado(),
        });
    }
    
  }//GEN-LAST:event_jcbSectorActionPerformed

  
  // 3. Filtrar reservas por 'Baja'
  private void jrbBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbBajaActionPerformed
     if (jrbBaja.isSelected()) {
        jrbAlta.setSelected(false); // Desmarcar el radio button 'Alta'

        // Obtener el sector seleccionado
        String sectorSeleccionado = (String) jcbSector.getSelectedItem();
        if (sectorSeleccionado == null || sectorSeleccionado.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Seleccione su sector asignado.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        modelo.setRowCount(0); // Limpiar la tabla antes de cargar nuevas reservas

        // Obtener reservas 'Baja' en el sector seleccionado
        List<Reserva> reservasBaja = reservaData.obtenerReservasPorSector(sectorSeleccionado);
        
        // Filtrar las reservas con estado 'Baja' (estado = false)
        reservasBaja = reservasBaja.stream()
                                   .filter(reserva -> !reserva.isEstado()) // Filtra solo las reservas en estado "Baja"
                                   .collect(Collectors.toList());

        if (reservasBaja.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay reservas 'Baja' para el sector seleccionado.");
        } else {
            // Cargar las reservas 'Baja' en la tabla
            for (Reserva reserva : reservasBaja) {
                modelo.addRow(new Object[]{
                    reserva.getIdReserva(),
                    reserva.getMesa().getIdMesa(),
                    reserva.getNombreCliente(),
                    reserva.getTelefono(),
                    reserva.getComensales(),
                    reserva.getSector(),
                    reserva.getFechaHora(),
                    reserva.isEstado(),
                });
            }
        }
    }
  }//GEN-LAST:event_jrbBajaActionPerformed

  
  // 4. Filtrar por 'Nombre'
  private void jtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtNombreKeyReleased
    jrbAlta.setSelected(false);
    jrbBaja.setSelected(false);
    
    String nombre = jtNombre.getText().toLowerCase(); 
    modelo.setRowCount(0); 
    // Filtrar las reservas por nombre (se asume que tienes el método que hace la búsqueda)
    List<Reserva> reservasFiltradas = reservaData.obtenerReservaPorNombre(nombre);
    
    if (reservasFiltradas.isEmpty()) {
        JOptionPane.showMessageDialog(null, "No se encontraron reservas para ese nombre.");
    }

    // Cargar las reservas filtradas en la tabla
    for (Reserva reserva : reservasFiltradas) {
        modelo.addRow(new Object[]{
            reserva.getIdReserva(),
            reserva.getMesa().getIdMesa(),
            reserva.getNombreCliente(),
            reserva.getTelefono(),
            reserva.getComensales(),
            reserva.getSector(),
            reserva.getFechaHora(),
            reserva.isEstado(),
        });
    }
    
  }//GEN-LAST:event_jtNombreKeyReleased

  
  
  // 5. Filtrar por 'Fecha y Hora'
  private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
    if(jcbSector.getSelectedItem()==null){
      JOptionPane.showMessageDialog(null, "Seleccione su sector asignado ", "Error", JOptionPane.ERROR_MESSAGE);
      return ;
    }
    
    if(jdcFecha.getDate()==null ){
      JOptionPane.showMessageDialog(null, "Seleccione una fecha a buscar ", "Error", JOptionPane.ERROR_MESSAGE);
      return ;
    }

    Date fechaSeleccionada = jdcFecha.getDate(); 
    Date horaSeleccionada = (Date) jsHora.getValue();
    // Convertir la fecha seleccionada a LocalDateTime (sin hora)
    LocalDateTime fechaHoraSeleccionada = fechaSeleccionada.toInstant()
                                                            .atZone(ZoneId.systemDefault())
                                                            .toLocalDateTime();

    // Establecer la hora y minutos seleccionados en la fecha
    LocalDateTime fechaHoraFinal = fechaHoraSeleccionada.withHour(horaSeleccionada.getHours())
                                                       .withMinute(horaSeleccionada.getMinutes())
                                                       .withSecond(0)
                                                       .withNano(0);

    
    List<Reserva> reservasFiltradas = reservaData.obtenerReservasPorFecha(fechaHoraFinal);

    DefaultTableModel modelo = (DefaultTableModel) jtReservas.getModel();
    modelo.setRowCount(0);  // Esto elimina todas las filas actuales

    // Cargar las reservas filtradas en la tabla
    for (Reserva reserva : reservasFiltradas) {
        modelo.addRow(new Object[]{
            reserva.getIdReserva(),
            reserva.getMesa().getIdMesa(),
            reserva.getNombreCliente(),
            reserva.getTelefono(),
            reserva.getComensales(),
            reserva.getSector(),
            reserva.getFechaHora(),
            reserva.isEstado(),
        });
    }
  }//GEN-LAST:event_jbBuscarActionPerformed

  
  // 6. Filtrar por 'Fecha'
  private void jdcFechaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jdcFechaPropertyChange
      if ("date".equals(evt.getPropertyName())) {  // Verifica que el cambio sea en la fecha
        // Obtener la fecha seleccionada en el JDateChooser
        Date fechaSeleccionada = (Date) evt.getNewValue();
        
        // Convertir la fecha seleccionada a LocalDate (sin la parte de la hora)
        LocalDate fecha = fechaSeleccionada.toInstant()
                                           .atZone(ZoneId.systemDefault())
                                           .toLocalDate();
        
        // Llamar al método para obtener las reservas filtradas solo por fecha
        List<Reserva> reservasFiltradas = reservaData.obtenerReservasSoloPorFecha(fecha);
        
        // Limpiar la tabla antes de cargar las nuevas reservas
        DefaultTableModel modelo = (DefaultTableModel) jtReservas.getModel();
        modelo.setRowCount(0);  // Esto elimina todas las filas actuales
        
        // Cargar las reservas filtradas en la tabla
        for (Reserva reserva : reservasFiltradas) {
            modelo.addRow(new Object[]{
                reserva.getIdReserva(),
                reserva.getMesa().getIdMesa(),
                reserva.getNombreCliente(),
                reserva.getTelefono(),
                reserva.getComensales(),
                reserva.getSector(),
                reserva.getFechaHora(),
                reserva.isEstado(),
            });
        }
    }
    
  }//GEN-LAST:event_jdcFechaPropertyChange

  
  
  // 7. Mostrar todas las reservas (segun el sector seleccionado)
  private void jbMostrarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMostrarTodoActionPerformed
    String sectorSeleccionado = (String) jcbSector.getSelectedItem();

    if (sectorSeleccionado == null || sectorSeleccionado.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Seleccione su sector asignado", "Error", JOptionPane.ERROR_MESSAGE);
        return; 
    }

    List<Reserva> reservasPorSector = reservaData.obtenerReservasPorSector(sectorSeleccionado);

    // Limpiar la tabla antes de cargar las nuevas reservas
    DefaultTableModel modelo = (DefaultTableModel) jtReservas.getModel();
    modelo.setRowCount(0);  // Esto elimina todas las filas actuales

    // Cargar las reservas filtradas en la tabla
    for (Reserva reserva : reservasPorSector) {
        modelo.addRow(new Object[] {
            reserva.getIdReserva(),
            reserva.getMesa().getIdMesa(),
            reserva.getNombreCliente(),
            reserva.getTelefono(),
            reserva.getComensales(),
            reserva.getSector(),
            reserva.getFechaHora(),
            reserva.isEstado()
        });
    }
  }//GEN-LAST:event_jbMostrarTodoActionPerformed

  
  
  

  
  
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JLabel jLabel8;
  private javax.swing.JLabel jLabel9;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JSeparator jSeparator2;
  private javax.swing.JButton jbBuscar;
  private javax.swing.JButton jbMostrarTodo;
  private javax.swing.JComboBox<String> jcbSector;
  private com.toedter.calendar.JDateChooser jdcFecha;
  private javax.swing.JRadioButton jrbAlta;
  private javax.swing.JRadioButton jrbBaja;
  private javax.swing.JSpinner jsHora;
  private javax.swing.JTextField jtNombre;
  private javax.swing.JTable jtReservas;
  // End of variables declaration//GEN-END:variables


  
// 3. Cargar combo-sector
private void cargaComboSector (){
    // Agregar un elemento nulo como primer elemento
    jcbSector.addItem(null);  

    // Agregar otros elementos al JComboBox
    jcbSector.addItem("Comedor");
    jcbSector.addItem("Terraza");
    jcbSector.addItem("Patio");
    
}  
  
  
  
  
// 1. Cabecera 'tabla'
private void armarCabecera(){
  modelo = new DefaultTableModel() { 
    @Override
    public boolean isCellEditable(int row, int column) {
        return false; // Hace que todas las celdas no sean editables
    }
  };
  
  modelo.addColumn("ID RESERVA");
  modelo.addColumn("ID MESA");
  modelo.addColumn("NOMBRE DEL CLIENTE");
  modelo.addColumn("TELÉFONO");
  modelo.addColumn("COMENSALES");
  modelo.addColumn("SECTOR");
  modelo.addColumn("FECHA Y HORA");
  modelo.addColumn("ESTADO");

  jtReservas.setModel(modelo);
  jtReservas.getTableHeader().setReorderingAllowed(false); /*que no pueda mover las columnas*/

 }


// 2. Cargar datos a la 'tabla'
private void cargarDatos(){
  modelo.setRowCount(0); // Limpiar las filas existentes del modelo
  jtReservas.setBackground(new java.awt.Color(153, 204, 255));
  // Obtener la lista de reservas
  List<Reserva> reservas = reservaData.listarReservas(); 

  // Recorrer la lista de reservas y agregar cada una al modelo
  for (Reserva r : reservas) {
      modelo.addRow(new Object[]{
          r.getIdReserva(),                        // ID de la Reserva
          r.getMesa().getIdMesa(),                 // ID de la Mesa (asumiendo que Mesa tiene un método getIdMesa())
          r.getNombreCliente(),                     // Nombre del Cliente
          r.getTelefono(),                          // Teléfono del Cliente
          r.getComensales(),                       // Cantidad de Comensales
          r.getSector(),                            // Sector de la Reserva
          r.getFechaHora(),                        // Fecha y Hora de la Reserva
          r.isEstado() ? "Activo" : "Inactivo"    // Estado de la Reserva como texto
      });
  }
}


// 3. Modelo sppiner
private void modeloSpinner(){
  SpinnerDateModel model = new SpinnerDateModel();
  jsHora.setModel(model);
  JSpinner.DateEditor editor = new JSpinner.DateEditor(jsHora, "HH:mm");
  jsHora.setEditor(editor);

}

}
