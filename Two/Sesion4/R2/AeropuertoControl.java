package Two.Sesion4.R2;

import java.util.concurrent.*;
import java.util.concurrent.ThreadLocalRandom;

public class AeropuertoControl {

    private final ExecutorService executor = Executors.newCachedThreadPool();

    public CompletableFuture<Boolean> verificarPista() {
        return CompletableFuture.supplyAsync(() -> {
            simularLatencia();
            boolean disponible = Math.random() < 0.80; // 80% de éxito
            System.out.println("🛣️ Pista disponible: " + disponible);
            return disponible;
        }, executor);
    }

    public CompletableFuture<Boolean> verificarClima() {
        return CompletableFuture.supplyAsync(() -> {
            simularLatencia();
            boolean favorable = Math.random() < 0.85; // 85% de éxito
            System.out.println("🌦️ Clima favorable: " + favorable);
            return favorable;
        }, executor);
    }

    public CompletableFuture<Boolean> verificarTraficoAereo() {
        return CompletableFuture.supplyAsync(() -> {
            simularLatencia();
            boolean despejado = Math.random() < 0.90; // 90% de éxito
            System.out.println("🚦 Tráfico aéreo despejado: " + despejado);
            return despejado;
        }, executor);
    }

    public CompletableFuture<Boolean> verificarPersonalTierra() {
        return CompletableFuture.supplyAsync(() -> {
            simularLatencia();
            boolean disponible = Math.random() < 0.95; // 95% de éxito
            System.out.println("👷‍♂️ Personal disponible: " + disponible);
            return disponible;
        }, executor);
    }

    private void simularLatencia() {
        try {
            TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(2, 4));
        } catch (InterruptedException e) {
            throw new RuntimeException("Interrupción simulada");
        }
    }

    public void procesarAterrizaje() {
        System.out.println("🛫 Verificando condiciones para aterrizaje...\n");

        CompletableFuture<Boolean> pista = verificarPista();
        CompletableFuture<Boolean> clima = verificarClima();
        CompletableFuture<Boolean> trafico = verificarTraficoAereo();
        CompletableFuture<Boolean> personal = verificarPersonalTierra();

        CompletableFuture.allOf(pista, clima, trafico, personal)
                .thenApply(v -> {
                    try {
                        return pista.get() && clima.get() && trafico.get() && personal.get();
                    } catch (Exception e) {
                        throw new RuntimeException("Error al obtener resultados: " + e.getMessage());
                    }
                })
                .thenAccept(autorizado -> {
                    if (autorizado) {
                        System.out.println("\n🛬 Aterrizaje autorizado: todas las condiciones óptimas.");
                    } else {
                        System.out.println("\n🚫 Aterrizaje denegado: condiciones no óptimas.");
                    }
                })
                .exceptionally(ex -> {
                    System.out.println("\n❌ Error en el proceso de aterrizaje: " + ex.getMessage());
                    return null;
                })
                .thenRun(executor::shutdown);
    }

    public static void main(String[] args) {
        new AeropuertoControl().procesarAterrizaje();
    }
}
