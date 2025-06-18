package One.Sesion2.R1;
import java.util.Scanner;


public class Principal {
  public static class SimuladorFarmacia {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar datos al usuario
        System.out.print("Nombre del medicamento: ");
        String medicamento = scanner.nextLine();

        System.out.print("Precio unitario: ");
        double precioUnitario = scanner.nextDouble();

        System.out.print("Cantidad de piezas: ");
        int cantidad = scanner.nextInt();

        // Cálculos
        var totalSinDescuento = precioUnitario * cantidad;
        boolean aplicaDescuento = totalSinDescuento > 500.0;
        double descuento = aplicaDescuento ? totalSinDescuento * 0.15 : 0.0;
        double totalPagar = totalSinDescuento - descuento;

        // Mostrar resultados
        System.out.println("\nMedicamento: " + medicamento);
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Precio unitario: $" + precioUnitario);
        System.out.println("Total sin descuento: $" + totalSinDescuento);
        System.out.println("¿Aplica descuento?: " + aplicaDescuento);
        System.out.println("Descuento: $" + descuento);
        System.out.println("Total a pagar: $" + totalPagar);

        scanner.close();
    }  
    }      
}  
