package app.controller;

import app.model.Usuario;
import app.model.UsuarioDAO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Parent;

public class RegistroController {

    @FXML private TextField nombreField;
    @FXML private TextField emailField;
    @FXML private PasswordField passwordField;

    @FXML
    private void guardarUsuario() {
        String nombre = nombreField.getText().trim();
        String email = emailField.getText().trim();
        String password = passwordField.getText().trim();

        if (nombre.isEmpty() || email.isEmpty() || password.isEmpty()) {
            mostrarAlerta("Error", "Por favor, completa todos los campos");
            return;
        }

        if (UsuarioDAO.existeEmail(email)) {
            mostrarAlerta("Error", "Este correo ya está registrado");
            return;
        }

        Usuario usuario = new Usuario(nombre, email, password);
        if (UsuarioDAO.insertar(usuario)) {
            mostrarAlerta("Éxito", "Usuario registrado correctamente");
            nombreField.clear();
            emailField.clear();
            passwordField.clear();
        } else {
            mostrarAlerta("Error", "No se pudo registrar el usuario");
        }
    }

    @FXML
    private void volverInicio() throws Exception {
        Stage stage = (Stage) nombreField.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Inicio.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 1370, 687);
        stage.setScene(scene);
        stage.setWidth(1370);
        stage.setHeight(687);
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
