package Two.Sesion1.R1;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<OrdenProduccion> todas = new ArrayList<>();

        // Crear órdenes de masa
        OrdenMasa om1 = new OrdenMasa("A123", 500);
        OrdenMasa om2 = new OrdenMasa("A124", 750);
        todas.add(om1);
        todas.add(om2);

        // Crear órdenes personalizadas
        OrdenPersonalizada op1 = new OrdenPersonalizada("P456", 100, "ClienteX");
        OrdenPersonalizada op2 = new OrdenPersonalizada("P789", 150, "ClienteY");
        todas.add(op1);
        todas.add(op2);

        // Crear órdenes prototipo
        OrdenPrototipo ot1 = new OrdenPrototipo("T789", 10, "Diseño");
        OrdenPrototipo ot2 = new OrdenPrototipo("T790", 5, "Pruebas");
        todas.add(ot1);
        todas.add(ot2);

        // Mostrar por tipo
        ProcesadorOrdenes.mostrarOrdenes(List.of(om1, om2));
        ProcesadorOrdenes.mostrarOrdenes(List.of(op1, op2));
        ProcesadorOrdenes.mostrarOrdenes(List.of(ot1, ot2));

        // Procesar órdenes personalizadas
        ProcesadorOrdenes.procesarPersonalizadas(todas, 200);

        // Resumen
        ProcesadorOrdenes.contarOrdenes(todas);
    }
}
