package com.m2iformation._formation_spring_game.repository;

import com.m2iformation._formation_spring_game.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    boolean existsByUsername(String username);

    Optional<User> findUserByUsername(String usernmame);

}
