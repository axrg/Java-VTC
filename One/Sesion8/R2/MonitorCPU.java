package One.Sesion8.R2;

import java.util.HashSet;
import java.util.Scanner;

public class MonitorCPU {
    public static void main(String[] args) {
        Scanner scanner = null;
        HashSet<Integer> consumosRegistrados = new HashSet<>();

        try {
            scanner = new Scanner(System.in);
            System.out.println("Ingrese los consumos de CPU por servidor (en %). Escriba -1 para finalizar.");

            while (true) {
                System.out.print("Consumo de CPU (%): ");
                String entrada = scanner.nextLine().trim();

                // Salida del ciclo
                if (entrada.equals("-1")) break;

                int consumo;

                try {
                    consumo = Integer.parseInt(entrada);
                } catch (NumberFormatException e) {
                    System.out.println("❌ Error: Ingrese un número válido.");
                    continue;
                }

                // Validaciones de rango
                if (consumo < 0 || consumo > 100) {
                    System.out.println("⚠️ Valor fuera de rango. Debe estar entre 0% y 100%.");
                    continue;
                }

                // Validar duplicados
                if (consumosRegistrados.contains(consumo)) {
                    System.out.println("🔁 Valor duplicado. Ya ha sido registrado.");
                    continue;
                }

                // Agregar al conjunto
                consumosRegistrados.add(consumo);

                // Validar consumo crítico
                if (consumo > 95) {
                    throw new ConsumoCriticoException("🔥 Alerta crítica: consumo de CPU excede el 95%.");
                }

                System.out.println("✅ Consumo registrado correctamente.");
            }

        } catch (ConsumoCriticoException e) {
            System.out.println(e.getMessage());
        } finally {
            if (scanner != null) {
                scanner.close();
                System.out.println("📦 Recursos cerrados correctamente.");
            }
        }

        System.out.println("📊 Registros finales: " + consumosRegistrados);
    }
}
