public class Gerente extends Funcionario {

    private int idGerente;

    public Gerente(String CPF, String nome, String telefone, String email, int idGerente) {
        super(CPF,nome,telefone,email);
        this.idGerente = idGerente;
    }


    public int getIdGerente() {
        return this.idGerente;
    }

    public void setIdGerente(int idGerente) {
        this.idGerente = idGerente;
    }

    public void emitirRelatorioDeVendas(){
        //A ser implementado
    }

    public void emitirRelatorioDeCarros(){
        //A ser implementado
    }

    public void emitirRelatorioDeFuncionarios(){
        //A ser implementado
    }
    
    public void inserirFuncionario(Funcionario funcionario){
        //A ser implementado
    }

    public void deletaFuncionario(Funcionario funcionario){
        //A ser implementado
    }



}
