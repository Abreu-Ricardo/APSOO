public class Cliente {
    
    private int idCliente;
    private String endereco;
    private String estado;
    private String cidade;
    private String email;

    public Cliente(int idCliente, String endereco, String estado, String cidade, String email) {
        this.idCliente = idCliente;
        this.endereco = endereco;
        this.estado = estado;
        this.cidade = cidade;
        this.email = email;
    }

    public int getIdCliente() {
        return this.idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return this.cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    

}
