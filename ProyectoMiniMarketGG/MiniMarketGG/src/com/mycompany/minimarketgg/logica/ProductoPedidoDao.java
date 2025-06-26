package com.mycompany.minimarketgg.logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mycompany.minimarketgg.persistencia.Conexion;

public class ProductoPedidoDao {
    private Conexion cn;

    public ProductoPedidoDao() {
        this.cn = new Conexion(); // Asegúrate de que la clase Conexion maneje correctamente la conexión a la base de datos
    }

    public boolean registrarProductoPedido(ProductoPedido pp) {
        String sql = "INSERT INTO productos_pedidos (id_producto, id_pedido, cantidad, precio_por_unidad_proveedor, precio_total) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = cn.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, pp.getIdProducto());
            ps.setInt(2, pp.getIdPedido());
            ps.setInt(3, pp.getCantidad());
            ps.setDouble(4, pp.getPrecioPorUnidadProveedor());
            ps.setDouble(5, pp.getPrecioTotal());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error al insertar ProductoPedido: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizarProductoPedido(ProductoPedido pp) {
        String sql = "UPDATE productos_pedidos SET cantidad = ?, precio_por_unidad_proveedor = ?, precio_total = ? WHERE id_producto = ? AND id_pedido = ?";
        try (Connection con = cn.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, pp.getCantidad());
            ps.setDouble(2, pp.getPrecioPorUnidadProveedor());
            ps.setDouble(3, pp.getPrecioTotal());
            ps.setInt(4, pp.getIdProducto());
            ps.setInt(5, pp.getIdPedido());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error al actualizar ProductoPedido: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarProductoPedido(int idProducto, int idPedido) {
        String sql = "DELETE FROM productos_pedidos WHERE id_producto = ? AND id_pedido = ?";
        try (Connection con = cn.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idProducto);
            ps.setInt(2, idPedido);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error al eliminar ProductoPedido: " + e.getMessage());
            return false;
        }
    }

    public List<ProductoPedido> obtenerProductosPedidosPorPedido(int idPedido) {
        List<ProductoPedido> productos = new ArrayList<>();
        String sql = "SELECT * FROM productos_pedidos WHERE id_pedido = ?";
        try (Connection con = cn.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idPedido);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    productos.add(new ProductoPedido(
                            rs.getInt("id_producto"),
                            rs.getInt("id_pedido"),
                            rs.getInt("cantidad"),
                            rs.getDouble("precio_por_unidad_proveedor")));
                }
            }
            return productos;
        } catch (SQLException e) {
            System.err.println("Error al obtener productos del pedido: " + e.getMessage());
            return null;
        }
    }
    
    public ArrayList<ProductoPedido> obtenerProductosPedido(int idPedido) {
        ArrayList<ProductoPedido> productosPedido = new ArrayList<>();
        String sql = "SELECT id_producto, cantidad, precio_por_unidad_proveedor FROM productos_pedidos WHERE id_pedido = ?";
        Connection con = Conexion.getConnection(); // Utiliza la conexión definida en la clase Conexion

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idPedido);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int idProducto = rs.getInt("id_producto");
                    int cantidad = rs.getInt("cantidad");
                    double precioPorUnidad = rs.getDouble("precio_por_unidad_proveedor");

                    ProductoPedido productoPedido = new ProductoPedido(idProducto, idPedido, cantidad, precioPorUnidad); // Inicializar con precio total a 0
                    productoPedido.updatePrecioTotal(); // Actualizar el precio total usando el método definido en la clase
                    productosPedido.add(productoPedido);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener productos del pedido: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return productosPedido;
    }

    // Método para obtener los nombres de los productos en un pedido específico
    public List<String> obtenerNombresProductosPorPedido(int idPedido) {
        List<String> nombresProductos = new ArrayList<>();
        String sql = "SELECT p.nombre FROM productos_pedidos pp " +
                     "JOIN productos p ON pp.id_producto = p.id_producto " +
                     "WHERE pp.id_pedido = ?";
        try (Connection con = cn.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idPedido);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    nombresProductos.add(rs.getString("nombre"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener nombres de productos del pedido: " + e.getMessage());
        }
        return nombresProductos;
    }
    
    public ProductoPedido obtenerProductoPedidoPorIdProductoYIdPedido(int idProducto, int idPedido) {
    String sql = "SELECT * FROM productos_pedidos WHERE id_producto = ? AND id_pedido = ?";
    try (Connection con = cn.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setInt(1, idProducto);
        ps.setInt(2, idPedido);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return new ProductoPedido(
                        rs.getInt("id_producto"),
                        rs.getInt("id_pedido"),
                        rs.getInt("cantidad"),
                        rs.getDouble("precio_por_unidad_proveedor")
                );
            }
        }
    } catch (SQLException e) {
        System.err.println("Error al obtener ProductoPedido: " + e.getMessage());
    }
    return null;
}
    
       public String obtenerNombreProductoPorId(int idProducto) {
        String sql = "SELECT nombre_producto FROM productos WHERE id_producto = ?";
        try (Connection con = cn.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idProducto);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("nombre_producto");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener nombre del producto: " + e.getMessage());
        }
        return null;
    }
    public int obtenerCantidadProductosPedidos() {
        String sql = "SELECT COUNT(*) AS total FROM productos_pedidos";
        int cantidad = 0;

        try (Connection con = cn.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                cantidad = rs.getInt("total");
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener la cantidad de productos pedidos: " + e.getMessage());
        }
        return cantidad;
    }

    public int obtenerCantidadProductosPedidosPorPedido(int idPedido) {
        String sql = "SELECT COUNT(*) AS total FROM productos_pedidos WHERE id_pedido = ?";
        int cantidad = 0;

        try (Connection con = cn.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idPedido);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    cantidad = rs.getInt("total");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener la cantidad de productos pedidos para el pedido " + idPedido + ": " + e.getMessage());
        }
        return cantidad;
    }

    public double calcularTotalPedido(int idPedido) {
        double total = 0.0;
        String sql = "SELECT SUM(precio_total) as total FROM productos_pedidos WHERE id_pedido = ?";
        try (Connection con = cn.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idPedido);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                total = rs.getDouble("total");
            }
        } catch (SQLException e) {
            System.err.println("Error al calcular el total del pedido: " + e.getMessage());
        }
        return total;
    }
}