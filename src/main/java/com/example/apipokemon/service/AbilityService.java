package com.example.apipokemon.service;

import java.util.List;

import com.example.apipokemon.persistance.model.Ability;
import com.example.apipokemon.persistance.model.Pokemon;

public interface AbilityService {

    List<Ability> getAllAbilities();

    List<Ability> getAbilitiesByPokemonId(Long pokemonId);

    List<Pokemon> getPokemonsByAbilityId(Long abilityId);

}
