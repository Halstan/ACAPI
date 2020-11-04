package com.ac.ac.auth

import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.Ordered
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter

@Configuration
@EnableResourceServer
class ResourceServerConfig: ResourceServerConfigurerAdapter() {


    override fun configure(http: HttpSecurity?) {
        http!!.authorizeRequests().antMatchers(HttpMethod.GET, "/api/asesinos", "/api/asesinos/page/**", "/api/paises", "/api/armas").permitAll()
                .antMatchers(HttpMethod.GET, "/api/asesinos/{id}", "/api/paises/{id}", "/api/armas/{id}").hasAnyRole("USER", "ADMIN")
                .antMatchers(HttpMethod.POST, "/api/asesinos", "/api/paises", "/api/armas").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/asesinos", "/api/paises", "/api/armas/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/asesinos", "/api/paises", "/api/armas/{id}").hasRole("ADMIN")
                .antMatchers("/api/asesinos/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and().cors().configurationSource(corsConfigurationSource())
    }

    @Bean
    fun corsConfigurationSource(): CorsConfigurationSource{
        val config = CorsConfiguration()
        config.allowedOrigins = mutableListOf("http://localhost:4200")
        config.allowedMethods = mutableListOf("GET", "POST", "PUT", "DELETE", "OPTIONS")
        config.allowCredentials = true
        config.allowedHeaders = mutableListOf("Content-Type", "Authorization")

        val source = UrlBasedCorsConfigurationSource()
        source.registerCorsConfiguration("/**", config)

        return source
    }

    @Bean
    fun filterRegistrationBean(): FilterRegistrationBean<CorsFilter>{
        val bean = FilterRegistrationBean<CorsFilter>(CorsFilter(corsConfigurationSource()))
        bean.order = Ordered.HIGHEST_PRECEDENCE
        return bean
    }
}