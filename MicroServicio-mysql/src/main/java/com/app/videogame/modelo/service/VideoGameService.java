package com.app.videogame.modelo.service;

import com.app.videogame.modelo.dto.*;

import java.util.List;
import java.util.Optional;

public interface VideoGameService {
    List<PublisherSalesDTO> findTop5();

    List<YearsSelasDTO> findByYears();

    List<GenreSalesDTO> findGenres();

    List<PlatformSalesDTO> findPlatforms();

    List<GlobalSalesDTO> findGlobalSales();

//    List<RegionDTO> findRegions();



}
