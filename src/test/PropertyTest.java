package test;

import bean.Person;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PropertyTest extends BaseApplication {

    private Stage window;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("列表");

        Person person = new Person();
        person.firstNameProperty().addListener((observable, oldValue, newValue) -> {
            pln("name change to "+newValue);
            pln("firstNameProperty(): "+person.firstNameProperty());
            pln("getFirstName(): "+person.getFirstName());
        });

        Button btn = new Button("提交");
        btn.setOnAction(e->{
            person.setFirstName("Jim");
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
