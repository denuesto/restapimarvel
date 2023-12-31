package com.demo.marvelapi.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CharactersResults {

	private String id;
	private String name;
	private String description;
	
	private CharactersThumbnail thumbnail;
}
