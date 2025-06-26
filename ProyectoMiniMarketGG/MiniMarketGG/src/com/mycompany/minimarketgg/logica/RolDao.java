/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.minimarketgg.logica;

import com.mycompany.minimarketgg.persistencia.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class RolDao {
    private Conexion cn = new Conexion();
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;

    public ArrayList<Rol> obtenerRoles() {
        ArrayList<Rol> roles = new ArrayList<>();
        String sql = "SELECT * FROM roles";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_rol");
                String tipoRol = rs.getString("tipo_rol");
                roles.add(new Rol(id, tipoRol));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener roles: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar conexión: " + e.getMessage());
            }
        }
        return roles;
    }

    public ArrayList<String> obtenerNombresRoles() {
        ArrayList<String> nombresRoles = new ArrayList<>();
        String sql = "SELECT tipo_rol FROM roles";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                nombresRoles.add(rs.getString("tipo_rol"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener nombres de roles: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar conexión: " + e.getMessage());
            }
        }
        return nombresRoles;
    }
    
    public int obtenerIdPorNombre(String nombreRol) {
    String sql = "SELECT id_rol FROM roles WHERE tipo_rol = ?";
    try {
        con = cn.getConnection();
        ps = con.prepareStatement(sql);
        ps.setString(1, nombreRol);
        rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt("id_rol");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al obtener ID de rol: " + e.getMessage());
    } finally {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar conexión: " + e.getMessage());
        }
    }
    return -1; // Retorna -1 si el rol no se encuentra
}

}


