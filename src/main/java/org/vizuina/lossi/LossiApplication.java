package org.vizuina.lossi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.vizuina.lossi.model.Person;

import java.io.Serializable;

@SpringBootApplication
@Slf4j
public class LossiApplication {

    public static void main(String[] args) {
        SpringApplication.run(LossiApplication.class, args);
    }


    @Bean
    ApplicationRunner init(PersonRepository personRepository) {
        return applicationArguments -> {
            Serializable caca = personRepository.save(Person.builder().name("caca").build());
            log.info("Saved caca {}", caca);
        };
    }

}
