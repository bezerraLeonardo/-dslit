package com.leonardoBezerra.dslist.repositories;

import com.leonardoBezerra.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository <GameList, Long> {

}
