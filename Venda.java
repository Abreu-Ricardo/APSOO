import java.util.Date;

public class Venda {

    private Date date;
    private int idVenda;
    private int idFuncionario;
    private String situacao;
    private Carro carroDaVenda;
    private Cliente clienteDaVenda;
    private Funcionario funcionarioDaVenda;


    public Venda(Date date, int idVenda, int idFuncionario, String situacao, Carro carroDaVenda, Cliente clienteDaVenda, Funcionario funcionarioDaVenda) {
        this.date = date;
        this.idVenda = idVenda;
        this.idFuncionario = idFuncionario;
        this.situacao = situacao;
        this.carroDaVenda = carroDaVenda;
        this.clienteDaVenda = clienteDaVenda;
        this.funcionarioDaVenda = funcionarioDaVenda;
    }

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getIdVenda() {
		return this.idVenda;
	}

	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
	}

	public int getIdFuncionario() {
		return this.idFuncionario;
	}

	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public String getSituacao() {
		return this.situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Carro getCarroDaVenda() {
		return this.carroDaVenda;
	}

	public void setCarroDaVenda(Carro carroDaVenda) {
		this.carroDaVenda = carroDaVenda;
	}

	public Cliente getClienteDaVenda() {
		return this.clienteDaVenda;
	}

	public void setClienteDaVenda(Cliente clienteDaVenda) {
		this.clienteDaVenda = clienteDaVenda;
	}

	public Funcionario getFuncionarioDaVenda() {
		return this.funcionarioDaVenda;
	}

	public void setFuncionarioDaVenda(Funcionario funcionarioDaVenda) {
		this.funcionarioDaVenda = funcionarioDaVenda;
	}

    public String pedidoRealizado(Date data, int tipoPagamento, boolean situacao){
        //A ser implementado

		return "a";
    }
    
}
