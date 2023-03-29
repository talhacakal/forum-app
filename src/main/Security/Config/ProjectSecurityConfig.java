package main.Security.Config;

import main.Security.Filter.JWTTokenValidatorFilter;
import main.Security.Filter.JWTTokenGeneratorFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;


@Configuration
@EnableWebSecurity
public class ProjectSecurityConfig {

    @Autowired
    private JWTTokenValidatorFilter jwtTokenValidatorFilter;

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception{
        http
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .csrf().disable()
                .addFilterAfter(new JWTTokenGeneratorFilter(), BasicAuthenticationFilter.class)
                .addFilterAfter(jwtTokenValidatorFilter, BasicAuthenticationFilter.class)
                .authorizeHttpRequests()
                .requestMatchers(GET,"/api/entry/**","/api/comment/**","/api/profile/**").permitAll()
                .requestMatchers("/api/profile/auth/**","/api/entry/auth/**","/api/comment/auth/**").hasAnyRole("USER")
                .requestMatchers("/api/dev/**").hasRole("DEV")
                .requestMatchers("/register","/login").permitAll()
                .and().httpBasic();
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
