package com.app.videogame.controller;

import com.app.videogame.modelo.entity.VideoGame;
import com.app.videogame.modelo.repository.VideoGameRepository;
import com.app.videogame.modelo.service.VideoGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/dashboard")
public class DashBoardController {

    @Autowired
    private VideoGameRepository videoGameRepository;

    @Autowired
    private VideoGameService videoGameService;

    @GetMapping(value = "/inicio")
    public String inicio(Model model) {
        List<VideoGame> videoGames = videoGameRepository.findAll();

        model.addAttribute("videogames", videoGames);
        model.addAttribute("totalSales", videoGameService.findGlobalSales());
        model.addAttribute("promedioTotalSales", videoGameService.findAvgGlobalSales());
        model.addAttribute("countDocument", videoGameService.countVideoGame());
        model.addAttribute("genreVideoGame", videoGameService.findGenreBy());
        return "./index";
    }

}
