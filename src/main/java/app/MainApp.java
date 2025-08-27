package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Inicio.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1370, 687);
        stage.setTitle("Sistema Abogados");
        stage.setScene(scene);
        stage.setResizable(false); // no se puede redimensionar
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
