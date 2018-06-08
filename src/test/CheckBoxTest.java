package test;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CheckBoxTest extends BaseApplication {
    private Stage window;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("复选框");

        CheckBox checkBox1 = new CheckBox("Bacon");
        checkBox1.setSelected(true);
        CheckBox checkBox2 = new CheckBox("Tuna");
        Button btn = new Button("Test");

        btn.setOnAction(e->{
            handleOptions(checkBox1,checkBox2);
        });

        VBox vBox = new VBox();
        vBox.setPadding(new Insets(20,20,20,20));
        vBox.setSpacing(10);//设置子视图间距
        vBox.setAlignment(Pos.BASELINE_CENTER);
        vBox.getChildren().addAll(checkBox1,checkBox2,btn);
        Scene scene = new Scene(vBox, 320,150);//场景,类似于Android中的Activity
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleOptions(CheckBox checkBox1, CheckBox checkBox2) {
        StringBuilder msg = new StringBuilder("User Order:\n");

        if(checkBox1.isSelected()){
            msg.append(checkBox1.getText());
        }
        if(checkBox2.isSelected()){
            msg.append(checkBox2.getText());
        }

        println(msg.toString());
    }
}
