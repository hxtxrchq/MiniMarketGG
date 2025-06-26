/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.minimarketgg.ventas;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.mycompany.minimarketgg.logica.Usuario;
import com.mycompany.minimarketgg.logica.Venta;
import com.mycompany.minimarketgg.logica.VentaDao;
import com.mycompany.minimarketgg.util.IconoUtil;
import com.mycompany.minimarketgg.util.PantallaUtil;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JOptionPane;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class HistorialVenta extends javax.swing.JPanel {
    /**
     * Creates new form HistorialVenta
     */
    private DefaultTableModel modeloTabla;
    private VentaDao ventaDao = new VentaDao();
    private Usuario usuario;

    public HistorialVenta(Usuario usuario) {
        this.usuario = usuario;
        initComponents();
        modeloTabla = (DefaultTableModel) TablaHistorial.getModel();
        cargarHistorialVentas();

        btnLimpiarHistorial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarHistorial();
            }
        });

        btnImprimirHistorial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    imprimirHistorial();
                } catch (FileNotFoundException | DocumentException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error al generar el PDF: " + ex.getMessage());
                }
            }
        });
    }

    private void cargarHistorialVentas() {
        List<Venta> historialVentas = ventaDao.obtenerHistorialVentas();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        modeloTabla.setRowCount(0);
        for (Venta venta : historialVentas) {
            String fechaFormateada = dateFormat.format(venta.getFecha());
            modeloTabla.addRow(new Object[]{venta.getNumeroBoleta(), venta.getMetodoPago(), venta.getTotal(), fechaFormateada});
        }
    }

    private void limpiarHistorial() {
        modeloTabla.setRowCount(0);
        ventaDao.limpiarHistorialVentas();
    }

    private void imprimirHistorial() throws FileNotFoundException, DocumentException {
    String dest = "historial_ventas.pdf";
    Document document = new Document();
    PdfWriter.getInstance(document, new FileOutputStream(dest));
    document.open();

    // Añadir título al PDF
    Font titleFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
    Paragraph title = new Paragraph("Historial de Ventas", titleFont);
    title.setAlignment(Element.ALIGN_CENTER);
    document.add(title);

    // Crear tabla
    PdfPTable table = new PdfPTable(4); // 4 columnas
    table.setWidthPercentage(100); // Ancho de la tabla
    table.setSpacingBefore(10f); // Espacio antes de la tabla
    table.setSpacingAfter(10f); // Espacio después de la tabla

    // Añadir encabezados a la tabla
    Font headFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
    table.addCell(new PdfPCell(new Phrase("Num Boleta", headFont)));
    table.addCell(new PdfPCell(new Phrase("Metodo de Pago", headFont)));
    table.addCell(new PdfPCell(new Phrase("Total", headFont)));
    table.addCell(new PdfPCell(new Phrase("Fecha de Venta", headFont)));

    // Añadir filas a la tabla
    for (int i = 0; i < modeloTabla.getRowCount(); i++) {
        table.addCell(new PdfPCell(new Phrase(modeloTabla.getValueAt(i, 0).toString())));
        table.addCell(new PdfPCell(new Phrase(modeloTabla.getValueAt(i, 1).toString())));
        
        // Formatear el total con "S/. "
        String totalFormateado = "S/. " + modeloTabla.getValueAt(i, 2).toString();
        table.addCell(new PdfPCell(new Phrase(totalFormateado)));
        
        table.addCell(new PdfPCell(new Phrase(modeloTabla.getValueAt(i, 3).toString())));
    }

    // Añadir tabla al documento
    document.add(table);

    // Cerrar documento
    document.close();

    JOptionPane.showMessageDialog(null, "Historial de ventas guardado como PDF.");

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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaHistorial = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        btnLimpiarHistorial = new javax.swing.JButton();
        btnImprimirHistorial = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setText("HISTORIAL VENTAS");

        TablaHistorial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Num Boleta", "Metodo de Pago", "Total", "Fecha de Venta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TablaHistorial);

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/minimarketgg/imagenes/back_icon.png"))); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnLimpiarHistorial.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnLimpiarHistorial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/minimarketgg/imagenes/limpiar.png"))); // NOI18N
        btnLimpiarHistorial.setText("Limpiar Historial");

        btnImprimirHistorial.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnImprimirHistorial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/minimarketgg/imagenes/impresora.png"))); // NOI18N
        btnImprimirHistorial.setText("Imprimir");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(btnBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(295, 295, 295))
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnLimpiarHistorial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnImprimirHistorial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 697, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addGap(126, 126, 126)
                        .addComponent(btnLimpiarHistorial)
                        .addGap(18, 18, 18)
                        .addComponent(btnImprimirHistorial)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        if (frame != null) {
            frame.dispose();
        }
        JFrame ventanaVentas = new JFrame();
    Ventas ventasPanel = new Ventas(usuario); // Pasar el objeto usuario al constructor de Ventas
    ventanaVentas.setContentPane(ventasPanel);
    ventanaVentas.setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximizar la ventana a pantalla completa
    ventanaVentas.setVisible(true);
    ventanaVentas.setLocationRelativeTo(null);
    IconoUtil.establecerIcono(ventanaVentas);
    ventanaVentas.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaHistorial;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnImprimirHistorial;
    private javax.swing.JButton btnLimpiarHistorial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
