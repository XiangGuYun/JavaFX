package test;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ListViewTest extends BaseApplication {
    private Stage window;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("列表");
        Label label = new Label("选择你喜欢的直播平台");

        ListView<String> listView = new ListView<>();
        listView.setOrientation(Orientation.VERTICAL);
        listView.getItems().addAll("斗鱼","虎牙","熊猫");
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);


        Button btn = new Button("Test");
        btn.setOnAction(e->{
            ObservableList<String> items = listView.getSelectionModel().getSelectedItems();
            for (String item:items
                 ) {
                println(item);
            }
        });

        VBox vBox = new VBox();
        vBox.setPadding(new Insets(20,20,20,20));
        vBox.setSpacing(10);//设置子视图间距
        vBox.getChildren().addAll(label,listView,btn);
        Scene scene = new Scene(vBox, 320,300);//场景,类似于Android中的Activity
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
