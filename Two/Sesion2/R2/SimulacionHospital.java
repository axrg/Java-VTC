package Two.Sesion2.R2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimulacionHospital {
    public static void main(String[] args) {
        System.out.println("🏥 Iniciando acceso a la Sala de cirugía...");

        RecursoMedico salaCirugia = new RecursoMedico("Sala de cirugía");

        String[] profesionales = {
                "Dra. Sánchez",
                "Dr. Gómez",
                "Enf. Ramírez",
                "Dr. Pérez",
                "Enf. López"
        };

        ExecutorService executor = Executors.newFixedThreadPool(4);

        for (String nombre : profesionales) {
            executor.submit(() -> salaCirugia.usar(nombre));
        }

        executor.shutdown();
    }
}
