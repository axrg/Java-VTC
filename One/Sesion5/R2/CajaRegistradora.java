package One.Sesion5.R2;

public class CajaRegistradora {
    public static void main(String[] args) {
        MetodoPago[] pagos = {
                new PagoEfectivo(150.0),
                new PagoTarjeta(320.0, 500.0),
                new PagoTransferencia(280.0, false)
        };

        for (MetodoPago pago : pagos) {
            Autenticable autenticable = (Autenticable) pago;

            if (autenticable.autenticar()) {
                System.out.println("✅ Autenticación exitosa.");
                pago.procesarPago();
                pago.mostrarResumen();
                System.out.println();
            } else {
                System.out.println("❌ Fallo de autenticación. " + pago.getClass().getSimpleName() + " no válido.");
                System.out.println();
            }
        }
    }
}

