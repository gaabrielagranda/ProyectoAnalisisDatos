package com.app.videogame.models.service;

import com.app.videogame.models.dto.*;
import java.util.List;

/**
 * Interfaz para definir los métodos de servicio relacionados con los videojuegos.
 */
public interface VideoGameService {

    /**
     * Obtiene los 5 principales editores por ventas globales.
     *
     * @return Lista de PublisherSalesDTO.
     */
    List<PublisherSalesDTO> findTop5();

    /**
     * Obtiene las ventas globales por año.
     *
     * @return Lista de YearsSelasDTO.
     */
    List<YearsSelasDTO> findByYears();

    /**
     * Obtiene las ventas globales por género.
     *
     * @return Lista de GenreSalesDTO.
     */
    List<GenreSalesDTO> findGenres();

    /**
     * Obtiene las ventas globales por plataforma.
     *
     * @return Lista de PlatformSalesDTO.
     */
    List<PlatformSalesDTO> findPlatforms();

    /**
     * Obtiene las ventas globales totales.
     *
     * @return Lista de GlobalSalesDTO.
     */
    List<GlobalSalesDTO> findGlobalSales();

    /**
     * Obtiene el promedio de ventas globales.
     *
     * @return Lista de GlobalSalesDTO.
     */
    List<GlobalSalesDTO> findAvgGlobalSales();

    /**
     * Obtiene el número total de videojuegos.
     *
     * @return CountDocument.
     */
    CountDocument countVideoGame();

    /**
     * Obtiene el género con la mayor venta global.
     *
     * @return Lista de GenreSalesDTO.
     */
    List<GenreSalesDTO> findGenreBy();

    /**
     * Obtiene las ventas por región.
     *
     * @return Lista de RegionDTO.
     */
    List<RegionDTO> findRegions();
}
