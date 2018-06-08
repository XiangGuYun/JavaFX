package test;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GridPaneTest extends Application {

    Stage window;

    public static void main(String[] args){
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("网格面板");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10,10,10,10));//设置内边距
        gridPane.setVgap(8);//设置垂直外边距
        gridPane.setHgap(8);//设置横向外边距

        //用户名
        Label usernameLabel = new Label("Username:");
        gridPane.setConstraints(usernameLabel,0,0);

        TextField usernameField = new TextField();
        gridPane.setConstraints(usernameField,1,0);

        //密码
        Label passwordLabel = new Label("Password:");
        gridPane.setConstraints(passwordLabel,0,1);

        TextField passwordField = new TextField();
        passwordField.setPromptText("请输入密码");
        gridPane.setConstraints(passwordField,1,1);

        //登录按钮
        Button btnLogin = new Button("登录");
        gridPane.setConstraints(btnLogin,1,2);

        gridPane.getChildren().addAll(usernameLabel,usernameField,passwordLabel,passwordField,btnLogin);

        Scene scene = new Scene(gridPane, 720,640);//场景,类似于Android中的Activity
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}
