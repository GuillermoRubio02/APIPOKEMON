package com.example.apipokemon.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apipokemon.persistance.model.Ability;

public interface AbilityRepository extends JpaRepository<Ability, Long> {

}
