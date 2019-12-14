package com.games.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.games.model.GameDTO;

@Repository
public class GameInsertRepository {

	@PersistenceContext
    private EntityManager entityManager;
	
	@Transactional
	public void insertGameData(GameDTO gameDTO) {
		
		this.entityManager.persist(gameDTO);
		
	}
	
}
