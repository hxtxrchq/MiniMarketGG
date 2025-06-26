package com.mycompany.minimarketgg.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTable;

public class ReceiptGenerator {

    private JTable tablaVenta;
    private double totalPago;
    private int ticketNumber;

    public ReceiptGenerator(JTable tablaVenta, double totalPago, int ticketNumber) {
        this.tablaVenta = tablaVenta;
        this.totalPago = totalPago;
        this.ticketNumber = ticketNumber;
    }

    public String generateReceiptText() {
        StringBuilder receiptText = new StringBuilder();

        // Centrar MinimarketGG
        receiptText.append(centerText("MinimarketGG")).append("\n");

        // Centrar Ticket de venta #
        receiptText.append(centerText("Ticket de venta #" + ticketNumber)).append("\n");

        // Fecha y hora
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String dateString = dateFormat.format(new Date());
        receiptText.append(String.format("%-20s %s\n", "Fecha: " + dateString.split(" ")[0], dateString.split(" ")[1]));

        // Añadir encabezados de las columnas
        receiptText.append("--------------------------------\n");
        receiptText.append(String.format("%-5s %-12s %-7s %s\n", "Cant.", "Articulo", "Precio", "Total"));
        receiptText.append("--------------------------------\n");

        // Añadir filas de la tabla
        for (int i = 0; i < tablaVenta.getRowCount(); i++) {
            String cantidad = tablaVenta.getValueAt(i, 2).toString();
            String nombre = tablaVenta.getValueAt(i, 1).toString();
            String precio = tablaVenta.getValueAt(i, 3).toString();
            String total = tablaVenta.getValueAt(i, 4).toString();

            // Dividir el nombre del artículo si es muy largo
            if (nombre.length() > 12) {
                String part1 = nombre.substring(0, 12);
                String part2 = nombre.substring(12);
                receiptText.append(String.format("%-5s %-12s %-7s %s\n", cantidad, part1, precio, total));
                receiptText.append(String.format("%-5s %-12s %-7s %s\n", "", part2, "", ""));
            } else {
                receiptText.append(String.format("%-5s %-12s %-7s %s\n", cantidad, nombre, precio, total));
            }
        }

        receiptText.append("--------------------------------\n");
        receiptText.append(String.format("\nTOTAL: S/%.2f\n\n", totalPago));
        receiptText.append("GRACIAS POR SU COMPRA!\n");

        // Añadir margen inferior
        receiptText.append("\n\n\n");

        return receiptText.toString();
    }

    private String centerText(String text) {
        int width = 32; // Asumiendo un ancho de 32 caracteres para centrar el texto
        int padding = (width - text.length()) / 2;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < padding; i++) {
            sb.append(" ");
        }
        sb.append(text);
        return sb.toString();
    }
}
