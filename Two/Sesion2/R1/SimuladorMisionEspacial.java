package Two.Sesion2.R1;

import java.util.concurrent.*;

public class SimuladorMisionEspacial {
    public static void main(String[] args) {
        System.out.println("🚀 Simulación de misión espacial iniciada...");

        ExecutorService executor = Executors.newFixedThreadPool(4);

        try {
            Future<String> nav = executor.submit(new SistemaNavegacion());
            Future<String> soporte = executor.submit(new SistemaSoporteVital());
            Future<String> termico = executor.submit(new SistemaControlTermico());
            Future<String> comm = executor.submit(new SistemaComunicaciones());

            System.out.println(comm.get());
            System.out.println(soporte.get());
            System.out.println(termico.get());
            System.out.println(nav.get());

            System.out.println("✅ Todos los sistemas reportan estado operativo.");

        } catch (InterruptedException | ExecutionException e) {
            System.err.println("❌ Error en la simulación: " + e.getMessage());
        } finally {
            executor.shutdown();
        }
    }
}
