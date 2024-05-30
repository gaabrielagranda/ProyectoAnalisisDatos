package com.app.videogame.models.dto;

import java.io.Serializable;

/**
 * Clase DTO (Data Transfer Object) que representa las ventas totales por género de videojuegos.
 */
public class GenreSalesDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Género del videojuego.
     */
    private String genre;

    /**
     * Ventas totales del género en millones.
     */
    private double totalSales;

    /**
     * Constructor con parámetros.
     *
     * @param genre Género del videojuego.
     * @param totalSales Ventas totales del género.
     */
    public GenreSalesDTO(String genre, double totalSales) {
        this.genre = genre;
        this.totalSales = totalSales;
    }

    // Métodos getter y setter

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(double totalSales) {
        this.totalSales = totalSales;
    }

    @Override
    public String toString() {
        return "GenreSalesDTO{" +
                "genre='" + genre + '\'' +
                ", totalSales=" + totalSales +
                '}';
    }
}
