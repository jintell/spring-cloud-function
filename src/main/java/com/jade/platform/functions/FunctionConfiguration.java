package com.jade.platform.functions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;

import java.util.function.Function;

@SpringBootApplication
public class FunctionConfiguration {

    @Bean
    public Function<String, String> reverse() {
        return s ->  new StringBuilder(s).reverse().toString();
    }

    @Bean
    public Function<Flux<String>, Flux<String>> uppercase() {
        return s -> s.map(String::toUpperCase);
    }

    /*
     * You need this main method (empty) or explicit <start-class>example.FunctionConfiguration</start-class>
     * in the POM to ensure boot plug-in makes the correct entry
     */
    public static void main(String[] args) {
        SpringApplication.run(FunctionConfiguration.class, args);
    }

}
