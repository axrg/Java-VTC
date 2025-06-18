package Two.Sesion3.R1;

import java.util.List;
import java.util.Arrays;
import java.util.Optional;


public class ProcesadorPedidos {
    public static void main(String[] args) {
        List<Pedido> pedidos = Arrays.asList(
                new Pedido("Juan", "domicilio", "555-1234"),
                new Pedido("Ana", "local", "555-9999"),
                new Pedido("Luis", "domicilio", null),
                new Pedido("Carla", "domicilio", "555-5678"),
                new Pedido("Mario", "local", null)
        );

        pedidos.stream()
                .filter(p -> "domicilio".equalsIgnoreCase(p.getTipoEntrega()))
                .map(Pedido::getTelefono)
                .flatMap(Optional::stream)
                .map(tel -> "📞 Confirmación enviada al número: " + tel)
                .forEach(System.out::println);
    }
}
