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


public class EscolheAcao{
    ToggleGroup grupo = new ToggleGroup();
    RadioButton testeDrive; 
    RadioButton venda;      
    
    public Scene escolhaDaCena() {

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);

        grid.setHgap(20);
        grid.setVgap(20);

        Button seleciona = new Button("Próximo");
        seleciona.getStyleClass().add("next");


        testeDrive = new RadioButton("Teste Drive");
        venda      = new RadioButton("Venda");


        testeDrive.setOnAction(e -> pegaOpcao());
        venda.setOnAction(e -> pegaOpcao());

        testeDrive.setToggleGroup(grupo);
        venda.setToggleGroup(grupo);

        grid.add(testeDrive, 0, 0);
        grid.add(venda,      1, 0);
        grid.add(seleciona,  1, 1);
        
        Scene cenaDeEscolha = new Scene(grid, 850, 400);
        cenaDeEscolha.getStylesheets().add("estilo.css");

        return cenaDeEscolha;
    }

    public void pegaOpcao(){

        if(testeDrive.isSelected()){
            System.out.println("Agendar Teste Drive Clicado");
            // Vai para a cena TesteDriveView
            Interface.mensagensEntreCenas(0);

        }
        else{
            System.out.println("Venda de Carro clicado");
            // Vai para a cena VendaView
            Interface.mensagensEntreCenas(1);
        }

        
    }
}