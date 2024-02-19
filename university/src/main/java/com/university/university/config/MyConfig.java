package com.university.university.config;

import org.apache.catalina.filters.CorsFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class MyConfig implements WebMvcConfigurer{


//    @Bean
//    public WebMvcConfigurer corsMappingConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                WebConfigProperties.Cors cors = webConfigProperties.getCors();
//                registry.addMapping("/**")
//                        .allowedOrigins(cors.getAllowedOrigins())
//                        .allowedMethods(cors.getAllowedMethods())
//                        .maxAge(cors.getMaxAge())
//                        .allowedHeaders(cors.getAllowedHeaders())
//                        .exposedHeaders(cors.getExposedHeaders());
//            }
//        };
//    }
@Override
public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")
            .allowedOrigins("http://localhost:4000")
            .allowedMethods("GET","POST","PUT", "DELETE")
            .allowedHeaders("Access-Control-Allow-Origin", "Authentication")
            .allowCredentials(false).maxAge(3600);
}
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
