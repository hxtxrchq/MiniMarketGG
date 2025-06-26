package com.mycompany.minimarketgg.igu.productos;
import com.mycompany.minimarketgg.logica.Categoria;
import com.mycompany.minimarketgg.logica.CategoriaDao;
import com.mycompany.minimarketgg.logica.Producto;
import com.mycompany.minimarketgg.logica.ProductoDao;
import com.mycompany.minimarketgg.logica.ProveedorDao;
import com.mycompany.minimarketgg.logica.Proveedor;
import com.mycompany.minimarketgg.util.IconoUtil;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class EditarProducto extends javax.swing.JFrame {

      public EditarProducto() {
        this.setTitle("Editar Producto");
        setResizable(false);
        IconoUtil.establecerIcono(this);
        initComponents();
        llenarComboboxProveedores();
        llenarComboboxCategorias();
        llenarComboboxProductos();
    }
    
   private void llenarComboboxProveedores() {
    ArrayList<String> nombresProveedores = prov_dao.obtenerNombresProveedores();
    for (String nombre : nombresProveedores) {
        comboBoxProveedor.addItem(nombre);
    }
}
    
    private void llenarComboboxCategorias() {
    ArrayList<String> nombresCategorias = cat_dao.obtenerNombresCategorias();
    for (String nombre : nombresCategorias) {
        comboBoxCategoria.addItem(nombre);
    }
}
    
    private void llenarComboboxProductos() {
    ArrayList<String> nombresProductos = pdao.obtenerNombresProductos();
    for (String nombre : nombresProductos) {
        comboBoxProducto.addItem(nombre);
    }
}
    
    Producto p = null; // Inicializar p como null
    ProductoDao pdao = new ProductoDao();
    ProveedorDao prov_dao = new ProveedorDao();
    CategoriaDao cat_dao = new CategoriaDao();        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        btnLimpiar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JToggleButton();
        btnCancelar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        btnComprobar = new javax.swing.JButton();
        comboBoxCategoria = new javax.swing.JComboBox<>();
        comboBoxProveedor = new javax.swing.JComboBox<>();
        comboBoxProducto = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Editar Producto");

        jLabel1.setText("Nombre:");

        jLabel2.setText("Categoria:");

        jLabel4.setText("Descripción:");

        jLabel5.setText("Precio:");

        jLabel6.setText("Stock:");

        jLabel7.setText("Proveedor:");

        txtStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStockActionPerformed(evt);
            }
        });

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcion);

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

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel8.setText("Producto:");

        btnComprobar.setText("Llenar Campos");
        btnComprobar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprobarActionPerformed(evt);
            }
        });

        comboBoxCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elige una categoria" }));
        comboBoxCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxCategoriaActionPerformed(evt);
            }
        });

        comboBoxProveedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elige un proveedor" }));
        comboBoxProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxProveedorActionPerformed(evt);
            }
        });

        comboBoxProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elige un producto" }));
        comboBoxProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(comboBoxProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(37, 37, 37)
                                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(68, 68, 68)
                                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jScrollPane1))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel8))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(comboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel5)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(txtNombre)
                                                    .addGap(67, 67, 67))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(comboBoxProducto, 0, 171, Short.MAX_VALUE)
                                                    .addGap(42, 42, 42)))
                                            .addComponent(btnComprobar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblTitulo)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(btnComprobar)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(comboBoxProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpiar)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addGap(25, 25, 25))
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

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        txtNombre.setText("");
        txtPrecio.setText("");
        txtStock.setText("");
        txtDescripcion.setText("");
        comboBoxCategoria.setSelectedIndex(0);
        comboBoxProveedor.setSelectedIndex(0);
        comboBoxProducto.setSelectedIndex(0);
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void txtStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStockActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void btnComprobarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprobarActionPerformed
   String nombreProducto = comboBoxProducto.getSelectedItem().toString();
    ProductoDao pdao = new ProductoDao();  // Aseg?rate de que pdao est? instanciado correctamente
    p = pdao.obtenerProductoPorNombre(nombreProducto);  // Obtener el producto por nombre
    if (p != null) {
        CategoriaDao cdao = new CategoriaDao();
        ProveedorDao provDao = new ProveedorDao();  // Cambi? el nombre para evitar conflictos

        // Producto encontrado, cargar los detalles del producto en los campos
        txtNombre.setText(p.getNombre());
        txtDescripcion.setText(p.getDescripcion());
        txtPrecio.setText(String.format("%.2f", p.getPrecio()));  // Formateo del precio para visualizaci?n
        txtStock.setText(String.valueOf(p.getStock()));

        Categoria categoria = cdao.obtenerCategoriaPorId(p.getIdCategoria());
        Proveedor proveedor = provDao.obtenerProveedorPorId(p.getIdProveedor());

        if (categoria != null) {
            comboBoxCategoria.setSelectedItem(categoria.getNombre());
        } else {
            comboBoxCategoria.setSelectedItem("Categoría no encontrada");
        }

        if (proveedor != null) {
            comboBoxProveedor.setSelectedItem(proveedor.getNombre());
        } else {
            comboBoxProveedor.setSelectedItem("Proveedor no encontrado");
        }
        
    } else {
        // Producto no encontrado, mostrar un mensaje
        JOptionPane.showMessageDialog(null, "El producto no existe en la base de datos.");
    }
    }//GEN-LAST:event_btnComprobarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // Verificar si se ha cargado un producto
    if (p != null) {
        try {
            // Actualizar los detalles del producto con los nuevos valores de los campos de texto
            p.setNombre(txtNombre.getText());
            p.setDescripcion(txtDescripcion.getText());
            p.setPrecio(Double.parseDouble(txtPrecio.getText()));
            p.setStock(Integer.parseInt(txtStock.getText()));

            // Obtener ID de la categor?a seleccionada
            Categoria categoriaSeleccionada = cat_dao.obtenerCategoriaPorNombre((String) comboBoxCategoria.getSelectedItem());
            if (categoriaSeleccionada != null) {
                p.setIdCategoria(categoriaSeleccionada.getId());
            } else {
                JOptionPane.showMessageDialog(null, "Categoría seleccionada no válida.");
                return;
            }

            // Obtener ID del proveedor seleccionado
            Proveedor proveedorSeleccionado = prov_dao.obtenerProveedorPorNombre((String) comboBoxProveedor.getSelectedItem());
            if (proveedorSeleccionado != null) {
                p.setIdProveedor(proveedorSeleccionado.getId());
            } else {
                JOptionPane.showMessageDialog(null, "Proveedor seleccionado no válido.");
                return;
            }

            // Llamar al m?todo para guardar los cambios en la base de datos
            if (pdao.actualizarProducto(p)) {
                JOptionPane.showMessageDialog(null, "Cambios guardados correctamente.");
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar los cambios.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error en la entrada de datos. Asegúrate de que el precio y el stock son numéricos.");
        }
    } else {
        JOptionPane.showMessageDialog(null, "No se ha cargado ningún producto para guardar los cambios.");
    }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void comboBoxProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxProveedorActionPerformed

    private void comboBoxCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxCategoriaActionPerformed

    private void comboBoxProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxProductoActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnComprobar;
    private javax.swing.JToggleButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> comboBoxCategoria;
    private javax.swing.JComboBox<String> comboBoxProducto;
    private javax.swing.JComboBox<String> comboBoxProveedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables
}
