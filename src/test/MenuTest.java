package test;

import bean.Product;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utils.AlertDialog;
import utils.TextUtils;

public class MenuTest extends BaseApplication {

    private Stage window;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("书库");
        Menu fileMenu = new Menu("文件");

        MenuItem setItem = new MenuItem("设置");

        fileMenu.getItems().addAll(getMenuItem("新建",e->pln("新建")),
                new SeparatorMenuItem(),
                getMenuItem("打开",e->pln("打开")),
                new SeparatorMenuItem(),
                getMenuItem("保存",e->pln("保存")),
                new SeparatorMenuItem(),
                getMenuItem("另存为",e->pln("另存为")),
                new SeparatorMenuItem(),
                getMenuItem("退出",true));

        Menu editMenu = new Menu("编辑");
        editMenu.getItems().addAll(new MenuItem("剪切"),
                new SeparatorMenuItem(),
                new MenuItem("复制"),
                new SeparatorMenuItem(),
                new MenuItem("删除"));

        Menu helpMenu = new Menu("帮助");
        CheckMenuItem checkMenuItem = new CheckMenuItem("反馈");
        checkMenuItem.setOnAction(e->{
            if(checkMenuItem.isSelected()){
                pln("显示");
            }else {
                pln("隐藏");
            }
        });
        CheckMenuItem autoSaveItem = new CheckMenuItem("自动保存");
        autoSaveItem.setSelected(true);
        autoSaveItem.setOnAction(e->{
            if(checkMenuItem.isSelected()){
                pln("自动保存");
            }else {
                pln("不自动保存");
            }
        });
        helpMenu.getItems().addAll(new MenuItem("关于"),
                new SeparatorMenuItem(),
                new MenuItem("检查更新"),
                checkMenuItem,autoSaveItem);

        Menu mainTitleMenu = new Menu("主题");
        RadioMenuItem radio1 = new RadioMenuItem("蓝色");
        RadioMenuItem radio2 = new RadioMenuItem("红色");
        RadioMenuItem radio3 = new RadioMenuItem("黑色");
        ToggleGroup toggleGroup = new ToggleGroup();
        radio1.setToggleGroup(toggleGroup);
        radio2.setToggleGroup(toggleGroup);
        radio3.setToggleGroup(toggleGroup);
        mainTitleMenu.getItems().addAll(radio1,radio2,radio3);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu,editMenu,mainTitleMenu,helpMenu);

        VBox vBox = new VBox();
        vBox.setSpacing(10);//设置子视图间距
        vBox.getChildren().addAll(menuBar);
        Scene scene = new Scene(vBox, 380,300);//场景,类似于Android中的Activity
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public MenuItem getMenuItem(String text, EventHandler<ActionEvent> handler){
        MenuItem menuItem = new MenuItem(text);
        menuItem.setOnAction(handler);
        return menuItem;
    }

    public MenuItem getMenuItem(String text, boolean disable){
        MenuItem menuItem = new MenuItem(text);
        menuItem.setDisable(disable);
        return menuItem;
    }

}
