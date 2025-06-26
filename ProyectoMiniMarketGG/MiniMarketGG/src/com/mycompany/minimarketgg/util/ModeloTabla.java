package com.mycompany.minimarketgg.util;

import javax.swing.table.DefaultTableModel;

public class ModeloTabla extends DefaultTableModel {

    public ModeloTabla(Object[][] datos, String[] titulos) {
        super(datos, titulos);  // Directamente pasa los datos y titulos al constructor de la superclase
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;  // Hace todas las celdas no editables
    }
}