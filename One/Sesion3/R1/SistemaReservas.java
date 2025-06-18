package One.Sesion3.R1;

import java.util.Scanner;

public class SistemaReservas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear vuelo
        System.out.println("✈️ Crear nuevo vuelo:");
        System.out.print("Código del vuelo: ");
        String codigo = scanner.nextLine();
        System.out.print("Destino: ");
        String destino = scanner.nextLine();
        System.out.print("Hora de salida (formato 24h): ");
        String hora = scanner.nextLine();

        Vuelo vuelo = new Vuelo(codigo, destino, hora);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n📋 MENÚ:");
            System.out.println("1. Reservar asiento (pasajero ya creado)");
            System.out.println("2. Mostrar itinerario");
            System.out.println("3. Cancelar reserva");
            System.out.println("4. Reservar asiento ingresando nombre y pasaporte");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del pasajero: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Número de pasaporte: ");
                    String pasaporte = scanner.nextLine();
                    Pasajero pasajero = new Pasajero(nombre, pasaporte);
                    vuelo.reservarAsiento(pasajero);
                    break;

                case 2:
                    System.out.println(vuelo.obtenerItinerario());
                    break;

                case 3:
                    vuelo.cancelarReserva();
                    break;

                case 4:
                    System.out.print("Nombre: ");
                    String nombre2 = scanner.nextLine();
                    System.out.print("Pasaporte: ");
                    String pasaporte2 = scanner.nextLine();
                    vuelo.reservarAsiento(nombre2, pasaporte2);
                    break;

                case 5:
                    System.out.println("👋 ¡Gracias por usar el sistema de reservas!");
                    salir = true;
                    break;

                default:
                    System.out.println("❌ Opción inválida. Intenta de nuevo.");
            }
        }

        scanner.close();
    }
}
