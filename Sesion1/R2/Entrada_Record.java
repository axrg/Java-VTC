package Sesion1.R2;

public record Entrada_Record(String nombreEvento, double precio) {
    public void mostrarInformacion() {
        System.out.println("Evento: " + nombreEvento() + " | Precio: $" + precio());
    }
}
