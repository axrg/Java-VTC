package Sesion4.R1;

public class Principal {
    public static void main(String[] args) {
        // Crear dos facturas con el mismo folio
        Factura f1 = new Factura("FAC001", "Juan Pérez", 1450.0);
        Factura f2 = new Factura("FAC001", "Comercial XYZ", 1450.0);

        // Mostrar las facturas
        System.out.println(f1);
        System.out.println(f2);

        // Comparar con equals()
        System.out.println("¿Las facturas son iguales?: " + f1.equals(f2));
    }
}
