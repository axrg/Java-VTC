package Sesion1.R2;

public class Principal_Record {
     public static void main(String[] args) {
        // 🎁 Crear un objeto usando record
        Entrada_Record entrada3 = new Entrada_Record("Festival de Jazz", 600.0);
        Entrada_Record entrada4 = new Entrada_Record("Stand-Up Comedy", 300.0);

        // Mostrar la información
        entrada3.mostrarInformacion();
        entrada4.mostrarInformacion();
    }   
}
