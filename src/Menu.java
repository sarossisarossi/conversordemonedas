import java.util.*;

public class Menu {
    private final Map<Integer, String> opciones;
    private int contador;

    public Menu() {
        opciones = new TreeMap<>();
        contador = 1;
    }


    public void agregarOpcion(String moneda1, String moneda2) {
        String detalle1 = Monedas.monedas_es.getOrDefault(moneda1, moneda1);
        String detalle2 = Monedas.monedas_es.getOrDefault(moneda2, moneda2);
        String descripcion = "Convertir de " + detalle1 + " a " + detalle2;

        while (opciones.containsKey(contador)) {
            contador++;
        }
        opciones.put(contador, descripcion);
    }

    public void mostrarOpciones() {
        for (Map.Entry<Integer, String> entry : opciones.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue());
        }
    }
}
