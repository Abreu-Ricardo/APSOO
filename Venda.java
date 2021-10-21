import java.util.Date;

public class Venda {

    private Date date;
    private int idVenda;
   	private String idFuncionario;


    private String situacao;
    private Carro carroDaVenda;
    private Cliente clienteDaVenda;
    private Funcionario funcionarioDaVenda;

	@Override
	public String toString() {
		return "{" +
			" date='" + getDate() + "'" +
			", idVenda='" + getIdVenda() + "'" +
			", idFuncionario='" + getIdFuncionario() + "'" +
			", situacao='" + getSituacao() + "'" +
			", carroDaVenda='" + getCarroDaVenda() + "'" +
			", clienteDaVenda='" + getClienteDaVenda() + "'" +
			", funcionarioDaVenda='" + getFuncionarioDaVenda() + "'" +
			"}";
	}


    public Venda(Date date, int idVenda, String idFuncionario, String situacao, Carro carroDaVenda, Cliente clienteDaVenda, Funcionario funcionarioDaVenda) {
        this.date = date;
        this.idVenda = idVenda;
        this.idFuncionario = idFuncionario;
        this.situacao = situacao;
        this.carroDaVenda = carroDaVenda;
        this.clienteDaVenda = clienteDaVenda;
        this.funcionarioDaVenda = funcionarioDaVenda;
    }
	public String getIdFuncionario() {
		return this.idFuncionario;
	}

	public void setIdFuncionario(String idFuncionario) {
		this.idFuncionario = idFuncionario;
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

    public void pedidoRealizado(Date data, int tipoPagamento, String situacao){
        //A ser implementado
		this.situacao = situacao;

		
    }
    
}
