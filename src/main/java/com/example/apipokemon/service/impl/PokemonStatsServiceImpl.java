package com.example.apipokemon.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import com.example.apipokemon.persistance.model.PokemonStats;
import com.example.apipokemon.persistance.repository.PokemonStatsRepository;
import com.example.apipokemon.service.PokemonStatsService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PokemonStatsServiceImpl implements PokemonStatsService {

    PokemonStatsRepository pokemonStatsRepository;

    @Override
    public PokemonStats getStatsByPokemonId(Long pokemonId) {
        return pokemonStatsRepository.findByPokemon_Id(pokemonId)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "No se encontraron estadísticas para el Pokémon " + pokemonId
            ));
    }

}
