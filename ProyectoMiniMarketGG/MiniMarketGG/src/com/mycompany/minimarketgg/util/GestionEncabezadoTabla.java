package com.mycompany.minimarketgg.util;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;

//  Permite personalizar el encabezado de la tabla (Color, tamaño, etc)
public class GestionEncabezadoTabla implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = new JLabel((String) value, SwingConstants.CENTER);
        label.setOpaque(true);
        label.setBackground(new Color(25, 16, 19)); // Color oscuro para el fondo
        label.setForeground(Color.white); // Texto en color blanco
        label.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 1, Color.white)); // Borde blanco
        label.setToolTipText("Click para ordenar"); // Tooltip más genérico

        // Ajustar el tamaño del encabezado
        label.setPreferredSize(new Dimension(table.getColumnModel().getColumn(column).getWidth(), 30));
        label.setMinimumSize(new Dimension(50, 30)); // Asegura que la altura mínima sea 30
        
        return label;
    }
}