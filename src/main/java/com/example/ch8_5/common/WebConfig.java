package com.example.ch8_5.common;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Value("${spring.servlet.multipart.location}")
    private String filepath;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
<<<<<<< HEAD
                .allowedOrigins("*");
=======
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // 허용 HTTP 메서드
                .allowedHeaders("*") // 모든 헤더 허용
                .maxAge(3600); // Preflight 요청 캐시 시간 (초);
>>>>>>> e24795dcb9434d887e33d17e3d09c64fda7d7988

    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // addResourceLocations 등록 시 어떤 방식으로 접근하는지 (file or classpath) 설정
        registry.addResourceHandler("/uploads/**").addResourceLocations("file:" + filepath);
    }


}
