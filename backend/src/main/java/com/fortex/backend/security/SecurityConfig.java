package com.fortex.backend.security;

import java.util.Arrays;

import com.fortex.backend.user.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;
    private final UserServiceImpl userDetailsService;

    @Autowired
    public SecurityConfig(UserServiceImpl userService) {
        this.userDetailsService = userService;
    }
    @Bean
CorsConfigurationSource corsConfigurationSource()
{
    CorsConfiguration configuration = new CorsConfiguration();
    configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
    configuration.setAllowedMethods(Arrays.asList("GET","POST"));
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", configuration);
    return source;
}
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().authorizeRequests()
        .antMatchers("/index.html", "/", "/home", "/login").permitAll()
        .antMatchers("/api/user/delete/**")
        .hasAuthority("ADMIN")
        .anyRequest()
        .authenticated()
        .and()
        .formLogin()
        .permitAll();
    }
//     @Bean
// public FilterRegistrationBean corsFilter() {
//     UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//     CorsConfiguration config = new CorsConfiguration();
//     config.setAllowCredentials(true);
//     config.addAllowedOrigin("*");
//     config.addAllowedHeader("*");
//     config.addAllowedMethod("*");
//     source.registerCorsConfiguration("/**", config);
//     FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
//     bean.setOrder(0); 
//     return bean;
// }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);

    }
}