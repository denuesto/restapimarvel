package com.demo.backendmarvelapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.backendmarvelapi.dto.response.CharactersResults;
import com.demo.backendmarvelapi.entity.LogCharacters;
import com.demo.backendmarvelapi.service.ICharactersMarvelService;

@RestController
@RequestMapping("/backend/restapi")
@CrossOrigin("*")
public class CharactersMarvelController {
	
	@Autowired
	private ICharactersMarvelService iCharactersMarvelService;
	
	@GetMapping("/characters")
	public List<CharactersResults> findAll(){
		return iCharactersMarvelService.findAll();
	}
	
	@GetMapping("/characters/{id}")
	public CharactersResults findById(@PathVariable("id") String id){
		return iCharactersMarvelService.findById(id);
	}
	
	@GetMapping("/logcharacters")
	public List<LogCharacters> findAllLogCharacters(){
		return iCharactersMarvelService.findAllLogCharacters();
	}

}
