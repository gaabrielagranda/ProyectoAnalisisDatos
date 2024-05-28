package com.app.videogame.models.service;

import com.app.videogame.models.entity.dto.*;
import com.app.videogame.models.repository.VideoGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoGameServiceImpl implements VideoGameService{
    @Autowired
    private VideoGameRepository videoGameRepository;
    @Override
    public List<PublisherSalesDTO> findTop5ByOrderByTotalSalesDesc() {

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

    @Override
    public List<GlobalSalesDTO> findAvgGlobalSales() {
        return videoGameRepository.findAvgGlobalSalesBy();
    }

    @Override
    public CountDocument countVideoGame() {

        return videoGameRepository.totalVideoGames();
    }

    @Override
    public List<GenreSalesDTO> findGenreBy() {
        return videoGameRepository.findGenre();
    }


//    @Override
//    public List<RegionDTO> findRegions() {
//        return videoGameRepository.findRegionsBy();
//    }

}
