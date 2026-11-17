package com.example.apipokemon.service;

import java.util.List;

import com.example.apipokemon.persistance.model.Trainer;
import com.example.apipokemon.persistance.model.Pokemon;

public interface TrainerService {

    List<Trainer> getAllTrainers();

    Trainer getTrainer(Long id);

    List<Pokemon> getPokemonsByTrainerId(Long id);

}
