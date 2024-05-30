package com.app.videogame.models.dto;

import java.io.Serializable;

/**
 * Clase DTO (Data Transfer Object) que representa las ventas totales de videojuegos por año.
 */
public class YearsSelasDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private int year;
    private double totalSales;

    /**
     * Constructor con parámetros.
     *
     * @param year Año de las ventas.
     * @param totalSales Ventas totales en millones.
     */
    public YearsSelasDTO(int year, double totalSales) {
        this.year = year;
        this.totalSales = totalSales;
    }

    // Métodos getter y setter

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(double totalSales) {
        this.totalSales = totalSales;
    }

    @Override
    public String toString() {
        return "YearsSelasDTO{" +
                "year=" + year +
                ", totalSales=" + totalSales +
                '}';
    }
}
