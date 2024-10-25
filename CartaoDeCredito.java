public class CartaoDeCredito {
    private String numero;
    private String nomeTitular;
    private String cpfTitular;
    private float limite;
    private float saldo;

    public CartaoDeCredito(String numero, String nomeTitular, String cpfTitular, float limite) {
        this.numero = numero;
        this.nomeTitular = nomeTitular;
        this.cpfTitular = cpfTitular;
        this.limite = limite;
        this.saldo = limite;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public String getCpfTitular() {
        return cpfTitular;
    }

    public void setCpfTitular(String cpfTitular) {
        this.cpfTitular = cpfTitular;
    }

    public float getLimite() {
        return limite;
    }

    public void setLimite(float limite) {
        this.limite = limite;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    // Métodos usando Getters e Setters
    public float consultarSaldo() {
        return getSaldo();
    }

    public float consultarLimite() {
        return getLimite();
    }

    public boolean realizarTransacao(float valor) {
        if (valor <= getSaldo()) {
            setSaldo(getSaldo() - valor);
            return true;
        } else {
            System.out.println("Saldo insuficiente.");
            return false;
        }
    }
}
