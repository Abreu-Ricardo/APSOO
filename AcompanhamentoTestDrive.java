public class AcompanhamentoTestDrive {

    private String cpfFuncionario;
    private String estadoCarroChegada;


    public AcompanhamentoTestDrive(String cpfFuncionario, String estadoCarroChegada) {
        this.cpfFuncionario = cpfFuncionario;
        this.estadoCarroChegada = estadoCarroChegada;
    }
    
    public String getCpfFuncionario() {
        return this.cpfFuncionario;
    }

    public void setCpfFuncionario(String cpfFuncionario) {
        this.cpfFuncionario = cpfFuncionario;
    }

    public String getEstadoCarroChegada() {
        return this.estadoCarroChegada;
    }

    public void setEstadoCarroChegada(String estadoCarroChegada) {
        this.estadoCarroChegada = estadoCarroChegada;
    }

}
