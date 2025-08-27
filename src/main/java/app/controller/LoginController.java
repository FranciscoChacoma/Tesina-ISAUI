package app.controller;

import app.model.UsuarioDAO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginController {

    @FXML private VBox rootVBox;
    @FXML private TextField nombreField;
    @FXML private PasswordField passwordField;

    @FXML
    private void loginUsuario() throws Exception {
        String nombre = nombreField.getText().trim();
        String password = passwordField.getText().trim();

        if (nombre.isEmpty() || password.isEmpty()) {
            mostrarAlerta("Error", "Por favor, completa todos los campos");
            return;
        }

        if (UsuarioDAO.validarLogin(nombre, password)) {
            Stage stage = (Stage) rootVBox.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/App.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root, 1370, 687);
            stage.setScene(scene);
            stage.show();
        } else {
            mostrarAlerta("Error", "Usuario o contraseña incorrecta");
        }
    }

    @FXML
    private void volver() throws Exception {
        Stage stage = (Stage) rootVBox.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Inicio.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 1370, 687);
        stage.setScene(scene);
        stage.show();
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
