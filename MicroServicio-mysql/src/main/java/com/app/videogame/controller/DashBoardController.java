package com.app.videogame.controller;

import com.app.videogame.models.dto.UsuarioRegistarDto;
import com.app.videogame.models.entity.Rol;
import com.app.videogame.models.entity.Usuario;
import com.app.videogame.models.entity.VideoGame;
import com.app.videogame.models.repository.UsuarioRepository;
import com.app.videogame.models.repository.VideoGameRepository;
import com.app.videogame.models.service.VideoGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/dashboard")
public class DashBoardController {


    // Repositorio para manejar operaciones relacionadas con videojuegos
    @Autowired
    private VideoGameRepository videoGameRepository;

    // Servicio para proporcionar operaciones relacionadas con videojuegos
    @Autowired
    private VideoGameService videoGameService;

    // Maneja la solicitud para la página de inicio del panel de control
    @GetMapping(value = "/inicio")
    public String inicio(Model model) {
        // Recupera los videojuegos existentes
        List<VideoGame> videoGames = videoGameRepository.findAll();

        // Agrega los datos al modelo para mostrar en la vista
        model.addAttribute("videogames", videoGames);
        model.addAttribute("totalSales", videoGameService.findGlobalSales());
        model.addAttribute("promedioTotalSales", videoGameService.findAvgGlobalSales());
        model.addAttribute("countDocument", videoGameService.countVideoGame());
        model.addAttribute("genreVideoGame", videoGameService.findGenreBy());

        // Devuelve la vista de inicio
        return "./vistas/index";
    }

    // Maneja la solicitud para la página de formulario de datos
    @GetMapping(value = "/formData")
    public String formData(Model model) {
        // Crea un nuevo videojuego y lo agrega al modelo
        VideoGame videoGame = new VideoGame();
        model.addAttribute("videogame", videoGame);

        // Devuelve la vista del formulario de datos
        return "./vistas/formData";
    }

    // Maneja la solicitud para insertar un nuevo videojuego
    @PostMapping(value = "/insert")
    public String insert(VideoGame videoGame) {
        // Guarda el videojuego en el repositorio
        videoGameRepository.save(videoGame);

        // Redirige a la página principal del panel de control
        return "redirect:/dashboard";
    }

    // Maneja la solicitud para la página de gráficos
    @GetMapping(value = "/charts")
    public String charts() {
        // Devuelve la vista de gráficos
        return "./vistas/charts";
    }

    // Maneja la solicitud para la página de tabla de videojuegos
    @GetMapping(value = "/table")
    public String table(Model model) {
        // Recupera todos los videojuegos existentes
        List<VideoGame> videoGames = videoGameRepository.findAll();

        // Agrega los videojuegos al modelo para mostrar en la vista
        model.addAttribute("videogames", videoGames);

        // Devuelve la vista de tabla de videojuegos
        return "./vistas/tables";
    }
}
