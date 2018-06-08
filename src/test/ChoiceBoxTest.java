package test;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChoiceBoxTest extends BaseApplication {
    private Stage window;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("下拉菜单");
        Label label = new Label("选择你最喜欢的直播平台");
        ChoiceBox<String> box = new ChoiceBox<>();
        box.getItems().add("斗鱼");
        box.getItems().add("虎牙");
        box.getItems().add("龙珠");
        box.getItems().add("战旗");
        box.getItems().add("全民");
        box.getItems().addAll("其他","都不喜欢");
        Button btn = new Button("Test");
        btn.setOnAction(e->{
            println(box.getValue());
        });
        //设置默认值
        box.setValue("斗鱼");

        //监听选项改变
        box.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            println("oldValue is "+oldValue+" and newValue is "+newValue);
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
