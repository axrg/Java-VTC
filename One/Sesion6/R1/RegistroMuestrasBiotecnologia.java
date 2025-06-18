package One.Sesion6.R1;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Scanner;

public class RegistroMuestrasBiotecnologia {

    public static void main(String[] args) {
        // Paso 1: ArrayList para registrar todas las especies en orden de llegada
        ArrayList<String> listaMuestras = new ArrayList<>();
        listaMuestras.add("Homo sapiens");
        listaMuestras.add("Mus musculus");
        listaMuestras.add("Arabidopsis thaliana");
        listaMuestras.add("Homo sapiens"); // muestra replicada

        // Paso 2: HashSet para filtrar especies únicas
        HashSet<String> especiesUnicas = new HashSet<>(listaMuestras);

        // Paso 3: HashMap para asociar ID de muestra con investigador
        HashMap<String, String> muestraInvestigador = new HashMap<>();
        muestraInvestigador.put("M-001", "Dra. López");
        muestraInvestigador.put("M-002", "Dr. Hernández");
        muestraInvestigador.put("M-003", "Mtra. García");

        // Paso 4: Mostrar resultados
        System.out.println("📋 Lista de muestras en orden de llegada:");
        for (String especie : listaMuestras) {
            System.out.println("- " + especie);
        }

        System.out.println("\n🧬 Especies únicas procesadas:");
        for (String especieUnica : especiesUnicas) {
            System.out.println("- " + especieUnica);
        }

        System.out.println("\n🧑‍🔬 Relación ID de muestra → Investigador:");
        for (String id : muestraInvestigador.keySet()) {
            System.out.println(id + " → " + muestraInvestigador.get(id));
        }

        // Búsqueda por ID
        System.out.println("\n🔍 Buscar investigador por ID de muestra");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa un ID de muestra (ej. M-002): ");
        String idBusqueda = scanner.nextLine();

        if (muestraInvestigador.containsKey(idBusqueda)) {
            System.out.println("👤 Investigador responsable: " + muestraInvestigador.get(idBusqueda));
        } else {
            System.out.println("⚠️ ID de muestra no encontrado.");
        }

        scanner.close();
    }
}