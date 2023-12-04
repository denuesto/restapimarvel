package com.demo.marvelapi.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CharactersMarvelResponse {
	
	private CharactersData data;

}
