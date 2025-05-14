import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import com.google.gson.Gson;

public class Conversor {
    private int moedaBaseNumero;
    private int moedaConvertidaNumero;
    private String moedaBase;
    private String moedaConvertida;
    private double valorParaConverter;
    private double valorConvertido;
    private double taxaDeConversao;

    public int getMoedaBaseNumero() {
         return moedaBaseNumero; }
    public int getMoedaConvertidaNumero() { 
        return moedaConvertidaNumero; }
    public String getMoedaBase() { 
        return moedaBase; }
    public String getMoedaConvertida() {
         return moedaConvertida; }
    public double getValorParaConverter() { 
        return valorParaConverter; }
    public double getValorConvertido() { 
        return valorConvertido; }
    public double getTaxaDeConversao() {
         return taxaDeConversao; }

    public void menuConvertor(Scanner scanner) throws IOException, InterruptedException {
        System.out.println("""

        
            Olá, seja muito bem-vindo ao conversor de moedas!

            Digite o número que corresponde à moeda que você deseja converter:

            (1) ARS - Peso argentino
            (2) BOB - Boliviano boliviano
            (3) BRL - Real brasileiro
            (4) CLP - Peso chileno
            (5) COP - Peso colombiano
            (6) USD - Dólar americano
            (7) Sair
        """);

        this.moedaBaseNumero = scanner.nextInt();

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

        this.moedaConvertidaNumero = scanner.nextInt();

        if (this.moedaBaseNumero == 7 || this.moedaConvertidaNumero == 7) {
            System.out.println("Encerrando o programa...");
            return;
        }

        System.out.println("Digite o valor que deseja converter:");
        this.valorParaConverter = scanner.nextDouble();

        this.moedaBase = getCodigoMoeda(this.moedaBaseNumero);
        this.moedaConvertida = getCodigoMoeda(this.moedaConvertidaNumero);

        HttpClient client = HttpClient.newHttpClient();
        String url = "https://v6.exchangerate-api.com/v6/e47368b602e21b5295bbeaeb/pair/" + moedaBase + "/" + moedaConvertida;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        ConversorRecord respostaApi = gson.fromJson(response.body(), ConversorRecord.class);

        this.taxaDeConversao = Double.parseDouble(respostaApi.conversion_rate());
        this.valorConvertido = valorParaConverter * taxaDeConversao;

        System.out.println("Resultado da conversão: " + valorConvertido);
    }

    public static String getCodigoMoeda(int opcao) {
        return switch (opcao) {
            case 1 -> "ARS";
            case 2 -> "BOB";
            case 3 -> "BRL";
            case 4 -> "CLP";
            case 5 -> "COP";
            case 6 -> "USD";
            default -> "EXIT";
        };
    }
}

    