package test;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TreeViewTest extends BaseApplication {
    private Stage window;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("列表");
        Label label = new Label("选择你喜欢的直播平台");

        TreeItem<String> treeItem2 = new CheckBoxTreeItem<>("直播平台");
        TreeItem<String> treeItem3 = new CheckBoxTreeItem<>("斗鱼");
        TreeItem<String> treeItem4 = new CheckBoxTreeItem<>("虎牙");
        TreeItem<String> treeItem5 = new CheckBoxTreeItem<>("熊猫");

        treeItem2.setExpanded(true);
        treeItem2.getChildren().add(treeItem3);
        treeItem2.getChildren().add(treeItem4);
        treeItem2.getChildren().add(treeItem5);

        treeItem3.getChildren().addAll(new CheckBoxTreeItem<>("LOL"),
                new CheckBoxTreeItem<>("绝地求生"),
                new CheckBoxTreeItem<>("王者荣耀"));

        TreeView<String> treeView = new TreeView<>(treeItem2);
        treeView.setShowRoot(false);

        treeView.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> {
                    if(newValue!=null){
                        println(newValue.getValue());
                    }
                });

        Button btn = new Button("Test");
        btn.setOnAction(e->{

        });

        VBox vBox = new VBox();
        vBox.setPadding(new Insets(20,20,20,20));
        vBox.setSpacing(10);//设置子视图间距
        vBox.getChildren().addAll(label,treeView,btn);
        Scene scene = new Scene(vBox, 320,300);//场景,类似于Android中的Activity
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
