package app.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;

public class InicioController {

    @FXML
    private VBox rootVBox;

    @FXML
    private void abrirLogin() throws Exception {
        Stage stage = (Stage) rootVBox.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Login.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 1370, 687);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void abrirRegistro() throws Exception {
        Stage stage = (Stage) rootVBox.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Registro.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 1370, 687);
        stage.setScene(scene);
        stage.show();
    }
}
