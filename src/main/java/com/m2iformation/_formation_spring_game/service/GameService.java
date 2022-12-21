package com.m2iformation._formation_spring_game.service;


import com.m2iformation._formation_spring_game.controller.models.GameDto;
import com.m2iformation._formation_spring_game.entity.Game;
import com.m2iformation._formation_spring_game.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<Game> fetchAll(){
        return gameRepository.findAll();
    }

    public Game fetchById(Long id) throws Exception {
        Optional<Game> game = gameRepository.findById(id);
        return game.orElseThrow(() -> new Exception());
    }

    public GameDto addGame(GameDto gameDto) {
        Game game = new Game();
        game.setName(gameDto.getName());
        game.setDescription(gameDto.getDescription());

        Game savedGame = gameRepository.save(game);

        GameDto gameResponse = new GameDto();
        gameResponse.setId(savedGame.getId());
        gameResponse.setName(savedGame.getName());
        gameResponse.setDescription(savedGame.getDescription());

        return gameResponse;

    }

    public GameDto editGame(GameDto gameDto){
        Game game = new Game();
        game.setName(gameDto.getName());
        game.setDescription(gameDto.getDescription());
        game.setId(gameDto.getId());
        Game gameEdit = gameRepository.save(game);


        GameDto gameResponse = new GameDto();
        gameResponse.setId(gameEdit.getId());
        gameResponse.setName(gameEdit.getName());
        gameResponse.setDescription(gameEdit.getDescription());


        return gameResponse;
    }



    public void deleteGame(Long id){
        gameRepository.deleteById(id);
    }
}
