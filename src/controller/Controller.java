package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public ImageView imageView;
    @FXML
    Button btn;

    public void onClick(ActionEvent actionEvent) {
        System.out.println("点击了按钮");
        btn.setText("点击过了");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("初始化...");
        imageView.setImage(
                new Image("https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/logo_white.png"));
    }
}
