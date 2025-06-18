package com.uci;

public class EventoVital {
    public final int pacienteId;
    public final int fc;
    public final int paSist;
    public final int paDiast;
    public final int spo2;

    public EventoVital(int pacienteId, int fc, int paSist, int paDiast, int spo2) {
        this.pacienteId = pacienteId;
        this.fc = fc;
        this.paSist = paSist;
        this.paDiast = paDiast;
        this.spo2 = spo2;
    }

    public boolean esCritico() {
        return (fc < 50 || fc > 120) ||
                (paSist < 90 || paSist > 140 || paDiast < 60 || paDiast > 90) ||
                (spo2 < 90);
    }

    public int prioridad() {
        // FC = 1 (más prioridad), PA = 2, SpO₂ = 3
        if (fc < 50 || fc > 120) return 1;
        if (paSist < 90 || paSist > 140 || paDiast < 60 || paDiast > 90) return 2;
        return 3;
    }

    public String mensaje() {
        if (fc < 50 || fc > 120)
            return "⚠️ Paciente " + pacienteId + " - FC crítica: " + fc + " bpm";
        if (paSist < 90 || paSist > 140 || paDiast < 60 || paDiast > 90)
            return "⚠️ Paciente " + pacienteId + " - PA crítica: " + paSist + "/" + paDiast + " mmHg";
        if (spo2 < 90)
            return "⚠️ Paciente " + pacienteId + " - SpO₂ baja: " + spo2 + "%";
        return "";
    }
}
