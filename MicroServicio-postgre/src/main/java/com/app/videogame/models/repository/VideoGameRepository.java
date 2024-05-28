package com.app.videogame.models.repository;

import com.app.videogame.models.entity.VideoGame;
import com.app.videogame.models.entity.dto.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoGameRepository extends JpaRepository<VideoGame, Long> {
    @Query(value = "SELECT new com.app.videogame.models.entity.dto.PublisherSalesDTO( v.publisher, round(SUM(v.global_Sales),2)) FROM VideoGame v GROUP BY v.publisher ORDER BY SUM(v.global_Sales) DESC limit 5")
    List<PublisherSalesDTO> findTop5ByOrderByTotalSalesDesc();

    @Query(value = "SELECT new com.app.videogame.models.entity.dto.YearsSelasDTO(v.year, ROUND(SUM(v.global_Sales),2)) from VideoGame v GROUP BY v.year order by v.year asc ")
    List<YearsSelasDTO> findYearsSelasBy();

    @Query(value = "SELECT new com.app.videogame.models.entity.dto.GenreSalesDTO(v.genre, ROUND(SUM(v.global_Sales),2)) from VideoGame v group by v.genre order by sum(v.global_Sales) desc")
    List<GenreSalesDTO> findGenresBy();

    @Query(value = "SELECT new com.app.videogame.models.entity.dto.PlatformSalesDTO(v.platform, ROUND(SUM(v.global_Sales),2)) from VideoGame v GROUP BY v.platform ORDER BY SUM(v.global_Sales) desc ")
    List<PlatformSalesDTO> findPlatformsBy();

    @Query(value = "SELECT new com.app.videogame.models.entity.dto.GlobalSalesDTO(ROUND(SUM(v.global_Sales),2)) from VideoGame v")
    List<GlobalSalesDTO> findGlobalSalesBy();

//    @Query(value = "SELECT NEW com.app.videogame.modelo.dto.RegionDTO(ROUND(sum(v.na_sales),2), ROUND(sum(v.eu_sales),2), ROUND(sum(v.jp_sales),2)  from VVideoGame v ")
//    List<RegionDTO> findRegionsBy();

    @Query(value = "SELECT new com.app.videogame.models.entity.dto.GlobalSalesDTO(ROUND(avg(v.global_Sales),3)) from VideoGame v")
    List<GlobalSalesDTO> findAvgGlobalSalesBy();

    @Query("SELECT new com.app.videogame.models.entity.dto.CountDocument(count(v.id)) from VideoGame v")
    CountDocument totalVideoGames();

    @Query("SELECT new  com.app.videogame.models.entity.dto.GenreSalesDTO(genre, sum(global_Sales)) FROM VideoGame  Group by genre order by genre Limit 1")
    List<GenreSalesDTO> findGenre();
}


