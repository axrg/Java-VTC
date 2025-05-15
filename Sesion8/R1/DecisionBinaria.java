package Sesion8.R1;

import java.util.Scanner;

public class DecisionBinaria implements LogicaDecision {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String tomarDecision() {
        System.out.println("¿Qué decides hacer? (A: Entrar al bosque / B: Regresar al pueblo)");
        String input = scanner.nextLine().trim().toUpperCase();
        while (!input.equals("A") && !input.equals("B")) {
            System.out.println("Opción inválida. Intenta de nuevo (A/B):");
            input = scanner.nextLine().trim().toUpperCase();
        }
        return input;
    }
}
