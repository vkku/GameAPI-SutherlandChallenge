package com.games.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.games.model.GameDTO;
import com.games.service.GamesService;

@RestController
public class GameController {
	
	@Autowired
	GamesService gamesService;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@GetMapping("/getGames")
	public ResponseEntity<String> fetchGames() throws JsonProcessingException{
		
		List<GameDTO> gameDtoList = gamesService.fetchGameList();
		String responseString = objectMapper.writeValueAsString(gameDtoList);
		ResponseEntity<String> response = ResponseEntity.ok().body(responseString);
		
		return response;
		
	}
	
	@GetMapping("/getGame")
	public ResponseEntity<String> fetchGameBasedOnId(@RequestParam("id") String id) throws JsonProcessingException{
		
		GameDTO gameDto = gamesService.fetchGameListBasedOnId(id);
		
		String responseString = objectMapper.writeValueAsString(gameDto);
		
		ResponseEntity<String> response = ResponseEntity.ok().body(responseString);
		
		return response;
		
	}
	
	@PostMapping("/insertGameDetails")
	public ResponseEntity<String> insertGameDetailsInTable(@RequestBody GameDTO gameDTO) throws JsonProcessingException{
		try {
			gamesService.insertGameDetails(gameDTO);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}

}
