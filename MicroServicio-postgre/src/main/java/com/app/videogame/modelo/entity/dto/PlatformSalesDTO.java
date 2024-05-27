package com.app.videogame.modelo.entity.dto;

import java.io.Serializable;

public class PlatformSalesDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String platform;
    private double totalVentas;

    public PlatformSalesDTO(String platform, double totalVentas) {
        this.platform = platform;
        this.totalVentas = totalVentas;
    }

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
