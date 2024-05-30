package com.app.videogame.models.dto;

/**
 * Clase DTO (Data Transfer Object) que representa los datos de registro de un usuario.
 */
public class UsuarioRegistarDto {

    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String password;

    /**
     * Constructor con parámetro apellido.
     *
     * @param apellido Apellido del usuario.
     */
    public UsuarioRegistarDto(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Constructor con todos los parámetros.
     *
     * @param id Identificador del usuario.
     * @param nombre Nombre del usuario.
     * @param apellido Apellido del usuario.
     * @param email Correo electrónico del usuario.
     * @param password Contraseña del usuario.
     */
    public UsuarioRegistarDto(Long id, String nombre, String apellido, String email, String password) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
    }

    /**
     * Constructor con parámetros nombre, apellido, email y password.
     *
     * @param nombre Nombre del usuario.
     * @param apellido Apellido del usuario.
     * @param email Correo electrónico del usuario.
     * @param password Contraseña del usuario.
     */
    public UsuarioRegistarDto(String nombre, String apellido, String email, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
    }

    /**
     * Constructor con parámetros apellido y email.
     *
     * @param apellido Apellido del usuario.
     * @param email Correo electrónico del usuario.
     */
    public UsuarioRegistarDto(String apellido, String email) {
        this.apellido = apellido;
        this.email = email;
    }

    /**
     * Constructor por defecto.
     */
    public UsuarioRegistarDto() {
    }

    // Métodos getter y setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
