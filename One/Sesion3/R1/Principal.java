package One.Sesion3.R1;

public class Principal {
    public static void main(String[] args) {
        // Crear pasajero y vuelo
        Pasajero pasajero1 = new Pasajero("Ana Martínez", "P123456");
        Vuelo vuelo = new Vuelo("UX123", "París", "14:30");

        // Reservar asiento
        vuelo.reservarAsiento(pasajero1);

        // Mostrar itinerario
        System.out.println(vuelo.obtenerItinerario());

        // Cancelar reserva
        vuelo.cancelarReserva();

        // Mostrar itinerario después de cancelar
        System.out.println(vuelo.obtenerItinerario());

        // Reservar usando nombre y pasaporte
        vuelo.reservarAsiento("Mario Gonzalez", "P789101");

        // Mostrar itinerario final
        System.out.println(vuelo.obtenerItinerario());
    }
}
