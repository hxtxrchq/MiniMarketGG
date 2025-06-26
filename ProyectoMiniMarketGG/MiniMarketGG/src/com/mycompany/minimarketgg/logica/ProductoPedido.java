package com.mycompany.minimarketgg.logica;

public class ProductoPedido {
    private int idProducto; // Directamente el ID en lugar de la entidad completa
    private int idPedido; // Directamente el ID en lugar de la entidad completa
    private int cantidad;
    private double precioPorUnidadProveedor;
    private double precioTotal; // Puede ser calculado o directamente manipulado

    public ProductoPedido(int idProducto, int idPedido, int cantidad, double precioPorUnidadProveedor) {
        this.idProducto = idProducto;
        this.idPedido = idPedido;
        this.cantidad = cantidad;
        this.precioPorUnidadProveedor = precioPorUnidadProveedor;
        this.precioTotal = cantidad * precioPorUnidadProveedor;
    }

    // Getters y Setters
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
        updatePrecioTotal();
    }

    public double getPrecioPorUnidadProveedor() {
        return precioPorUnidadProveedor;
    }

    public void setPrecioPorUnidadProveedor(double precioPorUnidadProveedor) {
        this.precioPorUnidadProveedor = precioPorUnidadProveedor;
        updatePrecioTotal();
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    // Asumir que el total es manejado por la base de datos o recalculado aquí
    public void updatePrecioTotal() {
        this.precioTotal = this.cantidad * this.precioPorUnidadProveedor;
    }
}
