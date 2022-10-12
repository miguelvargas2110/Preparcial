package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

import java.io.IOException;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("/view/Menu.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Empleado(){
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/Empleado.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Creacion de Estudiante");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void Producto(){
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/Producto.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Creacion de Producto");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
