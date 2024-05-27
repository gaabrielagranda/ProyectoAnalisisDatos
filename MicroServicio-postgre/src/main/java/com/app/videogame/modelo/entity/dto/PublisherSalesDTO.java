package com.app.videogame.modelo.entity.dto;

import java.io.Serializable;

public class PublisherSalesDTO  implements Serializable {
    private String publisher;
    private double totalSales; // O el tipo de dato adecuado para las ventas totales

    // Constructor
    public PublisherSalesDTO(String publisher, double totalSales) {
        this.publisher = publisher;
        this.totalSales = totalSales;
    }

    // Getters y setters

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

    // Opcional: puedes agregar otros métodos si es necesario
}
