package One.Sesion4.R1;

import java.util.Objects;

public class Factura {
    private String folio;
    private String cliente;
    private double total;

    // Constructor
    public Factura(String folio, String cliente, double total) {
        this.folio = folio;
        this.cliente = cliente;
        this.total = total;
    }

    // Método toString()
    @Override
    public String toString() {
        return "🧾 Factura [folio=" + folio + ", cliente=" + cliente + ", total=$" + total + "]";
    }

    // Método equals() - compara solo el folio
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Factura)) return false;
        Factura otra = (Factura) obj;
        return Objects.equals(this.folio, otra.folio);
    }

    // Método hashCode() basado solo en el folio
    @Override
    public int hashCode() {
        return Objects.hash(folio);
    }
}
