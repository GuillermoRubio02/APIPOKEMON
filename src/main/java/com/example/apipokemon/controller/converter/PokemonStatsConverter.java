package com.example.apipokemon.controller.converter;

import org.springframework.stereotype.Component;

import com.example.apipokemon.controller.dto.PokemonStatsDto;
import com.example.apipokemon.persistance.model.PokemonStats;

@Component
public class PokemonStatsConverter {

    public PokemonStatsDto convertToDto(PokemonStats stats) {

        PokemonStatsDto statsDto = new PokemonStatsDto();

        statsDto.setId(stats.getId());
        statsDto.setHp(stats.getHp());
        statsDto.setAttack(stats.getAttack());
        statsDto.setDefense(stats.getDefense());
        statsDto.setSpeed(stats.getSpeed());
        statsDto.setHeight(stats.getHeight());
        statsDto.setWeight(stats.getWeight());

        if (stats.getPokemon() != null) {
            statsDto.setPokemonId(stats.getPokemon().getId());
        }

        return statsDto;
    }

    public PokemonStats convertToEntity(PokemonStatsDto statsDto) {

        PokemonStats stats = new PokemonStats();

        stats.setId(statsDto.getId());
        stats.setHp(statsDto.getHp());
        stats.setAttack(statsDto.getAttack());
        stats.setDefense(statsDto.getDefense());
        stats.setSpeed(statsDto.getSpeed());
        stats.setHeight(statsDto.getHeight());
        stats.setWeight(statsDto.getWeight());

        return stats;
    }
}
