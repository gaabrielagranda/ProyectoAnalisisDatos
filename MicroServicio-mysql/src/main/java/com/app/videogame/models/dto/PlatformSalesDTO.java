package com.app.videogame.models.dto;

import java.io.Serializable;

/**
 * Clase DTO (Data Transfer Object) que representa las ventas totales por plataforma de videojuegos.
 */
public class PlatformSalesDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Plataforma de videojuegos.
     */
    private String platform;

    /**
     * Ventas totales en millones.
     */
    private double totalVentas;

    /**
     * Constructor con parámetros.
     *
     * @param platform Plataforma de videojuegos.
     * @param totalVentas Ventas totales en millones.
     */
    public PlatformSalesDTO(String platform, double totalVentas) {
        this.platform = platform;
        this.totalVentas = totalVentas;
    }

    // Métodos getter y setter

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public double getTotalVentas() {
        return totalVentas;
    }

    public void setTotalVentas(double totalVentas) {
        this.totalVentas = totalVentas;
    }

    @Override
    public String toString() {
        return "PlatformSalesDTO{" +
                "platform='" + platform + '\'' +
                ", totalVentas=" + totalVentas +
                '}';
    }
}
