package com.example.apipokemon.controller.converter;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.example.apipokemon.controller.dto.TrainerDto;
import com.example.apipokemon.controller.dto.PokemonDto;
import com.example.apipokemon.persistance.model.Trainer;
import com.example.apipokemon.persistance.model.Pokemon;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class TrainerConverter {

    final PokemonConverter pokemonConverter;

    public TrainerDto convertToDto(Trainer trainer) {

        TrainerDto trainerDto = new TrainerDto();

        trainerDto.setId(trainer.getId());
        trainerDto.setName(trainer.getName());
        trainerDto.setHometown(trainer.getHometown());

        if (trainer.getPokemons() != null) {

            Set<PokemonDto> pokemonsDto = new HashSet<>();

            for (Pokemon pokemon : trainer.getPokemons()) {
                pokemonsDto.add(pokemonConverter.convertToDto(pokemon));
            }

            trainerDto.setPokemons(pokemonsDto);
        }

        return trainerDto;
    }

    public Trainer convertToEntity(TrainerDto trainerDto) {

        Trainer trainer = new Trainer();

        trainer.setId(trainerDto.getId());
        trainer.setName(trainerDto.getName());
        trainer.setHometown(trainerDto.getHometown());

        return trainer;
    }

}
