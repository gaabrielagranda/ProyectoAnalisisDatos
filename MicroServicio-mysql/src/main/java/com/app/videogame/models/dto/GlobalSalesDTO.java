package com.app.videogame.models.dto;

import java.io.Serializable;

/**
 * Clase DTO (Data Transfer Object) que representa las ventas globales totales de videojuegos.
 */
public class GlobalSalesDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Ventas globales totales en millones.
     */
    private double totalGlobal;

    /**
     * Constructor con parámetros.
     *
     * @param totalGlobal Ventas globales totales.
     */
    public GlobalSalesDTO(double totalGlobal) {
        this.totalGlobal = totalGlobal;
    }

    // Métodos getter y setter

    public double getTotalGlobal() {
        return totalGlobal;
    }

    public void setTotalGlobal(double totalGlobal) {
        this.totalGlobal = totalGlobal;
    }

    @Override
    public String toString() {
        return "GlobalSalesDTO{" +
                "totalGlobal=" + totalGlobal +
                '}';
    }
}
