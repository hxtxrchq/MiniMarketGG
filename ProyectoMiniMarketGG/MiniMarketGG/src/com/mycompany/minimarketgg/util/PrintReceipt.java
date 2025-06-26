package com.mycompany.minimarketgg.util;

import javax.print.*;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class PrintReceipt {

    public static void printText(String text) {
        try {
            InputStream is = new ByteArrayInputStream(text.getBytes());
            DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
            PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();

            PrintService[] printServices = PrintServiceLookup.lookupPrintServices(flavor, pras);
            if (printServices.length > 0) {
                PrintService printService = ServiceUI.printDialog(null, 200, 200, printServices, PrintServiceLookup.lookupDefaultPrintService(), flavor, pras);
                if (printService != null) {
                    DocPrintJob job = printService.createPrintJob();
                    Doc doc = new SimpleDoc(is, flavor, null);
                    job.print(doc, pras);
                } else {
                    System.out.println("Impresión cancelada.");
                }
            } else {
                System.err.println("No se encontraron impresoras compatibles.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
