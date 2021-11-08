import javafx.application.Application;
import javafx.event.*;
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
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color; // Macro de cores
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.control.ButtonBase.*;
import javafx.scene.input.KeyEvent;
import java.util.Date;


public class TesteDriveView /*extends Application*/{

    ComboBox   idCliente, marcaBox, modeloBox, corBox;
    Label      nomeClienteD;
    DatePicker data;
    PopUp pop = new PopUp();  
    Scene testeDriveView;

    //MainView principalView;
    Scene view;

 
    

    /*FAZER SELECAO DE FUNCIONARIOS???? FALAR COM O IGOR SOBRE ISSO*/ 

    //@Override
    public Scene cenaTesteDrive(){

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(5);
        grid.setVgap(5);

        Label nomeClienteE = new Label("nome do cliente:    ");
        nomeClienteD = new Label("Identifique o cliente");

        Label campoNomeCliente = new Label("ID cliente:     ");
        Label marca  = new Label("marcas:   ");
        Label modelo = new Label("modelo:   ");
        Label cor    = new Label("cor:   ");


        Label dataDoTeste = new Label("Escolha uma data:    ");




        ObservableList<String> idsClientes = FXCollections.observableArrayList("Op1", "Op2", "Op3");
        idCliente = new ComboBox(idsClientes);
        idCliente.setOnAction(e -> pegaCliente());

        ObservableList<String> marcasEx  = FXCollections.observableArrayList("Op1", "Op2", "Op3");
        ObservableList<String> modelosEx = FXCollections.observableArrayList("Op1", "Op2", "Op3");
        ObservableList<String> coresEx   = FXCollections.observableArrayList("Op1", "Op2", "Op3");


        marcaBox    = new ComboBox(marcasEx);
        modeloBox   = new ComboBox(modelosEx);
        corBox      = new ComboBox(coresEx);

        marcaBox.getStyleClass().add("combo-box"); 
        modeloBox.getStyleClass().add("combo-box"); 
        corBox.getStyleClass().add("combo-box");


        marcaBox.setOnAction(e -> pegaMarca());
        modeloBox.setOnAction(e -> pegaModelo());
        corBox.setOnAction(e -> pegaCor());

        Button botaoFinaliza = new Button("Agendar");
        botaoFinaliza.getStyleClass().add("next");
        botaoFinaliza.setOnAction(e -> finaliza());

        Button botaoVolta = new Button("Voltar");
        //botaoVolta.getStyleClass().add("next");
        botaoVolta.setOnAction(e -> voltaCenaInicial());


        
        // ESCOLHER DATA
        data = new DatePicker();
        data.setOnAction(e -> pegaData());

        grid.add(nomeClienteE, 0, 0);
        grid.add(nomeClienteD, 1, 0);

        grid.add(campoNomeCliente, 0, 1);
        grid.add(idCliente,      1, 1);

        grid.add(marca,  0, 2);
        grid.add(modelo, 0, 3);
        grid.add(cor,    0, 4);

        grid.add(marcaBox,  1,  2);
        grid.add(modeloBox, 1,  3);
        grid.add(corBox,    1,  4);

        grid.add(dataDoTeste,  0,   5);
        grid.add(data,         1,   5);

        grid.add(botaoFinaliza,  2, 7);
        grid.add(botaoVolta,     0, 7);

        testeDriveView = new Scene(grid, 850, 400);
        testeDriveView.getStylesheets().add("estilo.css");

        // janela.setScene(testeDriveView);
        // janela.show();

        return testeDriveView;

    }

    public void pegaCliente(){
        String nome = idCliente.getValue().toString();
        System.out.println(nome);
        
        // Atualiza nome do cliente
        nomeClienteD.setText(nome);
    }

    public void pegaMarca(){
        System.out.println(marcaBox.getValue().toString());
    }

    public void pegaModelo(){
        System.out.println(modeloBox.getValue().toString());
    }

    public void pegaCor(){
        System.out.println(corBox.getValue().toString());
    }

    public void pegaData(){
        String padrao = "dd-MM-yyyy";
        DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern(padrao);
        LocalDate dataLocal = data.getValue();

        System.out.println(dataLocal.format(dataFormatada));
    }

    public void finaliza(){
        pop.popFin("Teste Drive", "Agendamento realizado com sucesso.");
    }

    public void voltaCenaInicial(){
        //principalView = new MainView();
        System.out.println("Entra");
        Interface.mensagensEntreCenas(-1);

        //System.out.println(MainView.jan.setScene());
        
    }

    // public static void main(String[] Args){
    //     launch();
    // }
}