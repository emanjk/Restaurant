
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
    jLabel2 = new javax.swing.JLabel();
    jSeparator1 = new javax.swing.JSeparator();
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

    setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jLabel6.setFont(new java.awt.Font("Franklin Gothic Medium", 3, 18)); // NOI18N
    jLabel6.setForeground(new java.awt.Color(0, 204, 0));
    jLabel6.setText("Gestion  Reservas");
    add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 10, -1, -1));

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

    add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 780, 180));

    jLabel2.setFont(new java.awt.Font("Franklin Gothic Medium", 3, 18)); // NOI18N
    jLabel2.setText("LISTA DE RESERVAS");
    add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 280, 170, -1));
    add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 300, 200, 10));

    jLabel7.setFont(new java.awt.Font("Roboto", 1, 16)); // NOI18N
    jLabel7.setForeground(new java.awt.Color(204, 0, 0));
    jLabel7.setText(" Sector:");
    add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

    jcbSector.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
    jcbSector.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jcbSectorActionPerformed(evt);
      }
    });
    add(jcbSector, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 100, -1));

    jPanel2.setBackground(new java.awt.Color(255, 204, 153));
    jPanel2.setForeground(new java.awt.Color(255, 204, 153));

    jLabel8.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
    jLabel8.setForeground(new java.awt.Color(255, 102, 0));
    jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel8.setText("Filtrar Reservas");

    jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    jLabel1.setForeground(new java.awt.Color(0, 0, 0));
    jLabel1.setText("Por estado: ");

    jrbAlta.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
    jrbAlta.setForeground(new java.awt.Color(0, 0, 0));
    jrbAlta.setText("Alta");
    jrbAlta.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jrbAltaActionPerformed(evt);
      }
    });

    jrbBaja.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
    jrbBaja.setForeground(new java.awt.Color(0, 0, 0));
    jrbBaja.setText("Baja");
    jrbBaja.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jrbBajaActionPerformed(evt);
      }
    });

    jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    jLabel4.setForeground(new java.awt.Color(0, 0, 0));
    jLabel4.setText("Fecha:");

    jdcFecha.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
      public void propertyChange(java.beans.PropertyChangeEvent evt) {
        jdcFechaPropertyChange(evt);
      }
    });

    jSeparator2.setForeground(new java.awt.Color(204, 204, 204));

    jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    jLabel9.setForeground(new java.awt.Color(0, 0, 0));
    jLabel9.setText("Nombre: ");

    jtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyReleased(java.awt.event.KeyEvent evt) {
        jtNombreKeyReleased(evt);
      }
    });

    jbBuscar.setBackground(new java.awt.Color(51, 204, 0));
    jbBuscar.setForeground(new java.awt.Color(255, 255, 255));
    jbBuscar.setText("Buscar");
    jbBuscar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jbBuscarActionPerformed(evt);
      }
    });

    jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
    jLabel3.setForeground(new java.awt.Color(0, 0, 0));
    jLabel3.setText("Hora");

    jbMostrarTodo.setText("Mostrar todo");
    jbMostrarTodo.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jbMostrarTodoActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel2Layout.createSequentialGroup()
            .addGap(260, 260, 260)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel8))))
          .addGroup(jPanel2Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jrbAlta)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jrbBaja))
          .addGroup(jPanel2Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel9)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(jPanel2Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jLabel4)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jsHora, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(jPanel2Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jbMostrarTodo)))
        .addGap(290, 290, 290))
    );
    jPanel2Layout.setVerticalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel2Layout.createSequentialGroup()
            .addGap(30, 30, 30)
            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(8, 8, 8)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jrbAlta)
          .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jrbBaja))
        .addGap(20, 20, 20)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel9))
        .addGap(22, 22, 22)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel4)
          .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jsHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jbBuscar)))
        .addGap(18, 18, 18)
        .addComponent(jbMostrarTodo)
        .addContainerGap())
    );

    add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 750, 220));
  }// </editor-fold>//GEN-END:initComponents

  
  
  // 1. Filtrar reservas por 'Alta'
  private void jrbAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbAltaActionPerformed
       
        
        
        if (jrbAlta.isSelected()) {
        jrbBaja.setSelected(false); // Desmarcar el radio button 'Baja'
        

        // Obtener el sector seleccionado
        String sectorSeleccionado = (String) jcbSector.getSelectedItem();
        if (sectorSeleccionado == null || sectorSeleccionado.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Seleccione su sector asignado.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        modelo.setRowCount(0); // Limpiar la tabla antes de cargar nuevas reservas

        // Obtener reservas 'Alta' en el sector seleccionado
        List<Reserva> reservasAlta = reservaData.obtenerReservasPorSector(sectorSeleccionado);
        
        // Filtrar las reservas con estado 'Alta' (estado = true)
        reservasAlta = reservasAlta.stream()
                                   .filter(reserva -> reserva.isEstado()) // Filtra solo las reservas en estado "Alta"
                                   .collect(Collectors.toList());

        if (reservasAlta.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay reservas 'Alta' para el sector seleccionado.");
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

  
  // 7. Mostrar todas las reservas
  private void jbMostrarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMostrarTodoActionPerformed
      // Obtener todas las reservas desde la base de datos
    List<Reserva> todasLasReservas = reservaData.listarReservas();

    // Limpiar la tabla antes de cargar las nuevas reservas
    DefaultTableModel modelo = (DefaultTableModel) jtReservas.getModel();
    modelo.setRowCount(0);  // Esto elimina todas las filas actuales

    // Cargar todas las reservas en la tabla
    for (Reserva reserva : todasLasReservas) {
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
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JLabel jLabel8;
  private javax.swing.JLabel jLabel9;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JSeparator jSeparator1;
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
