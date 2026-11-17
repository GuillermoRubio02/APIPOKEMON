package com.example.apipokemon.controller.converter;

import org.springframework.stereotype.Component;

import com.example.apipokemon.controller.dto.PokemonDto;
import com.example.apipokemon.persistance.model.Pokemon;

@Component
public class PokemonConverter {

    public PokemonDto convertToDto(Pokemon pokemon) {

        PokemonDto pokemonDto = new PokemonDto();

        pokemonDto.setId(pokemon.getId());
        pokemonDto.setName(pokemon.getName());
        pokemonDto.setImagen_url(pokemon.getImagen_url());
        pokemonDto.setType(pokemon.getType());

        if (pokemon.getTrainer() != null) {
            pokemonDto.setTrainerId(pokemon.getTrainer().getId());
        }

        return pokemonDto;
    }

    public Pokemon convertToEntity(PokemonDto pokemonDto) {

        Pokemon pokemon = new Pokemon();

        pokemon.setName(pokemonDto.getName());
        pokemon.setImagen_url(pokemonDto.getImagen_url());
        pokemon.setType(pokemonDto.getType());

        return pokemon;
    }
}
