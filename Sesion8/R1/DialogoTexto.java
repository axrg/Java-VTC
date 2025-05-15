package Sesion8.R1;

public class DialogoTexto implements GestorDialogo {
    @Override
    public void mostrarDialogo(String personaje, String texto) {
        System.out.println(personaje + ": " + texto);
    }
}
