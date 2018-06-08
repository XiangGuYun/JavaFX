package test;

import bean.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import utils.AlertDialog;
import utils.TextUtils;

import java.util.function.Predicate;

public class TableViewTest extends BaseApplication {
    private Stage window;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("书库");
        Label label = new Label("书单");

        TableView<Product> tableView = new TableView<>();

        TableColumn<Product,String> nameCol = new TableColumn<>("Name");
        nameCol.setMinWidth(120);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Product,Double> priceCol = new TableColumn<>("Price");
        priceCol.setMinWidth(120);
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<Product,Integer> quantityCol = new TableColumn<>("Quantity");
        quantityCol.setMinWidth(120);
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        TextField nameField = new TextField("Name");
        TextField priceField = new TextField("Price");
        TextField quantityField = new TextField("Quantity");

        tableView.setItems(getProducts());
        tableView.getColumns().addAll(nameCol,priceCol,quantityCol);

        Button btnAdd = new Button("add");
        btnAdd.setMinWidth(60);
        btnAdd.setOnAction(e->{
            if(!TextUtils.isDigitsOnly(priceField.getText())){
                AlertDialog.display("提示","价格只能是数字");
                return;
            }
            if(!TextUtils.isDigitsOnly(quantityField.getText())){
                AlertDialog.display("提示","品质只能是数字");
                return;
            }
            tableView.getItems().add(new Product(
                    nameField.getText(),
                    Double.parseDouble(priceField.getText()),
                    Integer.parseInt(quantityField.getText())
            ));
        });

        Button btnDlt = new Button("delete");
        btnDlt.setMinWidth(60);
        btnDlt.setOnMouseClicked(e->{
            tableView.getItems().removeIf(product ->
                    product.getName().equals(nameField.getText())||
                    String.valueOf(product.getPrice()).equals(priceField.getText())||
                    String.valueOf(product.getQuantity()).equals(quantityField.getText())
            );
        });

        HBox box = new HBox();
        box.setPadding(new Insets(10,0,10,0));
        box.setSpacing(10);
        box.getChildren().addAll(nameField,priceField,quantityField,btnAdd,btnDlt);

        VBox vBox = new VBox();
        vBox.setPadding(new Insets(20,20,20,20));
        vBox.setSpacing(10);//设置子视图间距
        vBox.getChildren().addAll(label,tableView,box);
        Scene scene = new Scene(vBox, 380,300);//场景,类似于Android中的Activity
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public ObservableList<Product> getProducts(){
        ObservableList<Product> products = FXCollections.observableArrayList();
        products.add(new Product("三国志",12.4,100));
        products.add(new Product("左传",4,100));
        products.add(new Product("资治通鉴",52,100));
        return products;
    }

}
