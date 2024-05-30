package com.app.videogame.models.entity;

import jakarta.persistence.*;

/**
 * Clase que representa un videojuego en el sistema.
 */
@Entity
@Table(name = "videogames")
public class VideoGame {

    /**
     * Identificador único del videojuego.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre del videojuego.
     */
    private String name;

    /**
     * Plataforma en la que se puede jugar el videojuego.
     */
    private String platform;

    /**
     * Año de lanzamiento del videojuego.
     */
    private int year;

    /**
     * Género del videojuego.
     */
    private String genre;

    /**
     * Editor del videojuego.
     */
    private String publisher;

    /**
     * Ventas en América del Norte en millones.
     */
    private double na_Sales;

    /**
     * Ventas en Europa en millones.
     */
    private double eu_Sales;

    /**
     * Ventas en Japón en millones.
     */
    private double jp_Sales;

    /**
     * Ventas en otros mercados en millones.
     */
    private double other_Sales;

    /**
     * Ventas globales en millones.
     */
    private double global_Sales;

    /**
     * Constructor por defecto.
     */
    public VideoGame() {
    }

    /**
     * Constructor con parámetros.
     *
     * @param name Nombre del videojuego.
     * @param platform Plataforma del videojuego.
     * @param year Año de lanzamiento.
     * @param genre Género del videojuego.
     * @param publisher Editor del videojuego.
     * @param na_Sales Ventas en América del Norte.
     * @param eu_Sales Ventas en Europa.
     * @param jp_Sales Ventas en Japón.
     * @param other_Sales Ventas en otros mercados.
     * @param global_Sales Ventas globales.
     */
    public VideoGame(String name, String platform, int year, String genre, String publisher, double na_Sales, double eu_Sales, double jp_Sales, double other_Sales, double global_Sales) {
        this.name = name;
        this.platform = platform;
        this.year = year;
        this.genre = genre;
        this.publisher = publisher;
        this.na_Sales = na_Sales;
        this.eu_Sales = eu_Sales;
        this.jp_Sales = jp_Sales;
        this.other_Sales = other_Sales;
        this.global_Sales = global_Sales;
    }

    // Métodos getter y setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public double getNaSales() {
        return na_Sales;
    }

    public void setNaSales(double na_Sales) {
        this.na_Sales = na_Sales;
    }

    public double getEuSales() {
        return eu_Sales;
    }

    public void setEuSales(double eu_Sales) {
        this.eu_Sales = eu_Sales;
    }

    public double getJpSales() {
        return jp_Sales;
    }

    public void setJpSales(double jp_Sales) {
        this.jp_Sales = jp_Sales;
    }

    public double getOtherSales() {
        return other_Sales;
    }

    public void setOtherSales(double other_Sales) {
        this.other_Sales = other_Sales;
    }

    public double getGlobalSales() {
        return global_Sales;
    }

    public void setGlobalSales(double global_Sales) {
        this.global_Sales = global_Sales;
    }

    @Override
    public String toString() {
        return "VideoGame{" +
                "name='" + name + '\'' +
                ", platform='" + platform + '\'' +
                ", year=" + year +
                ", genre='" + genre + '\'' +
                ", publisher='" + publisher + '\'' +
                ", naSales=" + na_Sales +
                ", euSales=" + eu_Sales +
                ", jpSales=" + jp_Sales +
                ", otherSales=" + other_Sales +
                ", globalSales=" + global_Sales +
                '}';
    }
}
