public class Pagamento {

    private double valor;
    private int tipoDePagamento;
    private double desconto;
    private int idVenda;

    public Pagamento(double valor, int tipoDePagamento, double desconto, int idVenda) {
        this.valor = valor;
        this.tipoDePagamento = tipoDePagamento;
        this.desconto = desconto;
        this.idVenda = idVenda;
    }

 

    public int getIdVenda() {
        return this.idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
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

    public double calculaDesconto(String credencial, double valorCarro, int tipoPagamento){
        //A ser implementado

        if(tipoPagamento==2 && credencial.length()==14){
            valorCarro = valorCarro - (0.10 * valorCarro);
        }else{
            valorCarro = 0.0;
        }

        this.desconto = 0.10 * valorCarro;

        return valorCarro;
    }

    public boolean registraPagamento(int tipoPagamento, double valorCarro, double desconto){
        //A ser implementado

        return true;
    }


    
}
