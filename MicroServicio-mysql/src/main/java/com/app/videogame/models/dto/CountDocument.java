package com.app.videogame.models.dto;

import java.io.Serializable;

public class CountDocument implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long totalDocument;


    public CountDocument(Long totalDocument) {
        this.totalDocument = totalDocument;
    }

    public Long getTotalDocument() {
        return totalDocument;
    }

    public void setTotalDocument(Long totalDocument) {
        this.totalDocument = totalDocument;
    }

    @Override
    public String toString() {
        return "CountDocument{" +
                "totalDocument=" + totalDocument +
                '}';
    }
}
