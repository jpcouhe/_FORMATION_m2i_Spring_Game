package com.m2iformation._formation_spring_game.repository;

import com.m2iformation._formation_spring_game.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {

}
