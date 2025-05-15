package Sesion5.R1;

// Operador.java
public class Operador {
    private String nombre;

    public Operador(String nombre) {
        this.nombre = nombre;
    }

    public void reportarse() {
        System.out.println("👷 Operador " + nombre + " reportándose.");
    }
}
