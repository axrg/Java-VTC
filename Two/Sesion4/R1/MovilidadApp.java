package Two.Sesion4.R1;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class MovilidadApp {

    // Simula el cálculo de la ruta (2–3 segundos)
    public CompletableFuture<String> calcularRuta() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("🚦 Calculando ruta...");
                TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(2, 4));
                if (Math.random() < 0.1) throw new RuntimeException("Error al calcular ruta.");
                return "Centro -> Norte";
            } catch (InterruptedException e) {
                throw new RuntimeException("Interrupción en cálculo de ruta");
            }
        });
    }

    // Simula la estimación de la tarifa (1–2 segundos)
    public CompletableFuture<Double> estimarTarifa() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("💰 Estimando tarifa...");
                TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(1, 3));
                if (Math.random() < 0.1) throw new RuntimeException("Error al estimar tarifa.");
                return 75.50;
            } catch (InterruptedException e) {
                throw new RuntimeException("Interrupción en estimación de tarifa");
            }
        });
    }

    public void procesarSolicitud() {
        CompletableFuture<String> rutaFuture = calcularRuta();
        CompletableFuture<Double> tarifaFuture = estimarTarifa();

        rutaFuture.thenCombine(tarifaFuture, (ruta, tarifa) ->
                        "✅ 🚗 Ruta calculada: " + ruta + " | Tarifa estimada: $" + tarifa
                )
                .exceptionally(ex -> "❌ Error en la solicitud: " + ex.getMessage())
                .thenAccept(System.out::println);
    }

    public static void main(String[] args) throws InterruptedException {
        MovilidadApp app = new MovilidadApp();
        app.procesarSolicitud();

        // Esperar a que terminen los procesos asincrónicos antes de que finalice el programa
        TimeUnit.SECONDS.sleep(5);
    }
}
