package com.mycompany.minimarketgg.logica;

import com.mycompany.minimarketgg.persistencia.Conexion;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProveedorDao {
    private Conexion cn = new Conexion();
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public boolean RegistrarProveedor(Proveedor prov){
        String sql = "INSERT INTO proveedores (id_proveedor, nombre_proveedor, telefono, correo) VALUES (?, ?, ?, ?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, prov.getId());
            ps.setString(2, prov.getNombre());
            ps.setString(3, prov.getTelefono());
            ps.setString(4, prov.getCorreo());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        } finally{
            try {
                con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }
    }
    public boolean actualizarProveedor(Proveedor proveedor) {
    String sql = "UPDATE proveedores SET nombre_proveedor = ?, telefono = ?, correo = ? WHERE id_proveedor = ?";
    try (Connection con = cn.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setString(1, proveedor.getNombre());
        ps.setString(2, proveedor.getTelefono());
        ps.setString(3, proveedor.getCorreo());
        ps.setInt(4, proveedor.getId());  // Asegúrate de que esto corresponda al ID del proveedor

        int updated = ps.executeUpdate();
        return updated > 0;
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al actualizar proveedor: " + e.getMessage());
        System.err.println("Error al actualizar proveedor: " + e.getMessage());
        return false;
    }
}
    public ArrayList<Proveedor> obtenerProveedores() {
        ArrayList<Proveedor> proveedores = new ArrayList<>();
        String sql = "SELECT * FROM proveedores";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_proveedor");
                String nombre = rs.getString("nombre_proveedor");
                String telefono = rs.getString("telefono");
                String correo = rs.getString("correo");
                Proveedor proveedor = new Proveedor(id, nombre, telefono, correo);
                proveedores.add(proveedor);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener proveedores: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar conexión: " + e.getMessage());
            }
        }
        return proveedores;
    }
    
    public ArrayList<String> obtenerNombresProveedores() {
        ArrayList<String> nombresProveedores = new ArrayList<>();
        String sql = "SELECT nombre_proveedor FROM proveedores";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String nombre = rs.getString("nombre_proveedor");
                nombresProveedores.add(nombre);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener nombres de proveedores: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar conexión: " + e.getMessage());
            }
        }
        return nombresProveedores;
    }
    
    public Proveedor obtenerProveedorPorId(int idProveedor) {
        String sql = "SELECT * FROM proveedores WHERE id_proveedor = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idProveedor);
            rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id_proveedor");
                String nombre = rs.getString("nombre_proveedor");
                String telefono = rs.getString("telefono");
                String correo = rs.getString("correo");
                return new Proveedor(id, nombre, telefono, correo);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener proveedor por ID: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar conexión: " + e.getMessage());
            }
        }
        return null;
    }
    
    public boolean existeProveedor(String nombreProveedor) {
    String sql = "SELECT COUNT(*) FROM proveedores WHERE nombre_proveedor = ?";
    try {
        con = cn.getConnection();
        ps = con.prepareStatement(sql);
        ps.setString(1, nombreProveedor);
        rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt(1) > 0;  // Verifica si el conteo es mayor que cero
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al verificar la existencia del proveedor: " + e.getMessage());
    } finally {
        try {
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar conexión: " + e.getMessage());
        }
    }
    return false;
    }
    
    public Proveedor obtenerProveedorPorNombre(String nombreProveedor) {
    Proveedor proveedor = null;
    String sql = "SELECT * FROM proveedores WHERE nombre_proveedor = ?";
    try {
        con = cn.getConnection();
        ps = con.prepareStatement(sql);
        ps.setString(1, nombreProveedor);
        rs = ps.executeQuery();
        if (rs.next()) {
            int id = rs.getInt("id_proveedor");
            String nombre = rs.getString("nombre_proveedor");
            String telefono = rs.getString("telefono");
            String correo = rs.getString("correo");
            proveedor = new Proveedor(id, nombre, telefono, correo);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al obtener proveedor por nombre: " + e.getMessage());
    } finally {
        try {
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar conexión: " + e.getMessage());
        }
    }
    return proveedor;
    }
    
    public int obtenerCantidadProveedores() {
        int cantidad = 0; // Variable para almacenar la cantidad de proveedores
        String sql = "SELECT COUNT(*) AS total FROM proveedores"; // Consulta SQL que cuenta los proveedores
        try (Connection con = cn.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                cantidad = rs.getInt("total"); // Obtiene el total de la consulta
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener la cantidad de proveedores: " + e.getMessage(), "Error en Base de Datos", JOptionPane.ERROR_MESSAGE);
            System.err.println("Error al obtener la cantidad de proveedores: " + e.getMessage());
        }
        return cantidad; // Devuelve la cantidad de proveedores
    }

 public boolean proveedorAsociadoProducto(int idProveedor) {
        String sql = "SELECT COUNT(*) AS total FROM productos WHERE id_proveedor = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idProveedor);
            rs = ps.executeQuery();
            if (rs.next()) {
                int total = rs.getInt("total");
                return total > 0;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al verificar la asociación del proveedor con productos: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar conexión: " + e.getMessage());
            }
        }
        return false;
    }
    
    // Método para eliminar un proveedor si no está asociado a productos
    public boolean eliminarProveedor(int idProveedor) {
        if (!proveedorAsociadoProducto(idProveedor)) {
            String sql = "DELETE FROM proveedores WHERE id_proveedor = ?";
            try {
                con = cn.getConnection();
                ps = con.prepareStatement(sql);
                ps.setInt(1, idProveedor);
                int rowsDeleted = ps.executeUpdate();
                return rowsDeleted > 0;
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al eliminar el proveedor: " + e.getMessage());
            } finally {
                try {
                    con.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error al cerrar conexión: " + e.getMessage());
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se puede eliminar el proveedor porque está asociado a productos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    public String obtenerNombreProveedorPorId(int idProveedor) {
        String sql = "SELECT nombre_proveedor FROM proveedores WHERE id_proveedor = ?";
        try (Connection con = cn.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idProveedor);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("nombre_proveedor");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener nombre del proveedor: " + e.getMessage());
        }
        return null;
    }  
     
}