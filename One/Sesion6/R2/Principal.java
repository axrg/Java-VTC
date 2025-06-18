package One.Sesion6.R2;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Collections;
import java.util.Comparator;

public class Principal {

    public static void main(String[] args) {
        // Lista concurrente de temas activos
        CopyOnWriteArrayList<Tema> temas = new CopyOnWriteArrayList<>();

        // Agregar temas
        temas.add(new Tema("Lectura comprensiva", 2));
        temas.add(new Tema("Matemáticas básicas", 1));
        temas.add(new Tema("Cuidado del medio ambiente", 3));
        temas.add(new Tema("Tecnología educativa", 1));

        // Mostrar temas ordenados alfabéticamente (Comparable)
        System.out.println("📚 Temas ordenados alfabéticamente:");
        Collections.sort(temas);
        for (Tema tema : temas) {
            System.out.println(tema);
        }

        // Ordenar por prioridad (Comparator)
        System.out.println("\n🔢 Temas ordenados por prioridad:");
        temas.sort(Comparator.comparingInt(Tema::getPrioridad));
        for (Tema tema : temas) {
            System.out.println(tema);
        }

        // Repositorio concurrente de recursos
        ConcurrentHashMap<String, String> recursos = new ConcurrentHashMap<>();
        recursos.put("Lectura comprensiva", "https://recursos.edu/lectura");
        recursos.put("Matemáticas básicas", "https://recursos.edu/mate");
        recursos.put("Cuidado del medio ambiente", "https://recursos.edu/medioambiente");
        recursos.put("Tecnología educativa", "https://recursos.edu/tecnologia");

        // Mostrar recursos
        System.out.println("\n🔗 Repositorio de recursos:");
        for (String titulo : recursos.keySet()) {
            System.out.println(titulo + " ➤ " + recursos.get(titulo));
        }
    }
}
