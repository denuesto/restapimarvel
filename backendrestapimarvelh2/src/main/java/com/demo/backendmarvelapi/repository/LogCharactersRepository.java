package com.demo.backendmarvelapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.backendmarvelapi.entity.LogCharacters;

@Repository
public interface LogCharactersRepository extends JpaRepository<LogCharacters, Long> {

}
