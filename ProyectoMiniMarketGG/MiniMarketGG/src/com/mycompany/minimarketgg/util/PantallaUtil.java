package com.mycompany.minimarketgg.util;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * Utilidad para manejar las dimensiones de la pantalla.
 * Proporciona métodos para obtener el tamaño completo de la pantalla principal.
 */
public class PantallaUtil {

    /**
     * Obtiene el tamaño actual de la pantalla.
     * @return Dimension que representa el tamaño de la pantalla.
     */
    public static Dimension obtenerTamanoPantalla() {
        return Toolkit.getDefaultToolkit().getScreenSize();
    }

    /**
     * Obtiene el ancho actual de la pantalla.
     * @return int que representa el ancho de la pantalla.
     */
    public static int obtenerAnchoPantalla() {
        return obtenerTamanoPantalla().width;
    }

    /**
     * Obtiene el alto actual de la pantalla.
     * @return int que representa el alto de la pantalla.
     */
    public static int obtenerAltoPantalla() {
        return obtenerTamanoPantalla().height;
    }
}