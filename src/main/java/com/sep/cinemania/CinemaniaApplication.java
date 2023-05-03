package com.sep.cinemania;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Cinemania Api's"))
public class CinemaniaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CinemaniaApplication.class, args);
    }

}
