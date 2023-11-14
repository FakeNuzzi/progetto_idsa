package idsa.progetto_idsa.config;

import idsa.progetto_idsa.entity.Role;
import idsa.progetto_idsa.entity.User;
import jakarta.servlet.Filter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SpringSecurityConfig {
    private final JwtAuthentationFilter jwtAuthentationFilter;
    private final AuthenticationProvider authenticationProvider;
    private final PasswordEncoder passwordEncoder;

    //ok
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((authz) -> authz
                    .requestMatchers("/")
                    .permitAll()
                    .anyRequest()
                    .authenticated()
                )
                .sessionManagement((session) -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthentationFilter, UsernamePasswordAuthenticationFilter.class)
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    //ok
    //utenti di default per test
    @Bean
    public UserDetailsService userDetailsService(){

        UserDetails user = User.builder()
                .nome("user")
                .cognome("user")
                .email("user")
                .password(passwordEncoder.encode("user"))
                .cf("user")
                .role(Role.USER)
                .build();

        UserDetails admin = User.builder()
                .nome("admin")
                .cognome("admin")
                .email("admin")
                .password(passwordEncoder.encode("admin"))
                .cf("admin")
                .role(Role.ADMIN)
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }
}
