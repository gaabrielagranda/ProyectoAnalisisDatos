package com.app.videogame.modelo.service;

import com.app.videogame.modelo.entity.dto.*;
import org.springframework.data.domain.Pageable;

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
