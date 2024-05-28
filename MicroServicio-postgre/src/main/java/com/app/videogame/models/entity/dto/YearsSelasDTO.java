package com.app.videogame.models.entity.dto;

import java.io.Serializable;

public class YearsSelasDTO implements Serializable {
    private int year;
        private double totalSales; // O el tipo de dato adecuado para las ventas totales

        // Constructor
        public YearsSelasDTO(int year, double totalSales) {
            this.year = year;
            this.totalSales = totalSales;
        }

        // Getters y setters


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

    // Opcional: puedes agregar otros métodos si es necesario
    }

