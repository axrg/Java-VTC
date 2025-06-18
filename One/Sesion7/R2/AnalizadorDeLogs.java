package One.Sesion7.R2;

import java.io.*;

public class AnalizadorDeLogs {
    public static void main(String[] args) {
        String archivoLog = "One/Sesion7/R2/errores.log";
        int totalLineas = 0;
        int totalErrores = 0;
        int totalWarnings = 0;

        try (BufferedReader lector = new BufferedReader(new FileReader(archivoLog))) {
            String linea;

            while ((linea = lector.readLine()) != null) {
                totalLineas++;

                if (linea.contains("ERROR")) {
                    totalErrores++;
                }
                if (linea.contains("WARNING")) {
                    totalWarnings++;
                }
            }

            System.out.println("===== RESUMEN DEL ANALISIS =====");
            System.out.println("Total de líneas leídas: " + totalLineas);
            System.out.println("Cantidad de errores: " + totalErrores);
            System.out.println("Cantidad de advertencias: " + totalWarnings);

            double porcentaje = ((double)(totalErrores + totalWarnings) / totalLineas) * 100;
            System.out.printf("Porcentaje de líneas con errores/advertencias: %.2f%%\n", porcentaje);

        } catch (IOException e) {
            System.err.println("Ocurrió un error al leer el archivo. Detalles guardados en registro_fallos.txt");
            guardarError(e.getMessage());
        }
    }

    private static void guardarError(String mensaje) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter("registro_fallos.txt", true))) {
            escritor.write("Error al analizar el archivo: " + mensaje);
            escritor.newLine();
        } catch (IOException ex) {
            System.err.println("No se pudo escribir en registro_fallos.txt: " + ex.getMessage());
        }
    }
}
