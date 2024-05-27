package com.app.videogame.modelo.service;

import com.app.videogame.modelo.dto.*;
import com.app.videogame.modelo.entity.VideoGame;

import java.util.List;

public interface VideoGameService {
    List<PublisherSalesDTO> findTop5();

    List<YearsSelasDTO> findByYears();

    List<GenreSalesDTO> findGenres();

    List<PlatformSalesDTO> findPlatforms();

    List<GlobalSalesDTO> findGlobalSales();

    List<GlobalSalesDTO> findAvgGlobalSales();

    CountDocument countVideoGame();

    List<GenreSalesDTO> findGenreBy();

    List<RegionDTO> findRegions();







}
