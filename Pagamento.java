public class Pagamento {

    private double valor;
    private int tipoDePagamento;
    private double desconto;

    public Pagamento(double valor, int tipoDePagamento, double desconto) {
        this.valor = valor;
        this.tipoDePagamento = tipoDePagamento;
        this.desconto = desconto;
    }

    public double getValor() {
        return this.valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getTipoDePagamento() {
        return this.tipoDePagamento;
    }

    public void setTipoDePagamento(int tipoDePagamento) {
        this.tipoDePagamento = tipoDePagamento;
    }

    public double getDesconto() {
        return this.desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public double calculaDesconto(String CNPJ, double valorCarro, int tipoPagamento){
        //A ser implementado

        return 0.1;
    }

    public boolean registraPagamento(int tipoPagamento, double valorCarro, double desconto){
        //A ser implementado

        return true;
    }


    
}
