//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import com.google.gson.JsonElement;

public class CurrencyConverter {
    private String apiKey = this.loadApiKeyFromFile("src/apikey.txt");
    private String url;
    public String dateTime;
    public HashMap<String,Double> monedas = new HashMap<>();
    public Boolean ultimaConsultaExitosa;

    private String loadApiKeyFromFile(String filePath) {
        try {
            return (new String(Files.readAllBytes(Paths.get(filePath)))).trim();
        } catch (IOException e) {
            System.err.println("Error reading API key: " + e.getMessage());
            return "";
        }
    }

    public String buildUrl(String baseCode) {
        this.url = "https://v6.exchangerate-api.com/v6/" + this.apiKey + "/latest/" + baseCode;
        System.out.println(this.url);
        return this.url;
    }

    private JsonObject getApiData(String buildUrl) {
        this.buildUrl(buildUrl);
        this.ultimaConsultaExitosa = false;
        try {

            System.out.println("URL construida: " + this.url);
            String urlString = this.url;
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuffer response = new StringBuffer();

            String inputLine;
            while((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            in.close();
            JsonParser parser = new JsonParser();
            JsonObject json = parser.parse(response.toString()).getAsJsonObject();

            if (json.get("result").getAsString().equals("success")) {
                System.err.println("API response was successful.");
                this.ultimaConsultaExitosa = true; // ⬅️ true con minúscula
            }

            if (this.ultimaConsultaExitosa) {
                JsonObject rates = json.getAsJsonObject("conversion_rates");
                for (Map.Entry<String, JsonElement> entry : rates.entrySet()) {
                    String currency = entry.getKey();
                    double value = entry.getValue().getAsDouble();
                    this.monedas.put(currency, value);
                }
            }

            return parser.parse(response.toString()).getAsJsonObject();

        } catch (IOException e) {
            System.err.println("Error fetching data from the API: " + e.getMessage());
            return null;
        }
    }

    public JsonObject getCurrencyData(String buildUrl) {
        this.getApiData(buildUrl);

return null;
    }

    public JsonObject getCurrencyData2(String buildUrl) {
        this.buildUrl(buildUrl);

        try {
            System.out.println("URL construida: ");
            System.out.println("URL construida: " + this.url);
            String urlString = this.url;
            System.out.println("URL construida: " + urlString);
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuffer response = new StringBuffer();

            String inputLine;
            while((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            in.close();
            JsonParser parser = new JsonParser();
            return parser.parse(response.toString()).getAsJsonObject();
        } catch (IOException e) {
            System.err.println("Error fetching data from the API: " + e.getMessage());
            return null;
        }
    }
}
