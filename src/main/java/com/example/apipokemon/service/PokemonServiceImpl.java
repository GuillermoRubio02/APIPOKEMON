package com.example.apipokemon.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.apipokemon.persistance.model.Pokemon;
import com.example.apipokemon.persistance.repository.PokemonRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PokemonServiceImpl implements PokemonService {

    PokemonRepository pokemonRepository;

    @Override
    public List<Pokemon> getAllPokemons() {
        return pokemonRepository.findAll();
    }

    @Override
    public Pokemon getPokemonById(Long id) {
        return pokemonRepository.findById(id).orElse(null);
    }

    @Override
    public Pokemon createPokemon(Pokemon pokemon) {
        return pokemonRepository.save(pokemon);
    }

    @Override
    public Pokemon updatePokemon(Long id, Pokemon pokemon) {
        Pokemon existingPokemon = pokemonRepository.findById(id).orElse(null);
        if (existingPokemon == null) {
            return null;
        }
        existingPokemon.setName(pokemon.getName());
        existingPokemon.setImagen_url(pokemon.getImagen_url());
        existingPokemon.setType(pokemon.getType());
        return pokemonRepository.save(existingPokemon);
    }

    @Override
    public void deletePokemon(Long id) {
        Pokemon existingPokemon = pokemonRepository.findById(id).orElse(null);
        pokemonRepository.delete(existingPokemon);
    }

}
