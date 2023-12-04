package com.demo.marvelapi.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demo.marvelapi.dto.response.CharactersData;
import com.demo.marvelapi.dto.response.CharactersMarvelResponse;
import com.demo.marvelapi.dto.response.CharactersResults;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/marvel")
@Slf4j
public class RestApiMarvelController {
	
	@Value("${api.url.marvel}")
	String apiUrl;
	
	@Value("${api.key.parameters}")
	String apikeyParameters;
	
	@GetMapping("/characters")
	public List<CharactersResults> findAll(){
		RestTemplate restTemplate = new RestTemplate();
		String apiUrlParameters =apiUrl+"?"+apikeyParameters;
		
		Object[] objects = new Object[] {restTemplate.getForObject(apiUrlParameters, Object.class)};
		
		ObjectMapper objectMapper = new ObjectMapper();
		List<CharactersResults> response = Arrays.stream(objects)
				.map(o -> objectMapper.convertValue(o, CharactersMarvelResponse.class))
				.map(CharactersMarvelResponse::getData)
				.map(CharactersData::getResults)
				.collect(Collectors.toList()).get(0);
		
		return response;
	}
	
	@GetMapping("/characters/{id}")
	public CharactersResults findyId(@PathVariable("id") String id){
		RestTemplate restTemplate = new RestTemplate();
		String apiUrlParameters =apiUrl+"/"+id +"?"+apikeyParameters;
		
		Object[] objects = new Object[] {restTemplate.getForObject(apiUrlParameters, Object.class)};
		ObjectMapper objectMapper = new ObjectMapper();
		CharactersResults response = Arrays.stream(objects)
				.map(o -> objectMapper.convertValue(o, CharactersMarvelResponse.class))
				.map(CharactersMarvelResponse::getData)
				.map(CharactersData::getResults)
				.collect(Collectors.toList()).get(0).get(0);
		
		return response;			
	}
}
