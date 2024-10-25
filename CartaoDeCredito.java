public class CartaoDeCredito {
    public String numero;
    public String nomeTitular;
    public String cpfTitular;
    public float limite;
    public float saldo;

    public CartaoDeCredito(String numero, String nomeTitular, String cpfTitular, float limite) {
        this.numero = numero;
        this.nomeTitular = nomeTitular;
        this.cpfTitular = cpfTitular;
        this.limite = limite;
        this.saldo = limite;
    }

    public float consultarSaldo() {
        return saldo;
    }

    public float consultarLimite() {
        return limite;
    }

    public boolean realizarTransacao(float valor) {
        if (valor <= saldo) {
            saldo -= valor;
            return true;
        } else {
            System.out.println("Saldo insuficiente.");
            return false;
        }
    }
}
