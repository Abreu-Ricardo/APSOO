import java.util.Date;

public class Funcionario {
  
    private String CPF;
    private String nome;
    private String telefone;
    private String email;

    public Funcionario(String CPF, String nome, String telefone, String email) {
        this.CPF = CPF;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }


    public String getCPF() {
        return this.CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void realizaPedido(String CPF, String CNPJ, int carro, int idFuncionario, Date dataVenda,int tipoPagamento, double valorCarro){  //tem uma coisa meio estranha aqui quanto ao id do carro que acho q deveria ser placa
        //Precisa ser implementado
    }

    public void agendarTestDrive(Carro carro, Cliente cliente, Date data){
        //A ser implementado
    }

    public void inserirCliente(Cliente cliente){
        //A ser implementado
    }

    public void deletaCliente(Cliente cliente){
        //A ser implementado
    }

    public void deletaCarro(Carro carro){
        //A ser implementado
    }

    public void insereVenda(Venda venda){
        //A ser implementado
    }






}
