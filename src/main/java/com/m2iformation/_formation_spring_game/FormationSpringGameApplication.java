package com.m2iformation._formation_spring_game;

import com.m2iformation._formation_spring_game.entity.Game;
import com.m2iformation._formation_spring_game.repository.GameRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FormationSpringGameApplication {

    public static void main(String[] args) {
        SpringApplication.run(FormationSpringGameApplication.class, args);
    }



    @Bean
    CommandLineRunner commandLineRunner(GameRepository gameRepository) {
        return args -> {



            Game game1 = new Game("Diablo", "Hack And Slash");
            Game game2 = new Game("Mario", "Jeux de Plateforme");

            gameRepository.save(game1);
            gameRepository.save(game2);

        };

    }
}
