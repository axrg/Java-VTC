package One.Sesion5.R2;

public class PagoTransferencia extends MetodoPago implements Autenticable {
    private boolean validacionExterna;

    public PagoTransferencia(double monto, boolean validacionExterna) {
        super(monto);
        this.validacionExterna = validacionExterna;
    }

    @Override
    public boolean autenticar() {
        return validacionExterna;
    }

    @Override
    public void procesarPago() {
        System.out.println("🏦 Procesando pago por transferencia de $" + monto);
    }
}
