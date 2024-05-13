import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;
import java.util.Scanner;

import com.google.gson.Gson;

class Converter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Loop principal para permitir múltiples conversiones
        while (true) {
            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create("https://v6.exchangerate-api.com/v6/68416c6baf9d011f71e02e28/latest/USD"))
                        .build();

                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                // Analiza la respuesta JSON utilizando Gson
                Gson gson = new Gson();
                ExchangeRateData exchangeData = gson.fromJson(response.body(), ExchangeRateData.class);

                // Accede a los datos de las tasas de cambio
                System.out.println("Tasas de cambio obtenidas: " + exchangeData.conversion_rates);

                // Filtra las monedas de interés
                System.out.println("Tasas de cambio filtradas:");
                System.out.println("ARS - Peso argentino: " + exchangeData.conversion_rates.getARS());
                System.out.println("BOB - Boliviano boliviano: " + exchangeData.conversion_rates.getBOB());
                System.out.println("BRL - Real brasileño: " + exchangeData.conversion_rates.getBRL());
                System.out.println("USD - Dólar Estadounidense: " + exchangeData.conversion_rates.getUSD());
                // Agrega más monedas según sea necesario

                // Solicitud al usuario para la conversión
                System.out.println("\nIngrese la divisa que quiere convertir (ej. USD):");
                String fromCurrency = scanner.next().toUpperCase();
                System.out.println("Ingrese la cantidad a convertir:");
                double amount = scanner.nextDouble();
                System.out.println("Ingrese a qué divisa del listado quiere convertirla:");
                String toCurrency = scanner.next().toUpperCase();

                // Realiza la conversión
                double fromRate = getRateForCurrency(exchangeData, fromCurrency);
                double toRate = getRateForCurrency(exchangeData, toCurrency);
                double result = (amount / fromRate) * toRate;

                // Muestra el resultado
                System.out.println("\nResultado de la conversión:");
                System.out.println(amount + " " + fromCurrency + " = " + result + " " + toCurrency);

                // Pregunta al usuario si desea hacer otra conversión
                System.out.println("\n¿Desea convertir otra divisa? (si/no)");
                String answer = scanner.next().toLowerCase();
                if (!answer.equals("si")) {
                    System.out.println("Gracias por usar el conversor de divisas. ¡Hasta luego!");
                    break; // Sale del bucle si la respuesta no es "si"
                }

            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
        scanner.close();
    }

    static class ExchangeRateData {
        private ConversionRates conversion_rates;

        public ConversionRates getConversion_rates() {
            return conversion_rates;
        }
    }

    static class ConversionRates {
        private double ARS;
        private double BOB;
        private double BRL;
        private double CLP;
        private double COP;
        private double USD;

        public double getARS() {
            return ARS;
        }

        public double getBOB() {
            return BOB;
        }

        public double getBRL() {
            return BRL;
        }

        public double getCLP() {
            return CLP;
        }

        public double getCOP() {
            return COP;
        }

        public double getUSD() {
            return USD;
        }
    }

    // Método para obtener la tasa de cambio de una divisa específica
    static double getRateForCurrency(ExchangeRateData exchangeData, String currency) {
        switch (currency) {
            case "ARS":
                return exchangeData.conversion_rates.getARS();
            case "BOB":
                return exchangeData.conversion_rates.getBOB();
            case "BRL":
                return exchangeData.conversion_rates.getBRL();
            case "CLP":
                return exchangeData.conversion_rates.getCLP();
            case "COP":
                return exchangeData.conversion_rates.getCOP();
            case "USD":
                return exchangeData.conversion_rates.getUSD();
            default:
                System.out.println("La divisa ingresada no es válida.");
                return 1; // Si la divisa no es válida, se devuelve una tasa de cambio de 1 (no afecta a la conversión)
        }
    }
}
