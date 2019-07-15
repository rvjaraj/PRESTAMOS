/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.prestamo;

import controlador.ControladorAdministrador;
import controlador.ControladorAmortizacion;
import controlador.ControladorPrestamo;
import controlador.ControladorUsuario;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Amortizacion;
import modelo.Prestamo;
import modelo.Usuario;

/**
 *
 * @author VINICIO
 *
 */
public class VistaPrestamo extends javax.swing.JInternalFrame {

    /**
     * Atributos de la clase
     */
    FileInputStream fis;
    private DefaultTableModel modelotabla;  // modelo de la tabla.
    private int numBy;
    private String tipom;
    private String archivo;
    private int codAux = -500;

    /**
     * Constructor de la clase
     *
     * @param controladorArticulo : clase controladora de Articulo
     */
    public VistaPrestamo() {
        initComponents();
        
        modelotabla = new DefaultTableModel();
        tipom = "";
        
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        txtFecha.setText(dateFormat.format(date));
        
        comboMeses.removeAll();
        comboMeses.addItem("Seleccione");
        for (int i = 1; i < 101; i++) {
            comboMeses.addItem(i + "");
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        panelCrud = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        txtCantidad = new javax.swing.JTextField();
        telefono = new javax.swing.JLabel();
        telefono1 = new javax.swing.JLabel();
        comboMeses = new javax.swing.JComboBox<>();
        txtMeses = new javax.swing.JTextField();
        telefono2 = new javax.swing.JLabel();
        telefono3 = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtBuscarM = new javax.swing.JTextField();
        buscar4 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
                cerrado(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelCrud.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                panelCrudStateChanged(evt);
            }
        });

        jPanel1.setPreferredSize(new java.awt.Dimension(579, 400));

        jLabel1.setFont(new java.awt.Font("Verdana", 3, 14)); // NOI18N
        jLabel1.setText("CREAR PRESTAMO");

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("C.I:");

        txtCliente.setEditable(false);
        txtCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClienteActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("DIRECCION: ");

        txtDireccion.setEditable(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("TELEFONO:");

        txtTelefono.setEditable(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("CLIENTE: ");

        txtCedula.setText("0105452171");
        txtCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCedulaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedulaKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("FECHA :");

        txtFecha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFechaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFechaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFechaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCedula))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCliente))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(32, 32, 32)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel2)))
                .addGap(4, 4, 4)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel8))
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel3)
                        .addGap(11, 11, 11)
                        .addComponent(jLabel7))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jLabel10.setFont(new java.awt.Font("Verdana", 3, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 255));
        jLabel10.setText("DETALLE");

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Periodo", "Interes", "Cuota sin interes", "Cuota", "Capital Pendiente", "fecha"
            }
        ));
        jScrollPane1.setViewportView(tabla);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtCantidad.setText("12000");
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });

        telefono.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        telefono.setText("CANTIDAD SOLICITADA");

        telefono1.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        telefono1.setText("VALOR DE INTERES ");

        txtMeses.setText("12");
        txtMeses.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMesesKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMesesKeyTyped(evt);
            }
        });

        telefono2.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        telefono2.setText("MESES");

        telefono3.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        telefono3.setText("%");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(telefono, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                    .addComponent(telefono2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(telefono1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(comboMeses, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtMeses))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(telefono3)
                .addContainerGap(68, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telefono)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMeses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telefono2))
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(telefono1)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comboMeses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(telefono3)))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/calcular.png"))); // NOI18N
        btnActualizar.setText("CALCULAR");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.setEnabled(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(109, 109, 109)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 787, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(jLabel1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(205, 205, 205)
                        .addComponent(btnActualizar)
                        .addGap(268, 268, 268)
                        .addComponent(btnGuardar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizar)
                    .addComponent(btnGuardar))
                .addGap(48, 48, 48))
        );

        panelCrud.addTab("CREAR", jPanel1);

        jLabel22.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabel22.setText("MODIFICAR PRESTAMO");

        jLabel12.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabel12.setText("INGRESE CODIGO:  ");

        txtBuscarM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarMKeyTyped(evt);
            }
        });

        buscar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar.png"))); // NOI18N
        buscar4.setText("BUSCAR");
        buscar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscar4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(txtBuscarM, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buscar4)
                        .addContainerGap(589, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtBuscarM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buscar4))
                .addContainerGap(522, Short.MAX_VALUE))
        );

        panelCrud.addTab("MODIFICAR", jPanel4);

        jLabel23.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabel23.setText("LISTA DE PRESTAMOS");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(183, 183, 183)
                .addComponent(jLabel23)
                .addContainerGap(672, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel23)
                .addGap(0, 583, Short.MAX_VALUE))
        );

        panelCrud.addTab("LISTA", jPanel6);

        getContentPane().add(panelCrud, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 48, 1010, 630));

        jLabel6.setFont(new java.awt.Font("Sitka Heading", 2, 24)); // NOI18N
        jLabel6.setText("CONTROLADOR PRESTAMO");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 11, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/kardex.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 130, 100));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cerrado(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_cerrado
    }//GEN-LAST:event_cerrado

    private void panelCrudStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_panelCrudStateChanged
        int n = panelCrud.getSelectedIndex();
        if (n == 3) {
        }
    }//GEN-LAST:event_panelCrudStateChanged

    private void buscar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscar4ActionPerformed

    }//GEN-LAST:event_buscar4ActionPerformed

    private void txtBuscarMKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarMKeyTyped
        if (evt.getKeyCode() != KeyEvent.VK_DELETE) {
            if (evt.getKeyChar() < '0' || evt.getKeyChar() > '9') {
                evt.consume();
            }
        }

    }//GEN-LAST:event_txtBuscarMKeyTyped

    private void txtClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClienteActionPerformed

    private void txtFechaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaKeyPressed

    private void txtFechaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaKeyReleased

    private void txtFechaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaKeyTyped

    private void txtCedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyTyped
        if (evt.getKeyCode() != KeyEvent.VK_DELETE) {
            if (evt.getKeyChar() < '0' || evt.getKeyChar() > '9') {
                evt.consume();
            }
        }
    }//GEN-LAST:event_txtCedulaKeyTyped

    private void txtCedulaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!txtCedula.getText().equals("")) {
                ControladorUsuario cotrolador = new ControladorUsuario();
                Usuario c = cotrolador.findByCedula2(txtCedula.getText());
                if (c != null) {
                    codAux = c.getIdUsuario();
                    txtCliente.setText(c.getNombre() + " " + c.getApellido());
                    txtTelefono.setText(c.getTelefono());
                    txtDireccion.setText(c.getDireccion());
                } else {
                    JOptionPane.showMessageDialog(this, "USUARIO NO ENCONTRADO, O NO PUEDE HACER PRESTAMOS", "USUARIO", JOptionPane.INFORMATION_MESSAGE);
                    txtCedula.setText("");
                    txtCliente.setText("");
                    txtTelefono.setText("");
                    txtDireccion.setText("");
                    
                }
            } else {
                JOptionPane.showMessageDialog(this, "DATOS INGRESADOS INCORRECTOS", "ERROR", JOptionPane.ERROR_MESSAGE);
                txtCedula.setText("");
                txtCliente.setText("");
                txtTelefono.setText("");
                txtDireccion.setText("");
            }
        }
    }//GEN-LAST:event_txtCedulaKeyPressed

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        if (evt.getKeyChar() != '.') {
            if (evt.getKeyChar() < '0' || evt.getKeyChar() > '9') {
                evt.consume();
            }
        }
    }//GEN-LAST:event_txtCantidadKeyTyped

    private void txtMesesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMesesKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMesesKeyPressed

    private void txtMesesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMesesKeyTyped
        if (evt.getKeyCode() != KeyEvent.VK_DELETE) {
            if (evt.getKeyChar() < '0' || evt.getKeyChar() > '9') {
                evt.consume();
            }
        }
    }//GEN-LAST:event_txtMesesKeyTyped

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        limpiarTabla();
        boolean bandera = true;
        if (txtCliente.getText().equals("")) {
            bandera = false;
        }
        if (txtCantidad.getText().equals("")) {
            bandera = false;
        }
        if (txtMeses.getText().equals("")) {
            bandera = false;
        }
        
        if (comboMeses.getSelectedIndex() == 0) {
            bandera = false;
        }
        
        if (bandera) {
            double catidad = Integer.parseInt(txtCantidad.getText());
            int meses = Integer.parseInt(txtMeses.getText());
            double iva = (int) comboMeses.getSelectedIndex();
            
            double cuota = catidad / meses;
            double interes = catidad * (iva * 0.01);
            
            Date date = new Date();
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            
            DefaultTableModel model = (DefaultTableModel) tabla.getModel();
            model.insertRow(0, new Object[]{0, 0, 0, 0, catidad, dateFormat.format(date)});
            for (int i = 1; i < meses + 1; i++) {
                catidad = (double) tabla.getValueAt(i - 1, 4);
                interes = catidad * (iva * 0.01);
                date.setMonth(date.getMonth() + 1);
                model.insertRow(i, new Object[]{i, interes, cuota, interes + cuota, catidad - cuota, dateFormat.format(date)});
            }
            btnGuardar.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(this, "Exiten errores en los campos!! \nVerfique los datos ingresados", "PRESTAMO", JOptionPane.ERROR_MESSAGE);
            btnGuardar.setEnabled(false);
        }

    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        boolean bandera = true;
        if (txtCliente.getText().equals("")) {
            bandera = false;
        }
        if (txtCantidad.getText().equals("")) {
            bandera = false;
        }
        if (txtMeses.getText().equals("")) {
            bandera = false;
        }
        
        if (comboMeses.getSelectedIndex() == 0) {
            bandera = false;
        }
        
        if (bandera) {
            double catidad = Integer.parseInt(txtCantidad.getText());
            int meses = Integer.parseInt(txtMeses.getText());
            int iva = (int) comboMeses.getSelectedIndex();
            ControladorUsuario controladorUsuario = new ControladorUsuario();
            Prestamo p = new Prestamo(0, BigDecimal.valueOf(catidad), meses, iva, controladorUsuario.findByCedula(txtCedula.getText()));
            ControladorPrestamo controladorPrestamo = new ControladorPrestamo();
            controladorPrestamo.createPrestamo(p);
            btnGuardar.setEnabled(false);
            
            p = controladorPrestamo.MaxId().get(0);
            Date date = new Date();
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            for (int i = 1; i < tabla.getRowCount(); i++) {
                date.setMonth(date.getMonth() + 1);
                double interes = (double) tabla.getValueAt(i, 1);
                double cuota = (double) tabla.getValueAt(i, 2);
                double capsin = (double) tabla.getValueAt(i, 3);
                double deuda = (double) tabla.getValueAt(i, 3);
                Amortizacion a = new Amortizacion(0, 1, BigDecimal.valueOf(interes), BigDecimal.valueOf(capsin), BigDecimal.valueOf(cuota), BigDecimal.valueOf(deuda), "POR PAGAR", date, p);
                ControladorAmortizacion controladorAmortizacion = new ControladorAmortizacion();
                controladorAmortizacion.Crear(a);
            }
            JOptionPane.showMessageDialog(this, "DATOS INGRESADOS CORRECTAMENTE");
            btnGuardar.setEnabled(false);
            limpiarTabla();
            txtCedula.setText("");
            txtCliente.setText("");
            txtTelefono.setText("");
            txtDireccion.setText("");
            txtCliente.setText("");
            txtCantidad.setText("");
            txtMeses.setText("");
            comboMeses.setSelectedIndex(0);
        } else {
            JOptionPane.showMessageDialog(this, "Exiten errores en los campos!! \nVerfique los datos ingresados", "PRESTAMO", JOptionPane.ERROR_MESSAGE);
            btnGuardar.setEnabled(false);
        }
        

    }//GEN-LAST:event_btnGuardarActionPerformed
    public void limpiarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton buscar4;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JComboBox<String> comboMeses;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane panelCrud;
    private javax.swing.JTable tabla;
    private javax.swing.JLabel telefono;
    private javax.swing.JLabel telefono1;
    private javax.swing.JLabel telefono2;
    private javax.swing.JLabel telefono3;
    private javax.swing.JTextField txtBuscarM;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtMeses;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
