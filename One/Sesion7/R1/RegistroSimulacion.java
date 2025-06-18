package One.Sesion7.R1;

import java.io.IOException;
import java.nio.file.*;

public class RegistroSimulacion {

    public static void main(String[] args) {
        Path rutaArchivo = Paths.get("config", "parametros.txt");

        try {
            guardarParametros(rutaArchivo);

            if (Files.exists(rutaArchivo)) {
                System.out.println("✅ Archivo creado correctamente.\n");
                String contenido = leerParametros(rutaArchivo);
                System.out.println("📄 Contenido del archivo:\n" + contenido);
            } else {
                System.out.println("❌ El archivo no fue creado.");
            }
        } catch (IOException e) {
            System.err.println("⚠️ Ocurrió un error: " + e.getMessage());
        }
    }

    public static void guardarParametros(Path rutaArchivo) throws IOException {
        // Crear carpeta si no existe
        if (Files.notExists(rutaArchivo.getParent())) {
            Files.createDirectories(rutaArchivo.getParent());
            System.out.println("📁 Carpeta 'config' creada.");
        }

        // Contenido a escribir
        String parametros = """
            Tiempo de ciclo: 55.8 segundos
            Velocidad de línea: 1.2 m/s
            Número de estaciones: 8
            """;

        // Escribir en el archivo
        Files.writeString(rutaArchivo, parametros, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        System.out.println("📝 Parámetros guardados en: " + rutaArchivo);
    }

    public static String leerParametros(Path rutaArchivo) throws IOException {
        return Files.readString(rutaArchivo);
    }
}
