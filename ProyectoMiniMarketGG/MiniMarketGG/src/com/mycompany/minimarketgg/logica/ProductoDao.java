package com.mycompany.minimarketgg.logica;

import com.mycompany.minimarketgg.persistencia.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;
import java.util.List;

public class ProductoDao {
    private Conexion cn = new Conexion();
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public ProductoDao() {
        
    }
        
    public ProductoDao(Conexion cn) {
        this.cn = cn;
    }
    
    public boolean RegistrarProducto(Producto prod) {
    String sql = "INSERT INTO productos (nombre_producto, descripcion, precio, cantidad_stock, id_categoria, id_proveedor) VALUES (?, ?, ?, ?, ?, ?)";
    try (Connection con = cn.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setString(1, prod.getNombre());
        ps.setString(2, prod.getDescripcion());
        ps.setDouble(3, prod.getPrecio());
        ps.setInt(4, prod.getStock());
        ps.setInt(5, prod.getIdCategoria());  // Usando el ID de la categoría directamente
        ps.setInt(6, prod.getIdProveedor());  // Usando el ID del proveedor directamente
        ps.execute();
        return true;
    } catch (SQLException e) {
        System.err.println("Error al registrar producto: " + e.getMessage());
        return false;
      }
    }
    
    public ArrayList<Producto> obtenerProductos() {
    ArrayList<Producto> productos = new ArrayList<>();
    String sql = "SELECT * FROM productos";
    try (Connection con = cn.getConnection();
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {
        while (rs.next()) {
            productos.add(extractProductoFromResultSet(rs));
        }
    } catch (SQLException e) {
        // Considera el uso de logging aquí en vez de mostrar un JOptionPane
        System.err.println("Error al obtener productos: " + e.getMessage());
    }
    return productos;
    }
    
    private Producto extractProductoFromResultSet(ResultSet rs) throws SQLException {
    int itemid = rs.getInt("id_producto");
    String nombre = rs.getString("nombre_producto");
    int id_proveedor = rs.getInt("id_proveedor");
    double precio = rs.getDouble("precio");
    int stock = rs.getInt("cantidad_stock");
    int id_categoria = rs.getInt("id_categoria");
    String descripcion = rs.getString("descripcion");
    
    
    return new Producto(itemid, nombre, id_categoria, id_proveedor, precio, stock, descripcion);
    }
    
    public Producto obtenerProductoPorNombre(String nombreProducto) {
    String sql = "SELECT * FROM productos WHERE nombre_producto = ?";
    try (Connection con = cn.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setString(1, nombreProducto);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return extractProductoFromResultSet(rs);
            }
        }
    } catch (SQLException e) {
        System.err.println("Error al obtener producto por nombre: " + e.getMessage());
    }
    return null;
    }
    
    public boolean eliminarProductoPorNombre(String nombreProducto) {
    String sql = "DELETE FROM productos WHERE nombre_producto = ?";
    try (Connection con = cn.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setString(1, nombreProducto);
        return ps.executeUpdate() > 0;
    } catch (SQLException e) {
        System.err.println("Error al eliminar producto: " + e.getMessage());
        return false;
        }
    }
    
    public boolean actualizarProducto(Producto producto) {
    String sql = "UPDATE productos SET nombre_producto = ?, descripcion = ?, precio = ?, cantidad_stock = ?, id_categoria = ?, id_proveedor = ? WHERE id_producto = ?";
    try (Connection con = cn.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setString(1, producto.getNombre());
        ps.setString(2, producto.getDescripcion());
        ps.setDouble(3, producto.getPrecio());
        ps.setInt(4, producto.getStock());
        ps.setInt(5, producto.getIdCategoria());
        ps.setInt(6, producto.getIdProveedor());
        ps.setInt(7, producto.getIdProducto());  // Asegúrate de que esto corresponde al ID del producto

        int updated = ps.executeUpdate();
        return updated > 0;
    } catch (SQLException e) {
        System.err.println("Error al actualizar producto: " + e.getMessage());
        return false;
    }
    }
    
    public boolean actualizarStockProducto(int idProducto, int nuevoStock) {
    String sql = "UPDATE productos SET cantidad_stock = ? WHERE id_producto = ?";
    try (Connection con = cn.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setInt(1, nuevoStock);
        ps.setInt(2, idProducto);
        int filasAfectadas = ps.executeUpdate();
        return filasAfectadas > 0;
    } catch (SQLException e) {
        System.err.println("Error al actualizar el stock del producto: " + e.getMessage());
        return false;
    }
}
    
    public ArrayList<String> obtenerNombresProductos() {
    ArrayList<String> nombresProductos = new ArrayList<>();
    String sql = "SELECT nombre_producto FROM productos";
    try (Connection con = cn.getConnection();
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {
        while (rs.next()) {
            nombresProductos.add(rs.getString("nombre_producto"));
        }
    } catch (SQLException e) {
        System.err.println("Error al obtener nombres de productos: " + e.getMessage());
    }
    return nombresProductos;
    }
    
    public int obtenerCantidadProductos() {
    try (Connection con = cn.getConnection();
         Statement stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT COUNT(*) AS total FROM productos")) {
        if (rs.next()) {
            return rs.getInt("total");
        }
    } catch (SQLException e) {
        System.err.println("Error al obtener el total de productos: " + e.getMessage());
        return 0;
    }
    return 0;
    }
    
    public Producto obtenerProductoPorId(int idProducto) {
    String sql = "SELECT * FROM productos WHERE id_producto = ?";
    try (Connection con = cn.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setInt(1, idProducto);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return extractProductoFromResultSet(rs);
            }
        }
    } catch (SQLException e) {
        System.err.println("Error al obtener producto por ID: " + e.getMessage());
    }
    return null;
    }
    
    public int obtenerIdPorNombre(String nombreProducto) {
        Connection con = Conexion.getConnection();
        String sql = "SELECT id_producto FROM productos WHERE nombre_producto = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, nombreProducto);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("id_producto");
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el ID del producto: " + e.getMessage());
        } finally {
            // Asegúrate de cerrar los recursos abiertos
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException ex) {
                System.out.println("Error al cerrar los recursos: " + ex.getMessage());
            }
        }
        return -1;  // Retorna -1 si el producto no se encuentra o hay un error
    }
    
    public double obtenerPrecioProveedorPorNombre(String nombreProducto) {
        String sql = "SELECT precio_proveedor FROM Productos WHERE nombre_producto = ?";
        try (Connection con = Conexion.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nombreProducto);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getDouble("precio_proveedor");
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener el precio del proveedor: " + e.getMessage());
        }
        return -1;
    }
    
    public ArrayList<Producto> buscarProductosPorNombre(String nombreProducto) {
        ArrayList<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM productos WHERE nombre_producto LIKE ?";
        try (Connection con = cn.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nombreProducto + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    productos.add(extractProductoFromResultSet(rs));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al buscar productos por nombre: " + e.getMessage());
        }
        return productos;
    }

    public List<String> obtenerNombresProductosPorProveedor(int idProveedor) {
        List<String> nombresProductos = new ArrayList<>();
        String sql = "SELECT nombre_producto FROM productos WHERE id_proveedor = ?";
        try (Connection con = cn.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idProveedor);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    nombresProductos.add(rs.getString("nombre_producto"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener nombres de productos por proveedor: " + e.getMessage());
        }
        return nombresProductos;
    }
}