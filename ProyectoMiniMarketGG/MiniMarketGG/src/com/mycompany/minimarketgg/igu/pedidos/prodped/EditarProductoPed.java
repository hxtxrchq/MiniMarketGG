package com.mycompany.minimarketgg.igu.pedidos.prodped;

import com.mycompany.minimarketgg.logica.ProductoPedido;
import com.mycompany.minimarketgg.logica.ProductoPedidoDao;
import com.mycompany.minimarketgg.util.IconoUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

public class EditarProductoPed extends javax.swing.JFrame {

    private ProductoPedido productoPedido = null;
    private ProductoPedidoDao productoPedidoDao = new ProductoPedidoDao();
    private int idPedido; // Variable para almacenar el ID del pedido
    private Map<String, Integer> productoNombreIdMap; // Mapa para almacenar nombre de producto e ID

    public EditarProductoPed(int idPedido) {
        this.idPedido = idPedido;
        this.setTitle("Editar Producto del Pedido");
        setResizable(false);
        IconoUtil.establecerIcono(this);
        initComponents();
        llenarComboboxProductos();
    }

    private void llenarComboboxProductos() {
        productoNombreIdMap = new HashMap<>();
        ArrayList<ProductoPedido> productos = productoPedidoDao.obtenerProductosPedido(idPedido);
        for (ProductoPedido producto : productos) {
            String nombreProducto = productoPedidoDao.obtenerNombreProductoPorId(producto.getIdProducto());
            if (nombreProducto != null) {
                comboProducto.addItem(nombreProducto);
                productoNombreIdMap.put(nombreProducto, producto.getIdProducto());
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        comboProducto = new javax.swing.JComboBox<>();
        txtCantidad = new javax.swing.JTextField();
        txtPrecioUnitario = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnLlenarCampos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        comboProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboProductoActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                btnLimpiarStateChanged(evt);
            }
        });
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Editar Productos en Pedido");

        jLabel2.setText("Producto:");

        jLabel3.setText("Cantidad:");

        jLabel4.setText("Precio unitario:");

        btnLlenarCampos.setText("Llenar Campos");
        btnLlenarCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLlenarCamposActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(btnCancelar)
                        .addGap(40, 40, 40)
                        .addComponent(btnLimpiar)
                        .addGap(46, 46, 46)
                        .addComponent(btnGuardar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(comboProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(71, 71, 71)
                                .addComponent(btnLlenarCampos))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtPrecioUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLlenarCampos))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtPrecioUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGuardar)
                    .addComponent(btnLimpiar))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_btnLimpiarStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarStateChanged

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        txtCantidad.setText("");
        txtPrecioUnitario.setText("");
        comboProducto.setSelectedIndex(0);
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void comboProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboProductoActionPerformed
  
    }//GEN-LAST:event_comboProductoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (productoPedido != null) {
            try {
                int cantidad = Integer.parseInt(txtCantidad.getText());
                productoPedido.setCantidad(cantidad);
                productoPedido.updatePrecioTotal(); // Actualiza el precio total basado en la nueva cantidad
                if (productoPedidoDao.actualizarProductoPedido(productoPedido)) {
                    JOptionPane.showMessageDialog(null, "Cambios guardados correctamente.");
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al guardar los cambios.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error en la entrada de datos. Asegúrate de que la cantidad es válida.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se ha cargado ningún producto para guardar los cambios.");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnLlenarCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLlenarCamposActionPerformed
         String nombreProducto = (String) comboProducto.getSelectedItem();
    if (nombreProducto != null && productoNombreIdMap.containsKey(nombreProducto)) {
        int idProducto = productoNombreIdMap.get(nombreProducto);
        productoPedido = productoPedidoDao.obtenerProductoPedidoPorIdProductoYIdPedido(idProducto, idPedido);
        if (productoPedido != null) {
            txtCantidad.setText(String.valueOf(productoPedido.getCantidad()));
            txtPrecioUnitario.setText(String.valueOf(productoPedido.getPrecioPorUnidadProveedor()));
            txtPrecioUnitario.setEditable(false); // Hacer que el campo de texto no sea editable después de llenarlo
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo encontrar el producto en el pedido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(this, "El producto seleccionado no es válido.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnLlenarCamposActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();        
    }//GEN-LAST:event_btnCancelarActionPerformed

    /**
     * @param args the command line arguments
     */
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnLlenarCampos;
    private javax.swing.JComboBox<String> comboProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtPrecioUnitario;
    // End of variables declaration//GEN-END:variables
}
