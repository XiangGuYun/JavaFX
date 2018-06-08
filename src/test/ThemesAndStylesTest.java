package test;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ThemesAndStylesTest extends BaseApplication {
    private Stage window;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("登录测试");

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(10,10,10,10));//设置内边距
        gridPane.setVgap(8);//设置垂直外边距
        gridPane.setHgap(8);//设置横向外边距

        //用户名
        Label usernameLabel = new Label("用户名:");
        usernameLabel.setStyle("-fx-text-fill: aliceblue");
        usernameLabel.setId("bold-label");
        gridPane.setConstraints(usernameLabel,0,0);

        TextField usernameField = new TextField("请输入用户名");
        gridPane.setConstraints(usernameField,1,0);

        //密码
        Label passwordLabel = new Label("密  码:");
        gridPane.setConstraints(passwordLabel,0,1);

        TextField passwordField = new TextField();
        passwordField.setPromptText("请输入密码");
        gridPane.setConstraints(passwordField,1,1);

        //登录按钮
        Button btnLogin = new Button("登  录");
        gridPane.setConstraints(btnLogin,1,2);
        btnLogin.setOnAction(e->{
        });

        Button btnSignUp = new Button("注  册");
        btnSignUp.getStyleClass().add("button-blue");
        gridPane.setConstraints(btnSignUp, 1,3);

        gridPane.getChildren().addAll(usernameLabel,usernameField,passwordLabel,passwordField,btnLogin,
                btnSignUp);

        Scene scene = new Scene(gridPane, 320,240);//场景,类似于Android中的Activity
        scene.getStylesheets().add("css/Viper.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
