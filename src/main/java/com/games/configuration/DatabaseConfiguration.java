package com.games.configuration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.games.model.GameDTO;
import com.games.repository.GameRepository;
import com.games.util.Utils;

@Profile("default")
@Configuration
public class DatabaseConfiguration {
	
	@Autowired
	GameRepository gameRepository;
	
	@PostConstruct
	private void loadCsvData() {
		try {
			Resource resource = new ClassPathResource("gamesc2b2088.csv");
			InputStream input = resource.getInputStream();

			
			/*
			 * String result = new BufferedReader(new InputStreamReader(input))
			 * .lines().collect(Collectors.joining("\n"));
			 */
			 
			
			gameRepository.saveAll(Utils.read(GameDTO.class, input));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
