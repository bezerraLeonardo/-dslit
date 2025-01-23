package com.leonardoBezerra.dslist.repositories;

import com.leonardoBezerra.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository <Game, Long> {

}
