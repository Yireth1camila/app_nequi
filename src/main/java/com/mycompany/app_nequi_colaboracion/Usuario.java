/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.app_nequi;
import java.util.ArrayList;
/**
 *
 * @author USUARIO
 */
public class Usuario {
    // ===================== USUARIO =====================
    private final String nombre;
    private final CuentaNequi cuenta;
    private final ArrayList<Banco> bancosAsociados;
    private final ArrayList<Dispositivo> dispositivos;

    public Usuario(String nombre) {
        this.nombre = nombre;
        this.cuenta = new CuentaNequi();
        this.bancosAsociados = new ArrayList<>();
        this.dispositivos = new ArrayList<>();
    }

    
    
    public String getNombre() {
        return nombre;
    }

    public CuentaNequi getCuenta() {
        return cuenta;
    }

    public void asociarBanco(Banco banco) {
        bancosAsociados.add(banco);
    }

    public void mostrarBancos() {
        System.out.println("Bancos asociados:");
        for (Banco b : bancosAsociados) {
            System.out.println("- " + b.getNombre());
        }
    }

    public void agregarDispositivo(Dispositivo d) {
        dispositivos.add(d);
    }

    public void autorizarDispositivo(String nombre) {
        for (Dispositivo d : dispositivos) {
            if (d.getNombre().equalsIgnoreCase(nombre)) {
                d.autorizar();
                System.out.println("✅ Dispositivo autorizado: " + d.getNombre());
                return;
            }
        }
        System.out.println("❌ Dispositivo no encontrado.");
    }

    public void mostrarDispositivos() {
        System.out.println("Dispositivos:");
        for (Dispositivo d : dispositivos) {
            System.out.println("- " + d);
        }
    }
}

    

