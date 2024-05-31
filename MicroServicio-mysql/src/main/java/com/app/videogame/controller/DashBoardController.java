package com.app.videogame.controller;

import com.app.videogame.models.entity.Usuario;
import com.app.videogame.models.entity.VideoGame;
import com.app.videogame.models.repository.UsuarioRepository;
import com.app.videogame.models.repository.VideoGameRepository;
import com.app.videogame.models.service.VideoGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.security.Principal;
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

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Maneja la solicitud para la página de inicio del panel de control
    @GetMapping(value = "/inicio")
    public String inicio(Model model, Principal principal) {

        try {
        // Recupera los videojuegos existentes
        List<VideoGame> videoGames = videoGameRepository.findAll();
        // Agrega los datos al modelo para mostrar en la vista
        model.addAttribute("videogames", videoGames);
        model.addAttribute("totalSales", videoGameService.findGlobalSales());
        model.addAttribute("promedioTotalSales", videoGameService.findAvgGlobalSales());
        model.addAttribute("countDocument", videoGameService.countVideoGame());
        model.addAttribute("genreVideoGame", videoGameService.findGenreBy());

            if (principal != null) {

                // principal contiene el nombre del usuario autenticado (en este caso el email)
                String email = principal.getName();

                // buscamos el usuario por el email
                Usuario usuario = usuarioRepository.findByEmail(email);

                // añadimos los atributos del usuario al modelo
                model.addAttribute("usuario", usuario);

            } else {
                // si no hay usuario autenticado, aun puedes pasar datos por defecto o un mensaje
                model.addAttribute("usuario", null);
            }

        } catch (Exception e) {
            return "/Errors/404";
        }

        // Devuelve la vista de inicio
        return "./vistas/index";
    }

    @GetMapping(value = "/editar/{id}")
    public String mostrarFormularioDeModificarPaciente(@PathVariable("id") Long id, Model model){

         VideoGame videoGame =
                videoGameRepository.findById(id).orElse(null);
        model.addAttribute("videogame", videoGame);
        return "./vistas/formData";
    }

    // Maneja la solicitud para la página de formulario de datos
    @GetMapping(value = "/formData")
    public String formData(Model model) {

        try {
        // Crea un nuevo videojuego y lo agrega al modelo
        VideoGame videoGame = new VideoGame();
        model.addAttribute("videogame", videoGame);

        } catch (Exception e) {
            return "/Errors/404";
        }


        return "./vistas/formData";
    }

    // Maneja la solicitud para insertar un nuevo videojuego
    @PostMapping(value = "/insert")
    public String insert(VideoGame videoGame) {

        try {

        // Guarda el videojuego en el repositorio
        videoGameRepository.save(videoGame);

        } catch (Exception e) {
            return "/Errors/500";
        }

        // Redirige a la página principal del panel de control
        return "redirect:/dashboard/inicio";
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
