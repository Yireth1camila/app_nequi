package com.mycompany.simuladornequi3;

import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Factura_Digital {

    public static void generarFactura(Usuario usuario) {
        String nombreArchivo = "Factura_" + usuario.getNombre().replaceAll(" ", "_") + ".pdf";
        try {
            File file = new File(nombreArchivo);
            PdfWriter writer = new PdfWriter(file);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            // Encabezado
            document.add(new Paragraph("🧾 FACTURA DIGITAL NEQUI").setBold().setFontSize(18));
            document.add(new Paragraph("Usuario: " + usuario.getNombre()));
            document.add(new Paragraph("Fecha de generación: " +
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))));
            document.add(new Paragraph(" "));

            // Tabla
            Table table = new Table(2);
            table.addCell("Fecha/Hora");
            table.addCell("Monto consignado");

            // ✅ Corrección aquí: usar Transaccion en lugar de String
            List<Transaccion> historial = usuario.getCuenta().getHistorial();
            boolean hayConsignaciones = false;

            for (Transaccion transaccion : historial) {
                if (transaccion.getTipo().equalsIgnoreCase("Ingreso")) {
                    table.addCell(transaccion.getFechaFormateada());
                    table.addCell("$" + transaccion.getMonto());
                    hayConsignaciones = true;
                }
            }

            if (hayConsignaciones) {
                document.add(table);
                document.add(new Paragraph("\nGracias por usar el servicio Nequi."));
            } else {
                document.add(new Paragraph("No se encontraron consignaciones en el historial."));
            }

            document.close();
            System.out.println("✅ Factura generada: " + file.getAbsolutePath());

        } catch (IOException e) {
            System.out.println("❌ Error al generar el PDF: " + e.getMessage());
        }
    }
}
