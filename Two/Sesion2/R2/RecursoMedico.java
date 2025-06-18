package Two.Sesion2.R2;

import java.util.concurrent.locks.ReentrantLock;

public class RecursoMedico {
    private final String nombre;
    private final ReentrantLock lock = new ReentrantLock();

    public RecursoMedico(String nombre) {
        this.nombre = nombre;
    }

    public void usar(String profesional) {
        System.out.println("⏳ " + profesional + " está intentando ingresar a " + nombre);
        lock.lock();
        try {
            System.out.println("👩‍⚕️ " + profesional + " ha ingresado a " + nombre);
            Thread.sleep(1000); // Simula uso del recurso
            System.out.println("✅ " + profesional + " ha salido de " + nombre);
        } catch (InterruptedException e) {
            System.out.println("⚠️ Interrupción para " + profesional);
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    }
}
