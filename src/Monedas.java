import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;



public class Monedas {
    public static final Map<String, String> monedas_es = new HashMap<>();

    public static void cargarDesdeCSV(String rutaArchivo) {
        try (BufferedReader br = new BufferedReader( new InputStreamReader(new FileInputStream(rutaArchivo), StandardCharsets.UTF_8))) {
            String linea;
            boolean esPrimera = true;
            while ((linea = br.readLine()) != null) {
                if (esPrimera) {
                    esPrimera = false; // saltar encabezado
                    continue;
                }
                System.out.println(linea.toString());
                String[] partes = linea.split(";", 2);
                if (partes.length == 2) {
                    monedas_es.put(partes[0].trim(), partes[1].trim());
                    System.out.println(partes[0]);
                    System.out.println(partes[1]);
                }
            }
        } catch (IOException e) {
            System.out.println("Error leyendo archivo: " + e.getMessage());
        }
    }
}
