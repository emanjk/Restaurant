/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;
import Modelo.Producto;
import Persistencia.ProductoData;
import Persistencia.Conexion;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import javax.swing.ButtonGroup;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Roma
 */
public class GProductos extends javax.swing.JPanel {
    private  Connection con; /* variable q tendra la conexion */ 
    private ProductoData productoData; 
    private DefaultTableModel modelo= new DefaultTableModel(){ 
        public boolean isCellEditable(int fila, int column){
           
            return false;// evita la modificacion de datos en las celdas
        }
    }; 
    private ButtonGroup grupoEstado;
    private ButtonGroup grupoEstado1;
    private ButtonGroup grupoEstado2;
    /**
     * Creates new form GProductos
     */
    public GProductos() {
        initComponents();
        // Configurar un SpinnerNumberModel con mínimo de 0, sin límite máximo, y paso de 1 en 1.
        jSStock.setModel(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
        jSId1.setModel(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
        jSId2.setModel(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
        StockMin.setModel(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
        StockMax.setModel(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));

        
        jTFCodigo.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!Character.isDigit(c)) {
                    evt.consume();
                    JOptionPane.showMessageDialog(null, "Solo se permiten números en el campo de Código.");
                }
            }
        });
        jTFCodigo1.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!Character.isDigit(c)) {
                    evt.consume();
                    JOptionPane.showMessageDialog(null, "Solo se permiten números en el campo de Código.");
                }
            }
        });
        jTFCodigo2.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!Character.isDigit(c)) {
                    evt.consume();
                    JOptionPane.showMessageDialog(null, "Solo se permiten números en el campo de Código.");
                }
            }
        });

        jTPrecio.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!Character.isDigit(c) && c != '.') {
                    evt.consume();
                    JOptionPane.showMessageDialog(null, "Solo se permiten números en el campo de Precio.");
                }
            }
        });
        jTPrecio1.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!Character.isDigit(c) && c != '.') {
                    evt.consume();
                    JOptionPane.showMessageDialog(null, "Solo se permiten números en el campo de Precio.");
                }
            }
        });
        PrecioMin.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!Character.isDigit(c) && c != '.') {
                    evt.consume();
                    JOptionPane.showMessageDialog(null, "Solo se permiten números en el campo de Precio.");
                }
            }
        });
        PrecioMax.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!Character.isDigit(c) && c != '.') {
                    evt.consume();
                    JOptionPane.showMessageDialog(null, "Solo se permiten números en el campo de Precio.");
                }
            }
        });

        grupoEstado = new ButtonGroup();
        grupoEstado.add(jRON);
        grupoEstado.add(jROFF);
        
        grupoEstado1 = new ButtonGroup();
        grupoEstado.add(jRON1);
        grupoEstado.add(jROFF1);
        
        grupoEstado2 = new ButtonGroup();
        grupoEstado.add(jRON2);
        grupoEstado.add(jROFF2);
        
        this.con = Conexion.getConexion(); // Obtener la conexión y guardarla
        this.productoData = new ProductoData(con);
        this.modelo = new DefaultTableModel(); // Inicializar el modelo de la tabla

        armarCabecera(); // Configurar cabecera de la tabla
        cargarDatos();   // Cargar todos los datos en la tabla
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jCBTipo = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jRON = new javax.swing.JRadioButton();
        jROFF = new javax.swing.JRadioButton();
        jBGuardar1 = new javax.swing.JButton();
        jTFCodigo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jTFNombre = new javax.swing.JTextField();
        jTPrecio = new javax.swing.JTextField();
        jTDesc = new javax.swing.JTextField();
        jSStock = new javax.swing.JSpinner();
        jPanel2 = new javax.swing.JPanel();
        jROFF2 = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jRON2 = new javax.swing.JRadioButton();
        jLabel27 = new javax.swing.JLabel();
        jCBTipo2 = new javax.swing.JComboBox<>();
        jLabel28 = new javax.swing.JLabel();
        PrecioMin = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jTFNombre2 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        PrecioMax = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        StockMin = new javax.swing.JSpinner();
        StockMax = new javax.swing.JSpinner();
        jLabel11 = new javax.swing.JLabel();
        jSId2 = new javax.swing.JSpinner();
        jLabel33 = new javax.swing.JLabel();
        jTFCodigo2 = new javax.swing.JTextField();
        exit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTPR = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jCBTipo1 = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jRON1 = new javax.swing.JRadioButton();
        jROFF1 = new javax.swing.JRadioButton();
        jTFCodigo1 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jTFNombre1 = new javax.swing.JTextField();
        jTDesc1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jBModificar1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jSId1 = new javax.swing.JSpinner();
        jTPrecio1 = new javax.swing.JTextField();
        jSStock1 = new javax.swing.JSpinner();

        jPanel1.setBackground(new java.awt.Color(255, 204, 153));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Felix Titling", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 0));
        jLabel1.setText("AGREGAR  Producto");

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("DESCRIPCION");

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("CODIGO");

        jCBTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bebida", "Trago", "Desayuno", "Merienda", "Almuerzo", "Cena" }));

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("ESTADO");

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("TIPO");

        jRON.setText("Alta");

        jROFF.setText("Baja");

        jBGuardar1.setText("GUARDAR");
        jBGuardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardar1ActionPerformed(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("NOMBRE");

        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("PRECIO");

        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("STOCK");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(47, 47, 47)
                            .addComponent(jTFCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(87, 87, 87))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(jLabel7))
                            .addGap(44, 44, 44)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTFNombre)
                                .addComponent(jCBTipo, 0, 126, Short.MAX_VALUE))
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel17)
                                        .addComponent(jLabel18))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jSStock, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                                            .addComponent(jTPrecio, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addComponent(jTDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jRON)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jROFF, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(25, 25, 25))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jBGuardar1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(101, 101, 101)))
                            .addComponent(jLabel5))
                        .addGap(10, 10, 10))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTFCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTFNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jCBTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jTPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel18)
                    .addComponent(jSStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRON)
                    .addComponent(jROFF))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBGuardar1)
                .addGap(14, 14, 14))
        );

        jPanel2.setBackground(new java.awt.Color(255, 153, 102));

        jROFF2.setText("Baja");
        jROFF2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jROFF2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Felix Titling", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 102, 0));
        jLabel2.setText("FILTRAR por:");

        jRON2.setText("Alta");
        jRON2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRON2ActionPerformed(evt);
            }
        });

        jLabel27.setForeground(new java.awt.Color(0, 0, 0));
        jLabel27.setText("TIPO");

        jCBTipo2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bebida", "Trago", "Desayuno", "Merienda", "Almuerzo", "Cena" }));
        jCBTipo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBTipo2ActionPerformed(evt);
            }
        });

        jLabel28.setForeground(new java.awt.Color(0, 0, 0));
        jLabel28.setText("PRECIO MIN:");

        jLabel29.setForeground(new java.awt.Color(0, 0, 0));
        jLabel29.setText("STOCK MIN:");

        jLabel30.setForeground(new java.awt.Color(0, 0, 0));
        jLabel30.setText("NOMBRE");

        jTFNombre2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFNombre2KeyReleased(evt);
            }
        });

        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("ESTADO");

        PrecioMax.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                PrecioMaxKeyReleased(evt);
            }
        });

        jLabel31.setForeground(new java.awt.Color(0, 0, 0));
        jLabel31.setText("PRECIO MAX:");

        jLabel32.setForeground(new java.awt.Color(0, 0, 0));
        jLabel32.setText("STOCK MAX:");

        StockMax.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                StockMaxStateChanged(evt);
            }
        });

        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("ID");

        jSId2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSId2StateChanged(evt);
            }
        });

        jLabel33.setForeground(new java.awt.Color(0, 0, 0));
        jLabel33.setText("CODIGO");

        jTFCodigo2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFCodigo2KeyReleased(evt);
            }
        });

        exit.setText("X");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRON2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jROFF2))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel31)
                                        .addComponent(jLabel28))
                                    .addComponent(jLabel29)
                                    .addComponent(jLabel32)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel30)
                                    .addComponent(jLabel33)
                                    .addComponent(jLabel27))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTFNombre2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTFCodigo2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSId2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jCBTipo2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(PrecioMin)
                                        .addComponent(PrecioMax)
                                        .addComponent(StockMin, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                                        .addComponent(StockMax)))))
                        .addGap(0, 22, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(68, 68, 68)
                        .addComponent(exit)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(jLabel11))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSId2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTFCodigo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTFNombre2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCBTipo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(PrecioMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(PrecioMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(StockMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(StockMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jRON2)
                    .addComponent(jROFF2))
                .addContainerGap())
        );

        jTPR.setBackground(new java.awt.Color(0, 153, 153));
        jTPR.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTPR);

        jPanel4.setBackground(new java.awt.Color(255, 204, 153));
        jPanel4.setForeground(new java.awt.Color(0, 0, 0));

        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("DESCRIPCION");

        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setText("CODIGO");

        jCBTipo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bebida", "Trago", "Desayuno", "Merienda", "Almuerzo", "Cena" }));

        jLabel22.setForeground(new java.awt.Color(0, 0, 0));
        jLabel22.setText("ESTADO");

        jLabel23.setForeground(new java.awt.Color(0, 0, 0));
        jLabel23.setText("TIPO");

        jRON1.setText("Alta");

        jROFF1.setText("Baja");

        jLabel24.setForeground(new java.awt.Color(0, 0, 0));
        jLabel24.setText("NOMBRE");

        jLabel25.setForeground(new java.awt.Color(0, 0, 0));
        jLabel25.setText("PRECIO");

        jLabel26.setForeground(new java.awt.Color(0, 0, 0));
        jLabel26.setText("STOCK");

        jLabel9.setFont(new java.awt.Font("Felix Titling", 3, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 102, 0));
        jLabel9.setText("MODIFICAR Producto");

        jBModificar1.setText("MODIFICAR");
        jBModificar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBModificar1ActionPerformed(evt);
            }
        });

        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("ID");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(jLabel21)
                                    .addGap(47, 47, 47))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel24)
                                        .addComponent(jLabel10))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTFCodigo1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTFNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jSId1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addContainerGap(12, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel20)
                                .addComponent(jLabel25)
                                .addComponent(jLabel26))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTDesc1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jRON1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jROFF1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(9, 9, 9))
                                .addComponent(jSStock1)
                                .addComponent(jTPrecio1))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addGap(69, 69, 69)
                                .addComponent(jCBTipo1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel22)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jBModificar1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSId1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(5, 5, 5)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jTFCodigo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jTFNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jCBTipo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jTDesc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel26)
                        .addGap(12, 12, 12))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jTPrecio1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSStock1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRON1)
                    .addComponent(jROFF1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBModificar1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBGuardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardar1ActionPerformed
          Producto pr = new Producto();

        try {
            // Validaciones de campos vacíos y correcta conversión de datos
            if (jTFCodigo.getText().isEmpty() || jTFNombre.getText().isEmpty() || jTPrecio.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos requeridos.");
                return;
            }            
            pr.setCodigo(Integer.parseInt(jTFCodigo.getText()));// Código debe ser un número entero
            pr.setNombre(jTFNombre.getText());// Nombre debe ser texto
            pr.setTipo(jCBTipo.getSelectedItem().toString());
            pr.setDescripcion(jTDesc.getText());
            pr.setPrecio(Double.parseDouble(jTPrecio.getText()));// Precio debe ser un número decimal
            pr.setStock((int) jSStock.getValue());// Stock debe ser un número entero
            pr.setEstado(jRON.isSelected());

            productoData.guardarProducto(pr);

            cargarDatos();

            JOptionPane.showMessageDialog(this, "Producto guardado correctamente.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error en el formato de los datos numéricos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al guardar el producto: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    

    }//GEN-LAST:event_jBGuardar1ActionPerformed

    private void jBModificar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBModificar1ActionPerformed
        int idProducto = (int) jSId1.getValue();
        Producto producto = productoData.buscarProductoPorId(idProducto);

        if (producto != null) {
            try {
                producto.setCodigo(Integer.parseInt(jTFCodigo1.getText()));
                producto.setNombre(jTFNombre1.getText());
                producto.setTipo(jCBTipo1.getSelectedItem().toString());
                producto.setDescripcion(jTDesc1.getText());
                producto.setPrecio(Double.parseDouble(jTPrecio1.getText()));
                producto.setStock((int) jSStock1.getValue());
                producto.setEstado(jRON1.isSelected());

                productoData.modificarProducto(producto);

                cargarDatos();

                JOptionPane.showMessageDialog(this, "Producto modificado correctamente.");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Error en el formato de los datos numéricos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error al modificar el producto: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No se encontró el producto con el ID especificado.");
        }
    }//GEN-LAST:event_jBModificar1ActionPerformed

    private void jROFF2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jROFF2ActionPerformed
         cargarProductosPorEstado(false);
    }//GEN-LAST:event_jROFF2ActionPerformed

    private void jRON2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRON2ActionPerformed
         cargarProductosPorEstado(true);
    }//GEN-LAST:event_jRON2ActionPerformed

    private void jTFNombre2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFNombre2KeyReleased
        borrarFilas(); // Limpia la tabla antes de agregar nuevos resultados.
        String textoBusqueda = jTFNombre2.getText().trim(); // Obtiene el texto del campo de búsqueda y elimina espacios en blanco.

        if (!textoBusqueda.isEmpty()) { // Solo realiza la búsqueda si el campo no está vacío.
            // Usa el método buscarProductoPorNombre para obtener productos que coinciden con el texto ingresado.
            List<Producto> productosFiltrados = productoData.buscarProductoPorNombre(textoBusqueda);

            for (Producto p : productosFiltrados) { // Agrega cada producto encontrado a la tabla.
                modelo.addRow(new Object[]{
                    p.getIdProducto(),        
                    p.getNombre(),    
                    p.getDescripcion(),         
                    p.getTipo(),
                    p.getPrecio(),         
                    p.getStock(),
                    p.isEstado() ? "Alta" : "Baja"
                });
            }
        }
    }//GEN-LAST:event_jTFNombre2KeyReleased

    private void PrecioMaxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PrecioMaxKeyReleased
        borrarFilas();
        String textoMin = PrecioMin.getText().trim();
        String textoMax = PrecioMax.getText().trim();

        if (!textoMin.isEmpty() && !textoMax.isEmpty()) {
            try {
                double precioMin = Double.parseDouble(textoMin);
                double precioMax = Double.parseDouble(textoMax);
                List<Producto> productosFiltrados = productoData.buscarProductoPorPrecio(precioMin, precioMax);

                for (Producto p : productosFiltrados) {
                    modelo.addRow(new Object[]{
                        p.getIdProducto(),
                        p.getNombre(),
                        p.getDescripcion(),
                        p.getTipo(),
                        p.getPrecio(),
                        p.getStock(),
                        p.isEstado() ? "Alta" : "Baja"
                    });
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Por favor ingresa valores numéricos válidos para el rango de precio.");
            }
        }
    }//GEN-LAST:event_PrecioMaxKeyReleased

    private void jSId2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSId2StateChanged
        int idProducto = (int) jSId2.getValue(); // Obtener el valor del spinner
        cargarProductoPorIdEnTabla(idProducto); 
    }//GEN-LAST:event_jSId2StateChanged

    private void jCBTipo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBTipo2ActionPerformed
        String tipoSeleccionado = (String) jCBTipo2.getSelectedItem(); // Obtener la situación seleccionada
        if (tipoSeleccionado != null && !tipoSeleccionado.isEmpty()) {
            cargarProductosPorTipo(tipoSeleccionado); // Cargar mesas por situación
        }
    }//GEN-LAST:event_jCBTipo2ActionPerformed

    private void StockMaxStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_StockMaxStateChanged
        StockMin.addChangeListener(new javax.swing.event.ChangeListener() {
        public void stateChanged(javax.swing.event.ChangeEvent evt) {
            cargarProductosPorStock();
        }
    });

    StockMax.addChangeListener(new javax.swing.event.ChangeListener() {
        public void stateChanged(javax.swing.event.ChangeEvent evt) {
            cargarProductosPorStock();
        }
    });
    }//GEN-LAST:event_StockMaxStateChanged

    private void jTFCodigo2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFCodigo2KeyReleased
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume(); // Ignora cualquier caracter que no sea un dígito
            JOptionPane.showMessageDialog(this, "Solo se permiten números");
        }
    }//GEN-LAST:event_jTFCodigo2KeyReleased

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        this.setVisible(false);  // Oculta el panel actual
    }//GEN-LAST:event_exitActionPerformed
    
     
    
    private void cargarProductoPorCodigo() {
    // Limpiar la tabla antes de mostrar el nuevo resultado
    modelo.setRowCount(0);

    // Leer y convertir el texto a un número
    String textoBusqueda = jTFCodigo2.getText().trim();
    
    if (!textoBusqueda.isEmpty()) { 
        try {
            int codigo = Integer.parseInt(textoBusqueda); // Convierte el texto a entero
            Producto producto = productoData.buscarProductoPorCodigo(codigo); // Busca el producto

            if (producto != null) {
                // Agrega el producto encontrado a la tabla
                modelo.addRow(new Object[]{
                    producto.getIdProducto(),
                    producto.getCodigo(),
                    producto.getNombre(),
                    producto.getTipo(),
                    producto.getDescripcion(),
                    producto.getPrecio(),
                    producto.getStock(),
                    producto.isEstado() ? "Alta" : "Baja"
                });
            } else {
                JOptionPane.showMessageDialog(null, "Producto no encontrado con el código: " + codigo);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingrese un número válido.");
        }
    } else {
        JOptionPane.showMessageDialog(null, "El campo de búsqueda está vacío.");
    }
}

    private void cargarProductosPorStock() {
        // Obtener valores mínimo y máximo de stock de los spinners
        int stockMin = (int) StockMin.getValue();
        int stockMax = (int) StockMax.getValue();

        // Limpiar la tabla antes de cargar nuevos datos
        modelo.setRowCount(0);

        // Obtener la lista de productos filtrados por stock
        List<Producto> productos = productoData.buscarProductoPorStock(stockMin, stockMax);

        // Recorrer la lista y agregar cada producto a la tabla
        for (Producto p : productos) {
            modelo.addRow(new Object[]{
                p.getIdProducto(),     // ID del producto
                p.getCodigo(),         // Código del producto
                p.getNombre(),         // Nombre del producto
                p.getTipo(),           // Tipo de producto
                p.getDescripcion(),    // Descripción
                p.getPrecio(),         // Precio
                p.getStock(),          // Stock
                p.isEstado() ? "Alta" : "Baja" // Estado (Alta/Baja)
            });
        }
    }

    
    private void cargarProductosPorEstado(boolean estado) {
        modelo.setRowCount(0); // Limpiar la tabla antes de cargar nuevos datos
        List<Producto> pr = productoData.listarProductosPorEstado(estado); 

            for (Producto p : pr) {
                modelo.addRow(new Object[]{
                    p.getIdProducto(),         
                    p.getNombre(),    
                    p.getDescripcion(),         
                    p.getTipo(),
                    p.getPrecio(),         
                    p.getStock(),
                    p.isEstado()  ? "Alta" : "Baja"
                });

            }
    }
    
    private void cargarProductoPorIdEnTabla(int idProducto) {
        // Limpiar la tabla antes de cargar los datos nuevos
        modelo.setRowCount(0);
        Producto producto = productoData.buscarProductoPorId(idProducto);

        // Si el producto se encuentra, agregarlo a la tabla
        if (producto != null) {
            modelo.addRow(new Object[]{
                producto.getIdProducto(),          // ID del producto
                producto.getCodigo(),              // Código del producto
                producto.getNombre(),              // Nombre del producto
                producto.getTipo(),                // Tipo de producto
                producto.getDescripcion(),         // Descripción
                producto.getPrecio(),              // Precio
                producto.getStock(),               // Stock
                producto.isEstado() ? "Alta" : "Baja" // Estado (Alta/Baja)
            });
        } else {
            JOptionPane.showMessageDialog(this, "No se encontró un producto con el ID especificado.", "Producto no encontrado", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private void cargarProductosPorTipo(String tipo) {
        // Limpiar la tabla antes de cargar nuevos datos
        modelo.setRowCount(0);

        // Obtener la lista de productos filtrados por tipo
        List<Producto> productos = productoData.buscarProductoPorTipo(tipo);

        // Recorrer la lista y agregar cada producto a la tabla
        for (Producto p : productos) {
            modelo.addRow(new Object[]{
                p.getIdProducto(),     // ID del producto
                p.getCodigo(),         // Código del producto
                p.getNombre(),         // Nombre del producto
                p.getTipo(),           // Tipo de producto
                p.getDescripcion(),    // Descripción
                p.getPrecio(),         // Precio
                p.getStock(),          // Stock
                p.isEstado() ? "Alta" : "Baja" // Estado (Alta/Baja)
            });
        }
    }

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField PrecioMax;
    private javax.swing.JTextField PrecioMin;
    private javax.swing.JSpinner StockMax;
    private javax.swing.JSpinner StockMin;
    private javax.swing.JButton exit;
    private javax.swing.JButton jBGuardar1;
    private javax.swing.JButton jBModificar1;
    private javax.swing.JComboBox<String> jCBTipo;
    private javax.swing.JComboBox<String> jCBTipo1;
    private javax.swing.JComboBox<String> jCBTipo2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jROFF;
    private javax.swing.JRadioButton jROFF1;
    private javax.swing.JRadioButton jROFF2;
    private javax.swing.JRadioButton jRON;
    private javax.swing.JRadioButton jRON1;
    private javax.swing.JRadioButton jRON2;
    private javax.swing.JSpinner jSId1;
    private javax.swing.JSpinner jSId2;
    private javax.swing.JSpinner jSStock;
    private javax.swing.JSpinner jSStock1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTDesc;
    private javax.swing.JTextField jTDesc1;
    private javax.swing.JTextField jTFCodigo;
    private javax.swing.JTextField jTFCodigo1;
    private javax.swing.JTextField jTFCodigo2;
    private javax.swing.JTextField jTFNombre;
    private javax.swing.JTextField jTFNombre1;
    private javax.swing.JTextField jTFNombre2;
    private javax.swing.JTable jTPR;
    private javax.swing.JTextField jTPrecio;
    private javax.swing.JTextField jTPrecio1;
    // End of variables declaration//GEN-END:variables

    //  Cabecera de la 'tabla'
    private void armarCabecera() {
        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hace que todas las celdas no sean editables
            }
        };

        // Agregar columnas al modelo de la tabla
        modelo.addColumn("ID");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("TIPO");
        modelo.addColumn("DESCRIPCION");
        modelo.addColumn("PRECIO");
        modelo.addColumn("STOCK");
        modelo.addColumn("ESTADO");

        // Establecer el modelo de la tabla y opciones
        jTPR.setModel(modelo);
        jTPR.getTableHeader().setReorderingAllowed(false); // Impide mover las columnas
    }

    private void borrarFilas(){
        int fila=jTPR.getRowCount()-1;
        for(int f=fila; f>=0;f--){
            modelo.removeRow(f);
        }
    }
    
    //  Cargar datos a la 'tabla'
    private void cargarDatos() {
        modelo.setRowCount(0); // Limpiar la tabla antes de cargar nuevos datos
        List<Producto> pr = productoData.listarProductos(); 

        for (Producto p : pr) {
            modelo.addRow(new Object[]{
                p.getIdProducto(),        
                p.getNombre(),    
                p.getDescripcion(),         
                p.getTipo(),
                p.getPrecio(),         
                p.getStock(),
                p.isEstado()  ? "Alta" : "Baja"
            });
        }
    }
    
   

}