package com.app.videogame.models.service;

import com.app.videogame.models.dto.*;

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
