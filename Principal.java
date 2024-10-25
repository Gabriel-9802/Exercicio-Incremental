import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Número do Cartão: ");
        String numero = scanner.nextLine();
        
        System.out.print("Nome do Titular: ");
        String nomeTitular = scanner.nextLine();
        
        System.out.print("CPF do Titular: ");
        String cpfTitular = scanner.nextLine();
        
        System.out.print("Limite do Cartão: ");
        float limite = scanner.nextFloat();

        CartaoDeCredito cartao = new CartaoDeCredito(numero, nomeTitular, cpfTitular, limite);

        int opcao = 0;
        while (opcao != 4) {
            System.out.println("\nMenu:");
            System.out.println("1 - Realizar Transação");
            System.out.println("2 - Consultar Limite");
            System.out.println("3 - Consultar Saldo");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Valor da Transação: ");
                    float valor = scanner.nextFloat();
                    if (cartao.realizarTransacao(valor)) {
                        System.out.println("Transação realizada com sucesso!");
                    }
                    break;
                case 2:
                    System.out.println("Limite disponível: R$" + cartao.consultarLimite());
                    break;
                case 3:
                    System.out.println("Saldo disponível: R$" + cartao.consultarSaldo());
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
        scanner.close();
    }
}
