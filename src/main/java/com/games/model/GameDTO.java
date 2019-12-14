package com.games.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class GameDTO {

	@Id
	@JsonProperty("title")
	private String title;

	@JsonProperty("platform")
	private String platform;

	@JsonProperty("score")
	private Double score;

	@JsonProperty("genre")
	private String genre;

	@JsonProperty("editors_choice")
	private String editors_choice;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getEditors_choice() {
		return editors_choice;
	}

	public void setEditors_choice(String editors_choice) {
		this.editors_choice = editors_choice;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}
	
}
