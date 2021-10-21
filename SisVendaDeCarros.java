import java.util.ArrayList;



public class SisVendaDeCarros {
    
    
    static int idVenda = 0;

    public String buscarPessoa(String credencial){
        //Precisa ser implementado

        ClienteDAO clienteDao = new ClienteDAO();

        String nome = clienteDao.buscaPessoaBanco(credencial);

        return nome;
    }

    public ArrayList<String> buscaMarcasCarros(){
        //Precisa ser implementado

        CarroDAO carroDao = new CarroDAO();

        ArrayList<String> listaMarcas = new ArrayList<String>();

        listaMarcas = carroDao.buscaMarcasCarrosBanco();

        return listaMarcas;
    }

    public ArrayList<String> buscaModelosCarros(String marcaCarro){
        //Precisa ser implementado
        CarroDAO carroDao = new CarroDAO();

        ArrayList<String> listaModelos = new ArrayList<String>();

        listaModelos = carroDao.buscaModelosCarrosBanco(marcaCarro);

        return listaModelos;
    }

    public ArrayList<String> buscaCoresCarros(String modeloCarro){
        //Precisa ser implementado
        CarroDAO carroDao = new CarroDAO();

        ArrayList<String> listaDeCores = new ArrayList<String>();

        listaDeCores = carroDao.buscaCoresCarrosBanco(modeloCarro);

        return listaDeCores;
    }

    public float calculaValor(String modeloCarro,String marcaCarro,String corCarro){
        //Precisa ser implementado

        CarroDAO carroDao = new CarroDAO();

        float ret = carroDao.calculaValorBanco(modeloCarro, marcaCarro, corCarro);

        return ret;
    }

    public String buscarFuncionario(String idFuncionario){
        //Precisa ser implementado

        FuncionarioDAO funcionarioDao = new FuncionarioDAO();

        String ret = funcionarioDao.buscarFuncionarioBanco(idFuncionario);


        return ret;
    }

    public ArrayList<String> listarFormasPagamento(){
        //A ser implementado

        ArrayList<String> cars = new ArrayList<String>(); 
        return cars;
    }

    public ArrayList<String> emitirRelatorioVenda(){
        //Precisa ser implementado (eu acho)

        ArrayList<String> cars = new ArrayList<String>(); 
        return cars;
    }

    public ArrayList<String> pegaCpfFuncionarios(){
        //Precisa ser implementado (eu acho)
        FuncionarioDAO fDao = new FuncionarioDAO();

        ArrayList<String> listaCpf = new ArrayList<String>();

        listaCpf = fDao.buscaCpfFuncionarios();
        
        return listaCpf;
    }

    public String buscaPlacaCarro(String opcaoMarca, String opcaoModelo, String opcaoCor){

        CarroDAO cDao = new CarroDAO();

        String ret = cDao.buscaPlacaCarroBanco(opcaoMarca,opcaoModelo,opcaoCor);


        return ret;

    }

    public ArrayList<String> pegaInfoFuncionarios(String credencial){
        //Precisa ser implementado (eu acho)
        FuncionarioDAO fDao = new FuncionarioDAO();

        ArrayList<String> listaInfo = new ArrayList<String>();

        listaInfo = fDao.pegaInfoFuncionariosBanco(credencial);
        
        return listaInfo;
    }

    public Cliente getCliente(String credencial){

        ClienteDAO cDao = new ClienteDAO();

        Cliente clienteRet = cDao.getClienteBanco(credencial);

        return clienteRet;

    }

    public void insereVenda(Venda venda){

        VendaDAO vDao = new VendaDAO();

        vDao.insereVendaBanco(venda);

    }




    public void inserirFuncionario(Funcionario funcionario){
        //A ser implementado
    }

    public void inserirCarro(Carro carro){
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

    public void deletaFuncionario(Funcionario funcionario){
        //A ser implementado
    }



}
