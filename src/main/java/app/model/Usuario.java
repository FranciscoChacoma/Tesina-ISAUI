package app.model;

public class Usuario {
    private String nombre;
    private String email;
    private String password; // NUEVO

    public Usuario(String nombre, String email, String password) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("El email no puede estar vacío.");
        }
        if (password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("La contraseña no puede estar vacía.");
        }
        this.nombre = nombre;
        this.email = email;
        this.password = password; // NUEVO
    }

    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public String getPassword() { return password; } // NUEVO
}
