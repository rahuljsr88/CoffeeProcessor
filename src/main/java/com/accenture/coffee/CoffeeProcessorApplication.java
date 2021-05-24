package com.accenture.coffee;

import com.accenture.coffee.service.CoffeeProcessorDbService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * The main Springboot application class of the Coffee Processor is defined here
 *
 * @author rahuljsr88@gmail.com
 */
@SpringBootApplication
@EnableSwagger2
public class CoffeeProcessorApplication {
    public static void main(String[] args) {
        SpringApplication.run(CoffeeProcessorApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(CoffeeProcessorDbService coffeeProcessorDbService) {
        return args -> {
            coffeeProcessorDbService.loadData();
        };
    }
}
