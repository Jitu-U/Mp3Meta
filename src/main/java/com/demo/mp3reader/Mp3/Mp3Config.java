package com.demo.mp3reader.Mp3;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.List;
import java.util.UUID;

@Configuration
public class Mp3Config {

    @Bean
    CommandLineRunner commandLineRunner(Mp3Repository repository){
        return args -> {
            Mp3 sampleMp3 = new Mp3();
            sampleMp3.setId(UUID.randomUUID());
            repository.saveAll(
                    List.of(sampleMp3)
            );
        };
    }
}
