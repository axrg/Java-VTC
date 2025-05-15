package Sesion5.R2;

public class PagoEfectivo extends MetodoPago implements Autenticable {

    public PagoEfectivo(double monto) {
        super(monto);
    }

    @Override
    public boolean autenticar() {
        return true; // Siempre es válido
    }

    @Override
    public void procesarPago() {
        System.out.println("💵 Procesando pago en efectivo por $" + monto);
    }
}

