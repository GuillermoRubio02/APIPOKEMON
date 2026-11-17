package com.example.apipokemon.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.apipokemon.persistance.model.Trainer;
import com.example.apipokemon.persistance.repository.TrainerRepository;
import com.example.apipokemon.service.TrainerService;
import com.example.apipokemon.persistance.model.Pokemon;
import com.example.apipokemon.persistance.repository.PokemonRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TrainerServiceImpl implements TrainerService {

    TrainerRepository trainerRepository;

    PokemonRepository pokemonRepository;

    @Override
    public List<Trainer> getAllTrainers() {
        return trainerRepository.findAll();
    }

    @Override
    public Trainer getTrainer(Long id) {
        return trainerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Pokemon> getPokemonsByTrainerId(Long id) {
        return pokemonRepository.findByTrainer_Id(id);
    }

}
