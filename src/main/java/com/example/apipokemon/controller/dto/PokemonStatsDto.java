package com.example.apipokemon.controller.dto;

import lombok.Data;

@Data
public class PokemonStatsDto {

    private Long id;
    private Integer hp;
    private Integer attack;
    private Integer defense;
    private Integer speed;
    private Double height;
    private Double weight;
    private Long pokemonId;

}
