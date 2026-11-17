package com.example.apipokemon.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apipokemon.persistance.model.PokemonStats;

import java.util.Optional;

public interface PokemonStatsRepository extends JpaRepository<PokemonStats, Long> {

    Optional<PokemonStats> findByPokemon_Id(Long pokemonId);

}
