package com.example.apipokemon.controller.dto;

import java.util.Set;

import lombok.Data;

@Data
public class TrainerDto {

    private Long id;
    private String name;
    private String hometown;
    private Set<PokemonDto> pokemons;

}
