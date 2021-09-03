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
import javafx.scene.paint.Color; // Macro de cores
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.control.ButtonBase.*;
import javafx.scene.input.KeyEvent;

import java.beans.*;
import javax.swing.JFrame;
import javafx.event.ActionEvent;
import javafx.beans.*;
import javafx.scene.control.TextField;
import javafx.scene.*;
import javafx.event.EventHandler;


/*  

    SEMPRE DAR CAMINHO DOS MODULOS
    export PATH_TO_FX=/home/ricardo/Documents/APSOO/Trabalho/javafx-sdk-16/lib 
    
    PARA COMPILAR E EXECUTAR
    javac --module-path $PATH_TO_FX --add-modules javafx.controls Prot.java
    java --module-path $PATH_TO_FX  --add-modules javafx.controls Prot

*/

public class Prot extends Application{

    // CPF
    TextField cpfText = new TextField();
    Label userCPF = new Label("CPF*:");

    // Nome
    Label userNome = new Label("Nome*:");
    TextField nomeText = new TextField();

    //Rua
    Label userRua = new Label("Rua*:");
    TextField ruaText = new TextField();

    // Num
    Label userNum = new Label("N°*:");
    TextField numText = new TextField();

    // Bairro
    Label userBairro = new Label("Bairro*:");
    TextField bairroText = new TextField();

    // Cidade
    Label userCidade = new Label("Cidade*:");
    TextField cidadeText = new TextField();

    // UF
    Label userUF = new Label("UF*:");
    TextField ufText = new TextField();

    // Fone
    Label userFone = new Label("Telefone*:");
    TextField foneText = new TextField();

    // Email
    Label userEmail = new Label("Email*:");
    TextField emailText = new TextField();








    @Override
    public void start(Stage stage) {
        stage.setTitle("Primeira Janela");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);


        // CRIANDO SCENE !!!!!!!!!!!!!
        Scene scene = new Scene(grid, 600, 400);
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

                @Override
                public void handle(KeyEvent k) {
                    if (k.getCode().toString() == "ENTER"){
                        //System.out.println(k.getTarget());
                        //System.out.println("ASDADASDASDASDAS");
                        verificaCampos();
                    }
                    // else{
                    //     System.out.println(k.getCode().toString());
                    // }
                    
                }
            });
        stage.setScene(scene);
        

        //The gap properties manage the spacing between the rows and columns
        grid.setHgap(10);
        grid.setVgap(10);
        
        // padding property manages the space around the edges of the grid pane.
        // The insets are in the order of top, right, bottom, and left
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        // Adicionando texto na cena
        // Text texto = new Text("Passa o LOGIN IRMAO!");
        // texto.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        // //       Noh coluna linha numColum  numLin
        // grid.add(texto, 1, 0, 2, 1);


        // **BASICAMENTE CRIA ALGUM WIDGET E ADICIONA NO GRID
        // CPF
        //Label userCPF = new Label("CPF*:");
        grid.add(userCPF, 0, 1);

        // Area de preechimento de texto
        //TextField cpfText = new TextField();
        cpfText.setPromptText("Digite o seu CPF");
        grid.add(cpfText, 1, 1);

        // Nome
        // Label userNome = new Label("Nome*:");
        grid.add(userNome, 0, 2);

        //TextField nomeText = new TextField();
        nomeText.setPromptText("Digite o seu nome");
        grid.add(nomeText, 1, 2);

        //Rua
        // Label userRua = new Label("Rua*:");
        grid.add(userRua, 0, 3);

        // TextField ruaText = new TextField();
        ruaText.setPromptText("Digite seu endereco");
        grid.add(ruaText, 1, 3);

        // Num
        //Label userNum = new Label("N°*:");
        grid.add(userNum, 0, 4);

        //TextField numText = new TextField();
        numText.setPromptText("Digite o numero da casa");
        grid.add(numText, 1, 4);

        // Bairro
        //Label userBairro = new Label("Bairro*:");
        grid.add(userBairro, 0, 5);

        // TextField bairroText = new TextField();
        bairroText.setPromptText("Nome do seu bairro");
        grid.add(bairroText, 1, 5);

        // Cidade
        //Label userCidade = new Label("Cidade*:");
        grid.add(userCidade, 0, 6);

        //TextField cidadeText = new TextField();
        cidadeText.setPromptText("Nome da sua cidade");
        grid.add(cidadeText, 1, 6);

        // UF
        Label userUF = new Label("UF*:");
        grid.add(userUF, 0, 7);

        TextField ufText = new TextField();
        ufText.setPromptText("Nome da UF");
        grid.add(ufText, 1, 7);

        // Fone
        Label userFone = new Label("Telefone*:");
        grid.add(userFone, 0, 8);

        TextField foneText = new TextField();
        foneText.setPromptText("Digite seu telefone");
        grid.add(foneText, 1, 8);

        // Email
        Label userEmail = new Label("Email*:");
        grid.add(userEmail, 0, 9);

        TextField emailText = new TextField();
        emailText.setPromptText("Digite seu email");
        grid.add(emailText, 1, 9);


        // // Titulo da area da senha
        // Label pw = new Label("Senha :");
        // grid.add(pw, 0, 2);

        // // Campo de preechimento da senha
        // PasswordField pwBox = new PasswordField();
        // grid.add(pwBox, 1, 2);


        // Criando botao
        // Button butaoSalva = new Button();
        // butaoSalva.setText("Salva PUTA!");

        // butaoSalva.setOnAction(new EventHandler<ActionEvent>() {
        //     @Override public void handle(ActionEvent e) {
        //         //butaoSalva.setText("Accepted");
        //         System.out.println("SALVO FI DE CACHORRA!");
        //     }
        // });
        // grid.add(butaoSalva, 1,3);

        // Criando botao
        Button butaoSair = new Button("Cancelar");
        butaoSair.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                System.exit(-1);
                //System.out.printf("%s\n", userTextField.getText());
            }
        });
        grid.add(butaoSair, 1, 10);

        // Criando botao
        Button butaoNome = new Button("Confirmar");
        butaoNome.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e){
                // MANDAR DADOS PARA O BANCO DE DADOS APOS CLICAR O BOTAO DE CONFIRMAR


            }
        });
        grid.add(butaoNome, 2, 10);


        
        Menu menu1 = new Menu("File");
        Menu menu2 = new Menu("Options");
        Menu menu3 = new Menu("Help");
        
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(menu1, menu2, menu3);
        
        HBox horizontalBox = new HBox(menuBar);
        grid.add(horizontalBox, 0, 0);
        
        stage.show();
    }

    public void verificaCampos(){
        if (cpfText.getText().length() > 0){
            System.out.printf("%s\n", cpfText.getText());                    
        }
        else{
            System.out.println("CPF Vazio!");
        }

        if (nomeText.getText().length() > 0){
            System.out.printf("%s\n", nomeText.getText()); 
        }
        else{
            System.out.printf("Nome Vazio!\n"); 
        }

        if (ruaText.getText().length() > 0){
            System.out.printf("%s\n", ruaText.getText());
        }
        else{
            System.out.printf("Endereco invalido!\n");
        }

        if (numText.getText().length() > 0){
            System.out.printf("%s\n", numText.getText());
        }
        else{
            System.out.printf("Numero invalido\n");
        }

        if(bairroText.getText().length() > 0){
            System.out.printf("%s\n", userBairro.getText());
        }
        else{
            System.out.printf("Bairro nao preechido!\n");
        }

        if(cidadeText.getText().length() > 0){
            System.out.printf("%s\n", cidadeText.getText());
        }
        else{
            System.out.printf("Nome da cidade invalido \n");
        }

        if(ufText.getText().length() > 0){
            System.out.printf("%s\n", ufText.getText());
        }
        else{
            System.out.printf("UF invalido \n");
        }

        if(foneText.getText().length() > 0){
            System.out.printf("%s\n", foneText.getText());
        }
        else{
            System.out.printf("Telefone invalido \n");
        }

        if(emailText.getText().length() > 0){
            System.out.printf("%s\n", emailText.getText());
        }
        else{
            System.out.printf("Email invalido \n");
        }
    }

    public static void main (String[] args){
        launch();
    }
}