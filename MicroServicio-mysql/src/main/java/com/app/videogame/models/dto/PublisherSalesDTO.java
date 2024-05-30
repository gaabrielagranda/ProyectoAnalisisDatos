package com.app.videogame.models.dto;

import java.io.Serializable;

/**
 * Clase DTO (Data Transfer Object) que representa las ventas totales por editor de videojuegos.
 */
public class PublisherSalesDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Editor de videojuegos.
     */
    private String publisher;

    /**
     * Ventas totales en millones.
     */
    private double totalSales;

    /**
     * Constructor con parámetros.
     *
     * @param publisher Editor de videojuegos.
     * @param totalSales Ventas totales en millones.
     */
    public PublisherSalesDTO(String publisher, double totalSales) {
        this.publisher = publisher;
        this.totalSales = totalSales;
    }

    // Métodos getter y setter

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public double getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(double totalSales) {
        this.totalSales = totalSales;
    }

    @Override
    public String toString() {
        return "PublisherSalesDTO{" +
                "publisher='" + publisher + '\'' +
                ", totalSales=" + totalSales +
                '}';
    }
}
