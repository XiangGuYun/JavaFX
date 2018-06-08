package test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SwitchSceneTest extends Application {

    Stage window;
    Scene scene1, scene2;

    public static void main(String[] args) {
        launch(args);//启动
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        //类似于Android中的TextView
        Label label = new Label("这是第一个场景");
        Button button1 = new Button("跳转");
        button1.setOnAction(e->{
            window.setScene(scene2);
        });

        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label, button1);
        scene1 = new Scene(layout1, 320,240);

        Button button2 = new Button("回去");
        button2.setOnAction(e->{
            window.setScene(scene1);
        });


        StackPane layout2 = new StackPane();
        layout2.getChildren().add(button2);
        scene2 = new Scene(layout2, 320,240);

        window.setScene(scene1);
        window.setTitle("场景跳转");
        window.show();
    }
}
