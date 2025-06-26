package com.mycompany.minimarketgg.igu.pedidos.prodped;

import com.mycompany.minimarketgg.logica.Producto;
import com.mycompany.minimarketgg.logica.ProductoDao;
import com.mycompany.minimarketgg.logica.ProductoPedido;
import com.mycompany.minimarketgg.logica.ProductoPedidoDao;
import com.mycompany.minimarketgg.util.IconoUtil;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class EliminarProductoPed extends javax.swing.JFrame {

    private int idPedido;
    private ProductoPedidoDao productopedidodao;
    private Producto producto;
    private ProductoDao productodao;
    
    public EliminarProductoPed(int idPedido) {
        this.productopedidodao = new ProductoPedidoDao();
        this.productodao = new ProductoDao();
        this.idPedido = idPedido;
        this.setTitle("Eliminar Producto del Pedido");
        setResizable(false);
        IconoUtil.establecerIcono(this);
        initComponents();
        actualizarComboBoxProductoPeds();
    }
    
    private void actualizarComboBoxProductoPeds() {
        comboBoxProductoPed.removeAllItems();
        ArrayList<ProductoPedido> productosPedido = productopedidodao.obtenerProductosPedido(idPedido);
        for (ProductoPedido productoPedido : productosPedido) {
            producto = productodao.obtenerProductoPorId(productoPedido.getIdProducto());
            if (producto != null) {
                comboBoxProductoPed.addItem(producto.getNombre());
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JToggleButton();
        btnCancelar = new javax.swing.JToggleButton();
        chkConfirmacion = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        comboBoxProductoPed = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Eliminar Producto");

        jLabel1.setText("Producto:");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        chkConfirmacion.setText("¿Confirmas la eliminación?");
        chkConfirmacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkConfirmacionActionPerformed(evt);
            }
        });

        jLabel2.setText("Marca para confirmar:");

        comboBoxProductoPed.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elige un producto" }));
        comboBoxProductoPed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxProductoPedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(38, 38, 38)
                                        .addComponent(chkConfirmacion, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(68, 68, 68)
                                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboBoxProductoPed, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(157, 157, 157)))))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblTitulo)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(comboBoxProductoPed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkConfirmacion)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chkConfirmacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkConfirmacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkConfirmacionActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
    String nombreProducto = (String) comboBoxProductoPed.getSelectedItem();
        if (nombreProducto != null) {
            if (chkConfirmacion.isSelected()) {
                // La casilla de verificación está marcada, procede con la eliminación del producto del pedido
                int idProducto = productodao.obtenerIdPorNombre(nombreProducto);  // Obtener id desde nombre
                if (idProducto != -1) {
                    // Producto encontrado, proceder con la eliminación
                    if (productopedidodao.eliminarProductoPedido(idProducto, idPedido)) {
                        JOptionPane.showMessageDialog(this, "Producto eliminado del pedido correctamente.");
                        this.dispose();  // Cierra la ventana
                    } else {
                        JOptionPane.showMessageDialog(this, "Error al eliminar el producto del pedido.");
                    }
                } else {
                    // Producto no encontrado en el pedido
                    JOptionPane.showMessageDialog(this, "El producto seleccionado no está en el pedido.");
                }
            } else {
                // La casilla de verificación no está marcada, informar al usuario que debe confirmar la eliminación
                JOptionPane.showMessageDialog(this, "Por favor, marque la casilla de confirmación para eliminar el producto del pedido.");
            }
        } else {
            // No hay producto seleccionado o el comboBox está vacío
            JOptionPane.showMessageDialog(this, "No hay producto seleccionado para eliminar.");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void comboBoxProductoPedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxProductoPedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxProductoPedActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnCancelar;
    private javax.swing.JToggleButton btnGuardar;
    private javax.swing.JCheckBox chkConfirmacion;
    private javax.swing.JComboBox<String> comboBoxProductoPed;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
