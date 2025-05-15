import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear objeto de tipo Paciente
        Paciente paciente = new Paciente();

        // 📥 Solicitar datos
        System.out.print("Ingrese el nombre del paciente: ");
        paciente.nombre = scanner.nextLine();

        System.out.print("Ingrese la edad del paciente: ");
        paciente.edad = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        System.out.print("Ingrese el número de expediente: ");
        paciente.numeroExpediente = scanner.nextLine();

        // 📢 Mostrar información
        paciente.mostrarInformacion();

        scanner.close();
    }
}
