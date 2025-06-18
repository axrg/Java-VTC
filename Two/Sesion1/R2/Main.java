package Two.Sesion1.R2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<MaterialCurso> materiales = new ArrayList<>();

        // Crear videos
        Video v1 = new Video("Introducción a Java", "Mario", 15);
        Video v2 = new Video("POO en Java", "Carlos", 20);
        materiales.add(v1);
        materiales.add(v2);

        // Crear artículos
        Articulo a1 = new Articulo("Historia de Java", "Ana", 1200);
        Articulo a2 = new Articulo("Tipos de datos", "Luis", 800);
        materiales.add(a1);
        materiales.add(a2);

        // Crear ejercicios
        Ejercicio e1 = new Ejercicio("Variables y tipos", "Luis");
        Ejercicio e2 = new Ejercicio("Condicionales", "Mario");
        materiales.add(e1);
        materiales.add(e2);

        // Mostrar materiales
        GestorMateriales.mostrarMateriales(materiales);

        // Contar duración videos
        List<Video> soloVideos = List.of(v1, v2);
        GestorMateriales.contarDuracionVideos(soloVideos);

        // Marcar ejercicios como revisados
        GestorMateriales.marcarEjerciciosRevisados(materiales);

        // Filtrar por autor (opcional)
        GestorMateriales.filtrarPorAutor(materiales, m -> m.autor.equals("Mario"));
    }
}
