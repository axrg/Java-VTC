package Sesion2.R2;
import java.util.Scanner;

public class CajeroAutomatico {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var saldo = 1000.0; // Inferencia de tipo con var
        int opcion;

        do {
            System.out.println("\nBienvenido al cajero automático");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Depositar dinero");
            System.out.println("3. Retirar dinero");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("💰 Saldo actual: $" + saldo);
                    break;
                case 2:
                    System.out.print("Ingresa el monto a depositar: ");
                    double deposito = scanner.nextDouble();
                    saldo += deposito;
                    System.out.println("✅ Depósito exitoso. Nuevo saldo: $" + saldo);
                    break;
                case 3:
                    System.out.print("Ingresa el monto a retirar: ");
                    double retiro = scanner.nextDouble();
                    if (retiro > saldo) {
                        System.out.println("❌ Saldo insuficiente. No se realizó el retiro.");
                        continue; // vuelve al menú sin ejecutar el resto del switch
                    }
                    saldo -= retiro;
                    System.out.println("✅ Retiro exitoso. Nuevo saldo: $" + saldo);
                    break;
                case 4:
                    System.out.println("👋 Gracias por usar el cajero automático. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("❌ Opción inválida. Intenta de nuevo.");
                    continue; // regresa al menú sin ejecutar break
            }
        } while (opcion != 4);

        scanner.close();
    }
}
