import java.util.Scanner;

public class ConversorMoedas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Conversor conversor = new Conversor();
        boolean continuar = true;

        while (continuar) {
            try {
                conversor.menuConvertor(scanner);

                if (conversor.getMoedaBaseNumero() == 7 || conversor.getMoedaConvertidaNumero() == 7) {
                    continuar = false;
                    System.out.println("Encerrando o conversor...");
                }

            } catch (Exception e) {
                System.out.println("Erro na conversão. Tente novamente.");
                e.printStackTrace();
            }
        }

        scanner.close();
    }
}



