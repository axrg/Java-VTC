package One.Sesion8.R1;

public class TransicionSimple implements TransicionHistoria {
    @Override
    public void siguienteEscena(String decision) {
        if (decision.equalsIgnoreCase("A")) {
            System.out.println("Transición: Entras en el bosque oscuro...");
        } else {
            System.out.println("Transición: Decides regresar al pueblo.");
        }
    }
}
