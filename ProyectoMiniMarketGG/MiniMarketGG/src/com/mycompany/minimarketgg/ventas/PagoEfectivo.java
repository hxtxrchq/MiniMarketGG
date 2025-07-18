/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.minimarketgg.ventas;

import com.mycompany.minimarketgg.igu.Menu;
import com.mycompany.minimarketgg.igu.productos.Inventario;
import com.mycompany.minimarketgg.logica.Producto;
import com.mycompany.minimarketgg.logica.ProductoDao;
import com.mycompany.minimarketgg.logica.Usuario; // Importar Usuario
import com.mycompany.minimarketgg.logica.Venta;
import com.mycompany.minimarketgg.logica.VentaDao;
import com.mycompany.minimarketgg.util.PantallaUtil;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class PagoEfectivo extends javax.swing.JPanel {

    private JTable tablaVenta;
    private double totalPagar;
    private ProductoDao productoDao;
    private Usuario usuario;
    private int numeroBoleta;

    public PagoEfectivo(JTable tablaVenta, double totalPagar, Usuario usuario, int numeroBoleta) {
        this.tablaVenta = tablaVenta;
        this.totalPagar = totalPagar;
        this.usuario = usuario;
        this.numeroBoleta = numeroBoleta;
        this.productoDao = new ProductoDao();
        initComponents();
        txtTotalAPagar.setText(String.valueOf(totalPagar));
        txtTotalAPagar.setEditable(false);
        btnPagar.setEnabled(false);
        addListeners();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCancelaCon = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTotalAPagar = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtVuelto = new javax.swing.JTextField();
        btnPagar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btnCancelarVenta = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("PAGO EFECTIVO");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setText("Cancela con:");

        txtCancelaCon.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtCancelaCon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCancelaConActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel3.setText("Total a pagar:");

        txtTotalAPagar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtTotalAPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalAPagarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel4.setText("Vuelto:");

        txtVuelto.setEditable(false);
        txtVuelto.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtVuelto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVueltoActionPerformed(evt);
            }
        });

        btnPagar.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        btnPagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/minimarketgg/imagenes/payment-method (1).png"))); // NOI18N
        btnPagar.setText("PAGAR");
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/minimarketgg/imagenes/Alegre2.png"))); // NOI18N

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/minimarketgg/imagenes/back_icon.png"))); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnCancelarVenta.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnCancelarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/minimarketgg/imagenes/delete window.png"))); // NOI18N
        btnCancelarVenta.setText("CANCELAR VENTA");
        btnCancelarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarVentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(216, 216, 216)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtVuelto, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                                    .addComponent(txtTotalAPagar))
                                .addGap(256, 256, 256)
                                .addComponent(btnPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(238, 238, 238)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(406, 406, 406)
                                .addComponent(jLabel1)
                                .addGap(200, 200, 200)
                                .addComponent(btnCancelarVenta)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(209, 209, 209))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(39, 39, 39)
                        .addComponent(txtCancelaCon, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(btnBack)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(btnBack)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(btnCancelarVenta))
                .addGap(118, 118, 118)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCancelaCon, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(btnPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotalAPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(87, 87, 87)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtVuelto, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addContainerGap(354, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addListeners() {
        txtCancelaCon.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                calcularVuelto();
            }
            public void removeUpdate(DocumentEvent e) {
                calcularVuelto();
            }
            public void insertUpdate(DocumentEvent e) {
                calcularVuelto();
            }
        });
    }
    
private void calcularVuelto() {
    try {
            double cancelaCon = Double.parseDouble(txtCancelaCon.getText());
            double vuelto = cancelaCon - totalPagar;
            txtVuelto.setText(String.format("%.2f", vuelto));
            btnPagar.setEnabled(cancelaCon >= totalPagar);
        } catch (NumberFormatException e) {
            txtVuelto.setText("0");
            btnPagar.setEnabled(false);
        }   
}

    private void txtCancelaConActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCancelaConActionPerformed
         // Calcular el vuelto autom�ticamente
        try {
            double cancelaCon = Double.parseDouble(txtCancelaCon.getText());
            double vuelto = cancelaCon - totalPagar;
            txtVuelto.setText(String.valueOf(vuelto));
            btnPagar.setEnabled(cancelaCon >= totalPagar);
        } catch (NumberFormatException e) {
            txtVuelto.setText("0");
            btnPagar.setEnabled(false);
        }
    }//GEN-LAST:event_txtCancelaConActionPerformed

    private void txtTotalAPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalAPagarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalAPagarActionPerformed

    private void txtVueltoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVueltoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVueltoActionPerformed

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
        // Registrar la venta en la base de datos
    registrarVentaEnBD(numeroBoleta, "Efectivo", totalPagar, new Date());
    
    // Actualizar el stock de productos solo aqu�
        actualizarStockProductos();
    // Abrir la ventana de pago realizado
    JFrame ventanaPagoRealizado = new JFrame();
    PagoRealizado pagoRealizadoPanel = new PagoRealizado(tablaVenta, totalPagar, usuario, "Efectivo", numeroBoleta);
    ventanaPagoRealizado.setContentPane(pagoRealizadoPanel);
    ventanaPagoRealizado.setSize((int) (PantallaUtil.obtenerAnchoPantalla() * 0.85), (int) (PantallaUtil.obtenerAltoPantalla() * 0.85)); 
    ventanaPagoRealizado.setVisible(true);
    ventanaPagoRealizado.setLocationRelativeTo(null);
    ventanaPagoRealizado.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    
    
    // Cerrar la ventana actual
    JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
    if (currentFrame != null) {
        currentFrame.dispose();
    }
    }//GEN-LAST:event_btnPagarActionPerformed
    private void actualizarStockProductos() {
         for (int i = 0; i < tablaVenta.getRowCount(); i++) {
        int idProducto = Integer.parseInt(tablaVenta.getValueAt(i, 0).toString());
        int cantidadVendida = Integer.parseInt(tablaVenta.getValueAt(i, 2).toString());

        Producto producto = productoDao.obtenerProductoPorId(idProducto);
        int nuevoStock = producto.getStock() - cantidadVendida;

        boolean actualizado = productoDao.actualizarStockProducto(idProducto, nuevoStock);
        if (!actualizado) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el stock del producto: " + producto.getNombre());
        }
    }
    }
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
    // Cerrar la ventana actual
        JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        if (currentFrame != null) {
            currentFrame.dispose();
        }

        // Abrir la ventana de m�todos de pago
        JFrame ventanaPagos = new JFrame();
        Pagos pagosPanel = new Pagos(tablaVenta, totalPagar, usuario); 
        ventanaPagos.setContentPane(pagosPanel);
        ventanaPagos.setSize((int) (PantallaUtil.obtenerAnchoPantalla() * 0.85), (int) (PantallaUtil.obtenerAltoPantalla() * 0.85)); 
        ventanaPagos.setVisible(true);
        ventanaPagos.setLocationRelativeTo(null);
        ventanaPagos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }//GEN-LAST:event_btnBackActionPerformed

    private void btnCancelarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarVentaActionPerformed
        // Opciones personalizadas para el cuadro de di�logo
        String[] options = {"S�", "No"};
        int response = JOptionPane.showOptionDialog(
                this, 
                "�Est�s seguro de que quieres cancelar la venta?", 
                "Confirmar cancelaci�n", 
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.QUESTION_MESSAGE, 
                null, 
                options, 
                options[1]);

        // Si el usuario confirma la cancelaci�n
        if (response == JOptionPane.YES_OPTION) {
            // Redirigir al men� principal
            JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            if (currentFrame != null) {
                currentFrame.dispose(); // Cerrar la ventana actual

                // Crear y mostrar la ventana del men� principal
                Menu menu = new Menu(usuario);  // Pasar el objeto Usuario al men�
                menu.setResizable(false);
                menu.setVisible(true);
                menu.setSize((int) (PantallaUtil.obtenerAnchoPantalla() * 0.62), (int) (PantallaUtil.obtenerAltoPantalla() * 0.67)); // Tama�o de ventana = 85% del monitor
                menu.setLocationRelativeTo(null);
            }
        }
    }//GEN-LAST:event_btnCancelarVentaActionPerformed
    private void registrarVentaEnBD(int numeroBoleta, String metodoPago, double total, Date fecha) {
    Timestamp timestamp = new Timestamp(fecha.getTime());
    Venta venta = new Venta(numeroBoleta, metodoPago, total, timestamp);
    VentaDao ventaDao = new VentaDao();
    ventaDao.guardarVenta(venta);
}





    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCancelarVenta;
    private javax.swing.JButton btnPagar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtCancelaCon;
    private javax.swing.JTextField txtTotalAPagar;
    private javax.swing.JTextField txtVuelto;
    // End of variables declaration//GEN-END:variables
}
