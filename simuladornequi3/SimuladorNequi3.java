/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.simuladornequi3;
import java.util.Scanner;

/**
 *
 * @author USUARIO
 */
public class SimuladorNequi3 {

    public static void main(String[] args) {
       // ===================== SIMULADORNEQUI3 =====================


        Scanner sc = new Scanner(System.in);

        // Crear usuarios
        Usuario usuario1 = new Usuario("yireth camila saya");
        Usuario usuario2 = new Usuario("juan david banguera");

        // Asociar bancos
        usuario1.asociarBanco(new Banco("Bancolombia"));
        usuario1.asociarBanco(new Banco("Davivienda"));

        usuario2.asociarBanco(new Banco("BBVA"));

        // Agregar dispositivos
        usuario1.agregarDispositivo(new Dispositivo("Celular"));
        usuario1.agregarDispositivo(new Dispositivo("Tablet"));

        int opcion;
        do {
            System.out.println("\n=== Simulador Nequi 3 ===");
            System.out.println("Usuario activo: " + usuario1.getNombre());
            System.out.println("1. Consultar saldo");
            System.out.println("2. Agregar dinero");
            System.out.println("3. Retirar dinero");
            System.out.println("4. Recargar celular");
            System.out.println("5. Enviar dinero a " + usuario2.getNombre());
            System.out.println("6. Mostrar historial");
            System.out.println("7. Mostrar bancos asociados");
            System.out.println("8. Autorizar dispositivo");
            System.out.println("9. Mostrar dispositivos");
            System.out.println("10. Generar factura digital (PDF)");
            System.out.println("0. Salir");
            System.out.print("Seleccione: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("💰 Saldo actual: $" + usuario1.getCuenta().getSaldo());
                    break;
                case 2:
                    System.out.print("Ingrese monto a agregar: ");
                    double ingreso = sc.nextDouble();
                    usuario1.getCuenta().agregarDinero(ingreso);
                    System.out.println("✅ Dinero agregado correctamente.");
                    break;
                case 3:
                    System.out.print("Ingrese monto a retirar: ");
                    double retiro = sc.nextDouble();
                    if (usuario1.getCuenta().retirar(retiro)) {
                        System.out.println("✅ Retiro exitoso.");
                    } else {
                        System.out.println("❌ Fondos insuficientes.");
                    }
                    break;
                case 4:
                    System.out.print("Ingrese monto de recarga: ");
                    double recarga = sc.nextDouble();
                    if (usuario1.getCuenta().recargar(recarga)) {
                        System.out.println("✅ Recarga exitosa.");
                    } else {
                        System.out.println("❌ Fondos insuficientes.");
                    }
                    break;
                case 5:
                    System.out.print("Ingrese monto a enviar: ");
                    double envio = sc.nextDouble();
                    if (usuario1.getCuenta().enviarDinero(envio, usuario2.getCuenta())) {
                        System.out.println("✅ Envío exitoso a " + usuario2.getNombre());
                    } else {
                        System.out.println("❌ Fondos insuficientes.");
                    }
                    break;
                case 6:
                    usuario1.getCuenta().mostrarHistorial();
                    break;
                case 7:
                    usuario1.mostrarBancos();
                    break;
                case 8:
                    sc.nextLine(); // limpiar buffer
                    System.out.print("Ingrese nombre del dispositivo: ");
                    String disp = sc.nextLine();
                    usuario1.autorizarDispositivo(disp);
                    break;
                case 9:
                    usuario1.mostrarDispositivos();
                    break;
                case 10:
                Factura_Digital.generarFactura(usuario1);
                break;
                case 0:
                    System.out.println("👋 Saliendo del simulador...");
                    break;
                default:
                    System.out.println("⚠️ Opción inválida.");
            }
        } while (opcion != 0);
    }
}
