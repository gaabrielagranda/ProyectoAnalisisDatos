package com.app.videogame.modelo.dto;

import java.io.Serializable;

public class RegionDTO implements Serializable
{
    private int year;
    private double eu_Sales;
    private double jp_Sales;
    private double na_Sales;
    private double other_sales;
    private double global_Sales;

    public RegionDTO(double eu_Sales, double jp_Sales, double na_Sales, double other_sales, double global_Sales, int year) {
        this.eu_Sales = eu_Sales;
        this.jp_Sales = jp_Sales;
        this.na_Sales = na_Sales;
        this.other_sales = other_sales;
        this.global_Sales = global_Sales;
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getEu_Sales() {
        return eu_Sales;
    }

    public void setEu_Sales(double eu_Sales) {
        this.eu_Sales = eu_Sales;
    }

    public double getJp_Sales() {
        return jp_Sales;
    }

    public void setJp_Sales(double jp_Sales) {
        this.jp_Sales = jp_Sales;
    }

    public double getNa_Sales() {
        return na_Sales;
    }

    public void setNa_Sales(double na_Sales) {
        this.na_Sales = na_Sales;
    }

    public double getOther_sales() {
        return other_sales;
    }

    public void setOther_sales(double other_sales) {
        this.other_sales = other_sales;
    }

    public double getGlobal_Sales() {
        return global_Sales;
    }

    public void setGlobal_Sales(double global_Sales) {
        this.global_Sales = global_Sales;
    }

    @Override
    public String toString() {
        return "RegionDTO{" +
                "year=" + year +
                ", eu_Sales=" + eu_Sales +
                ", jp_Sales=" + jp_Sales +
                ", na_Sales=" + na_Sales +
                ", other_sales=" + other_sales +
                ", global_Sales=" + global_Sales +
                '}';
    }
}
