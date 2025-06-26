package com.mycompany.minimarketgg.util;

import javax.swing.JFrame;
import javax.imageio.ImageIO;
import java.awt.Image;
import java.io.IOException;

public class IconoUtil {

    private static Image icono;

    static {
        try {
            icono = ImageIO.read(IconoUtil.class.getResource("/com/mycompany/minimarketgg/imagenes/Alegremind.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void establecerIcono(JFrame frame) {
        frame.setIconImage(icono);
    }
}