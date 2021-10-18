
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;


public class PopUp {
    public static void pop(String titulo, String conteudo) {
        Stage window = new Stage();
        
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(titulo);
        window.setMinWidth(250);
        window.setMinHeight(80);

        // Image imagemCheck = new Image("images/check.png");
        // ImageView checkView = new ImageView(imagemCheck);
        
        // checkView.setFitHeight(40);
        // checkView.setPreserveRatio(true);


        //Label l = new Label(conteudo, checkView);
        Label l = new Label(conteudo);
        //l.setText(conteudo);

        Button butao = new Button("OK");
        butao.setOnAction(e -> window.close());
        butao.getStyleClass().add("next");

        VBox box = new VBox();
        box.getChildren().addAll(l, butao);
        box.setAlignment(Pos.CENTER);

        Scene cena = new Scene(box);
        cena.getStylesheets().add("estilo.css");

        window.setScene(cena);
        window.showAndWait();

    }

    public static void popFin(String titulo, String conteudo) {
        Stage window = new Stage();
        
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(titulo);
        window.setMinWidth(250);
        window.setMinHeight(80);

        Image imagemCheck = new Image("images/check.png");
        ImageView checkView = new ImageView(imagemCheck);
        
        checkView.setFitHeight(40);
        checkView.setPreserveRatio(true);


        Label l = new Label(conteudo, checkView);
        //l.setText(conteudo);

        Button butao = new Button("OK");
        butao.setOnAction(e -> window.close());
        butao.getStyleClass().add("next");

        VBox box = new VBox();
        box.getChildren().addAll(l, butao);
        box.setAlignment(Pos.CENTER);

        Scene cena = new Scene(box);
        cena.getStylesheets().add("estilo.css");

        window.setScene(cena);
        window.showAndWait();

    }

    public static void popErro(String titulo, String conteudo) {
        Stage window = new Stage();
        
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(titulo);
        window.setMinWidth(250);
        window.setMinHeight(80);

        Image imagemErro = new Image("images/error.png");
        ImageView erroView = new ImageView(imagemErro);
        
        erroView.setFitHeight(40);
        erroView.setPreserveRatio(true);


        Label l = new Label(conteudo, erroView);
        //l.setText(conteudo);

        Button butao = new Button("OK");
        butao.setOnAction(e -> window.close());
        butao.getStyleClass().add("botao-erro");

        VBox box = new VBox();
        box.getChildren().addAll(l, butao);
        box.setAlignment(Pos.CENTER);

        Scene cena = new Scene(box);
        cena.getStylesheets().add("estilo.css");

        window.setScene(cena);
        window.showAndWait();

    }

    public static void popCliente(String titulo, String conteudo) {
        Stage window = new Stage();
        
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(titulo);
        window.setMinWidth(250);
        window.setMinHeight(80);

        Image imagemErro = new Image("images/check.png");
        ImageView erroView = new ImageView(imagemErro);
        
        erroView.setFitHeight(40);
        erroView.setPreserveRatio(true);


        Label l = new Label(conteudo, erroView);
        //l.setText(conteudo);

        Button butao = new Button("OK");
        butao.setOnAction(e -> window.close());
        butao.getStyleClass().add("botao-erro");

        VBox box = new VBox();
        box.getChildren().addAll(l, butao);
        box.setAlignment(Pos.CENTER);

        Scene cena = new Scene(box);
        cena.getStylesheets().add("estilo.css");

        window.setScene(cena);
        window.showAndWait();

    }



}