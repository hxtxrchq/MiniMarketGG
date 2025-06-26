package com.mycompany.minimarketgg.logica;

public class Pedido {
    private int id;
    private String fechaPedido; // Cambiar Date a String
    private int idProveedor;
    private double totalPedido;

    // Constructor sin parámetros
    public Pedido() {
    }

    // Constructor con todos los parámetros
    public Pedido(int id, String fechaPedido, int idProveedor, double totalPedido) {
        this.id = id;
        this.fechaPedido = fechaPedido;
        this.idProveedor = idProveedor;
        this.totalPedido = totalPedido;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(String fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public double getTotalPedido() {
        return totalPedido;
    }

    public void setTotalPedido(double totalPedido) {
        this.totalPedido = totalPedido;
    }

    // Método toString para representar el objeto Pedido como String
    @Override
    public String toString() {
        return "Pedido{" +
               "id=" + id +
               ", fechaPedido='" + fechaPedido + '\'' +
               ", idProveedor=" + idProveedor +
               ", totalPedido=" + totalPedido +
               '}';
    }
}