package com.mycompany.minimarketgg.logica;

public class Producto {
	
	private int id_producto;
	private String nombre;
	private int id_categoria;
	private int id_proveedor;
	private double precio;
	private int stock;
        private String descripcion;
    public String getIdProducto;
	
	 // Constructor vacío
    public Producto() {
    }

    // Constructor con todos los atributos
    public Producto(int itemid, String nombre, int id_categoria, int id_proveedor , double precio, int stock, String descripcion) {
        this.id_producto = itemid;
        this.nombre = nombre;
        this.id_proveedor = id_proveedor;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.id_categoria = id_categoria;
    }

    // Getters y setters
    public int getIdProducto() {
        return id_producto;
    }

    public void setIdProducto(int itemid) {
        this.id_producto = itemid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdCategoria() {
        return id_categoria;
    }

    public void setIdCategoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public int getIdProveedor() {
        return id_proveedor;
    }

    public void setIdProveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Producto{" + "id_producto=" + id_producto + ", nombre=" + nombre + ", id_categoria=" + id_categoria + ", id_proveedor=" + id_proveedor + ", precio=" + precio + ", stock=" + stock + ", descripcion=" + descripcion + '}';
    }
}