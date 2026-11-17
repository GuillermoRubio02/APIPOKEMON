package com.example.apipokemon.service;

import com.example.apipokemon.persistance.model.PokemonStats;

public interface PokemonStatsService {

    PokemonStats getStatsByPokemonId(Long pokemonId);

}
