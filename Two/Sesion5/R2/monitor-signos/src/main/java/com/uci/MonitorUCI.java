package com.uci;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Comparator;

public class MonitorUCI {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("🧠 Iniciando monitoreo de pacientes UCI...");

        PacienteUCI p1 = new PacienteUCI(1);
        PacienteUCI p2 = new PacienteUCI(2);
        PacienteUCI p3 = new PacienteUCI(3);

        Flux<EventoVital> flujoCombinado = Flux.merge(
                p1.generarEventos(),
                p2.generarEventos(),
                p3.generarEventos()
        );

        flujoCombinado
                .filter(EventoVital::esCritico)
                .onBackpressureBuffer()
                .bufferTimeout(5, Duration.ofMillis(1000))
                .flatMap(batch ->
                        Flux.fromIterable(batch.stream()
                                .sorted(Comparator.comparingInt(EventoVital::prioridad)) // prioridad: FC > PA > SpO2
                                .toList())
                )
                .delayElements(Duration.ofSeconds(1)) // simula procesamiento lento
                .map(EventoVital::mensaje)
                .subscribe(System.out::println);

        // Mantener aplicación corriendo
        Thread.sleep(30000);
    }
}
