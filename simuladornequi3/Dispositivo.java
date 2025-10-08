/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simuladornequi3;

/**
 *
 * @author USUARIO
 */
public class Dispositivo {
    // ===================== DISPOSITIVO =====================
   
   // ===================== DISPOSITIVO =====================

   
    private final String nombre;
    private boolean autorizado;

    public Dispositivo(String nombre) {
        this.nombre = nombre;
        this.autorizado = false;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isAutorizado() {
        return autorizado;
    }

    public void autorizar() {
        this.autorizado = true;
    }

    @Override
    public String toString() {
        return nombre + (autorizado ? " (Autorizado)" : " (No autorizado)");
    }
}

    

