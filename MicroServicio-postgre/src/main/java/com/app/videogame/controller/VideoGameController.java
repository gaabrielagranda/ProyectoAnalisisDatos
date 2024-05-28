package com.app.videogame.controller;

import com.app.videogame.models.entity.VideoGame;
import com.app.videogame.models.repository.VideoGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/video-game")
public class VideoGameController {


    @Autowired
    private VideoGameRepository videoGameRepository;

    @GetMapping(value = "/listar")
    public List<VideoGame> listar() {
        return videoGameRepository.findAll();
    }

    @PostMapping(value = "/insertar")
    @ResponseStatus(HttpStatus.CREATED)
    public List<VideoGame> insertar(@RequestBody List<VideoGame> videoGames) {
        return videoGameRepository.saveAll(videoGames);
    }

    @PutMapping(value = "/editar/{id}")
    public ResponseEntity<VideoGame> editar(@RequestBody VideoGame videoGame, @PathVariable Long id) {
        VideoGame videoGameAux = videoGameRepository.findById(id).orElse(null);
        if (videoGameAux != null) {
            videoGameAux.setName(videoGame.getName());
            videoGameAux.setPlatform(videoGame.getPlatform());
            videoGameAux.setPublisher(videoGame.getPublisher());
            videoGameAux.setGenre(videoGame.getGenre());
            videoGameAux.setYear(videoGame.getYear());
            videoGameAux.setNaSales(videoGame.getNaSales());
            videoGameAux.setEuSales(videoGame.getEuSales());
            videoGameAux.setJpSales(videoGame.getJpSales());
            videoGameAux.setOtherSales(videoGame.getOtherSales());
            videoGameAux.setGlobalSales(videoGame.getGlobalSales());
            videoGameRepository.save(videoGameAux);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/eliminar/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        VideoGame videoGame = videoGameRepository.findById(id).orElse(null);
        if (videoGame != null) {
            videoGameRepository.delete(videoGame);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

