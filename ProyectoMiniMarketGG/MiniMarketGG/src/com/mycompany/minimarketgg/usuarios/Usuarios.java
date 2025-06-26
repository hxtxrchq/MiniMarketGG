/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.minimarketgg.usuarios;

import com.mycompany.minimarketgg.igu.Menu;
import com.mycompany.minimarketgg.logica.Usuario;
import com.mycompany.minimarketgg.logica.UsuarioDao;
import com.mycompany.minimarketgg.logica.RolDao;
import com.mycompany.minimarketgg.logica.Rol;
import com.mycompany.minimarketgg.util.PantallaUtil;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Usuarios extends javax.swing.JFrame {

    private DefaultTableModel modeloTabla;
    private int idUsuarioEditando = -1;
    private Usuario usuario; // Atributo para almacenar el usuario

    // Constructor que acepta un objeto Usuario
    public Usuarios(Usuario usuario) {
        this.usuario = usuario; // Inicializa el usuario
        initComponents();
        modeloTabla = (DefaultTableModel) TablaUsuarios.getModel();
        cargarUsuarios();
        llenarComboBoxRoles();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaUsuarios = new javax.swing.JTable();
        txtNombre = new javax.swing.JTextField();
        txtNombreUsuario = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();
        btnRegistrarUsuario = new javax.swing.JButton();
        comboBoxRol = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnEditarUsuario = new javax.swing.JButton();
        btnEliminarUsuario = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Usuario", "Rol"
            }
        ));
        jScrollPane1.setViewportView(TablaUsuarios);

        btnRegistrarUsuario.setText("Registrar Usuario");
        btnRegistrarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarUsuarioActionPerformed(evt);
            }
        });

        comboBoxRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxRolActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("ADMINISTRAR USUARIOS");

        jLabel2.setText("NOMBRE");

        jLabel3.setText("NOMBRE DE USUARIO");

        jLabel4.setText("CONTRASEÑA");

        jLabel5.setText("ROL");

        btnEditarUsuario.setText("Editar Usuario");
        btnEditarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarUsuarioActionPerformed(evt);
            }
        });

        btnEliminarUsuario.setText("Eliminar Usuario");
        btnEliminarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarUsuarioActionPerformed(evt);
            }
        });

        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/minimarketgg/imagenes/back_icon.png"))); // NOI18N
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboBoxRol, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNombre)
                    .addComponent(txtNombreUsuario)
                    .addComponent(txtPassword)
                    .addComponent(btnRegistrarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(btnEditarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(93, 93, 93)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 925, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(btnRegresar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(450, 450, 450))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(17, 17, 17)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(comboBoxRol, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(btnRegistrarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnEditarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btnEliminarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarUsuarioActionPerformed
       if (idUsuarioEditando == -1) {
            registrarUsuario();
        } else {
            actualizarUsuario();
        }
}

private void registrarUsuario() {
    String nombre = txtNombre.getText();
        String nombreUsuario = txtNombreUsuario.getText();
        String password = txtPassword.getText();
        String rolSeleccionado = comboBoxRol.getSelectedItem().toString();

        if (nombre.isEmpty() || nombreUsuario.isEmpty() || password.isEmpty() || rolSeleccionado == null) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Campos incompletos", JOptionPane.WARNING_MESSAGE);
            return;
        }

        RolDao rolDao = new RolDao();
        int idRol = rolDao.obtenerIdPorNombre(rolSeleccionado);

        if (idRol == -1) {
            JOptionPane.showMessageDialog(this, "Error al obtener el ID del rol.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setNombre_usuario(nombreUsuario);
        usuario.setPass(password);
        usuario.setRol(new Rol(idRol, rolSeleccionado));

        UsuarioDao usuarioDao = new UsuarioDao();
        if (usuarioDao.registrarUsuario(usuario)) {
            Object[] fila = {usuario.getId_usuario(), nombre, nombreUsuario, rolSeleccionado};
            modeloTabla.addRow(fila);
            limpiarCampos();
            JOptionPane.showMessageDialog(this, "Usuario registrado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(this, "Error al registrar el usuario.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRegistrarUsuarioActionPerformed

private void actualizarUsuario() {
    String nombre = txtNombre.getText();
        String nombreUsuario = txtNombreUsuario.getText();
        String password = txtPassword.getText();
        String rolSeleccionado = comboBoxRol.getSelectedItem().toString();

        if (nombre.isEmpty() || nombreUsuario.isEmpty() || password.isEmpty() || rolSeleccionado == null) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Campos incompletos", JOptionPane.WARNING_MESSAGE);
            return;
        }

        RolDao rolDao = new RolDao();
        int idRol = rolDao.obtenerIdPorNombre(rolSeleccionado);

        if (idRol == -1) {
            JOptionPane.showMessageDialog(this, "Error al obtener el ID del rol.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Usuario usuario = new Usuario();
        usuario.setId_usuario(idUsuarioEditando);
        usuario.setNombre(nombre);
        usuario.setNombre_usuario(nombreUsuario);
        usuario.setPass(password);
        usuario.setRol(new Rol(idRol, rolSeleccionado));

        UsuarioDao usuarioDao = new UsuarioDao();
        if (usuarioDao.actualizarUsuario(usuario)) {
            int selectedRow = TablaUsuarios.getSelectedRow();
            modeloTabla.setValueAt(nombre, selectedRow, 1);
            modeloTabla.setValueAt(nombreUsuario, selectedRow, 2);
            modeloTabla.setValueAt(rolSeleccionado, selectedRow, 3);

            limpiarCampos();
            btnRegistrarUsuario.setText("Registrar Usuario");
            idUsuarioEditando = -1;
            JOptionPane.showMessageDialog(this, "Usuario actualizado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(this, "Error al actualizar el usuario.", "Error", JOptionPane.ERROR_MESSAGE);
        }
}

    private void comboBoxRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxRolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxRolActionPerformed

    private void btnEditarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarUsuarioActionPerformed
    int selectedRow = TablaUsuarios.getSelectedRow();
        if (selectedRow >= 0) {
            int idUsuario = (int) TablaUsuarios.getValueAt(selectedRow, 0);
            UsuarioDao usuarioDao = new UsuarioDao();
            Usuario usuario = usuarioDao.obtenerUsuarioPorId(idUsuario);

            if (usuario != null) {
                idUsuarioEditando = usuario.getId_usuario();
                txtNombre.setText(usuario.getNombre());
                txtNombreUsuario.setText(usuario.getNombre_usuario());
                txtPassword.setText(usuario.getPass());
                comboBoxRol.setSelectedItem(usuario.getRol().getTipoRol());
                btnRegistrarUsuario.setText("Guardar Cambios");
            } else {
                JOptionPane.showMessageDialog(this, "Error al cargar los datos del usuario.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una fila para editar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarUsuarioActionPerformed

    private void btnEliminarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarUsuarioActionPerformed
      int selectedRow = TablaUsuarios.getSelectedRow();
        if (selectedRow >= 0) {
            int idUsuario = (int) TablaUsuarios.getValueAt(selectedRow, 0);
            int confirm = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas eliminar este usuario?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                UsuarioDao usuarioDao = new UsuarioDao();
                if (usuarioDao.eliminarUsuario(idUsuario)) {
                    modeloTabla.removeRow(selectedRow);
                    JOptionPane.showMessageDialog(this, "Usuario eliminado exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(this, "Error al eliminar el usuario.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una fila para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarUsuarioActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.dispose();
        // Abrir la ventana del menú
    Menu menu = new Menu(usuario); // Asegúrate de pasar el objeto 'usuario' al constructor del menú
    menu.setSize((int) (PantallaUtil.obtenerAnchoPantalla() * 0.62), (int) (PantallaUtil.obtenerAltoPantalla() * 0.67)); // Tamaño de ventana = 85% del monitor
    menu.setVisible(true);
    menu.setLocationRelativeTo(null);
    menu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_btnRegresarActionPerformed

  private void cargarUsuarios() {
    UsuarioDao usuarioDao = new UsuarioDao();
        List<Usuario> usuarios = usuarioDao.listarUsuarios();
        for (Usuario usuario : usuarios) {
            Object[] fila = {
                usuario.getId_usuario(),
                usuario.getNombre(),
                usuario.getNombre_usuario(),
                usuario.getRol().getTipoRol()
            };
            modeloTabla.addRow(fila);
        }
  }


  private void llenarComboBoxRoles() {
       RolDao rolDao = new RolDao();
        List<String> nombresRoles = rolDao.obtenerNombresRoles();
        for (String nombreRol : nombresRoles) {
            comboBoxRol.addItem(nombreRol);
        }
    }

    private void limpiarCampos() {
        txtNombreUsuario.setText("");
        txtNombre.setText("");
        txtPassword.setText("");
        comboBoxRol.setSelectedIndex(0);
    }
    

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaUsuarios;
    private javax.swing.JButton btnEditarUsuario;
    private javax.swing.JButton btnEliminarUsuario;
    private javax.swing.JButton btnRegistrarUsuario;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> comboBoxRol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreUsuario;
    private javax.swing.JTextField txtPassword;
    // End of variables declaration//GEN-END:variables
}
