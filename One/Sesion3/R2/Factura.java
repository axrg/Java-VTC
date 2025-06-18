package One.Sesion3.R2;

import java.util.Optional;

public class Factura {
    // 🔐 Atributos privados
    private double monto;
    private String descripcion;
    private Optional<String> rfc;

    // 🛠️ Constructor
    public Factura(double monto, String descripcion, String rfc) {
        this.monto = monto;
        this.descripcion = descripcion;
        // Si el RFC es null, se usa Optional.empty()
        this.rfc = Optional.ofNullable(rfc);
    }

    // ✅ Método público que devuelve el resumen
    public String getResumen() {
        StringBuilder resumen = new StringBuilder();
        resumen.append("📄 Factura generada:\n");
        resumen.append("Descripción: ").append(descripcion).append("\n");
        resumen.append("Monto: $").append(monto).append("\n");

        // Mostrar RFC si está presente
        if (rfc.isPresent()) {
            resumen.append("RFC: ").append(rfc.get()).append("\n");
        } else {
            resumen.append("RFC: [No proporcionado]\n");
        }

        return resumen.toString();
    }
}
