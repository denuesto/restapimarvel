package com.demo.backendmarvelapi.service;

import java.util.List;

import com.demo.backendmarvelapi.dto.response.CharactersResults;
import com.demo.backendmarvelapi.entity.LogCharacters;

public interface ICharactersMarvelService {
	
	CharactersResults findById(String id);
	
	List<CharactersResults> findAll();
	
	LogCharacters save(LogCharacters logCharacters);
	
	List<LogCharacters> findAllLogCharacters();

}
