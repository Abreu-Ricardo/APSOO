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
    Stage jan;
    Scene cena3;
    PopUp popup = new PopUp();
    Cena1 c1;
    Cena2 c2;
    String idEscolhido;
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
        Image valorImage    = new Image("images/valor.png");
        Image tipoPagImage  = new Image("images/pagop.png");

        // Criando a visualizacao da imagem
        ImageView calendarioView = new ImageView(calendario);
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
        Label valortext = new Label("R$ 60000,00");


        

        // Botoes da cena 3
        // Botoes para andar entre as cenas
        Button next3  = new Button("Next");
        Button volta3 = new Button("Voltar");

        // ComboBox para escolher o idFuncionario
        ObservableList<String> idsFunc = FXCollections.observableArrayList("Op1", "Op2", "Op3");
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
        grid3.add(valor,        0, 1);
        grid3.add(data,         0, 2);
        grid3.add(idFunc,       0, 3);
        grid3.add(nomeFunc,     0, 4);
        grid3.add(tipoPag,      0, 5);

        grid3.add(nomeFuncText, 1, 4);


        // Colocando botoes
        grid3.add(next3,  1, 6);
        grid3.add(volta3, 0, 6);

        

        // Colocando RadioButtons
        //grid3.add(group, 1, 4);
        grid3.add(pagamentoDinheiro,      1, 5);
        grid3.add(pagamentoFinanciamento, 2, 5);
        grid3.add(pagamentoCartao,        3, 5);

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

        // colocar o nome no setText
        nomeFuncionario.setText(idFuncBox.getValue().toString());
    }

    public void pegaPagamento(int formaPag){

        switch (formaPag) {
            case 1:
                System.out.println("Dinheiro clicado");
                flagTipoPagamento = 1;
                break;
            
            case 2:
                System.out.println("Financiamento clicado");
                flagTipoPagamento = 2;
                break;

            case 3:
                System.out.println("Cartao selecionado");
                flagTipoPagamento = 3;
                break;
        
            default:
                break;
        }
    }

    public void voltaParaCena1(){

        switch (flagTipoPagamento) {
            case 1:
                popup.popFin("Pedido Realizado", "Pedido realizado com sucesso");
                break;
            
            case 2:
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
