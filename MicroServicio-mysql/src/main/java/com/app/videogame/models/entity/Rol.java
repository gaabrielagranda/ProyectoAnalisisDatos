package com.app.videogame.models.entity;

import jakarta.persistence.*;

/**
 * Clase que representa un rol en el sistema.
 */
@Entity
@Table(name = "roles")
public class Rol {

    /**
     * Identificador único del rol.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre del rol.
     */
    private String nombre;

    /**
     * Constructor por defecto.
     */
    public Rol() {
    }

    /**
     * Constructor con parámetros.
     *
     * @param nombre Nombre del rol.
     */
    public Rol(String nombre) {
        this.nombre = nombre;
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
}
