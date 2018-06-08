package test;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class LastTest extends Application {

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("test1.fxml"));
        primaryStage.setScene(new Scene(parent, 720,540));
        primaryStage.setTitle("学习园地");
        primaryStage.setResizable(false);//设置是否可拖拽缩放
        primaryStage.getIcons().add(new Image("img/book.png"));//设置左上角应用图标
        //监听关闭按钮
        //primaryStage.setOnCloseRequest(event -> AlertDialog.display("提示","确定要退出吗"));
        primaryStage.show();
    }
}
