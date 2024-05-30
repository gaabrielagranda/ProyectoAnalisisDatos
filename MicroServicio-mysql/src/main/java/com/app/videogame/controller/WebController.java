package com.app.videogame.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
@RequestMapping(value = "/web-games")
public class WebController {

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
    public String profile() {
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
            if (authorities.contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
                return "redirect:/dashboard/inicio";
            } else if (authorities.contains(new SimpleGrantedAuthority("ROLE_USER"))) {
                return "redirect:/web-games/home";
            }
        }
        // Si el usuario no tiene un rol válido, redirigir a una página de acceso denegado o de error.
        return "redirect:/dashboard/login";
    }

}
