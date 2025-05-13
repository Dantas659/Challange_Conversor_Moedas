public class ConversorMoedas {
    public static void main(String[] args) {
        System.out.println("Olá, seja muito bem-vindo ao conversor de moedas!");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o valor em reais que deseja converter:");
        double valorBase = scanner.nextDouble();
        System.out.println("Escolha a moeda para a qual deseja converter:");
        double valorConvertido = scanner.nextDouble();
        scanner.close();
    }
    
}
