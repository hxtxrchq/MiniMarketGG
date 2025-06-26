package com.mycompany.minimarketgg.util;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReceiptToPDF {

    private String receiptText;

    public ReceiptToPDF(String receiptText) {
        this.receiptText = receiptText;
    }

    public void generatePDF(String filePath) {
        // Ancho del documento ajustado para 32 caracteres
        float width = 32 * 6; // Aproximadamente 6 puntos por carácter en la fuente Courier de tamaño 6
        Document document = new Document(new Rectangle(width, calculateContentHeight()));

        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filePath));
            writer.setViewerPreferences(PdfWriter.PageLayoutSinglePage);
            document.open();

            Font fontContent = new Font(Font.FontFamily.COURIER, 6, Font.NORMAL); // Usar una fuente monoespaciada más pequeña para ajustarse mejor

            // Dividir el texto del recibo en líneas y agregar cada línea al documento PDF
            String[] lines = formatReceiptText(receiptText).split("\n");
            for (String line : lines) {
                Paragraph paragraph = new Paragraph(line, fontContent);
                paragraph.setAlignment(Paragraph.ALIGN_LEFT);
                document.add(paragraph);
            }

        } catch (DocumentException | FileNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            document.close();
        }

        openPDF(filePath);
    }

    private void openPDF(String filePath) {
        File pdfFile = new File(filePath);
        if (pdfFile.exists()) {
            if (Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().open(pdfFile);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } else {
                System.out.println("Awt Desktop no es soportado!");
            }
        } else {
            System.out.println("El archivo PDF no fue encontrado!");
        }
    }

    private int calculateContentHeight() {
        int headerHeight = 50; // Altura del encabezado
        int footerHeight = 30; // Altura del pie de página
        int lineHeight = 10; // Altura de cada línea de texto

        // Contar las líneas en el texto del recibo
        int lineCount = receiptText.split("\n").length;

        // Calcular la altura total basada en el número de líneas en el texto del recibo
        int contentHeight = lineCount * lineHeight;

        // Altura total del documento
        return headerHeight + contentHeight + footerHeight;
    }

    private String formatReceiptText(String text) {
        StringBuilder formattedText = new StringBuilder();

        String[] lines = text.split("\n");
        for (String line : lines) {
            while (line.length() > 32) {
                formattedText.append(line, 0, 32).append("\n");
                line = line.substring(32);
            }
            formattedText.append(line).append("\n");
        }

        return formattedText.toString();
    }
}