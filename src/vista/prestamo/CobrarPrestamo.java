/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.prestamo;

import controlador.ControladorAmortizacion;
import controlador.ControladorFundacion;
import controlador.ControladorPrestamo;
import vista.Cliente.*;
import controlador.ControladorUsuario;
import controlador.MySQLDB;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Amortizacion;
import modelo.Fundacion;
import modelo.Prestamo;
import modelo.Usuario;

/**
 *
 * @author vinic
 */
public class CobrarPrestamo extends javax.swing.JInternalFrame {

    /**
     * Creates new form Crear
     */
    private DefaultTableModel modelotabla;

    public CobrarPrestamo() {
        initComponents();
        modelotabla = new DefaultTableModel();

    }

    public void limpiarTablaPrestamo() {
        DefaultTableModel modelo = (DefaultTableModel) prestamo.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
    }

    public void limpiarTablapagado() {
        DefaultTableModel modelo = (DefaultTableModel) pagadas.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
    }

    public void limpiarTablaporPagar() {
        DefaultTableModel modelo = (DefaultTableModel) porPagar.getModel();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        prestamo = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        porPagar = new javax.swing.JTable();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        pagadas = new javax.swing.JTable();
        jLabel25 = new javax.swing.JLabel();
        ingreseCedula = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        buscar1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        prestamo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CANTIDAD PRESTADA", "MESES", "INTERES", "USUARIO"
            }
        ));
        prestamo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                prestamoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(prestamo);

        porPagar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Periodo", "Interes", "Cuota sin interes", "Cuota", "Deuda", "Estado", "Fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        porPagar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                porPagarMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(porPagar);

        jLabel23.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabel23.setText("LISTA DE PRESTAMOS");

        jLabel24.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabel24.setText("CUOTAS POR PAGAR");

        pagadas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Periodo", "Interes", "Cuota sin interes", "Cuota", "Deuda", "Estado", "Fecha"
            }
        ));
        jScrollPane2.setViewportView(pagadas);

        jLabel25.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabel25.setText("CUOTAS POR PAGAR");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 919, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(998, 998, 998))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel23))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel24))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 919, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 919, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel25)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel25)
                .addGap(21, 21, 21)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 999, -1));

        ingreseCedula.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        ingreseCedula.setText("INGRESE CEDULA: ");
        getContentPane().add(ingreseCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 164, 20));

        txtCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedulaKeyTyped(evt);
            }
        });
        getContentPane().add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 153, -1));

        buscar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar.png"))); // NOI18N
        buscar1.setText("BUSCAR");
        buscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscar1ActionPerformed(evt);
            }
        });
        getContentPane().add(buscar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void prestamoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_prestamoMouseClicked
        int id = (int) prestamo.getValueAt(prestamo.getSelectedRow(), 0);
        ControladorAmortizacion contAr = new ControladorAmortizacion();
        List<Amortizacion> lis = contAr.listar(id);
        DefaultTableModel model = (DefaultTableModel) porPagar.getModel();
        DefaultTableModel model1 = (DefaultTableModel) pagadas.getModel();
        int index1 = 0;
        int index2 = 0;
        for (Amortizacion u : lis) {
            if (u.getEstado().equals("POR PAGAR")) {
                model.insertRow(index1, new Object[]{u.getIdAmortizacion(), u.getPeriodo(), u.getInteres(), u.getCapitalSin(), u.getCouta(), u.getDeuda(), u.getEstado(), u.getFecha()});
            } else {
                model1.insertRow(index2, new Object[]{u.getIdAmortizacion(), u.getPeriodo(), u.getInteres(), u.getCapitalSin(), u.getCouta(), u.getDeuda(), u.getEstado(), u.getFecha()});
                index2++;
            }

        }
    }//GEN-LAST:event_prestamoMouseClicked

    private void txtCedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyTyped
        if (evt.getKeyCode() != KeyEvent.VK_DELETE) {
            if (evt.getKeyChar() < '0' || evt.getKeyChar() > '9') {
                evt.consume();
            }
        }
    }//GEN-LAST:event_txtCedulaKeyTyped

    private void buscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscar1ActionPerformed
        limpiarTablaPrestamo();
        limpiarTablapagado();
        limpiarTablaporPagar();
        if (txtCedula.getText().length() > 0) {
            ControladorUsuario conU = new ControladorUsuario();
            Usuario u = conU.findByCedula(txtCedula.getText());

            if (u != null) {
                ControladorPrestamo conp = new ControladorPrestamo();
                List<Prestamo> lis = conp.findByUsuario(u);
                System.out.println(lis.size());
                if (!lis.isEmpty()) {
                    DefaultTableModel model = (DefaultTableModel) prestamo.getModel();
                    int index = 0;
                    for (Prestamo uu : lis) {
                        model.insertRow(index, new Object[]{uu.getIdPrestamo(), uu.getCantidad(), uu.getMeses(), uu.getInteres(), (uu.getIdUsuario().getNombre() + " " + uu.getIdUsuario().getApellido())});
                        index++;
                    }

                } else {
                    JOptionPane.showMessageDialog(this, "Usuario no cuenta con prestamos");

                }
            } else {
                JOptionPane.showMessageDialog(this, "Usuario no econtrado");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Ingrese la cedula");
        }
    }//GEN-LAST:event_buscar1ActionPerformed

    private void porPagarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_porPagarMouseClicked
        System.out.println("a");
        if (evt.getClickCount() == 2) {
            int row = porPagar.getSelectedRow();
            ControladorAmortizacion con = new ControladorAmortizacion();
            Amortizacion u = con.findByID((int) porPagar.getValueAt(row, 0));
            int conf = JOptionPane.showConfirmDialog(this, "DESEA CALCELAR: " + u.getDeuda() + " CORRESPODIENTE AL PERIODO  "
                    + u.getPeriodo());
            if (conf == JOptionPane.OK_OPTION) {
                u.setEstado("PAGADO");
                con = new ControladorAmortizacion();
                con.edit(u);

                ControladorFundacion confu = new ControladorFundacion();
                Fundacion f = confu.findByID(1);
                double valor = f.getValorNeto().doubleValue();
                BigDecimal cantidad = (BigDecimal) u.getDeuda();
                double resta = valor + cantidad.doubleValue();
                f.setValorNeto(BigDecimal.valueOf(resta));
                confu.edit(f);
                JOptionPane.showMessageDialog(this, "CUOTA PAGADA");
                {
                    limpiarTablaporPagar();
                    limpiarTablapagado();
                    int id = (int) prestamo.getValueAt(prestamo.getSelectedRow(), 0);
                    ControladorAmortizacion contAr = new ControladorAmortizacion();
                    List<Amortizacion> lis = contAr.listar(id);
                    DefaultTableModel model = (DefaultTableModel) porPagar.getModel();
                    DefaultTableModel model1 = (DefaultTableModel) pagadas.getModel();
                    int index1 = 0;
                    int index2 = 0;
                    for (Amortizacion uu : lis) {
                        if (uu.getEstado().equals("POR PAGAR")) {
                            model.insertRow(index1, new Object[]{uu.getIdAmortizacion(), uu.getPeriodo(), uu.getInteres(), uu.getCapitalSin(), uu.getCouta(), uu.getDeuda(), uu.getEstado(), uu.getFecha()});
                        } else {
                            model1.insertRow(index2, new Object[]{uu.getIdAmortizacion(), uu.getPeriodo(), uu.getInteres(), uu.getCapitalSin(), uu.getCouta(), uu.getDeuda(), uu.getEstado(), uu.getFecha()});
                            index2++;
                        }

                    }
                }
            }
        }
    }//GEN-LAST:event_porPagarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscar1;
    private javax.swing.JLabel ingreseCedula;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable pagadas;
    private javax.swing.JTable porPagar;
    private javax.swing.JTable prestamo;
    private javax.swing.JTextField txtCedula;
    // End of variables declaration//GEN-END:variables
}
