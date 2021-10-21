public class PessoaJuridica extends Cliente{

    private String CNPJ;
    private String razaoSocial;
    private String nomeFantasia;

    public PessoaJuridica(int idCliente, String endereco, String estado, String cidade, String telefone, String email, String CNPJ, String razaoSocial, String nomeFantasia) {
        super(idCliente, endereco, estado, cidade, telefone, email);
        this.CNPJ = CNPJ;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;
    }

    public String getCNPJ() {
        return this.CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getRazaoSocial() {
        return this.razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return this.nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }
    
}
