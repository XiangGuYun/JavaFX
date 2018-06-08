package test;

import bean.Person;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BindingTest extends BaseApplication {

    private Stage window;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("列表");

        IntegerProperty x = new SimpleIntegerProperty(3);
        IntegerProperty y = new SimpleIntegerProperty(3);

        y.bind(x.multiply(10));
        pln("x: "+x.getValue());
        pln("y: "+y.getValue());

        x.setValue(9);
        pln("x: "+x.getValue());
        pln("y: "+y.getValue());

        Button btn = new Button("提交");
        btn.setOnAction(e->{

        });

        VBox vBox = new VBox();
        vBox.setPadding(new Insets(20,20,20,20));
        vBox.setSpacing(10);//设置子视图间距
        vBox.getChildren().addAll(btn);
        Scene scene = new Scene(vBox, 320,300);//场景,类似于Android中的Activity
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
