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

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
//import javafx.scene.Scene;
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


public class ClienteView {

    SisVendaDeCarros control = new SisVendaDeCarros();

    // static Stage jan;
    // static Scene cena1;
    
    // static Cena2 c2 = new Cena2();
    // static Cena3 c3 = new Cena3();
    PopUp popup = new PopUp();

    public Scene cena1(/*Stage janela*/ ){
        Scene cena1;
        //jan = janela;
        //Cena2 c2 = new Cena2();

        // jan.setHeight(450);
        // jan.setWidth(900);


        GridPane grid1 = new GridPane();
        grid1.setAlignment(Pos.CENTER);
        grid1.setVgap(3);
        grid1.setHgap(25);

        // Titulo
        Label pessoaF = new Label("Pessoa Física");
        // Colocando idetificador para o CSS 
        pessoaF.getStyleClass().add("titulo");
        grid1.add(pessoaF, 0, 0);

        // CPF
        Label cpfTitulo = new Label("CPF: ");
        TextField cpfText = new TextField();
        cpfText.setPromptText("Digite o CPF do cliente...");
            
        grid1.add(cpfTitulo, 0, 1);
        grid1.add(cpfText, 1, 1);

        // idCliente fisico
        Label idClienteTitulo = new Label("ID do Cliente: ");
        TextField idClienteText = new TextField();
        idClienteText.setPromptText("Digite o ID do cliente...");
            
        grid1.add(idClienteTitulo, 0, 2); 
        grid1.add(idClienteText, 1, 2);

        // Botao para proxima cena
        Button botaoF = new Button("Next");
        botaoF.getStyleClass().add("next");
        grid1.add(botaoF, 1, 3);
        
        botaoF.setOnAction(e -> botaoEsq( cpfText.getText(), idClienteText.getText()  ));






        // ##### Grid da direita #####

        Label pessoaJ = new Label("Pessoa Jurídica");
        pessoaJ.getStyleClass().add("titulo");
        grid1.add(pessoaJ, 5, 0);

        // CNPJ
        Label cnpjTitulo = new Label("CNPJ: ");
        TextField cnpjText = new TextField();
        cnpjText.setPromptText("Digite o CNPJ do cliente...");
            
        grid1.add(cnpjTitulo, 5, 1);
        grid1.add(cnpjText, 6, 1);

    
        // idCliente juridico
        Label idClienteJuTitulo = new Label("ID do Cliente: ");
        TextField idClienteJuText = new TextField();
        idClienteJuText.setPromptText("Digite o ID do cliente...");

        grid1.add(idClienteJuTitulo, 5, 2); 
        grid1.add(idClienteJuText, 6, 2);


        // Botao para proxima cena
        Button botaoJ = new Button("Next");
        botaoJ.getStyleClass().add("next");
        grid1.add(botaoJ, 6, 3);


        botaoJ.setOnAction(e -> botaoDir( cnpjText.getText(), idClienteJuText.getText()  ));
            
        cena1 = new Scene( grid1, 850, 400);
        cena1.getStylesheets().add("estilo.css");

        return cena1;
    }

    // static public void mensagensEntreCenas(int msg){
    //     if (msg == 1){
    //         jan.setScene(cena1);
    //     }
    //     else if (msg == 2){
    //         jan.setScene(c2.cena2());
    //     }

    //     else if (msg == 3){
    //         jan.setScene(c3.cena3());
    //     }
    // }

    public void botaoEsq(String cpfCliente, String idCliente){

        if (verficaCPF(cpfCliente) && verificaId(idCliente)){
            System.out.printf("Entrou no if do botaoEsq: %s \n", cpfCliente);

            String nomeCliente = control.buscarPessoa(cpfCliente);
            popup.popCliente("O cliente é: ", nomeCliente);  //fazer busca no banco aqui, e jogar o nome correto com o idcliente/ou cnpj cliente
            
            // ARRUMAR
            //trocaParaCena2(cpfCliente, idCliente);
            Interface.c2.credencialCliente = cpfCliente;
            Interface.c2.idCliente = idCliente;
            Interface.mensagensEntreCenas(2);
        }
        
        else if ( !verficaCPF(cpfCliente) ){
            //System.out.printf("Entrou no else if cpfCliente do botaoEsq: %s", cpfCliente);
            popup.popErro("Erro na identificação", "CPF/CNPJ inválido!");
        }

        else if ( !verificaId(idCliente) ){
            popup.popErro("Erro na identificação", "Preencha todos os campos!");
        }
        // tamanho de cpf = 11
        
    }

    public void botaoDir(String cnpjCliente, String idCliente){

        if (verficaCNPJ(cnpjCliente) && verificaId(idCliente)){
            System.out.println("Entrou no if do botaoDir");
            String nomeCliente = control.buscarPessoa(cnpjCliente);
            popup.popCliente("O cliente é: ", nomeCliente);
             //fazer busca no banco aqui, e jogar o nome correto com o idcliente/ou cnpj cliente
            trocaParaCena2(cnpjCliente, idCliente);
        }

        else if ( verficaCNPJ(cnpjCliente) == false){
            //System.out.println("Entrou no 1 else if do botaoDir");
            popup.popErro("Erro na identificação", "CPF/CNPJ inválido!");
        }
    
        else if (!verificaId(idCliente)){
            popup.popErro("Erro na identificação", "Preencha todos os campos!");
        }
        // tamanho de cnpj = 14
        return;
    }


    public boolean verficaCPF(String cpfPassado){

        if (cpfPassado.length() == 11 && cpfPassado != null){

            for (int i = 0; i < cpfPassado.length(); i++){
                // Se for caracter no if vai ser TRUE ou seja nao eh digito numerico entao retorna falso
                if ( !Character.isDigit( cpfPassado.charAt(i)) )
                    return false;
            }
        }

        else
            return false;

        return true;
    }

    public boolean verficaCNPJ(String cnpjPassado){
        //System.out.println(cnpjPassado);

        if (cnpjPassado.length() == 14 && cnpjPassado != null){

            for (int i = 0; i < cnpjPassado.length(); i++){
                // Se for caracter no if vai ser TRUE ou seja nao eh digito numerico entao retorna falso
                if ( !Character.isDigit( cnpjPassado.charAt(i)) )
                    return false;
            }
        }

        else
            return false;

        return true;
    }

    public boolean verificaId(String idClientePassado){
        //System.out.printf("TESTE %s \n", idClientePassado);

        if (idClientePassado != null && idClientePassado.length() > 0){

            for (int i=0; i < idClientePassado.length(); i++){
                // Se for caracter no if vai ser TRUE ou seja nao eh digito numerico entao retorna falso
                if( !Character.isDigit( idClientePassado.charAt(i)) )
                return false;
            }
        }

        else
            return false;

        return true;
    }

    public void trocaParaCena2(String credencialCliente, String idCliente){
        //c2 = new Cena2( credencialCliente, idCliente);


        Interface.mensagensEntreCenas(2);
        //System.out.println("SEt On ACtIon clicado em Cena1"); 

    }
}