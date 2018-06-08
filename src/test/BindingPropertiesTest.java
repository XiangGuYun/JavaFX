package test;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BindingPropertiesTest extends Application {

    private Stage window;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("列表");

        TextField userInput = new TextField();
        Label firstLabel = new Label("Welcome to the site");
        Label secondLabel = new Label();

        secondLabel.textProperty().bind(userInput.textProperty());

        HBox btmText = new HBox(firstLabel, secondLabel);
        btmText.setAlignment(Pos.CENTER);


        VBox vBox = new VBox(10, userInput, btmText);
        vBox.setPadding(new Insets(20,20,20,20));
        Scene scene = new Scene(vBox, 320,300);//场景,类似于Android中的Activity
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
