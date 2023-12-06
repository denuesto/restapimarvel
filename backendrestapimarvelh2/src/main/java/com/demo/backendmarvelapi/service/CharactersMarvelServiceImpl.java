package com.demo.backendmarvelapi.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.backendmarvelapi.dto.response.CharactersResults;
import com.demo.backendmarvelapi.entity.LogCharacters;
import com.demo.backendmarvelapi.repository.LogCharactersRepository;

@Service
public class CharactersMarvelServiceImpl implements ICharactersMarvelService {
	
	@Autowired
	private LogCharactersRepository logCharactersRepository;
	String apiUrl = "http://localhost:8080/api/marvel/characters";

	@Override
	public CharactersResults findById(String id) {
		String apiUrlId=apiUrl+"/"+id;
		RestTemplate restTemplate = new RestTemplate();
		CharactersResults character = restTemplate.getForObject(apiUrlId, CharactersResults.class);
		
		LogCharacters logCharacters = new LogCharacters();
		logCharacters.setUrl(apiUrlId);
		logCharacters.setFecha(new java.util.Date());
		save(logCharacters);
		return character;
	}

	@Override
	public List<CharactersResults> findAll() {
		
		List<CharactersResults> characters = null;
		RestTemplate restTemplate = new RestTemplate();
		CharactersResults[] objects = restTemplate.getForObject(apiUrl, CharactersResults[].class);
		
		characters = Arrays.asList(objects);
		
		LogCharacters logCharacters = new LogCharacters();
		logCharacters.setUrl(apiUrl);
		logCharacters.setFecha(new java.util.Date());
		save(logCharacters);
		
		return characters;
	}

	@Override
	public LogCharacters save(LogCharacters logCharacters) {
		LogCharacters log = logCharactersRepository.save(logCharacters);
		return log;
	}

	@Override
	public List<LogCharacters> findAllLogCharacters() {
		
		return logCharactersRepository.findAll();
	}

}
