import java.util.ArrayList;

public class SisVendaDeCarros {
    
    


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

        float a = 0.1f;

        return a;
    }

    public String buscarFuncionario(String idFuncionario){
        //Precisa ser implementado

        return "a";
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

    public void insereVenda(Venda venda){
        //A ser implementado
    }




}
