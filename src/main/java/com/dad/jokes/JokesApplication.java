package com.dad.jokes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableWebMvc
@EnableJpaAuditing
@EnableSwagger2
public class JokesApplication {

    public static void main(String[] args)
    {
        SpringApplication.run(JokesApplication.class, args);
    }

}
