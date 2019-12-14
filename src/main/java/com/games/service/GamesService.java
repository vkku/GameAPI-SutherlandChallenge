package com.games.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.games.model.GameDTO;
import com.games.repository.GameInsertRepository;
import com.games.repository.GameRepository;


@Service
public class GamesService {

	@Autowired
	GameRepository gameRepository;
	
	@Autowired
	GameInsertRepository insertRepository;

	
	public List<GameDTO> fetchGameList(){
		
		return (List<GameDTO>) gameRepository.findAll();
		
	}
	
	public GameDTO fetchGameListBasedOnId(String id){

		GameDTO gameDto = new GameDTO();
		gameDto = gameRepository.findById(id).get();
		return gameDto;
		
	}
	
	public void insertGameDetails(GameDTO gameDTO){

		try {
			insertRepository.insertGameData(gameDTO);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
}
