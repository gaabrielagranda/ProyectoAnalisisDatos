package com.app.videogame.models.entity;

import jakarta.persistence.*;
import java.util.Collection;

/**
 * Clase que representa un usuario en el sistema.
 */
@Entity
@Table(name = "usuarios", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Usuario {

    /**
     * Identificador único del usuario.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre del usuario.
     */
    private String nombre;

    /**
     * Apellido del usuario.
     */
    private String apellido;

    /**
     * Email del usuario. Debe ser único.
     */
    private String email;

    /**
     * Contraseña del usuario.
     */
    private String password;

    /**
     * Roles asociados al usuario. Relación Many-to-Many con la entidad Rol.
     */
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "usuario_role",
            joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Collection<Rol> roles;

    /**
     * Constructor por defecto.
     */
    public Usuario() {
    }

    /**
     * Constructor con parámetros.
     *
     * @param nombre Nombre del usuario.
     * @param apellido Apellido del usuario.
     * @param email Email del usuario.
     * @param password Contraseña del usuario.
     * @param roles Roles asociados al usuario.
     */
    public Usuario(String nombre, String apellido, String email, String password, Collection<Rol> roles) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    /**
     * Constructor con todos los atributos, incluido el ID.
     *
     * @param id Identificador único del usuario.
     * @param nombre Nombre del usuario.
     * @param apellido Apellido del usuario.
     * @param email Email del usuario.
     * @param password Contraseña del usuario.
     * @param roles Roles asociados al usuario.
     */
    public Usuario(Long id, String nombre, String apellido, String email, String password, Collection<Rol> roles) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.roles = roles;
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

    public Collection<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Rol> roles) {
        this.roles = roles;
    }
}
