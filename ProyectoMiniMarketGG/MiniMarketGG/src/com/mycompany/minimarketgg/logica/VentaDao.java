package com.mycompany.minimarketgg.logica;

import com.mycompany.minimarketgg.persistencia.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VentaDao {
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private Conexion cn = new Conexion();

    public void guardarVenta(Venta venta) {
        String sql = "INSERT INTO ventas (numero_boleta, metodo_pago, total, fecha) VALUES (?, ?, ?, ?)";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, venta.getNumeroBoleta());
            ps.setString(2, venta.getMetodoPago());
            ps.setDouble(3, venta.getTotal());
            ps.setTimestamp(4, venta.getFecha());
            ps.executeUpdate();

            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                venta.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }

    public List<Venta> obtenerHistorialVentas() {
        List<Venta> ventas = new ArrayList<>();
        String sql = "SELECT * FROM ventas";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int numeroBoleta = rs.getInt("numero_boleta");
                String metodoPago = rs.getString("metodo_pago");
                double total = rs.getDouble("total");
                Timestamp fecha = rs.getTimestamp("fecha");

                Venta venta = new Venta(numeroBoleta, metodoPago, total, fecha);
                venta.setId(id);
                ventas.add(venta);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }

        return ventas;
    }

    public void limpiarHistorialVentas() {
        String sql = "DELETE FROM ventas";

        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }

    public static int getNextTicketNumber() {
        String sql = "SELECT MAX(numero_boleta) AS max_boleta FROM ventas";
        int nextTicketNumber = 1;

        try (Connection con = new Conexion().getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                nextTicketNumber = rs.getInt("max_boleta") + 1;
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }

        return nextTicketNumber;
    }
}
