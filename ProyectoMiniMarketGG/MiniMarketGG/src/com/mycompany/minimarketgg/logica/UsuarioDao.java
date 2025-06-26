package com.mycompany.minimarketgg.logica;

import com.mycompany.minimarketgg.persistencia.Conexion;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();

    public Usuario log(String nombreUsuario, String pass) {
        Usuario usuario = new Usuario();
        String sql = "SELECT u.*, r.tipo_rol FROM usuarios u INNER JOIN roles r ON u.id_rol = r.id_rol WHERE u.nombre_usuario = ? AND u.pass = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, nombreUsuario);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            if (rs.next()) {
                usuario.setId_usuario(rs.getInt("id_usuario"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setNombre_usuario(rs.getString("nombre_usuario"));
                usuario.setPass(rs.getString("pass"));
                Rol rol = new Rol();
                rol.setId(rs.getInt("id_rol"));
                rol.setTipoRol(rs.getString("tipo_rol"));
                usuario.setRol(rol);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return usuario;
    }

    public boolean registrarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nombre, nombre_usuario, pass, id_rol) VALUES (?, ?, ?, ?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getNombre_usuario());
            ps.setString(3, usuario.getPass());
            ps.setInt(4, usuario.getRol().getId());
            ps.executeUpdate();

            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                usuario.setId_usuario(rs.getInt(1));
            }
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar usuario: " + e.getMessage());
            return false;
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar conexión: " + e.getMessage());
            }
        }
    }

    public List<Usuario> listarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT u.id_usuario, u.nombre, u.nombre_usuario, u.pass, r.id_rol, r.tipo_rol " +
                     "FROM usuarios u " +
                     "INNER JOIN roles r ON u.id_rol = r.id_rol";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_usuario");
                String nombre = rs.getString("nombre");
                String nombre_usuario = rs.getString("nombre_usuario");
                String pass = rs.getString("pass");
                int id_rol = rs.getInt("id_rol");
                String tipo_rol = rs.getString("tipo_rol");
                Rol rol = new Rol(id_rol, tipo_rol);
                usuarios.add(new Usuario(id, nombre, nombre_usuario, pass, rol));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener usuarios: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar conexión: " + e.getMessage());
            }
        }
        return usuarios;
    }

    public boolean actualizarUsuario(Usuario usuario) {
        String sql = "UPDATE usuarios SET nombre = ?, nombre_usuario = ?, pass = ?, id_rol = ? WHERE id_usuario = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getNombre_usuario());
            ps.setString(3, usuario.getPass());
            ps.setInt(4, usuario.getRol().getId());
            ps.setInt(5, usuario.getId_usuario());
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar usuario: " + e.getMessage());
            return false;
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar conexión: " + e.getMessage());
            }
        }
    }

    public Usuario obtenerUsuarioPorId(int idUsuario) {
        Usuario usuario = null;
        String sql = "SELECT u.id_usuario, u.nombre, u.nombre_usuario, u.pass, r.id_rol, r.tipo_rol " +
                     "FROM usuarios u " +
                     "INNER JOIN roles r ON u.id_rol = r.id_rol " +
                     "WHERE u.id_usuario = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idUsuario);
            rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id_usuario");
                String nombre = rs.getString("nombre");
                String nombre_usuario = rs.getString("nombre_usuario");
                String pass = rs.getString("pass");
                int id_rol = rs.getInt("id_rol");
                String tipo_rol = rs.getString("tipo_rol");
                Rol rol = new Rol(id_rol, tipo_rol);
                usuario = new Usuario(id, nombre, nombre_usuario, pass, rol);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener usuario: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar conexión: " + e.getMessage());
            }
        }
        return usuario;
    }

    public boolean eliminarUsuario(int idUsuario) {
        String sql = "DELETE FROM usuarios WHERE id_usuario = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idUsuario);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar usuario: " + e.getMessage());
            return false;
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar conexión: " + e.getMessage());
            }
        }
    }
}
