package com.leonardoBezerra.dslist.Services;


import com.leonardoBezerra.dslist.dto.GameListDTO;

import com.leonardoBezerra.dslist.entities.GameList;
import com.leonardoBezerra.dslist.projections.GameMinProjection;
import com.leonardoBezerra.dslist.repositories.GameListRepository;
import com.leonardoBezerra.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(GameListDTO::new).toList();

    }
    @Transactional
    public void  move(Long listId, int sourceIndex, int destinationIndex) {

        List<GameMinProjection> list = gameRepository.searchByList(listId);

        GameMinProjection o =  list.remove(sourceIndex);
        list.add(destinationIndex, o);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex > destinationIndex ? destinationIndex : sourceIndex;

        for (int i = min; i<= max; i++) {
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(),i);
        }
    }

    @Transactional(readOnly = true)
    public GameListDTO findById(Long id) {
        GameList entity = gameListRepository.findById(id).get();
        return new GameListDTO(entity);
    }

}
