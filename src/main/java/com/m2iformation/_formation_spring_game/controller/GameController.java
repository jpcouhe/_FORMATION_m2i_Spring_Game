package com.m2iformation._formation_spring_game.controller;

import com.m2iformation._formation_spring_game.controller.models.GameDto;
import com.m2iformation._formation_spring_game.entity.Game;
import com.m2iformation._formation_spring_game.service.GameService;
import com.oracle.wls.shaded.org.apache.xpath.operations.Mod;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class GameController {

    @Autowired
    GameService gameService;


    @GetMapping("/games")
    public String displayAllGames(Model model){
        List<Game> games = gameService.fetchAll();
        model.addAttribute("games", games);
        return "games";
    }

    @GetMapping("/games/details/{id}")
    public String displayOneGame(Model model, @PathVariable(required = false, name="id") String id){
        try{
                Game game = gameService.fetchById(Long.valueOf(id));
                model.addAttribute("game", game);
                return "detail-game";
        }catch (Exception e){
                return "error";
        }
    }


    @GetMapping("/games/add")
    public String createGame(){
        return  "add-game";
    }


    @PostMapping("/games/add")
    public String createGame(HttpServletRequest req){
        String name = req.getParameter("gameName");
        String description = req.getParameter("gameDescription");
        GameDto game = new GameDto(name, description);

        gameService.addGame(game);

        return  "redirect:/games";
    }


    @GetMapping("/games/edit")
    public String editGame(Model model, @RequestParam String id){
        try{
            Game game = gameService.fetchById(Long.valueOf(id));
            model.addAttribute("game", game);
                    return "edit-game";

        }catch (Exception e){
                return "error";
        }
    }

    @PostMapping("/games/edit")
    public String updateGame(Model model, HttpServletRequest req, @RequestParam String id){
        String name = req.getParameter("gameName");
        String description = req.getParameter("gameDescription");
        try{
            Game gameToUpdate = gameService.fetchById(Long.valueOf(id));

            GameDto gameToUpdateDto = new GameDto(gameToUpdate.getId(),gameToUpdate.getName(), gameToUpdate.getDescription());
            gameToUpdateDto.setDescription(description);
            gameToUpdateDto.setName(name);

            gameService.editGame(gameToUpdateDto);
            return "redirect:/games";
        }catch (Exception e){
            return "error";
        }



    }
    @PostMapping("/deleteGame")
    public String deleteGame(Model model, HttpServletRequest req){
        String id = req.getParameter("idGame");

        gameService.deleteGame(Long.valueOf(id));

        return "redirect:/games";
    }

}
