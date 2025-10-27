package com.mycompany.app_nequi;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Cell;
import java.io.FileNotFoundException;
import java.time.format.DateTimeFormatter;

/**
 * Clase encargada de generar la factura digital en PDF con la información
 * del usuario y su historial de transacciones.
 *
 * Esta versión muestra un formato simple pero funcional.
 *
 * @author Edgar
 */
public class Factura_Digital {

    public static void generarFactura(Usuario usuario) {
        if (usuario == null || usuario.getCuenta() == null) {
            System.out.println("⚠️ No se puede generar la factura: usuario inválido o sin cuenta.");
            return;
        }

        try {
            String nombreArchivo = "Factura_" + usuario.getNombre().replace(" ", "_") + ".pdf";
            PdfWriter writer = new PdfWriter(nombreArchivo);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            // Encabezado
            document.add(new Paragraph("🧾 FACTURA DIGITAL NEQUI")
                    .setBold()
                    .setFontSize(16));
            document.add(new Paragraph("Usuario: " + usuario.getNombre()));
            document.add(new Paragraph("Saldo actual: $" + usuario.getCuenta().getSaldo()));
            document.add(new Paragraph("\n"));

            // Crear tabla para mostrar transacciones
            Table table = new Table(3);
            table.addHeaderCell(new Cell().add(new Paragraph("Tipo de transacción")));
            table.addHeaderCell(new Cell().add(new Paragraph("Monto ($)")));
            table.addHeaderCell(new Cell().add(new Paragraph("Fecha")));

            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

            if (usuario.getCuenta().getHistorial().isEmpty()) {
                document.add(new Paragraph("📭 No hay transacciones registradas."));
            } else {
                for (Transaccion t : usuario.getCuenta().getHistorial()) {
                    table.addCell(new Cell().add(new Paragraph(t.getTipo())));
                    table.addCell(new Cell().add(new Paragraph(String.valueOf(t.getMonto()))));
                    table.addCell(new Cell().add(new Paragraph(t.getFecha().format(formato))));
                }
                document.add(table);
            }

            document.add(new Paragraph("\nGracias por usar el simulador Nequi 💜"));
            document.close();

            System.out.println("✅ Factura generada correctamente: " + nombreArchivo);

        } catch (FileNotFoundException e) {
            System.out.println("❌ Error al generar el PDF: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("❌ Ocurrió un error inesperado: " + e.getMessage());
        }
    }
}
