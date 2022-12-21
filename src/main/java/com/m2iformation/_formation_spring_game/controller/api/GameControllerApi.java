package com.m2iformation._formation_spring_game.controller.api;

import com.m2iformation._formation_spring_game.controller.models.GameDto;
import com.m2iformation._formation_spring_game.entity.Game;
import com.m2iformation._formation_spring_game.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class GameControllerApi {

    @Autowired
    private GameService gameService;

    @GetMapping("/games")
    public ResponseEntity<List<Game>> getAllGames(){
        List<Game> games = gameService.fetchAll();
        if(games.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok().body(games);
        }
    }


    @GetMapping("/games/{id}")
    public ResponseEntity<Game> getGameById(@PathVariable("id") long id){
        try {
            Game game = gameService.fetchById(id);
            return ResponseEntity.ok().body(game);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/games")
    public ResponseEntity<GameDto> createGame(@RequestBody GameDto gameDto){
        try{
            GameDto gameSaved = gameService.addGame(gameDto);
            return new ResponseEntity<>(gameSaved, HttpStatus.CREATED);
        }catch (Exception e){
            return ResponseEntity.internalServerError().body(null);
        }
    }

    @PutMapping("/games/{id}")
    public ResponseEntity<GameDto> updateGame(@PathVariable("id") long id, @RequestBody GameDto gameDto){
        try{
            Game game = gameService.fetchById(id);
            gameDto.setId(game.getId());
            GameDto gameUpdated = gameService.editGame(gameDto);
            return new ResponseEntity<>(gameUpdated, HttpStatus.OK);
        }catch (Exception e){
            return  ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/games/{id}")
    public ResponseEntity<HttpStatus> deleteGame(@PathVariable("id") long id) {
        try{
            gameService.deleteGame(id);
            return ResponseEntity.noContent().build();
        }catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }

}
