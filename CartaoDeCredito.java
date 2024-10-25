public class CartaoDeCredito {
    private String numero;
    private String nomeTitular;
    private String cpfTitular;
    private float limite;
    private float saldo;
    private float taxaDeCashback;

    public CartaoDeCredito(String numero, String nomeTitular, float limite) {
        this.numero = numero;
        this.nomeTitular = nomeTitular;
        this.limite = limite;
        this.saldo = limite;
        this.taxaDeCashback = 0.0f; 
    }

    public CartaoDeCredito(String numero, String nomeTitular, String cpfTitular, float limite) {
        this.numero = numero;
        this.nomeTitular = nomeTitular;
        this.cpfTitular = cpfTitular;
        this.limite = limite;
        this.saldo = limite;
        this.taxaDeCashback = 0.0f; 
    }

    public CartaoDeCredito(String numero, String nomeTitular, String cpfTitular, float limite, float taxaDeCashback) {
        this.numero = numero;
        this.nomeTitular = nomeTitular;
        this.cpfTitular = cpfTitular;
        this.limite = limite;
        this.saldo = limite;
        this.taxaDeCashback = taxaDeCashback;
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

    public boolean realizarTransacao(float valor, boolean comCashback) {
        if (comCashback && taxaDeCashback > 0) {
            float valorComCashback = valor * (1 - taxaDeCashback);
            return realizarTransacao(valorComCashback);
        }
        return realizarTransacao(valor);
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

    public float getTaxaDeCashback() {
        return taxaDeCashback;
    }

    public void setTaxaDeCashback(float taxaDeCashback) {
        this.taxaDeCashback = taxaDeCashback;
    }

    public float consultarSaldo() {
        return saldo;
    }

    public float consultarLimite() {
        return limite;
    }
}
