package com.app.videogame.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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

    // Configuración de la cadena de filtros de seguridad
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(authorize -> authorize
                // Configuración de la autorización de las solicitudes
                .requestMatchers("/security/registrar/**", "/js/**", "/css/**", "/assets/**","/designWeb/**", "/security/registro-guardados", "/web-games/home", "/web-games/browse", "/web-games/details","web-games/profile", "/web-games/streams").permitAll() // Permitir acceso a estas rutas sin autenticación
                .anyRequest().authenticated() // Requerir autenticación para cualquier otra solicitud
                )
                .formLogin(form -> form
                        .loginPage("/security/login") // Página de inicio de sesión personalizada
                        .loginProcessingUrl("/login") // URL de procesamiento de inicio de sesión
                        .defaultSuccessUrl("/web-games/redirectByRole", true) // Redirección después de un inicio de sesión exitoso
                        .failureUrl("/security/login?error") // Redirección después de un inicio de sesión fallido
                        .permitAll() // Permitir acceso a la página de inicio de sesión sin autenticación
                )
                .logout(logout -> logout
                        // Configuración del cierre de sesión
                        .invalidateHttpSession(true) // Invalidar la sesión HTTP existente
                        .clearAuthentication(true) // Limpiar la autenticación existente
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout")) // URL de cierre de sesión
                        .logoutSuccessUrl("/web-games/home?logout") // Redirección después del cierre de sesión
                        .permitAll() // Permitir acceso a la URL de cierre de sesión sin autenticación
                )
                .build(); // Finalizar la configuración y construir el SecurityFilterChain
    }

    // Codificador de contraseñas para cifrar las contraseñas de usuario
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Configuración del administrador de autenticación
    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    // Proveedor de autenticación que utiliza el servicio de detalles de usuario y el codificador de contraseñas
    @Bean
    AuthenticationProvider authenticationProvider(UserDetailsService userDetailsService)  {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());

        return daoAuthenticationProvider;
    }
}
