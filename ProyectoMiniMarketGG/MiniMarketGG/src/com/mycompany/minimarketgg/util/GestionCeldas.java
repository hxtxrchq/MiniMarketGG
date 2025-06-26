package com.mycompany.minimarketgg.util;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.table.DefaultTableCellRenderer;

public class GestionCeldas extends DefaultTableCellRenderer {
    private String tipo;  // Puede ser "texto" o "icono"
    private Font normal = new Font("Rubik", Font.PLAIN, 12);
    private Font bold = new Font("Rubik", Font.BOLD, 12);
    private ImageIcon iconoInformar = new ImageIcon(getClass().getResource("/com/mycompany/minimarketgg/imagenes/info_icon.png"));

    public GestionCeldas() {
        this.tipo = "texto"; // Valor por defecto
    }

    public GestionCeldas(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Verifica si la tabla contiene la columna "Stock"
        boolean containsStockColumn = false;
        TableModel model = table.getModel();
        for (int i = 0; i < model.getColumnCount(); i++) {
            if ("Stock".equals(model.getColumnName(i))) {
                containsStockColumn = true;
                break;
            }
        }

        // Aplica la lógica de pintar fila basada en la columna de stock
        if (containsStockColumn && column == table.getColumnModel().getColumnIndex("Stock")) {
            try {
                int stock = Integer.parseInt(value.toString());
                if (stock <= 12) {
                    setBackground(Color.YELLOW);
                    setForeground(Color.BLACK);
                } else {
                    setBackground(isSelected ? new Color(140, 140, 140) : Color.WHITE);
                    setForeground(isSelected ? Color.WHITE : Color.BLACK);
                }
            } catch (NumberFormatException e) {
                setBackground(isSelected ? new Color(140, 140, 140) : Color.WHITE);
                setForeground(Color.BLACK);
            }
        } else {
            setBackground(isSelected ? new Color(140, 140, 140) : Color.WHITE);
            setForeground(isSelected ? Color.WHITE : Color.BLACK);
        }

        // Configurar icono o texto según el tipo de celda
        if ("icono".equals(tipo) && "INFO".equals(value)) {
            setText("");
            setIcon(iconoInformar);
            setToolTipText("Click para más información");
        } else {
            setText((value == null) ? "" : value.toString());
            setIcon(null);
        }

        setHorizontalAlignment(JLabel.CENTER);
        setFont(isSelected ? bold : normal);
        return this;
    }
}