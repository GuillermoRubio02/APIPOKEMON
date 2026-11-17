package com.example.apipokemon.service.impl;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.example.apipokemon.persistance.model.Ability;
import com.example.apipokemon.persistance.model.Pokemon;
import com.example.apipokemon.persistance.repository.AbilityRepository;
import com.example.apipokemon.persistance.repository.PokemonRepository;
import com.example.apipokemon.service.AbilityService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AbilityServiceImpl implements AbilityService {

    AbilityRepository abilityRepository;
    PokemonRepository pokemonRepository;

    @Override
    public List<Ability> getAllAbilities() {
        return abilityRepository.findAll();
    }

    @Override
    public List<Ability> getAbilitiesByPokemonId(Long pokemonId) {

        Pokemon pokemon = pokemonRepository.findById(pokemonId)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Pokémon " + pokemonId + " no encontrado"
            ));

        return new ArrayList<>(pokemon.getAbilities());
    }

    @Override
    public List<Pokemon> getPokemonsByAbilityId(Long abilityId) {

        Ability ability = abilityRepository.findById(abilityId)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Habilidad " + abilityId + " no encontrada"
            ));

        return new ArrayList<>(ability.getPokemons());
    }

}
