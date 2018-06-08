package utils;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmDialog {

    static boolean answer;

    public static boolean display(String title, String msg){
        Stage window = new Stage();
        //初始化形式(形态)
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(200);

        Label label = new Label(msg);

        Button yesBtn = new Button("是");
        Button noBtn = new Button("否");

        yesBtn.setOnAction(e->{
            answer = true;
            window.close();
        });

        noBtn.setOnAction(e->{
            window.close();
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, yesBtn, noBtn);
        label.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        return answer;
    }
}
