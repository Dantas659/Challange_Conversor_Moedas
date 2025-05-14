import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import com.google.gson.Gson;

public class ConversorMoedas extends Conversor {
    public static void main(String[] args) throws IOException, InterruptedException {

          System.out.println("Olá, seja muito bem-vindo ao conversor de moedas!");

        Scanner scanner = new Scanner(System.in);

        System.out.println("""
            Digite o número que corresponde à moeda que você deseja converter:

            (1) ARS - Peso argentino
            (2) BOB - Boliviano boliviano
            (3) BRL - Real brasileiro
            (4) CLP - Peso chileno
            (5) COP - Peso colombiano
            (6) USD - Dólar americano
            (7) Sair
        """);

        int moedaBaseNumero = scanner.nextInt();

        System.out.println("""
            Escolha a moeda para a qual deseja converter:

            (1) ARS - Peso argentino
            (2) BOB - Boliviano boliviano
            (3) BRL - Real brasileiro
            (4) CLP - Peso chileno
            (5) COP - Peso colombiano
            (6) USD - Dólar americano
            (7) Sair
        """);

        int moedaConvertidaNumero = scanner.nextInt();

        System.out.println("Digite o valor que deseja converter:");
        double valorParaConverter = scanner.nextDouble();

        scanner.close();

        // Converter número em sigla
        String moedaBase = getCodigoMoeda(moedaBaseNumero);
        String moedaConvertida = getCodigoMoeda(moedaConvertidaNumero);

        if (moedaBase.equals("EXIT") || moedaConvertida.equals("EXIT")) {
            System.out.println("Encerrando o programa...");
            return;
        }

        // Cria o cliente HTTP
        HttpClient client = HttpClient.newHttpClient();

        // Monta a URL com as moedas
        String url = "https://v6.exchangerate-api.com/v6/e47368b602e21b5295bbeaeb/pair/" + moedaBase + "/" + moedaConvertida;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        // Envia a requisição e recebe a resposta
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        ConversorRecord respostaApi = gson.fromJson(response.body(), ConversorRecord.class);
        System.out.println(respostaApi.conversion_rate());
        double valorConvertido = valorParaConverter * Double.parseDouble(respostaApi.conversion_rate());
        System.out.println("Resultado da conversão" + valorConvertido);
        
        
    }

    public static String getCodigoMoeda(int opcao) {
        return switch (opcao) {
            case 1 -> "ARS";
            case 2 -> "BOB";
            case 3 -> "BRL";
            case 4 -> "CLP";
            case 5 -> "COP";
            case 6 -> "USD";
            default -> "EXIT"; // Para sair ou opção inválida
        };
    }
    

    

        
}

