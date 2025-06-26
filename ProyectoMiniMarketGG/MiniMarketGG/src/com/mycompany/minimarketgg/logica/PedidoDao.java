package com.mycompany.minimarketgg.logica;

import com.mycompany.minimarketgg.persistencia.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PedidoDao {
    private Conexion cn = new Conexion(); // Asumiendo que tienes una clase de conexión

    // Método para agregar un nuevo pedido
    public boolean agregarPedido(Pedido pedido) {
        String sql = "INSERT INTO pedido (fecha_pedido, id_proveedor, total_pedido) VALUES (?, ?, ?)";
        try (Connection con = cn.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, pedido.getFechaPedido()); // Cambiar setDate a setString
            ps.setInt(2, pedido.getIdProveedor());
            ps.setDouble(3, pedido.getTotalPedido());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar pedido: " + e.getMessage());
            return false;
        }
    }

    // Método para obtener todos los pedidos
    public ArrayList<Pedido> obtenerPedidos() {
        ArrayList<Pedido> pedidos = new ArrayList<>();
        String sql = "SELECT * FROM pedido";
        try (Connection con = cn.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                pedidos.add(new Pedido(
                    rs.getInt("id_pedido"),
                    rs.getString("fecha_pedido"), // Cambiar getDate a getString
                    rs.getInt("id_proveedor"),
                    rs.getDouble("total_pedido")
                ));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener pedidos: " + e.getMessage());
        }
        return pedidos;
    }

    // Método para actualizar un pedido
    public boolean actualizarPedido(Pedido pedido) {
        String sql = "UPDATE pedido SET fecha_pedido = ?, id_proveedor = ?, total_pedido = ? WHERE id_pedido = ?";
        try (Connection con = cn.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, pedido.getFechaPedido()); // Cambiar setDate a setString
            ps.setInt(2, pedido.getIdProveedor());
            ps.setDouble(3, pedido.getTotalPedido());
            ps.setInt(4, pedido.getId());
            int updateCount = ps.executeUpdate();
            return updateCount > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar pedido: " + e.getMessage());
            return false;
        }
    }

    // Método para eliminar un pedido
    public boolean eliminarPedido(int idPedido) {
        String sql = "DELETE FROM pedido WHERE id_pedido = ?";
        try (Connection con = cn.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idPedido);
            int deleteCount = ps.executeUpdate();
            return deleteCount > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar pedido: " + e.getMessage());
            return false;
        }
    }

    // Método para obtener un pedido por ID
    public Pedido obtenerPedidoPorId(int id) {
        String sql = "SELECT * FROM pedido WHERE id_pedido = ?";
        try (Connection con = cn.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Pedido(
                        rs.getInt("id_pedido"),
                        rs.getString("fecha_pedido"), // Cambiar getDate a getString
                        rs.getInt("id_proveedor"),
                        rs.getDouble("total_pedido")
                    );
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener el pedido: " + e.getMessage());
        }
        return null;  // No se encontró el pedido
    }

    // Método para verificar si un pedido existe
    public boolean existePedido(int id) {
        String sql = "SELECT COUNT(*) FROM pedido WHERE id_pedido = ?";
        try (Connection con = cn.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;  // Devuelve true si el conteo es mayor que cero
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al verificar la existencia del pedido: " + e.getMessage());
        }
        return false;  // Por defecto, devuelve false si algo falla
    }

    // Método para obtener la cantidad de pedidos
    public int obtenerCantidadPedidos() {
        int cantidad = 0;
        String sql = "SELECT COUNT(*) AS total FROM pedido"; // Asegúrate de que la tabla se llama 'pedido'
        try (Connection con = cn.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                cantidad = rs.getInt("total");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener la cantidad de pedidos: " + e.getMessage(), "Error en Base de Datos", JOptionPane.ERROR_MESSAGE);
            System.err.println("Error al obtener la cantidad de pedidos: " + e.getMessage());
        }
        return cantidad;
    }

    // Método para actualizar el total del pedido
    public boolean actualizarTotalPedido(int idPedido, double nuevoTotal) {
        String sql = "UPDATE pedido SET total_pedido = ? WHERE id_pedido = ?";
        try (Connection con = cn.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setDouble(1, nuevoTotal);
            ps.setInt(2, idPedido);
            int affectedRows = ps.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.err.println("Error al actualizar el total del pedido: " + e.getMessage());
            return false;
        }
    }
}