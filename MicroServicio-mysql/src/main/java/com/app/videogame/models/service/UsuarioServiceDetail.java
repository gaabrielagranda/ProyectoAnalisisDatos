package com.app.videogame.models.service;

import com.app.videogame.models.entity.Rol;
import com.app.videogame.models.entity.Usuario;
import com.app.videogame.models.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Servicio para cargar detalles del usuario para la autenticación.
 */
@Service
public class UsuarioServiceDetail implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    /**
     * Obtiene las autoridades del usuario.
     *
     * @param roles La colección de roles del usuario.
     * @return La colección de autoridades del usuario.
     */
    private Collection<? extends GrantedAuthority> authorities(Collection<Rol> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getNombre()))
                .collect(Collectors.toList());
    }

    /**
     * Carga el usuario por su nombre de usuario (correo electrónico) para la autenticación.
     *
     * @param username El nombre de usuario (correo electrónico) del usuario.
     * @return Los detalles del usuario para la autenticación.
     * @throws UsernameNotFoundException Si el usuario no es encontrado.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(username);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        return new User(usuario.getEmail(), usuario.getPassword(), authorities(usuario.getRoles()));
    }
}
