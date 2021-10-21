import java.util.Date;

public class Funcionario {
  
    private String CPF;
    private String nome;
    private String telefone;
    private String email;

    @Override
    public String toString() {
        return "{" +
            " CPF='" + getCPF() + "'" +
            ", nome='" + getNome() + "'" +
            ", telefone='" + getTelefone() + "'" +
            ", email='" + getEmail() + "'" +
            "}";
    }

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

    public void realizaPedido(String CPF, String CNPJ, Carro carro, String idFuncionario, Date dataVenda,int tipoPagamento, float valorCarro){  //tem uma coisa meio estranha aqui quanto ao id do carro que acho q deveria ser placa
        //Precisa ser implementado

        SisVendaDeCarros control = new SisVendaDeCarros();

        String nomeFuncionario = null;
        String nomeCliente = null;
        String credencialCliente = null;

        //Passo 2 Diagrama de comunicação
        nomeFuncionario = control.buscarFuncionario(idFuncionario);
        
        //Passo 3 Diagrama de comunicação
        if(CPF.length()==11){
            nomeCliente = control.buscarPessoa(CPF);
            credencialCliente = CPF;
        }else{
            nomeCliente = control.buscarPessoa(CNPJ);
            credencialCliente = CNPJ;
        }

        System.out.println(nomeFuncionario);
        System.out.println(nomeCliente);

        //Passo 4 Diagrama de comunicação
        if(nomeFuncionario != null && nomeCliente != null){
            String situacao = "Em andamento";

            Cliente clienteDaOperacao = control.getCliente(credencialCliente);

            System.out.println("Cliente da operação: ");
            System.out.println(clienteDaOperacao.toString());

            Venda vendaRealizada = new Venda(dataVenda, SisVendaDeCarros.idVenda, idFuncionario, situacao, carro, clienteDaOperacao, this);
            
            System.out.println("Venda da operação: ");
            System.out.println(vendaRealizada.toString());
            
        
            Pagamento pagamentoDaOperacao = new Pagamento(valorCarro, tipoPagamento, 0.0);
            
            double desconto = pagamentoDaOperacao.calculaDesconto(credencialCliente, valorCarro, tipoPagamento);

            System.out.println("Valor do carro com desconto: ");
            System.out.println(desconto);


            control.insereVenda(vendaRealizada);

            



            situacao = "Pedido finalizado";

            vendaRealizada.pedidoRealizado(dataVenda, tipoPagamento, situacao);

            System.out.println("Compra depois de finalizada: ");
            System.out.println(vendaRealizada.toString());


        
            SisVendaDeCarros.idVenda = SisVendaDeCarros.idVenda + 1;
        }   





        if(credencialCliente.length()==14){

        }
        



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
