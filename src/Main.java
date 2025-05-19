import com.google.gson.JsonObject;

public class Main {
    public static void main(String[] args) {


            System.out.printf("Hello and welcome!");
            CurrencyConverter converter = new CurrencyConverter();
            JsonObject data = converter.getCurrencyData("USD");

            System.out.println(converter.ultimaConsultaExitosa.toString());
            System.out.println(converter.monedas.get("MOP"));
            Monedas.cargarDesdeCSV("src/monedas.csv");
            Menu menu = new Menu();
            menu.agregarOpcion("USD", "CLP");
            menu.agregarOpcion("EUR", "MXN");
            menu.mostrarOpciones();

    }
}