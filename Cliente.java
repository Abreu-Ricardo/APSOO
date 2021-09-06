public class Cliente{


    private String cpf;
    private String Nome;
    private String Rua;
    private int numero;
    private String Bairro;
    private String Cidade;
    private String uf;
    private String telefone;
    private String email;


    public Cliente(String cpf, String nome, String rua, int numero, String bairro, String cidade, String uf,
    String telefone, String email) {
        this.cpf = cpf;
        this.Nome = nome;
        this.Rua = rua;
        this.numero = numero;
        this.Bairro = bairro;
        this.Cidade = cidade;
        this.uf = uf;
        this.telefone = telefone;
        this.email = email;
    }


    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return this.Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getRua() {
        return this.Rua;
    }

    public void setRua(String Rua) {
        this.Rua = Rua;
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return this.Bairro;
    }

    public void setBairro(String Bairro) {
        this.Bairro = Bairro;
    }

    public String getCidade() {
        return this.Cidade;
    }

    public void setCidade(String Cidade) {
        this.Cidade = Cidade;
    }

    public String getUf() {
        return this.uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
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



}