package com.app.videogame.controller;

import com.app.videogame.modelo.dto.*;
import com.app.videogame.modelo.service.VideoGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping(value = "/api/video-game")
public class VideoGameConsultasController {

    @Autowired
    private VideoGameService videoGameService;

    @GetMapping(value = "/consulta/sales-of-top5")
    public List<PublisherSalesDTO> consultaTop5() {
        return videoGameService.findTop5();
    }

    @GetMapping(value = "/consulta/sales-of-years")
    public List<YearsSelasDTO> consultaYears() {
        return videoGameService.findByYears();
    }

    @GetMapping(value = "/consulta/sales-of-genre")
    public List<GenreSalesDTO> consultaGenres() {
        return videoGameService.findGenres();
    }

    @GetMapping(value = "/consulta/sales-of-platform")
    public List<PlatformSalesDTO> consultaPlatforms() {
        return videoGameService.findPlatforms();
    }

    @GetMapping(value = "/consulta/sales-of-global")
    public List<GlobalSalesDTO> consultaGlobals() {
        return videoGameService.findGlobalSales();
    }

//    @GetMapping(value = "/consulta/sales-of-region")
//    public List<RegionDTO> consultaRegions() {
//        return videoGameService.findRegions();
//    }
}
