import javafx.application.Application;
import javafx.beans.property.ObjectProperty;
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

public class Cena2 {

    SisVendaDeCarros control = new SisVendaDeCarros();

    ArrayList<String> listaModelosCarros = new ArrayList<>();
    ArrayList<String> listaCores = new ArrayList<>();

    Stage jan;
    PopUp popup = new PopUp();
    Cena1 C1;   // = new Cena1();
    Cena3 C3;
    String credencialCliente, idCliente;      // Identificacao do cliente
    String opcaoMarca  = null,                 // Variaveis para salvar as opcoes marcadas 
           opcaoModelo = null, 
           opcaoCor    = null; 

    ChoiceBox cb1, // choice-box da marca 
              cb2, // choice-box do modelo
              cb3; // choice-box da cor

    public Cena2(Cena1 c1, String credencial, String id){
        C1 = c1;
        credencialCliente = credencial;
        idCliente = id;
    }

    public Scene cena2(Stage janela){
        jan = janela;
        Scene cena2;

        GridPane grid2 = new GridPane();
        grid2.setAlignment(Pos.CENTER);
        grid2.setVgap(3);
        grid2.setHgap(1);

        Label tituloCarro = new Label("Preencha as opções");
        tituloCarro.getStyleClass().add("titulo");


        Image     marcaImagem = new Image("images/marca.png");
        ImageView marcaView = new ImageView(marcaImagem);
        
        Image     modeloImagem = new Image("images/opt.png");
        ImageView modeloView   = new ImageView(modeloImagem);

        Image     corImagem = new Image("images/colors.png");
        ImageView corView   = new ImageView(corImagem);


        //
        marcaView.setFitHeight(30);
        marcaView.setPreserveRatio(true);

        modeloView.setFitHeight(30);
        modeloView.setPreserveRatio(true);
        
        corView.setFitHeight(30);
        corView.setPreserveRatio(true);



        // Criando titulos
        Label marcas = new Label("Marcas:  ", marcaView);
        Label modelo = new Label("Modelo:  ", modeloView);
        Label cor    = new Label("Cor:     ", corView);

        // Botoes da cena2
        Button next2 = new Button("Next");
        Button volta2 = new Button("Voltar");

        next2.getStyleClass().add("next");

        // Acoes dos botoes da cena 2
        next2.setOnAction(e -> trocaParaCena3());
        volta2.setOnAction(e -> trocaParaCena1());


        // ***** IMPORTANTE PARA QUEM FOR FAZER AS CLASSES DAO *****
        // Quando for pegar as opcoes de cada carro
        // ponha tudo em strings, uma para marca, modelo e cor,
        // porque para a caixa de opcoes funcionar, ela soh aceita um 
        // certo tipo de List, por isso tem que ser String para poder 
        // fazer um cast
        String teste[] = {"OPCAO 1", "OPCAO 2", "OPCAO 3", ""};



        cb1 = new ChoiceBox();
        ArrayList<String> listaMarcas = control.buscaMarcasCarros();
        cb1.setOnAction(e -> callbackCb1());
        // Fazendo cast de String para observableArrayList  --- Trocar teste ---
        cb1.setItems(FXCollections.observableArrayList(listaMarcas));
        
        cb2 = new ChoiceBox();
        cb2.setOnAction(e -> callbackCb2());

        cb3 = new ChoiceBox();
        cb3.setOnAction(e -> callbackCb3());
        // Fazendo cast de String para observableArrayList  --- Trocar teste ---
   

        // Colocando as caixas de opcoes em uma etiqueta para o CSS
        cb1.getStyleClass().add("choice-box");
        cb2.getStyleClass().add("choice-box");
        cb3.getStyleClass().add("choice-box");

        // Anexando todos os widgets no grid
        grid2.add(tituloCarro, 0, 0);

        // Titulos das caixas de opcoes
        grid2.add(marcas, 0, 1);
        grid2.add(modelo, 0, 2);
        grid2.add(cor,    0, 3);

        // Caixas de opcoes
        grid2.add(cb1, 1, 1);
        grid2.add(cb2, 1, 2);
        grid2.add(cb3, 1, 3);

        // Botao next
        grid2.add(next2 , 2, 6);

        // Botao volta
        grid2.add(volta2, 0, 6);

        cena2 = new Scene( grid2, 850, 300);
        cena2.getStylesheets().add("estilo.css");

        return cena2;

    }

    public void trocaParaCena1(/*ActionEvent e*/){
        jan.setScene(C1.cena1(jan));   

    }

    public void trocaParaCena3(/*ActionEvent e*/){
        
        if ( opcaoMarca != null && (opcaoModelo != null && opcaoCor != null) ){
            
            C3 = new Cena3(this, credencialCliente, idCliente, opcaoMarca, opcaoModelo, opcaoCor);
            jan.setScene(C3.cena3(jan));   
            
        }

        else{
            popup.popErro("Erro na escolha do carro", "Preencha todas as opções!");
        }

        // Caso tenha errado e volte para as escolhas, elas precisam
        // estar limpas para as novas escolhas
        // opcaoMarca = opcaoModelo = opcaoCor = null;

    }

    public void callbackCb1(){
        opcaoMarca = cb1.getValue().toString();
        System.out.println( opcaoMarca );

    
        this.listaModelosCarros = this.control.buscaModelosCarros(opcaoMarca);
        cb2.setItems(FXCollections.observableArrayList(this.listaModelosCarros));

    }

    public void callbackCb2(){
        opcaoModelo = cb2.getValue().toString();
        System.out.println( opcaoModelo );
        
        this.listaCores = this.control.buscaCoresCarros(opcaoModelo);
        cb3.setItems(FXCollections.observableArrayList(this.listaCores));
    }

    public void callbackCb3(){
        opcaoCor = cb3.getValue().toString();

        System.out.println( opcaoCor );
    }
}