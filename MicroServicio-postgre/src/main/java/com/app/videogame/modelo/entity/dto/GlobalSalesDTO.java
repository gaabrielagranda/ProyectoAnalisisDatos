package com.app.videogame.modelo.entity.dto;

import java.io.Serializable;

public class GlobalSalesDTO implements Serializable {

    private double totalGlobal;

    public GlobalSalesDTO(double totalGlobal) {
        this.totalGlobal = totalGlobal;
    }

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
