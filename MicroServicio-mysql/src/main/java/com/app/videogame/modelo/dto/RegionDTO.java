package com.app.videogame.modelo.dto;

import java.io.Serializable;

public class RegionDTO implements Serializable
{
    private double eu_Sales;
    private double jp_Sales;
    private double na_Sales;

    public RegionDTO(double eu_Sales, double jp_Sales, double na_Sales) {
        this.eu_Sales = eu_Sales;
        this.jp_Sales = jp_Sales;
        this.na_Sales = na_Sales;
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

    @Override
    public String toString() {
        return "RegionDTO{" +
                "eu_Sales=" + eu_Sales +
                ", jp_Sales=" + jp_Sales +
                ", na_Sales=" + na_Sales +
                '}';
    }
}
