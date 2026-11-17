package com.example.apipokemon.controller.dto;

import lombok.Data;

@Data
public class PokemonDto {

    Long id;

    String name;

    String imagen_url;

    String type;

    Long trainerId;

}
