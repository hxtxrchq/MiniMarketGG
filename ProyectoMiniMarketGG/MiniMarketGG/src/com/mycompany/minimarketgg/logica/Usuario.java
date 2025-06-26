/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.minimarketgg.logica;

public class Usuario {
    private int id_usuario;
    private String nombre;
    private String nombre_usuario;  // Cambiado a nombre_usuario
    private String pass;
    private Rol rol;

    public Usuario() {
    }

    public Usuario(int id_usuario, String nombre, String nombre_usuario, String pass, Rol rol) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.nombre_usuario = nombre_usuario;
        this.pass = pass;
        this.rol = rol;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre_usuario() {  // Cambiado a getNombre_usuario
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {  // Cambiado a setNombre_usuario
        this.nombre_usuario = nombre_usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
