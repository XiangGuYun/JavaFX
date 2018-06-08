package test;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static utils.TextUtils.isDigitsOnly;


/**
 * 提取和验证输入框
 */
public class ExtractAndVolidateInputTest extends BaseApplication {

    private Stage window;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("提取验证");

        TextField textField = new TextField("请输入信息");
        Button btn = new Button("提取并验证");

        btn.setOnAction(e->{
            println(textField.getText());
            println("是否是纯数字:"+isDigitsOnly(textField.getText()));
        });

        VBox vBox = new VBox();
        vBox.setPadding(new Insets(20,20,20,20));
        vBox.setSpacing(10);//设置子视图间距
        vBox.setAlignment(Pos.BASELINE_CENTER);
        vBox.getChildren().addAll(textField,btn);
        Scene scene = new Scene(vBox, 320,100);//场景,类似于Android中的Activity
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
