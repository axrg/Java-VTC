package Sesion4.R2;

import java.util.Objects;

// 🎯 Record DeclaracionImpuestos
public record DeclaracionImpuestos(String rfcContribuyente, double montoDeclarado) {}

// 💼 Clase tradicional CuentaFiscal
class CuentaFiscal {
    private final String rfc;
    private double saldoDisponible;

    // Constructor con validación
    public CuentaFiscal(String rfc, double saldoDisponible) {
        if (saldoDisponible < 0) {
            throw new IllegalArgumentException("El saldo no puede ser negativo.");
        }
        this.rfc = rfc;
        this.saldoDisponible = saldoDisponible;
    }

    // Getters
    public String getRfc() {
        return rfc;
    }

    public double getSaldoDisponible() {
        return saldoDisponible;
    }

    // Método para validar RFC usando Objects.equals()
    public boolean validarRFC(DeclaracionImpuestos d) {
        return Objects.equals(this.rfc, d.rfcContribuyente());
    }
}
