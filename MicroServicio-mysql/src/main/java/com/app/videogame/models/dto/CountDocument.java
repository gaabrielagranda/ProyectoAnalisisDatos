package com.app.videogame.models.dto;

import java.io.Serializable;

/**
 * Clase DTO (Data Transfer Object) que representa el conteo de documentos.
 */
public class CountDocument implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Número total de documentos.
     */
    private Long totalDocument;

    /**
     * Constructor con parámetros.
     *
     * @param totalDocument Número total de documentos.
     */
    public CountDocument(Long totalDocument) {
        this.totalDocument = totalDocument;
    }

    // Métodos getter y setter

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
