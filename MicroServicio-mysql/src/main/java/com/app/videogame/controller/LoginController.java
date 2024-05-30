package com.app.videogame.controller;

import com.app.videogame.models.dto.UsuarioRegistarDto;
import com.app.videogame.models.entity.Rol;
import com.app.videogame.models.entity.Usuario;
import com.app.videogame.models.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
@Controller
@RequestMapping(value = "/security")
public class LoginController {

    // Repositorio para manejar operaciones relacionadas con usuarios
    @Autowired
    private UsuarioRepository usuarioRepository;

    // Codificador de contraseñas para cifrar contraseñas de usuario
    @Autowired
    private PasswordEncoder passwordEncoder;


    // Maneja la solicitud para la página de inicio de sesión
    @GetMapping(value = "/login")
    public String login() {
        // Devuelve la vista de inicio de sesión
        return "./vistas/login";
    }

    // Maneja la solicitud para la página de registro de usuarios
    @GetMapping(value = "/registrar")
    public String registrar(Model model) {
        // Crea un nuevo DTO para el registro de usuarios y lo agrega al modelo
        UsuarioRegistarDto usuarioRegistarDto = new UsuarioRegistarDto();
        model.addAttribute("usuarioRegistarDto", usuarioRegistarDto);

        // Devuelve la vista de registro de usuarios
        return "./vistas/register";
    }

    // Maneja la solicitud para guardar un nuevo usuario registrado
    @PostMapping(value = "/registro-guardados")
    public String registroGuardados(UsuarioRegistarDto usuarioRegistarDto) {
        // Crea un nuevo usuario con la información proporcionada
        Usuario usuario = new Usuario(usuarioRegistarDto.getNombre(), usuarioRegistarDto.getApellido(), usuarioRegistarDto.getEmail(), passwordEncoder.encode(usuarioRegistarDto.getPassword()), Arrays.asList(new Rol("ROLE_ADMIN")));

        // Guarda el usuario en el repositorio de usuarios
        usuarioRepository.save(usuario);

        // Redirige a la página de inicio de sesión del panel de control
        return "redirect:/security/login";
    }
}
