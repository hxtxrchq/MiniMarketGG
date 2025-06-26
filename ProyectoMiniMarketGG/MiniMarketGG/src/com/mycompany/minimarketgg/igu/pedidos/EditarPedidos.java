package com.mycompany.minimarketgg.igu.pedidos;

import com.mycompany.minimarketgg.logica.Pedido;
import com.mycompany.minimarketgg.logica.PedidoDao;
import com.mycompany.minimarketgg.logica.ProveedorDao;
import com.mycompany.minimarketgg.logica.Proveedor;
import com.mycompany.minimarketgg.util.IconoUtil;
import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class EditarPedidos extends javax.swing.JFrame {

    private Pedido p = null; // Inicializar p como null
    private PedidoDao pdao = new PedidoDao();
    private ProveedorDao provDao = new ProveedorDao(); // Para obtener proveedores por ID
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public EditarPedidos() {
        this.setTitle("Editar Pedido");
        setResizable(false);
        IconoUtil.establecerIcono(this);
        initComponents();
        llenarComboboxPedidos();
        llenarComboboxProveedores();
    }

    private void llenarComboboxPedidos() {
        ArrayList<Pedido> pedidos = pdao.obtenerPedidos();
        for (Pedido pedido : pedidos) {
            comboBoxPedido.addItem(String.valueOf(pedido.getId()));
        }
    }
    
    private void llenarComboboxProveedores() {
        ArrayList<Proveedor> proveedores = provDao.obtenerProveedores();
        for (Proveedor proveedor : proveedores) {
            comboBoxProveedor.addItem(proveedor.getNombre());
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        comboBoxPedido = new javax.swing.JComboBox<>();
        btnLlenarCampos = new javax.swing.JButton();
        fechaPedido = new com.toedter.calendar.JDateChooser();
        comboBoxProveedor = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Editar Pedido");

        jLabel2.setText("ID Pedido");

        comboBoxPedido.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elige un ID de Pedido" }));
        comboBoxPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxPedidoActionPerformed(evt);
            }
        });

        btnLlenarCampos.setText("Llenar Campos");
        btnLlenarCampos.setToolTipText("");
        btnLlenarCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLlenarCamposActionPerformed(evt);
            }
        });

        fechaPedido.setDateFormatString("yyyy-MM-dd");

        comboBoxProveedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elige un proveedor" }));

        jLabel3.setText("Fecha");

        jLabel4.setText("Proveedor");

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(fechaPedido, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboBoxPedido, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboBoxProveedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(btnLlenarCampos))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(btnCancelar)
                        .addGap(31, 31, 31)
                        .addComponent(btnLimpiar)
                        .addGap(34, 34, 34)
                        .addComponent(btnGuardar)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboBoxPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLlenarCampos))
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fechaPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBoxProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnLimpiar)
                    .addComponent(btnGuardar))
                .addContainerGap(110, Short.MAX_VALUE))
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

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
         if (p != null) {
            try {
                String fechaPedidoStr = sdf.format(fechaPedido.getDate()); // Convertir la fecha a String
                p.setFechaPedido(fechaPedidoStr);
                String nombreProveedor = comboBoxProveedor.getSelectedItem().toString();
                Proveedor proveedorSeleccionado = provDao.obtenerProveedorPorNombre(nombreProveedor);
                if (proveedorSeleccionado != null) {
                    p.setIdProveedor(proveedorSeleccionado.getId());
                    if (pdao.actualizarPedido(p)) {
                        JOptionPane.showMessageDialog(null, "Cambios guardados correctamente.");
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al guardar los cambios.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Proveedor seleccionado no válido.");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error en la entrada de datos. Asegúrate de que la fecha y el proveedor son válidos.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se ha cargado ningún pedido para guardar los cambios.");
        }

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnLlenarCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLlenarCamposActionPerformed
           int idPedido = Integer.parseInt(comboBoxPedido.getSelectedItem().toString());
        p = pdao.obtenerPedidoPorId(idPedido);
        if (p != null) {
            try {
                fechaPedido.setDate(sdf.parse(p.getFechaPedido())); // Convertir la fecha de String a Date
            } catch (Exception e) {
                e.printStackTrace();
            }
            Proveedor proveedor = provDao.obtenerProveedorPorId(p.getIdProveedor());
            if (proveedor != null) {
                comboBoxProveedor.setSelectedItem(proveedor.getNombre());
            } else {
                comboBoxProveedor.setSelectedItem("Proveedor no encontrado");
            }
        } else {
            JOptionPane.showMessageDialog(null, "El pedido no existe en la base de datos.");
        }

    }//GEN-LAST:event_btnLlenarCamposActionPerformed

    private void comboBoxPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxPedidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxPedidoActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
      fechaPedido.setDate(null);
        comboBoxProveedor.setSelectedIndex(0);
        comboBoxPedido.setSelectedIndex(0);

    }//GEN-LAST:event_btnLimpiarActionPerformed

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
    private javax.swing.JComboBox<String> comboBoxPedido;
    private javax.swing.JComboBox<String> comboBoxProveedor;
    private com.toedter.calendar.JDateChooser fechaPedido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
