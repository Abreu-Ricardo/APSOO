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
    //Scene cena1, cena2, cena3;

    static Stage jan;
    PopUp popup = new PopUp();


    static ClienteView    c1             = new ClienteView();
    static CarroView      c2             = new CarroView();
    static PagamentoView  c3             = new PagamentoView();
    static EscolheAcao    pagView        = new EscolheAcao();
    static TesteDriveView testeDriveView = new TesteDriveView();
    //Cena2 c2 = new Cena2();

    // // Agrupador de radio buttons, com ele garante que apenas
    // // um radio button pode ser clicado
    // ToggleGroup grupo = new ToggleGroup();

    // // RadioButtons criados fora do metodos start para serem usados em outro metodos
    // RadioButton pagamentoDinheiro       = new RadioButton("Dinheiro");
    // RadioButton pagamentoFinanciamento  = new RadioButton("Financiamento");
    // RadioButton pagamentoCartao         = new RadioButton("Cartão");


    @Override
    public void start(Stage janela){
        jan = janela;
        jan.setTitle("InOut Carros");
        jan.getIcons().add(new Image("images/shop.png"));

  

        //janela.setScene(c1.cena1());
        janela.setScene(pagView.escolhaDaCena());
        janela.show();

    }

    static public void mensagensEntreCenas(int msg){

        if (msg == -1){
            jan.setScene(pagView.escolhaDaCena());
        }

        else if (msg == 0){
            jan.setScene(testeDriveView.cenaTesteDrive());
        }

        else if (msg == 1){
            jan.setScene(c1.cena1());
        }
        else if (msg == 2){
            jan.setScene(c2.cena2());
        }

        else if (msg == 3){
            jan.setScene(c3.cena3());
        }
    }


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

