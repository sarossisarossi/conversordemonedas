import com.google.gson.JsonObject;
import java.util.*;



public class Menu {
    private final Map<Integer, String> opciones;
    private int contador;
    private final Map<Integer, String[]> conversiones;

    public Menu() {
        opciones = new TreeMap<>();
        conversiones = new HashMap<>();
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
        conversiones.put(contador, new String[]{moneda1, moneda2});
    }

    public void mostrarOpciones() {
        System.out.println("***********************************************************");
        System.out.println("Sea bienvenido al Conversor de Monedas =)\n");

        for (Map.Entry<Integer, String> entry : opciones.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue());
        }
        System.out.println("\n***********************************************************");
    }

    public void agregarOpcionSalida() {
        while (opciones.containsKey(contador)) {
            contador++;
        }
        opciones.put(contador, "Salir del conversor");
    }

    public void ejecutarMenu() {
        Scanner scanner = new Scanner(System.in);
        int seleccion;

        while (true) {
            mostrarOpciones();

            System.out.print("¿Qué opción de conversión desea? Ingrese el número: ");
            String input = scanner.nextLine();

            try {
                seleccion = Integer.parseInt(input);

                if (opciones.containsKey(seleccion)) {
                    String descripcion = opciones.get(seleccion);
                    System.out.println("Usted seleccionó: " + descripcion);
                    String[] monedasSeleccionadas = conversiones.get(seleccion);
                    String moneda1 = monedasSeleccionadas[0];
                    String moneda2 = monedasSeleccionadas[1];
                    String detalle1 = Monedas.monedas_es.getOrDefault(moneda1, moneda1);
                    String detalle2 = Monedas.monedas_es.getOrDefault(moneda2, moneda2);
                    // Obtener tipo de cambio
                    CurrencyConverter converter = new CurrencyConverter();
                    JsonObject data = converter.getCurrencyData(moneda1);  // Supongo que trae todas contra moneda2
                    Double tipoCambio = converter.monedas.get(moneda2);
                    if (tipoCambio == 0.0) {
                        System.out.println("No se pudo obtener el tipo de cambio para esta conversión.");

                    }

                    // Mostrar resultado
                    System.out.print("¿Cuántos " + detalle1 + " quiere comprar con " + detalle2 + "? ");
                    double cantidad = Double.parseDouble(scanner.nextLine());

                    double monedaSalida = cantidad * tipoCambio;

                    System.out.printf("Requiere %.2f %s para comprar %.2f %s.%n", monedaSalida, detalle2, cantidad, detalle1);

                    if (descripcion.equalsIgnoreCase("Salir del conversor")) {
                        System.out.println("Gracias por usar el conversor. ¡Hasta pronto!");
                        break;
                    }

                    // Aquí podrías agregar la lógica de conversión real:
                    // convertir(monedaOrigen, monedaDestino);
                } else {
                    System.out.println("Opción inválida. Por favor, intente nuevamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Ingrese un número.");
            }
        }
    }

}
