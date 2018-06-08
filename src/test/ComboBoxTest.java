package test;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ComboBoxTest extends BaseApplication{
    private Stage window;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("组合菜单");
        Label label = new Label("选择你最喜欢的直播平台");

        ComboBox<String> box = new ComboBox<>();
        box.getItems().addAll("斗鱼","虎牙","熊猫");
        box.setPromptText("请选择");
        box.setOnAction(e->{
            println(box.getValue());
        });
        box.setEditable(true);

        Button btn = new Button("Test");
        btn.setOnAction(e->{
            println(box.getValue());
        });

        VBox vBox = new VBox();
        vBox.setPadding(new Insets(20,20,20,20));
        vBox.setSpacing(10);//设置子视图间距
        vBox.setAlignment(Pos.BASELINE_CENTER);
        vBox.getChildren().addAll(label,box,btn);
        Scene scene = new Scene(vBox, 320,150);//场景,类似于Android中的Activity
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
