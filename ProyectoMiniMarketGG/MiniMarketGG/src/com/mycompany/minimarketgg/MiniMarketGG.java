package com.mycompany.minimarketgg;

import com.mycompany.minimarketgg.igu.Login;
import com.mycompany.minimarketgg.util.PantallaUtil;

public class MiniMarketGG {

    public static void main(String[] args) {
        // Crear instancia del login (enviando el ancho y alto de pantalla)
        Login login = new Login(PantallaUtil.obtenerAnchoPantalla(), PantallaUtil.obtenerAltoPantalla());
        // Configurar propiedades del login
        login.setResizable(false);
        login.setLocationRelativeTo(null);
        login.setVisible(true);
    }
}