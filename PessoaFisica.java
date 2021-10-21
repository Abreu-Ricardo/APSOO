public class PessoaFisica extends Cliente{

    private String CPF;
    private String nome;

    public PessoaFisica(int idCliente, String endereco, String estado, String cidade,String telefone, String email, String CPF, String nome) {
        super(idCliente,endereco,estado,cidade,telefone,email);
        this.CPF = CPF;
        this.nome = nome;
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
    
}
