import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utils.AlertDialog;
import utils.ConfirmDialog;

/**
 * StackPane堆面板-下个元素会覆盖在上个元素上面-类似于Android中的FrameLayout
 * VBox-类似于Android中的垂直线性布局,与其相对的是HBox
 * BorderPane-类似于Android中的相对布局
 * GridPane-类似于Android中的网格布局
 */
public class Main extends Application implements EventHandler<ActionEvent>{

    Button button;
    private Stage window;

    public static void main(String[] args) {
        launch(args);//启动
    }

    /**
     * 类似于Android中的onCreate方法,执行初始化的操作
     * @param primaryStage 类似于Android中的window
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        primaryStage.setTitle("标题");

        button = new Button("点击我");//button.setText("点击我");
        button.setOnAction(event -> {//设置点击事件
            AlertDialog.display("标题","茉莉清茶");
        });

        Button btnConfirm = new Button("确认对话框");
        btnConfirm.setOnAction(e->{
            boolean result = ConfirmDialog.display("标题", "666666");
            System.out.println(result);
        });

        Button closeProgramBtn = new Button("退出");
        closeProgramBtn.setOnAction(e->{
            closeProgram();
        });

        //监听窗口的关闭事件
        window.setOnCloseRequest(e->{
            e.consume();
            closeProgram();
        });

        VBox layout = new VBox();
        layout.setAlignment(Pos.BASELINE_CENTER);
        layout.getChildren().addAll(button, btnConfirm, closeProgramBtn);
        Scene scene = new Scene(layout, 320,240);//场景,类似于Android中的Activity
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * 退出
     */
    private void closeProgram() {
        if(ConfirmDialog.display("标题", "确定要退出吗?")) window.close();
    }

    /**
     * 处理监听事件的第二种方案
     * @param event
     */
    @Override
    public void handle(ActionEvent event) {
        if(event.getSource()==button){
            //....
        }
    }
}
