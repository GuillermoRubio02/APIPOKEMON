
package com.example.apipokemon.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apipokemon.controller.converter.PokemonConverter;
import com.example.apipokemon.controller.dto.PokemonDto;
import com.example.apipokemon.persistance.model.Pokemon;
import com.example.apipokemon.service.PokemonService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/pokemons")
@CrossOrigin
@AllArgsConstructor
public class PokemonController {

    PokemonService pokemonService;

    PokemonConverter converter;

    @GetMapping
    public ResponseEntity<List<PokemonDto>> getAllPokemons() {
        return ResponseEntity.ok(pokemonService.getAllPokemons().stream().map(converter::convertToDto).collect(Collectors.toList()));
    }

    @GetMapping("/")
    public ResponseEntity<List<PokemonDto>> getAllPokemons2() {
        List<PokemonDto> pokemonDtos = new ArrayList<>();
        for(Pokemon pokemon : pokemonService.getAllPokemons()) {
            PokemonDto pokemonDto = converter.convertToDto(pokemon);
            pokemonDtos.add(pokemonDto);
        }
        return ResponseEntity.ok(pokemonDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PokemonDto> getPokemonById(@PathVariable Long id) {

        Pokemon pokemon = pokemonService.getPokemonById(id);

        return ResponseEntity.status(HttpStatus.OK).body(converter.convertToDto(pokemon));

    }

    @PostMapping
    public ResponseEntity<PokemonDto> createPokemon(@RequestBody PokemonDto pokemonDto) {
        Pokemon pokemon = converter.convertToEntity(pokemonDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(converter.convertToDto(pokemonService.createPokemon(pokemon)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PokemonDto> updatePokemon(@PathVariable Long id, @RequestBody PokemonDto pokemonDto) {
        Pokemon pokemon = converter.convertToEntity(pokemonDto);
        return ResponseEntity.ok(converter.convertToDto(pokemonService.updatePokemon(id, pokemon)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePokemon(@PathVariable Long id) {
        pokemonService.deletePokemon(id);
        return ResponseEntity.noContent().build();
    }

}
