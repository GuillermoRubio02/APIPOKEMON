package com.example.apipokemon.persistance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apipokemon.persistance.model.Pokemon;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

    List<Pokemon> findByTrainer_Id(Long trainerId);

}
