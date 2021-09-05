
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


public class Popup {
    public static void pop(String titulo, String conteudo) {
        Stage window = new Stage();
        
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(titulo);
        window.setMinWidth(250);


        Label l = new Label();
        l.setText(conteudo);

        Button butao = new Button("OK");
        butao.setOnAction(e -> window.close());

        VBox box = new VBox();
        box.getChildren().addAll(l, butao);
        box.setAlignment(Pos.CENTER);

        Scene cena = new Scene(box);
        window.setScene(cena);
        window.showAndWait();

    }
}
