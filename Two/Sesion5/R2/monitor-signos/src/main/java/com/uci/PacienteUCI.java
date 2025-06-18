package com.uci;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.Random;

public class PacienteUCI {
    private final int id;
    private final Random rand = new Random();

    public PacienteUCI(int id) {
        this.id = id;
    }

    public Flux<EventoVital> generarEventos() {
        return Flux.interval(Duration.ofMillis(300))
                .map(tick -> {
                    int fc = 40 + rand.nextInt(101); // 40–140 bpm
                    int sistolica = 80 + rand.nextInt(81); // 80–160
                    int diastolica = 50 + rand.nextInt(51); // 50–100
                    int spo2 = 85 + rand.nextInt(16); // 85–100
                    return new EventoVital(id, fc, sistolica, diastolica, spo2);
                });
    }
}
