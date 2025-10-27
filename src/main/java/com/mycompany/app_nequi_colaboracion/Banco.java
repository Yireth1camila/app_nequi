/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.app_nequi;

/**
 *
 * @author USUARIO
 */
public class Banco {

    // ===================== BANCO =====================
    
    private String nombre;

    public Banco(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Banco: " + nombre;
    }
}

    
    

