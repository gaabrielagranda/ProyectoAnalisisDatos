package com.app.videogame.modelo.service;

import com.app.videogame.modelo.dto.*;
import com.app.videogame.modelo.repository.VideoGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideoGameServiceImpl implements VideoGameService{
    @Autowired
    private VideoGameRepository videoGameRepository;
    @Override
    public List<PublisherSalesDTO> findTop5() {
        return videoGameRepository.findTop5ByOrderByTotalSalesDesc();
    }

    @Override
    public List<YearsSelasDTO> findByYears() {
        return videoGameRepository.findYearsSelasBy();
    }

    @Override
    public List<GenreSalesDTO> findGenres() {
        return videoGameRepository.findGenresBy();
    }

    @Override
    public List<PlatformSalesDTO> findPlatforms() {
        return videoGameRepository.findPlatformsBy();
    }

    @Override
    public List<GlobalSalesDTO> findGlobalSales() {
        return videoGameRepository.findGlobalSalesBy();
    }

//    @Override
//    public List<RegionDTO> findRegions() {
//        return videoGameRepository.findRegionsBy();
//    }

}
