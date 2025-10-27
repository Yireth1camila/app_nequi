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
public class CuentaNequi {
    // ===================== CUENTANEQUI =====================

    private double saldo;
    private final ArrayList<Transaccion> historial;

    public CuentaNequi() {
        this.saldo = 0;
        this.historial = new ArrayList<>();
    }

    public double getSaldo() {
        return saldo;
    }

    // ✅ Nuevo método para agregar dinero
    public void agregarDinero(double monto) {
        saldo += monto;
        historial.add(new Transaccion("Ingreso", monto));
    }

    public boolean retirar(double monto) {
        if (monto <= saldo) {
            saldo -= monto;
            historial.add(new Transaccion("Retiro", monto));
            return true;
        }
        return false;
    }

    public boolean recargar(double monto) {
        if (monto <= saldo) {
            saldo -= monto;
            historial.add(new Transaccion("Recarga", monto));
            return true;
        }
        return false;
    }

    public boolean enviarDinero(double monto, CuentaNequi destino) {
        if (monto <= saldo) {
            saldo -= monto;
            destino.agregarDinero(monto); // usamos el nuevo método
            historial.add(new Transaccion("Envío", monto));
            return true;
        }
        return false;
    }

    public void mostrarHistorial() {
        for (Transaccion t : historial) {
            System.out.println(t);
        }
    }

    // ✅ Método agregado para corregir el error
    public ArrayList<Transaccion> getHistorial() {
        return historial;
    }
}
