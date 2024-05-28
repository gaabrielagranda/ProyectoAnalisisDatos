package com.app.videogame.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(authorize -> authorize
                        // Configuración de la autorización de las solicitudes
                        .requestMatchers("/dashboard/registrar/**", "/jss/**", "/css/**", "/assets/**", "/dashboard/registro-guardados","/video-game/home", "/video-game/juegos","video-game/add/{productId}","/video-game/ver").permitAll() // Permitir acceso a estas rutas sin autenticación
                        .anyRequest().authenticated() // Requerir autenticación para cualquier otra solicitud
                )
                .formLogin(form -> form
                        .loginPage("/dashboard/login")
                        .loginProcessingUrl("/login")
                        .defaultSuccessUrl("/dashboard/inicio", true) // si el usuario es verdadero redirigeme a esta pagina
                        .failureUrl("/dashboard/login?error")
                        .permitAll()
                )
                .logout(logout -> logout
                        // Configuración del cierre de sesión
                        .invalidateHttpSession(true) // Invalidar la sesión HTTP existente
                        .clearAuthentication(true) // Limpiar la autenticación existente
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout")) // Especificar la URL de cierre de sesión
                        .logoutSuccessUrl("/dashboard/login?logout") // Especificar la URL de redirección después del cierre de sesión
                        .permitAll() // Permitir acceso a la URL de cierre de sesión sin autenticación
                )
                .build(); // Finalizar la configuración y construir el SecurityFilterChain

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    AuthenticationProvider authenticationProvider(UserDetailsService userDetailsService) throws Exception {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());

        return daoAuthenticationProvider;
    }
}
