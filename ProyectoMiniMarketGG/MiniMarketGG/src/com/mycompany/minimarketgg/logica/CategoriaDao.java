package com.mycompany.minimarketgg.logica;
import com.mycompany.minimarketgg.persistencia.Conexion;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CategoriaDao {
    private Conexion cn = new Conexion();
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public boolean RegistrarCategoria(Categoria cat){
        String sql = "INSERT INTO categoria (nombre_categoria, descripcion) VALUES (?, ?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cat.getNombre());
            ps.setString(2, cat.getDescripcion());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }
    }
    
    public ArrayList<Categoria> obtenerCategorias() {
        ArrayList<Categoria> categorias = new ArrayList<>();
        String sql = "SELECT * FROM categoria";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_categoria");
                String nombre = rs.getString("nombre_categoria");
                String descripcion = rs.getString("descripcion");
                categorias.add(new Categoria(id, nombre, descripcion));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener categor�as: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar conexi�n: " + e.getMessage());
            }
        }
        return categorias;
    }
    
    public Categoria obtenerCategoriaPorId(int idCategoria) {
        String sql = "SELECT * FROM categoria WHERE id_categoria = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idCategoria);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Categoria(
                    rs.getInt("id_categoria"),
                    rs.getString("nombre_categoria"),
                    rs.getString("descripcion")
                );
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener categor�a por ID: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar conexi�n: " + e.getMessage());
            }
        }
        return null;
    }
    
    public boolean existeCategoria(String nombreCategoria) {
        String sql = "SELECT COUNT(*) FROM categoria WHERE nombre_categoria = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, nombreCategoria);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al verificar la existencia de la categor�a: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar conexi�n: " + e.getMessage());
            }
        }
        return false;
    }
    
    public Categoria obtenerCategoriaPorNombre(String nombreCategoria) {
        String sql = "SELECT * FROM categoria WHERE nombre_categoria = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, nombreCategoria);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Categoria(
                    rs.getInt("id_categoria"),
                    rs.getString("nombre_categoria"),
                    rs.getString("descripcion")
                );
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener categor�a por nombre: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar conexi�n: " + e.getMessage());
            }
        }
        return null;
    }
    
    public boolean actualizarCategoria(Categoria categoria) {
    String sql = "UPDATE categoria SET nombre_categoria = ?, descripcion = ? WHERE id_categoria = ?";
    try (Connection con = cn.getConnection();
         PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setString(1, categoria.getNombre());
        ps.setString(2, categoria.getDescripcion());
        ps.setInt(3, categoria.getId());  // Aseg�rate de que esto corresponda al ID de la categor�a

        int updated = ps.executeUpdate();
        return updated > 0;
    } catch (SQLException e) {
        System.err.println("Error al actualizar categor�a: " + e.getMessage());
        return false;
    }
}

    
    public ArrayList<String> obtenerNombresCategorias() {
    ArrayList<String> nombresCategorias = new ArrayList<>();
    String sql = "SELECT nombre_categoria FROM categoria";
    try {
        con = cn.getConnection();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        // Recorrer los resultados y obtener solo los nombres de las categor as
        while (rs.next()) {
            String nombre = rs.getString("nombre_categoria");
            nombresCategorias.add(nombre);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al obtener nombres de categor as: " + e.getMessage());
    } finally {
        // Cerrar recursos
        try {
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar conexi n: " + e.getMessage());
        }
    }
    return nombresCategorias; // Devolver la lista de nombres de categor as
    }
    
    public int obtenerCantidadCategorias() {
        int cantidad = 0;
        String sql = "SELECT COUNT(*) AS total FROM categoria"; // Aseg�rate de que la tabla se llama 'categorias'
        try (Connection con = cn.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                cantidad = rs.getInt("total");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener la cantidad de categor�as: " + e.getMessage(), "Error en Base de Datos", JOptionPane.ERROR_MESSAGE);
            System.err.println("Error al obtener la cantidad de categor�as: " + e.getMessage());
        }
        return cantidad;
    }


// M�todo para verificar si una categor�a est� asociada a alg�n producto
    public boolean categoriaAsociadaProducto(int idCategoria) {
        String sql = "SELECT COUNT(*) AS total FROM productos WHERE id_categoria = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idCategoria);
            rs = ps.executeQuery();
            if (rs.next()) {
                int total = rs.getInt("total");
                return total > 0;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al verificar la asociaci�n de la categor�a con productos: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar conexi�n: " + e.getMessage());
            }
        }
        return false;
    }
    
    // M�todo para eliminar una categor�a si no est� asociada a productos
    public boolean eliminarCategoria(int idCategoria) {
        if (!categoriaAsociadaProducto(idCategoria)) {
            String sql = "DELETE FROM categoria WHERE id_categoria = ?";
            try {
                con = cn.getConnection();
                ps = con.prepareStatement(sql);
                ps.setInt(1, idCategoria);
                int rowsDeleted = ps.executeUpdate();
                return rowsDeleted > 0;
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al eliminar la categor�a: " + e.getMessage());
            } finally {
                try {
                    con.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Error al cerrar conexi�n: " + e.getMessage());
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se puede eliminar la categor�a porque est� asociada a productos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
}