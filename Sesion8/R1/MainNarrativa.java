package Sesion8.R1;

public class MainNarrativa {
    private final TransicionHistoria transicion;
    private final GestorDialogo dialogo;
    private final LogicaDecision decision;

    public MainNarrativa(TransicionHistoria transicion, GestorDialogo dialogo, LogicaDecision decision) {
        this.transicion = transicion;
        this.dialogo = dialogo;
        this.decision = decision;
    }

    public void iniciarEscena() {
        dialogo.mostrarDialogo("Narrador", "Estás parado frente a un bosque oscuro y misterioso.");
        dialogo.mostrarDialogo("Narrador", "Una voz interior te pregunta qué hacer...");

        String eleccion = decision.tomarDecision();

        transicion.siguienteEscena(eleccion);
        dialogo.mostrarDialogo("Narrador", "Fin de la escena.");
    }

    public static void main(String[] args) {
        TransicionHistoria transicion = new TransicionSimple();
        GestorDialogo dialogo = new DialogoTexto();
        LogicaDecision decision = new DecisionBinaria();

        MainNarrativa narrativa = new MainNarrativa(transicion, dialogo, decision);
        narrativa.iniciarEscena();
    }
}
