package com.spring.datat.rest;

import com.spring.datat.rest.utils.DataPreloader;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Created by Pavel on 2017-07-07.
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }
    @Bean
    CommandLineRunner init (DataPreloader loader){
        return (args) -> loader.createLibraries(50);
    }
}
