package com.mycompany.minimarketgg.igu.pedidos.prodped;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mycompany.minimarketgg.igu.table.VentanaTabla;
import com.mycompany.minimarketgg.logica.Pedido;
import com.mycompany.minimarketgg.logica.PedidoDao;
import com.mycompany.minimarketgg.logica.ProductoPedido;
import com.mycompany.minimarketgg.logica.ProductoPedidoDao;
import com.mycompany.minimarketgg.logica.ProveedorDao;
import com.mycompany.minimarketgg.util.IconoUtil;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import javax.swing.JOptionPane;

public class ProductoPed extends javax.swing.JFrame {
private int idPedido;
    
    public ProductoPed(int idPedido) {
        this.idPedido = idPedido;
        initComponents();
        this.setTitle("Pedido id-" + idPedido + " MiniMarketGG");
        IconoUtil.establecerIcono(this);
        VentanaTabla TablaProdPed = new VentanaTabla(5,idPedido);
        jPanelTablaProdPed.add(TablaProdPed);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        actualizarContadorProdPed(); 
 
    }

    private void actualizarTabla(){
        jPanelTablaProdPed.removeAll();
        VentanaTabla TablaProdPed = new VentanaTabla(5,idPedido);
        jPanelTablaProdPed.add(TablaProdPed);
        jPanelTablaProdPed.revalidate();
        jPanelTablaProdPed.repaint();
        actualizarContadorProdPed();
        actualizarTotalPedidoDespuesDeCambios(idPedido);
    }
    

    public void actualizarContadorProdPed() {
        ProductoPedidoDao propeddao = new ProductoPedidoDao();
        int cantidadProdPed = propeddao.obtenerCantidadProductosPedidosPorPedido(idPedido); // Asegúrate de que este método tome en cuenta el idPedido
        jLabelCounterProdPed.setText("Productos en pedido: " + cantidadProdPed);
    }
    
    public void actualizarTotalPedidoDespuesDeCambios(int idPedido) {
    ProductoPedidoDao ppDao = new ProductoPedidoDao();
    double nuevoTotal = ppDao.calcularTotalPedido(idPedido);
    PedidoDao pedidoDao = new PedidoDao();
    pedidoDao.actualizarTotalPedido(idPedido, nuevoTotal);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanelTablaProdPed = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnAgregar1 = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JToggleButton();
        jLabelCounterProdPed = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanelTablaProdPedLayout = new javax.swing.GroupLayout(jPanelTablaProdPed);
        jPanelTablaProdPed.setLayout(jPanelTablaProdPedLayout);
        jPanelTablaProdPedLayout.setHorizontalGroup(
            jPanelTablaProdPedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 880, Short.MAX_VALUE)
        );
        jPanelTablaProdPedLayout.setVerticalGroup(
            jPanelTablaProdPedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Productos en Pedido");

        btnAgregar1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnAgregar1.setText("Agregar");
        btnAgregar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregar1ActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/minimarketgg/imagenes/refresh_icon.png"))); // NOI18N
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        jLabelCounterProdPed.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabelCounterProdPed.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelCounterProdPed.setText("Productos en pedido: 0");
        jLabelCounterProdPed.setForeground(new java.awt.Color(25, 25, 112));
        actualizarContadorProdPed();

        btnEditar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/minimarketgg/imagenes/impresora.png"))); // NOI18N
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabelCounterProdPed, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnAgregar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                                    .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(btnAgregar1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelCounterProdPed)
                .addGap(27, 27, 27)
                .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(138, Short.MAX_VALUE))
        );

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/minimarketgg/imagenes/delete window.png"))); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBack)
                .addGap(95, 95, 95))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelTablaProdPed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(btnBack))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanelTablaProdPed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        actualizarTabla();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        EliminarProductoPed eliminar = new EliminarProductoPed(idPedido);
        eliminar.setVisible(true);
        eliminar.setLocationRelativeTo(null);
        eliminar.setDefaultCloseOperation(eliminar.DISPOSE_ON_CLOSE);
        eliminar.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                actualizarTabla();
            }
        });
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnAgregar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregar1ActionPerformed
        AgregarProductoPed agregar = new AgregarProductoPed(idPedido);
        agregar.setVisible(true);
        agregar.setLocationRelativeTo(null);
        agregar.setDefaultCloseOperation(agregar.DISPOSE_ON_CLOSE);
        agregar.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                actualizarTabla();
            }
        });
    }//GEN-LAST:event_btnAgregar1ActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
       EditarProductoPed editar = new EditarProductoPed(idPedido);
    editar.setVisible(true);
    editar.setLocationRelativeTo(null);
    editar.setDefaultCloseOperation(editar.DISPOSE_ON_CLOSE);
    editar.addWindowListener(new java.awt.event.WindowAdapter() {
        @Override
        public void windowClosed(java.awt.event.WindowEvent windowEvent) {
            actualizarTabla();
        }
    });
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        try {
            imprimirPedido();
        } catch (FileNotFoundException | DocumentException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al generar el PDF: " + ex.getMessage());
        }
    }//GEN-LAST:event_btnImprimirActionPerformed
    
    private void imprimirPedido() throws FileNotFoundException, DocumentException {
        ProductoPedidoDao productoPedidoDao = new ProductoPedidoDao();
        PedidoDao pedidoDao = new PedidoDao();
        Pedido pedido = pedidoDao.obtenerPedidoPorId(idPedido);
        List<ProductoPedido> productosPedido = productoPedidoDao.obtenerProductosPedidosPorPedido(idPedido);

        // Obtener el nombre del proveedor
        ProveedorDao proveedorDao = new ProveedorDao();
        String nombreProveedor = proveedorDao.obtenerNombreProveedorPorId(pedido.getIdProveedor());

        String dest = "pedido_" + idPedido + ".pdf";
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(dest));
        document.open();

        // Añadir título al PDF
        Font titleFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
        Paragraph title = new Paragraph("Pedido ID: " + idPedido, titleFont);
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);

        // Información del pedido
        Font infoFont = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL);
        Paragraph info = new Paragraph("Fecha de Pedido: " + pedido.getFechaPedido() + "\nProveedor: " + nombreProveedor + "\nTotal Pedido: S/ " + pedido.getTotalPedido(), infoFont);
        info.setAlignment(Element.ALIGN_LEFT);
        document.add(info);

        // Crear tabla
        PdfPTable table = new PdfPTable(4); // 4 columnas
        table.setWidthPercentage(100); // Ancho de la tabla
        table.setSpacingBefore(10f); // Espacio antes de la tabla
        table.setSpacingAfter(10f); // Espacio después de la tabla

        // Añadir encabezados a la tabla
        Font headFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
        table.addCell(new PdfPCell(new Phrase("Nombre Producto", headFont)));
        table.addCell(new PdfPCell(new Phrase("Cantidad", headFont)));
        table.addCell(new PdfPCell(new Phrase("Precio Unitario", headFont)));
        table.addCell(new PdfPCell(new Phrase("Precio Total", headFont)));

        // Añadir filas a la tabla
        for (ProductoPedido pp : productosPedido) {
            String nombreProducto = productoPedidoDao.obtenerNombreProductoPorId(pp.getIdProducto());
            table.addCell(new PdfPCell(new Phrase(nombreProducto)));
            table.addCell(new PdfPCell(new Phrase(String.valueOf(pp.getCantidad()))));
            table.addCell(new PdfPCell(new Phrase(String.valueOf(pp.getPrecioPorUnidadProveedor()))));
            table.addCell(new PdfPCell(new Phrase(String.valueOf(pp.getPrecioTotal()))));
        }

        // Añadir tabla al documento
        document.add(table);

        // Cerrar documento
        document.close();

        JOptionPane.showMessageDialog(null, "Pedido guardado como PDF.");

        // Abrir el archivo PDF
        try {
            File pdfFile = new File(dest);
            if (pdfFile.exists()) {
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(pdfFile);
                } else {
                    JOptionPane.showMessageDialog(null, "Apertura automática de PDF no soportada en este sistema.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "El archivo PDF no se encuentra.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al abrir el archivo PDF: " + e.getMessage());
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnActualizar;
    private javax.swing.JButton btnAgregar1;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelCounterProdPed;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelTablaProdPed;
    // End of variables declaration//GEN-END:variables
}
