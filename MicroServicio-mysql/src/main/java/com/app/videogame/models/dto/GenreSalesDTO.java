package com.app.videogame.models.dto;

import java.io.Serializable;

public class GenreSalesDTO implements Serializable {
    private String genre;
    private double totalSales;

    public GenreSalesDTO(String genre, double totalSales) {
        this.genre = genre;
        this.totalSales = totalSales;
    }

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
