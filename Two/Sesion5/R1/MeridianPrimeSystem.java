package Two.Sesion5.R1;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class MeridianPrimeSystem {

    static Random random = new Random();
    static AtomicInteger semaforoRojoCounter = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        System.out.println("🧠 Iniciando monitoreo de sistemas en Meridian Prime...");

        Flux<String> trafico = Flux.interval(Duration.ofMillis(500))
                .map(i -> random.nextInt(101))
                .filter(nivel -> nivel > 70)
                .map(nivel -> "🚗 Alerta: Congestión del " + nivel + "% en Avenida Solar")
                .onBackpressureBuffer(10)
                .subscribeOn(Schedulers.parallel());

        Flux<String> contaminacion = Flux.interval(Duration.ofMillis(600))
                .map(i -> 30 + random.nextInt(71)) // 30-100 ug/m3
                .filter(pm -> pm > 50)
                .map(pm -> "🌫️ Alerta: Contaminación alta (PM2.5: " + pm + " ug/m3)")
                .subscribeOn(Schedulers.parallel());

        Flux<String> accidentes = Flux.interval(Duration.ofMillis(800))
                .map(i -> List.of("Baja", "Media", "Alta").get(random.nextInt(3)))
                .filter(p -> p.equals("Alta"))
                .map(p -> "🚑 Emergencia vial: Accidente con prioridad Alta")
                .subscribeOn(Schedulers.parallel());

        Flux<String> trenes = Flux.interval(Duration.ofMillis(700))
                .map(i -> random.nextInt(11)) // 0-10 min
                .filter(min -> min > 5)
                .map(min -> "🚝 Tren maglev con retraso crítico: " + min + " minutos")
                .onBackpressureBuffer(5)
                .subscribeOn(Schedulers.parallel());

        Flux<String> semaforos = Flux.interval(Duration.ofMillis(400))
                .map(i -> List.of("Verde", "Amarillo", "Rojo").get(random.nextInt(3)))
                .map(estado -> {
                    if (estado.equals("Rojo")) {
                        int count = semaforoRojoCounter.incrementAndGet();
                        if (count >= 3) {
                            semaforoRojoCounter.set(0);
                            return "🚦 Semáforo en Rojo detectado 3 veces seguidas en cruce Norte";
                        }
                    } else {
                        semaforoRojoCounter.set(0);
                    }
                    return null;
                })
                .filter(mensaje -> mensaje != null)
                .subscribeOn(Schedulers.parallel());

        // 🔥 Combina todos los flujos y procesa alertas
        Flux<String> sistemaGlobal = Flux.merge(trafico, contaminacion, accidentes, trenes, semaforos)
                .publish()
                .autoConnect();

        // Muestra cada alerta crítica
        sistemaGlobal
                .doOnNext(alerta -> System.out.println(alerta))
                .subscribe();

        // 🚨 Alerta global si ocurren 3 o más eventos críticos casi al mismo tiempo
        sistemaGlobal.buffer(Duration.ofSeconds(1))
                .filter(lista -> lista.size() >= 3)
                .subscribe(lista -> {
                    System.out.println("🚨 Alerta global: Múltiples eventos críticos detectados en Meridian Prime");
                    lista.forEach(System.out::println);
                    System.out.println("──────────────────────────────────────────────");
                });

        // Mantiene la app corriendo
        Thread.sleep(30000); // 30 segundos de simulación
    }
}
