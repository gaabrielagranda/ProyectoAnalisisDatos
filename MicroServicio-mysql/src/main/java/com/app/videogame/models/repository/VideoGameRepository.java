package com.app.videogame.models.repository;

import com.app.videogame.models.dto.*;
import com.app.videogame.models.entity.VideoGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositorio para gestionar operaciones CRUD en la entidad VideoGame.
 */
@Repository
public interface VideoGameRepository extends JpaRepository<VideoGame, Long> {

    /**
     * Obtiene los 5 principales editores ordenados por ventas globales totales en orden descendente.
     *
     * @return Lista de PublisherSalesDTO.
     */
    @Query("SELECT NEW com.app.videogame.models.dto.PublisherSalesDTO(v.publisher, ROUND(SUM(v.global_Sales), 2)) " +
            "FROM VideoGame v GROUP BY v.publisher ORDER BY SUM(v.global_Sales) DESC")
    List<PublisherSalesDTO> findTop5ByOrderByTotalSalesDesc();

    /**
     * Obtiene las ventas globales agrupadas por año en orden ascendente.
     *
     * @return Lista de YearsSelasDTO.
     */
    @Query("SELECT NEW com.app.videogame.models.dto.YearsSelasDTO(v.year, ROUND(SUM(v.global_Sales), 2)) " +
            "FROM VideoGame v GROUP BY v.year ORDER BY v.year ASC")
    List<YearsSelasDTO> findYearsSelasBy();

    /**
     * Obtiene las ventas globales agrupadas por género en orden descendente.
     *
     * @return Lista de GenreSalesDTO.
     */
    @Query("SELECT NEW com.app.videogame.models.dto.GenreSalesDTO(v.genre, ROUND(SUM(v.global_Sales), 2)) " +
            "FROM VideoGame v GROUP BY v.genre ORDER BY SUM(v.global_Sales) DESC")
    List<GenreSalesDTO> findGenresBy();

    /**
     * Obtiene las ventas globales agrupadas por plataforma en orden descendente.
     *
     * @return Lista de PlatformSalesDTO.
     */
    @Query("SELECT NEW com.app.videogame.models.dto.PlatformSalesDTO(v.platform, ROUND(SUM(v.global_Sales), 2)) " +
            "FROM VideoGame v GROUP BY v.platform ORDER BY SUM(v.global_Sales) DESC")
    List<PlatformSalesDTO> findPlatformsBy();

    /**
     * Obtiene las ventas globales totales.
     *
     * @return Lista de GlobalSalesDTO.
     */
    @Query("SELECT NEW com.app.videogame.models.dto.GlobalSalesDTO(ROUND(SUM(v.global_Sales), 2)) " +
            "FROM VideoGame v")
    List<GlobalSalesDTO> findGlobalSalesBy();

    /**
     * Obtiene las ventas por región agrupadas por año en orden ascendente.
     *
     * @return Lista de RegionDTO.
     */
    @Query("SELECT NEW com.app.videogame.models.dto.RegionDTO(ROUND(SUM(v.na_Sales), 2), ROUND(SUM(v.eu_Sales), 2), " +
            "ROUND(SUM(v.jp_Sales), 2), ROUND(SUM(v.other_Sales), 2), ROUND(SUM(v.global_Sales), 2), v.year) " +
            "FROM VideoGame v GROUP BY v.year ORDER BY v.year ASC")
    List<RegionDTO> findRegionsBy();

    /**
     * Obtiene el promedio de ventas globales.
     *
     * @return Lista de GlobalSalesDTO.
     */
    @Query("SELECT NEW com.app.videogame.models.dto.GlobalSalesDTO(ROUND(AVG(v.global_Sales), 3)) " +
            "FROM VideoGame v")
    List<GlobalSalesDTO> findAvgGlobalSalesBy();

    /**
     * Obtiene el total de videojuegos.
     *
     * @return CountDocument.
     */
    @Query("SELECT NEW com.app.videogame.models.dto.CountDocument(COUNT(v.id)) " +
            "FROM VideoGame v")
    CountDocument totalVideoGames();

    /**
     * Obtiene el género con la mayor venta global.
     *
     * @return Lista de GenreSalesDTO.
     */
    @Query("SELECT NEW com.app.videogame.models.dto.GenreSalesDTO(v.genre, SUM(v.global_Sales)) " +
            "FROM VideoGame v GROUP BY v.genre ORDER BY SUM(v.global_Sales) DESC")
    List<GenreSalesDTO> findTopGenreBySales();
}
