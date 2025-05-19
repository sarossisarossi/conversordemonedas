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
