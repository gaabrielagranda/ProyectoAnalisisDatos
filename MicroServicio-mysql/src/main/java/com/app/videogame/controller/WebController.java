package com.app.videogame.controller;

import com.app.videogame.models.entity.Usuario;
import com.app.videogame.models.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.Collection;

@Controller
@RequestMapping(value = "/web-games")
public class WebController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping(value = "/home")
    public String home() {
        return "/web/index";
    }

    @GetMapping(value = "/browse")
    public String browse() {
        return "/web/browse";
    }
    @GetMapping(value = "/details")
    public String details() {
        return "/web/details";
    }

    @GetMapping(value = "/profile")
    public String profile(Model model, Principal principal) {

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



        return "/web/profile";
    }

    @GetMapping(value = "/streams")
    public String streams() {
        return "/web/streams";
    }

    @GetMapping("/redirectByRole")
    public String redirectByRole(Authentication authentication) {
        if (authentication != null) {
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            if (authorities.contains(new SimpleGrantedAuthority("ROLE_ADMIN")) || authorities.contains(new SimpleGrantedAuthority("ROLE_USER"))) {
                return "redirect:/web-games/home";
            } else if (authorities.contains(new SimpleGrantedAuthority("ROLE_INVITE"))) {
                return "redirect:/web-games/profile";
            }
        }
        // Si el usuario no tiene un rol válido, redirigir a una página de acceso denegado o de error.
        return "redirect:/dashboard/login";
    }

}
