package com.example.apipokemon.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.apipokemon.controller.converter.TrainerConverter;
import com.example.apipokemon.controller.converter.PokemonConverter;
import com.example.apipokemon.controller.dto.TrainerDto;
import com.example.apipokemon.controller.dto.PokemonDto;
import com.example.apipokemon.persistance.model.Trainer;
import com.example.apipokemon.service.TrainerService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/trainers")
@AllArgsConstructor
public class TrainerController {

    TrainerService trainerService;

    TrainerConverter trainerConverter;

    PokemonConverter pokemonConverter;

    @GetMapping
    public ResponseEntity<List<TrainerDto>> getAllTrainers() {

        return ResponseEntity.ok(
            trainerService.getAllTrainers()
                .stream()
                .map(trainerConverter::convertToDto)
                .collect(Collectors.toList())
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrainerDto> getTrainer(@PathVariable Long id) {

        Trainer trainer = trainerService.getTrainer(id);

        if (trainer == null) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Entrenador no encontrado"
            );
        }

        return ResponseEntity.ok(
            trainerConverter.convertToDto(trainer)
        );
    }

    @GetMapping("/{id}/pokemons")
    public ResponseEntity<List<PokemonDto>> getPokemonsByTrainerId(
            @PathVariable Long id) {

        Trainer trainer = trainerService.getTrainer(id);

        if (trainer == null) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Entrenador no encontrado"
            );
        }

        return ResponseEntity.ok(
            trainerService.getPokemonsByTrainerId(id)
                .stream()
                .map(pokemonConverter::convertToDto)
                .collect(Collectors.toList())
        );
    }

}
