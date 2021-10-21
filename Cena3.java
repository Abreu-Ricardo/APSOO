import javafx.application.Application;
import javafx.event.*;
//import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.stage.Popup;
import javafx.stage.Stage;
import java.util.*;
import javafx.scene.control.*;
import javafx.collections.*;
import javafx.scene.image.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.LocalDateTime; 


public class Cena3{

    SisVendaDeCarros control = new SisVendaDeCarros();

    Stage jan;
    Scene cena3;
    PopUp popup = new PopUp();
    Cena1 c1;
    Cena2 c2;

    String cpfFuncionarioDaOperacao;
    String idEscolhido;
    int tipoPagamentoDaOperacao;


    ComboBox idFuncBox; 


    int flagTipoPagamento;                      // Flag para saber qual opcao de pagamento foi clicada
    String credencialCliente, idCliente,        // Identificacao do cliente
           opcaoMarca, opcaoModelo, opcaoCor;   // Opcoes escolhidas para o carro
           
    

    public Cena3( Cena2 cena2, String credencial, String id, String opMarca, 
                  String opModelo, String opCor) {
        
        c2 = cena2;
        credencialCliente = credencial;
        idCliente = id;
        opcaoMarca = opMarca;
        opcaoModelo = opModelo;
        opcaoCor = opCor;
    }
    

    // Agrupador de radio buttons, com ele garante que apenas
    // um radio button pode ser clicado
    ToggleGroup grupo = new ToggleGroup();

    // RadioButtons criados fora do metodos start para serem usados em outro metodos
    RadioButton pagamentoDinheiro       = new RadioButton("Dinheiro");
    RadioButton pagamentoFinanciamento  = new RadioButton("Financiamento");
    RadioButton pagamentoCartao         = new RadioButton("Cartão");

    public Scene cena3(Stage janela){

        jan = janela;
        jan.setHeight(450);
        jan.setWidth(900);

        GridPane grid3 = new GridPane();
        grid3.setAlignment(Pos.CENTER);
        grid3.setVgap(3);
        grid3.setHgap(5);

        // Carregando a imagem para o programa
        Image calendario    = new Image("images/calendar.png");
        Image idFuncImage   = new Image("images/idFunc.png");
        Image nomeFuncImage = new Image("images/empregado.png");
        //Image valorImage  = new Image("images/valor.png");
        Image valorImage    = new Image("images/valor.png");
        Image tipoPagImage  = new Image("images/pagop.png");

        // Criando a visualizacao da imagem
        ImageView calendarioView = new ImageView(calendario);
        // ImageView nomeFuncView = new ImageView(nomeFuncImage);
        // ImageView valorView = new ImageView(valorImage);
        // ImageView tipoPagView = new ImageView(tipoPagImage);
        ImageView idFuncView     = new ImageView(idFuncImage);
        ImageView nomeFuncView   = new ImageView(nomeFuncImage);
        ImageView valorView      = new ImageView(valorImage);
        ImageView tipoPagView    = new ImageView(tipoPagImage);        



        // Atribuindo o tamanho correto para os icones
        calendarioView.setFitHeight(50);
        calendarioView.setPreserveRatio(true);


        nomeFuncView.setFitHeight(50);
        nomeFuncView.setPreserveRatio(true);


        valorView.setFitHeight(50);
        valorView.setPreserveRatio(true);

        tipoPagView.setFitHeight(50);
        tipoPagView.setPreserveRatio(true);

        idFuncView.setFitHeight(50);
        idFuncView.setPreserveRatio(true);

        // Titulos da cena 3
        // Label tituloRecibo = new Label("Recibo");
        // Label data = new Label("Data:                       ", calendarioView);
        // Label nomeFunc = new Label("Nome do Funcionário:    ", nomeFuncView);
        // Label valor = new Label("valor do carro:            ", valorView);
        // Label tipoPag = new Label("Tipo de Pagamento:       ", tipoPagView);
        Label tituloRecibo  = new Label("Recibo");
        Label data          = new Label("Data:                       ", calendarioView);
        Label idFunc        = new Label("Id do Funcionário:    "      , idFuncView);
        Label nomeFunc      = new Label("Nome do Funcionário:    "    , nomeFuncView);
        Label valor         = new Label("valor do carro:            " , valorView);
        Label tipoPag       = new Label("Tipo de Pagamento:       "   , tipoPagView);

        tituloRecibo.getStyleClass().add("titulo");

        // Criando formatador para a data
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        // Pegando a data atual
        LocalDateTime agr = LocalDateTime.now(); 
        // Salvando numa string para utilizar da interface
        String d = new String(formatador.format(agr));

        // APAGAR
        //System.out.println( t  );
        Label valorData = new Label(d);
        // Pegar o nome do func e por como String
        Label nomeFuncText = new Label("Escolha o id do func");

        // Pegar o cpf do func e por como String

        float valorCarro = control.calculaValor(this.opcaoModelo, this.opcaoMarca, this.opcaoCor);
        Label valortext = new Label(String.valueOf(valorCarro));


        

        // Botoes da cena 3
        // Botoes para andar entre as cenas
        Button next3  = new Button("Next");
        Button volta3 = new Button("Voltar");


        ArrayList<String> listaCpfs = new ArrayList<String>();

        listaCpfs = control.pegaCpfFuncionarios();

        // ComboBox para escolher o idFuncionario
        ObservableList<String> idsFunc = FXCollections.observableArrayList(listaCpfs);
        idFuncBox = new ComboBox(idsFunc);

        idFuncBox.getStyleClass().add("choice-box");


        

        // RadioButton pagamentoDinheiro       = new RadioButton("Dinheiro");
        pagamentoDinheiro.setToggleGroup(grupo);
        pagamentoDinheiro.setOnAction(e -> pegaPagamento(1));

        // RadioButton pagamentoFinanciamento  = new RadioButton("Financiamento");
        pagamentoFinanciamento.setToggleGroup(grupo);
        pagamentoFinanciamento.setOnAction(e -> pegaPagamento(2));


        // RadioButton pagamentoCartao         = new RadioButton("Cartão");
        pagamentoCartao.setToggleGroup(grupo);
        pagamentoCartao.setOnAction(e -> pegaPagamento(3));

        // Colocando o CSS nos botoes
        // radio-buttons
        pagamentoDinheiro.getStyleClass().add("radio-button");     
        pagamentoFinanciamento.getStyleClass().add("radio-button");
        pagamentoCartao.getStyleClass().add("radio-button");

        // No botao next
        next3.getStyleClass().add("next");

        // Acoes dos botoes da cena 2
        volta3.setOnAction(e -> trocaParaCena2());
        next3.setOnAction(e -> voltaParaCena1());
        idFuncBox.setOnAction(e -> pegaIdFunc(nomeFuncText));

        // COLOCAR TITULO
        grid3.add(tituloRecibo, 0, 0);
        // grid3.add(data,         0, 1);
        // grid3.add(nomeFunc,     0, 2);
        // grid3.add(valor,      0, 3);
        // grid3.add(tipoPag,      0, 4);
        grid3.add(valor,        0, 1);
        grid3.add(data,         0, 2);
        grid3.add(idFunc,       0, 3);
        grid3.add(nomeFunc,     0, 4);
        grid3.add(tipoPag,      0, 5);


        grid3.add(nomeFuncText, 1, 4);

        // Colocando botoes
        // grid3.add(next3,  1, 5);
        // grid3.add(volta3, 0, 5);
        grid3.add(next3,  1, 6);
        grid3.add(volta3, 0, 6);



        // Colocando RadioButtons
        //grid3.add(group, 1, 4);
        // grid3.add(pagamentoDinheiro,      1, 4);
        // grid3.add(pagamentoFinanciamento, 2, 4);
        // grid3.add(pagamentoCartao,        3, 4);
        grid3.add(pagamentoDinheiro,      1, 5);
        grid3.add(pagamentoFinanciamento, 2, 5);
        grid3.add(pagamentoCartao,        3, 5);

        // 
        // grid3.add(valorData,    1, 1);
        // grid3.add(nomeFuncText, 1, 2);
        // grid3.add(valortext,  1, 3);

        // Colocando os valores que serao mostrados
        grid3.add(valortext,    1, 1);
        grid3.add(valorData,    1, 2);
        //grid3.add(nomeFuncText, 1, 3);
        grid3.add(idFuncBox,       1, 3);

        cena3 = new Scene(  grid3, 850, 300);
        cena3.getStylesheets().add("estilo.css");

        return cena3;
    }

    public void trocaParaCena2(/*ActionEvent e*/){
        c2 = new Cena2();
        jan.setScene(c2.cena2(jan));   

    }

    public void pegaIdFunc(Label nomeFuncionario){

        // IGOR ******************* IGOR
        // puxar do BD os nomes do funcionarios, o id
        // vai ficar salvo nessa var
        idEscolhido = idFuncBox.getValue().toString();

        this.cpfFuncionarioDaOperacao = idEscolhido;

        String nomeFunc = control.buscarFuncionario(idEscolhido);


        // colocar o nome no setText
        nomeFuncionario.setText(nomeFunc);
    }

    public void pegaPagamento(int formaPag){

        switch (formaPag) {
            case 1:
                System.out.println("Dinheiro clicado");
                this.flagTipoPagamento = 1;
                flagTipoPagamento = 1;
                break;
            
            case 2:
                System.out.println("Financiamento clicado");
                flagTipoPagamento = 2;
                this.flagTipoPagamento = 2;
                break;

            case 3:
                System.out.println("Cartao selecionado");
                this.flagTipoPagamento = 3;
                flagTipoPagamento = 3;
                break;
        
            default:
                break;
        }
    }

    public void voltaParaCena1(){

        switch (flagTipoPagamento) {
            case 1:
                //Pedido realizado vai ser chamado aqui

                //Busca de placa pra instanciar carro
                String placaEscolhida = control.buscaPlacaCarro(opcaoMarca,opcaoModelo,opcaoCor);
                System.out.println(placaEscolhida);

                //Calcular valor para instanciar carro
                float valor = control.calculaValor(opcaoModelo, opcaoMarca, opcaoCor);
                System.out.println(valor);

                //Instanciar carro
                Carro carro = new Carro(placaEscolhida,opcaoMarca,opcaoModelo,opcaoCor,valor);
                
                System.out.println("Carro da operação: ");
                System.out.println(carro.toString());
                
                //Buscar informações do funcionário por ID, para que seja possível chamar o realizarPedido()
                ArrayList<String> infoFuncionario = new ArrayList<String>();
                infoFuncionario = control.pegaInfoFuncionarios(this.cpfFuncionarioDaOperacao);
                Funcionario funcionarioDaOperacao = new Funcionario(infoFuncionario.get(0), infoFuncionario.get(1), infoFuncionario.get(2), infoFuncionario.get(3));
                
                System.out.println("Funcionário da operação: ");
                System.out.println(funcionarioDaOperacao.toString());


                Date data = new Date();
                String cred1;
                String cred2;


                //Verifica se é cpf ou cnpj o cliente para enviarmos no realizaPedido
                if(this.credencialCliente.length()==11){
                    cred1 = this.credencialCliente;
                    cred2 = null;
                }else{
                    cred2 = this.credencialCliente;
                    cred1 = null;
                }


                //Chama realiza pedido
                funcionarioDaOperacao.realizaPedido(cred1, cred2, carro,
                this.cpfFuncionarioDaOperacao, data, this.tipoPagamentoDaOperacao, valor);





                popup.popFin("Pedido Realizado", "Pedido realizado com sucesso");
                break;
            
            case 2:
                //Pedido realizado vai ser chamado aqui

                //Busca de placa pra instanciar carro
                placaEscolhida = control.buscaPlacaCarro(opcaoMarca,opcaoModelo,opcaoCor);
                System.out.println(placaEscolhida);

                //Calcular valor para instanciar carro
                valor = control.calculaValor(opcaoModelo, opcaoMarca, opcaoCor);
                System.out.println(valor);

                //Instanciar carro
                carro = new Carro(placaEscolhida,opcaoMarca,opcaoModelo,opcaoCor,valor);
                
                System.out.println("Carro da operação: ");
                System.out.println(carro.toString());
                
                //Buscar informações do funcionário por ID, para que seja possível chamar o realizarPedido()
                
                infoFuncionario = control.pegaInfoFuncionarios(this.cpfFuncionarioDaOperacao);
                funcionarioDaOperacao = new Funcionario(infoFuncionario.get(0), infoFuncionario.get(1), infoFuncionario.get(2), infoFuncionario.get(3));
                
                System.out.println("Funcionário da operação: ");
                System.out.println(funcionarioDaOperacao.toString());


                data = new Date();
            


                //Verifica se é cpf ou cnpj o cliente para enviarmos no realizaPedido
                if(this.credencialCliente.length()==11){
                    cred1 = this.credencialCliente;
                    cred2 = null;
                }else{
                    cred2 = this.credencialCliente;
                    cred1 = null;
                }


                //Chama realiza pedido
                funcionarioDaOperacao.realizaPedido(cred1, cred2, carro,
                this.cpfFuncionarioDaOperacao, data, this.tipoPagamentoDaOperacao, valor);
                popup.popFin("Pedido Realizado", "Pedido realizado com sucesso");
                break;

            case 3:
                popup.popErro("Pedido Realizado", "O pagamento não pôde ser realizado");
                break;
        
            default:
                break;
        }

        c1 = new Cena1();
        //jan.setScene(c1.cena1(jan));
    }
}