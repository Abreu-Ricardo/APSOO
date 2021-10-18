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

import java.lang.*;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;


public class Interface extends Application{

    // Variaveis que seram utilizadas entre metodos
    Scene cena1, cena2, cena3;
    Stage janela;
    PopUp popup = new PopUp();
    Cena1 c1 = new Cena1();
    //Cena2 c2 = new Cena2();

    // // Agrupador de radio buttons, com ele garante que apenas
    // // um radio button pode ser clicado
    // ToggleGroup grupo = new ToggleGroup();

    // // RadioButtons criados fora do metodos start para serem usados em outro metodos
    // RadioButton pagamentoDinheiro       = new RadioButton("Dinheiro");
    // RadioButton pagamentoFinanciamento  = new RadioButton("Financiamento");
    // RadioButton pagamentoCartao         = new RadioButton("Cartão");


    @Override
    public void start(Stage jan){
        janela = jan;
        janela.setTitle("Interface APSOO");
        janela.getIcons().add(new Image("images/shop.png"));

        //                  ##### CENA  1 #####
        // ##### Grid da esquerda #####

        // GridPane grid1 = new GridPane();
        // grid1.setAlignment(Pos.CENTER);
        // grid1.setVgap(3);
        // grid1.setHgap(25);

        // // Titulo
        // Label pessoaF = new Label("Pessoa Física");
        // // Colocando idetificador para o CSS 
        // pessoaF.getStyleClass().add("titulo");
        // grid1.add(pessoaF, 0, 0);

        // // CPF
        // Label cpfTitulo = new Label("CPF: ");
        // TextField cpfText = new TextField();
        // cpfText.setPromptText("Digite o CPF do cliente...");
        
        // grid1.add(cpfTitulo, 0, 1);
        // grid1.add(cpfText, 1, 1);

        // // idCliente fisico
        // Label idClienteTitulo = new Label("ID do Cliente: ");
        // TextField idClienteText = new TextField();
        // idClienteText.setPromptText("Digite o ID do cliente...");
        
        // grid1.add(idClienteTitulo, 0, 2); 
        // grid1.add(idClienteText, 1, 2);

        //  // Botao para proxima cena
        //  Button botaoF = new Button("Next");
        //  botaoF.getStyleClass().add("next");
        //  grid1.add(botaoF, 1, 3);

        //  botaoF.setOnAction(e -> trocaParaCena2());






        // // ##### Grid da direita #####

        // Label pessoaJ = new Label("Pessoa Jurídica");
        // pessoaJ.getStyleClass().add("titulo");
        // grid1.add(pessoaJ, 5, 0);

        // // CNPJ
        // Label cnpjTitulo = new Label("CNPJ: ");
        // TextField cnpjText = new TextField();
        // cnpjText.setPromptText("Digite o CNPJ do cliente...");
        
        // grid1.add(cnpjTitulo, 5, 1);
        // grid1.add(cnpjText, 6, 1);

 
        // // idCliente juridico
        // Label idClienteJuTitulo = new Label("ID do Cliente: ");
        // TextField idClienteJuText = new TextField();
        // idClienteJuText.setPromptText("Digite o ID do cliente...");

        // grid1.add(idClienteJuTitulo, 5, 2); 
        // grid1.add(idClienteJuText, 6, 2);


        // // Botao para proxima cena
        // Button botaoJ = new Button("Next");
        // botaoJ.getStyleClass().add("next");
        // grid1.add(botaoJ, 6, 3);


        // botaoJ.setOnAction(e -> trocaParaCena2());
        
        // cena1 = new Scene( grid1, 850, 300);
        // cena1.getStylesheets().add("estilo.css");


        //                  ##### CENA  2 #####


        // GridPane grid2 = new GridPane();
        // grid2.setAlignment(Pos.CENTER);
        // grid2.setVgap(3);
        // grid2.setHgap(1);

        // Label tituloCarro = new Label("Preencha as opções");
        // tituloCarro.getStyleClass().add("titulo");

        // // Criando titulos
        // Label marcas = new Label("Marcas:  ");
        // Label modelo = new Label("Modelo:  ");
        // Label cor    = new Label("Cor:     ");

        // // Botoes da cena2
        // Button next2 = new Button("Next");
        // Button volta2 = new Button("Voltar");

        // next2.getStyleClass().add("next");

        // // Acoes dos botoes da cena 2
        // next2.setOnAction(e -> trocaParaCena3());
        // volta2.setOnAction(e -> trocaParaCena1());


        // // ***** IMPORTANTE PARA QUEM FOR FAZER AS CLASSES DAO *****
        // // Quando for pegar as opcoes de cada carro
        // // ponha tudo em strings, uma para marca, modelo e cor,
        // // porque para a caixa de opcoes funcionar, ela soh aceita um 
        // // certo tipo de List, por isso tem que ser String para poder 
        // // fazer um cast
        // String teste[] = {"OPCAO 1", "OPCAO 2", "OPCAO 3", ""};



        // ChoiceBox cb1 = new ChoiceBox();
        // // Fazendo cast de String para observableArrayList  --- Trocar teste ---
        // cb1.setItems(FXCollections.observableArrayList(teste));
        
        // ChoiceBox cb2 = new ChoiceBox();
        // // Fazendo cast de String para observableArrayList  --- Trocar teste ---
        // cb2.setItems(FXCollections.observableArrayList(teste));
        
        // ChoiceBox cb3 = new ChoiceBox();
        // // Fazendo cast de String para observableArrayList  --- Trocar teste ---
        // cb3.setItems(FXCollections.observableArrayList(teste));

        // // Colocando as caixas de opcoes em uma etiqueta para o CSS
        // cb1.getStyleClass().add("choice-box");
        // cb2.getStyleClass().add("choice-box");
        // cb3.getStyleClass().add("choice-box");

        // // Anexando todos os widgets no grid
        // grid2.add(tituloCarro, 0, 0);

        // // Titulos das caixas de opcoes
        // grid2.add(marcas, 0, 1);
        // grid2.add(modelo, 0, 2);
        // grid2.add(cor,    0, 3);

        // // Caixas de opcoes
        // grid2.add(cb1, 1, 1);
        // grid2.add(cb2, 1, 2);
        // grid2.add(cb3, 1, 3);

        // // Botao next
        // grid2.add(next2 , 2, 6);

        // // Botao volta
        // grid2.add(volta2, 0, 6);

        // cena2 = new Scene( grid2, 850, 300);
        // cena2.getStylesheets().add("estilo.css");


        //                  ##### CENA  3 #####

    //     GridPane grid3 = new GridPane();
    //     grid3.setAlignment(Pos.CENTER);
    //     grid3.setVgap(3);
    //     grid3.setHgap(5);

    //     // Carregando a imagem para o programa
    //     Image calendario = new Image("calendar.png");
    //     Image nomeFuncImage = new Image("empregado.png");
    //     Image cpfFuncImage = new Image("cpfFunc.png");
    //     Image tipoPagImage = new Image("pagamento.png");

    //     // Criando a visualizacao da imagem
    //     ImageView calendarioView = new ImageView(calendario);
    //     ImageView nomeFuncView = new ImageView(nomeFuncImage);
    //     ImageView cpfFuncView = new ImageView(cpfFuncImage);
    //     ImageView tipoPagView = new ImageView(tipoPagImage);
        
    //     // Atribuindo o tamanho correto para os icones
    //     calendarioView.setFitHeight(30);
    //     calendarioView.setPreserveRatio(true);


    //     nomeFuncView.setFitHeight(30);
    //     nomeFuncView.setPreserveRatio(true);


    //     cpfFuncView.setFitHeight(30);
    //     cpfFuncView.setPreserveRatio(true);

    //     tipoPagView.setFitHeight(30);
    //     tipoPagView.setPreserveRatio(true);

    //     // Titulos da cena 3
    //     Label tituloRecibo = new Label("Recibo");
    //     Label data = new Label("Data:                       ", calendarioView);
    //     Label nomeFunc = new Label("Nome do Funcionário:    ", nomeFuncView);
    //     Label cpfFunc = new Label("CPF do Funcionário:      ", cpfFuncView);
    //     Label tipoPag = new Label("Tipo de Pagamento:       ", tipoPagView);

    //     tituloRecibo.getStyleClass().add("titulo");

    //     // Criando formatador para a data
    //     DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    //     // Pegando a data atual
    //     LocalDateTime agr = LocalDateTime.now(); 
    //     // Salvando numa string para utilizar da interface
    //     String d = new String(formatador.format(agr));

    //     // APAGAR
    //     //System.out.println( t  );
    //     Label valorData = new Label(d);
    //     // Pegar o nome do func e por como String
    //     Label nomeFuncText = new Label("Exemplo -> Carlos Alberto");

    //     // Pegar o cpf do func e por como String
    //     Label cpfFunctext = new Label("Exemplo -> 12345678900");


        

    //     // Botoes da cena 3
    //     // Botoes para andar entre as cenas
    //     Button next3  = new Button("Next");
    //     Button volta3 = new Button("Voltar");
        
        

    //     // RadioButton pagamentoDinheiro       = new RadioButton("Dinheiro");
    //     pagamentoDinheiro.setToggleGroup(grupo);
    //     pagamentoDinheiro.setOnAction(e -> pegaPagamento(1));

    //     // RadioButton pagamentoFinanciamento  = new RadioButton("Financiamento");
    //     pagamentoFinanciamento.setToggleGroup(grupo);
    //     pagamentoFinanciamento.setOnAction(e -> pegaPagamento(2));


    //     // RadioButton pagamentoCartao         = new RadioButton("Cartão");
    //     pagamentoCartao.setToggleGroup(grupo);
    //     pagamentoCartao.setOnAction(e -> pegaPagamento(3));


        


    //     pagamentoDinheiro.getStyleClass().add("radio-button");     
    //     pagamentoFinanciamento.getStyleClass().add("radio-button");
    //     pagamentoCartao.getStyleClass().add("radio-button");

    //     next3.getStyleClass().add("next");

    //     // Acoes dos botoes da cena 2
    //    // volta3.setOnAction(e -> trocaParaCena2());
    //     next3.setOnAction(e -> popup.pop("Pedido Realizado", "Pedido realizado com sucesso"));

    //     // COLOCAR TITULO
    //     grid3.add(tituloRecibo, 0, 0);
    //     grid3.add(data,         0, 1);
    //     grid3.add(nomeFunc,     0, 2);
    //     grid3.add(cpfFunc,      0, 3);
    //     grid3.add(tipoPag,      0, 4);


    //     // Colocando botoes
    //     grid3.add(next3,  1, 5);
    //     grid3.add(volta3, 0, 5);

    //     // Colocando RadioButtons
    //     //grid3.add(group, 1, 4);
    //     grid3.add(pagamentoDinheiro,      1, 4);
    //     grid3.add(pagamentoFinanciamento, 2, 4);
    //     grid3.add(pagamentoCartao,        3, 4);

    //     // 
    //     grid3.add(valorData,    1, 1);
    //     grid3.add(nomeFuncText, 1, 2);
    //     grid3.add(cpfFunctext,  1, 3);

    //     cena3 = new Scene(  grid3, 850, 300);
    //     cena3.getStylesheets().add("estilo.css");
        

        




        janela.setScene(c1.cena1(janela));
        janela.show();

    }

    // Verifica qual tipo de forma de pagamento foi escolhida
    // public void pegaPagamento(int formaPag){

    //     switch (formaPag) {
    //         case 1:
    //             System.out.println("Dinheiro clicado");
    //             break;
            
    //         case 2:
    //             System.out.println("Financiamento clicado");
    //             break;

    //         case 3:
    //             System.out.println("Cartao selecionado");
    //             break;
        
    //         default:
    //             break;
    //     }
    // }


    // public void trocaParaCena1(/*ActionEvent e*/){
    //     janela.setScene(c1.);   

    // }

    // public void trocaParaCena2(/*ActionEvent e*/){
    //     janela.setScene(c2.trocaParaCena2());   

    // }

    // public void trocaParaCena3(/*ActionEvent e*/){
    //     //janela.setScene(c3.trocaParaCena3());   

    // }


    public static void main(String args[]) throws Exception{
        
        Conexao teste = new Conexao();
        

        Connection con = teste.createConnectionToMySQL();

        if(con!=null){
            System.out.println("Conectou");
            con.close();
        }else{
            System.out.println("Não conectou");
        }
       


        launch();
    }
}

