package com.mycompany.minimarketgg.logica;

import java.sql.Timestamp;

public class Venta {
    private int id;
    private int numeroBoleta;
    private String metodoPago;
    private double total;
    private Timestamp fecha;

    public Venta(int numeroBoleta, String metodoPago, double total, Timestamp fecha) {
        this.numeroBoleta = numeroBoleta;
        this.metodoPago = metodoPago;
        this.total = total;
        this.fecha = fecha;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumeroBoleta() {
        return numeroBoleta;
    }

    public void setNumeroBoleta(int numeroBoleta) {
        this.numeroBoleta = numeroBoleta;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }
}
