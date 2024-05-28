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

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

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
        return "./vistas/index";
    }

    @GetMapping(value = "/formData")
    public String formData(Model model) {
        VideoGame videoGame = new VideoGame();
        model.addAttribute("videogame", videoGame);
        return "./vistas/formData";
    }
    @PostMapping(value = "/insert")
    public String insert(VideoGame videoGame) {
        videoGameRepository.save(videoGame);
        return "redirect:/dashboard";
    }

    @GetMapping(value = "/charts")
    public String charts() {
        return "./vistas/charts";
    }

    @GetMapping(value = "/table")
    public String table(Model model) {
        List<VideoGame> videoGames = videoGameRepository.findAll();
        model.addAttribute("videogames", videoGames);

        return "./vistas/tables";
    }

    @GetMapping(value = "/login")
    public String login() {
        return "./vistas/login";
    }

    @GetMapping(value = "/registrar")
    public String registrar(Model model) {
        UsuarioRegistarDto usuarioRegistarDto = new UsuarioRegistarDto();
        model.addAttribute("usuarioRegistarDto", usuarioRegistarDto);
        return "./vistas/register";
    }

    @PostMapping(value = "/registro-guardados")
    public String registroGuardados(UsuarioRegistarDto usuarioRegistarDto) {
            Usuario usuario = new Usuario(usuarioRegistarDto.getNombre(), usuarioRegistarDto.getApellido(), usuarioRegistarDto.getEmail(), passwordEncoder.encode(usuarioRegistarDto.getPassword()), Arrays.asList(new Rol("ROLE_USER")));
           usuarioRepository.save(usuario);

           return "redirect:/dashboard/login";
    }

}
