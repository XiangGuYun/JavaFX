package test;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EmbeddingLayoutsTest extends Application {
    private BorderPane layout;

    Stage window;

    public static void main(String[] args){
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("内嵌式布局");

        initView();

        Scene scene = new Scene(layout, 720,640);//场景,类似于Android中的Activity
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void initView() {
        HBox topMenu = new HBox();
        Button btn1 = new Button("文件");
        Button btn2 = new Button("编辑");
        Button btn3 = new Button("视图");
        topMenu.getChildren().addAll(btn1,btn2,btn3);

        VBox leftMenu = new VBox();
        Button btn4 = new Button("按钮1");
        Button btn5 = new Button("按钮2");
        Button btn6 = new Button("按钮3");
        leftMenu.getChildren().addAll(btn4,btn5,btn6);

        layout = new BorderPane();
        layout.setTop(topMenu);
        layout.setLeft(leftMenu);
    }
}
