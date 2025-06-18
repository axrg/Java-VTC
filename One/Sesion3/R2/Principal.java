package One.Sesion3.R2;

public class Principal {
    public static void main(String[] args) {
        // Crear una factura con RFC
        Factura facturaConRFC = new Factura(2500.0, "Servicio de consultoría", "ABCC010101XYZ");

        // Crear una factura sin RFC (null)
        Factura facturaSinRFC = new Factura(1800.0, "Reparación de equipo", null);

        // Imprimir los resúmenes
        System.out.println(facturaConRFC.getResumen());
        System.out.println(facturaSinRFC.getResumen());
    }
}

