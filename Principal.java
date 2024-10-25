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
        
        System.out.print("Limite do Cartão (use vírgula para decimal): ");
        float limite = Float.parseFloat(scanner.nextLine().replace(",", "."));

        System.out.print("Deseja adicionar uma taxa de cashback? (1 para sim, 0 para não): ");
        int respostaCashback = Integer.parseInt(scanner.nextLine());
        float taxaDeCashback = 0.0f;
        
        if (respostaCashback == 1) {
            System.out.print("Taxa de Cashback (use vírgula para decimal, ex: 0,05 para 5%): ");
            taxaDeCashback = Float.parseFloat(scanner.nextLine().replace(",", "."));
        }

        CartaoDeCredito cartao;
        if (respostaCashback == 1) {
            cartao = new CartaoDeCredito(numero, nomeTitular, cpfTitular, limite, taxaDeCashback);
        } else {
            cartao = new CartaoDeCredito(numero, nomeTitular, cpfTitular, limite);
        }

        int opcao = 0;
        while (opcao != 5) {
            System.out.println("\nMenu:");
            System.out.println("1 - Realizar Transação Básica");
            System.out.println("2 - Realizar Transação com Cashback");
            System.out.println("3 - Consultar Limite");
            System.out.println("4 - Consultar Saldo");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    System.out.print("Valor da Transação (use vírgula para decimal): ");
                    float valor = Float.parseFloat(scanner.nextLine().replace(",", "."));
                    if (cartao.realizarTransacao(valor)) {
                        System.out.println("Transação básica realizada com sucesso!");
                    } else {
                        System.out.println("Saldo insuficiente.");
                    }
                    break;
                case 2:
                    System.out.print("Valor da Transação com Cashback (use vírgula para decimal): ");
                    valor = Float.parseFloat(scanner.nextLine().replace(",", "."));
                    if (cartao.realizarTransacao(valor, true)) {
                        System.out.println("Transação com cashback realizada com sucesso!");
                    } else {
                        System.out.println("Saldo insuficiente.");
                    }
                    break;
                case 3:
                    System.out.println("Limite disponível: R$" + cartao.consultarLimite());
                    break;
                case 4:
                    System.out.println("Saldo disponível: R$" + cartao.consultarSaldo());
                    break;
                case 5:
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
