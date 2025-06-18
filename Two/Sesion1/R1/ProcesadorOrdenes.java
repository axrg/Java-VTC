package Two.Sesion1.R1;

import java.util.List;

public class ProcesadorOrdenes {

    public static void mostrarOrdenes(List<? extends OrdenProduccion> lista) {
        System.out.println("\n📋 Órdenes registradas:");
        for (OrdenProduccion orden : lista) {
            orden.mostrarResumen();
        }
    }

    public static void procesarPersonalizadas(List<? super OrdenPersonalizada> lista, int costoAdicional) {
        System.out.println("\n💰 Procesando órdenes personalizadas...");
        for (Object obj : lista) {
            if (obj instanceof OrdenPersonalizada personalizada) {
                personalizada.aplicarCostoAdicional(costoAdicional);
            }
        }
    }

    public static void contarOrdenes(List<OrdenProduccion> lista) {
        int masa = 0, pers = 0, proto = 0;
        for (OrdenProduccion orden : lista) {
            if (orden instanceof OrdenMasa) masa++;
            else if (orden instanceof OrdenPersonalizada) pers++;
            else if (orden instanceof OrdenPrototipo) proto++;
        }

        System.out.println("\n📊 Resumen total de órdenes:");
        System.out.println("🔧 Producción en masa: " + masa);
        System.out.println("🛠️ Personalizadas: " + pers);
        System.out.println("🧪 Prototipos: " + proto);
    }
}
