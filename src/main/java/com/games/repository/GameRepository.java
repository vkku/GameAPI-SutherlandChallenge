package com.games.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.repository.CrudRepository;

import com.games.model.GameDTO;

public interface GameRepository extends CrudRepository<GameDTO, String> {
	
}
