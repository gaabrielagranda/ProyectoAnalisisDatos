package com.app.videogame.models.service;

import com.app.videogame.models.entity.dto.*;

import java.util.List;

public interface VideoGameService {


    List<PublisherSalesDTO> findTop5ByOrderByTotalSalesDesc();

    List<YearsSelasDTO> findByYears();

    List<GenreSalesDTO> findGenres();

    List<PlatformSalesDTO> findPlatforms();

    List<GlobalSalesDTO> findGlobalSales();

    List<GlobalSalesDTO> findAvgGlobalSales();

    CountDocument countVideoGame();

    List<GenreSalesDTO> findGenreBy();






}
