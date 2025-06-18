package Two.Sesion3.R2;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;


public class ProcesadorEncuestas {
    public static void main(String[] args) {
        // Encuestas para sucursal Centro
        List<Encuesta> centroEncuestas = Arrays.asList(
                new Encuesta("Juan", "El tiempo de espera fue largo", 2),
                new Encuesta("Ana", null, 3),
                new Encuesta("Luis", "Todo estuvo excelente", 5)
        );

        // Encuestas para sucursal Norte
        List<Encuesta> norteEncuestas = Arrays.asList(
                new Encuesta("Pedro", "La atención fue buena, pero la limpieza puede mejorar", 3),
                new Encuesta("Sofía", null, 4)
        );

        List<Sucursal> sucursales = Arrays.asList(
                new Sucursal("Centro", centroEncuestas),
                new Sucursal("Norte", norteEncuestas)
        );

        sucursales.stream()
                .flatMap(sucursal ->
                        sucursal.getEncuestas().stream()
                                .filter(e -> e.getCalificacion() <= 3)
                                .flatMap(encuesta -> encuesta.getComentario()
                                        .map(coment -> Stream.of("Sucursal " + sucursal.getNombre() +
                                                ": Seguimiento a paciente con comentario: \"" + coment + "\""))
                                        .orElseGet(Stream::empty))
                )
                .forEach(System.out::println);
    }
}
