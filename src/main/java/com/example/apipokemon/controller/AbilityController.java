package com.example.apipokemon.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apipokemon.controller.converter.AbilityConverter;
import com.example.apipokemon.controller.converter.PokemonConverter;
import com.example.apipokemon.controller.dto.AbilityDto;
import com.example.apipokemon.controller.dto.PokemonDto;
import com.example.apipokemon.service.AbilityService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/abilities")
@AllArgsConstructor
public class AbilityController {

    AbilityService abilityService;

    AbilityConverter abilityConverter;

    PokemonConverter pokemonConverter;

    @GetMapping
    public ResponseEntity<List<AbilityDto>> getAllAbilities() {

        return ResponseEntity.ok(
            abilityService.getAllAbilities()
                .stream()
                .map(abilityConverter::convertToDto)
                .collect(Collectors.toList())
        );
    }

    @GetMapping("/{id}/pokemons")
    public ResponseEntity<List<PokemonDto>> getPokemonsByAbilityId(
            @PathVariable Long id) {

        return ResponseEntity.ok(
            abilityService.getPokemonsByAbilityId(id)
                .stream()
                .map(pokemonConverter::convertToDto)
                .collect(Collectors.toList())
        );
    }

}
